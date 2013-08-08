package models;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * Deserialiser pour la classe IpModel (transforme rerprésentation Json vers un objet IpModel).
 * @author cui
 *
 */
public class IpModelDeserializer implements JsonDeserializer<IpModel> {

	private static final String LONGITUDE = "longitude";
	private static final String LATITUDE = "latitude";
	private static final String ZIPCODE = "zipcode";
	private static final String CITY = "city";
	private static final String REGION_NAME = "region_name";
	private static final String REGION_CODE = "region_code";
	private static final String COUNTRY_CODE = "country_code";
	private static final String METRO_CODE = "metroCode";
	private static final String AREA_CODE = "areaCode";
	private static final String IP = "ip";

	@Override
	public IpModel deserialize(JsonElement json, Type type,
			JsonDeserializationContext context) throws JsonParseException {
		IpModel model = new IpModel();
		JsonObject jsonObject = json.getAsJsonObject();
		
		model.setIp(getProperty(jsonObject, IP));
		model.setCountryCode(getProperty(jsonObject, COUNTRY_CODE));
		model.setRegionCode(getProperty(jsonObject, REGION_CODE));
		model.setRegionName(getProperty(jsonObject, REGION_NAME));
		model.setCity(getProperty(jsonObject, CITY));
		model.setZipCode(getProperty(jsonObject, CITY));
		model.setLatitude(getProperty(jsonObject, LATITUDE));
		model.setLongitude(getProperty(jsonObject, LONGITUDE));
		model.setMetroCode(getProperty(jsonObject, METRO_CODE));
		model.setAreaCode(getProperty(jsonObject, AREA_CODE));
		
		return model;
	}
	
	private String getProperty(final JsonObject jsonObject, final String property) {
		return jsonObject.get(property) == null ? null : jsonObject.get(property).getAsString();
	}
		
}


