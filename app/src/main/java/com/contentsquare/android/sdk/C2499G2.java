package com.contentsquare.android.sdk;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.G2 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nJsonView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonView.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/JsonView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n1#2:124\n1549#3:125\n1620#3,3:126\n1855#3,2:129\n*S KotlinDebug\n*F\n+ 1 JsonView.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/JsonView\n*L\n103#1:125\n103#1:126,3\n103#1:129,2\n*E\n"})
public final class C2499G2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public String f1637a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public JSONObject f1638b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public List<C2499G2> f1639c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public JSONObject f1640d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public JSONArray f1641e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public JSONObject f1642f;

    /* JADX INFO: renamed from: g */
    public int f1643g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public a f1644h;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.G2$a */
    public enum a {
        VIEW,
        ANDROID_COMPOSE_VIEW,
        ANDROID_VIEWS_HANDLER,
        COMPOSE_NODE
    }

    public C2499G2() {
        this.f1637a = "";
        this.f1638b = new C2469D2(0, "", "").m897a();
        this.f1642f = new C2489F2(0, 0, 0, 0, BitmapDescriptorFactory.HUE_RED, null, null, false, BitmapDescriptorFactory.HUE_RED, AnalyticsListener.EVENT_DRM_KEYS_LOADED).m916a();
        this.f1643g = 1;
        this.f1644h = a.VIEW;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final JSONObject m924a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f1637a);
        jSONObject.put("style", this.f1642f);
        jSONObject.put("format", this.f1643g);
        jSONObject.put("metadata", this.f1638b);
        List<C2499G2> list = this.f1639c;
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((C2499G2) it.next()).m924a());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                jSONArray.put(it2.next());
            }
            jSONObject.put("children", jSONArray);
        }
        JSONArray jSONArray2 = this.f1641e;
        if (jSONArray2 != null) {
            jSONObject.put("children", jSONArray2);
        }
        JSONObject jSONObject2 = this.f1640d;
        if (jSONObject2 != null) {
            jSONObject.put("children", jSONObject2);
        }
        return jSONObject;
    }

    @NotNull
    public final String toString() {
        return "JsonView{id=\\'" + this.f1637a + "\\', metadata=" + this.f1638b + ", children=" + this.f1639c + ", webViewChildren=" + this.f1640d + ", externalChildren=" + this.f1641e + ", style=" + this.f1642f + ", format=" + this.f1643g + '}';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2499G2(@NotNull C2499G2 other) {
        this();
        Intrinsics.checkNotNullParameter(other, "other");
        this.f1637a = other.f1637a;
        this.f1638b = other.f1638b;
        this.f1639c = other.f1639c;
        this.f1640d = other.f1640d;
        this.f1641e = other.f1641e;
        this.f1642f = other.f1642f;
        this.f1643g = other.f1643g;
        this.f1644h = other.f1644h;
    }
}
