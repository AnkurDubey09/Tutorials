package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ZomatoSearchSteps {
	
	static Response response;
	
	@Given("the zomato developer seach api")
	public static void the_zomato_developer_seach_api() {
		RestAssured.baseURI = "https://developers.zomato.com";
	}
	
	@When("i hit the search api with $qparam $value")
	public static void i_hit_the_search_api_with_params(String qParam, int qValue) {
		System.out.println("QUERY PARAMS ARE --> "+qParam+" - "+qValue);
		response = given().headers("user-key", "7551e1b7aac1cb39267c91a92184885f").
				param("query", "gwalior").
				param(qParam, qValue).
				when().get("api/v2.1/search");
	}
	
	@Then("status is 200 and content type is json")
	public static void status_is_200_and_content_type_is_json() {
		response.then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	}
	
	@Then("$expected_param should have $expected_value")
	public static void result_should_have_total_results_start_shown(String expParam, String expValue) {
		String json = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(json);
		
		//assertThat("", hasSize(3));
		//assertThat((Integer) jsonPath.getJsonObject("restaurants[0].restaurant.user_rating.votes"),greaterThanOrEqualTo(20));
		//assertThat((String)jsonPath.getJsonObject("restaurants[0].restaurant.user_rating.rating_text"),containsString("Good"));
		
		if(expParam.contains("results_") || expParam.contains("_id") || expParam.contains("_range")) {
			int value = jsonPath.getJsonObject(expParam);
			assertThat(value, equalTo(Integer.parseInt(expValue)));
			assertThat(value, instanceOf(Integer.class));
		} /*
			 * else if(expParam.contains("_rating")) { float value =
			 * jsonPath.getJsonObject(expParam); assertThat(value,
			 * equalTo(Float.parseFloat(expValue))); }
			 */
		else {
			String value = jsonPath.getJsonObject(expParam);
			assertThat(value, equalTo(expValue));
			assertThat(value, instanceOf(String.class));
		}
		
		
		/*
		 * int resultsFound = jsonPath.getJsonObject("results_found"); int resultsStart
		 * = jsonPath.getJsonObject("results_start"); int resultsShown =
		 * jsonPath.getJsonObject("results_shown");
		 */
		/*
		 * assertThat(resultsFound, equalTo(total)); assertThat(resultsStart,
		 * equalTo(start)); assertThat(resultsShown, equalTo(shown));
		 */	
		
		
	}
	


}
