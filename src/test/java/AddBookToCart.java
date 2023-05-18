import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 *AddBookToCart
 * Steps:
 * 1.Navigate to  https://www.laguna.rs/
 * 2.Choose in header menu list "knjige"
 * 3.Choose book
 * 4.Click on the book
 * 5.Click on the button "Dodaj u korpu"
 *
 * Expected results:
 * 5.Verify that book is in shoping cart
 */


@Test
public class AddBookToCart {
    public void AddItemToCartTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/");

        WebElement booksLink = driver.findElement(By.cssSelector("#glavni-meni-wrapper a[href*='knjige_spisak']"));
        booksLink.click();

        WebElement selectBook = driver.findElement(By.cssSelector("div#spisak-knjiga-knjige>div.knjiga.col-lg-3.col-md-3.col-sm-4.col-xs-8:nth-child(3)>div.podaci>a.naslov"));
        selectBook.click();

        WebElement addBookToCart = driver.findElement(By.id("dugme-korpa"));
        addBookToCart.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement shoppingCartBadge = driver.findElement(By.id("korpa_broj"));
        Assert.assertTrue(shoppingCartBadge.isDisplayed());

        String actualNumberInShoppingCart = shoppingCartBadge.getText();
        Assert.assertEquals(actualNumberInShoppingCart, "1");

        driver.quit();
    }
}
