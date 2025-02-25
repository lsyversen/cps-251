package com.rich.billtip

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an actual Android device or emulator.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Retrieve the application context from the instrumentation framework
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        // Verify that the package name matches the expected package of the app
        assertEquals("com.rich.billtip", appContext.packageName)
    }
}
