package org.exito.com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class UnidadTiempo {

    private TimeUnit timeUnit;

    public UnidadTiempo(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public UnidadTiempo() {
    }

    public void esperar(long tiempo) {
        try {
            timeUnit.sleep(tiempo);
        } catch (InterruptedException e) {
            Logger logger = LoggerFactory.getLogger(UnidadTiempo.class);
            logger.error("", e);
            Thread.currentThread().interrupt();
        }
    }
}

