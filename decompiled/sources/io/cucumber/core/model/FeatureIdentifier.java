package io.cucumber.core.model;

import java.net.URI;

/* loaded from: classes5.dex */
public class FeatureIdentifier {
    public static URI parse(String str) {
        return parse(FeaturePath.parse(str));
    }

    public static URI parse(URI uri) {
        if (isFeature(uri)) {
            return uri;
        }
        throw new IllegalArgumentException("featureIdentifier does not reference a single feature file: " + uri);
    }

    public static boolean isFeature(URI uri) {
        return uri.getSchemeSpecificPart().endsWith(".feature");
    }
}
