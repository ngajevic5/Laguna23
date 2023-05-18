import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Open book details
 * Steps:
 * 1.Navigate to https://www.laguna.rs/
 * 2. 2.In header click on the search field "Knjige o kojima se priča"
 * 3.In search field write book name "Pobednici"
 * 4.Click submit
 * 5.click on the book you were looking for
 *
 * Expected results:
 * Verify when you open book, you have details of book
 */

@Test
public class OpenBookDetails {
    public void openBookDetailTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.laguna.rs/");

        WebElement searchTextField = driver.findElement(By.id("pretraga_rec"));
        WebElement searchSubmitIcon = driver.findElement(By.id("pretraga_submit"));
        searchTextField.sendKeys("Pobednici");
        searchSubmitIcon.click();

        WebElement searchResultItem = driver.findElement(By.xpath("//div[@class='podaci']//a[@class='naslov']"));
        searchResultItem.click();

        //Validate opened book
        WebElement selectedBookTitle = driver.findElement(By.xpath("//div[@class='row hidden-sm hidden-xs podaci']//h1"));
        WebElement selectedBookAuthor = driver.findElement(By.xpath("//div[@class='row hidden-sm hidden-xs podaci']//h2//a"));
        Assert.assertTrue(selectedBookTitle.getText().equals("Pobednici"));
        Assert.assertTrue(selectedBookAuthor.getText().equals("Fredrik Bakman"));

        driver.quit();
    }
}