package org.exito.com.util;

import java.util.concurrent.ThreadLocalRandom;

public class Utilitarios {
    public static int generarNumeroAleatorio(int limiteInicial, int LimiteFinal) {
        return Math.abs(ThreadLocalRandom.current().nextInt(limiteInicial, LimiteFinal));
    }
}