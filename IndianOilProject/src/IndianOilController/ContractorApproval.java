package IndianOilController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import IndianOilModel.AdminTransportInfoRefined;
import IndianOilModel.ContractorApprovedData;
import IndianOilModel.ContractorData;
import IndianOilModel.DriverData;
import IndianOilModel.EmployeeData;
import IndianOilModel.RequestToContractor;
import IndianOilModel.TransportInfo;

import com.opensymphony.xwork2.ActionSupport;

public class ContractorApproval extends ActionSupport implements SessionAware {

	Map se;
	private String EmpNo1;
	public String getEmpNo1() {
		return EmpNo1;
	}

	public void setEmpNo1(String empNo1) {
		EmpNo1 = empNo1;
	}
	private String ContractorIdInSession;
	private String obtainedEmpMobileNo;
	private String approveEmailMessage;

	public String getApproveEmailMessage() {
		return approveEmailMessage;
	}

	public void setApproveEmailMessage(String approveEmailMessage) {
		this.approveEmailMessage = approveEmailMessage;
	}

	public String getContractorIdInSession() {
		return ContractorIdInSession;
	}

	public void setContractorIdInSession(String contractorIdInSession) {
		ContractorIdInSession = contractorIdInSession;
	}

	private String prepareMessageForSms;

	public String getPrepareMessageForSms() {
		return prepareMessageForSms;
	}

	public void setPrepareMessageForSms(String prepareMessageForSms) {
		this.prepareMessageForSms = prepareMessageForSms;
	}

	private String AllotedStatus;

	public String getObtainedEmpMobileNo() {
		return obtainedEmpMobileNo;
	}

	public void setObtainedEmpMobileNo(String obtainedEmpMobileNo) {
		this.obtainedEmpMobileNo = obtainedEmpMobileNo;
	}

	private String ContractorName;
	private ArrayList<RequestToContractor> rtc;
	private RequestToContractor rtcHolder;
	private RequestToContractor rtcApprove;
	private String ExtractedEmpNo;
	private String ExtractedEmpEmail;
	boolean connectivity;

	public String getExtractedEmpNo() {
		return ExtractedEmpNo;
	}

	public void setExtractedEmpNo(String extractedEmpNo) {
		ExtractedEmpNo = extractedEmpNo;
	}

	public String getExtractedEmpEmail() {
		return ExtractedEmpEmail;
	}

	public void setExtractedEmpEmail(String extractedEmpEmail) {
		ExtractedEmpEmail = extractedEmpEmail;
	}

	public RequestToContractor getRtcApprove() {
		return rtcApprove;
	}

	public void setRtcApprove(RequestToContractor rtcApprove) {
		this.rtcApprove = rtcApprove;
	}

	public RequestToContractor getRtcHolder() {
		return rtcHolder;
	}

	public void setRtcHolder(RequestToContractor rtcHolder) {
		this.rtcHolder = rtcHolder;
	}

	public String getContractorName() {
		return ContractorName;
	}

	public void setContractorName(String contractorName) {
		ContractorName = contractorName;
	}

	public String getAllotedStatus() {
		return AllotedStatus;
	}

	public void setAllotedStatus(String allotedStatus) {
		AllotedStatus = allotedStatus;
	}

	private ArrayList<DriverData> dd = new ArrayList<>();

	public ArrayList<DriverData> getDd() {
		return dd;
	}

	public void setDd(ArrayList<DriverData> dd) {
		this.dd = dd;
	}

	private String DriverContact;

	public String getDriverContact() {
		return DriverContact;
	}

	public void setDriverContact(String driverContact) {
		DriverContact = driverContact;
	}

	private String ContractorId;
	private TransportInfo trApprove;
	private TransportInfo trReject;

	public TransportInfo getTrApprove() {
		return trApprove;
	}

	public void setTrApprove(TransportInfo trApprove) {
		this.trApprove = trApprove;
	}

