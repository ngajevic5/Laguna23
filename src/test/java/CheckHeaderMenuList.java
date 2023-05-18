import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Check Header menu list
 * Steps:
 * 1.Navigate to https://www.laguna.rs/
 * 2.Check header menu list has the following elements:
 * 3."Naslovna" ; "Knjige" ; "U pripremi" ; "#Bukmarker" ; "Top-liste" ; "Mala Laguna"; "Klub čitalaca"
 *
 * Expected results:
 * 3.Verify that 'Header menu' have the same elements from the list
 */
@Test
public class CheckHeaderMenuList {
    public void testCheckHeaderMenuListTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/");

        //ocekivane stavke menija
        List<String> expectedMenuItems = new ArrayList<>();
        expectedMenuItems.add("Naslovna");
        expectedMenuItems.add("Knjige");
        expectedMenuItems.add("U pripremi");
        expectedMenuItems.add("#Bukmarker");
        expectedMenuItems.add("Top-liste");
        expectedMenuItems.add("Mala Laguna");
        expectedMenuItems.add("Klub čitalaca");


        List<WebElement> webElementListHeaderMenuItems = driver.findElements(By.xpath("//ul[@id='glavni-meni']//li/a"));


        List<String> headerMenuItems = new ArrayList<>();
        for (WebElement element : webElementListHeaderMenuItems) {
            headerMenuItems.add(element.getText());
        }
        Assert.assertTrue(headerMenuItems.containsAll(expectedMenuItems));

        driver.quit();
    }
}
