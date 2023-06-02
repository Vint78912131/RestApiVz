import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import java.util.*;

public class TestServer {

    public static List<String> servers = new ArrayList<String>();

    public static List<String> srv_uuid = new ArrayList<>();
    @BeforeAll
    public static void preparation() {
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

            JSONObject body = new JSONObject(response.getBody().asString());
            JSONArray hosts = body.getJSONObject("payloads.hosts").names();
//                    .replaceAll("\\/[|\\]","")
//                    .split(","))
                    ;

            System.out.println(hosts);
//            System.out.println(body);

//            List <String> uuid = Arrays.asList(JsonPath.from(hosts).get("uuid").toString());
//            System.out.println(hosts);
//            System.out.println(uuid);
//            for (Object s : hosts) {
//                System.out.println(s + " : " + s.getClass());
//                System.out.println((Map<String,String>)s.valueOf());
//                servers.add(s.toString());
//            }
//            System.out.println(servers);


            for (String s : servers) {
//                JSONObject json = new JSONObject(s);
//                System.out.println(json);
                System.out.println(s);
            }

//            System.out.println(srv_uuid);

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
