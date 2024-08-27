package com.nttdata.steps;

import com.nttdata.model.Orden;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class OrdenStep {
    private static String ORDER_URL = "https://petstore.swagger.io/v2/store/order";

    public void crearOrden(String status) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": 0,\n" +
                        "  \"quantity\": 0,\n" +
                        "  \"shipDate\": \"2021-09-01T15:00:00.000Z\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(ORDER_URL)
                .then()
                .log().all();
    }

    public void obtenerCodigoRespuesta() {
        System.out.println("Código de respuesta: " + SerenityRest.lastResponse().statusCode());
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }


    public void validarStatus(String status) {
        restAssuredThat(response -> response.body("'status'", org.hamcrest.Matchers.equalTo(status)));
        System.out.println("Status: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    public void consultarOrden(String id) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .get(ORDER_URL + "/" + id)
                .then()
                .log().all();
    }

    public void validarBody() {
        Orden orden = SerenityRest.lastResponse().as(Orden.class);
        System.out.println("Id: " + orden.getId());
        System.out.println("PetId: " + orden.getPetId());
        System.out.println("Quantity: " + orden.getQuantity());
        System.out.println("ShipDate: " + orden.getShipDate());
        System.out.println("Status: " + orden.getStatus());
        System.out.println("Complete: " + orden.isComplete());
    }
}
