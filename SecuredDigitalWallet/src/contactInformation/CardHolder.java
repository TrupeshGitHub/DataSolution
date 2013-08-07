package contactInformation;

/**
 * 
 * @author harsh
 * This class will be responsible for the structuring of information of the contacts.
 * Contacts here will refer to the
 */
public class CardHolder {

	/**
	 * First name of the contact 
	 */
	private String firstName;
	/**
	 * Middle name of the contact 
	 */
	private String middleName;
	/**
	 * Last name of the contact 
	 */
	private String lastName;
	/**
	 * Name of the company, the contact works with 
	 */
	private String firmName;
	/**
	 * Name of the company, the contact works with 
	 */
	private Address CompanyAddress;
	/**
	 * Name of the company, the contact works with 
	 */
	private PhoneNumber contactNumber;
	/**
	 * official email address of the contact 
	 */
	private String workEmail;
	/**
	 * personal email address of the contact 
	 */
	private String personalEmail;
	/**
	 * website address of the contact 
	 */
	private String website;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWorkEmail() {
		return workEmail;
	}
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getCompanyName() {
		return firmName;
	}
	public void setCompanyName(String companyName) {
		firmName = companyName;
	}
	public void setContactNumber(PhoneNumber contactNumber) {
		this.contactNumber = contactNumber;
	}
	public PhoneNumber getContactNumber() {
		return contactNumber;
	}
	public void setCompanyAddress(Address companyAddress) {
		CompanyAddress = companyAddress;
	}
	public Address getCompanyAddress() {
		return CompanyAddress;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getWebsite() {
		return website;
	}
}
