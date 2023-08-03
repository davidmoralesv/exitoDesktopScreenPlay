package org.exito.com.model;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private static final XProducto producto = new XProducto();

    public static String getNombre() {
        return producto.getNombre();
    }

    public static void setNombre(String nombre) {
        producto.setNombre(nombre);
    }

    public static Integer cantidad() {
        return producto.getCantidad();
    }

    public static void setCantidad(Integer cantidad) {
        producto.setCantidad(cantidad);
    }

    public static Double getPrecio() {
        return producto.getPrecio();
    }

    public static void setPrecio(Double precio) {
        producto.setPrecio(precio);
    }

    public static List<XProducto> productos = new ArrayList<>();
}
