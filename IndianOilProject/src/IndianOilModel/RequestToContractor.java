package IndianOilModel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RequestToContractor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Pk;
	private String Empno;
	@Lob
	private String EmpAddress;
	private String EmpName;
	private String EmpMobileNo;
	@Lob
	private String EmpPurpose;
	@Temporal(TemporalType.DATE)
	private Date CarReportingDate;
	private String CarReportingTime;
	private String CarName;
	private String CarType;
	private String RequestStatus;
	
	private String DateofBookingRequest;
	private String AdminName;
	private String AdminContact;
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
	private String ContractorId;
	private String TripInKms;
	private String DropAtStation;
	private String AdminRequeststatus;
	public long getPk() {
		return Pk;
	}
	public void setPk(long pk) {
		Pk = pk;
	}
	public String getEmpno() {
		return Empno;
	}
	public void setEmpno(String empno) {
		Empno = empno;
	}
	public String getEmpAddress() {
		return EmpAddress;
	}
	public void setEmpAddress(String empAddress) {
		EmpAddress = empAddress;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpMobileNo() {
		return EmpMobileNo;
	}
	public void setEmpMobileNo(String empMobileNo) {
		EmpMobileNo = empMobileNo;
	}
	public String getEmpPurpose() {
		return EmpPurpose;
	}
	public void setEmpPurpose(String empPurpose) {
		EmpPurpose = empPurpose;
	}
	public Date getCarReportingDate() {
		return CarReportingDate;
	}
	public void setCarReportingDate(Date carReportingDate) {
		CarReportingDate = carReportingDate;
	}
	public String getCarReportingTime() {
		return CarReportingTime;
	}
	public void setCarReportingTime(String carReportingTime) {
		CarReportingTime = carReportingTime;
	}
	public String getCarName() {
		return CarName;
	}
	public void setCarName(String carName) {
		CarName = carName;
	}
	public String getCarType() {
		return CarType;
	}
	public void setCarType(String carType) {
		CarType = carType;
	}
	public String getRequestStatus() {
		return RequestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		RequestStatus = requestStatus;
	}
	public String getDateofBookingRequest() {
		return DateofBookingRequest;
	}
	public void setDateofBookingRequest(String dateofBookingRequest) {
		DateofBookingRequest = dateofBookingRequest;
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
