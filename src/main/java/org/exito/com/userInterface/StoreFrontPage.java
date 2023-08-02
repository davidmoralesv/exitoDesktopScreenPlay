package org.exito.com.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StoreFrontPage extends PageObject {
    public static Target LOGO_EXITO = Target.the("logo del Exito.com").located(By.xpath("//img[contains(@src, 'https://exitocol.vtexassets')]"));
    public static Target CATEGORIA_LINK = Target.the("Categorías").locatedBy("//a[starts-with(@class, 'exito-home-components-1-x-carouselGridItemContainer')]/div[contains(@class, 'x-text') and contains(text(),'{0}')]/..");

    public static Target FILTRO_BUTTON = Target.the("Filtro Subcategoria").located(By.xpath("//h5[contains(@class,'exito-filters')]"));
    public static Target SUBCATEGORIA_ACCORDION = Target.the("Acordeon Subcategoria").located(By.xpath("//div[contains(text(),'Sub-categoría')]/.."));

    public static Target TELEVISORES_CAIXUM_CHECKBOX = Target.the("Subcategoria Televisores Caxum").located(By.xpath("//label[text()='Televisores Caixun']/..//input[@type='checkbox']"));
}
