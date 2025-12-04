package com.contentsquare.android.sdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.communication.error.ErrorAnalysisInterface;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class H8 implements G8 {

    @NotNull
    public final F7 a;

    @NotNull
    public final Lazy b;

    @Nullable
    public ScreenViewTracker c;

    @Nullable
    public C0849x1 d;

    @SourceDebugExtension({"SMAP\nWebViewEventProcessorsFactoryImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewEventProcessorsFactoryImpl.kt\ncom/contentsquare/android/internal/features/webviewbridge/WebViewEventProcessorsFactoryImpl$createWebViewSessionReplayEventProcessor$1\n+ 2 ModuleStarter.kt\ncom/contentsquare/android/internal/features/initialize/ModuleStarter\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,101:1\n63#2:102\n800#3,11:103\n*S KotlinDebug\n*F\n+ 1 WebViewEventProcessorsFactoryImpl.kt\ncom/contentsquare/android/internal/features/webviewbridge/WebViewEventProcessorsFactoryImpl$createWebViewSessionReplayEventProcessor$1\n*L\n92#1:102\n92#1:103,11\n*E\n"})
    public static final class a extends Lambda implements Function0<ErrorAnalysisInterface> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ErrorAnalysisInterface invoke() {
            ArrayList arrayList = C0644c3.b;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof ErrorAnalysisInterface) {
                    arrayList2.add(next);
                }
            }
            return (ErrorAnalysisInterface) CollectionsKt.firstOrNull((List) arrayList2);
        }
    }

    public static final class b extends Lambda implements Function0<C5> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C5 invoke() {
            return C5.k;
        }
    }

    public static final class c extends Lambda implements Function0<C0663e2> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C0663e2 invoke() {
            return new C0663e2(H8.this.a, 62);
        }
    }

    public H8(@NotNull F7 touchTargetDetector) {
        Intrinsics.checkNotNullParameter(touchTargetDetector, "touchTargetDetector");
        this.a = touchTargetDetector;
        this.b = LazyKt.lazy(new c());
    }

    @Override // com.contentsquare.android.sdk.G8
    @Nullable
    public final A8 a(@NotNull WebView webView, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(activity, "activity");
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance();
        if (csApplicationModule == null || csRuntimeModule == null) {
            return null;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        C0686g5 c0686g5 = csRuntimeModule.getScreenViewHandler().d;
        C0663e2 c0663e2 = (C0663e2) this.b.getValue();
        C0710j analyticsPipeline = csApplicationModule.getAnalyticsPipeline();
        Intrinsics.checkNotNullExpressionValue(analyticsPipeline, "appModule.analyticsPipeline");
        E1 eventsBuildersFactory = csApplicationModule.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "appModule.eventsBuildersFactory");
        C0849x1 c0849x1 = this.d;
        if (c0849x1 == null) {
            ScreenViewTracker screenViewTrackerB = b();
            if (screenViewTrackerB != null) {
                this.d = new C0849x1(screenViewTrackerB);
            }
            c0849x1 = this.d;
        }
        C0849x1 c0849x12 = c0849x1;
        Intrinsics.checkNotNull(c0849x12);
        ScreenViewTracker screenViewTrackerB2 = b();
        Intrinsics.checkNotNull(screenViewTrackerB2);
        return new A8(activity, handler, webView, c0686g5, c0663e2, analyticsPipeline, eventsBuildersFactory, c0849x12, screenViewTrackerB2);
    }

    public final ScreenViewTracker b() {
        PreferencesStore preferencesStore;
        ScreenViewTracker screenViewTracker = this.c;
        if (screenViewTracker != null) {
            return screenViewTracker;
        }
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (companion != null && (preferencesStore = companion.getPreferencesStore()) != null) {
            this.c = new ScreenViewTracker(preferencesStore);
        }
        return this.c;
    }

    @Override // com.contentsquare.android.sdk.G8
    @Nullable
    public final N8 a() {
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule == null) {
            return null;
        }
        E1 eventsBuildersFactory = csApplicationModule.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "appModule.eventsBuildersFactory");
        a aVar = a.a;
        b bVar = b.a;
        C0849x1 c0849x1 = this.d;
        if (c0849x1 == null) {
            ScreenViewTracker screenViewTrackerB = b();
            if (screenViewTrackerB != null) {
                this.d = new C0849x1(screenViewTrackerB);
            }
            c0849x1 = this.d;
        }
        C0849x1 c0849x12 = c0849x1;
        Intrinsics.checkNotNull(c0849x12);
        ScreenViewTracker screenViewTrackerB2 = b();
        Intrinsics.checkNotNull(screenViewTrackerB2);
        return new N8(eventsBuildersFactory, aVar, bVar, c0849x12, screenViewTrackerB2);
    }
}
