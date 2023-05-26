import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    public void addNetTest() {
        String requestBody = "{\n" +
                "\"enabled\":false,\n" +
                "\"network\":\"testnetwork\",\n" +
                "\"mac\":\"001C000C55EC\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/1a35c40d-47f4-4437-a82c-137eec60f630/device/net");
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
    public void setNetTest() {
        String requestBody = "{\n" +
                "\"enabled\":true,\n" +
                "\"network\":\"check_set_network\",\n" +
                "\"mac\":\"123C42E8F444\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/1a35c40d-47f4-4437-a82c-137eec60f630/device/net/net1");
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
