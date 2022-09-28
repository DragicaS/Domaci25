package Domaci25;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

/*
Testirati rad kalkulatora https://testsheepnz.github.io/BasicCalculator.html.
 Testirati rad svih operacija posebno.
Za njega napisati edge case-eve na koje naletite,
ili ispunite neka matematicka pravila (deljenje sa nulom, jedinicom, veliki/mali brojevi itd).
Napisati minimum 4 edge case-a po testnoj metodi, 16 ukupno (minimum), zanemarujuci Concatenate.
*/
public class Domaci25 {
    private WebDriver driver;

    @BeforeClass
    public void start() {
        System.setProperty("webdriver.chrome.driver", "D:\\Bootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,600)");


    }


    @Test
    public void testAdd() {
        String expectedResult = "4";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("2");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("2");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        //Select selectEl=new Select(sum);
        //selectEl.selectByVisibleText("add");
        sum.sendKeys("add");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));


        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);

    }

    @BeforeMethod
    public void refresh() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }

    @AfterMethod
    public void clear() {
        WebElement delete = driver.findElement(By.id("clearButton"));
        delete.click();
    }

    @Test
    public void testAddNegativeNumber() {
        //In first field negative number
        //In second field postive number
        String expectedRes = "2";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("-2");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("4");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("add");
        WebElement calculate = driver.findElement(By.id("calculateButton"));
        calculate.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        String actualRes = result.getAttribute("value");

        Assert.assertEquals(actualRes, expectedRes);
    }

    @Test
    public void testAddNegativeNumber2() {
        //In second field negative number
        //In first field postive number
        String expectedResult = "3";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("5");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("-2");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("add");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();

        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void sumZero() {
        String expectedResult = "0";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("0");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("0");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Add");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void sumBigNumber() {
        String expectedResult = "24691356";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("12345678");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("12345678");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Add");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testSubtract() {
        String expectedResult = "4";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("8");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("4");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Subtract");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testSubtractNegativeNumber1() {
        //first field negative number
        //second fiel postive number
        String expectedResult = "-6";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("-2");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("4");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Subtract");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSubtractNegativeNumber2() {
        //first field positive number
        //second field negative number

        String expectedResult = "6";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("2");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("-4");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Subtract");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSubtractNegativeNumber3() {
        //Both field negative number

        String expectedResult = "2";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("-2");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("-4");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Subtract");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSubtractZero() {
        String expectedResult = "0";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("-2");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("-2");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Subtract");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSubtractBigNumber() {
        String expectedResult = "99900";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("200100");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("100200");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Subtract");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMultiply() {
        String expectedResult = "4";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("2");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("2");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Multiply");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMultiplyNegativeNumber() {
        String expectedResult = "8";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("-2");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("-4");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Multiply");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplyWithZero1() {
        String expectedResult = "0";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("18");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("0");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Multiply");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplyWithZero2() {
        String expectedResult = "0";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("0");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("29");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Multiply");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplyWithZero3() {
        String expectedResult = "0";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("0");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("0");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Multiply");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplyBigNumber() {
        String expectedResult = "38430000000";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("150000");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("256200");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Multiply");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testDivide() {
        String expectedResult = "8";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("16");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("2");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Divide");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divideNegativeNumber() {
        String expectedResult = "-8";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("16");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("-2");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Divide");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divideNegativeNumber2() {
        String expectedResult = "8";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("-16");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("-2");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Divide");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divideWithZero() {
        String expectedResult = "";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("16");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("0");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Divide");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divideWithOne() {
        String expectedResult = "250";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("250");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("1");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Divide");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divideWithDecimal() {
        String expectedResult = "4";
        WebElement field1 = driver.findElement(By.id("number1Field"));
        field1.sendKeys("10");
        WebElement field2 = driver.findElement(By.id("number2Field"));
        field2.sendKeys("2.5");
        WebElement sum = driver.findElement(By.id("selectOperationDropdown"));
        sum.sendKeys("Divide");
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));
        calculateButton.click();
        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String actualResult = result.getAttribute("value");
        Assert.assertEquals(actualResult, expectedResult);
    }

}
