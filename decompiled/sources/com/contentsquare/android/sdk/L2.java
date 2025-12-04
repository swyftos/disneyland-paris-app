package com.contentsquare.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import com.contentsquare.android.sdk.C0853x5;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class L2 implements C0853x5.a {

    @NotNull
    public final Application a;

    @NotNull
    public final I1 b;

    @NotNull
    public final C0710j c;

    @NotNull
    public final Configuration d;

    @NotNull
    public final G1 e;

    @NotNull
    public final L0 f;

    @NotNull
    public final PreferencesStore g;

    @NotNull
    public final Logger h;
    public boolean i;

    @Nullable
    public J0 j;

    @NotNull
    public final CsApplicationModule k;

    @NotNull
    public final P7 l;

    public L2(@NotNull Application application, @NotNull I1 eventsStatusPrefsHelper, @NotNull C0710j analyticsPipeline, @NotNull Configuration configuration, @NotNull G1 eventsProcessor, @NotNull L0 componentListener, @NotNull PreferencesStore preferenceStore) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(eventsStatusPrefsHelper, "eventsStatusPrefsHelper");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(eventsProcessor, "eventsProcessor");
        Intrinsics.checkNotNullParameter(componentListener, "componentListener");
        Intrinsics.checkNotNullParameter(preferenceStore, "preferenceStore");
        this.a = application;
        this.b = eventsStatusPrefsHelper;
        this.c = analyticsPipeline;
        this.d = configuration;
        this.e = eventsProcessor;
        this.f = componentListener;
        this.g = preferenceStore;
        this.h = new Logger("LegacyComponentsHolder");
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance(application);
        Intrinsics.checkNotNullExpressionValue(csApplicationModule, "getInstance(application)");
        this.k = csApplicationModule;
        this.l = new P7(csApplicationModule, analyticsPipeline, configuration);
    }

    public final void a() {
        this.h.d("SDK started tracking...");
        if (this.i) {
            this.h.d("SDK was already tracking, moving along...");
        } else {
            if (this.b.a.getBoolean(PreferencesKey.IS_HIDE_EVENT_PENDING, false)) {
                String string = this.b.a.getString(PreferencesKey.SCHEDULED_APP_HIDE_EVENT, null);
                if (string != null) {
                    try {
                        this.h.d("sending hide event");
                        JSONObject json = new JSONObject(string);
                        C0710j c0710j = this.c;
                        c0710j.getClass();
                        Intrinsics.checkNotNullParameter(json, "json");
                        BuildersKt__Builders_commonKt.launch$default(c0710j.c, null, null, new C0720k(c0710j, json, null), 3, null);
                        this.h.d("hide event pending flag removed");
                    } catch (JSONException e) {
                        Q2.a(this.h, "The serialized hide event: [" + string + "] failed to be parsed into JSON with parsing error message: [" + e.getMessage() + AbstractJsonLexerKt.END_LIST, e);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                this.b.a.remove(PreferencesKey.IS_HIDE_EVENT_PENDING);
                this.b.a.remove(PreferencesKey.SCHEDULED_APP_HIDE_EVENT);
            }
            this.h.d("sending start event");
            C0710j c0710j2 = this.c;
            E1 eventsBuildersFactory = this.k.getEventsBuildersFactory();
            Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
            c0710j2.a(E1.a(eventsBuildersFactory, 0));
            if (this.j == null) {
                this.j = CsRuntimeModule.getInstance(this.a).getCsActivityCallbacks();
            }
            this.h.d("the session was validated, attaching listeners");
            J0 j0 = this.j;
            if (j0 != null) {
                Application application = this.a;
                Intrinsics.checkNotNullParameter(application, "application");
                application.registerActivityLifecycleCallbacks(j0);
                Activity activity = j0.i.a.get();
                if (activity != null) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    J0.a(activity, j0.q, j0.d);
                }
                ((C0723k2) j0.g).i = true;
            }
            this.a.registerComponentCallbacks(this.f);
        }
        this.i = true;
    }

    public final void b() {
        if (this.i) {
            J0 j0 = this.j;
            if (j0 != null) {
                Application application = this.a;
                Intrinsics.checkNotNullParameter(application, "application");
                application.unregisterActivityLifecycleCallbacks(j0);
                C0723k2 c0723k2 = (C0723k2) j0.g;
                c0723k2.i = false;
                Activity activity = j0.m;
                if (activity != null) {
                    c0723k2.b(activity);
                    ViewTreeObserverOnGlobalLayoutListenerC0825u5 viewTreeObserverOnGlobalLayoutListenerC0825u5 = j0.k;
                    viewTreeObserverOnGlobalLayoutListenerC0825u5.getClass();
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    WeakHashMap<View, InterfaceC0795r5> weakHashMap = viewTreeObserverOnGlobalLayoutListenerC0825u5.c.get(activity);
                    if (weakHashMap != null) {
                        Iterator<Map.Entry<View, InterfaceC0795r5>> it = weakHashMap.entrySet().iterator();
                        while (it.hasNext()) {
                            it.next().getValue().clear();
                        }
                        weakHashMap.clear();
                    }
                }
                j0.m = null;
            }
            this.a.unregisterComponentCallbacks(this.f);
            this.j = null;
        } else {
            this.h.d("SDK was already stopped, moving along...");
        }
        this.i = false;
    }
}
