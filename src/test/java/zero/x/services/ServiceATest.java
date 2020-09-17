package zero.x.services;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceATest {

    private final ServiceA serviceA = new ServiceA();

    @Test
    public void testA() {
        System.out.println("testA");
        List<String> list = serviceA.listWithTwoElements("one", "two");
        Assertions.assertEquals(list.size(), 2);
    }

}
