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
        //Thread.sleep(5000)

        // check the search result ensuring every product has the word 'Table' in its title

        // try adding something to cart
        WebElement cartButton = driver.findElement(By.name("addToCartButton"))
        cartButton.submit()
        Thread.sleep(5000)

        // Add the last of found items to Cart

        // Empty Cart
        WebElement emptyCartButton = driver.findElement(By.className("emptyCartButton"))
        //emptyCartButton.submit() // breaks when trying this
        Thread.sleep(5000)  // Let the user actually see something!
    }

}