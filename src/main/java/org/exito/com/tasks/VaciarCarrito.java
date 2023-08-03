package org.exito.com.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.userInterface.CarritoComprasPage;
import org.exito.com.userInterface.StoreFrontPage;
import org.exito.com.userInterface.TransversalPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class VaciarCarrito implements Task {

    public static VaciarCarrito vaciar() {
        return Tasks.instrumented(VaciarCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(StoreFrontPage.LOGO_EXITO, isVisible()));
        actor.attemptsTo(Click.on(TransversalPage.CARRITO));
        actor.attemptsTo(Check.whether(CarritoComprasPage.CARRITO_ESTA_VACIO.resolveFor(actor).isCurrentlyVisible())
                        .otherwise(
                                WaitUntil.the(CarritoComprasPage.VACIAR_CARRITO_LINK, isPresent()),
                                WaitUntil.the(CarritoComprasPage.VACIAR_CARRITO_LINK, isVisible()),
                                WaitUntil.the(CarritoComprasPage.VACIAR_CARRITO_LINK, isClickable()),
                                Click.on(CarritoComprasPage.VACIAR_CARRITO_LINK),
                WaitUntil.the(CarritoComprasPage.CONFIRMAR_VACIAR_CARRITO_BUTTON, isVisible()),
                WaitUntil.the(CarritoComprasPage.CONFIRMAR_VACIAR_CARRITO_BUTTON, isClickable()),
                Click.on(CarritoComprasPage.CONFIRMAR_VACIAR_CARRITO_BUTTON),
                WaitUntil.the(CarritoComprasPage.CONFIRMAR_VACIAR_CARRITO_BUTTON, isVisible()),
                WaitUntil.the(CarritoComprasPage.CONFIRMAR_VACIAR_CARRITO_BUTTON, isClickable()),
                Click.on(CarritoComprasPage.CONFIRMAR_VACIAR_CARRITO_BUTTON)));

        actor.attemptsTo(WaitUntil.the(CarritoComprasPage.SIGUE_COMPRANDO_BUTTON, isVisible()),
                WaitUntil.the(CarritoComprasPage.SIGUE_COMPRANDO_BUTTON, isClickable()),
                Click.on(CarritoComprasPage.SIGUE_COMPRANDO_BUTTON));
    }
}

