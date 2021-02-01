package questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateTotalPrice implements Question<Boolean> {

    private float totalPrice;


    public ValidateTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        float price =Serenity.sessionVariableCalled("pagePrice");
        return price==totalPrice;
    }

    public static ValidateTotalPrice is(float totalPrice){
        return new ValidateTotalPrice(totalPrice);
    }
}
