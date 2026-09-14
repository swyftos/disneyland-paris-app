package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public interface NativeModule {
    default boolean canOverrideExistingModule() {
        return false;
    }

    @Nonnull
    String getName();

    void initialize();

    void invalidate();

    @Deprecated(forRemoval = true, since = "Use invalidate method instead")
    default void onCatalystInstanceDestroy() {
    }
}
