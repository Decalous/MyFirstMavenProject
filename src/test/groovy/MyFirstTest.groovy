// docs: https://bonigarcia.dev/webdrivermanager/

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import static org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import io.github.bonigarcia.wdm.WebDriverManager

class ChromeTest {

    WebDriver driver

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup()
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver()
    }

    @AfterEach
    void teardown() {
        driver.quit()
    }

    @Test
    void test() {
        //// Go to https://www.webstaurantstore.com/
        driver.get("https://www.webstaurantstore.com/")
        //String title = driver.getTitle()
        //assertThat(title).contains("WebstaurantStore")

        //// Search for 'stainless work table'
        WebElement searchBox = driver.findElement(By.name("searchval"))
        searchBox.sendKeys("stainless work table")
        searchBox.submit()
        //Thread.sleep(5000) // for debugging visually

        // Check the search result ensuring every product has the word 'Table' in its title
        //WebElement nextPageButton = driver.findElement(By.className("rc-pagination-next"))
        //nextPageButton.submit() // when searching by className, get a javascript error "Unable to find owning document"
        int numPages = 9 // TODO: find the number of pages on the site
        String page = "https://www.webstaurantstore.com/search/stainless-work-table.html?page="
        for (int i = 2; i <= numPages;i++){
            String goTo = page + i.toString()
            driver.get(goTo)
            Thread.sleep(2000)  // for debugging visually
            // TODO: figure out how to iterate through all items on the page
                // TODO: figure out how to check an item
        }
        //driver.get("https://www.webstaurantstore.com/search/stainless-work-table.html?page=2") // not an elegant solution but could hard code each page
        //Thread.sleep(5000)  // for debugging visually

        // try adding something to cart
        //WebElement cartButton = driver.findElement(By.name("addToCartButton"))
        //cartButton.submit()
        //Thread.sleep(5000) // for debugging visually

        // TODO: Add the last of found items to Cart

        // Empty Cart
        //WebElement emptyCartButton = driver.findElement(By.className("emptyCartButton"))
        // TODO: figure out why emptyCartButton.submit() breaks
        //emptyCartButton.submit() // breaks when trying this
        //Thread.sleep(5000)  // for debugging visually
    }

}