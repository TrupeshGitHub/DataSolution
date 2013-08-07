package contactInformation;

/**
 *  
 * @author harsh
 * A structure to contain address of the contact
 */
public class Address {

	/**
	 *  street line 1
	 */
	private String streetLine1;
	/**
	 *  street line 2
	 */
	private String streetLine2;
	/**
	 *  city of residence
	 */
	private String city;
	/**
	 *  state of residence
	 */
	private String state;
	/**
	 *  country of residence
	 */
	private String country;
	/**
	 *  postal code of the address
	 */
	private int postalCode;
	
	public String getStreetLine1() {
		return streetLine1;
	}
	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}
	public String getStreetLine2() {
		return streetLine2;
	}
	public void setStreetLine2(String streetLine2) {
		this.streetLine2 = streetLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalode) {
		this.postalCode = postalode;
	}
	/**
	 * This method will specially be used for navigation purpose as the maps APIs expect the complete address
	 * @return completeAddress of the contact 
	 */
	public String getCompleteAddress(){
		return (this.getStreetLine1()+","+this.getStreetLine2()+","+this.getCity()+","+this.getState()+","+this.getCountry()+" "+this.getPostalCode());
	}	
	
}
