import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSnapshot {
    @BeforeEach
    public void preparation() {
        TestVz.setCookies();
//        TestServer.getServerList();
    }
    @Test
    @DisplayName("Create snapshot VM")
    @Epic(value = "Virtualization")
    @Story("Snapshot")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#9c203aba-50c5-4883-895f-1ca123caa12b")
    @Feature("Create snapshot VM")
    @Description("Create snapshot VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Создание снапшота виртуальной машины на сервере.")
    public void createSnapshotVMTest() {
        String requestBody = "{\"name\":\"snap_name\",\"description\":\"test snapshot VM\"}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/snapshot");
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
    @DisplayName("Delete snapshot VM")
    @Epic(value = "Virtualization")
    @Story("Snapshot")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#2d2d9ac2-a85a-4baf-aae0-9c238ad9d70e")
    @Feature("Delete snapshot VM")
    @Description("Delete snapshot VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Удаление снапшота виртуальной машины на сервере.")
    public void deleteSnapshotVMTest() {
        String requestBody = "{\"children\":false}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .delete("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/snapshot/a649cecb-6601-44fd-a845-ff0f54698c37");
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
    @DisplayName("Switch snapshot VM")
    @Epic(value = "Virtualization")
    @Story("Snapshot")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#f900a807-f067-4704-8769-c9fc7a496249")
    @Feature("Switch snapshot VM")
    @Description("Switch snapshot VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Переключение снапшота виртуальной машины на сервере.")
    public void switchSnapshotVMTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .when()
                .post("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/snapshot/a649cecb-6601-44fd-a845-ff0f54698c37");
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
    @DisplayName("Get snapshot VM list")
    @Epic(value = "Virtualization")
    @Story("Snapshot")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#2a9cd371-81b0-4bfe-a02f-50324b9b00b2")
    @Feature("Get snapshot VM list")
    @Description("Get snapshot VM list")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получение списка снапшотов виртуальной машины на сервере.")
    public void getSnapshotVMListTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .when()
                .get("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/snapshot");
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
    @DisplayName("Get snapshot VM parametrs")
    @Epic(value = "Virtualization")
    @Story("Snapshot")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#83124d19-b484-4365-8db7-fdf245859daf")
    @Feature("Get snapshot VM parametrs")
    @Description("Get snapshot VM parametrs")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получение параметров снапшотов виртуальной машины на сервере.")
    public void getSnapshotVMParametersTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .when()
                .get("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/snapshot/5b5d23d4-57e5-4a00-9c63-2e3fc40222b4");
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