	public TransportInfo getTrReject() {
		return trReject;
	}

	public void setTrReject(TransportInfo trReject) {
		this.trReject = trReject;
	}

	public String getContractorId() {
		return ContractorId;
	}

	public void setContractorId(String contractorId) {
		ContractorId = contractorId;
	}

	public ArrayList<TransportInfo> getTr() {
		return tr;
	}

	public void setTr(ArrayList<TransportInfo> tr) {
		this.tr = tr;
	}

	private AdminTransportInfoRefined atirApprove;
	private AdminTransportInfoRefined atirReject;
	private ArrayList<TransportInfo> tr = new ArrayList<>();

	public ArrayList<AdminTransportInfoRefined> getAt() {
		return at;
	}

	public void setAt(ArrayList<AdminTransportInfoRefined> at) {
		this.at = at;
	}

	ArrayList<AdminTransportInfoRefined> at = new ArrayList<>();

	public AdminTransportInfoRefined getAtirApprove() {
		return atirApprove;
	}

	public void setAtirApprove(AdminTransportInfoRefined atirApprove) {
		this.atirApprove = atirApprove;
	}

	public AdminTransportInfoRefined getAtirReject() {
		return atirReject;
	}

	public void setAtirReject(AdminTransportInfoRefined atirReject) {
		this.atirReject = atirReject;
	}

	private String ValidateApproveStatus;
	private String ValidateRejectedStatus;

	public String getValidateApproveStatus() {
		return ValidateApproveStatus;
	}

	public void setValidateApproveStatus(String validateApproveStatus) {
		ValidateApproveStatus = validateApproveStatus;
	}

	public String getValidateRejectedStatus() {
		return ValidateRejectedStatus;
	}

	public void setValidateRejectedStatus(String validateRejectedStatus) {
		ValidateRejectedStatus = validateRejectedStatus;
	}

	private String Reason;

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	private String CarNo;

	public String getCarNo() {
		return CarNo;
	}

	public void setCarNo(String carNo) {
		CarNo = carNo;
	}

	private String obtainedempno;
	private String result;
	private String StartingReading;
	private String EndingReading;
	private String TotalKms;
	private String TotalTimeTaken;
	private String DriverAlloted;
	private String MailStatus;
	private String RejectionStatus;

	public String getMailStatus() {
		return MailStatus;
	}

	public void setMailStatus(String mailStatus) {
		MailStatus = mailStatus;
	}

	public String getRejectionStatus() {
		return RejectionStatus;
	}

	public void setRejectionStatus(String rejectionStatus) {
		RejectionStatus = rejectionStatus;
	}

	public String getObtainedempno() {
		return obtainedempno;
	}

