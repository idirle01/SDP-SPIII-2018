// TestRunnerFailureException.java
//
// Informatics 102 Spring 2012
// Code Example
//
// This exception is thrown from a TestRunner when it is unable to execute
// tests from a class because, for example, the class does not exist.  This
// kind of failure is distinct from the failure of an individual test method,
// which can be represented by any exception that is convenient.
//
// Note that there are four constructors here.  These mirror the ones that
// are typically included in most exceptions in the Java library, which
// allow exceptions to optionally specify a string "message" to be included
// and, separately, to optionally specify a "cause" (i.e., an exception to
// be embedded within the exception we're constructing, when we want to
// provide additional information about a failure).

package reflection.quickunit;


public class TestRunnerFailureException extends RuntimeException
{
	public TestRunnerFailureException()
	{
	}
	
	
	public TestRunnerFailureException(String message)
	{
		super(message);
	}
	
	
	public TestRunnerFailureException(Exception cause)
	{
		super(cause);
	}
	
	
	public TestRunnerFailureException(String message, Exception cause)
	{
		super(cause);
	}
}
