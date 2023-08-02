package org.exito.com.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class VerificarProductosEnElCarrito implements Task {

    public static VerificarProductosEnElCarrito seleccionar() {
        return Tasks.instrumented(VerificarProductosEnElCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {



    }
}
