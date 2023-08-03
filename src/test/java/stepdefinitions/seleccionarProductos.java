package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.exito.com.tasks.*;

public class seleccionarProductos {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que se ingresa a exito.com")
    public void queSeIngresaAExitoCom() {
        OnStage.theActorCalled("usuario").wasAbleTo(AbrirURL.abrir());
    }

    @Y("^vacia el carrito")
    public void vaciarElCarrito() {
        OnStage.theActorCalled("usuario").wasAbleTo(VaciarCarrito.vaciar());
    }

    @Y("^selecciona la categoria (.*)")
    public void SeleccionaCategoriaAleatoria(String nombreCategoria) {
        OnStage.theActorCalled("usuario").wasAbleTo(SeleccionarCategoria.seleccionar(nombreCategoria));
    }

    @Y("^selecciona la subcategoria")
    public void SeleccionaSubcategoriaAleatoria() {
        OnStage.theActorCalled("usuario").wasAbleTo(SeleccionarSubcategoria.seleccionar());
    }

    @Y("^selecciona un producto aleatoriamente")
    public void SeleccionaUnProductoAleatoriamente() {
        OnStage.theActorCalled("usuario").wasAbleTo(SeleccionarUnProductoAleatoriamente.seleccionar());
    }

    @Y("^agregar el producto al carrito y agregar las unidades aleatoriamente")
    public void AgregarProductoAlCarritoYAgregarUnidades() {
        OnStage.theActorCalled("usuario").wasAbleTo(AgregarAlCarritoYSeleccionarUnidades.seleccionar());
    }

    @Y("^verifica los productos en el carrito de compras")
    public void verificarProductosEnElCarritoDeComprassss() {
        OnStage.theActorCalled("usuario").wasAbleTo(VerificarProductosEnElCarrito.seleccionar());
    }


}
