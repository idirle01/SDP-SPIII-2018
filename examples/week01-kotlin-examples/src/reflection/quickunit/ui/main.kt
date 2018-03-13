package reflection.quickunit.ui

import reflection.quickunit.TestRunner
import java.util.*

// This simple console-mode user interface asks the user to state the
// name of the test class.  It then runs the test methods in that class
// and reports the results.

fun main(args: Array<String>) {
    val consoleIn = Scanner(System.`in`)

    print("Test class name: ")
    val testClassName = consoleIn.nextLine().trim { it <= ' ' }

    if (testClassName.length == 0) {
        return
    }

    try {
        val results = TestRunner().runTests(testClassName)

        for (result in results) {
            print(
                    result.testClassName
                            + "." + result.testName + ": ")

            if (result.wasSuccessful()) {
                println("SUCCEEDED")
            } else {
                println("FAILED")

                // Since exceptions can contain other exceptions,
                // we'll print all of the exceptions in the "chain"
                // when there is a failure.
                result.failureReason.printStackTrace(System.out)
            }
        }
    } catch (e: Exception) {
        println("Could not execute tests")
        e.printStackTrace()
    }

}