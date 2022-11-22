import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class ListOfObjectsExcercise {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(3000);

        int j = 0;
        String[] productToCart = {"Blouse", "Printed Chiffon Dress"};
        //, "Faded Short Sleeve T-shirt

        //find all product names on site
        List<WebElement> listOfAllProducts = driver.findElements(By.cssSelector("h5[itemprop='name']"));

        for (int i = 0; i < listOfAllProducts.size(); i++) {
            //get product names from WebElements
            String productName = listOfAllProducts.get(i).getText().trim();

            List<String> productsToCartList = Arrays.asList(productToCart);

            if (productsToCartList.contains(productName)) {
                System.out.println(productName);
                j++;
                driver.findElements(By.xpath("//a[@title='Add to cart']")).get(i).click();
                Thread.sleep(3000);
                driver.findElement(By.cssSelector("span[class*='continue']")).click();
                Thread.sleep(5000);

                String quantityInCart = driver.findElement(By.cssSelector("a[title='View my shopping cart'] span[class='ajax_cart_quantity']")).getText();
                if (quantityInCart == "2") {
                    break;
                }
            }
        }
        //Maybe I should switchTo frame ???
        String productQuantity = driver.findElement(By.cssSelector("//a[@title='View my shopping cart']/span[@class='ajax_cart_quantity']")).getText();

        Assert.assertEquals(productQuantity, "2");
        System.out.println(productQuantity);
    }
}
