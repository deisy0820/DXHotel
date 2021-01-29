package tasks;

import interactions.JSClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.SearchHotel;

import static userinterfaces.SearchHotel.BOTTON_SEARCH;
import static userinterfaces.SearchHotel.DESTINATION;

public class EnterDataForSearchHotel implements Task {
    private String location;
    private String checkIn;
    private String checkOut;

    public EnterDataForSearchHotel(String location, String checkIn, String checkOut) {
        this.location = location;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

            actor.attemptsTo(
                    Click.on(SearchHotel.LOCATION),
                    Click.on(DESTINATION.of(location).resolveFor(actor)),
                    Enter.keyValues(checkIn).into(SearchHotel.CHECK_IN),
                    Enter.keyValues(checkOut).into(SearchHotel.CHECK_OUT));
                    actor.attemptsTo(WaitUntil.the(BOTTON_SEARCH, WebElementStateMatchers.isVisible()).forNoMoreThan(5000).seconds(),
                    Click.on(BOTTON_SEARCH));
    }
    public static EnterDataForSearchHotel of(String location, String checkIn, String checkOut) {

        return Tasks.instrumented(EnterDataForSearchHotel.class, location, checkIn, checkOut);
    }
}
