package IndianOilController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import IndianOilModel.ContractorApprovedData;
import IndianOilModel.EmployeeData;
import IndianOilModel.RequestToContractor;
import IndianOilModel.TransportInfo;

import com.opensymphony.xwork2.ActionSupport;

public class CarBookingPartA extends ActionSupport implements SessionAware {
	private EmployeeData ed1;
	private String CheckStatus;
	private String RequestNo;

	public String getCheckStatus() {
		return CheckStatus;
	}

	public void setCheckStatus(String checkStatus) {
		CheckStatus = checkStatus;
	}

	public String getRequestNo() {
		return RequestNo;
	}

	public void setRequestNo(String requestNo) {
		RequestNo = requestNo;
	}

	private ContractorApprovedData cad;
	private RequestToContractor rtc;

	public ContractorApprovedData getCad() {
		return cad;
	}

	public void setCad(ContractorApprovedData cad) {
		this.cad = cad;
	}

	public RequestToContractor getRtc() {
		return rtc;
	}

	public void setRtc(RequestToContractor rtc) {
		this.rtc = rtc;
	}

	private String requestno;

	public String getRequestno() {
		return requestno;
	}

	public void setRequestno(String requestno) {
		this.requestno = requestno;
	}

	private String ExtractedEmpName;

	public String getExtractedEmpName() {
		return ExtractedEmpName;
	}

	public void setExtractedEmpName(String extractedEmpName) {
		ExtractedEmpName = extractedEmpName;
	}

	private String obtainedempno;

	public String getObtainedempno() {
		return obtainedempno;
	}

	public void setObtainedempno(String obtainedempno) {
		this.obtainedempno = obtainedempno;
	}

	private String LogoutStatus;
	private ArrayList<TransportInfo> ApprovedRequests;

	public ArrayList<TransportInfo> getApprovedRequests() {
		return ApprovedRequests;
	}

	public void setApprovedRequests(ArrayList<TransportInfo> approvedRequests) {
		ApprovedRequests = approvedRequests;
	}

	private ArrayList<TransportInfo> RejectedRequests;

	public ArrayList<TransportInfo> getRejectedRequests() {
		return RejectedRequests;
	}

	public void setRejectedRequests(ArrayList<TransportInfo> rejectedRequests) {
		RejectedRequests = rejectedRequests;
	}

	public String getLogoutStatus() {
		return LogoutStatus;
	}

	public void setLogoutStatus(String logoutStatus) {
		LogoutStatus = logoutStatus;
	}

	private String RequestCheck;

	public String getRequestCheck() {
		return RequestCheck;
	}

	public void setRequestCheck(String requestCheck) {
		RequestCheck = requestCheck;
	}

	public EmployeeData getEd1() {
		return ed1;
	}

	public void setEd1(EmployeeData ed1) {
		this.ed1 = ed1;
	}

	private String checkDetailsValidationError;

	public String getCheckDetailsValidationError() {
		return checkDetailsValidationError;
	}

	public void setCheckDetailsValidationError(
			String checkDetailsValidationError) {
		this.checkDetailsValidationError = checkDetailsValidationError;
	}

	private Map se;
	private String ErrorStatus = "NoError";

	public String getErrorStatus() {
		return ErrorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		ErrorStatus = errorStatus;
	}

	private String ValidateFieldStatus;

	public String getValidateFieldStatus() {
		return ValidateFieldStatus;
	}

	public void setValidateFieldStatus(String validateFieldStatus) {
		ValidateFieldStatus = validateFieldStatus;
	}

	private TransportInfo ti = new TransportInfo();

	public TransportInfo getTi() {
		return ti;
	}

	public void setTi(TransportInfo ti) {
		this.ti = ti;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		se = arg0;
	}

	@Override
	public String execute() throws Exception {
		setEd1((EmployeeData) se.get("ed1"));
		if (requestCheck().equals("RequestNotExists")) {
			if (valid().equals("NoError")) {
				return methodRun();
			} else
				return "ValidationError";
		} else {
			setRequestCheck("Request Already Sent for the same date !!!!");
			return "RequestExists";
		}
	}

	public String valid() {
		setEd1((EmployeeData) se.get("ed1"));
		if (ti.getCarName() == null) {
			setErrorStatus("Error");
			setValidateFieldStatus("\n" + "Please select the car !!");
		}
		if (ti.getCarReportingDate() == null) {
			setErrorStatus("Error");
			setValidateFieldStatus("\n" + "Please mention the pick up date !!");
		}
		if (ti.getCarReportingTime().equals("")) {
			setErrorStatus("Error");
			setValidateFieldStatus("\n"
					+ "Please mention the pick up timings !!");
		}
		if (ti.getCarType() == null) {
			setErrorStatus("Error");
			setValidateFieldStatus("\n" + "Please select the car type !!");
		}
		if (ti.getEmpPurpose().equals("")) {
			setErrorStatus("Error");
			setValidateFieldStatus("\n" + "Please mention the purpose !!");
		}
		if (ti.getEmpMobileNo().equals("")) {
			setErrorStatus("Error");
			setValidateFieldStatus("\n" + "Please select the car type !!");

		}
		if (ti.getEmpAddress().equals("")) {
			setErrorStatus("Error");
			setValidateFieldStatus("\n" + "Please select the car type !!");
		}
		return ErrorStatus;
	}

