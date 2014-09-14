package IndianOilModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DriverData {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long DriverPk;
private String DriverName;
private String DriverContact;
private String DriverEmail;
public String getDriverEmail() {
	return DriverEmail;
}
public void setDriverEmail(String driverEmail) {
	DriverEmail = driverEmail;
}
public long getDriverPk() {
	return DriverPk;
}
public void setDriverPk(long driverPk) {
	DriverPk = driverPk;
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
