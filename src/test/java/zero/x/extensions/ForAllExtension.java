package zero.x.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

public class ForAllExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("After all");
        context.getRoot().getStore(Namespace.GLOBAL).put("test", new CloseableOnlyOnceResource());
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("Before all");
        context.getTestClass().ifPresent(c -> System.out.println(c.getName()));
    }

    private static class CloseableOnlyOnceResource implements
        ExtensionContext.Store.CloseableResource {

        @Override
        public void close() {
            System.out.println("done");
        }
    }

}
