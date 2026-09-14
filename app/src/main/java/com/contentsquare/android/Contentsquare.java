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
import com.contentsquare.android.sdk.C2437A0;
import com.contentsquare.android.sdk.C2462C5;
import com.contentsquare.android.sdk.C2478E1;
import com.contentsquare.android.sdk.C2504G7;
import com.contentsquare.android.sdk.C2527J0;
import com.contentsquare.android.sdk.C2549L2;
import com.contentsquare.android.sdk.C2552L5;
import com.contentsquare.android.sdk.C2557M0;
import com.contentsquare.android.sdk.C2561M4;
import com.contentsquare.android.sdk.C2598Q1;
import com.contentsquare.android.sdk.C2599Q2;
import com.contentsquare.android.sdk.C2624S8;
import com.contentsquare.android.sdk.C2684Z2;
import com.contentsquare.android.sdk.C2706b5;
import com.contentsquare.android.sdk.C2746f5;
import com.contentsquare.android.sdk.C2762h1;
import com.contentsquare.android.sdk.C2772i1;
import com.contentsquare.android.sdk.C2793k2;
import com.contentsquare.android.sdk.C2822n1;
import com.contentsquare.android.sdk.C2872s1;
import com.contentsquare.android.sdk.C2926x5;
import com.contentsquare.android.sdk.C2941z0;
import com.contentsquare.android.sdk.ViewTreeObserverOnGlobalLayoutListenerC2896u5;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class Contentsquare {

    /* JADX INFO: renamed from: a */
    @NonNull
    public static final Logger f1111a = new Logger("Contentsquare");

    @VisibleForTesting
    public Contentsquare() {
        throw new UnsupportedOperationException("This class cannot be instantiated.");
    }

    /* JADX INFO: renamed from: a */
    public static void m742a(MotionEvent motionEvent, C2561M4 c2561m4) {
        if (CsApplicationModule.getInstance() != null) {
            MotionEvent event = MotionEvent.obtain(motionEvent);
            C2793k2 c2793k2 = (C2793k2) CsApplicationModule.getInstance().getGesturesInterceptor();
            c2793k2.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            if (c2793k2.f2814i) {
                c2793k2.f2812g.m827d("consumeAndRecycle() called with event [" + event + AbstractJsonLexerKt.END_LIST);
                ViewGroup viewGroup = c2793k2.f2813h.get();
                if (viewGroup != null) {
                    c2793k2.f2807b.m1119a(event, viewGroup);
                }
                event.recycle();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m759b(WeakReference weakReference, C2561M4 c2561m4) {
        View view = (View) weakReference.get();
        if (view != null) {
            C2684Z2 c2684z2 = C2462C5.f1469l;
            c2684z2.getClass();
            Intrinsics.checkNotNullParameter(view, "view");
            c2684z2.f2323b.put(view, Boolean.TRUE);
        }
    }

    public static void consumeEvent(@NonNull final MotionEvent motionEvent) {
        f1111a.m827d("CS_API, consumeEvent with event " + motionEvent);
        Telemetry.INSTANCE.collectApiCall("consume_event");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m742a(motionEvent, (C2561M4) obj);
            }
        });
    }

    @Deprecated
    public static String currentSessionReplayLink() {
        String strM1164a;
        Logger logger = f1111a;
        logger.m827d("CS_API, currentSessionReplayLink");
        Telemetry.INSTANCE.collectApiCall("current_sr_link");
        C2462C5 c2462c5 = C2462C5.f1468k;
        if (c2462c5 != null) {
            strM1164a = c2462c5.f1481i.m1164a();
            c2462c5.f1482j.flushCurrentEventBatchAsync();
        } else {
            strM1164a = "INACTIVE";
        }
        logger.m831i("SessionReplay link: " + strM1164a);
        return strM1164a;
    }

    @Nullable
    public static byte[] currentSessionReplayProperties(long j) {
        f1111a.m827d("CS_API, currentSessionReplayProperties");
        Telemetry.INSTANCE.collectApiCall("current_session_replay_properties");
        ContentsquareModule contentsquareModule = ContentsquareModule.getInstance();
        if (contentsquareModule != null) {
            return contentsquareModule.getSessionReplayProperties().m925a(j).toByteArray();
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static void m764d(String name, C2561M4 c2561m4) {
        JsonConfig.SessionReplay sessionReplay;
        C2549L2 c2549l2 = c2561m4.f1860a;
        c2549l2.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        PreferencesStore preferencesStore = c2549l2.f1818g;
        PreferencesKey preferencesKey = PreferencesKey.SESSION_REPLAY_ETR_ENABLED;
        boolean etrEnabled = false;
        if (preferencesStore.contains(preferencesKey)) {
            etrEnabled = c2549l2.f1818g.getBoolean(preferencesKey, false);
        } else {
            JsonConfig.ProjectConfiguration projectConfig = c2549l2.f1815d.getProjectConfig();
            if (projectConfig != null && (sessionReplay = projectConfig.getSessionReplay()) != null) {
                etrEnabled = sessionReplay.getEtrEnabled();
            }
        }
        if (etrEnabled) {
            C2478E1 eventsBuildersFactory = c2549l2.f1822k.getEventsBuildersFactory();
            Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
            C2872s1.a aVar = (C2872s1.a) C2478E1.m901a(eventsBuildersFactory, 28);
            Intrinsics.checkNotNullParameter(name, "name");
            aVar.f3093k = name;
            c2549l2.f1814c.m1159a(aVar);
        } else {
            c2549l2.f1819h.m829e("ETR is disabled for this project.");
        }
        C2462C5 c2462c5 = C2462C5.f1468k;
        if (c2462c5 != null) {
            Intrinsics.checkNotNullParameter(name, "name");
            c2462c5.f1480h.m1206a(name);
        }
    }

    public static void doNotTrack(@NonNull final View view) {
        f1111a.m827d("CS_API, doNotTrack for view");
        Telemetry.INSTANCE.collectApiCall("do_not_track_view");
        C2941z0.f3292a.m1244a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda14
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m743a(view, (C2561M4) obj);
            }
        });
    }

    public static void excludeFromExposureMetric(@NonNull View view) {
        f1111a.m827d("CS_API, excludeFromExposureMetric");
        Telemetry.INSTANCE.collectApiCall("exclude_from_exposure_metric");
        final WeakReference weakReference = new WeakReference(view);
        C2941z0.f3292a.m1244a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m751a(weakReference, (C2561M4) obj);
            }
        });
    }

    @Deprecated
    public static void forgetMe() {
        f1111a.m827d("CS_API, forgetMe");
        Telemetry.INSTANCE.collectApiCall("forget_me");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m746a((C2561M4) obj);
            }
        });
    }

    @Nullable
    public static Integer getProjectId() {
        Logger logger = f1111a;
        logger.m827d("CS_API, getProjectId");
        logger.m831i("User requested Contentsquare Project ID.");
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
        Logger logger = f1111a;
        logger.m827d("CS_API, getSessionNumber");
        logger.m831i("User requested Contentsquare Session Number.");
        Telemetry.INSTANCE.collectApiCall(TCEventPropertiesNames.TCL_SESSION_NUMBER);
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule == null) {
            return 0;
        }
        C2552L5 sessionRestoreHelper = csApplicationModule.getSessionRestoreHelper();
        PreferencesStore preferencesStore = sessionRestoreHelper.f1832a;
        PreferencesKey preferencesKey = PreferencesKey.SESSION_ID;
        if (!preferencesStore.contains(preferencesKey)) {
            sessionRestoreHelper.f1832a.putInt(preferencesKey, 1);
        }
        return sessionRestoreHelper.f1832a.getInt(preferencesKey, 1);
    }

    public static String getUserId() {
        Logger logger = f1111a;
        logger.m827d("CS_API, getUserId");
        logger.m831i("User requested Contentsquare User ID.");
        Telemetry.INSTANCE.collectApiCall("user_id");
        CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance();
        String strM986a = csRuntimeModule != null ? csRuntimeModule.getRunTime().m986a() : null;
        if (strM986a != null) {
            logger.m831i("Get user ID - User ID: ".concat(strM986a));
            return strM986a;
        }
        logger.m831i("User ID Unknown. You need to opt-in.");
        return "UNKNOWN";
    }

    @UiThread
    public static void mask(@NonNull View view) {
        Telemetry.INSTANCE.collectApiCall("mask");
        final WeakReference weakReference = new WeakReference(view);
        C2941z0.f3292a.m1244a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda13
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m759b(weakReference, (C2561M4) obj);
            }
        });
    }

    public static void onSessionReplayLinkChange(@Nullable final Consumer<String> consumer) {
        f1111a.m827d("CS_API, onSessionReplayLinkChange");
        Telemetry.INSTANCE.collectApiCall("on_session_replay_link_change");
        C2941z0.f3292a.m1244a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda7
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m744a(consumer, (C2561M4) obj);
            }
        });
    }

    public static void optIn(@NonNull final Context context) {
        f1111a.m827d("CS_API, optIn");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda6
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m741a(context, (C2561M4) obj);
            }
        });
    }

    public static void optOut(@NonNull final Context context) {
        f1111a.m827d("CS_API, optOut");
        Telemetry.INSTANCE.collectApiCall("opt_out");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda5
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m755b(context, (C2561M4) obj);
            }
        });
    }

    public static void resumeTracking() {
        f1111a.m827d("CS_API, resumeTracking");
        Telemetry.INSTANCE.collectApiCall("resume_tracking");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda11
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m756b((C2561M4) obj);
            }
        });
    }

    public static void send(@NonNull final Transaction transaction) {
        f1111a.m827d("CS_API, send with transaction = " + transaction);
        Telemetry.INSTANCE.collectApiCall("send_transaction");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda21
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m745a(transaction, (C2561M4) obj);
            }
        });
    }

    public static void sendUserIdentifier(@NonNull final String str) {
        Telemetry.INSTANCE.collectApiCall("send_user_identifier");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda12
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m758b(str, (C2561M4) obj);
            }
        });
    }

    @UiThread
    public static void setDefaultMasking(final boolean z) {
        Telemetry.INSTANCE.collectApiCall("set_default_masking");
        C2941z0.f3292a.m1244a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda22
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m752a(z, (C2561M4) obj);
            }
        });
    }

    public static void start(@NonNull final Context context) {
        C2941z0 c2941z0 = C2941z0.f3292a;
        C2941z0.f3294c = true;
        C2437A0.m854a(context);
        Telemetry.INSTANCE.collectApiCall(ViewProps.START);
        c2941z0.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CsApplicationModule.getInstance((Application) context.getApplicationContext()).getBridgeManager().notifyStart();
            }
        });
    }

    public static void stopTracking() {
        f1111a.m827d("CS_API, stopTracking");
        Telemetry.INSTANCE.collectApiCall("stop_tracking");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda15
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m761c((C2561M4) obj);
            }
        });
    }

    @UiThread
    public static void triggerReplayForCurrentScreen(@NonNull final String str) {
        Telemetry.INSTANCE.collectApiCall("trigger_replay_for_current_screen");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda23
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m762c(str, (C2561M4) obj);
            }
        });
    }

    @UiThread
    public static void triggerReplayForCurrentSession(@NonNull final String str) {
        Telemetry.INSTANCE.collectApiCall("trigger_replay_for_current_session");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda18
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m764d(str, (C2561M4) obj);
            }
        });
    }

    @UiThread
    public static void unMask(@NonNull View view) {
        Telemetry.INSTANCE.collectApiCall("unmask");
        final WeakReference weakReference = new WeakReference(view);
        C2941z0.f3292a.m1244a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda9
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m763c(weakReference, (C2561M4) obj);
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static boolean wasInitialized() {
        Telemetry.INSTANCE.collectApiCall("was_initialized");
        return CsRuntimeModule.getInstance() != null;
    }

    /* JADX INFO: renamed from: c */
    public static void m761c(C2561M4 c2561m4) {
        CoreModule coreModule = CoreModule.getInstance();
        if (coreModule != null) {
            coreModule.getPreferencesStore().putBoolean(PreferencesKey.PAUSE_TRACKING, true);
        }
        C2746f5.f2633b.clear();
        c2561m4.f1862c.f3234f = false;
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            csApplicationModule.getBridgeManager().notifyStopTracking();
        }
        f1111a.m831i("Stopping Tracker");
    }

    @SafeVarargs
    public static void doNotTrack(@NonNull final Class<? extends Activity>... clsArr) {
        f1111a.m827d("CS_API, doNotTrack for activity classes");
        Telemetry.INSTANCE.collectApiCall("do_not_track");
        C2941z0.f3292a.m1244a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda4
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                C2598Q1.m1006a((Class<? extends Activity>[]) clsArr);
            }
        });
    }

    @UiThread
    public static void mask(@NonNull final Class<?> cls) {
        Telemetry.INSTANCE.collectApiCall("mask");
        C2941z0.f3292a.m1244a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda19
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m747a(cls, (C2561M4) obj);
            }
        });
    }

    public static void send(@NonNull final String str) {
        f1111a.m827d("CS_API, screenName = " + str);
        Telemetry.INSTANCE.collectApiCall("send_screen_name");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda17
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m749a(str, (C2561M4) obj);
            }
        });
    }

    @UiThread
    public static void unMask(@NonNull final Class<?> cls) {
        Telemetry.INSTANCE.collectApiCall("unmask");
        C2941z0.f3292a.m1244a(true, new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda20
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m757b(cls, (C2561M4) obj);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m743a(View view, C2561M4 c2561m4) {
        HashSet<Class<? extends Activity>> hashSet = C2598Q1.f1988a;
        Intrinsics.checkNotNullParameter(view, "view");
        C2598Q1.f1990c.put(view, null);
    }

    /* JADX INFO: renamed from: b */
    public static void m755b(Context context, C2561M4 c2561m4) {
        C2746f5.f2633b.clear();
        CoreModule.safeInstance(context).getPreferencesStore().putBoolean(PreferencesKey.IS_OPT_OUT, true);
        c2561m4.f1861b.m1057b();
        f1111a.m831i("Opting out");
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance((Application) context.getApplicationContext());
        csApplicationModule.getSdkManager().m1232a();
        csApplicationModule.getBridgeManager().notifyOptOut();
        C2624S8.f2118a.getClass();
        Iterator<Map.Entry<WebView, C2557M0>> it = C2624S8.f2124g.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().f1848g.m974c();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m751a(WeakReference weakReference, C2561M4 c2561m4) {
        C2527J0 csActivityCallbacks = CsRuntimeModule.getInstance() != null ? CsRuntimeModule.getInstance().getCsActivityCallbacks() : null;
        View view = (View) weakReference.get();
        if (csActivityCallbacks == null || view == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        csActivityCallbacks.f1729k.getClass();
        ViewTreeObserverOnGlobalLayoutListenerC2896u5.m1208a(view);
    }

    public static void send(@NonNull final String str, final long j) {
        f1111a.m827d("CS_API send, with key = " + str + ", value(long) = " + j);
        Telemetry.INSTANCE.collectApiCall("send_dynamic_var");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda10
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m748a(str, j, (C2561M4) obj);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m746a(C2561M4 c2561m4) {
        C2746f5.f2633b.clear();
        CoreModule coreModule = CoreModule.getInstance();
        if (coreModule != null) {
            coreModule.getPreferencesStore().putBoolean(PreferencesKey.FORGET_ME, true);
        }
        c2561m4.f1861b.m1057b();
        C2926x5 c2926x5 = c2561m4.f1862c;
        if (c2926x5.f3234f) {
            c2926x5.m1233a(false);
            c2926x5.f3234f = false;
        }
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            csApplicationModule.getBridgeManager().notifyForgetMe();
        }
        f1111a.m831i("Forgetting User");
    }

    /* JADX INFO: renamed from: c */
    public static void m762c(String name, C2561M4 c2561m4) {
        JsonConfig.SessionReplay sessionReplay;
        C2549L2 c2549l2 = c2561m4.f1860a;
        c2549l2.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        PreferencesStore preferencesStore = c2549l2.f1818g;
        PreferencesKey preferencesKey = PreferencesKey.SESSION_REPLAY_ETR_ENABLED;
        boolean etrEnabled = false;
        if (preferencesStore.contains(preferencesKey)) {
            etrEnabled = c2549l2.f1818g.getBoolean(preferencesKey, false);
        } else {
            JsonConfig.ProjectConfiguration projectConfig = c2549l2.f1815d.getProjectConfig();
            if (projectConfig != null && (sessionReplay = projectConfig.getSessionReplay()) != null) {
                etrEnabled = sessionReplay.getEtrEnabled();
            }
        }
        if (etrEnabled) {
            C2478E1 eventsBuildersFactory = c2549l2.f1822k.getEventsBuildersFactory();
            Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
            C2822n1.a aVar = (C2822n1.a) C2478E1.m901a(eventsBuildersFactory, 29);
            Intrinsics.checkNotNullParameter(name, "name");
            aVar.f2900k = name;
            c2549l2.f1814c.m1159a(aVar);
        } else {
            c2549l2.f1819h.m829e("ETR is disabled for this project.");
        }
        C2462C5 c2462c5 = C2462C5.f1468k;
        if (c2462c5 != null) {
            Intrinsics.checkNotNullParameter(name, "name");
            c2462c5.f1479g.m1192a(name);
        }
    }

    public static void send(@NonNull final String str, @NonNull final String str2) {
        f1111a.m827d("CS_API send, with key = " + str + ", value(string) = " + str2);
        Telemetry.INSTANCE.collectApiCall("send_dynamic_var");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda16
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m750a(str, str2, (C2561M4) obj);
            }
        });
    }

    public static void send(@NonNull final String str, @NonNull final CustomVar[] customVarArr) {
        Telemetry.INSTANCE.collectApiCall("send_custom_var");
        C2941z0.f3292a.m1243a(new Consumer() { // from class: com.contentsquare.android.Contentsquare$$ExternalSyntheticLambda8
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                Contentsquare.m753a(customVarArr, str, (C2561M4) obj);
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public static void m756b(C2561M4 c2561m4) {
        CoreModule coreModule = CoreModule.getInstance();
        if (coreModule != null) {
            coreModule.getPreferencesStore().putBoolean(PreferencesKey.PAUSE_TRACKING, false);
        }
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            csApplicationModule.getBridgeManager().notifyResumeTracking();
        }
        c2561m4.f1862c.f3234f = true;
        f1111a.m831i("Resuming Tracker");
    }

    /* JADX INFO: renamed from: a */
    public static void m747a(Class type, C2561M4 c2561m4) {
        C2684Z2 c2684z2 = C2462C5.f1469l;
        c2684z2.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        c2684z2.f2324c.remove(new C2684Z2.a(type, false));
        c2684z2.f2324c.add(new C2684Z2.a(type, true));
    }

    /* JADX INFO: renamed from: b */
    public static void m758b(String str, C2561M4 c2561m4) {
        c2561m4.f1860a.f1823l.m1004a(str);
    }

    /* JADX INFO: renamed from: c */
    public static void m763c(WeakReference weakReference, C2561M4 c2561m4) {
        View view = (View) weakReference.get();
        if (view != null) {
            C2684Z2 c2684z2 = C2462C5.f1469l;
            c2684z2.getClass();
            Intrinsics.checkNotNullParameter(view, "view");
            c2684z2.f2323b.put(view, Boolean.FALSE);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m757b(Class type, C2561M4 c2561m4) {
        C2684Z2 c2684z2 = C2462C5.f1469l;
        c2684z2.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        c2684z2.f2324c.remove(new C2684Z2.a(type, false));
        c2684z2.f2324c.add(new C2684Z2.a(type, false));
    }

    /* JADX INFO: renamed from: a */
    public static void m744a(Consumer consumer, C2561M4 c2561m4) {
        C2462C5 c2462c5 = C2462C5.f1468k;
        if (consumer == null) {
            C2462C5.f1470m.m831i("Callback for SessionReplay link update is unregistered");
        } else {
            C2462C5.f1470m.m831i("Callback for SessionReplay link update is registered");
        }
        C2462C5.f1471n = consumer;
        C2462C5 c2462c6 = C2462C5.f1468k;
        if (c2462c6 == null || consumer == null) {
            return;
        }
        Intrinsics.checkNotNull(c2462c6);
        consumer.accept(c2462c6.f1481i.m1164a());
    }

    /* JADX INFO: renamed from: a */
    public static void m741a(Context context, C2561M4 c2561m4) {
        Activity activity;
        PreferencesStore preferencesStore = CoreModule.safeInstance(context).getPreferencesStore();
        preferencesStore.putBoolean(PreferencesKey.IS_OPT_OUT, false);
        preferencesStore.putBoolean(PreferencesKey.FORGET_ME, false);
        CsApplicationModule.getInstance((Application) context.getApplicationContext()).getUserIdRestoreHelper().m987a();
        if (CsRuntimeModule.getInstance() != null && (activity = ContentsquareModule.getInstance(context).getLiveActivityProvider().f1856a.get()) != null) {
            C2527J0 csActivityCallbacks = CsRuntimeModule.getInstance().getCsActivityCallbacks();
            csActivityCallbacks.getClass();
            Intrinsics.checkNotNullParameter(activity, "activity");
            C2527J0.m946a(activity, csActivityCallbacks.f1736r, csActivityCallbacks.f1722d);
        }
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance((Application) context.getApplicationContext());
        csApplicationModule.getSdkManager().m1232a();
        csApplicationModule.getBridgeManager().notifyOptIn();
        C2624S8.f2118a.getClass();
        Iterator<Map.Entry<WebView, C2557M0>> it = C2624S8.f2124g.entrySet().iterator();
        while (it.hasNext()) {
            C2557M0 value = it.next().getValue();
            if (value.m984a()) {
                value.f1848g.m969a();
            }
        }
        Telemetry.INSTANCE.collectApiCall("opt_in");
        String strM986a = c2561m4.m986a();
        if (strM986a != null) {
            f1111a.m831i("Opt-in successful. User ID: ".concat(strM986a));
        } else {
            f1111a.m831i("Opt-in failed. User ID: UNKNOWN");
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m753a(CustomVar[] customVarArr, String screenName, C2561M4 c2561m4) {
        Logger logger;
        StringBuilder sb;
        Logger logger2;
        StringBuilder sb2;
        String str;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (CustomVar customVar : customVarArr) {
            if (customVar.getIndex() < 0) {
                logger2 = f1111a;
                sb2 = new StringBuilder("CS_API, Entry with invalid index ");
                sb2.append(customVar.getIndex());
                str = " will not be kept, index must have positive value";
            } else {
                if (hashSet.contains(Integer.valueOf(customVar.getIndex()))) {
                    logger2 = f1111a;
                    sb2 = new StringBuilder("CS_API, Found multiple entries with index ");
                    sb2.append(customVar.getIndex());
                    str = ", only first entry will be kept";
                } else {
                    hashSet.add(Integer.valueOf(customVar.getIndex()));
                    arrayList.add(customVar);
                }
            }
            sb2.append(str);
            logger2.m831i(sb2.toString());
        }
        CustomVar[] customVars = (CustomVar[]) arrayList.toArray(new CustomVar[0]);
        if (customVars.length == 0) {
            logger = f1111a;
            sb = new StringBuilder("CS_API, screenName = ");
            sb.append(screenName);
        } else {
            logger = f1111a;
            sb = new StringBuilder("CS_API, screenName = ");
            sb.append(screenName);
            sb.append(" - cVars ");
            sb.append(CustomVar.INSTANCE.generateCustomVarsLogMessage(customVars));
        }
        logger.m827d(sb.toString());
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(customVars, "customVars");
        C2746f5.m1128a(new C2706b5(screenName, customVars, false, null, 12));
    }

    /* JADX INFO: renamed from: a */
    public static void m748a(String str, long j, C2561M4 c2561m4) {
        DynamicVarLongValidator dynamicVarLongValidator = new DynamicVarLongValidator(str, j);
        C2549L2 c2549l2 = c2561m4.f1860a;
        c2549l2.getClass();
        Intrinsics.checkNotNullParameter(dynamicVarLongValidator, "dynamicVarLongValidator");
        C2478E1 eventsBuildersFactory = c2549l2.f1822k.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
        C2762h1.a aVar = (C2762h1.a) C2478E1.m901a(eventsBuildersFactory, 19);
        String key = dynamicVarLongValidator.getKey();
        Intrinsics.checkNotNullParameter(key, "key");
        aVar.f2683l = key;
        aVar.f2682k = dynamicVarLongValidator.getValue();
        c2549l2.f1814c.m1159a(aVar);
    }

    /* JADX INFO: renamed from: a */
    public static void m750a(String str, String str2, C2561M4 c2561m4) {
        DynamicVarStringValidator dynamicVarStringValidator = new DynamicVarStringValidator(str, str2);
        C2549L2 c2549l2 = c2561m4.f1860a;
        c2549l2.getClass();
        Intrinsics.checkNotNullParameter(dynamicVarStringValidator, "dynamicVarStringValidator");
        C2478E1 eventsBuildersFactory = c2549l2.f1822k.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
        C2772i1.a aVar = (C2772i1.a) C2478E1.m901a(eventsBuildersFactory, 18);
        String key = dynamicVarStringValidator.getKey();
        Intrinsics.checkNotNullParameter(key, "key");
        aVar.f2738l = key;
        String value = dynamicVarStringValidator.getValue();
        Intrinsics.checkNotNullParameter(value, "value");
        aVar.f2737k = value;
        c2549l2.f1814c.m1159a(aVar);
    }

    /* JADX INFO: renamed from: a */
    public static void m745a(Transaction transaction, C2561M4 c2561m4) {
        C2549L2 c2549l2 = c2561m4.f1860a;
        c2549l2.getClass();
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        C2478E1 eventsBuildersFactory = c2549l2.f1822k.getEventsBuildersFactory();
        Intrinsics.checkNotNullExpressionValue(eventsBuildersFactory, "csApplicationModule.eventsBuildersFactory");
        C2504G7.a aVar = (C2504G7.a) C2478E1.m901a(eventsBuildersFactory, 16);
        try {
            aVar.m926a(transaction);
            c2549l2.f1814c.m1159a(aVar);
        } catch (IllegalArgumentException e) {
            C2599Q2.m1011a(c2549l2.f1819h, "Transaction not registered: " + e, e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m749a(String screenName, C2561M4 c2561m4) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        C2746f5.m1128a(new C2706b5(screenName, null, false, null, 14));
    }

    /* JADX INFO: renamed from: a */
    public static void m752a(boolean z, C2561M4 c2561m4) {
        C2462C5.f1469l.f2322a.putBoolean(PreferencesKey.SESSION_REPLAY_DEFAULT_MASKING, z);
    }
}
