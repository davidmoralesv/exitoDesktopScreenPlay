package org.exito.com.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.userInterface.StoreFrontPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarCategoria implements Task {

    Logger logger = LoggerFactory.getLogger(SeleccionarCategoria.class);

    private final String nombreCategoria;

    public SeleccionarCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public static SeleccionarCategoria seleccionar(String nombreCategoria) {
        return Tasks.instrumented(SeleccionarCategoria.class, nombreCategoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(StoreFrontPage.categoria.of(this.nombreCategoria), isVisible()),
                Scroll.to(StoreFrontPage.categoria.of(this.nombreCategoria)));
        actor.attemptsTo(Click.on(StoreFrontPage.categoria.of(this.nombreCategoria)));

        logger.info("Categoria {} seleccionada", this.nombreCategoria);
    }
}
