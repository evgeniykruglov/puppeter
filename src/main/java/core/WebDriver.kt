package testSuite

import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import props.Config
import java.io.File
import java.time.LocalDateTime

object Driver {
    val driver: WebDriver
    var wait: WebDriverWait

    init {
        val driverPath = Config.driverPath
        System.setProperty("webdriver.chrome.driver", driverPath)
        driver = ChromeDriver()
        wait = WebDriverWait(driver, 10)
    }

    fun getElements(locator: By?): List<WebElement>? {
        return driver.findElements(locator)
    }

    fun click(locator: By?) {
        driver.findElement(locator).click()
    }

    fun clickSafe(locator: By?) {
        try {
            click(locator)
        } catch (e: NoSuchElementException) {
            return
        } finally {
            return
        }
    }

    fun type(locator: By?, name: String?) {
        if (name != null) {
            driver.findElement(locator).clear()
            driver.findElement(locator).sendKeys(name)
        }
    }

    fun pressKey(locator: By?, key: Keys) {
        driver.findElement(locator).sendKeys(key)
    }

    fun takeScreenshot() {
        (this.driver as TakesScreenshot)
                .getScreenshotAs(OutputType.FILE)
                .copyTo(File("screenshots/${LocalDateTime.now()}.jpg"))
    }

    fun waitForElement(locator: By?) {
        wait.until(ExpectedConditions.elementToBeSelected(locator))
    }

    fun switchToLastTab() {
        driver.switchTo().window(driver.windowHandles.last())
    }
}