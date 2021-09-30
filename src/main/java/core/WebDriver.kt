package testSuite

import consts.Constants
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver


object Driver {
    val driver: WebDriver

    init {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH)
        driver = ChromeDriver()
    }

}