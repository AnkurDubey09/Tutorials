package steps;

import static io.restassured.RestAssured.given;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ZomatoLocationSteps extends Steps{
	
	static Response response;
	
	@Given("the zomato developer location api")
	public static void the_zomato_developer_search_api() {
		
		RestAssured.baseURI = "https://developers.zomato.com";
		
	}
	
	@When("i hit the location api")
	public static void i_hit_the_search_api() {
		
		response = given().headers("user-key", "7551e1b7aac1cb39267c91a92184885f").
				param("query", "gwalior").
				when().get("api/v2.1/locations");
		
		
	}
	
	@Then("status is 200 and content type is json")
	public void status_is_200() {
		
		response.then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
		//System.out.println("RESPONSE IS >>>>> "+response.getBody().asString());
		
	}
	
	
	@Then("entity id is $ent_id")
	public static void entity_id_is(int entityId){
		
		String json = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(json);
		int entId = jsonPath.getJsonObject("location_suggestions[0].entity_id");
		System.out.println("ENTITY_ID is --> "+entId+" ==== "+entityId);
		
		//response.then().assertThat().body("location_suggestions[0].entity_id", equalTo(11337));
		assertThat(entId, equalTo(entityId));
		
	}

}
