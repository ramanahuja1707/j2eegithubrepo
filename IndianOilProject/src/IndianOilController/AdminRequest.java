package IndianOilController;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.catalina.connector.Request;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import IndianOilModel.AdminTransportInfoRefined;
import IndianOilModel.ContractorData;
import IndianOilModel.EmployeeData;
import IndianOilModel.RequestToContractor;
import IndianOilModel.TransportInfo;

import com.opensymphony.xwork2.ActionSupport;

public class AdminRequest extends ActionSupport implements SessionAware {
	private String calculatedEmpno;
	public String getCalculatedEmpno() {
		return calculatedEmpno;
	}

	public void setCalculatedEmpno(String calculatedEmpno) {
		this.calculatedEmpno = calculatedEmpno;
	}

	private ArrayList<ContractorData> cd = new ArrayList<>();
	private TransportInfo tiReject;
	private TransportInfo tiApprove;
	ArrayList<TransportInfo> resultantForUpdatingRequestToCotractor;
	public ArrayList<TransportInfo> getResultantForUpdatingRequestToCotractor() {
		return resultantForUpdatingRequestToCotractor;
	}

	public void setResultantForUpdatingRequestToCotractor(
			ArrayList<TransportInfo> resultantForUpdatingRequestToCotractor) {
		this.resultantForUpdatingRequestToCotractor = resultantForUpdatingRequestToCotractor;
	}

	public TransportInfo getTiReject() {
		return tiReject;
	}

	public void setTiReject(TransportInfo tiReject) {
		this.tiReject = tiReject;
	}

	public TransportInfo getTiApprove() {
		return tiApprove;
	}

	public void setTiApprove(TransportInfo tiApprove) {
		this.tiApprove = tiApprove;
	}

	private String ContractorId;
	private String MailStatus;
	private String obtainedemail;
	private Boolean connectivity;
	private String ValidateApproveStatus;
	private String RejectionStatus;
	private String ApprovalStatus;
	private String ValidateRejectStatus;
	private String result;
	private String trip;
	private String station;
	private String name;
	private String contact;
	private String reason;

	public ArrayList<ContractorData> getCd() {
		return cd;
	}

	public void setCd(ArrayList<ContractorData> cd) {
		this.cd = cd;
	}

	private String obtainedempno;
	private ArrayList<TransportInfo> tr = new ArrayList<>();

	public String getContractorId() {
		return ContractorId;
	}

	public void setContractorId(String contractorId) {
		ContractorId = contractorId;
	}

	public String getRejectionStatus() {
		return RejectionStatus;
	}

	public void setRejectionStatus(String rejectionStatus) {
		RejectionStatus = rejectionStatus;
	}

	public String getApprovalStatus() {
		return ApprovalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		ApprovalStatus = approvalStatus;
	}

	public ArrayList<TransportInfo> getTr() {
		return tr;
	}

	public void setTr(ArrayList<TransportInfo> tr) {
		this.tr = tr;
	}

	public String getObtainedemail() {
		return obtainedemail;
	}

	public void setObtainedemail(String obtainedemail) {
		this.obtainedemail = obtainedemail;
	}

	public String getMailStatus() {
		return MailStatus;
	}

	public void setMailStatus(String mailStatus) {
		MailStatus = mailStatus;
	}

	public String getValidateApproveStatus() {
		return ValidateApproveStatus;
	}

	public void setValidateApproveStatus(String validateApproveStatus) {
		ValidateApproveStatus = validateApproveStatus;
	}

	public String getValidateRejectStatus() {
		return ValidateRejectStatus;
	}

