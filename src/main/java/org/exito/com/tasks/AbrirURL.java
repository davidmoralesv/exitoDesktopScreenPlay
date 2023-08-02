package org.exito.com.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.userInterface.StoreFrontPage;
import org.exito.com.util.ConfiguracionApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirURL implements Task {
    Logger logger = LoggerFactory.getLogger(AbrirURL.class);

    public static AbrirURL abrir() {
        return Tasks.instrumented(AbrirURL.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String strUrl = obtenerUrlExito();
        actor.wasAbleTo(Open.url(strUrl), WaitUntil.the(StoreFrontPage.logoExito, isVisible()));

        logger.info("Pagina {} cargada con exito.", strUrl);

    }

    private String obtenerUrlExito() {
        try {
            return ConfiguracionApp.getUrlExito();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
