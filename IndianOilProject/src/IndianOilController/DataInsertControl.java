package IndianOilController;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

import IndianOilModel.ContractorData;
import IndianOilModel.DriverData;
import IndianOilModel.EmployeeData;

public class DataInsertControl extends ActionSupport {
	@Override
	public String execute() throws Exception {
		EmployeeData ed = new EmployeeData();
		ed.setEmpContact("9599159814");
		ed.setEmpDept("HR");
		ed.setEmpDesig("DGM");
		ed.setEmpEmail("komalahuja188@gmail.com");
		ed.setEmpGrade('A');
		ed.setEmpName("komal Ahuja");
		ed.setEmpno("526853");
		ed.setEmpPassword("komal_ahuja");
		ed.setEmpUnit("HQ");
		ed.setEmpId("526853" + "HR");
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.save(ed);
		ses.getTransaction().commit();
		ses.close();
		return "success";

	}

	public String insertContractorDetail() {
		ContractorData cd = new ContractorData();
		cd.setContractorId("104F");
		cd.setContractorName("komal ahuja");
		cd.setContractorEmail("komalahuja0790@gmail.com");
		cd.setContractorContactNo("9999945678");
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.save(cd);
		ses.getTransaction().commit();
		ses.close();
		return "success";
	}
	public String insertDriverData()
	{
		DriverData d=new DriverData();
		d.setDriverContact("9811878978");
		d.setDriverEmail("ganesh45@gmail.com");
		d.setDriverName("ganesh");
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		ses.save(d);
		ses.getTransaction().commit();
		ses.close();
		return "success";
	}
}
