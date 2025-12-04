package com.contentsquare.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.api.model.DynamicVarLongValidator;
import com.contentsquare.android.api.model.DynamicVarStringValidator;
import com.contentsquare.android.api.model.Transaction;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.internal.core.telemetry.Telemetry;
import com.contentsquare.android.internal.features.initialize.ContentsquareModule;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import com.contentsquare.android.sdk.A0;
import com.contentsquare.android.sdk.C0636b5;
import com.contentsquare.android.sdk.C0676f5;
import com.contentsquare.android.sdk.C0692h1;
import com.contentsquare.android.sdk.C0702i1;
import com.contentsquare.android.sdk.C0723k2;
import com.contentsquare.android.sdk.C0752n1;
import com.contentsquare.android.sdk.C0801s1;
import com.contentsquare.android.sdk.C0853x5;
import com.contentsquare.android.sdk.C0866z0;
import com.contentsquare.android.sdk.C5;
import com.contentsquare.android.sdk.E1;
import com.contentsquare.android.sdk.G7;
import com.contentsquare.android.sdk.J0;
import com.contentsquare.android.sdk.L2;
import com.contentsquare.android.sdk.L5;
import com.contentsquare.android.sdk.M0;
import com.contentsquare.android.sdk.M4;
import com.contentsquare.android.sdk.Q1;
import com.contentsquare.android.sdk.Q2;
import com.contentsquare.android.sdk.S8;
import com.contentsquare.android.sdk.ViewTreeObserverOnGlobalLayoutListenerC0825u5;
import com.contentsquare.android.sdk.Z2;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class Contentsquare {

    @NonNull
    public static final Logger a = new Logger("Contentsquare");

    @VisibleForTesting
    public Contentsquare() {
        throw new UnsupportedOperationException("This class cannot be instantiated.");
    }

    public static void a(MotionEvent motionEvent, M4 m4) {
        if (CsApplicationModule.getInstance() != null) {
            MotionEvent event = MotionEvent.obtain(motionEvent);
            C0723k2 c0723k2 = (C0723k2) CsApplicationModule.getInstance().getGesturesInterceptor();
            c0723k2.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            if (c0723k2.i) {
                c0723k2.g.d("consumeAndRecycle() called with event [" + event + AbstractJsonLexerKt.END_LIST);
                ViewGroup viewGroup = c0723k2.h.get();
                if (viewGroup != null) {
                    c0723k2.b.a(event, viewGroup);
                }
                event.recycle();
            }
        }
    }

    public static void b(WeakReference weakReference, M4 m4) {
        View view = (View) weakReference.get();
        if (view != null) {
            Z2 z2 = C5.l;
            z2.getClass();
            Intrinsics.checkNotNullParameter(view, "view");
            z2.b.put(view, Boolean.TRUE);
        }
    }

    public static void consumeEvent(@NonNull final MotionEvent motionEvent) {
        a.d("CS_API, consumeEvent with event " + motionEvent);
        Telemetry.INSTANCE.collectApiCall("consume_event");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(motionEvent, (M4) obj);
            }
        });
    }

    @Deprecated
    public static String currentSessionReplayLink() {
        String strA;
        Logger logger = a;
        logger.d("CS_API, currentSessionReplayLink");
        Telemetry.INSTANCE.collectApiCall("current_sr_link");
        C5 c5 = C5.k;
        if (c5 != null) {
            strA = c5.i.a();
            c5.j.flushCurrentEventBatchAsync();
        } else {
            strA = "INACTIVE";
        }
        logger.i("SessionReplay link: " + strA);
        return strA;
    }

    @Nullable
    public static byte[] currentSessionReplayProperties(long j) {
        a.d("CS_API, currentSessionReplayProperties");
        Telemetry.INSTANCE.collectApiCall("current_session_replay_properties");
        ContentsquareModule contentsquareModule = ContentsquareModule.getInstance();
        if (contentsquareModule != null) {
            return contentsquareModule.getSessionReplayProperties().a(j).toByteArray();
        }
        return null;
    }

    public static void d(String name, M4 m4) {
        JsonConfig.SessionReplay sessionReplay;
        L2 l2 = m4.a;
        l2.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        PreferencesStore preferencesStore = l2.g;
        PreferencesKey preferencesKey = PreferencesKey.SESSION_REPLAY_ETR_ENABLED;
        boolean etrEnabled = false;
        if (preferencesStore.contains(preferencesKey)) {
            etrEnabled = l2.g.getBoolean(preferencesKey, false);
        } else {
            JsonConfig.ProjectConfiguration projectConfig = l2.d.getProjectConfig();
            if (projectConfig != null && (sessionReplay = projectConfig.getSessionReplay()) != null) {
                etrEnabled = sessionReplay.getEtrEnabled();
            }
        }
        if (etrEnabled) {
            E1 eventsBuildersFactory = l2.k.getEventsBuildersFactory();
            Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
            C0801s1.a aVar = (C0801s1.a) E1.a(eventsBuildersFactory, 28);
            Intrinsics.checkNotNullParameter(name, "name");
            aVar.k = name;
            l2.c.a(aVar);
        } else {
            l2.h.e("ETR is disabled for this project.");
        }
        C5 c5 = C5.k;
        if (c5 != null) {
            Intrinsics.checkNotNullParameter(name, "name");
            c5.h.a(name);
        }
    }

    public static void doNotTrack(@NonNull final View view) {
        a.d("CS_API, doNotTrack for view");
        Telemetry.INSTANCE.collectApiCall("do_not_track_view");
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda14
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(view, (M4) obj);
            }
        });
    }

    public static void excludeFromExposureMetric(@NonNull View view) {
        a.d("CS_API, excludeFromExposureMetric");
        Telemetry.INSTANCE.collectApiCall("exclude_from_exposure_metric");
        final WeakReference weakReference = new WeakReference(view);
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(weakReference, (M4) obj);
            }
        });
    }

    @Deprecated
    public static void forgetMe() {
        a.d("CS_API, forgetMe");
        Telemetry.INSTANCE.collectApiCall("forget_me");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a((M4) obj);
            }
        });
    }

    @Nullable
    public static Integer getProjectId() {
        Logger logger = a;
        logger.d("CS_API, getProjectId");
        logger.i("User requested Contentsquare Project ID.");
        Telemetry.INSTANCE.collectApiCall("project_id");
        CoreModule coreModule = CoreModule.getInstance();
        if (coreModule == null) {
            return null;
        }
        Configuration configuration = coreModule.getConfiguration();
        if (configuration.getProjectConfig() != null) {
            return Integer.valueOf(configuration.getProjectConfig().getCsProjectId());
        }
        return null;
    }

    public static int getSessionNumber() {
        Logger logger = a;
        logger.d("CS_API, getSessionNumber");
        logger.i("User requested Contentsquare Session Number.");
        Telemetry.INSTANCE.collectApiCall(TCEventPropertiesNames.TCL_SESSION_NUMBER);
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule == null) {
            return 0;
        }
        L5 sessionRestoreHelper = csApplicationModule.getSessionRestoreHelper();
        PreferencesStore preferencesStore = sessionRestoreHelper.a;
        PreferencesKey preferencesKey = PreferencesKey.SESSION_ID;
        if (!preferencesStore.contains(preferencesKey)) {
            sessionRestoreHelper.a.putInt(preferencesKey, 1);
        }
        return sessionRestoreHelper.a.getInt(preferencesKey, 1);
    }

    public static String getUserId() {
        Logger logger = a;
        logger.d("CS_API, getUserId");
        logger.i("User requested Contentsquare User ID.");
        Telemetry.INSTANCE.collectApiCall("user_id");
        CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance();
        String strA = csRuntimeModule != null ? csRuntimeModule.getRunTime().a() : null;
        if (strA != null) {
            logger.i("Get user ID - User ID: ".concat(strA));
            return strA;
        }
        logger.i("User ID Unknown. You need to opt-in.");
        return "UNKNOWN";
    }

    @UiThread
    public static void mask(@NonNull View view) {
        Telemetry.INSTANCE.collectApiCall("mask");
        final WeakReference weakReference = new WeakReference(view);
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda13
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.b(weakReference, (M4) obj);
            }
        });
    }

    public static void onSessionReplayLinkChange(@Nullable final Consumer<String> consumer) {
        a.d("CS_API, onSessionReplayLinkChange");
        Telemetry.INSTANCE.collectApiCall("on_session_replay_link_change");
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda7
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(consumer, (M4) obj);
            }
        });
    }

    public static void optIn(@NonNull final Context context) {
        a.d("CS_API, optIn");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda6
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(context, (M4) obj);
            }
        });
    }

    public static void optOut(@NonNull final Context context) {
        a.d("CS_API, optOut");
        Telemetry.INSTANCE.collectApiCall("opt_out");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda5
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.b(context, (M4) obj);
            }
        });
    }

    public static void resumeTracking() {
        a.d("CS_API, resumeTracking");
        Telemetry.INSTANCE.collectApiCall("resume_tracking");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda11
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.b((M4) obj);
            }
        });
    }

    public static void send(@NonNull final Transaction transaction) {
        a.d("CS_API, send with transaction = " + transaction);
        Telemetry.INSTANCE.collectApiCall("send_transaction");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda21
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(transaction, (M4) obj);
            }
        });
    }

    public static void sendUserIdentifier(@NonNull final String str) {
        Telemetry.INSTANCE.collectApiCall("send_user_identifier");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda12
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.b(str, (M4) obj);
            }
        });
    }

    @UiThread
    public static void setDefaultMasking(final boolean z) {
        Telemetry.INSTANCE.collectApiCall("set_default_masking");
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda22
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(z, (M4) obj);
            }
        });
    }

    public static void start(@NonNull final Context context) {
        C0866z0 c0866z0 = C0866z0.a;
        C0866z0.c = true;
        A0.a(context);
        Telemetry.INSTANCE.collectApiCall(ViewProps.START);
        c0866z0.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CsApplicationModule.getInstance((Application) context.getApplicationContext()).getBridgeManager().notifyStart();
            }
        });
    }

    public static void stopTracking() {
        a.d("CS_API, stopTracking");
        Telemetry.INSTANCE.collectApiCall("stop_tracking");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda15
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.c((M4) obj);
            }
        });
    }

    @UiThread
    public static void triggerReplayForCurrentScreen(@NonNull final String str) {
        Telemetry.INSTANCE.collectApiCall("trigger_replay_for_current_screen");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda23
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.c(str, (M4) obj);
            }
        });
    }

    @UiThread
    public static void triggerReplayForCurrentSession(@NonNull final String str) {
        Telemetry.INSTANCE.collectApiCall("trigger_replay_for_current_session");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda18
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.d(str, (M4) obj);
            }
        });
    }

    @UiThread
    public static void unMask(@NonNull View view) {
        Telemetry.INSTANCE.collectApiCall("unmask");
        final WeakReference weakReference = new WeakReference(view);
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda9
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.c(weakReference, (M4) obj);
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static boolean wasInitialized() {
        Telemetry.INSTANCE.collectApiCall("was_initialized");
        return CsRuntimeModule.getInstance() != null;
    }

    public static void c(M4 m4) {
        CoreModule coreModule = CoreModule.getInstance();
        if (coreModule != null) {
            coreModule.getPreferencesStore().putBoolean(PreferencesKey.PAUSE_TRACKING, true);
        }
        C0676f5.b.clear();
        m4.c.f = false;
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            csApplicationModule.getBridgeManager().notifyStopTracking();
        }
        a.i("Stopping Tracker");
    }

    @SafeVarargs
    public static void doNotTrack(@NonNull final Class<? extends Activity>... clsArr) {
        a.d("CS_API, doNotTrack for activity classes");
        Telemetry.INSTANCE.collectApiCall("do_not_track");
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda4
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Q1.a((Class<? extends Activity>[]) clsArr);
            }
        });
    }

    @UiThread
    public static void mask(@NonNull final Class<?> cls) {
        Telemetry.INSTANCE.collectApiCall("mask");
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda19
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(cls, (M4) obj);
            }
        });
    }

    public static void send(@NonNull final String str) {
        a.d("CS_API, screenName = " + str);
        Telemetry.INSTANCE.collectApiCall("send_screen_name");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda17
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(str, (M4) obj);
            }
        });
    }

    @UiThread
    public static void unMask(@NonNull final Class<?> cls) {
        Telemetry.INSTANCE.collectApiCall("unmask");
        C0866z0.a.a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda20
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.b(cls, (M4) obj);
            }
        });
    }

    public static void a(View view, M4 m4) {
        HashSet<Class<? extends Activity>> hashSet = Q1.a;
        Intrinsics.checkNotNullParameter(view, "view");
        Q1.c.put(view, null);
    }

    public static void b(Context context, M4 m4) {
        C0676f5.b.clear();
        CoreModule.safeInstance(context).getPreferencesStore().putBoolean(PreferencesKey.IS_OPT_OUT, true);
        m4.b.b();
        a.i("Opting out");
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance((Application) context.getApplicationContext());
        csApplicationModule.getSdkManager().a();
        csApplicationModule.getBridgeManager().notifyOptOut();
        S8.a.getClass();
        Iterator<Map.Entry<WebView, M0>> it = S8.g.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().g.c();
        }
    }

    public static void a(WeakReference weakReference, M4 m4) {
        J0 csActivityCallbacks = CsRuntimeModule.getInstance() != null ? CsRuntimeModule.getInstance().getCsActivityCallbacks() : null;
        View view = (View) weakReference.get();
        if (csActivityCallbacks == null || view == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        csActivityCallbacks.k.getClass();
        ViewTreeObserverOnGlobalLayoutListenerC0825u5.a(view);
    }

    public static void send(@NonNull final String str, final long j) {
        a.d("CS_API send, with key = " + str + ", value(long) = " + j);
        Telemetry.INSTANCE.collectApiCall("send_dynamic_var");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda10
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(str, j, (M4) obj);
            }
        });
    }

    public static void a(M4 m4) {
        C0676f5.b.clear();
        CoreModule coreModule = CoreModule.getInstance();
        if (coreModule != null) {
            coreModule.getPreferencesStore().putBoolean(PreferencesKey.FORGET_ME, true);
        }
        m4.b.b();
        C0853x5 c0853x5 = m4.c;
        if (c0853x5.f) {
            c0853x5.a(false);
            c0853x5.f = false;
        }
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            csApplicationModule.getBridgeManager().notifyForgetMe();
        }
        a.i("Forgetting User");
    }

    public static void c(String name, M4 m4) {
        JsonConfig.SessionReplay sessionReplay;
        L2 l2 = m4.a;
        l2.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        PreferencesStore preferencesStore = l2.g;
        PreferencesKey preferencesKey = PreferencesKey.SESSION_REPLAY_ETR_ENABLED;
        boolean etrEnabled = false;
        if (preferencesStore.contains(preferencesKey)) {
            etrEnabled = l2.g.getBoolean(preferencesKey, false);
        } else {
            JsonConfig.ProjectConfiguration projectConfig = l2.d.getProjectConfig();
            if (projectConfig != null && (sessionReplay = projectConfig.getSessionReplay()) != null) {
                etrEnabled = sessionReplay.getEtrEnabled();
            }
        }
        if (etrEnabled) {
            E1 eventsBuildersFactory = l2.k.getEventsBuildersFactory();
            Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
            C0752n1.a aVar = (C0752n1.a) E1.a(eventsBuildersFactory, 29);
            Intrinsics.checkNotNullParameter(name, "name");
            aVar.k = name;
            l2.c.a(aVar);
        } else {
            l2.h.e("ETR is disabled for this project.");
        }
        C5 c5 = C5.k;
        if (c5 != null) {
            Intrinsics.checkNotNullParameter(name, "name");
            c5.g.a(name);
        }
    }

    public static void send(@NonNull final String str, @NonNull final String str2) {
        a.d("CS_API send, with key = " + str + ", value(string) = " + str2);
        Telemetry.INSTANCE.collectApiCall("send_dynamic_var");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda16
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(str, str2, (M4) obj);
            }
        });
    }

    public static void send(@NonNull final String str, @NonNull final CustomVar[] customVarArr) {
        Telemetry.INSTANCE.collectApiCall("send_custom_var");
        C0866z0.a.a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda8
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.a(customVarArr, str, (M4) obj);
            }
        });
    }

    public static void b(M4 m4) {
        CoreModule coreModule = CoreModule.getInstance();
        if (coreModule != null) {
            coreModule.getPreferencesStore().putBoolean(PreferencesKey.PAUSE_TRACKING, false);
        }
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            csApplicationModule.getBridgeManager().notifyResumeTracking();
        }
        m4.c.f = true;
        a.i("Resuming Tracker");
    }

    public static void a(Class type, M4 m4) {
        Z2 z2 = C5.l;
        z2.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        z2.c.remove(new Z2.a(type, false));
        z2.c.add(new Z2.a(type, true));
    }

    public static void b(String str, M4 m4) {
        m4.a.l.a(str);
    }

    public static void c(WeakReference weakReference, M4 m4) {
        View view = (View) weakReference.get();
        if (view != null) {
            Z2 z2 = C5.l;
            z2.getClass();
            Intrinsics.checkNotNullParameter(view, "view");
            z2.b.put(view, Boolean.FALSE);
        }
    }

    public static void b(Class type, M4 m4) {
        Z2 z2 = C5.l;
        z2.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        z2.c.remove(new Z2.a(type, false));
        z2.c.add(new Z2.a(type, false));
    }

    public static void a(Consumer consumer, M4 m4) {
        C5 c5 = C5.k;
        if (consumer == null) {
            C5.m.i("Callback for SessionReplay link update is unregistered");
        } else {
            C5.m.i("Callback for SessionReplay link update is registered");
        }
        C5.n = consumer;
        C5 c52 = C5.k;
        if (c52 == null || consumer == null) {
            return;
        }
        Intrinsics.checkNotNull(c52);
        consumer.accept(c52.i.a());
    }

    public static void a(Context context, M4 m4) {
        Activity activity;
        PreferencesStore preferencesStore = CoreModule.safeInstance(context).getPreferencesStore();
        preferencesStore.putBoolean(PreferencesKey.IS_OPT_OUT, false);
        preferencesStore.putBoolean(PreferencesKey.FORGET_ME, false);
        CsApplicationModule.getInstance((Application) context.getApplicationContext()).getUserIdRestoreHelper().a();
        if (CsRuntimeModule.getInstance() != null && (activity = ContentsquareModule.getInstance(context).getLiveActivityProvider().a.get()) != null) {
            J0 csActivityCallbacks = CsRuntimeModule.getInstance().getCsActivityCallbacks();
            csActivityCallbacks.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            J0.a(activity, csActivityCallbacks.r, csActivityCallbacks.d);
        }
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance((Application) context.getApplicationContext());
        csApplicationModule.getSdkManager().a();
        csApplicationModule.getBridgeManager().notifyOptIn();
        S8.a.getClass();
        Iterator<Map.Entry<WebView, M0>> it = S8.g.entrySet().iterator();
        while (it.hasNext()) {
            M0 value = it.next().getValue();
            if (value.a()) {
                value.g.a();
            }
        }
        Telemetry.INSTANCE.collectApiCall("opt_in");
        String strA = m4.a();
        if (strA != null) {
            a.i("Opt-in successful. User ID: ".concat(strA));
        } else {
            a.i("Opt-in failed. User ID: UNKNOWN");
        }
    }

    public static void a(CustomVar[] customVarArr, String screenName, M4 m4) {
        Logger logger;
        StringBuilder sb;
        Logger logger2;
        StringBuilder sb2;
        String str;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (CustomVar customVar : customVarArr) {
            if (customVar.getIndex() < 0) {
                logger2 = a;
                sb2 = new StringBuilder("CS_API, Entry with invalid index ");
                sb2.append(customVar.getIndex());
                str = " will not be kept, index must have positive value";
            } else if (hashSet.contains(Integer.valueOf(customVar.getIndex()))) {
                logger2 = a;
                sb2 = new StringBuilder("CS_API, Found multiple entries with index ");
                sb2.append(customVar.getIndex());
                str = ", only first entry will be kept";
            } else {
                hashSet.add(Integer.valueOf(customVar.getIndex()));
                arrayList.add(customVar);
            }
            sb2.append(str);
            logger2.i(sb2.toString());
        }
        CustomVar[] customVars = (CustomVar[]) arrayList.toArray(new CustomVar[0]);
        if (customVars.length == 0) {
            logger = a;
            sb = new StringBuilder("CS_API, screenName = ");
            sb.append(screenName);
        } else {
            logger = a;
            sb = new StringBuilder("CS_API, screenName = ");
            sb.append(screenName);
            sb.append(" - cVars ");
            sb.append(CustomVar.INSTANCE.generateCustomVarsLogMessage(customVars));
        }
        logger.d(sb.toString());
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(customVars, "customVars");
        C0676f5.a(new C0636b5(screenName, customVars, false, null, 12));
    }

    public static void a(String str, long j, M4 m4) {
        DynamicVarLongValidator dynamicVarLongValidator = new DynamicVarLongValidator(str, j);
        L2 l2 = m4.a;
        l2.getClass();
        Intrinsics.checkNotNullParameter(dynamicVarLongValidator, "dynamicVarLongValidator");
        E1 eventsBuildersFactory = l2.k.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
        C0692h1.a aVar = (C0692h1.a) E1.a(eventsBuildersFactory, 19);
        String key = dynamicVarLongValidator.getKey();
        Intrinsics.checkNotNullParameter(key, "key");
        aVar.l = key;
        aVar.k = dynamicVarLongValidator.getValue();
        l2.c.a(aVar);
    }

    public static void a(String str, String str2, M4 m4) {
        DynamicVarStringValidator dynamicVarStringValidator = new DynamicVarStringValidator(str, str2);
        L2 l2 = m4.a;
        l2.getClass();
        Intrinsics.checkNotNullParameter(dynamicVarStringValidator, "dynamicVarStringValidator");
        E1 eventsBuildersFactory = l2.k.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
        C0702i1.a aVar = (C0702i1.a) E1.a(eventsBuildersFactory, 18);
        String key = dynamicVarStringValidator.getKey();
        Intrinsics.checkNotNullParameter(key, "key");
        aVar.l = key;
        String value = dynamicVarStringValidator.getValue();
        Intrinsics.checkNotNullParameter(value, "value");
        aVar.k = value;
        l2.c.a(aVar);
    }

    public static void a(Transaction transaction, M4 m4) {
        L2 l2 = m4.a;
        l2.getClass();
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        E1 eventsBuildersFactory = l2.k.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
        G7.a aVar = (G7.a) E1.a(eventsBuildersFactory, 16);
        try {
            aVar.a(transaction);
            l2.c.a(aVar);
        } catch (IllegalArgumentException e) {
            Q2.a(l2.h, "Transaction not registered: " + e, e);
        }
    }

    public static void a(String screenName, M4 m4) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        C0676f5.a(new C0636b5(screenName, null, false, null, 14));
    }

    public static void a(boolean z, M4 m4) {
        C5.l.a.putBoolean(PreferencesKey.SESSION_REPLAY_DEFAULT_MASKING, z);
    }
}
