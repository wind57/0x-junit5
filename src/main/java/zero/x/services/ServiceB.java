package zero.x.services;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class ServiceB {

    public Set<String> setWithTwoElements(String one, String two) {
        return ImmutableSet.of(one, two);
    }
}
