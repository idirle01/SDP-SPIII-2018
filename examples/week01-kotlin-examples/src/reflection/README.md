Code Example
--------------------------------

Java provides a mechanism called *reflection*, which allows executing Java
programs to ask questions about, and act on, their own structure.  For
example, questions like these can be asked:

* What class does this object belong to?
* What methods does this class have?
* What are this method's parameters?
* What annotations are associated with this method?

The reflection mechanism can also apply to most languages that compile and
run on the JVM.

We can also load classes dynamically that are not named explicitly within
our program, then create objects of these classes, call methods on them,
and so on, without having access to the source code and without knowing
about these classes until the program executes.  This sounds strange, but
it enables some techniques that can't be achieved without them.

One tool you may have seen in the past is called `JUnit`.  `JUnit` is a Java-
based framework for writing unit tests that is also utilised by other languages 
(e.g., Kotlin).  
Any method/function can be made a JUnit test
by placing a special annotation on it.  That test will be considered a
`success` if it doesn't throw an exception, or a `failure` if it does.

One of the most important things that JUnit is capable of doing is finding
all of the tests you marked with their annotation and executing them for
you automatically.  (There is some work to be done in identifying classes
that may contain tests, but that is done automatically by environments like
IntelliJ.)  To achieve this JUnit uses reflection; given the names of
classes that might contain test methods, JUnit is able to find those methods
automatically and execute them using reflection.  Note that without
reflection, this simply could not be done; there would need to be code that
acted as the "glue" between JUnit and your tests.  Reflection, however,
eliminates that glue by allowing JUnit to find and execute the tests
automatically at run-time.

In this code example, we have built a simplified unit testing framework called
`QuickUnit`, based upon a similar framework from the University of Edinburgh, 
which uses reflective techniques to find and execute unit tests
automatically.
