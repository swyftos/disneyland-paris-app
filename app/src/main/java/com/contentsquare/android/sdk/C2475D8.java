package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.D8 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nWebViewDomUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewDomUpdater.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/WebViewDomUpdater\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,55:1\n819#2:56\n847#2,2:57\n*S KotlinDebug\n*F\n+ 1 WebViewDomUpdater.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/WebViewDomUpdater\n*L\n35#1:56\n35#1:57,2\n*E\n"})
public final class C2475D8 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2536K f1528a;

    /* JADX INFO: renamed from: b */
    public int f1529b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f1530c;

    public C2475D8(@NotNull C2536K webViewAssetCache) {
        Intrinsics.checkNotNullParameter(webViewAssetCache, "webViewAssetCache");
        this.f1528a = webViewAssetCache;
        this.f1530c = new Logger("WebViewDomUpdater");
    }
}
