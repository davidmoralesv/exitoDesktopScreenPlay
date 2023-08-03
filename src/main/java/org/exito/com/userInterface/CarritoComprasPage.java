package org.exito.com.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoComprasPage extends PageObject {
    public static Target CARRITO = Target.the("Carrito de compras").located(By.xpath("//a[@class='exito-header-3-x-minicartLink']"));
    public static Target CONFIRMAR_EMAIL_BUTTON = Target.the("Confirmar email").located(By.xpath("//button[contains(text(),'Confirmar')]"));
    public static Target NOMBRES_DE_PRODUCTO = Target.the("Nombres de producto en el carrito").located(By.xpath("//span[@data-molecule-product-detail-name-span]"));
    public static Target CONTENEDOR_DE_TOTALES = Target.the("Contenedor de totales").located(By.xpath("//div[@class='exito-checkout-io-0-x-summaryContainer']"));
    public static Target VACIAR_CARRITO_LINK = Target.the("Vaciar carrito link").located(By.xpath("//button[@class='exito-checkout-io-0-x-emptyCartShowButton']"));
    public static Target CONFIRMAR_VACIAR_CARRITO_BUTTON = Target.the("Confirmar vaciar carrito").located(By.xpath("//div[@data-molecule-modal-confirmation-button-container]//button[2]"));
    public static Target SIGUE_COMPRANDO_BUTTON = Target.the("Sigue comprando").located(By.xpath("//span[contains(@class, 'emptyCartPageButton')]"));
    public static Target TOTAL_VENTA = Target.the("Total Venta").located(By.xpath("//div[contains(@class,'summaryTotal')]//span[@data-molecule-summary-item-value]"));
    public static Target CANTIDAD_POR_NOMBRE_PRODUCTO = Target.the("Cantidad por nombre producto").locatedBy("//span[contains(text(),'{0}')]/../../div[@data-molecule-product-detail-quantity]//span[@data-molecule-quantity-und-value]");
    public static Target CARRITO_ESTA_VACIO = Target.the("Mensaje carrito vacío").located(By.xpath("//h1[@class='exito-checkout-io-0-x-emptyCartPageTitle']"));
}
