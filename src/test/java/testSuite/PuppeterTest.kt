package testSuite

import org.junit.jupiter.api.Test
import props.Config.baseUrl

class PuppeterTest {
    @Test
    fun test() {
        Driver.driver.apply {
            this.get(baseUrl)
        }
    }

}