package IndianOilController;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import IndianOilModel.ContractorData;
import IndianOilModel.EmployeeData;
import IndianOilModel.TransportInfo;

import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginLogout extends ActionSupport implements SessionAware {
	private Map se;
	private ArrayList<ContractorData> cd=new ArrayList<>();
	public ArrayList<ContractorData> getCd() {
		return cd;
	}

	public void setCd(ArrayList<ContractorData> cd) {
		this.cd = cd;
	}

	private ArrayList<TransportInfo> tr = new ArrayList<>();
	private String AdminKey;
	private String AdminPassword;
	private String AdminLoginLogoutStatus;

	public ArrayList<TransportInfo> getTr() {
		return tr;
	}

	public void setTr(ArrayList<TransportInfo> tr) {
		this.tr = tr;
	}

	public String getAdminLoginLogoutStatus() {
		return AdminLoginLogoutStatus;
	}

	public void setAdminLoginLogoutStatus(String adminLoginLogoutStatus) {
		AdminLoginLogoutStatus = adminLoginLogoutStatus;
	}

	public String getAdminKey() {
		return AdminKey;
	}
	public void setAdminKey(String adminKey) {
		AdminKey = adminKey;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		se = arg0;
	}

	@Override
	public String execute() throws Exception { 
		if (validateFields().equals("NoError")) {
			if (getAdminKey().equals("system123")
					&& getAdminPassword().equals("123")) {
				SessionFactory sf = new Configuration().configure()
						.buildSessionFactory();
				Session ses = sf.openSession();
				ses.getTransaction();
				Query q = ses
						.createQuery("from TransportInfo where RequestStatus='"
								+ "Sent For Approval" + "'");
				ArrayList<TransportInfo> result = (ArrayList<TransportInfo>) q
						.list();
				setTr(result);
				extractContractorData();
				se.put("AdminKey", getAdminKey());
				se.put("AdminPassword", getAdminPassword());
				se.put("RequestedData", getTr());
				se.put("ContractorData", getCd());
				System.out.println(result.size());
				se.put("noofrecords",result.size());
				if(result.size()>0)
				{
				return "AdminLoginSuccess";
				}else
				{
					return "NoDataFound";
				}
			} else {
				setAdminLoginLogoutStatus("Invalid Key or Password !!");
				return "InvalidUser";
			}
		} else {
			return "ValidateFieldError";
		}
	}

	public String validateFields() {
		if ((getAdminKey().equals(""))) {
			addFieldError("AdminKey", "Please Fill Admin Key !!");
			setAdminLoginLogoutStatus("Please Fill All Fields !!");
			return "Error";
		}

		if ((getAdminPassword().equals(""))) {
			addFieldError("AdminPassword", "Please Fill Admin Password !!");
			setAdminLoginLogoutStatus("Please Fill All Fields !!");
			return "Error";
		}
		return "NoError";

	}

	public String adminLogout() {
		if (se.containsKey("AdminKey")) {
			se.remove("AdminKey");
			se.remove("AdminPassword");
			setAdminLoginLogoutStatus("Logout Successfully !!");
			return "AdminLogoutSuccess";
		} else
			return "AdminLogoutFailure";
	}
	public void extractContractorData()
	{
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses
				.createQuery("from ContractorData");
		ArrayList<ContractorData> resultant = (ArrayList<ContractorData>) q
				.list();
		setCd(resultant);
	}
}
