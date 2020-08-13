package zero.x.services;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class ServiceA {

    public List<String> listWithTwoElements(String one, String two) {
        return ImmutableList.of(one, two);
    }

}
