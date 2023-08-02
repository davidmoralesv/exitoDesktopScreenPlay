package org.exito.com.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.HoverOverBy;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.userInterface.StoreFrontPage;
import org.exito.com.util.Utilitarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarSubcategoria implements Task {
    Logger logger = LoggerFactory.getLogger(SeleccionarSubcategoria.class);

    private final String nombreSubcategoria;

    public SeleccionarSubcategoria(String nombreSubcategoria) {
        this.nombreSubcategoria = nombreSubcategoria;
    }

    public static SeleccionarSubcategoria seleccionar(String nombreSubcategoria) {
        return Tasks.instrumented(SeleccionarSubcategoria.class, nombreSubcategoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).setImplicitTimeout(20, ChronoUnit.SECONDS);
        int aleatorio = Utilitarios.generarNumeroAleatorio(0, StoreFrontPage.subcategoria.resolveAllFor(actor).size() - 1);
        actor.attemptsTo(Click.on(StoreFrontPage.subcategoria.resolveAllFor(actor).get(aleatorio)));
        BrowseTheWeb.as(actor).setImplicitTimeout(10, ChronoUnit.SECONDS);

        logger.info("Categoria aleatoria seleccionada");
    }
}