	public String methodRun() {
		if (se.containsKey("EmpNo")) {
			setEd1((EmployeeData) se.get("ed1"));
			ti.setEmpNo((String) se.get("EmpNo"));
			ti.setRequestStatus("Sent For Approval");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			ti.setDateofBookingRequest(dateFormat.format(date));
			String obtainedEmpName = (String) getEd1().getEmpName();
			ti.setEmpName(obtainedEmpName);
			System.out.println("Data of the Employee collected is :");
			System.out.println("------------------------");
			System.out.println("\n" + ti.getCarName());
			System.out.println("\n" + ti.getCarReportingTime());
			System.out.println("\n" + ti.getCarType());
			System.out.println("\n" + ti.getEmpAddress());
			System.out.println("\n" + ti.getEmpMobileNo());
			System.out.println("\n" + ti.getEmpPurpose());
			System.out.println(ti.getRequestStatus());
			System.out.println(dateFormat.format(date));
			System.out.println("-----------------------");
			System.out.println(ti.getEmpNo());
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			System.out.println("session build up !!!");
			Session ses = sf.openSession();
			ses.beginTransaction();
			System.out.println("Transaction started!!!!");
			ses.save(ti);
			System.out.println("data saved !!!");
			ses.getTransaction().commit();
			System.out.println("transaction committed !!!");

			if (ti != null) {
				return "BookingSuccess";
			} else
				return "BookingFailure";
		} else
			return "NotInSession";
	}

