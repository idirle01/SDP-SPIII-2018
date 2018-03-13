// Test.java
//
// Informatics 102 Spring 2012
// Code Example
//
// This annotation is intended to be placed on methods that are unit tests
// that we'd like QuickUnit to be able to execute.  The annotation should
// only be permitted to be used on methods.  It's critically important,
// too, that the annotation be available at run-time, since we want
// QuickUnit to be able to find these methods automatically.  So, as we've
// seen before, we specify a "retention policy" so the annotation will
// exist at run-time.

package reflection.quickunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test
{
}
