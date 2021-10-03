package consts

import org.openqa.selenium.By

object WebElements {
    val POPUP_BTN_CLOSE = By.xpath("*[@class='btn-close']")
    val SEARCH_KEY_BOX = By.xpath("//*[@class='search-key-box']")
    val SEARCH_KEY = By.xpath("//*[@class='search-key']")
    val NEXT_CHECKBOX_INPUT = By.xpath("//*[contains(@class,'next-checkbox-input')]")
    val ARIA_CHECKED = By.xpath("//*[@aria-checked='true']")
    val ITEM = By.xpath("//*[@class='_1OUGS']")
}