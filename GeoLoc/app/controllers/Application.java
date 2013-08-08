package controllers;

import java.util.HashMap;
import java.util.Map;

import models.IpModel;
import models.IpModelDeserializer;
import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.mvc.Controller;
import play.mvc.Router;

import com.google.gson.JsonElement;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void page2() {
		render();
	}
	
	public static void localisation(String format, String ip) {
		renderJSON(getLocalisation(format, ip));
	}

	public static void findAdress(String ip) {
		IpModel model = getLocalisation("json", ip);
		String args = model.getLatitude() + "," + model.getLongitude()
				+ "&sensor=true";
		HttpResponse reponse = WS.url(GOOGLEAPI_URL_SERVER + args).get();
		if (reponse.getStatus().intValue() == 200) {
			renderJSON(reponse.getJson().toString());
		} // else code erreur!!!
	}
	
	private static IpModel getLocalisation(String format, String ip) {
		HttpResponse response = WS.url(FREEGEOIP_URL_SERVER + "/json/" + ip)
				.get();
		IpModel model = null;
		if (response.getStatus().intValue() == 200) { // HttpStatus = 200!
			JsonElement jsonElement = response.getJson();
			IpModelDeserializer deserializer = new IpModelDeserializer();
			model = deserializer.deserialize(jsonElement, IpModel.class, null);
		}
		return model;
	}
	private static String FREEGEOIP_URL_SERVER = "http://freegeoip.net/";
	private static String GOOGLEAPI_URL_SERVER = "http://maps.googleapis.com/maps/api/geocode/json?latlng=";

}