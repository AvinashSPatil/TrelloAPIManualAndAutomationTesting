import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class Trello_App {
	

	@Test
	public void RegistrationSuccessful()
	{ 
	 String url= "https://api.trello.com/1/cards";
	 RestAssured.baseURI ="https://api.trello.com/1/cards";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("name", "User123");
	 requestParams.put("idList", "5caaf78fdfe10709193b63b8");
	 requestParams.put("keepFromSource", "all");
	 requestParams.put("key", " b67f24ac8f8e7b381d4f0239f6b0da81");
	 requestParams.put("token", "812df675872b6a04d91931d5707d3fdbbb642252f8d35d2e696f1753d0bc7bd0");
	 
	 request.body(requestParams.toJSONString());
	 Response response = request.post();
	 
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode, "200");
	 String successCode = response.jsonPath().get("SuccessCode");
	 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
	
	@AfterTest
	public void getCard()
	
	{
		
		 // Specify the base URL to the RESTful web service
		 RestAssured.baseURI = "https://api.trello.com/1/cards/5caaf82ec1468412bca4b043?attachments=false&attachment_fields=all&members=false&membersVoted=false&checkItemStates=false&checklists=none&checklist_fields=all&board=false&list=false&pluginData=false&stickers=false&sticker_fields=all&customFieldItems=false&key=b67f24ac8f8e7b381d4f0239f6b0da81&token=812df675872b6a04d91931d5707d3fdbbb642252f8d35d2e696f1753d0bc7bd0";
		 
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a request to the server by specifying the method Type and the method URL.
		 // This will return the Response from the server. Store the response in a variable.
		 Response response = httpRequest.request(Method.GET, "/5caaf82ec1468412bca4b043");
		 
		 // Now let us print the body of the message to see what response
		 // we have recieved from the server
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		 
		
	}
	
	@AfterClass
	public void DeleteCard()
	{

		 // Specify the base URL to the RESTful web service
		 RestAssured.baseURI = "https://api.trello.com/1/cards/5ca70845f9121c1dc939e65f?key=b67f24ac8f8e7b381d4f0239f6b0da81&token=812df675872b6a04d91931d5707d3fdbbb642252f8d35d2e696f1753d0bc7bd0''https://api.trello.com/1/cards/5ca70845f9121c1dc939e65f?key=b67f24ac8f8e7b381d4f0239f6b0da81&token=812df675872b6a04d91931d5707d3fdbbb642252f8d35d2e696f1753d0bc7bd0";
		 
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a request to the server by specifying the method Type and the method URL.
		 // This will return the Response from the server. Store the response in a variable.
		 Response response = httpRequest.request(Method.DELETE, "/5caaf82ec1468412bca4b043");
		 
		 // Now let us print the body of the message to see what response
		 // we have received from the server
		 String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		 
		
		
	}
	}
	
	
	
	 
	 
	 


