package org.exito.com.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListaDeProductosPage extends PageObject {
    public static Target productos = Target.the("Productos").locatedBy("(//div[@id='gallery-layout-container']//a[contains(@href,'televisor-caixun')])[{0}]");
    public static Target contenedorDeProductos = Target.the("Productos").located(By.xpath("//div[@id='gallery-layout-container']"));
}
