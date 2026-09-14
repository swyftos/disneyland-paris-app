package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1836d2 = {"getBackingMap", "Lcom/facebook/react/bridge/ReadableMap;", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ReactStylesDiffMapHelperKt {
    @NotNull
    public static final ReadableMap getBackingMap(@NotNull ReactStylesDiffMap reactStylesDiffMap) {
        Intrinsics.checkNotNullParameter(reactStylesDiffMap, "<this>");
        ReadableMap mBackingMap = reactStylesDiffMap.mBackingMap;
        Intrinsics.checkNotNullExpressionValue(mBackingMap, "mBackingMap");
        return mBackingMap;
    }
}