	public void setObtainedempno(String obtainedempno) {
		this.obtainedempno = obtainedempno;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStartingReading() {
		return StartingReading;
	}

	public void setStartingReading(String startingReading) {
		StartingReading = startingReading;
	}

	public String getEndingReading() {
		return EndingReading;
	}

	public void setEndingReading(String endingReading) {
		EndingReading = endingReading;
	}

	public String getTotalKms() {
		return TotalKms;
	}

	public void setTotalKms(String totalKms) {
		TotalKms = totalKms;
	}

	public String getTotalTimeTaken() {
		return TotalTimeTaken;
	}

	public void setTotalTimeTaken(String totalTimeTaken) {
		TotalTimeTaken = totalTimeTaken;
	}

	public String getDriverAlloted() {
		return DriverAlloted;
	}

	public void setDriverAlloted(String driverAlloted) {
		DriverAlloted = driverAlloted;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		se = arg0;
	}

	@Override
	public String execute() throws Exception {
		setContractorIdInSession((String) se.get("ContractorId"));
		if (getResult().equals("Approve")) {
			setContractorId((String) se.get("ContractorId"));
			if (validateApproveFields().equals("NoError")) {
				/*
				 * extractAdminRequestApproved();
				 * updateStatusOfApprovalInAdminTransportInfoRefined();
				 * refreshAdminRecords(); extractTransportInfo();
				 * updateStatusOfApprovalOfTransportInfo();
				 * refreshTransportTableRecords();
				 */
				String s = approveMailSend();
				if (s.equals("NoErrorInApproveSendingMail")) {
				/*	extractDataFromRequestToContractor();
					extractEmpNo();
					extractEmail();
					approveAdminRequest();
					refreshDriverData();
					extractRequestToContractor();
					sendSms();
					refreshRequestToContractor();*/
					if (getRtc().size() > 0) {
						setAllotedStatus("Request Alloted successfully !!");
						return "ApprovedSuccess";
					} else {
						return "NoDataFound";
					}
				} else{
					refreshRequestToContractor();
					setMailStatus("Internet not working or some other error ocuured !!!");
					return "NoInternetConnection";
				}
			} else {
				return "ApprovedError";
			}

		} else {
			if (validateRejectedFields().equals("NoError")) {
				if (checkConnection()) {
					try {
						extractEmpNo();
						extractEmail();
						System.out.println("Collecting proerties . . .");
						// Creating the
						// properties
						// Object
						Properties prop = System.getProperties();
						prop.put("mail.smtp.host", "smtp.gmail.com");
						prop.put("mail.smtp.port", "587");
						prop.put("mail.smtp.starttls.enable", "true");
						prop.put("mail.smtp.auth", "true");

						// Wrapping Username and password in MuAuthenticator //
						// Object
						MyAuthenticator mauth = new MyAuthenticator(
								"ramanahuja188@gmail.com", "raman@ahuja");

						System.out.println("Establishing session.....");

						Session s = Session.getDefaultInstance(prop, mauth); // Creating
																				// the
																				// Message
						Message m = new MimeMessage(s);
						m.setRecipient(RecipientType.TO, new InternetAddress(
								getExtractedEmpEmail()));

						// setting the headers m.setFrom(new
						// InternetAddress("ramanahuja188@gmail.com"));
						m.setSubject("REQUEST REJECTED");
						// The message -- Creating Bodypart
						BodyPart bpMessage = new MimeBodyPart();
						bpMessage
								.setText("YOUR APPLICATION REQUEST FOR THE BOOKING OF CONVEINCE HAS BEEN REJECTED DUE TO :"
										+ getReason()); // // Attachment ==
														// Creating MimeBodypart

						Multipart mp = new MimeMultipart();
						mp.addBodyPart(bpMessage);

						m.setContent(mp); // Sending the Mail using Transport
											// Class
						Transport.send(m);
						extractRequestToContractor();
						refreshRequestToContractor();
						System.out.println("Mail Sent Successfully ");
					} catch (MessagingException e) {
						System.out.println("Messaging Exception : "
								+ e.getMessage());
						e.printStackTrace();
						refreshRequestToContractor();
						setMailStatus("Internet not working or some other error ocuured !!!");
						return "NoInternetConnection";
					} catch (Exception e) {
						System.out.println("Eception " + e.getMessage());
						refreshRequestToContractor();
						e.printStackTrace();
						setMailStatus("Internet not working or some other error ocuured !!!");
						return "NoInternetConnection";
					}
					if (getRtc().size() > 0) {
						setRejectionStatus("Request Rejected successfully !!");
						return "RejectedSuccess";
					} else {
						refreshRequestToContractor();
						return "NoDataFound";
					}
				} else {
					refreshRequestToContractor();
					setMailStatus("Internet not working or some other error ocuured !!!");
					return "NoInternetConnection";
				}
			} else {
				refreshRequestToContractor();
				setRejectionStatus("Rejection of Request Failed !!!");
				return "RejectedError";
			}
		}
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

	private void extractEmail() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from EmployeeData where EmpName='"
				+ getExtractedEmpNo() + "'");
		// int i=q.executeUpdate();
		ArrayList<EmployeeData> resultdata = (ArrayList<EmployeeData>) q.list();
		setExtractedEmpEmail(resultdata.get(0).getEmpEmail());
		setObtainedEmpMobileNo(resultdata.get(0).getEmpContact());
		System.out.println("extracted emp no is:"
				+ resultdata.get(0).getEmpEmail());
	}

