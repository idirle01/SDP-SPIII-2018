// TestRunner.java
//
// Informatics 102 Spring 2012
// Code Example
//
// This class is where the "meat" of our QuickUnit framework is written.
// Its job is to find all of the test methods in some class, execute each
// of them, and return a list of the results of executing each.
//
// QuickUnit places restrictions on Test methods.  They must:
//
// * have a @Test annotation on them
// * be public
// * be declared in a class with a no-argument constructor
// * return void
// * take no parameters
//
// Those restrictions are checked and only methods that meet all of these
// requirements are considered to be tests; others are silently ignored.
//
// Reflection is used throughout.  Individual uses of reflection are
// explained where they occur.

package reflection.quickunit;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;


public class TestRunner
{
	// runTests() takes the fully-qualified name of a class, finds the
	// QuickUnit test methods in that class, executes those tests, and
	// returns a list of the results of executing them.
	//
	// Note that, by fully-qualified name, I mean the name of the class
	// including its package, if any.  So, for example, we might pass
	// "inf102.personexample.PersonTest", if we want to execute the tests
	// in the PersonTest class in the inf102.personexample package.
	public List<TestResult> runTests(String testClassName)
	{
		// Load the Class object representing the class whose name we were
		// given.  Every class in a Java program has a Class object that
		// represents it.  Here, we want that Class object, which we'll
		// need for use throughout this TestRunner.
		Class<?> testClass = loadTestClass(testClassName);
		
		// One of the requirements of QuickUnit test methods is that they
		// appear in classes with no-arg constructors.  This is because
		// the basic model for executing tests is to do this:
		//
		// * Create an object of the test class
		// * Call a test method on that object
		//
		// Each test method executes against a separate object of the
		// test class.  This ensures that tests are isolated from one
		// another, so the effects of one don't affect the results of
		// others.
		//
		// Here, we're calling a method that will verify that our test
		// class has a no-arg constructor.  If it doesn't, we don't have
		// any test methods, so we'll throw an exception.
		requireThatClassHasNoArgConstructor(testClass);
		
		// Now we'll loop through the test class' methods, checking
		// whether each is a test method; for those that are test methods,
		// we'll execute them and collect up the results into a list that
		// we'll return when we're done.  Each method in a class has a
		// Method object that represents it, which we use when we want to
		// find out details about it at run-time
		//
		// Note the call to getMethods() on testClass; this asks for all
		// of the public methods in the test class, which we can then
		// iterate through using a "foreach" loop.
		
		List<TestResult> results = new ArrayList<TestResult>();
		
		for (Method method : testClass.getMethods())
		{
			if (isTestMethod(method))
			{
				results.add(runTest(method));
			}
		}
		
		return results;
	}
	
	
	// loadTestClass() takes the fully-qualified name of a class and loads
	// the Class object that describes it.
	//
	// Note that the Class class is generic.  The idea is that the object
	// that describes the String class is actually a Class<String>.  When
	// we know what kind of class we've loaded, we can use this to be
	// specific.  In this case, we have no idea what class we're loading;
	// it's determined by the value of testClassName at run-time.  So we
	// say "Class<?>", which is how you use a generic class when you're
	// not sure what the type parameter should be.  The "?" in this context
	// is called a "wildcard."  There are some fairly hairy rules that
	// deal with wildcard type parameters, but we'll avoid them here.
	//
	// If loading the class fails, a TestRunnerFailureException is thrown.
	private Class<?> loadTestClass(String testClassName)
	{
		try
		{
			// The static method Class.forName is how you load a class
			// given its name.  The result is the Class object that
			// corresponds to the class -- or an exception if the class
			// doesn't exist.
			return Class.forName(testClassName);
		}
		catch (Exception e)
		{
			throw new TestRunnerFailureException(
				"Could not load test class", e);
		}
	}


	// requireThatClassHasNoArgConstructor() checks whether the given class
	// has a constructor that takes no arguments.  If it does, nothing is
	// done; if it doesn't, a TestRunnerFailureException is thrown.
	private void requireThatClassHasNoArgConstructor(Class<?> testClass)
	{
		// To check this, we'll need to find out about the test class'
		// constructors.  There are two ways to do it:
		//
		// * Get all the constructors using the getConstructors() method,
		//   then iterate through them.
		// * Find a constructor that takes certain kinds of parameters
		//   (in this case, none), using the getConstructor() method.
		//
		// The latter is a better approach, so we'll go with that; it'll
		// save us from writing a loop.
		//
		// To ask for a constructor with no arguments, we call getConstructor()
		// and pass it no arguments.  If, instead, we were interested in
		// constructors with two String arguments, we'd say this instead:
		//
		//     testClass.getConstructor(String.class, String.class)
		//
		// where "String.class" means "Give me the Class object corresponding
		// to the type String."  All types, including primitive types and
		// "void", can be followed by ".class" to get the Class object
		// corresponding to that type.
		//
		// getConstructor() returns null if there is no such constructor
		// or a Constructor object if there is.  In this case, we just
		// care whether it exists, so we'll check the result to see if it's
		// null.

		try
		{
			if (testClass.getConstructor() == null)
			{
				throw new TestRunnerFailureException(
					"No default constructor available in test class");
			}
		}
		catch (Exception e)
		{
			throw new TestRunnerFailureException(
				"No default constructor available in test class");
		}
	}


