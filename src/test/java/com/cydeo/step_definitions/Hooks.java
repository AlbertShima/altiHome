package com.cydeo.step_definitions;
/*
In the class we will be able to pass pre- & post- conditions to
each scenario and each step
*/

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {
    //import from io.cucumber.java not from unit
    @After
    public void tearDown() {
        Driver.closeDriver();
    }
    /*
    @Before
    public void setupScenario () {
        System.out.println("@Stetting up browser using cucumber @Before");
    }

    @BeforeStep
    public void setupStep() {
        System.out.println("-- applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep() {
        System.out.println(" applying tearDown using @AfterStep");
    }

     */
}
