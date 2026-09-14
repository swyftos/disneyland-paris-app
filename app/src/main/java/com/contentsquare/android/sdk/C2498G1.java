package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.UriBuilder;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.G1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2498G1 implements PreferencesStore.PreferencesStoreListener {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2942z1 f1626a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2478E1 f1627b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final ExecutorService f1628c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Configuration f1629d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final PreferencesStore f1630e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final C2932y1 f1631f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final C2438A1 f1632g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final Logger f1633h;

    /* JADX INFO: renamed from: i */
    public int f1634i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public C2791k0 f1635j;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.G1$a */
    public static final class a extends Lambda implements Function1<JSONObject, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(JSONObject jSONObject) {
            JSONObject json = jSONObject;
            Intrinsics.checkNotNullParameter(json, "json");
            C2498G1.this.m922a(json);
            return Unit.INSTANCE;
        }
    }

    public C2498G1(@NotNull C2942z1 eventStorage, @NotNull C2478E1 eventsBuildersFactory, @NotNull ExecutorService threadExecutor, @NotNull C2780j analyticsPipeline, @NotNull Configuration configuration, @NotNull PreferencesStore preferencesStore, @NotNull C2932y1 eventSendingManager, @NotNull C2438A1 eventUrlGenerator) {
        Intrinsics.checkNotNullParameter(eventStorage, "eventStorage");
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(threadExecutor, "threadExecutor");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(eventSendingManager, "eventSendingManager");
        Intrinsics.checkNotNullParameter(eventUrlGenerator, "eventUrlGenerator");
        this.f1626a = eventStorage;
        this.f1627b = eventsBuildersFactory;
        this.f1628c = threadExecutor;
        this.f1629d = configuration;
        this.f1630e = preferencesStore;
        this.f1631f = eventSendingManager;
        this.f1632g = eventUrlGenerator;
        this.f1633h = new Logger("EventsProcessor");
        this.f1634i = 100;
        a aVar = new a();
        Job job = analyticsPipeline.f2758g;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        analyticsPipeline.f2758g = null;
        analyticsPipeline.f2758g = BuildersKt__Builders_commonKt.launch$default(analyticsPipeline.f2754c, null, null, new C2800l(analyticsPipeline, aVar, null), 3, null);
        preferencesStore.registerOnChangedListener(this);
        m923b();
    }

    /* JADX INFO: renamed from: a */
    public final void m921a() {
        C2791k0 c2791k0 = this.f1635j;
        if (c2791k0 != null) {
            this.f1626a.m1247a();
            Intrinsics.checkNotNullExpressionValue(c2791k0.f2794a.submit(new C2791k0.a(c2791k0)), "threadExecutor.submit(DispatchBucketsCallable())");
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m923b() {
        JsonConfig.ProjectConfiguration projectConfig = this.f1629d.getProjectConfig();
        if (projectConfig != null) {
            this.f1633h.m827d("Updating the configuration in EventsProcessor with collector endpoint: " + projectConfig.getEndpoint() + " and maxBucketSize: " + projectConfig.getBucketSize());
            String collectorsEndpoint = UriBuilder.buildEventsUrl(projectConfig.getEndpoint());
            C2791k0 c2791k0 = this.f1635j;
            if (c2791k0 != null) {
                Intrinsics.checkNotNullParameter(collectorsEndpoint, "collectorsEndpoint");
                c2791k0.f2797d = collectorsEndpoint;
            }
            if (this.f1635j == null) {
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
                this.f1635j = new C2791k0(executorServiceNewSingleThreadExecutor, this.f1626a, new HttpConnection(), collectorsEndpoint, this.f1627b, this.f1630e, this.f1631f, this.f1632g);
            }
            this.f1634i = projectConfig.getBucketSize();
        }
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == PreferencesKey.RAW_CONFIGURATION_AS_JSON) {
            m923b();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m922a(final JSONObject jSONObject) {
        this.f1628c.submit(new Runnable() { // from class: com.contentsquare.android.sdk.G1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2498G1.m920a(this.f$0, jSONObject);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0071 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0021, B:6:0x0032, B:15:0x0059, B:17:0x0061, B:18:0x0071, B:11:0x0042), top: B:45:0x0021, inners: #0 }] */
    /* JADX INFO: renamed from: a */
    public static final void m920a(C2498G1 this$0, JSONObject event) {
        Integer numValueOf;
        boolean z;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        this$0.f1633h.m827d("processing event: " + event);
        C2942z1 c2942z1 = this$0.f1626a;
        synchronized (c2942z1) {
            Intrinsics.checkNotNullParameter(event, "event");
            c2942z1.m1252b();
            if (event.has("sn")) {
                try {
                    numValueOf = Integer.valueOf(event.getInt("sn"));
                } catch (JSONException e) {
                    C2599Q2.m1011a(c2942z1.f3300d, "Error getting the session number for the event = " + event, e);
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
            if (numValueOf != null) {
                if (numValueOf.intValue() != c2942z1.f3304h) {
                    c2942z1.m1249a(event, numValueOf.intValue(), c2942z1.m1245a(numValueOf.intValue()));
                } else {
                    c2942z1.m1249a(event, c2942z1.f3304h, c2942z1.f3303g);
                    c2942z1.f3305i++;
                }
            } else {
                c2942z1.m1249a(event, c2942z1.f3304h, c2942z1.f3303g);
                c2942z1.f3305i++;
            }
        }
        boolean z2 = this$0.f1630e.getBoolean(PreferencesKey.LOCAL_LOG_VISUALIZER_MODE, false);
        boolean z3 = this$0.f1626a.f3305i >= this$0.f1634i;
        try {
            z = event.has("ea") && event.getInt("ea") == 24;
        } catch (JSONException e2) {
            C2599Q2.m1011a(this$0.f1633h, "Error getting event action for the event " + event, e2);
        }
        if (z2 || z3 || z) {
            this$0.m921a();
        }
    }
}
