package Primer3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/*Ucitati stranicu https://demoqa.com/modal-dialogs i:
Kliknuti na dugme Large modal
Proveriti da li se dijalog prikazuje i ispisati u konzoli tekst dijaloga
*/
public class LargeModel {
    private WebDriver driver;
    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\Bootcamp\\chromedriver.exe");

        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/modal-dialogs");
        WebElement largeModel=driver.findElement(By.id("showLargeModal"));
        largeModel.click();
    }
    @Test
    public void large()
    {
        String expectedResult="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        WebElement finedText=driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/p"));
        String actualResult=finedText.getText();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @AfterClass
    public void close()
    {
       driver.quit();
    }
}