	public void setValidateRejectStatus(String validateRejectStatus) {
		ValidateRejectStatus = validateRejectStatus;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getObtainedempno() {
		return obtainedempno;
	}

	public void setObtainedempno(String obtainedempno) {
		this.obtainedempno = obtainedempno;
	}

	Map se;

	@Override
	public void setSession(Map<String, Object> arg0) {
		se = arg0;
	}

	@Override
	public String execute() throws Exception {
		if (getResult().equals("Approve")) {
			if (validateApproveFields().equals("NoError")) {
				extractDataFromTransportInfo();
				updateRequestToContractorTable();
				updateEmployeeRequestApproved();
				updateStatusOfApproval();
				refreshEmployeeRecords();
				approveEmployeeRequest();
				refreshConractorData();
				if (getTr().size() > 0) {
					setApprovalStatus("Request Approved successfully !!");
					return "ApprovedSuccess";
				} else {
					return "NoDataFound";
				}
			} else {
				setApprovalStatus("Approval of Request Failed !!!!");
				return "ApprovedError";
			}
		} else {
			if (validateRejectedFields().equals("NoError")) {
				calculateEmpnoByPk();
				SessionFactory sf = new Configuration().configure()
						.buildSessionFactory();
				org.hibernate.classic.Session ses = sf.openSession();
				ses.getTransaction();
				Query q = ses.createQuery("from EmployeeData where EmpNo='"
						+ getCalculatedEmpno() + "'");
				ArrayList<EmployeeData> result = (ArrayList<EmployeeData>) q
						.list();
				setObtainedemail(result.get(0).getEmpEmail());
				if (checkConnection()) {
					try {
						System.out.println("Collecting proerties . . .");
						// Creating the properties Object
						Properties prop = System.getProperties();
						prop.put("mail.smtp.host", "smtp.gmail.com");
						prop.put("mail.smtp.port", "587");
						prop.put("mail.smtp.starttls.enable", "true");
						prop.put("mail.smtp.auth", "true");

						// Wrapping Username and password in MuAuthenticator
						// Object
						MyAuthenticator mauth = new MyAuthenticator(
								"ramanahuja188@gmail.com", "raman@ahuja");

						System.out.println("Establishing session.....");

						Session s = Session.getDefaultInstance(prop, mauth);
						// Creating the Message
						Message m = new MimeMessage(s);
						m.setRecipient(RecipientType.TO, new InternetAddress(
								getObtainedemail()));

						// setting the headers
						m.setFrom(new InternetAddress("ramanahuja188@gmail.com"));
						m.setSubject("REQUEST REJECTED");
						// The message -- Creating Bodypart
						BodyPart bpMessage = new MimeBodyPart();
						bpMessage
								.setText("YOUR APPLICATION REQUEST FOR THE BOOKING OF CONVEINCE HAS BEEN REJECTED DUE TO :"
										+ getReason());
						// // Attachment == Creating MimeBodypart

						Multipart mp = new MimeMultipart();
						mp.addBodyPart(bpMessage);

						m.setContent(mp);
						// Sendnig the Mail using Transport Class
						Transport.send(m);
						updateEmployeeRequestRejected();
						updateStatusOfRejection();
						refreshEmployeeRecords();
						refreshConractorData();
						System.out.println("Mail Sent Successfully ");
					} catch (MessagingException e) {
						System.out.println("Messaging Exception : "
								+ e.getMessage());
						e.printStackTrace();
						refreshEmployeeRecords();
						setMailStatus("Internet not working or some other error ocuured !!!");
						return "NoInternetConnection";
					} catch (Exception e) {
						System.out.println("Eception " + e.getMessage());
						refreshEmployeeRecords();
						e.printStackTrace();
						setMailStatus("Internet not working or some other error ocuured !!!");
						return "NoInternetConnection";
					}
					if (getTr().size() > 0) {
						refreshEmployeeRecords();
						setRejectionStatus("Request Rejected successfully !!");
						return "RejectedSuccess";
					} else {
						refreshEmployeeRecords();
						return "NoDataFound";
					}
				} else {
					refreshEmployeeRecords();
					setMailStatus("Internet not working or some other error ocuured !!!");
					return "NoInternetConnection";
				}
			} else {
				refreshEmployeeRecords();
				setRejectionStatus("Rejection of Request Failed !!!");
				return "RejectedError";
			}

		}
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String validateApproveFields() {
		refreshEmployeeRecords();
		refreshConractorData();
		if (getObtainedempno() == null) {
			setValidateApproveStatus("Please Fill all the Fields !!!!");
			return "ApprovedError";
		} else if (getTrip() == null) {
			setValidateApproveStatus("Please Fill all the Fields !!!!");
			return "ApprovedError";
		} else if (getName().equals("")) {
			setValidateApproveStatus("Please Fill all the Fields !!!!");
			return "ApprovedError";
		} else if (getContact().equals("")) {
			setValidateApproveStatus("Please Fill all the Fields !!!!");
			return "ApprovedError";
		} else if (getContractorId() == null) {
			setValidateApproveStatus("Please Fill all the Fields !!!!");
			return "ApprovedError";
		}
		return "NoError";
	}

	public String validateRejectedFields() {
		refreshEmployeeRecords();
		if (getResult().equals("")) {
			setValidateRejectStatus("Please Fill the Fields !!!!");
			return "RejectedError";
		}
		if (getObtainedempno() == null) {
			setValidateRejectStatus("Please Fill the Fields !!!!");
			return "RejectedError";
		}

		else if (getReason().equals("")) {

			setValidateRejectStatus("Please Fill the Fields !!!!");
			return "RejectedError";
		}
		return "NoError";
	}

	public Boolean checkConnection() {
		try {
			URL url = new URL("http://www.google.com/");
			URLConnection conn = url.openConnection();
			conn.connect();
			connectivity = true;
			System.out.println("Dude its Working Fine ! ");
		} catch (Exception e) {
			connectivity = false;
			System.out.println("Not Working");
		}
		return connectivity;
	}

	public void updateEmployeeRequestRejected() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from TransportInfo where Pk='"
				+ getObtainedempno() + "' and RequestStatus='"
				+ "Sent For Approval" + "'");
		ArrayList<TransportInfo> result = (ArrayList<TransportInfo>) q.list();
		result.get(0).setRequestStatus("Rejected");
		System.out.println(result.get(0).getRequestStatus());
		tiReject = result.get(0);
		System.out.println("Update Employee Request Rejected !!!"
				+ result.get(0).getRequestStatus());
	}

