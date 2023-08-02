package org.exito.com.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StoreFrontPage extends PageObject {
    public static Target logoExito = Target.the("logo del Exito.com").located(By.xpath("//img[contains(@src, 'https://exitocol.vtexassets')]"));
    public static Target categoria = Target.the("Categorías").locatedBy("//a[starts-with(@class, 'exito-home-components-1-x-carouselGridItemContainer')]/div[contains(@class, 'x-text') and contains(text(),'{0}')]/..");
    public static Target subcategoriaDescuento = Target.the("Subcategoria Descuento").located(By.xpath("(//a[@class, 'campaign_name_bloque_mujer_1')"));

    public static Target conoceNuestrasMarcas = Target.the("Conoce nuestras marcas").located(By.xpath("//h5[contains(@class, 'exito-home-components') and text()='Conoce nuestras marcas']"));

    public static Target subcategoria = Target.the("Subcategoria").located(By.xpath("(//div[contains(@class,'rowGalleryFive')])[1]/a"));

}
