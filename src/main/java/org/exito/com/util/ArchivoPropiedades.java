package org.exito.com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ArchivoPropiedades {
    private ArchivoPropiedades() {
    }

    /**
     * Obtiene el valor del archivo propiedades
     *
     * @param strArchivo Ruta archivo propiedades
     * @param strLlave   Llave a buscar
     * @return Valor contenido en el archivo
     * @throws IOException Control error en la entrada/salida del archivo
     */
    public static String getValorPropiedades(String strArchivo, String strLlave) throws IOException {
        Properties propiedad = new Properties();
        propiedad.load(new FileInputStream(strArchivo));
        return propiedad.getProperty(strLlave);
    }
}