	public void updateStatusOfRejection() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.beginTransaction();
		ses.update(getTiReject());
		ses.getTransaction().commit();

	}

	public void refreshEmployeeRecords() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from TransportInfo where RequestStatus='"
				+ "Sent For Approval" + "'");
		ArrayList<TransportInfo> result = (ArrayList<TransportInfo>) q.list();
		setTr(result);
		System.out.println("Refresh Employee Records !!!!" + result.size());
	}

	public void approveEmployeeRequest() {
		AdminTransportInfoRefined atir = new AdminTransportInfoRefined();
		atir.setAdminContact(getContact());
		atir.setAdminName(getName());
		atir.setAdminRequeststatus("Sent To Contractor");
		atir.setContractorId(getContractorId());
		if (getStation() == null)
			atir.setDropAtStation("No");
		else
			atir.setDropAtStation("Yes");
		atir.setEmpNo(getObtainedempno());
		atir.setTripInKms(getTrip());
		atir.setD(new Date());
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.beginTransaction();
		ses.save(atir);
		ses.getTransaction().commit();
		System.out.println("Employee Request approved !!!");
	}

	public void refreshConractorData() {
		setCd((ArrayList<ContractorData>) se.get("ContractorData"));
		System.out.println("Refresh Contractor Data !!!");
	}

	public void updateEmployeeRequestApproved() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from TransportInfo  where Pk='"
				+ getObtainedempno() + "' and RequestStatus='"
				+ "Sent For Approval" + "'");
		// int i=q.executeUpdate();
		ArrayList<TransportInfo> result = (ArrayList<TransportInfo>) q.list();
		result.get(0).setRequestStatus("Approved");
		tiApprove = result.get(0);
		System.out.println("Update Employee Request Approved !!!"
				+ result.get(0).getRequestStatus());
	}

	public void updateStatusOfApproval() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.beginTransaction();
		ses.update(tiApprove);
		ses.getTransaction().commit();
	
		System.out.println("Update Status of Approval !!!");
	}
	public void extractDataFromTransportInfo() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from TransportInfo  where Pk='"
				+ getObtainedempno() + "' and RequestStatus='"
				+ "Sent For Approval" + "'");
		// int i=q.executeUpdate();
		setResultantForUpdatingRequestToCotractor((ArrayList<TransportInfo>) q.list());
	}
	public void updateRequestToContractorTable()
	{
		RequestToContractor rtc=new RequestToContractor();
		rtc.setAdminContact(getContact());
		rtc.setAdminName(getName());
		rtc.setAdminRequeststatus("Sent To Contractor");
		rtc.setCarName(resultantForUpdatingRequestToCotractor.get(0).getCarName());
		rtc.setCarReportingDate(resultantForUpdatingRequestToCotractor.get(0).getCarReportingDate());
		rtc.setCarReportingTime(resultantForUpdatingRequestToCotractor.get(0).getCarReportingTime());
		rtc.setCarType(resultantForUpdatingRequestToCotractor.get(0).getCarType());
		rtc.setContractorId(getContractorId());
		rtc.setDateofBookingRequest(resultantForUpdatingRequestToCotractor.get(0).getDateofBookingRequest());
		if(getStation()==null)
		rtc.setDropAtStation("No");
		else
			rtc.setDropAtStation("Yes");
		rtc.setEmpAddress(resultantForUpdatingRequestToCotractor.get(0).getEmpAddress());
		rtc.setEmpMobileNo(resultantForUpdatingRequestToCotractor.get(0).getEmpMobileNo());
		rtc.setEmpName(resultantForUpdatingRequestToCotractor.get(0).getEmpName());
		rtc.setEmpno(getObtainedempno());
		rtc.setEmpPurpose(resultantForUpdatingRequestToCotractor.get(0).getEmpPurpose());
		rtc.setRequestStatus(resultantForUpdatingRequestToCotractor.get(0).getRequestStatus());
		rtc.setTripInKms(getTrip());
		rtc.setDateofBookingRequest(new Date().toString());
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.beginTransaction();
		ses.save(rtc);
		ses.getTransaction().commit();
		
		System.out.println("Update Status of Approval !!!");
		
	}
	
	public void calculateEmpnoByPk() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from TransportInfo  where Pk='"
				+ getObtainedempno() + "'");
		// int i=q.executeUpdate();
		ArrayList<TransportInfo> result = (ArrayList<TransportInfo>) q.list();
		setCalculatedEmpno(result.get(0).getEmpno());
		System.out.println("Update Employee Request Approved !!!"
				+ result.get(0).getRequestStatus());
	}
}
