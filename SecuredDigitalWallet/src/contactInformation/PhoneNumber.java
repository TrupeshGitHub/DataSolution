package contactInformation;

public class PhoneNumber {

	/**
	 * enum to hold the phone type 
	 */
	public enum phoneType {office, mobile, fax, pager,other};
	/**
	 * phone number
	 */
	private long contactNumber;
	
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}
