package tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import userinterfaces.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenPage implements Task {
    private PageObject page;
    public OpenPage(PageObject page) {
        this.page = page;
    }
    @Override
    @Step("{0} goes to #OpenTheBrowser")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(page));
    }
    public static OpenPage at(HomePage page)
    {
        return instrumented(OpenPage.class, page) ;
    }
}

