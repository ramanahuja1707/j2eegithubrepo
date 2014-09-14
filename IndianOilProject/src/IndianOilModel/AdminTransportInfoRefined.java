package IndianOilModel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AdminTransportInfoRefined {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long AdminPk;
	private String EmpNo;
	private String TripInKms;
	private String DropAtStation;
	private String AdminName;
	private String AdminContact;
	private String ContractorId;
	private String AdminRequeststatus;
	@Temporal(TemporalType.DATE)
	private Date d;
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public long getAdminPk() {
		return AdminPk;
	}
	public void setAdminPk(long adminPk) {
		AdminPk = adminPk;
	}
	public String getEmpNo() {
		return EmpNo;
	}
	public void setEmpNo(String empNo) {
		EmpNo = empNo;
	}
	public String getTripInKms() {
		return TripInKms;
	}
	public void setTripInKms(String tripInKms) {
		TripInKms = tripInKms;
	}
	public String getDropAtStation() {
		return DropAtStation;
	}
	public void setDropAtStation(String dropAtStation) {
		DropAtStation = dropAtStation;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminContact() {
		return AdminContact;
	}
	public void setAdminContact(String adminContact) {
		AdminContact = adminContact;
	}
	public String getContractorId() {
		return ContractorId;
	}
	public void setContractorId(String contractorId) {
		ContractorId = contractorId;
	}
	public String getAdminRequeststatus() {
		return AdminRequeststatus;
	}
	public void setAdminRequeststatus(String adminRequeststatus) {
		AdminRequeststatus = adminRequeststatus;
	}
	
	
}
