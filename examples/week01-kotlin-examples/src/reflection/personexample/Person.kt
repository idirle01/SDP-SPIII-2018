package reflection.personexample

// Person.java
//
// Informatics 102 Spring 2012
// Code Example
//
// This is a straightforward Person class, which we'll write unit tests
// against in the PersonTest class.  There is an intentional bug here,
// where the getName() method returns the wrong result, so that a test
// will fail.  Try fixing the bug and watching the test succeed
// afterward.

data class Person(var name: String? = null, var phoneNumber: String? = null)

