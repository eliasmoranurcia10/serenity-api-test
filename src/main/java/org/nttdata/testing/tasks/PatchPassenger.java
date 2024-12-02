package org.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PatchPassenger implements Task {

    private final String _id, name;

    public PatchPassenger(String _id, String name) {
        this._id = _id;
        this.name = name;
    }

    public static Performable fromPage(String _id, String name){
        return instrumented(PatchPassenger.class, _id, name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Patch.to("/passenger/"+_id)
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .body("{\n" +
                                "    \"name\": \""+ name+"\"\n" +
                                "}"
                        ).log().all()
                )
        );
    }

}
