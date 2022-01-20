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

    @Test
    public void createProduct(){

        String endPoint="http://localhost:8888/api_testing/product/create.php";

        String body =
        "{\n"
            + "\"name\": \"Water Bottle\",\n"
            + "\"description\": \"Blue water bottle. Holds 64 ounces\",\n"
            + "\"price\": 12,\n"
            + "\"category_id\": 3\n"
            + "}";

        var response = given()
                .body(body).when().post(endPoint).then();

        response.log().body();

    }

    @Test
    public void updateProduct(){

        String endPoint="http://localhost:8888/api_testing/product/update.php";

        String body =
                "{\n"
                        + "\"id\": \"19\",\n"
                        + "\"description\": \"red water bottle. Holds 64 ounces\",\n"
                        + "\"price\": 12,\n"
                        + "\"category_id\": 3\n"
                        + "}";

        var response =
                given()
                .body(body)
                .when().put(endPoint)
                .then();

        response.log().body();

    }

    @Test
    public void deleteProduct(){

        String endPoint="http://localhost:8888/api_testing/product/delete.php";

        String body= "{\n"
                + "\"id\": \"19\""
                + "}";

        var response = given().body(body).when().delete(endPoint).then();
        response.log().body();


    }

}
