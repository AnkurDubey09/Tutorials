
Narrative:
In order to expose zomato search API
As a QA team
I want to use Behaviour-Driven Development to test the API
					 
Scenario:  Zomato search API should be working fine.
Given the zomato developer seach api 
When i hit the search api with <qparam> <value>
Then status is 200 and content type is json
Then <expected_param> should have <expected_value>
Examples:
|qparam|value|expected_param|expected_value|
|count|10|results_shown|10|
|start|10|results_start|10|
|cuisines|100|restaurants[0].restaurant.cuisines|Desserts, Beverages|
|cuisines|100|restaurants[0].restaurant.R.res_id|19008392|
|cuisines|100|restaurants[0].restaurant.name|Scoops|
|cuisines|100|restaurants[0].restaurant.location.address|Ambedkar centre, Lakshmi talkies, Main road, Machilipatnam, Machilipatnam Locality, Machilipatnam|
|cuisines|100|restaurants[0].restaurant.location.locality|Machilipatnam Locality|
|cuisines|100|restaurants[0].restaurant.location.city|Machilipatnam|
|cuisines|100|restaurants[0].restaurant.location.city_id|11500|
|cuisines|100|restaurants[0].restaurant.location.country_id|1|
|cuisines|100|restaurants[0].restaurant.location.locality_verbose|Machilipatnam Locality, Machilipatnam|
|cuisines|100|restaurants[0].restaurant.price_range|1|
|cuisines|100|restaurants[0].restaurant.currency|Rs.|
|cuisines|100|restaurants[0].restaurant.user_rating.aggregate_rating|4.1|
|cuisines|100|restaurants[0].restaurant.user_rating.rating_text|Very Good|
|cuisines|100|restaurants[0].restaurant.user_rating.rating_color|5BA829|
|cuisines|100|restaurants[0].restaurant.user_rating.votes|23|



