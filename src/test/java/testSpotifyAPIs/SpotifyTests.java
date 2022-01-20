package testSpotifyAPIs;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpotifyTests {

    @Test
    public void callGetAnAlbum(){

        String endPoint="https://api.spotify.com/v1/albums/0sNOF9WDwhWunNAHPD3Baj";

        var response = given().auth().oauth2("BQA44b9xqyXKSEIcVNhoFmtG1L4QwU3jAPXybhHqmtS0-uSWuhwZcFAWpIVguJpiDogsx8o6dNluUsRtB1CSV_ylflLCrRxQcrXluftIwffhrQbYUZMg5tCoKTd4EJZEP0Pr44oYJCznsBNT7FrRoxe5ixqjOW8zCqSDAi5eQVcMFvs")
                .when().get(endPoint).then();

        response.log().body();

    }
}
