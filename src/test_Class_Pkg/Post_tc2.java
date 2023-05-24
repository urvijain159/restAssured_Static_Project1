package test_Class_Pkg;
import java.io.IOException;

import java.time.LocalDateTime;
import org.testng.Assert;

import common_Method_pkg.API_Common_Functions;
import common_Method_pkg.Utility_CommonFunctions;
import io.restassured.path.json.JsonPath;
import req_Repo_pkg.Post_request_Repo;

    public class Post_tc2 {
	  public static void executor_post() throws IOException {
	 	for(int i=0; i<4; i++)
		{
		
		 int statusCode=API_Common_Functions.res_statusCode(Post_request_Repo.base_URI(),
    		                     Post_request_Repo.post_req_tc2(),Post_request_Repo.post_resource());
  
           if(statusCode == 201)
           {
    	
                String res_body=API_Common_Functions.response_body(Post_request_Repo.base_URI(),
        		                  Post_request_Repo.post_req_tc2(),Post_request_Repo.post_resource());
                Post_tc2.post_res_validator(res_body,statusCode);
                Utility_CommonFunctions.creator("post_tc2", Post_request_Repo.post_req_tc2(), res_body);
                break;
        
           }
           else
           {
    	     System.out.println("Incorrect status code is found hence retrying the API");
           }
	
	     }	
	}
			
    public static void post_res_validator(String res_body,int statusCode) throws IOException {
		    	//Parse response body and its parameters
				JsonPath jspres=new JsonPath(res_body);
				String res_name=jspres.getString("name");
				String res_job=jspres.getString("job");
				String res_id=jspres.getString("id");
				String res_createdAt=jspres.getString("createdAt");
				
				String trim_date=res_createdAt.substring(0,10);
				System.out.println(res_name);
				System.out.println(res_job);
				System.out.println(res_id);
				System.out.println(res_createdAt);
				
				//generate date
			   LocalDateTime date=LocalDateTime.now();
			   String exp_date=date.toString().substring(0,10);
			   
			   
			  //parse request body and its parameters
			   JsonPath jspreq=new JsonPath (Post_request_Repo.post_req_tc2());
				String req_name=jspreq.getString("name");
				String req_job=jspreq.getString("job");
			
		    	//Validate the response
			   
			   Assert.assertEquals(statusCode,201);
			   Assert.assertEquals(req_name, res_name);
			   Assert.assertEquals(req_job, res_job);
			   Assert.assertNotNull(res_id);
			   Assert.assertEquals(trim_date, exp_date);
			   
			
			}

		}

