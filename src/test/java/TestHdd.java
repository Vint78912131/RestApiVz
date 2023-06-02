import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestHdd {

    @BeforeAll
    public static void preparation() {
        TestVz.setCookies();
//        TestServer.getServerList();
    }

    @Test
    @DisplayName("Add new HDD")
    @Epic(value = "Virtualization")
    @Story("Hdd")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#3d728ae3-7a8c-448b-8e77-72c8cb2a3b0d")
    @Feature("Add new HDD")
    @Description("Add new HDD")
    @Severity(SeverityLevel.MINOR)
    @Step ("Добавить новый HDD для ВМ.")
    @Order(1)
    public void addHddTest() {
        String requestBody = "{\n" +
                "\"deviceType\":\"expand\",\n" +
                "\"size\":100,\n" +
                "\"recreate\": false,\n" +
                "\"iface\": \"scsi\",\n" +
                "\"subtype\":\"virtio-scsi\",\n" +
                "\"enabled\":false,\n" +
                "\"connected\":true\n" +
                "}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/1a35c40d-47f4-4437-a82c-137eec60f630/device/hdd");
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
    @DisplayName("Set new HDD properties")
    @Epic(value = "Virtualization")
    @Story("Hdd")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#6b8d8942-019e-45fc-aa2c-0a6794d659cf")
    @Feature("Set new HDD properties")
    @Description("Set new HDD properties")
    @Severity(SeverityLevel.MINOR)
    @Step ("Изменение параметров HDD для ВМ.")
    @Order(2)
    public void setHddTest() {
        String requestBody = "{\n" +
                "\"deviceType\":\"plain\",\n" +
                "\"size\":200,\n" +
                "\"recreate\": true,\n" +
                "\"iface\": \"scsi\",\n" +
                "\"subtype\":\"hyperv\",\n" +
                "\"enabled\":true,\n" +
                "\"connected\":true\n" +
                "}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/1a35c40d-47f4-4437-a82c-137eec60f630/device/hdd/hdd1");
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
