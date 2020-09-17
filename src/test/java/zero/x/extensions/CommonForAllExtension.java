package zero.x.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.platform.commons.support.AnnotationSupport;

/**
 * @author erabii
 * <p>
 * this is registered in module-info.java as the common extetnsio for all tests
 */
public class CommonForAllExtension implements BeforeAllCallback, AfterAllCallback {

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

        context.getTestClass().ifPresent(x -> {

            // only init this for classes that are annotated with CassandraIntegrationTest
            if (AnnotationSupport.isAnnotated(x, CassandraIntegrationTest.class)) {
                initiatedOnlyOnce();
            }
        });


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
