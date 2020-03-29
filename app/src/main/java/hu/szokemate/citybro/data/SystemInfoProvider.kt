package hu.szokemate.citybro.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SystemInfoProvider @Inject constructor() {

    @Suppress("TooGenericExceptionCaught")
    fun isInternetAvailable(): Boolean {
        val runtime = Runtime.getRuntime()

        try {
            val ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8")
            val exitValue = ipProcess.waitFor()
            return exitValue == 0
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return false
    }

}
