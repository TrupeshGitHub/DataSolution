package contactInformation;

/**
 *  
 * @author harsh
 * A structure to contain address of the contact
 */
public class Address {

	public Address(String streetLine1, String streetLine2, String city,
			int state, int country, int postalode) {
		super();
		this.streetLine1 = streetLine1;
		this.streetLine2 = streetLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalode = postalode;
	}
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
	private int state;
	/**
	 *  country of residence
	 */
	private int country;
	/**
	 *  postal code of the address
	 */
	private int postalode;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public int getPostalode() {
		return postalode;
	}
	public void setPostalode(int postalode) {
		this.postalode = postalode;
	}
	/**
	 * This method will specially be used for navigation purpose as the maps APIs expect the complete address
	 * @return completeAddress of the contact 
	 */
	public String getCompleteAddress(){
		return (this.getStreetLine1()+","+this.getStreetLine2()+","+this.getCity()+","+this.getState()+","+this.getCountry()+" "+this.getPostalode());
	}	
	
}
