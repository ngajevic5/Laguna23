import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Check social media icons
 * Steps:
 * 1.Navigate to https://www.laguna.rs/
 * 2.Check right corner of header have social media icons, in the following order:
 * 'facebook' ; 'twitter' ; 'instagram' ; 'youtube' ; 'tiktok'
 *
 * Expected results:
 * Verify the right corner of header have social media icons from the list.
 */


public class CheckSocialMediaIcons {
    @Test
    public void testSocialMediaLinksArePresentTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/");

        WebElement facebookIcon = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-xs']//li//a[contains(@href, 'facebook')]//img"));
        WebElement twitterIcon = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-xs']//li//a[contains(@href, 'twitter')]//img"));
        WebElement instagramIcon = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-xs']//li//a[contains(@href, 'instagram')]//img"));
        WebElement youtubeIcon = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-xs']//li//a[contains(@href, 'youtube')]//img"));
        WebElement tiktokIcon = driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-xs']//li//a[contains(@href, 'tiktok')]//img"));

        Assert.assertTrue(facebookIcon.isDisplayed());
        Assert.assertTrue(twitterIcon.isDisplayed());
        Assert.assertTrue(instagramIcon.isDisplayed());
        Assert.assertTrue(youtubeIcon.isDisplayed());
        Assert.assertTrue(tiktokIcon.isDisplayed());

        driver.quit();
    }
}
