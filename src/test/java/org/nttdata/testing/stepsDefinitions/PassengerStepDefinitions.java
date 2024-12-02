package org.nttdata.testing.stepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.nttdata.testing.tasks.DeletePassenger;
import org.nttdata.testing.tasks.PatchPassenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PassengerStepDefinitions {

    public static Logger LOGGER = LoggerFactory.getLogger(AirlineStepDefinitions.class);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el {actor} establece el endpoint para obtener los pasajeros")
    public void elActorEstableceElEndpointParaObtenerLosPasajeros(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }


    @When("el envia el id {string} con el nombre {string} que se va a modificar")
    public void elEnviaElIdConElNombreQueSeVaAModificar(String _id, String name) {
        theActorInTheSpotlight().attemptsTo(PatchPassenger.fromPage(_id, name));
    }

    @When("el envia el id {string} del dicho pasajero que se va a eliminar")
    public void elEnviaElIdDelDichoPasajeroQueSeVaAEliminar(String _id) {
        theActorInTheSpotlight().attemptsTo(DeletePassenger.fromPage(_id));
    }
}
