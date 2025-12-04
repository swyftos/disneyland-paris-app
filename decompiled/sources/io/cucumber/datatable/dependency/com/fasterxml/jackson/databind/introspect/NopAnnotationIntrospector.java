package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Version;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.AnnotationIntrospector;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.io.Serializable;

/* loaded from: classes5.dex */
public abstract class NopAnnotationIntrospector extends AnnotationIntrospector implements Serializable {
    public static final NopAnnotationIntrospector instance = new NopAnnotationIntrospector() { // from class: io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector.1
        private static final long serialVersionUID = 1;

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.AnnotationIntrospector, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Versioned
        public Version version() {
            return PackageVersion.VERSION;
        }
    };
    private static final long serialVersionUID = 1;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.AnnotationIntrospector, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Versioned
    public Version version() {
        return Version.unknownVersion();
    }
}
