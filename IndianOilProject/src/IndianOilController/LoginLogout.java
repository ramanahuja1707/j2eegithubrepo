package IndianOilController;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import IndianOilModel.EmployeeData;

import com.opensymphony.xwork2.ActionSupport;

public class LoginLogout extends ActionSupport implements SessionAware {
	private String EmpNo;

	public String getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(String empNo) {
		EmpNo = empNo;
	}
	private String EmpPassword;
	private Map se;
	private String LoginStatus;
	private EmployeeData ed1;
	public EmployeeData getEd1() {
		return ed1;
	}

	public void setEd1(EmployeeData ed1) {
		this.ed1 = ed1;
	}

	public String getLoginStatus() {
		return LoginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		LoginStatus = loginStatus;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		se = arg0;
	}

	@Override
	public String execute() throws Exception {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.getTransaction();
		Query q = ses.createQuery("from EmployeeData where EmpNo='"
				+ getEmpNo() + "' and EmpPassword='" + getEmpPassword() + "'");
		ArrayList<EmployeeData> result = (ArrayList<EmployeeData>) q.list();
		if (result.size() == 1) {
			setEd1((EmployeeData) result.get(0));
			se.put("EmpNo", getEmpNo());
			se.put("EmpPassword", getEmpPassword());
			se.put("ed1", getEd1());
			return "LoginSuccess";
		} else {
			setLoginStatus("Invalid User !!");
			return "InvalidUser";
		}
	}

	@Override
	public void validate() {
		if ((getEmpNo().equals(""))) {
			addFieldError("EmpNo", "Please Fill Employee No. !!");
		}

		if ((getEmpPassword().equals(""))) {
			addFieldError("EmpPassword", "Please Fill Employee Password !!");
		}

	}
	public String getEmpPassword() {
		return EmpPassword;
	}
	public void setEmpPassword(String empPassword) {
		EmpPassword = empPassword;
	}
	
}
