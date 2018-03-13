// Main.java
//
// Informatics 102 Spring 2012
// Code Example
//
// This simple console-mode user interface asks the user to state the
// name of the test class.  It then runs the test methods in that class
// and reports the results.
//
// Try running this program and typing "inf102.personexample.PersonTest"
// to see how our unit testing framework works.

package reflection.quickunit.ui;

import reflection.quickunit.TestResult;
import reflection.quickunit.TestRunner;
import java.util.List;
import java.util.Scanner;


public class Main
{
	public static void main(String[] args)
	{
		Scanner consoleIn = new Scanner(System.in);
		
		System.out.print("Test class name: ");
		String testClassName = consoleIn.nextLine().trim();
		
		if (testClassName.length() == 0)
		{
			return;
		}

		try
		{
			List<TestResult> results = new TestRunner().runTests(testClassName);
			
			for (TestResult result : results)
			{
				System.out.print(
					result.getTestClassName()
					+ "." + result.getTestName() + ": ");
				
				if (result.wasSuccessful())
				{
					System.out.println("SUCCEEDED");
				}
				else
				{
					System.out.println("FAILED");
					
					// Since exceptions can contain other exceptions,
					// we'll print all of the exceptions in the "chain"
					// when there is a failure.
					Throwable reason = result.getFailureReason();
					
					while (reason != null)
					{
						reason.printStackTrace(System.out);
						reason = reason.getCause();
					}
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Could not execute tests");
			e.printStackTrace();
		}
	}
}
