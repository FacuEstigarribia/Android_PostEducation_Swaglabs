package com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.ios;

import com.spotify.carina.carina.demo.mobile.gui.pages.swaglabs.common.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {
    @ExtendedFindBy(iosPredicate = "label == 'Signature Pad demo'")
    private ExtendedWebElement signaturePad;

    @ExtendedFindBy(iosPredicate = "label == 'SAVE' AND name == 'test-SAVE'")
    private ExtendedWebElement saveBtn;

    @ExtendedFindBy(iosPredicate = "label == 'CLEAR' AND name == 'test-CLEAR'")
    private ExtendedWebElement clearBtn;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    public void clickClearBtn(){
        clearBtn.click();
    }

    @Override
    public void drawPicture() {
        Point position = signaturePad.getLocation();
        Dimension size = signaturePad.getSize();
        int startX = position.x + size.width / 10;
        int startY = position.y + size.height / 10;
        int endX = startX + size.width / 2; // Fin del lado derecho del cuadrado
        int endY = startY + size.height / 2; // Fin del lado inferior del cuadrado

        // Dibuja el cuadrado
        drawLine(startX, startY, endX, startY, 10); // Línea superior
        drawLine(endX, startY, endX, endY, 10); // Línea derecha
        drawLine(endX, endY, startX, endY, 10); // Línea inferior
        drawLine(startX, endY, startX, startY, 10); // Línea izquierda
    }

    private void drawLine(int startX, int startY, int endX, int endY, int steps) {
        int deltaX = (endX - startX) / steps;
        int deltaY = (endY - startY) / steps;

        for (int i = 0; i < steps; i++) {
            swipe(startX, startY, startX + deltaX * i, startY + deltaY * i, 200);
        }
    }
}
