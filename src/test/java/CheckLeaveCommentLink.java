import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Check leave comment link
 * Steps:
 * 1.Navigate to https://www.laguna.rs/n5875_knjiga_sva_sirocad_bruklina_laguna.html
 * 2.Click on the class "Komentari"
 *
 * Expected results:
 * 1.Verify that you have field "Ostavi komentar" when you open class "Komentari"
 */


@Test
public class CheckLeaveCommentLink {
    public void checkLeaveCommentLinkTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/n5875_knjiga_sva_sirocad_bruklina_laguna.html");

        WebElement leaveCommentLink = driver.findElement(By.xpath("//div[@class='podatak']//a[@class='komentar-podatak']"));
        leaveCommentLink.click();

        WebElement inputField = driver.findElement(By.id("ostavi-komentar-k"));

        Assert.assertTrue(inputField.isDisplayed());

        driver.quit();
    }
}
