import io.qameta.allure.Attachment;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

public class TestVz {

    public static String endpoint = "http://192.168.12.40:80/";
    public static String jwtToken = null;
    public static String cookies = null;
    public static Integer cluster_id = null;
    public static String cluster_name = null;

    public static void setCookies () {
        RestAssured.baseURI = TestVz.endpoint;
        JSONObject requestBody = new JSONObject()
                .put("LoginPass", "1q2w3e")
                .put("LoginUser", "root");
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .post("/login/");

        try {
            response.then()
                    .assertThat()
                    .statusCode(201)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 201 Created");
            cookies = response.getDetailedCookies().toString();
            jwtToken = JsonPath.from(response.getBody().asString()).getString("payload.jwtToken");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Attachment(value = "Response", type = "application/json", fileExtension = ".txt")
    public static String getBody(Response response) {
        return response.getBody().prettyPrint();
    }
}