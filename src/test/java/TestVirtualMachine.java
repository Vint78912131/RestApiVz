import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class TestVirtualMachine {
    @BeforeEach
    public void preparation() {
        TestVz.setCookies();
//        TestServer.getServerList();
    }

    @Test
    @DisplayName("Get VM list")
    @Epic(value = "Virtualization")
    @Story("Virtual Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#45634f69-e090-4b48-b910-866c3e633274")
    @Feature("Get VM list")
    @Description("Get VM list")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить список виртуальных машин на сервере.")
    public void getVMListTest() {
                Response response = RestAssured
                        .given()
                        .header("Authorization", TestVz.jwtToken)
                        .contentType("application/json")
                        .when()
                        .get("/3309ce1b-6414-fc4c-ae67-b66e17951d58/vms");
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
    @DisplayName("Get all VM info")
    @Epic(value = "Virtualization")
    @Story("Virtual Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#928879e0-362e-46e1-ae60-800e027541f9")
    @Feature("Get all VM info")
    @Description("Get all VM info")
    @Severity(SeverityLevel.MINOR)
    @Step ("Получить детальную информацию о виртуальной машине на сервере.")
    public void getVMInfoTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .when()
                .get("/vm/1a35c40d-47f4-4437-a82c-137eec60f630");
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
    @DisplayName("Clone VM")
    @Epic(value = "Virtualization")
    @Story("Virtual Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#374319af-3e33-4790-9bee-cff185a80799")
    @Feature("Clone VM")
    @Description("Clone VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Клонирование виртуальной машины на сервере.")
    public void cloneVMTest() {
        String requestBody = "{\"name\":\"NewCloneTestVM\"}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/clone");
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
    @DisplayName("Move VM")
    @Epic(value = "Virtualization")
    @Story("Virtual Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#374319af-3e33-4790-9bee-cff185a80799")
    @Feature("Move VM")
    @Description("Move VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Перемещение образа виртуальной машины на сервере.")
    public void moveVMTest() {
        String requestBody = "{\"dst\":\"/home\"}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/move");
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
    @DisplayName("Stop VM")
    @Epic(value = "Virtualization")
    @Story("Virtual Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#c5717036-a201-44e9-9290-915dfd9410bf")
    @Feature("Stop VM")
    @Description("Stop VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Остановка виртуальной машины на сервере.")
    public void stopVMTest() {
        String requestBody = "{\"force\":false,\"acpi\":false,\"kill\":false}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/1a35c40d-47f4-4437-a82c-137eec60f630/stop");
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
    @DisplayName("Start VM")
    @Epic(value = "Virtualization")
    @Story("Virtual Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#9c9b8e71-a424-4886-8651-44a6bcf1dd22")
    @Feature("Start VM")
    @Description("Start VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Запуск виртуальной машины на сервере.")
    public void startVMTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .when()
                .post("/vm/1a35c40d-47f4-4437-a82c-137eec60f630/start");
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
    @DisplayName("Pause VM")
    @Epic(value = "Virtualization")
    @Story("Virtual Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#3dd2420c-bf98-4308-8d60-d66fa5acf1de")
    @Feature("Pause VM")
    @Description("Pause VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Остановка виртуальной машины на сервере.")
    public void pauseVMTest() {
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .when()
                .post("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/pause");
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
    @DisplayName("Resume VM")
    @Epic(value = "Virtualization")
    @Story("Virtual Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#95afe3ce-7e61-46b6-803a-4d18de7e1efa")
    @Feature("Resume VM")
    @Description("Resume VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Возобновление работы виртуальной машины на сервере.")
    public void resumeVMTest() {
        String requestBody = "{}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/resume");
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
    @DisplayName("Suspend VM")
    @Epic(value = "Virtualization")
    @Story("Virtual Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#ba333340-4750-4bcc-a246-f4edf222616d")
    @Feature("Suspend VM")
    @Description("Suspend VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Приостановка работы виртуальной машины на сервере.")
    public void suspendVMTest() {
        String requestBody = "{}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/suspend");
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
    @DisplayName("Migrate VM")
    @Epic(value = "Virtualization")
    @Story("Migrate Machine")
    @Link(name = "doc link", url = "https://documenter.getpostman.com/view/607407/2s93CHtEzX#ba333340-4750-4bcc-a246-f4edf222616d")
    @Feature("Migrate VM")
    @Description("Migrate VM")
    @Severity(SeverityLevel.MINOR)
    @Step ("Миграция виртуальной машины на другой сервер.")
    public void migrateVMTest() {
        String requestBody = "{\"dst\":\"192.168.12.142\"}";
        Response response = RestAssured
                .given()
                .header("Authorization", TestVz.jwtToken)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/vm/0beac2f3-98a6-4947-9273-5b253085bf3b/migrate");
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
