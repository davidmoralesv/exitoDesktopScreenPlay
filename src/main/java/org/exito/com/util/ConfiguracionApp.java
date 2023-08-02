package org.exito.com.util;

import java.io.IOException;

public class ConfiguracionApp {
    private static final String ARCHIVO_PROPIEDADES = "exito.properties";

    private static final String AMBIENTE_PROPIEDADES = "ambiente.properties";

    private ConfiguracionApp() {
    }

    public static String getAmbiente() throws IOException {
        return ArchivoPropiedades.getValorPropiedades(AMBIENTE_PROPIEDADES, "ambiente");
    }

    public static String getUrlExito() throws IOException {
        return ArchivoPropiedades.getValorPropiedades(ARCHIVO_PROPIEDADES, String.format("%s.aplicacion.url", getAmbiente()));
    }


}
