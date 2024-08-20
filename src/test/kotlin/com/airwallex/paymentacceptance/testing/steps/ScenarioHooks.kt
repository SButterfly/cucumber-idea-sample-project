package com.airwallex.paymentacceptance.testing.steps

import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.Scenario

class ScenarioHooks {

    @Before
    fun setup(scenario: Scenario) {
        val tags = scenario.sourceTagNames

        scenario.log(
            """
            test tags :: $tags
            """.trimIndent()
        )
    }

    @After(order = 0)
    fun tearDown(scenario: Scenario) {
    }
}

