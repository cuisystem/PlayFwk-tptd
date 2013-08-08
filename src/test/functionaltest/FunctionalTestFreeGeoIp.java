package functionaltest;

import models.IpModel;
import models.IpModelDeserializer;
import models.ModelGoogle;
import models.Results;

import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

import com.google.gson.Gson;

public class FunctionalTestFreeGeoIp extends FunctionalTest {

	private static String serviceLocalisation = "/localisation.json/";
	private static String serviceFindAdress = "/findAdress/";
	private static String ipPersonnal = "81.56.136.14";
	private static String ipReference = "78.225.149.183";

	private IpModelDeserializer deserializer = new IpModelDeserializer();

	private IpModel getModel(final String ip) {
		String args = "json," + ip;

		Response res = GET(serviceLocalisation + args);
		assertIsOk(res);
		assertContentType("application/json", res);
		String reponse = getContent(res);
		System.out.println(reponse);
		Gson gson = new Gson();
		return gson.fromJson(reponse, IpModel.class);
	}

	@Test
	public void testLocalisationIpPersonnel() {
		IpModel ipModel = getModel(ipPersonnal);
		assertEquals(ipPersonnal, ipModel.getIp());
		// TODO Others checks
	}

	@Test
	public void testLocalisationNominal() {
		IpModel ipModel = getModel(ipReference);
		assertEquals(ipReference, ipModel.getIp());
		// TODO Others checks
	}

	@Test
	public void testFindAdressIpNominal() {
		Response res = GET(serviceFindAdress + ipReference);
		assertIsOk(res);
		assertContentType("application/json", res);
		String reponse = getContent(res);
		System.out.println(reponse);
		Gson gson = new Gson();
		ModelGoogle modelGoogle = gson.fromJson(reponse, ModelGoogle.class);
		assertNotNull(modelGoogle);

		assertEquals("Pessac",
				((Results) modelGoogle.getResults().get(0))
						.getAddress_components()[2].getLong_name());
	}

}
