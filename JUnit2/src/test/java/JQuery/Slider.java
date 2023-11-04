package JQuery;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Slider {
    WebDriver driver;

    @Before
    public void slider(){

        WebDriverManager.firefoxdriver().setup();
        /*ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("-disabled-notifications");
        driver= new ChromeDriver(options);*/
        driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/slider/");

    }
    @Test
    public void SliderExample() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        WebElement iframe =driver.findElement(By.cssSelector("[class=\"demo-frame\"]"));
        driver.switchTo().frame(iframe);
        WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span[1]"));
        Actions act= new Actions(driver);
        act.clickAndHold(slider).moveByOffset(300,0).release().build().perform();
        Thread.sleep(1000);
    }
    @After
    public void close(){
        //driver.close();
    }
}
