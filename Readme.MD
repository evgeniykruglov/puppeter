# Puppeteer test

## Main issue

* Test goes to aliexpress.com, searches for “nylon shoulder bag”, selects the option “Fast shipping” and then clicks on
  the third product, then takes a screenshot of the page
    * Note: "Fast shipping" checkbox is absent on the page, so other checkbox "Free shipping" is selecting in the test

## Requirements

* Dependencies
    * Java 12
    * kotlin-stdlib-jdk8
    * junit-jupiter
    * selenium-java

## Structure

* Application.properties
    * `system=linux`
        * property `system` can have one of two values: `linux` or `win`. It depends on which chromedriver will be used
    * `baseUrl=http://aliexpress.com`
        * URL to aliexpress online shop
        * In Russia aliexpress has redirection to `aliexpress.ru`, which has another web-elements' naming, so need to
          use VPN on the host machine. Otherwise, test will be failed
* src/main/java/props/Config.kt
    * There props are read from application.properties
    * Assigning of val `driverPath` according which OS is selected
* src/main/resources
    * Directory with chromedriver binaries
* src/main/java/consts
    * Directory with constants and web-elements
* src/main/java/core/WebDriver.kt
    * Main core class with WebDriver and using methods
* src/test/java/testSuite/PuppeteerTest.kt
    * Test class which can be run

## Example of test running
