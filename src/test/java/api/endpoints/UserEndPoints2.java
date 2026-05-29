package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*UserEndPoints.java 
 --> Created for perform Create, Read, Update, Delete requests the User API's
*/

public class UserEndPoints2 {

	// Method created for getting the URL's from properties file
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load the properties file
		return routes;
	}

	public static Response CreateUser(User payload) {
		String post_url = getURL().getString("post_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(post_url);
		return response;
	}

	public static Response ReadUser(String userName) {
		String get_url = getURL().getString("get_url");
		Response response = given().pathParam("username", userName).when().get(get_url);
		return response;
	}

	public static Response UpdateUser(String userName, User payload) {
		String put_url = getURL().getString("put_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().get(put_url);
		return response;
	}

	public static Response DeleteUser(String userName) {
		String delete_url = getURL().getString("delete_url");
		Response response = given().pathParam("username", userName).when().get(delete_url);
		return response;
	}

}
