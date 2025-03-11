package PractiseProject.Utilities;

import org.testng.asserts.SoftAssert;

public class CustomSoftAssertion extends SoftAssert {
    /*The static instance softAssertion ensures that all soft assertions
    are collected in the same object throughout the test execution.
    If we create a new object each time, assertions will be scattered across
    different objects, and calling assertAll() won’t validate all collected assertions.*/
    public static CustomSoftAssertion softAssertion = new CustomSoftAssertion();

    public static void customAssertAll() {
        try {
            //assertAll() method which checks all collected soft assertions. If any assertion fails, it throws an exception.
            softAssertion.assertAll("Custom Soft Assertion");
            /*Normally, assertAll() stops the test immediately if any assertion fails.
            Here, we catch the exception to prevent the entire test from crashing.
            Instead, we just print "Custom Soft Assertion Failed" and continue execution.*/
        } catch (Exception e) {
            System.out.println("Custom Soft Assertion Failed");
        }

    }
}
