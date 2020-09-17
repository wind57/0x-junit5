package zero.x.services;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import zero.x.extensions.CassandraIntegrationTest;
import zero.x.extensions.IntegrationTest;

@CassandraIntegrationTest
public class ServiceATest {

    private final ServiceA serviceA = new ServiceA();

    @IntegrationTest
    public void testA() {
        System.out.println("testA");
        List<String> list = serviceA.listWithTwoElements("one", "two");
        Assertions.assertEquals(list.size(), 2);
    }

}
