package testSuite

import consts.Constants.CHROMEDRIVER_BIN_PATH
import consts.Constants.CHROMEDRIVER_EXE_PATH
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import props.Config


object Driver {
    val driver: WebDriver

    init {
        val driverPath = when (Config.operatingSystem) {
            "linux" -> CHROMEDRIVER_BIN_PATH
            "win" -> CHROMEDRIVER_EXE_PATH
            else -> throw IllegalArgumentException("Property system can be only `linux` or `win`")
        }
        System.setProperty("webdriver.chrome.driver", driverPath)
        driver = ChromeDriver()
    }

}