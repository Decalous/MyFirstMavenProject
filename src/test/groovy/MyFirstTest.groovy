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
        // Exercise
        driver.get("https://www.webstaurantstore.com/")
        String title = driver.getTitle()

        // Verify
        WebElement searchBox = driver.findElement(By.name("searchval"))

        searchBox.sendKeys("stainless work table")

        searchBox.submit()

        Thread.sleep(5000)  // Let the user actually see something!

        assertThat(title).contains("WebstaurantStore")
    }

}