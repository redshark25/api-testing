package trainingxyz;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    public void getCatergoris(){

        String endPoint="http://localhost:8888/api_testing/product/read.php";
         var response =  given().when().get(endPoint).then();
        response.log().body();

    }

    @Test
    public void getProduct(){

        String endPoint="http://localhost:8888/api_testing/product/read_one.php";

        var response = given()
                .queryParam("id",2)
                .when()
                .get(endPoint)
                .then();
        response.log().body();
    }



}
