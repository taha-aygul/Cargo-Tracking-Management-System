
public class Address {
	private String street_name;
	private String town_name;
	private String city_name;
	private String apartment_name;
	private String door_no;

	Address(String street_name,String town_name,String city_name,String apartment_name,String door_no){
		this.street_name=street_name;
		this.town_name=town_name;
		this.city_name=city_name;
		this.apartment_name=apartment_name;
		this.door_no=door_no;
	}
	
	public String getStreet_name() {
		return street_name;
	}
	public String getTown_name() {
		return town_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public String getApartment_name() {
		return apartment_name;
	}
	public String getDoor_no() {
		return door_no;
	}
	
	
}
