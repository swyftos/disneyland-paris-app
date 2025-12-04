package com.contentsquare.android.internal.features.webviewbridge.assets;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.features.srm.SrmKeysCache;
import com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset;
import com.contentsquare.android.sdk.C5;
import com.contentsquare.android.sdk.G6;
import com.contentsquare.android.sdk.K;
import com.contentsquare.android.sdk.L;
import com.contentsquare.android.sdk.L6;
import com.contentsquare.android.sdk.M6;
import com.contentsquare.android.sdk.M8;
import com.contentsquare.android.sdk.P0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nWebViewAssetsProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewAssetsProcessor.kt\ncom/contentsquare/android/internal/features/webviewbridge/assets/WebViewAssetsProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1855#2,2:135\n1855#2,2:137\n1855#2,2:139\n1549#2:141\n1620#2,3:142\n819#2:145\n847#2,2:146\n*S KotlinDebug\n*F\n+ 1 WebViewAssetsProcessor.kt\ncom/contentsquare/android/internal/features/webviewbridge/assets/WebViewAssetsProcessor\n*L\n69#1:135,2\n73#1:137,2\n75#1:139,2\n108#1:141\n108#1:142,3\n120#1:145\n120#1:146,2\n*E\n"})
/* loaded from: classes2.dex */
public final class a {

    @NotNull
    public static final Logger d = new Logger("WebViewAssetsProcessor");

    @NotNull
    public final K a;

    @NotNull
    public final M6 b;

    @NotNull
    public final P0 c;

    public a(@NotNull K webViewAssetsCache, @NotNull M6 staticResourceManager, @NotNull P0 cssProcessor) {
        Intrinsics.checkNotNullParameter(webViewAssetsCache, "webViewAssetsCache");
        Intrinsics.checkNotNullParameter(staticResourceManager, "staticResourceManager");
        Intrinsics.checkNotNullParameter(cssProcessor, "cssProcessor");
        this.a = webViewAssetsCache;
        this.b = staticResourceManager;
        this.c = cssProcessor;
    }

    public final void a(@NotNull List<WebViewAsset> assets, @Nullable String str, boolean z) {
        C5 c5;
        Intrinsics.checkNotNullParameter(assets, "assets");
        if (z) {
            for (WebViewAsset asset : assets) {
                asset.d = null;
                K k = this.a;
                String assetId = asset.a;
                k.getClass();
                Intrinsics.checkNotNullParameter(assetId, "assetId");
                if (!k.a.containsKey(assetId)) {
                    K k2 = this.a;
                    k2.getClass();
                    Intrinsics.checkNotNullParameter(asset, "asset");
                    k2.a.put(asset.a, asset);
                }
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (WebViewAsset webViewAsset : assets) {
            K k3 = this.a;
            String assetId2 = webViewAsset.a;
            k3.getClass();
            Intrinsics.checkNotNullParameter(assetId2, "assetId");
            WebViewAsset webViewAsset2 = k3.a.get(assetId2);
            if (webViewAsset2 != null) {
                if (webViewAsset2.f == WebViewAsset.a.DATA_CSS && str != null) {
                    webViewAsset2 = null;
                }
                if (webViewAsset2 != null) {
                    webViewAsset = webViewAsset2;
                }
            }
            webViewAsset.g = str;
            int iOrdinal = webViewAsset.f.ordinal();
            if (iOrdinal == 0) {
                arrayList3.add(webViewAsset);
            } else if (iOrdinal == 1) {
                arrayList2.add(webViewAsset);
            } else if (iOrdinal == 2) {
                arrayList.add(webViewAsset);
            } else if (iOrdinal == 3) {
                d.d("Cannot process unsupported asset " + webViewAsset.a);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            a((WebViewAsset) it.next());
        }
        if (str != null) {
            Iterator it2 = this.c.a(arrayList3, arrayList2).iterator();
            while (it2.hasNext()) {
                a((WebViewAsset) it2.next());
            }
            return;
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            a((WebViewAsset) it3.next());
        }
        if (!arrayList.isEmpty() && (c5 = C5.k) != null) {
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                arrayList4.add(((WebViewAsset) it4.next()).a);
            }
            M8 event = new M8(arrayList4);
            Intrinsics.checkNotNullParameter(event, "event");
            c5.d.a(event);
            d.d("Sent " + arrayList4.size() + " remote asset events to SR");
        }
        a(arrayList2);
        a(arrayList3);
    }

    public final void a(WebViewAsset asset) {
        JsonConfig.StaticResourceManager staticResourceManager;
        JsonConfig.ProjectConfiguration projectConfig = this.b.e.getProjectConfig();
        if (!((projectConfig == null || (staticResourceManager = projectConfig.getStaticResourceManager()) == null) ? false : staticResourceManager.getEnabled())) {
            d.d("Static Resource Manager feature disabled");
            return;
        }
        String element = asset.e;
        WebViewAssetContent webViewAssetContent = asset.d;
        byte[] data = webViewAssetContent != null ? webViewAssetContent.c : null;
        String mimeType = webViewAssetContent != null ? webViewAssetContent.a : null;
        if (element != null && data != null && mimeType != null) {
            M6 m6 = this.b;
            synchronized (m6) {
                try {
                    Intrinsics.checkNotNullParameter(element, "key");
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(mimeType, "mimeType");
                    SrmKeysCache srmKeysCache = m6.b;
                    srmKeysCache.getClass();
                    Intrinsics.checkNotNullParameter(element, "element");
                    LinkedHashSet linkedHashSet = srmKeysCache.d;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((SrmKeysCache.Key) it.next()).a);
                    }
                    if (!arrayList.contains(element)) {
                        m6.i.add(new G6(element, data, mimeType));
                        if (m6.i.size() >= m6.d) {
                            m6.f.d("Max bucket size reached");
                            JsonConfig.ProjectConfiguration projectConfig2 = m6.e.getProjectConfig();
                            if (projectConfig2 != null) {
                                BuildersKt__Builders_commonKt.launch$default(m6.h, null, null, new L6(m6, CollectionsKt.toList(m6.i), projectConfig2.getCsProjectId(), null), 3, null);
                                m6.i.clear();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            asset.d = null;
            K k = this.a;
            String assetId = asset.a;
            k.getClass();
            Intrinsics.checkNotNullParameter(assetId, "assetId");
            if (!k.a.containsKey(assetId)) {
                K k2 = this.a;
                k2.getClass();
                Intrinsics.checkNotNullParameter(asset, "asset");
                k2.a.put(asset.a, asset);
            }
            d.d("Asset sent to SRM: " + asset.a + " => " + asset.e);
            return;
        }
        d.d("Asset " + asset.a + " not sent to SRM: hash, payload or mimeType are null");
    }

    public static void a(ArrayList arrayList) {
        C5 c5 = C5.k;
        if (c5 == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (((WebViewAsset) next).e != null) {
                arrayList2.add(next);
            }
        }
        if (!arrayList2.isEmpty()) {
            L event = new L(arrayList2);
            Intrinsics.checkNotNullParameter(event, "event");
            c5.e.a(event);
        }
        d.d("Sent " + arrayList2.size() + " asset hash events to SR");
    }
}
