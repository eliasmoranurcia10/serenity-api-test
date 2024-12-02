package org.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeletePassenger implements Task {

    private final String _id;

    public DeletePassenger(String _id) {
        this._id = _id;
    }

    public static Performable fromPage(String _id){
        return instrumented(DeletePassenger.class, _id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from("/passenger/"+_id)
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .log().all()
                )
        );
    }
}
