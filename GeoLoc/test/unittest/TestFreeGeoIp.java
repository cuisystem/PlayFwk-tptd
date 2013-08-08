package unittest;

import models.IpModel;
import models.IpModelDeserializer;

import org.junit.Before;
import org.junit.Test;

import play.libs.F.Promise;
import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.test.UnitTest;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;


public class TestFreeGeoIp extends UnitTest {

	private IpModelDeserializer deserializer = new IpModelDeserializer();
	
	private IpModel getModel(final String ip) {
		HttpResponse response =	WS.url("http://freegeoip.net/json/" + ip).get();
		assertEquals(200, response.getStatus().intValue());
		JsonElement jsonElement = response.getJson();
		return deserializer.deserialize(jsonElement, IpModel.class, null);

	}
	
	@Test
	public void testIpPersonnel() {
		String myIp = "81.56.136.14";
		IpModel ipModel = getModel(myIp);
		assertEquals(myIp, ipModel.getIp());
		
	}
	
	@Test
	public void testNominal() {
		String myIp = "78.225.149.183";
		IpModel ipModel = getModel(myIp);
		System.out.println("Debug : " + ipModel.toString() );
		assertEquals(myIp, ipModel.getIp());
		
	}

}