	public String requestCheck() {
		System.out.println("car reporting date :" + ti.getCarReportingDate());
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from TransportInfo where Empno='"
				+ se.get("EmpNo") + "'");
		ArrayList<TransportInfo> result = (ArrayList<TransportInfo>) q.list();
		if (result.size() > 0) {
			if (result.get(0).getCarReportingDate()
					.equals(ti.getCarReportingDate())) {
				return "RequestExists";
			} else
				return "RequestNotExists";
		} else
			return "RequestNotExists";

	}

	public String logout() {
		se.remove("EmpNo");
		se.remove("EmpPassword");
		setLogoutStatus("Logout successfully !!");
		return "logoutsuccess";
	}

	public String showRejectedRequests() {
		if (se.containsKey("EmpNo")) {
			setEd1((EmployeeData) se.get("ed1"));
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.getTransaction();
			Query q = ses.createQuery("from TransportInfo where Empno='"
					+ se.get("EmpNo") + "'and RequestStatus='" + "Rejected"
					+ "'");
			ArrayList<TransportInfo> result = (ArrayList<TransportInfo>) q
					.list();
			setRejectedRequests(result);
			if (result.size() > 0) {
				return "success";
			} else
				return "NoRejectedRequest";
		} else {
			se.remove("EmpNo");
			se.remove("EmpPassword");
			return "NotInSession";
		}

	}

	public String bookNow() {
		if (se.containsKey("EmpNo")) {
			setEd1((EmployeeData) se.get("ed1"));
			return "success";
		} else {
			se.remove("EmpNo");
			se.remove("EmpPassword");
			return "NotInSession";
		}
	}

	public String showApprovedRequests() {
		if (se.containsKey("EmpNo")) {
			extractEmpName();
			setEd1((EmployeeData) se.get("ed1"));
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.getTransaction();
			Query q = ses
					.createQuery("from RequestToContractor where EmpName='"
							+ getExtractedEmpName() + "'and RequestStatus='"
							+ "Approved By Contractor"
							+ "' and AdminRequestStatus='"
							+ "Approved By Contractor" + "'");
			ArrayList<TransportInfo> result = (ArrayList<TransportInfo>) q
					.list();
			setApprovedRequests(result);
			if (result.size() > 0) {
				return "success";
			} else
				return "NoApprovedRequest";
		} else {
			se.remove("EmpNo");
			se.remove("EmpPassword");
			return "NotInSession";
		}

	}

	public void extractEmpName() {
		setEd1((EmployeeData) se.get("ed1"));
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		org.hibernate.classic.Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from EmployeeData where EmpNo='"
				+ se.get("EmpNo") + "'");
		// int i=q.executeUpdate();
		ArrayList<EmployeeData> resultdata = (ArrayList<EmployeeData>) q.list();
		setExtractedEmpName(resultdata.get(0).getEmpName());
		System.out.println("extracted emp name is:"
				+ resultdata.get(0).getEmpName());

	}

	public String checkDetails() {
		if (se.containsKey("EmpNo")) {
			if (getRequestno() != null) {
				setEd1((EmployeeData) se.get("ed1"));
				System.out.println("Going Emp No:" + getRequestno());
				extractRequestToContractor();
				SessionFactory sf = new Configuration().configure()
						.buildSessionFactory();
				org.hibernate.classic.Session ses = sf.openSession();
				ses.getTransaction();
				Query q = ses
						.createQuery("from ContractorApprovedData where EmpNo='"
								+ getRequestno() + "'");
				// int i=q.executeUpdate();
				ArrayList<ContractorApprovedData> resultdata = (ArrayList<ContractorApprovedData>) q
						.list();
				setCad(resultdata.get(0));
				if (resultdata.size() > 0) {
					setEd1((EmployeeData) se.get("ed1"));
					return "success";
				} else {
					return "NoDetailsFound";
				}
			} else {
				if (showApprovedRequests().equals("success")) {
					setEd1((EmployeeData) se.get("ed1"));
					setCheckDetailsValidationError("Please Select a Record !!!");
					return "ValidationError";
				} else {
					setCheckDetailsValidationError("Some Error Occured , Try again !!!");
					setEd1((EmployeeData) se.get("ed1"));
					return "SomeErrorOccured";
				}
			}
		} else {
			se.remove("EmpNo");
			se.remove("EmpPassword");
			return "NotInSession";
		}

	}

	public void extractRequestToContractor() {
		setEd1((EmployeeData) se.get("ed1"));
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from RequestToContractor where Empno='"
				+ getRequestno() + "'and RequestStatus='"
				+ "Approved By Contractor" + "' and AdminRequestStatus='"
				+ "Approved By Contractor" + "'");
		ArrayList<RequestToContractor> result = (ArrayList<RequestToContractor>) q
				.list();
		setRtc(result.get(0));
	}

	public String checkStatus() {
		setEd1((EmployeeData) se.get("ed1"));
		if (se.containsKey("EmpNo")) {
			setEd1((EmployeeData) se.get("ed1"));
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.getTransaction();
			Query q = ses.createQuery("from RequestToContractor where Empno='"
					+ getRequestNo() + "'and RequestStatus='"
					+ "Approved By Contractor" + "' and AdminRequestStatus='"
					+ "Approved By Contractor" + "'");
			Query q1 = ses
					.createQuery("from ContractorApprovedData where Empno='"
							+ getRequestNo() + "'");
			Query q2 = ses.createQuery("from RequestToContractor where Empno='"
					+ getRequestNo() + "'and RequestStatus='"
					+ "Rejected By Contractor" + "' and AdminRequestStatus='"
					+ "Rejected By Contractor" + "'");
			Query q3 = ses.createQuery("from TransportInfo where Pk='"
					+ getRequestNo() + "'and RequestStatus='" + "Rejected"
					+ "'");
			Query q4 = ses.createQuery("from TransportInfo where Pk='"
					+ getRequestNo() + "'");
			ArrayList<RequestToContractor> result = (ArrayList<RequestToContractor>) q
					.list();
			ArrayList<ContractorApprovedData> result1 = (ArrayList<ContractorApprovedData>) q1
					.list();
			ArrayList<RequestToContractor> result2 = (ArrayList<RequestToContractor>) q2
					.list();
			ArrayList<TransportInfo> result3 = (ArrayList<TransportInfo>) q3
					.list();
			ArrayList<TransportInfo> result4 = (ArrayList<TransportInfo>) q4
					.list();
			if (result.size() > 0 && result1.size() > 0) {
				setCheckStatus("Approved");
				setEd1((EmployeeData) se.get("ed1"));
				return "Approved";
			} else if (result3.size() > 0) {
				setEd1((EmployeeData) se.get("ed1"));
				setCheckStatus("Rejected By Admin");
				return "RejectedByAdmin";
			} else if (result2.size() > 0) {
				setEd1((EmployeeData) se.get("ed1"));
				setCheckStatus("Rejected By Contractor");
				return "RejectedByContractor";
			} else if(result4.size()==0)
			{
				setEd1((EmployeeData) se.get("ed1"));
				setCheckStatus("Please Enter Valid Request No. !!!");
				return "NoDataFound";
			}else
			{
				setEd1((EmployeeData) se.get("ed1"));
				setCheckStatus("In Processing");
				return "InProcessing";
			}
		} else {
			se.remove("EmpNo");
			se.remove("EmpPassword");
			return "NotInSession";
		}
	}
}
