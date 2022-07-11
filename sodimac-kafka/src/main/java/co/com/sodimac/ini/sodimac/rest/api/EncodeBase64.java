package co.com.sodimac.ini.sodimac.rest.api;



import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class EncodeBase64 {
	
	
	private String body;
	
	public EncodeBase64() {
		//TODO Auto-generated constructor stub
	}

	
	
	public String enconde(String bodyparam)
	{
		String jsonFinal="";
		try {
			System.out.println("entra");
			body=bodyparam;
			jsonFinal=convertBodyEnconde(body);
			System.out.println("mi body "+jsonFinal);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return jsonFinal;
	}
	
	public String encondeV2()
	{
		String jsonFinal="";
		try {
			System.out.println("entra");
			body="{}";
			jsonFinal=convertBodyEnconde(body);
			System.out.println("mi body "+jsonFinal);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return jsonFinal;
	}
	
	
	
	private String convertBodyEnconde(String body) 
	{	JSONObject jsonOb;
		try {
			String encodedString = Base64.encodeBase64String(body.getBytes());
			System.out.println("encoded "+encodedString);
			//jsonOb=new JSONObject("{\\\"records\\\":[{\\\"key\\\":\\\"RecaudoComision\\\",\\\"value\\\":\\\" \\\"}]}\r\n"
				//	+ "");
			jsonOb=new JSONObject();
			
			JSONArray jsonArr=new JSONArray();
			JSONObject jsonReg=new JSONObject();
			jsonReg.put("key","RecaudoComision" );
			jsonReg.put("value",encodedString );
			jsonArr.put(jsonReg);
			
			jsonOb.put("records",jsonArr);
			//System.out.println(jsonOb.getClass() + " "+jsonOb.toString());
			System.out.println("encode base 64 "+jsonOb.toString());
			return jsonOb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "error";
		
	}
	
	
	public String getBody() {
		return body;
		
	}

	public void setBody(String body) {
		this.body = body;
		
	}
	

}
