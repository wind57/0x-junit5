open module zero.x {

    requires com.google.common;
    requires org.junit.jupiter.api;

    provides org.junit.jupiter.api.extension.Extension with zero.x.extensions.CommonForAllExtension;
}