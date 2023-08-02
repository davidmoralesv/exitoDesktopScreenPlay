package org.exito.com.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.userInterface.StoreFrontPage;
import org.exito.com.util.Utilitarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarSubcategoria implements Task {
    Logger logger = LoggerFactory.getLogger(SeleccionarSubcategoria.class);


    public static SeleccionarSubcategoria seleccionar() {
        return Tasks.instrumented(SeleccionarSubcategoria.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(StoreFrontPage.FILTRO_BUTTON, isPresent()));
        actor.attemptsTo(Scroll.to(StoreFrontPage.FILTRO_BUTTON));

        actor.attemptsTo(WaitUntil.the(StoreFrontPage.SUBCATEGORIA_ACCORDION, isPresent()));
        actor.attemptsTo(Click.on(StoreFrontPage.SUBCATEGORIA_ACCORDION));

        actor.attemptsTo(WaitUntil.the(StoreFrontPage.TELEVISORES_CAIXUM_CHECKBOX, isPresent()));
        actor.attemptsTo(CheckCheckbox.of(StoreFrontPage.TELEVISORES_CAIXUM_CHECKBOX));

        logger.info("Categoria aleatoria seleccionada");
    }
}
