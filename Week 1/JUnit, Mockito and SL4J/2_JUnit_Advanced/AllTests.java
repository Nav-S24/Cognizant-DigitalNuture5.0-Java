import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

// Requires the junit-platform-suite dependency in your pom.xml:
//
// <dependency>
//     <groupId>org.junit.platform</groupId>
//     <artifactId>junit-platform-suite</artifactId>
//     <version>1.10.2</version>
//     <scope>test</scope>
// </dependency>
@Suite
@SelectClasses({
        EvenCheckerTest.class,
        ExceptionThrowerTest.class,
        PerformanceTesterTest.class
})
public class AllTests {
    // No body needed -- annotations drive the suite
}
