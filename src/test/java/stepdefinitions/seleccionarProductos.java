package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.exito.com.tasks.AbrirURL;
import org.exito.com.tasks.SeleccionarCategoria;
import org.exito.com.tasks.SeleccionarSubcategoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class seleccionarProductos {
    Logger logger = LoggerFactory.getLogger(seleccionarProductos.class);

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que se ingresa a exito.com")
    public void queSeIngresaAExitoCom() {
        OnStage.theActorCalled("usuario").wasAbleTo(AbrirURL.abrir());
    }

    @Y("^selecciona la categoria (.*) de forma aleatoria")
    public void ySeleccionaCategoriaAleatoria(String nombreCategoria) {
        OnStage.theActorCalled("usuario").wasAbleTo(SeleccionarCategoria.seleccionar(nombreCategoria));
    }

    @Y("^selecciona la subcategoria (.*) de forma aleatoria")
    public void ySeleccionaSubcategoriaAleatoria(String nombreSubcategoria) {
        OnStage.theActorCalled("usuario").wasAbleTo(SeleccionarSubcategoria.seleccionar(nombreSubcategoria));
    }
}
