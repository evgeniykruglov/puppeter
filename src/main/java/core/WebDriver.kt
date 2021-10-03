package testSuite

import consts.Constants.CHROMEDRIVER_BIN_PATH
import consts.Constants.CHROMEDRIVER_EXE_PATH
import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import props.Config
import java.io.File
import java.util.*


object Driver {
    val driver: WebDriver
    var wait: WebDriverWait

    init {
        val driverPath = when (Config.operatingSystem) {
            "linux" -> CHROMEDRIVER_BIN_PATH
            "win" -> CHROMEDRIVER_EXE_PATH
            else -> throw IllegalArgumentException("Property system can be only `linux` or `win`")
        }
        System.setProperty("webdriver.chrome.driver", driverPath)
        driver = ChromeDriver()
        wait = WebDriverWait(driver, 10)
    }

    fun getElements(locator: By?): List<WebElement>? {
        return driver.findElements(locator)
    }

    fun click(aNew: By?) {
        driver.findElement(aNew).click()
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
        (this as TakesScreenshot)
                .getScreenshotAs(OutputType.FILE)
                .copyTo(File("screenshots/${UUID.randomUUID()}.jpg"))
    }

    fun waitForElement(locator: By?) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
    }

}