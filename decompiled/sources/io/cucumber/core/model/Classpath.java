package io.cucumber.core.model;

import java.net.URI;

/* loaded from: classes5.dex */
public class Classpath {
    public static final String CLASSPATH_SCHEME = "classpath";
    public static final String CLASSPATH_SCHEME_PREFIX = "classpath:";

    public static String resourceName(URI uri) {
        if (!CLASSPATH_SCHEME.equals(uri.getScheme())) {
            throw new IllegalArgumentException("uri must have classpath scheme " + uri);
        }
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        return schemeSpecificPart.startsWith("/") ? schemeSpecificPart.substring(1) : schemeSpecificPart;
    }
}
