package tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import userinterfaces.ResultSearch;
import util.ConvertDate;
import util.ReplacePrice;

import java.util.Collections;
import java.util.List;

import static userinterfaces.ResultSearch.BOTTON_PRICE;

public class ValidatePrice implements Task {
    private String checkIn;
    private String checkOut;



    public ValidatePrice() {
    }

    public ValidatePrice newIntance(){
        ValidatePrice validate = new ValidatePrice();
        return validate;

    }

    public ValidatePrice(String checkIn, String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    @Step("{0} chose a most cheap option")
    public <T extends Actor> void performAs(T actor) {

        List<Integer> prices = ReplacePrice.change(ResultSearch.PRICE, actor);
        Collections.sort(prices);
        float pagePrice = operation(prices.get(0), ConvertDate.returnTotalDays(checkIn, checkOut));
        actor.attemptsTo(Click.on(BOTTON_PRICE.of(prices.get(0).toString())));

        Serenity.setSessionVariable("pagePrice").to(pagePrice);

    }


    public static ValidatePrice with(String checkIn, String checkOut) {

        return Tasks.instrumented(ValidatePrice.class, checkIn, checkOut);
    }

    private float operation(float price, float days) {

        return price * days;
    }

}
