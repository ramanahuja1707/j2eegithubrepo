package IndianOilController;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import IndianOilModel.AdminTransportInfoRefined;
import IndianOilModel.ContractorData;
import IndianOilModel.DriverData;
import IndianOilModel.EmployeeData;
import IndianOilModel.RequestToContractor;
import IndianOilModel.TransportInfo;

import com.opensymphony.xwork2.ActionSupport;

public class ContractorLogin extends ActionSupport implements SessionAware {

	Map se;
	 private ArrayList<DriverData> dd = new ArrayList<>();
	 private ArrayList<RequestToContractor> rtc=new ArrayList<>();

	public ArrayList<RequestToContractor> getRtc() {
		return rtc;
	}

	public void setRtc(ArrayList<RequestToContractor> rtc) {
		this.rtc = rtc;
	}

	public ArrayList<DriverData> getDd() {
		return dd;
	}

	public void setDd(ArrayList<DriverData> dd) {
		this.dd = dd;
	}

	private String ErrorStatus;
	private String ContractorLoginLogoutStatus;

	public String getContractorLoginLogoutStatus() {
		return ContractorLoginLogoutStatus;
	}

	public void setContractorLoginLogoutStatus(
			String contractorLoginLogoutStatus) {
		ContractorLoginLogoutStatus = contractorLoginLogoutStatus;
	}

	public String getErrorStatus() {
		return ErrorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		ErrorStatus = errorStatus;
	}

	ArrayList<RequestToContractor> at = new ArrayList<>();

	public ArrayList<RequestToContractor> getAt() {
		return at;
	}

	public void setAt(ArrayList<RequestToContractor> at) {
		this.at = at;
	}

	private String ContractorName;
	private String ContractorId;

	public String getContractorName() {
		return ContractorName;
	}

	public void setContractorName(String contractorName) {
		ContractorName = contractorName;
	}

	public String getContractorId() {
		return ContractorId;
	}

	public void setContractorId(String contractorId) {
		ContractorId = contractorId;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		se = arg0;
	}

	@Override
	public String execute() throws Exception {
		if (validateFields()) {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.getTransaction();
			Query q = ses
					.createQuery("from ContractorData where ContractorId='"
							+ getContractorId() + "' and ContractorName='"
							+ getContractorName() + "'");
			ArrayList<ContractorData> result = (ArrayList<ContractorData>) q
					.list();
			if (result.size() == 1) {
				extractRequestToContractor();
				extractDriverData();
				se.put("rtc", getAt());
				System.out.println(getContractorName());
				se.put("ContratorName", getContractorName());
				se.put("ContractorId", getContractorId());
				se.put("dd", getDd());
				se.put("noofrows", result.size());
				if (getRtc().size() > 0)
					return "ContractorSuccess";
				else
					return "NoData";
			} else {
				setErrorStatus("Invalid Name or Id !!");
				return "ContractorFailure";
			}
		}
		return "ValidateError";
	}

	public boolean validateFields() {
		boolean status = true;
		if (getContractorName().equals("")) {
			addFieldError("ContractorName",
					"Please Fill the Contractor Name !!");
			status = false;
		}
		if (getContractorId().equals("")) {
			addFieldError("ContractorId", "Please Fill the Contractor Id !!");
			status = false;
		}
		return status;
	}

	private void extractRequestToContractor() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses
				.createQuery("from RequestToContractor where ContractorId='"
						+ getContractorId()
						+ "' and AdminRequestStatus='"
						+ "Sent To Contractor" + "' and RequestStatus='"+"Sent For Approval"+"'");
		ArrayList<RequestToContractor> resultant = (ArrayList<RequestToContractor>) q
				.list();
		System.out.println("requests for the contractor after login are :"+resultant.size());
		setRtc(resultant);
	}

	public void extractDriverData() {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from DriverData");
		setDd((ArrayList<DriverData>) q.list());
	}

	public String contractorLogout() {
		System.out.println(se.get("ContractorName"));
		System.out.println(se.get("ContractorId"));
		System.out.println(se.size());
		if (se.containsKey("ContractorId")) {
			se.remove("ContractorId");
			se.remove("ContractorName");
			setContractorLoginLogoutStatus("Logout Successfully !!!");
			return "ContractorLogoutSuccess";
		} else {
			setContractorLoginLogoutStatus("Logout Failed !!!");
			return "ContractorLogoutFailure";
		}
	}
}
