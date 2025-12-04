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

@SourceDebugExtension({"SMAP\nJsonView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonView.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/JsonView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n1#2:124\n1549#3:125\n1620#3,3:126\n1855#3,2:129\n*S KotlinDebug\n*F\n+ 1 JsonView.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/JsonView\n*L\n103#1:125\n103#1:126,3\n103#1:129,2\n*E\n"})
/* loaded from: classes2.dex */
public final class G2 {

    @NotNull
    public String a;

    @NotNull
    public JSONObject b;

    @Nullable
    public List<G2> c;

    @Nullable
    public JSONObject d;

    @Nullable
    public JSONArray e;

    @NotNull
    public JSONObject f;
    public int g;

    @NotNull
    public a h;

    public enum a {
        VIEW,
        ANDROID_COMPOSE_VIEW,
        ANDROID_VIEWS_HANDLER,
        COMPOSE_NODE
    }

    public G2() {
        this.a = "";
        this.b = new D2(0, "", "").a();
        this.f = new F2(0, 0, 0, 0, BitmapDescriptorFactory.HUE_RED, null, null, false, BitmapDescriptorFactory.HUE_RED, AnalyticsListener.EVENT_DRM_KEYS_LOADED).a();
        this.g = 1;
        this.h = a.VIEW;
    }

    @NotNull
    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.a);
        jSONObject.put("style", this.f);
        jSONObject.put("format", this.g);
        jSONObject.put("metadata", this.b);
        List<G2> list = this.c;
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((G2) it.next()).a());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                jSONArray.put(it2.next());
            }
            jSONObject.put("children", jSONArray);
        }
        JSONArray jSONArray2 = this.e;
        if (jSONArray2 != null) {
            jSONObject.put("children", jSONArray2);
        }
        JSONObject jSONObject2 = this.d;
        if (jSONObject2 != null) {
            jSONObject.put("children", jSONObject2);
        }
        return jSONObject;
    }

    @NotNull
    public final String toString() {
        return "JsonView{id=\\'" + this.a + "\\', metadata=" + this.b + ", children=" + this.c + ", webViewChildren=" + this.d + ", externalChildren=" + this.e + ", style=" + this.f + ", format=" + this.g + '}';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public G2(@NotNull G2 other) {
        this();
        Intrinsics.checkNotNullParameter(other, "other");
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
        this.d = other.d;
        this.e = other.e;
        this.f = other.f;
        this.g = other.g;
        this.h = other.h;
    }
}
