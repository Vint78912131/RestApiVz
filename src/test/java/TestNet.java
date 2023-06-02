import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestNet {

    @BeforeEach
    public void preparation() {
        TestVz.setCookies();
//        TestServer.getServerList();
    }

    @Test
    @DisplayName("Add new network device")
    @Epic(value = "Virtualization")
    @Story("Network")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#8ba8cc0b-6f02-4283-ba15-eece006a9841")
    @Feature("Add new network device")
    @Description("Add new network device")
    @Severity(SeverityLevel.MINOR)
    @Step ("Добавить новый сетевой адаптер для ВМ.")
    @Order(1)
    public void addNetTest() {
        String mac = "";
        for (int i = 0; i < 12; i++) {
            int hex = (int) (Math.random() * 16);
            mac += mac + String.format("%02X%s", Integer.toString(hex, 16));;
        }
        System.out.println(mac);

        String requestBody = "{\n" +
                "\"enabled\":true,\n" +
                "\"network\":\"newtestnetwork\",\n" +
                "\"mac\":" + mac + "\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/2b938fc7-5abb-4d50-9273-6863d95d91f5/device/net");
        try {
            response.then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 200 OK")
            ;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestVz.getBody(response);
        }
    }

    @Test
    @DisplayName("Set new network device")
    @Epic(value = "Virtualization")
    @Story("Network")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#0df03b09-126b-445d-a71c-708218e17328")
    @Feature("Set new network device properties")
    @Description("Set new network device properties")
    @Severity(SeverityLevel.MINOR)
    @Step ("Изменение параметров сетевого адаптера для ВМ.")
    @Order(2)
    public void setNetTest() {
        String requestBody = "{\n" +
                "\"enabled\":true,\n" +
                "\"network\":\"check_set_network\",\n" +
                "\"mac\":\"023C42E8F444\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/2b938fc7-5abb-4d50-9273-6863d95d91f5/device/net/net1");
        try {
            response.then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 200 OK")
            ;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            TestVz.getBody(response);
        }
    }


}
