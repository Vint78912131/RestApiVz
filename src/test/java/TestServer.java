import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestServer {

    public static List<String> servers = new ArrayList<String>();

    public static List<String> srv_uuid = new ArrayList<>();
    @BeforeEach
    public void preparation() {
        TestVz.setCookies();
    }


    @Test
    @DisplayName("Get server list")
    @Epic(value = "Virtualization")
    @Story("Servers")
    @Link(name = "doc link", url = "    https://documenter.getpostman.com/view/607407/2s93CHtEzX#8c40979e-8025-41a6-b611-f41fe4ddc68b")
    @Feature("Get server list")
    @Description("Get server list")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список серверов кластера.")
    public void getServerListTest() {
        Response response = RestAssured
                .given()
                .header("Authorization",TestVz.jwtToken)
                .contentType("application/json")
                .when()
                .get("/srvs");
        try {
            response.then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 200 OK")
            ;
//            System.out.println(JsonPath.from(response.getBody().asString()).getString("payload.hosts[0].uuid"));
            String hosts = Arrays.toString((response.getBody()
                    .jsonPath().getList("payload.hosts")
                    .toString().replaceAll("\\[|\\]","")
                    .split(",")));


//            List <String> uuid = Collections.singletonList(JsonPath.from(hosts).get("uuid").toString());
            System.out.println(hosts);
//            for (String s : hosts) {
//                System.out.println(JsonPath.from(s).get("uuid"));
//            }

//            for (String s : books) {
//                srv_uuid.add(JsonPath.from(JSONObject.valueToString(s)).get("uuid").toString());
//                System.out.println(srv_uuid);
//            }
//            for (Object s : servers) {
//                System.out.println(s);
//                System.out.println();
//            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestVz.getBody(response);
        }
    }



}
