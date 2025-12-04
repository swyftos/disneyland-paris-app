package com.contentsquare.android.sdk;

import com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class L1 extends Lambda implements Function1<Pair<? extends String, ? extends String>, Unit> {
    public final /* synthetic */ K1 a;
    public final /* synthetic */ G2 b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ Ref.IntRef d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L1(K1 k1, G2 g2, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(1);
        this.a = k1;
        this.b = g2;
        this.c = intRef;
        this.d = intRef2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Pair<? extends String, ? extends String> pair) {
        Ref.IntRef intRef;
        int i;
        Pair<? extends String, ? extends String> result = pair;
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual(result, K8.d)) {
            Ref.IntRef intRef2 = this.d;
            intRef2.element--;
            intRef = this.c;
            i = intRef.element + 1;
        } else {
            String serializationId = result.component1();
            String dom = result.component2();
            if (serializationId != null) {
                D8 d8 = this.a.b;
                synchronized (d8) {
                    try {
                        Intrinsics.checkNotNullParameter(serializationId, "serializationId");
                        Intrinsics.checkNotNullParameter(dom, "dom");
                        d8.c.d("Start dom replacement for " + serializationId + " serialization id.");
                        while (true) {
                            if (d8.b >= 10) {
                                break;
                            }
                            K k = d8.a;
                            k.getClass();
                            Intrinsics.checkNotNullParameter(serializationId, "serializationId");
                            Collection<WebViewAsset> collectionValues = k.a.values();
                            Intrinsics.checkNotNullExpressionValue(collectionValues, "cache.values");
                            ArrayList arrayList = new ArrayList();
                            for (Object obj : collectionValues) {
                                if (Intrinsics.areEqual(((WebViewAsset) obj).g, serializationId)) {
                                    arrayList.add(obj);
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                Object next = it.next();
                                if (!StringsKt.endsWith$default(((WebViewAsset) next).c, ".css", false, 2, (Object) null)) {
                                    arrayList2.add(next);
                                }
                            }
                            if (arrayList2.isEmpty()) {
                                Thread.sleep(500L);
                                d8.b++;
                                d8.c.d("Assets not in cache for " + serializationId + ", wait and retry");
                            } else {
                                d8.c.d("Assets in cache, replacement will start");
                                Iterator it2 = arrayList2.iterator();
                                String strReplace$default = dom;
                                while (it2.hasNext()) {
                                    WebViewAsset webViewAsset = (WebViewAsset) it2.next();
                                    strReplace$default = StringsKt.replace$default(strReplace$default, webViewAsset.b, "cs://resources/" + webViewAsset.e, false, 4, (Object) null);
                                }
                                dom = strReplace$default;
                            }
                        }
                        d8.b = 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            try {
                this.b.d = new JSONObject(dom);
                this.b.g = 2;
            } catch (JSONException e) {
                Q2.a(this.a.c, "Failed to serialize WebView result callback to JSON", e);
                this.c.element++;
            }
            intRef = this.d;
            i = intRef.element - 1;
        }
        intRef.element = i;
        if (this.d.element == 0) {
            this.a.a(this.c.element);
        }
        return Unit.INSTANCE;
    }
}
