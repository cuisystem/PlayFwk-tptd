package models;



/**
 * Pojo représentant le modèle côté Java de l'URL freegoip.net
 * @author cui
 *
 */
public class IpModel {

	private String ip;
	private String countryCode;
	private String regionCode;
	private String regionName;
	private String city;
	private String zipCode;
	private String latitude;
	private String longitude;
	private String metroCode;
	private String areaCode;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getMetroCode() {
		return metroCode;
	}
	public void setMetroCode(String metroCode) {
		this.metroCode = metroCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	@Override
	public String toString() {
		return "IpModel [ip=" + ip + ", countryCode=" + countryCode
				+ ", regionCode=" + regionCode + ", regionName=" + regionName
				+ ", city=" + city + ", zipCode=" + zipCode + ", latitude="
				+ latitude + ", longitude=" + longitude + ", metroCode="
				+ metroCode + ", areaCode=" + areaCode + "]";
	}
	

	
	
}