	private void extractEmpNo() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from RequestToContractor where Pk='"
				+ getObtainedempno() + "' and ContractorId='"
				+ getContractorIdInSession() + "'");
		// int i=q.executeUpdate();
		ArrayList<RequestToContractor> resultdata = (ArrayList<RequestToContractor>) q
				.list();
		setExtractedEmpNo(resultdata.get(0).getEmpName());
		setEmpNo1(resultdata.get(0).getEmpno());
		System.out.println("extracted emp no is:"
				+ resultdata.get(0).getEmpName());
	}

	private String approveMailSend() {
		if (checkConnection()) {
			try {
				extractDataFromRequestToContractor();
				extractEmpNo();
				extractEmail();
				approveAdminRequest();
				refreshDriverData();
				extractRequestToContractor();
				sendSms();
				refreshRequestToContractor();
				extractEmpNo();
				extractEmail();
				System.out.println("Collecting proerties . . .");
				// Creating the
				// properties
				// Object
				Properties prop = System.getProperties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", "587");
				prop.put("mail.smtp.starttls.enable", "true");
				prop.put("mail.smtp.auth", "true");

				// Wrapping Username and password in MuAuthenticator //
				// Object
				MyAuthenticator mauth = new MyAuthenticator(
						"ramanahuja188@gmail.com", "raman@ahuja");

				System.out.println("Establishing session.....");

				Session s = Session.getDefaultInstance(prop, mauth); // Creating
																		// the
																		// Message
				Message m = new MimeMessage(s);
				m.setRecipient(RecipientType.TO, new InternetAddress(
						getExtractedEmpEmail()));

				// setting the headers m.setFrom(new
				// InternetAddress("ramanahuja188@gmail.com"));
				m.setSubject("REQUEST APPROVED");
				// The message -- Creating Bodypart
				BodyPart bpMessage = new MimeBodyPart();
				String message = "YOUR APPLICATION REQUEST FOR THE BOOKING OF CONVEINCE HAS BEEN APPROVED WITH DETAILS GIVEN AS :"
						+ getApproveEmailMessage();
				bpMessage.setText(message);
				// // Attachment ==
				// Creating MimeBodypart

				Multipart mp = new MimeMultipart();
				mp.addBodyPart(bpMessage);

				m.setContent(mp); // Sending the Mail using Transport
									// Class
				Transport.send(m);
				refreshRequestToContractor();
				refreshDriverData();
				System.out.println("Mail Sent Successfully ");
				return "NoErrorInApproveSendingMail";
			} catch (MessagingException e) {
				System.out.println("Messaging Exception : " + e.getMessage());
				e.printStackTrace();
				refreshRequestToContractor();
				refreshDriverData();
				setMailStatus("Internet not working or some other error ocuured !!!");
				return "NoInternetConnection";
			} catch (Exception e) {
				System.out.println("Exception " + e.getMessage());
				refreshRequestToContractor();
				refreshDriverData();
				e.printStackTrace();
				setMailStatus("Internet not working or some other error ocuured !!!");
				return "NoInternetConnection";
			}
		}
		refreshRequestToContractor();
		refreshDriverData();
		return "NoInternetConnection";
	}

	public String validateApproveFields() {
		refreshRequestToContractor();
		refreshDriverData();
		if (getObtainedempno() == null) {
			setValidateApproveStatus("Please select a record to allot or reject !!");
			return "ValidationError";
		}
		if (getResult() == null) {
			setValidateApproveStatus("Please fill all the fields !!!");
			return "ValidationError";
		}
		if (getStartingReading().equals("")) {
			setValidateApproveStatus("Please fill all the fields !!!");
			return "ValidationError";
		}
		if (getEndingReading().equals("")) {
			setValidateApproveStatus("Please fill all the fields !!!");
			return "ValidationError";
		}
		if (getTotalKms().equals("")) {
			setValidateApproveStatus("Please fill all the fields !!!");
			return "ValidationError";
		}
		if (getTotalTimeTaken().equals("")) {
			setValidateApproveStatus("Please fill all the fields !!!");
			return "ValidationError";
		}
		if (getDriverAlloted() == null) {
			setValidateApproveStatus("Please fill all the fields !!!");
			return "ApprovalError";
		}
		return "NoError";
	}

	public String validateRejectedFields() {
		refreshRequestToContractor();
		refreshDriverData();
		if (getResult().equals("")) {
			setValidateRejectedStatus("Please Fill the Fields !!!!");
			return "RejectedError";
		}
		if (getObtainedempno() == null) {
			setValidateRejectedStatus("Please Fill the Fields !!!!");
			return "RejectedError";
		}

		else if (getReason().equals("")) {

			setValidateRejectedStatus("Please Fill the Fields !!!!");
			return "RejectedError";
		}
		return "NoError";
	}

	private void extractDataFromRequestToContractor() {
		System.out.println("obtained emp no:" + obtainedempno);
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses
				.createQuery("from RequestToContractor where RequestStatus='"
						+ "Sent For Approval" + "'and Pk='"
						+ getObtainedempno() + "' and AdminRequestStatus='"
						+ "Sent To Contractor" + "' and ContractorId='"
						+ getContractorIdInSession() + "'");
		ArrayList<RequestToContractor> result = (ArrayList<RequestToContractor>) q
				.list();
		setRtcApprove(result.get(0));
	}

	public void approveAdminRequest() {
		calculateDriverContact();
		calculateContractorName();
		ContractorApprovedData cad = new ContractorApprovedData();
		cad.setCarNo(getCarNo());
		cad.setEmpno(getEmpNo1());
		cad.setCarName(getRtcApprove().getCarName());
		cad.setCarType(getRtcApprove().getCarType());
		cad.setContractorId(getContractorId());
		cad.setContractorName(getContractorName());
		cad.setDriverContact(getDriverContact());
		cad.setDriverName(getDriverAlloted());
		cad.setEndingReading(getEndingReading());
		cad.setStartingReading(getStartingReading());
		cad.setTotalKms(getTotalKms());
		cad.setD(new Date());
		System.out.println("car name :" + cad.getCarName());
		System.out.println("car name :" + cad.getCarName());
		System.out.println("car no." + cad.getCarNo());
		System.out.println("contractor name :" + cad.getContractorName());
		System.out.println("contractor id :" + cad.getContractorId());
		System.out.println("driver name:" + cad.getDriverName());
		System.out.println("driver contact :" + cad.getDriverContact());
		setApproveEmailMessage("\nCar name :" + cad.getCarName() + "\nCar no.:"
				+ cad.getCarNo() + "\nDriver name:" + cad.getDriverName()
				+ "\nDriver contact :" + cad.getDriverContact());
		System.out.println(getApproveEmailMessage());
		cad.setTotalTimeTaken(getTotalTimeTaken());
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.beginTransaction();
		ses.save(cad);
		ses.getTransaction().commit();
	}

	public void calculateDriverContact() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from DriverData where DriverName='"
				+ getDriverAlloted() + "'");
		// int i=q.executeUpdate();
		ArrayList<DriverData> resultdriverdata = (ArrayList<DriverData>) q
				.list();
		if (resultdriverdata.size() == 1) {
			setDriverContact(resultdriverdata.get(0).getDriverContact());
		}
	}

	public void refreshDriverData() {
		setDd((ArrayList<DriverData>) se.get("dd"));
	}

	public void refreshAdminTransportTableWhenRecordNotSelected() {
		setTr((ArrayList<TransportInfo>) se.get("tr"));
		setAt((ArrayList<AdminTransportInfoRefined>) se.get("at"));
	}

	public void calculateContractorName() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from ContractorData where ContractorId='"
				+ getContractorId() + "'");
		// int i=q.executeUpdate();
		ArrayList<ContractorData> resultdriverdata = (ArrayList<ContractorData>) q
				.list();
		if (resultdriverdata.size() == 1) {
			setContractorName(resultdriverdata.get(0).getContractorName());
		}
	}

	private void extractRequestToContractor() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses
				.createQuery("from RequestToContractor where RequestStatus='"
						+ "Sent For Approval" + "'and Pk='"
						+ getObtainedempno() + "' and AdminRequestStatus='"
						+ "Sent To Contractor" + "' and ContractorId='"
						+ getContractorIdInSession() + "'");
		ArrayList<RequestToContractor> result = (ArrayList<RequestToContractor>) q
				.list();
		if (getResult().equals("Approve")) {
			setApproveEmailMessage(getApproveEmailMessage().concat(
					"\nCar reporting date :"
							+ result.get(0).getCarReportingDate()
							+ "\nCar reporting address :"
							+ result.get(0).getEmpAddress() + "\nPurpose :"
							+ result.get(0).getEmpPurpose()));
			System.out.println("\n" + getApproveEmailMessage());
			setPrepareMessageForSms("Car_Booking_Request_Approved_Dated_"
					+ result.get(0).getCarReportingDate()
					+ "-(Full_Detail_Have_Been_Mailed)");
			result.get(0).setRequestStatus("Approved By Contractor");
			result.get(0).setAdminRequeststatus("Approved By Contractor");
		} else {
			result.get(0).setRequestStatus("Rejected By Contractor");
			result.get(0).setAdminRequeststatus("Rejected By Contractor");
		}
		setRtcHolder(result.get(0));
		updateRequestToContractor();
	}

	private void updateRequestToContractor() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.beginTransaction();
		ses.update(getRtcHolder());
		ses.getTransaction().commit();
		refreshRequestToContractor();

	}

	private void refreshRequestToContractor() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses
				.createQuery("from RequestToContractor where RequestStatus='"
						+ "Sent For Approval" + "' and AdminRequestStatus='"
						+ "Sent To Contractor" + "' and ContractorId='"
						+ getContractorIdInSession() + "'");
		ArrayList<RequestToContractor> resultantrtc = (ArrayList<RequestToContractor>) q
				.list();
		setRtc(resultantrtc);
	}

	public ArrayList<RequestToContractor> getRtc() {
		return rtc;
	}

	public void setRtc(ArrayList<RequestToContractor> rtc) {
		this.rtc = rtc;
	}

	public void sendSms() {
		try {
			System.out.println("obtained mobile number :"
					+ getObtainedEmpMobileNo() + "obtained sms message :"
					+ getPrepareMessageForSms());
			String url_open = "http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=ramanahuja188@gmail.com&pwd=769943&to=9560804766&sid=WEBSMS&msg="+getPrepareMessageForSms()+"&fl=0";
			
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
			System.out.println("opened");
			/*URL url = new URL(
					"http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=ramanahuja188@gmail.com&pwd=769943&to="
							+ getObtainedEmpMobileNo()
							+ "&sid=WEBSMS&msg="
							+ getPrepareMessageForSms() + "&fl=0");
			URLConnection conn = url.openConnection();
			conn.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder stringBuilder = new StringBuilder();

			String line = null;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}
			if (stringBuilder.toString().equals("")) {
				System.out.println("url not opened and sms sending failed !!!");
			} else {
				System.out.println("url opened and sms sent !!! ");
			}*/
		} catch (Exception e) {
			System.out.println("exception in sms sending:" + e.getMessage());
			System.out.println("Not Working,,,Sms not sent !!");
		}

	}
}
