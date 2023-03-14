package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Get03 {

    /*
    Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */

    @Test
    public void get03(){


        //Set the URL
        String url = "https://jsonplaceholder.typicode.com/todos/23";

        //Set the expected data

        //Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        //Do Assertion

        //1.yol  - hard assertion
        response.
                then().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).    //“title” is “et itaque necessitatibus maxime molestiae qui quas velit”
                body("completed",equalTo(false)).   //“completed” is false
                body("userId",equalTo(2));  //“userId” is 2


        //2.yol - soft assertion   (body kisminda title testi fail de olsa digerleri calisacak. Hard assertion da fail oldugunda tum kod duracak)
        //                          body den once test fail ederse yine body calismaz.
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),
                        "userId",equalTo(2));

         // Tek body() methodu icerisinde coklu assertion yaparak soft assertion olusturabilirsiniz. Fail durumunda  body() icerisinde Java calismayi durdurmaz
         // Coklu body() methodu ile assertion yapildiginda fail durumunda Java bir sonraki body() methodu oncesi calismayi durdurur.
    }

}
