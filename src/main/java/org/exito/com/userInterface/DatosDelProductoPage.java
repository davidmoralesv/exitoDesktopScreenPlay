package org.exito.com.userInterface;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosDelProductoPage extends PageObject {

    public static Target NOMBRE_PRODUCTO_LABEL = Target.the("Productos").located(By.xpath("//div[contains(@class, 'product-detail-name')]//h1[contains(@class, 'productNameContainer')]/span"));
    public static Target AGREGAR_AL_CARRITO_BUTTON = Target.the("Boton Agregar al Carrito").locatedBy("//div[contains(@class,'productSummaryBuyButtonProductDetail')]//span[text()='{0}']");
    public static Target AGREGAR_UNIDADES_BUTTON = Target.the("Boton Agregar unidades").locatedBy("//button[contains(@class, 'productSummaryAddToCar')]");
    public static Target INGRESAR_CORREO_TEXTBOX = Target.the("Ingresar correo electronico").located(By.xpath("//input[@placeholder='correo@email.com']"));
    public static Target UNIDADES_SELECCIONADAS = Target.the("Unidades seleccionadas").located(By.xpath("//div[contains(@class,'stepperContainerQty')]"));
    public static Target PRECIO_TOTAL = Target.the("Precio Total").located(By.xpath("//div[contains(@class,'exito-product-details')]//span[contains(@class,'currencyContainer')]"));
    public static Target COMPRAR_AHORA_BUTTON = Target.the("Comprar ahora").located(By.xpath("//div[contains(@class, 'exito-product-details')]//span[contains(text(), 'Comprar ahora')]"));
    public static Target CONFIRMAR_CORREO_BUTTON = Target.the("Confirmar correo").located(By.xpath("//button[contains(@class, 'preLoginActiveButton')]"));
}