	// A method is a test method if it has these attributes:
	//
	// * It has the @Test annotation on it
	// * It is public
	// * It is not static
	// * It returns void
	// * It takes no parameters
	private boolean isTestMethod(Method method)
	{
		// There's a lot going on here.  Each subexpression verifies one
		// of the attributes listed above.
		//
		// * The getAnnotation() method takes the Class object representing
		//   an annotation type (in this case, Test.class, which represents
		//   our @Test annotation) and returns that annotation if the given
		//   method has it, null if not.  So we'll check that we got back an
		//   annotation (i.e., not null).
		// * The getModifiers() method asks for a method's "modifiers" (e.g.,
		//   public, private, static, final, etc.).  They come back as an
		//   int that encodes all of them.  The Modifier.isXXX() methods,
		//   such as Modifier.isPublic() and Modifier.isStatic() let us ask
		//   whether a set of modifiers contains the one we're asking about.
		// * The getReturnType() method asks a method for its return type.
		//   In this case, we want to know whether the return type is null,
		//   which is represented by the Class object associated with the
		//   void type, which we can access by saying "void.class".
		// * The getParameterTypes() method returns an array containing the
		//   Class objects corresponding to the method's parameters.  In
		//   this case, we just want to know that there are no parameters,
		//   so we check that the length of that array is zero.
		
		return method.getAnnotation(Test.class) != null
			&& Modifier.isPublic(method.getModifiers())
			&& !Modifier.isStatic(method.getModifiers())
			&& method.getReturnType() == void.class
			&& method.getParameterTypes().length == 0;
	}


	// runTest() takes the Method object corresponding to a test method
	// and executes the test, returning a TestResult that represents
	// the result of running the test.
	private TestResult runTest(Method method)
	{
		try
		{
			// When called on a Method object, the getDeclaringClass()
			// method returns the Class object corresponding to the class
			// in which the method is declared.  The newInstance() method,
			// when called on a Class object, creates a new object of
			// that class.  newInstance() requires whatever parameters
			// are to be passed to the constructor; in this case, we've
			// already ensured that the constructor will have no parameters
			// because of previous checks, so we can safely pass no
			// parameters to newInstance().
			//
			// Note that what I get back here is an Object reference.  It
			// refers to some other kind of object -- an object of the class
			// whose name was passed to runTests() initially -- but we can't
			// be sure, at compile-time, what it is.  So we'll do the
			// safe thing, which is to store an Object reference to it;
			// no matter what kind of object we created, it's some kind
			// of Object, so an Object reference can point to it.
			Object testObject = method.getDeclaringClass().newInstance();

			// Invoking a method reflectively requires calling an invoke()
			// method on a Method object.  Normally, when you call a method,
			// you say something like this:
			//
			//     x.foo(y, z)
			//
			// which says "call the foo method on x, passing it y and z as
			// parameters."  To make the same call reflectively, you'd say
			// something more like this:
			//
			//     fooMethod.invoke(x, y, z);
			//
			// assuming that fooMethod is a Method object representing the
			// foo() method.
			//
			// In this case, we want to call the method on our newly-
			// created test object, but the method takes no parameters.
			// So we just pass one parameter, the test object, to invoke().
			method.invoke(testObject);

			// If we got this far, the test method didn't throw an exception,
			// so we should return success.
			return TestResult.forSuccess(
				method.getDeclaringClass().getName(),
				method.getName());
		}
		catch (InvocationTargetException e)
		{
			// An InvocationTargetException is thrown when a method invoked
			// using reflection throws an exception.  The InvocationTarget-
			// Exception contains a "cause," which is the exception that
			// was actually thrown from the method.
			//
			// For our framework, we should specify that the cause of the
			// test's failure was the exception that the test method
			// threw, as opposed to the InvocationTargetException that
			// contains it.  So we'll get the cause and use that as our
			// failure reason.
			
			return TestResult.forFailure(
				method.getDeclaringClass().getName(),
				method.getName(), e.getCause());
		}
		catch (Exception e)
		{
			// Any other exception indicates some kind of failure before
			// we were able to invoke the method, so we'll just pass it
			// along as the reason the test failed.
			
			return TestResult.forFailure(
				method.getDeclaringClass().getName(),
				method.getName(), e);
		}
	}
}
