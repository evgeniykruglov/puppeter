package props

import consts.Constants
import consts.Constants.APPLICATION_PROPERTIES
import java.io.File
import java.io.FileReader
import java.util.*

object Config {
    private val props = Properties().apply { load(FileReader(File(APPLICATION_PROPERTIES))) }

    val operatingSystem = props.getProperty("system")
    val baseUrl = props.getProperty("baseUrl")
    val driverPath = when (Config.operatingSystem) {
        "linux" -> "${Constants.RESOURCES_PATH}/chromedriver"
        "win" -> "${Constants.RESOURCES_PATH}/chromedriver.exe"
        else -> throw IllegalArgumentException("Property system can be only `linux` or `win`")
    }
}