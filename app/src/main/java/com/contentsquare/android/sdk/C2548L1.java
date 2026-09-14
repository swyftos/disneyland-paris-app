package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.L1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2548L1 extends Lambda implements Function1<Pair<? extends String, ? extends String>, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2538K1 f1808a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2499G2 f1809b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Ref.IntRef f1810c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Ref.IntRef f1811d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2548L1(C2538K1 c2538k1, C2499G2 c2499g2, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(1);
        this.f1808a = c2538k1;
        this.f1809b = c2499g2;
        this.f1810c = intRef;
        this.f1811d = intRef2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Pair<? extends String, ? extends String> pair) {
        Ref.IntRef intRef;
        int i;
        Pair<? extends String, ? extends String> result = pair;
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual(result, C2545K8.f1797d)) {
            this.f1811d.element--;
            intRef = this.f1810c;
            i = intRef.element + 1;
        } else {
            String serializationId = result.component1();
            String dom = result.component2();
            if (serializationId != null) {
                C2475D8 c2475d8 = this.f1808a.f1773b;
                synchronized (c2475d8) {
                    try {
                        Intrinsics.checkNotNullParameter(serializationId, "serializationId");
                        Intrinsics.checkNotNullParameter(dom, "dom");
                        c2475d8.f1530c.m827d("Start dom replacement for " + serializationId + " serialization id.");
                        while (c2475d8.f1529b < 10) {
                            C2536K c2536k = c2475d8.f1528a;
                            c2536k.getClass();
                            Intrinsics.checkNotNullParameter(serializationId, "serializationId");
                            Collection<WebViewAsset> collectionValues = c2536k.f1764a.values();
                            Intrinsics.checkNotNullExpressionValue(collectionValues, "cache.values");
                            ArrayList arrayList = new ArrayList();
                            for (Object obj : collectionValues) {
                                if (Intrinsics.areEqual(((WebViewAsset) obj).f1346g, serializationId)) {
                                    arrayList.add(obj);
                                }
                            }
                            ArrayList<WebViewAsset> arrayList2 = new ArrayList();
                            for (Object obj2 : arrayList) {
                                if (!StringsKt.endsWith$default(((WebViewAsset) obj2).f1342c, ".css", false, 2, (Object) null)) {
                                    arrayList2.add(obj2);
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                c2475d8.f1530c.m827d("Assets in cache, replacement will start");
                                String strReplace$default = dom;
                                for (WebViewAsset webViewAsset : arrayList2) {
                                    strReplace$default = StringsKt.replace$default(strReplace$default, webViewAsset.f1341b, "cs://resources/" + webViewAsset.f1344e, false, 4, (Object) null);
                                }
                                dom = strReplace$default;
                                break;
                            }
                            Thread.sleep(500L);
                            c2475d8.f1529b++;
                            c2475d8.f1530c.m827d("Assets not in cache for " + serializationId + ", wait and retry");
                        }
                        c2475d8.f1529b = 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            try {
                this.f1809b.f1640d = new JSONObject(dom);
                this.f1809b.f1643g = 2;
            } catch (JSONException e) {
                C2599Q2.m1011a(this.f1808a.f1774c, "Failed to serialize WebView result callback to JSON", e);
                this.f1810c.element++;
            }
            intRef = this.f1811d;
            i = intRef.element - 1;
        }
        intRef.element = i;
        if (this.f1811d.element == 0) {
            this.f1808a.m960a(this.f1810c.element);
        }
        return Unit.INSTANCE;
    }
}
