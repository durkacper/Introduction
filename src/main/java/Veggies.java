import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class Veggies {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Implicit wait - it is applied globally
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Explicit wait - create object of WebDriverWait class to be able to call methods and it is applied directly for each WebElements
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //list of product which we want to add to cart
        String[] productsToAdd = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);

        addItems(driver, productsToAdd);
        //instead of making "addItems" method static, we can first create an object of Veggies class
        //and then call the method for object:
//        Veggies veggies = new Veggies();
//        veggies.addItems(driver, productsToAdd);

        //click on cart icon
        driver.findElement(By.cssSelector("a.cart-icon")).click();

        //click on "PROCEED TO CHECKOUT" button
        driver.findElement(By.xpath("//div[@class='cart-preview active']/div[@class='action-block']/button")).click();

        //Explicit wait - applied for Promo Code text box:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        //enter promo code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        //click apply button for the promo code
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //Explicit wait - applied for "Code applied ..!" message
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='promoInfo']")));
        //Assertion for message
        Assert.assertEquals(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText(), "Code applied ..!");


    }

    // for static method we do not have to create object of class, to call this method
    public static void addItems(WebDriver driver, String[] productsToAdd) {

        int j = 0;

        //get all product names to one list
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            //format text to get only name of product (without "- 1 Kg")
            String[] productName = products.get(i).getText().split("-");
            String formattedProductName = productName[0].trim();

            //check whether name we get from iteration is present in array productsToAdd
            //but first - convert array to arrayList (because we want to use 'contains' method)
            List<String> productsToAddList = Arrays.asList(productsToAdd);


            if (productsToAddList.contains(formattedProductName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']//button[@type='button']")).get(i).click();
                if (j == productsToAdd.length) {
                    break;
                }
            }
        }
    }
}

