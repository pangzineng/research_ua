package _uastringdotcom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		String root = "http://www.useragentstring.com/?getJSON=all&uas=";
		String ua = "Mozilla/5.0%20(iPad;%20CPU%20OS%205_1_1%20like%20Mac%20OS%20X)%20AppleWebKit/534.46%20(KHTML,%20like%20Gecko)%20CriOS/29.0.1547.11%20Mobile/9B206%20Safari/7534.48.3";
		JSONParser parser = new JSONParser();
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(root + ua);
		CloseableHttpResponse response = httpclient.execute(httpGet);

		try {
		    BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		    JSONObject object = (JSONObject) parser.parse(br);
		    
		    @SuppressWarnings("unchecked")
			Set<String> keySet = object.keySet();
		    
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
		    for( String key : keySet){
		    	System.out.println("k: " + key + "\t\t\tv: " + object.get(key));
		    }
		} finally {
		    response.close();
		}
	}
}
