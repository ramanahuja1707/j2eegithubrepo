package IndianOilModel;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeData {
	@Id
	private String Empno;
	private String EmpUnit;
	private String EmpContact;
	private String EmpEmail;
	private String EmpId;
	private String EmpName;
	private String EmpDesig;
	private char EmpGrade;
	private String EmpDept;
	private String EmpPassword;
	public String getEmpno() {
		return Empno;
	}
	public void setEmpno(String empno) {
		Empno = empno;
	}
	public String getEmpPassword() {
		return EmpPassword;
	}
	public void setEmpPassword(String empPassword) {
		EmpPassword = empPassword;
	}
	public String getEmpUnit() {
		return EmpUnit;
	}
	public void setEmpUnit(String empUnit) {
		EmpUnit = empUnit;
	}
	public String getEmpContact() {
		return EmpContact;
	}
	public void setEmpContact(String empContact) {
		EmpContact = empContact;
	}
	public String getEmpEmail() {
		return EmpEmail;
	}
	public void setEmpEmail(String empEmail) {
		EmpEmail = empEmail;
	}
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpDesig() {
		return EmpDesig;
	}
	public void setEmpDesig(String empDesig) {
		EmpDesig = empDesig;
	}
	public char getEmpGrade() {
		return EmpGrade;
	}
	public void setEmpGrade(char empGrade) {
		EmpGrade = empGrade;
	}
	public String getEmpDept() {
		return EmpDept;
	}
	public void setEmpDept(String empDept) {
		EmpDept = empDept;
	}
}
