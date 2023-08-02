package org.exito.com.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JSClickOnTarget;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.userInterface.ListaDeProductosPage;
import org.exito.com.util.Utilitarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarUnProductoAleatoriamente implements Task {

    Logger logger = LoggerFactory.getLogger(SeleccionarCategoria.class);

    public static SeleccionarUnProductoAleatoriamente seleccionar() {
        return Tasks.instrumented(SeleccionarUnProductoAleatoriamente.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(ListaDeProductosPage.contenedorDeProductos, isVisible()));
        int aleatorio = Utilitarios.generarNumeroAleatorio(1, 4);
        WebElementFacade elemento = ListaDeProductosPage.productos.of(String.valueOf(aleatorio)).resolveFor(actor);

        BrowseTheWeb.as(actor).evaluateJavascript("return arguments[0].outerHTML",elemento);
        actor.attemptsTo(Click.on(elemento));
        logger.info("El producto {} fue seleccionado", elemento.getValue());
    }
}
