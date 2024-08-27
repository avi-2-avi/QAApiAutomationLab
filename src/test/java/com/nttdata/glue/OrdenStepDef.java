package com.nttdata.glue;

import com.nttdata.steps.OrdenStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrdenStepDef {
    @Steps
    OrdenStep orden;

    @Given("creo la orden con el status {string}")
    public void creoLaOrdenConElStatus(String status) {
        orden.crearOrden(status);
    }

    @When("obtengo el código de respuesta")
    public void obtengoElCodigoDeRespuesta() {
        orden.obtenerCodigoRespuesta();
    }

    @Then("el código de respuesta debe ser {int}")
    public void elCodigoDeRespuestaDebeSer(int statusCode) {
        orden.validarCodigoRespuesta(statusCode);
    }

    @And("el status de la orden debe ser {string}")
    public void elStatusDeLaOrdenDebeSer(String status) {
        orden.validarStatus(status);
    }

    @Given("hago la consulta de la orden con el id {string}")
    public void hagoLaConsultaDeLaOrdenConElId(String id) {
        orden.consultarOrden(id);
    }

    @And("el body de la respuesta debe estar completo")
    public void elBodyDeLaRespuestaDebeEstarCompleto() {
        orden.validarBody();
    }
}
