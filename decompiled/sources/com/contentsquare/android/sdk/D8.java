package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nWebViewDomUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewDomUpdater.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/WebViewDomUpdater\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,55:1\n819#2:56\n847#2,2:57\n*S KotlinDebug\n*F\n+ 1 WebViewDomUpdater.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/WebViewDomUpdater\n*L\n35#1:56\n35#1:57,2\n*E\n"})
/* loaded from: classes2.dex */
public final class D8 {

    @NotNull
    public final K a;
    public int b;

    @NotNull
    public final Logger c;

    public D8(@NotNull K webViewAssetCache) {
        Intrinsics.checkNotNullParameter(webViewAssetCache, "webViewAssetCache");
        this.a = webViewAssetCache;
        this.c = new Logger("WebViewDomUpdater");
    }
}
