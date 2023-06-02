import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestVirtualMachineStats {

    @BeforeAll
    public static void preparation() {
        TestVz.setCookies();
//        TestServer.getServerList();
    }

    @Test
    @DisplayName("Get CPU VM statistics")
    @Epic(value = "Virtualization")
    @Story("Statistic")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#b7332745-b96f-495e-924e-b238a5dbc976")
    @Feature("Get CPU VM statistics")
    @Description("Get CPU VM statistics")
    @Severity(SeverityLevel.TRIVIAL)
    @Step ("Получить статистику работы процессора ВМ на сервере.")
    public void getCpuStatisticTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .param("from","2023-05-16T08:00:00")
                .param("to","2023-05-17T12:00:00")
                .when()
                .get("/vm/3309ce1b-6414-fc4c-ae67-b66e17951d58/statistics/cpu");
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
    @DisplayName("Get memory VM statistics")
    @Epic(value = "Virtualization")
    @Story("Statistic")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#cde93001-f846-4d06-8b51-d3821eba2d33")
    @Feature("Get memory VM statistics")
    @Description("Get memory VM statistics")
    @Severity(SeverityLevel.TRIVIAL)
    @Step ("Получить статистику использования памяти ВМ на сервере.")
    public void getMemStatisticTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .param("from","2023-05-16T08:00:00")
                .param("to","2023-05-17T12:00:00")
                .when()
                .get("/vm/3309ce1b-6414-fc4c-ae67-b66e17951d58/statistics/mem");
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
    @DisplayName("Get network VM statistics")
    @Epic(value = "Virtualization")
    @Story("Statistic")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#1408fcdf-4775-4f50-85af-946956ce12b1")
    @Feature("Get network VM statistics")
    @Description("Get network VM statistics")
    @Severity(SeverityLevel.TRIVIAL)
    @Step ("Получить статистику сети ВМ на сервере.")
    public void getNetStatisticTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .param("from","2023-05-16T08:00:00")
                .param("to","2023-05-17T12:00:00")
                .when()
                .get("/vm/3309ce1b-6414-fc4c-ae67-b66e17951d58/statistics/net");
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
    @DisplayName("Get disk VM statistics")
    @Epic(value = "Virtualization")
    @Story("Statistic")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#ebc57165-8090-4b15-8cc7-16c1d96bccdd")
    @Feature("Get disk VM statistics")
    @Description("Get disk VM statistics")
    @Severity(SeverityLevel.TRIVIAL)
    @Step ("Получить статистику работы дисков ВМ на сервере.")
    public void getDiskStatisticTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .param("from","2023-05-16T08:00:00")
                .param("to","2023-05-17T12:00:00")
                .when()
                .get("/vm/3309ce1b-6414-fc4c-ae67-b66e17951d58/statistics/disk");
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
