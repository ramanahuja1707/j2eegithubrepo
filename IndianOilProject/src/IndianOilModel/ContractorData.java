package IndianOilModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContractorData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ContractorPk;
	private String ContractorId;
	private String ContractorName;
	private String ContractorEmail;
	private String ContractorContactNo;
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
	public String getContractorEmail() {
		return ContractorEmail;
	}
	public void setContractorEmail(String contractorEmail) {
		ContractorEmail = contractorEmail;
	}
	public String getContractorContactNo() {
		return ContractorContactNo;
	}
	public void setContractorContactNo(String contractorContactNo) {
		ContractorContactNo = contractorContactNo;
	}
}
