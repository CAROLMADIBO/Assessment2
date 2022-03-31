package Ilab.webUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WebAction {
    //Click web action
    public static void clickObject(WebElement element, WebDriver driver)
    {
        try
        {
            if (element.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        } catch (Exception e){
            System.out.println(element + " Not found");
        }
    }

    //SendKeys web action
    public static void passData(WebElement element,WebDriver driver,String data){

        try{

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofMillis(1000))
                    .ignoring(WebDriverException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(data);
        }catch (Exception e){
            System.out.println(element + " Not found");
        }
    }
}
