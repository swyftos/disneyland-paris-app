package androidx.webkit.internal;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public interface ConditionallySupportedFeature {
    @NonNull
    String getPublicFeatureName();

    boolean isSupported();
}
