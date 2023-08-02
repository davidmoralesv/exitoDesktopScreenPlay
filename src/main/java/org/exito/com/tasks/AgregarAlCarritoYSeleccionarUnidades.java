package org.exito.com.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.model.XProducto;
import org.exito.com.userInterface.CarritoComprasPage;
import org.exito.com.userInterface.DatosDelProductoPage;
import org.exito.com.util.UnidadTiempo;
import org.exito.com.util.Utilitarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.exito.com.model.Producto.productos;

public class AgregarAlCarritoYSeleccionarUnidades implements Task {
    Logger logger = LoggerFactory.getLogger(AgregarAlCarritoYSeleccionarUnidades.class);
    private final String correo = "correoprueba@prueba.colombia.com";
    private final String agregar = "Agregar";

    public static AgregarAlCarritoYSeleccionarUnidades seleccionar() {
        return Tasks.instrumented(AgregarAlCarritoYSeleccionarUnidades.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        XProducto producto = new XProducto();
        BrowseTheWeb.as(actor).setImplicitTimeout(20, ChronoUnit.SECONDS);
        actor.attemptsTo(WaitUntil.the(DatosDelProductoPage.AGREGAR_AL_CARRITO_BUTTON.of(agregar), isPresent()));
        BrowseTheWeb.as(actor).setImplicitTimeout(10, ChronoUnit.SECONDS);
        actor.attemptsTo(Scroll.to(DatosDelProductoPage.NOMBRE_PRODUCTO_LABEL));
        String name = DatosDelProductoPage.NOMBRE_PRODUCTO_LABEL.resolveFor(actor).getText();
        producto.setNombre(name);

        actor.attemptsTo(Click.on(DatosDelProductoPage.AGREGAR_AL_CARRITO_BUTTON.of(agregar)));

        int cantidadUnidades = Utilitarios.generarNumeroAleatorio(1, 10);
        for (int i = 1; i <= cantidadUnidades; i++) {
            if (DatosDelProductoPage.AGREGAR_UNIDADES_BUTTON.resolveFor(actor).getAttribute("disabled") != null) {
                break;
            }
            actor.attemptsTo(Click.on(DatosDelProductoPage.AGREGAR_UNIDADES_BUTTON));
            new UnidadTiempo(TimeUnit.SECONDS).esperar(1);
        }

        int unidades = Integer.parseInt(DatosDelProductoPage.UNIDADES_SELECCIONADAS.resolveFor(actor).getText().replaceAll("^(\\d+)\\..*", "$1"));
        producto.setCantidad(unidades);

        double precioTotal = Double.parseDouble(DatosDelProductoPage.PRECIO_TOTAL.resolveFor(actor).getText().replaceAll("[$.]", ""));
        producto.setPrecio(precioTotal);

        actor.attemptsTo(Click.on(DatosDelProductoPage.COMPRAR_AHORA_BUTTON));

        actor.attemptsTo(Check.whether(DatosDelProductoPage.INGRESAR_CORREO_TEXTBOX.resolveFor(actor).isCurrentlyVisible())
                .andIfSo(Enter.keyValues(correo).into(DatosDelProductoPage.INGRESAR_CORREO_TEXTBOX),
                        Click.on(DatosDelProductoPage.CONFIRMAR_CORREO_BUTTON)));

        productos.add(producto);

        actor.attemptsTo(WaitUntil.the(CarritoComprasPage.SEGUIR_COMPRANDO, isVisible()),
                Click.on(CarritoComprasPage.SEGUIR_COMPRANDO));

        logger.info("Se agregó correctamente el producto al carrito de compra");
    }
}
