// TestResult.java
//
// Informatics 102 Winter 2010
// Code Example
//
// The TestResult class encapsulates the result of executing one test
// method.  There are two possible results that a QuickUnit test can
// have: success or failure.  Failures are indicated by exceptions
// being thrown from test methods; by storing that exception within
// the TestResult, our user interface will be able to dipslay the exception
// that caused the failure.

package reflection.quickunit;


public class TestResult
{
	// We'll use this method to create TestResults that indicate
	// successful tests.
	public static TestResult forSuccess(String testClassName, String testName)
	{
		return new TestResult(testClassName, testName, true, null);
	}
	
	
	// We'll use this method to create TestResults tat indicate
	// failed tests.
	public static TestResult forFailure(
		String testClassName, String testName, Throwable reason)
	{
		if (reason == null)
		{
			throw new IllegalArgumentException("reason must not be null");
		}
		
		return new TestResult(testClassName, testName, false, reason);
	}
	

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
	// (2) We can be ensured that it is impossible to create a TestResult
	//     that isn't sensible, such as one that says it's a failure but
	//     includes no reason for failure.
	private TestResult(
		String testClassName, String testName,
		boolean wasSuccessful, Throwable failureReason)
	{
		this.testClassName = testClassName;
		this.testName = testName;
		this.wasSuccessful = wasSuccessful;
		this.failureReason = failureReason;
	}
	
	
	private String testClassName;
	private String testName;
	private boolean wasSuccessful;
	private Throwable failureReason;
	
	
	public String getTestClassName()
	{
		return testClassName;
	}
	
	
	public String getTestName()
	{
		return testName;
	}
	
	
	public boolean wasSuccessful()
	{
		return wasSuccessful;
	}
	
	
	public Throwable getFailureReason()
	{
		return failureReason;
	}
}
