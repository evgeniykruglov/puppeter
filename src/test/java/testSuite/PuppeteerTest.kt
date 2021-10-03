package testSuite

import consts.WebElements.ITEM
import consts.WebElements.NEXT_CHECKBOX_INPUT
import consts.WebElements.POPUP_BTN_CLOSE
import consts.WebElements.SEARCH_KEY
import consts.WebElements.SEARCH_KEY_BOX
import org.junit.jupiter.api.Test
import org.openqa.selenium.Keys
import props.Config.baseUrl
import testSuite.Driver.click
import testSuite.Driver.clickSafe
import testSuite.Driver.getElements
import testSuite.Driver.pressKey
import testSuite.Driver.switchToLastTab
import testSuite.Driver.takeScreenshot
import testSuite.Driver.type


class PuppeteerTest {
    @Test
    fun test() {
        Driver.driver.apply {
            this.get(baseUrl)
            try {
                clickSafe(POPUP_BTN_CLOSE)
                click(SEARCH_KEY_BOX)
                type(SEARCH_KEY, "nylon shoulder bag")
                pressKey(SEARCH_KEY, Keys.RETURN)
                clickSafe(POPUP_BTN_CLOSE)
                getElements(NEXT_CHECKBOX_INPUT)?.first()?.click()
                getElements(ITEM)?.get(3)?.click()
                switchToLastTab()
                takeScreenshot()
            } finally {
                this.quit()
            }
        }
    }
}