package com.contentsquare.android.sdk;

import android.view.View;
import android.webkit.WebView;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.api.bridge.flutter.ExternalViewGraphListener;
import com.contentsquare.android.api.bridge.flutter.ExternalViewGraphResult;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.Z4;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@SourceDebugExtension({"SMAP\nExternalViewsProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExternalViewsProcessor.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ExternalViewsProcessor\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,219:1\n215#2,2:220\n*S KotlinDebug\n*F\n+ 1 ExternalViewsProcessor.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ExternalViewsProcessor\n*L\n98#1:220,2\n*E\n"})
/* loaded from: classes2.dex */
public final class K1 implements ExternalViewGraphResult {

    @NotNull
    public static final WeakHashMap<View, ExternalViewGraphListener> g = new WeakHashMap<>();

    @NotNull
    public final I3 a;

    @NotNull
    public final D8 b;

    @NotNull
    public final Logger c;
    public a d;

    @NotNull
    public final WeakHashMap<WebView, G2> e;

    @NotNull
    public final WeakHashMap<View, b> f;

    public static final class a {

        @NotNull
        public final U4 a;

        @NotNull
        public final String b;

        @NotNull
        public final InterfaceC0679f8 c;

        @NotNull
        public final N0 d;

        @NotNull
        public final MutableStateFlow<Z4> e;

        public a(@NotNull U4 screenGraph, @NotNull String screenshot, @NotNull InterfaceC0679f8 result, @NotNull N0 screenGraphCallbackListener, @NotNull MutableStateFlow<Z4> snapshotStateFlow) {
            Intrinsics.checkNotNullParameter(screenGraph, "screenGraph");
            Intrinsics.checkNotNullParameter(screenshot, "screenshot");
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(screenGraphCallbackListener, "screenGraphCallbackListener");
            Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
            this.a = screenGraph;
            this.b = screenshot;
            this.c = result;
            this.d = screenGraphCallbackListener;
            this.e = snapshotStateFlow;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e);
        }

        public final int hashCode() {
            return this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "Parameter(screenGraph=" + this.a + ", screenshot=" + this.b + ", result=" + this.c + ", screenGraphCallbackListener=" + this.d + ", snapshotStateFlow=" + this.e + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public static final class b {

        @NotNull
        public final G2 a;

        @Nullable
        public final ExternalViewGraphListener b;

        public b(@NotNull G2 jsonView, @Nullable ExternalViewGraphListener externalViewGraphListener) {
            Intrinsics.checkNotNullParameter(jsonView, "jsonView");
            this.a = jsonView;
            this.b = externalViewGraphListener;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b);
        }

        public final int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            ExternalViewGraphListener externalViewGraphListener = this.b;
            return iHashCode + (externalViewGraphListener == null ? 0 : externalViewGraphListener.hashCode());
        }

        @NotNull
        public final String toString() {
            return "ViewFound(jsonView=" + this.a + ", listener=" + this.b + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public K1(@NotNull I3 pathDescriptor, @NotNull D8 webViewDomUpdater) {
        Intrinsics.checkNotNullParameter(pathDescriptor, "pathDescriptor");
        Intrinsics.checkNotNullParameter(webViewDomUpdater, "webViewDomUpdater");
        this.a = pathDescriptor;
        this.b = webViewDomUpdater;
        this.c = new Logger("ExternalViewsProcessor");
        this.e = new WeakHashMap<>();
        this.f = new WeakHashMap<>();
    }

    public final void a() {
        a aVar = this.d;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameter");
            aVar = null;
        }
        aVar.e.tryEmit(Z4.g.a);
        a aVar3 = this.d;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameter");
            aVar3 = null;
        }
        N0 n0 = aVar3.d;
        a aVar4 = this.d;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameter");
            aVar4 = null;
        }
        U4 u4 = aVar4.a;
        a aVar5 = this.d;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameter");
            aVar5 = null;
        }
        String str = aVar5.b;
        a aVar6 = this.d;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameter");
        } else {
            aVar2 = aVar6;
        }
        n0.a(u4, str, aVar2.c.a());
    }

    public final boolean b() {
        return (this.e.isEmpty() && this.f.isEmpty()) ? false : true;
    }

    public final void c() {
        if (!this.f.isEmpty()) {
            Set<Map.Entry<View, b>> setEntrySet = this.f.entrySet();
            Intrinsics.checkNotNullExpressionValue(setEntrySet, "registeredViewsFound.entries");
            Object objFirst = CollectionsKt.first(setEntrySet);
            Intrinsics.checkNotNullExpressionValue(objFirst, "registeredViewsFound.entries.first()");
            Map.Entry entry = (Map.Entry) objFirst;
            ExternalViewGraphListener externalViewGraphListener = g.get(entry.getKey());
            String strA = this.a.a((View) entry.getKey());
            if (externalViewGraphListener != null) {
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "viewFound.key");
                externalViewGraphListener.takeSnapShot((View) key, strA, this);
                return;
            }
            return;
        }
        if (this.e.isEmpty()) {
            a();
            return;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = this.e.size();
        Ref.IntRef intRef2 = new Ref.IntRef();
        for (Map.Entry<WebView, G2> entry2 : this.e.entrySet()) {
            WebView webView = entry2.getKey();
            G2 value = entry2.getValue();
            S8 s8 = S8.a;
            Intrinsics.checkNotNullExpressionValue(webView, "webView");
            s8.getClass();
            Intrinsics.checkNotNullParameter(webView, "webView");
            M0 m0 = S8.g.get(webView);
            K8 k8 = m0 != null ? m0.g : null;
            if (k8 != null) {
                k8.a(new L1(this, value, intRef2, intRef));
            } else {
                int i = intRef.element - 1;
                intRef.element = i;
                if (i == 0) {
                    a(intRef2.element);
                }
            }
        }
    }

    @Override // com.contentsquare.android.api.bridge.flutter.ExternalViewGraphResult
    public final void onSnapshotTaken(@NotNull View view, @NotNull String jsonScreenGraph) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(jsonScreenGraph, "jsonScreenGraph");
        b bVar = this.f.get(view);
        if (bVar != null) {
            bVar.a.g = 1;
            bVar.a.e = new JSONArray(jsonScreenGraph);
        }
        this.f.remove(view);
        c();
    }

    public final void a(int i) {
        this.e.clear();
        if (i == 0) {
            a();
            return;
        }
        a aVar = this.d;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameter");
            aVar = null;
        }
        String str = aVar.a.b;
        a aVar3 = this.d;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameter");
        } else {
            aVar2 = aVar3;
        }
        aVar2.d.a(str);
    }

    public final void a(@NotNull U4 screenGraph, @NotNull String screenshot, @NotNull InterfaceC0679f8 result, @NotNull N0 screenGraphCallbackListener, @NotNull MutableStateFlow<Z4> snapshotStateFlow) {
        Intrinsics.checkNotNullParameter(screenGraph, "screenGraph");
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(screenGraphCallbackListener, "screenGraphCallbackListener");
        Intrinsics.checkNotNullParameter(snapshotStateFlow, "snapshotStateFlow");
        this.d = new a(screenGraph, screenshot, result, screenGraphCallbackListener, snapshotStateFlow);
        c();
    }
}
