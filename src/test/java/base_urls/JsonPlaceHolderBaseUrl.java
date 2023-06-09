package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.runner.Request;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification spec;

    @Before // Her test methodundan once calisir.
    public void setUp() {
        spec = new RequestSpecBuilder().setAccept(ContentType.JSON).setBaseUri("https://jsonplaceholder.typicode.com").build();
    }

}
