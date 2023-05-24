package testClassPackage;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctionsPackage.API_Common_Function;
import CommonFunctionsPackage.Utility_CommonFunctions;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.Post_req_repository;

public class Post_tc_4 {
	@Test
	public static void execute() throws IOException {
		 for (int i=0; i<5; i++)
			{
			int res_status_code =API_Common_Function.response_statusCode(Post_req_repository.base_URI(),Post_req_repository.post_resource(),Post_req_repository.post_req_tc4());
			if (res_status_code==201)
			{
			 String responsebody = API_Common_Function.response_body(Post_req_repository.base_URI(), Post_req_repository.post_resource(),Post_req_repository.post_req_tc4());
			 Post_tc_4.validator(responsebody, res_status_code);
			 Utility_CommonFunctions.evidencefilecreator("Post_tc_4", Post_req_repository.post_req_tc4(), responsebody);
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
		       		String res_name = jspres.getString("name");
		       		String res_job = jspres.getString("job");
		       		String res_createdAt = jspres.getString("createdAt");
		       		String res_date = res_createdAt.substring(0, 10);
		       		System.out.println(res_name);
		       		System.out.println(res_job);
		       		System.out.println(res_createdAt);
		       		System.out.println(res_date);
		       		
		       		
		       		//Parse request body and its parameters
		       		JsonPath jspreq = new JsonPath(Post_req_repository.post_req_tc4());
		       		String req_name = jspreq.getString("name");
		       		String req_job = jspreq.getString("job");
				  
		       	//validate response body parameters
		       		Assert.assertEquals(req_name, res_name);
		       		Assert.assertEquals(req_job , res_job);
		       		
		       	//Date validation
		       		LocalDateTime Date = LocalDateTime.now();
			 		String sysdate = Date.toString().substring(0, 10);
		       		Assert.assertEquals(res_date, sysdate);
	}


}
