package org.exito.com.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListaDeProductosPage extends PageObject {
    public static Target PRODUCTOS = Target.the("Productos").locatedBy("(//div[@id='gallery-layout-container']//a[contains(@href,'televisor-caixun')])[{0}]");
    public static Target NUMERO_PRODUCTOS = Target.the("Numero Productos").located(By.xpath("//div[@id='gallery-layout-container']//a"));
    public static Target CONTENEDOR_DE_PRODUCTOS = Target.the("Productos").located(By.xpath("//div[@id='gallery-layout-container']"));
}
