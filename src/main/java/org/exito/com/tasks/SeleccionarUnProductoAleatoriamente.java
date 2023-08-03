package org.exito.com.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.userInterface.ListaDeProductosPage;
import org.exito.com.util.UnidadTiempo;
import org.exito.com.util.Utilitarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarUnProductoAleatoriamente implements Task {

    Logger logger = LoggerFactory.getLogger(SeleccionarCategoria.class);

    public static SeleccionarUnProductoAleatoriamente seleccionar() {
        return Tasks.instrumented(SeleccionarUnProductoAleatoriamente.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(ListaDeProductosPage.CONTENEDOR_DE_PRODUCTOS, isVisible()));
        int numeroProductos = ListaDeProductosPage.NUMERO_PRODUCTOS.resolveAllFor(actor).size();
        int aleatorio = Utilitarios.generarNumeroAleatorio(1, numeroProductos-5);
        new UnidadTiempo(TimeUnit.SECONDS).esperar(4);
        WebElementFacade elemento = ListaDeProductosPage.PRODUCTOS.of(String.valueOf(aleatorio)).resolveFor(actor);
        actor.attemptsTo(Scroll.to(elemento), Click.on(elemento));
    }
}
