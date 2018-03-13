package reflection.personexample

import reflection.quickunit.Test

// This is a QuickUnit test class, containing QuickUnit test methods.

class PersonTest {
    val NAME = "Argie Bargy"
    val PHONE_NUMBER = "949-123-4567"

    @Test
    fun whenCreatedWithoutAPhoneNumberPersonsHaveNoPhoneNumber() {
        val p = Person(NAME)

        // If we get back something other than null, that indicates a
        // test failure, so we'll throw an exception.  It doesn't
        // matter what kind of exception we throw, so we'll throw a
        // bare RuntimeException (so we don't have to say "throws").
        if (p.phoneNumber != null) {
            throw RuntimeException(
                    "non-null phone number returned when null was expected")
        }

        // I should point out that there are better ways to do this.  JUnit,
        // for example, includes a variety of assert methods, which throw
        // an AssertionFailedException when they don't have the desired
        // result.  For example, we could write the if statement above
        // this way instead:
        //
        //     assertNull(p.phoneNumber);
        //
        // If you'd like to take this example a little further, write a
        // simple assert mechanism like the one provided by JUnit.  It's
        // surprisingly little work -- JUnit has an Assert class with a
        // set of static assert methods, which throw an AssertionError when
        // the assertions fail and have no effect when they succeed.
    }


    @Test
    fun whenCreatedWithANamePersonsHaveThatName() {
        val p = Person(NAME, PHONE_NUMBER)
        val personName = p.name

        if (personName != NAME) {
            throw RuntimeException(
                    "getName() returned " + personName
                            + "; '$NAME' expected")
        }
    }
}
