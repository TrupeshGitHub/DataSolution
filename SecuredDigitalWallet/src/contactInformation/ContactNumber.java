package contactInformation;

public class ContactNumber {

	public ContactNumber(long officeNumber, long mobileNumber, long faxNumber,
			long pagerNumber, long otherNumber) {
		super();
		this.officeNumber = officeNumber;
		this.mobileNumber = mobileNumber;
		this.faxNumber = faxNumber;
		this.pagerNumber = pagerNumber;
		this.otherNumber = otherNumber;
	}
	/**
	 * Official number of the contact 
	 */
	private long officeNumber;
	/**
	 * Mobile number of the contact 
	 */
	private long mobileNumber;
	/**
	 * Fax number of the contact 
	 */
	private long faxNumber;
	/**
	 * Pager number of the contact 
	 */
	private long pagerNumber;
	/**
	 * Any other number of the contact 
	 */
	private long otherNumber;
	
	public long getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(long officeNumber) {
		this.officeNumber = officeNumber;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public long getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(long faxNumber) {
		this.faxNumber = faxNumber;
	}
	public void setPagerNumber(long pagerNumber) {
		this.pagerNumber = pagerNumber;
	}
	public long getPagerNumber() {
		return pagerNumber;
	}
	public void setOtherNumber(long otherNumber) {
		this.otherNumber = otherNumber;
	}
	public long getOtherNumber() {
		return otherNumber;
	}
}
