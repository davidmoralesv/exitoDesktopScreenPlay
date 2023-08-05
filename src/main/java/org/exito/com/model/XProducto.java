package org.exito.com.model;

@SuppressWarnings("all")
public class XProducto {
    private String nombre;
    private Integer cantidad;
    private Double precio;

    // Constructor

    public XProducto() {
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
