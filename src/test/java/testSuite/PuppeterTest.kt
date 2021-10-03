package testSuite

import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import props.Config.baseUrl
import testSuite.Driver.click
import testSuite.Driver.getElements
import testSuite.Driver.pressKey
import testSuite.Driver.takeScreenshot
import testSuite.Driver.type
import testSuite.Driver.waitForElement


class PuppeterTest {
    @Test
    fun test() {
        Driver.driver.apply {
            this.get(baseUrl)
            try {
                click(By.xpath("//*[contains(@class,'CouponPopup_CouponPopup__closeButton')]"))
                click(By.className("Header_SearchInput__combobox__85mzj"))
                type(By.xpath("//*[contains(@class,'Header_SearchInput__input')]"), "nylon shoulder bag")
                pressKey(By.xpath("//*[contains(@class,'Header_SearchInput__input')]"), Keys.RETURN)
                click(By.xpath("//*[contains(@class,'next-dialog-close')]"))
                //TODO
                waitForElement(By.xpath("//*[contains(@class,'next-checkbox-input')]"))
                getElements(By.xpath("//*[contains(@class,'next-checkbox-input')]"))?.first()?.click()
                click(By.xpath("//*[@product-index='3']"))
                takeScreenshot()

            } finally {
                this.quit()
            }

        }
    }

}