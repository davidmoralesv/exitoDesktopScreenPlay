package org.exito.com.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransversalPage extends PageObject {
    public static Target INGRESAR_CORREO_TEXTBOX = Target.the("Ingresar correo electronico").located(By.xpath("//input[@placeholder='correo@email.com']"));
    public static Target CARRITO = Target.the("Carrito de compras").located(By.xpath("//a[@class='exito-header-3-x-minicartLink']"));
}
