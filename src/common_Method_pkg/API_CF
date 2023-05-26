package common_Method_pkg;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;


public class API_Common_Functions {
	
	public static int res_statusCode(String baseURI,String req_body,String resource) {
	
	RestAssured.baseURI=baseURI;
	
	int statusCode=given().header("Content-type","application/json").body(req_body).when().post(resource).then().extract().response().statusCode();
	
	return statusCode;
	}
	
	
	
	public static String response_body(String baseURI,String req_body,String resource) {
	
	RestAssured.baseURI=baseURI;
	
	String res_body=given().header("Content-type","application/json").body(req_body).when().post(resource).then().extract().response().asString();
	return res_body;
    }
}
