package zero.x.services;

import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceBTest {

    private final ServiceB serviceB = new ServiceB();

    @Test
    public void testB() {
        System.out.println("testB");
        Set<String> set = serviceB.setWithTwoElements("one", "two");
        Assertions.assertEquals(set.size(), 2);
    }

}
