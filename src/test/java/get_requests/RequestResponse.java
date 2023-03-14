package get_requests;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    1) Postman manual API testi için kullanılır.
    2) API otomasyonu için Rest-Assured Library
    3) Ootomasyon kodlarının yazımı için şu adımları izliyoruz:
        a) Gereksinimleri anlama
        b) Test case' i yazma:
            - Test case'i yazmak icin "Gherkin Language" kullanıyoruz.
            x) Given: Ön kosullar --> Endpoint, body
            y) When: Islemler --> Get, Put, Delete....
            z) Then: Donutler --> Assert
            t) And : Coklu islemlerin art arda yazilacagi yerlerde kullanilir.
        c) Test kodunu yazarken su adimlari izleriz:
            i)    Set the URL
            ii)   Set the expected data  (API nin en zorlanilan yeri burasidir.)
            iii)  Send the request and get the response
            iv)   Do assertion
     */

    public static void main(String[] args) {

        String url = "https://restful-booker.herokuapp.com/booking/55";

        // Get request nasil yapilir:
        Response response = given().when().get(url);

        response.prettyPrint(); // prettyPrint() methodu response datayi JSON formatinda yazdirir.

        //Status Code nasil yazdirilir:
        System.out.println("Status Code : "+response.statusCode());

        //Content Type nasil yazdirilir:
        System.out.println("Content Type : "+response.contentType());

        //Status Line nasil yazdirilir:
        System.out.println("Status line : "+ response.statusLine());

        //Header nasil yazdirilir:
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Server"));

        //Headers nasil yazdirilir:
        System.out.println(response.headers());

        //Time nasil yazdirilir:
        System.out.println("Time : " +response.getTime());





    }
}
