package zero.x.services;

import java.util.Set;
import org.junit.jupiter.api.Assertions;
import zero.x.extensions.IntegrationExtension;
import zero.x.extensions.IntegrationTest;

@IntegrationExtension
public class ServiceBTest {

    private final ServiceB serviceB = new ServiceB();

    @IntegrationTest
    public void testB() {
        System.out.println("testB");
        Set<String> set = serviceB.setWithTwoElements("one", "two");
        Assertions.assertEquals(set.size(), 2);
    }

}
