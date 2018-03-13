// The TestResult class encapsulates the result of executing one test
// method.  There are two possible results that a QuickUnit test can
// have: success or failure.  Failures are indicated by exceptions
// being thrown from test methods; by storing that exception within
// the TestResult, our user interface will be able to dipslay the exception
// that caused the failure.

package reflection.quickunit

// Note that we've made the constructor private.  This forces our
// factory methods, TestResult.success() and TestResult.failure(),
// to be used when creating TestResults.  This has two important
// benefits:
//
// (1) Code that creates TestResults will read more cleanly.  Instead
//     of saying something like this:
//
//         new TestResult(classname, name, true, null)
//
//     we can say this instead:
//
//         TestResult.forSuccess(classname, name)
//
// (2) We can be ensure that it is impossible to create a TestResult
//     that isn't sensible, such as one that says it's a failure but
//     includes no reason for failure.

class TestResult private constructor(
        val testClassName: String, val testName: String,
        private val wasSuccessful: Boolean, val failureReason: Throwable) {


    fun wasSuccessful(): Boolean {
        return wasSuccessful
    }

    companion object {
        // We'll use this method to create TestResults that indicate successful tests.
        fun forSuccess(testClassName: String, testName: String): TestResult {
            return TestResult(testClassName, testName, true, Exception())
        }


        // We'll use this method to create TestResults that indicate failed tests.
        fun forFailure(
                testClassName: String, testName: String, reason: Throwable?): TestResult {
            if (reason == null) {
                throw IllegalArgumentException("reason must not be null")
            }

            return TestResult(testClassName, testName, false, reason)
        }
    }
}
