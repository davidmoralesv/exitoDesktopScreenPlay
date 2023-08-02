package org.exito.com.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoComprasPage extends PageObject {
    public static Target SEGUIR_COMPRANDO = Target.the("Seguir Comprando").located(By.xpath("//a[text()='Seguir comprando']"));
}
