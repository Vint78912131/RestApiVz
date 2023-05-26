import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestDevice {
    @BeforeEach
    public void preparation() {
        TestVz.setCookies();
//        TestServer.getServerList();
    }

    @Test
    @DisplayName("Delete device")
    @Epic(value = "Virtualization")
    @Story("Device")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#e07bbfab-dd85-4ec7-ac06-caf792ccf312")
    @Feature("Delete device by name")
    @Description("Delete device by name")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удалить устройство ВМ по имени.")
    public void deleteDeviceTest() {
        String requestBody = "{\n" +
                "\"destroyImage\":true\n" +
                "}";
//        for HDD
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .delete("/vm/1a35c40d-47f4-4437-a82c-137eec60f630/device/net1");
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
