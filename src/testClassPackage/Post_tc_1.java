package testClassPackage;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctionsPackage.API_Common_Function;
import CommonFunctionsPackage.Utility_CommonFunctions;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Post_req_repository;

public class Post_tc_1 {
	@Test
	public static void execute() throws IOException {
	 for (int i=0; i<5; i++)
		{
		int res_status_code =API_Common_Function.response_statusCode(Post_req_repository.base_URI(),Post_req_repository.post_resource(),Post_req_repository.post_req_tc1());
		if (res_status_code==200) {
		
		 break;
		}
		else
		{
		 System.out.println("Correct status code is not found hence retrying the API");
		}
	 }
	}
	public static void validator(String responsebody, int res_status_code) throws IOException { 
	        //Parse response body
	       		JsonPath jspres = new JsonPath(responsebody);
	       		String res_id = jspres.getString("id");
	       		String res_token = jspres.getString("token");
	       		System.out.println(res_id);
	       		System.out.println(res_token);
	       		
	       		
	       		
	       		//Parse request body and its parameters
	       		JsonPath jspreq = new JsonPath(Post_req_repository.post_req_tc1());
	       		String req_email = jspreq.getString("email");
	       		String req_password = jspreq.getString("passward");
	       		System.out.println(req_email);
	       		System.out.println(req_password);
			  
	       	//validate response body parameters
	       		Assert.assertEquals(res_id, 4);
	       		Assert.assertEquals(res_token , "QpwL5tke4Pnpja7X4");
	       	
}
}
