package requestRepositoryPackage;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;

import CommonFunctionsPackage.Utility_CommonFunctions;

public class Post_req_repository {
	@BeforeTest
	public static String base_URI() 
	{
		String baseURI = "https://reqres.in/";
		return baseURI;
	}
	
	public static String post_resource() 
	{
		String resource ="api/register";
		return resource;
	}
	
	
	public static String post_req_tc1() throws IOException 
	{
		ArrayList<String> data=Utility_CommonFunctions.readdataexcel("Post_Test_Data", "Post_tc_1");
		String req_name=data.get(1);
		String req_job=data.get(2);
		String requestbody="{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"pistol\"\r\n"
				+ "}";
		return requestbody;
	}
}

