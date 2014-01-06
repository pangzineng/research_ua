package _uastringdotcom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import batch.common.UAReader;

public class UAStringCom implements UAReader {

	private static String root = "http://www.useragentstring.com/?getJSON=all&uas=";

	JSONParser parser;
	JSONObject object;
	
	
	public UAStringCom() {
		parser = new JSONParser();
	}

	@Override
	public void read(String ua) {
		//String ua = "Mozilla/5.0%20(iPad;%20CPU%20OS%205_1_1%20like%20Mac%20OS%20X)%20AppleWebKit/534.46%20(KHTML,%20like%20Gecko)%20CriOS/29.0.1547.11%20Mobile/9B206%20Safari/7534.48.3";
		CloseableHttpClient httpclient;
		HttpGet httpGet;
		CloseableHttpResponse response;
		
		try {
			httpclient = HttpClients.createDefault();
			httpGet = new HttpGet(root + ua);
			response = httpclient.execute(httpGet);

			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		    object = (JSONObject) parser.parse(br);
		    
		    response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String get(String name) {
		/**
		* k: agent_language			v: 
		* k: agent_version			v: --
		* k: os_producer			v: 
		* k: os_name				v: OS/2
		* k: os_versionNumber		v: 
		* k: agent_type				v: Browser
		* k: agent_languageTag		v: 
		* k: os_producerURL			v: 
		* k: os_versionName			v: 
		* k: linux_distibution		v: Null
		* k: agent_name				v: Safari
		* k: os_type				v: OS/2
	    */
		return (String) object.get(name);
	}
}
