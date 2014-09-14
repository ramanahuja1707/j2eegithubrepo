package IndianOilModel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ContractorApprovedData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ContractorPk;
	private String Empno;
	
	private String ContractorId;
	private String ContractorName;
	private String CarNo;
	private String CarName;
	private String CarType;
	private String StartingReading;
	private String EndingReading;
	private String TotalKms;
	private String TotalTimeTaken;
	private String DriverName;
	private String DriverContact;
	@Temporal(TemporalType.DATE)
	private Date d;
	public String getEmpno() {
		return Empno;
	}

	public void setEmpno(String empno) {
		Empno = empno;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	public String getCarName() {
		return CarName;
	}

	public void setCarName(String carName) {
		CarName = carName;
	}

	public long getContractorPk() {
		return ContractorPk;
	}

	public void setContractorPk(long contractorPk) {
		ContractorPk = contractorPk;
	}

	public String getContractorId() {
		return ContractorId;
	}

	public void setContractorId(String contractorId) {
		ContractorId = contractorId;
	}

	public String getContractorName() {
		return ContractorName;
	}

	public void setContractorName(String contractorName) {
		ContractorName = contractorName;
	}

	public String getCarNo() {
		return CarNo;
	}

	public void setCarNo(String carNo) {
		CarNo = carNo;
	}
	public String getCarType() {
		return CarType;
	}

	public void setCarType(String carType) {
		CarType = carType;
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

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public String getDriverContact() {
		return DriverContact;
	}

	public void setDriverContact(String driverContact) {
		DriverContact = driverContact;
	}
}
