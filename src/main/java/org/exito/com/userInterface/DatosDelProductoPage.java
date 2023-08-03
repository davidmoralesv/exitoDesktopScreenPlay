package org.exito.com.userInterface;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosDelProductoPage extends PageObject {

    public static Target NOMBRE_PRODUCTO_LABEL = Target.the("Productos").located(By.xpath("//div[contains(@class, 'product-detail-name')]//h1[contains(@class, 'productNameContainer')]/span"));
    public static Target AGREGAR_AL_CARRITO_BUTTON = Target.the("Boton Agregar al Carrito").locatedBy("//div[contains(@class,'productSummaryBuyButtonProductDetail')]//span[text()='{0}']");
    public static Target AGREGAR_UNIDADES_BUTTON = Target.the("Boton Agregar unidades").locatedBy("//button[contains(@class, 'productSummaryAddToCar')]");

    public static Target UNIDADES_SELECCIONADAS = Target.the("Unidades seleccionadas").located(By.xpath("//div[contains(@class,'stepperContainerQty')]"));
    public static Target PRECIO_TOTAL = Target.the("Precio Total").located(By.xpath("//div[contains(@class,'exito-product-details')]//span[contains(@class,'currencyContainer')]"));
    public static Target CONFIRMAR_EMAIL_BUTTON = Target.the("Confirmar correo").located(By.xpath("//button[contains(@class, 'preLoginActiveButton')]"));
    public static Target TELEVISORES_CAISUM_BREADCRUMB = Target.the("Miga de pan Televisores Caisun").located(By.xpath("//a[contains(@href, '/televisores-caixun')]"));
    public static Target MENU_HEADER = Target.the("Menu Header").located(By.xpath("//div[@class='exito-header-3-x-services']"));
    public static Target COSTO_ENVIO = Target.the("Costo de envio").located(By.xpath("//p[contains(@class,'exitoCustomBenefits') and (contains(text(),'Enviado por') or contains(text(),'Costo de envío'))]"));
    public static Target ULTIMAS_UNIDADES = Target.the("Mensaje Ultimas unidades").located(By.xpath("//div[starts-with(text(),'¡Últimas') and contains(text(),'unidades')]"));
}
