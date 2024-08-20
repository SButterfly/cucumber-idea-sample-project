package com.airwallex.paymentacceptance.testing.runners

import io.cucumber.testng.AbstractTestNGCucumberTests
import io.cucumber.testng.CucumberOptions
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.io.File

@CucumberOptions(
    plugin = ["pretty","json:build/reports/cucumber.json", "rerun:build/rerun/rerun.txt"],
    features = ["src/test/resources/features"],
    glue = ["com.airwallex.paymentacceptance.testing"],
    publish = false,
    dryRun = false,
    /*
    * multiple tags filter:
    * 1. run scenario with tags include both p1 and p2:
    *  - tags = "@p1 and @p2"
    * 2. run scenario with tags include p1 or include p2:
    *  - tags = "@p1 or @p2"
    * 3. run scenario with tags include p1 and not include p2:
    *  - tags = "@p1 and not @p2"
    * */
    tags = "@p1"
)

@Test
class TestNgCucumberRunner : AbstractTestNGCucumberTests() {
    @Override
    @DataProvider(parallel = true)
    override fun scenarios(): Array<Array<Any>> {
        return super.scenarios()
    }

    @BeforeSuite
    fun deleteReportFolder() {
        val file = File("./build/reports/")
        println(file.absolutePath)
        try {
            file.deleteRecursively()
            println("Report Directory deleted successfully.")
        } catch (_: Exception) {}

        val folder = File("./build/userBrowserContext/")
        println(file.absolutePath)
        try {
            folder.deleteRecursively()
            println("User Browser Context Directory deleted successfully.")
        } catch (_: Exception) {}
    }
}
