package zero.x.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;

public class IntegrationTestExtension implements BeforeAllCallback, AfterAllCallback {

    private volatile boolean initiated;

    private static final Namespace INTEGRATION_TESTS_NAMESPACE = Namespace.create(new Object());

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println("After all");
        context.getRoot().getStore(INTEGRATION_TESTS_NAMESPACE)
               .getOrComputeIfAbsent("integration", x -> new IntegrationContextCloser());
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        initiatedOnlyOnce();
    }

    private void initiatedOnlyOnce() {
        if (!initiated) {
            System.out.println("Doing some set-up let's assume");
            initiated = true;
            return;
        }

        System.out.println("already initiated");
    }


    private static class IntegrationContextCloser implements
        ExtensionContext.Store.CloseableResource {

        private IntegrationContextCloser() {
            System.out.println("closer created");
        }

        @Override
        public void close() {
            System.out.println("done, closing context");
        }
    }
}
