package org.exito.com.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.model.XProducto;
import org.exito.com.userInterface.CarritoComprasPage;
import org.exito.com.userInterface.TransversalPage;
import org.exito.com.util.UnidadTiempo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.exito.com.model.Producto.productos;

public class VerificarProductosEnElCarrito implements Task {
    Logger logger = LoggerFactory.getLogger(VerificarProductosEnElCarrito.class);

    public static VerificarProductosEnElCarrito seleccionar() {
        return Tasks.instrumented(VerificarProductosEnElCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CarritoComprasPage.CARRITO));
        new UnidadTiempo(TimeUnit.SECONDS).esperar(2);

        actor.attemptsTo(Check.whether(TransversalPage.INGRESAR_CORREO_TEXTBOX.resolveFor(actor).isCurrentlyVisible())
                        .andIfSo(Enter.theValue("correo@correo.colombia.com")
                                .into(TransversalPage.INGRESAR_CORREO_TEXTBOX)),
                Click.on(CarritoComprasPage.CONFIRMAR_EMAIL_BUTTON));

        List<String> nombreProductosEnCarrito = CarritoComprasPage.NOMBRES_DE_PRODUCTO.resolveAllFor(actor)
                .stream().map(WebElementFacade::getText).collect(Collectors.toList());
        List<String> nombreProductosAniadidos = productos.stream().map(XProducto::getNombre)
                .collect(Collectors.toList());

        Ensure.that(estanListasContenidas(nombreProductosAniadidos, nombreProductosEnCarrito)).isTrue();
        logger.info("La validación de los nombres en el carrito es correcta");

        Double totalEnCarrito = Double.parseDouble(CarritoComprasPage.TOTAL_VENTA.resolveFor(actor).getText().replaceAll("[^0-9]", ""));
        Double sumaTotalesAniadidos = productos.stream().mapToDouble(XProducto::getPrecio).sum();

        Ensure.that(totalEnCarrito).isEqualTo(sumaTotalesAniadidos);
        logger.info("La validación de los nombres en el carrito es correcta");

        productos.forEach(producto -> {
            Integer cantidaProductoEnCarrito = Integer.parseInt(CarritoComprasPage.CANTIDAD_POR_NOMBRE_PRODUCTO.of(producto.getNombre()).resolveFor(actor).getText());
            Ensure.that(producto.getCantidad()).isEqualTo(cantidaProductoEnCarrito);
        });

        logger.info("La validación de las cantidades en el carrito es correcta");
    }

    public static <T> boolean estanListasContenidas(List<T> lista1, List<T> lista2) {
        Set<T> setLista1 = new HashSet<>(lista1);
        Set<T> setLista2 = new HashSet<>(lista2);
        return setLista1.containsAll(setLista2) && setLista2.containsAll(setLista1);
    }

}
