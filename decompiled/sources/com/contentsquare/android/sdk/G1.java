package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.UriBuilder;
import com.contentsquare.android.sdk.C0721k0;
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
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class G1 implements PreferencesStore.PreferencesStoreListener {

    @NotNull
    public final C0867z1 a;

    @NotNull
    public final E1 b;

    @NotNull
    public final ExecutorService c;

    @NotNull
    public final Configuration d;

    @NotNull
    public final PreferencesStore e;

    @NotNull
    public final C0858y1 f;

    @NotNull
    public final A1 g;

    @NotNull
    public final Logger h;
    public int i;

    @Nullable
    public C0721k0 j;

    public static final class a extends Lambda implements Function1<JSONObject, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(JSONObject jSONObject) {
            JSONObject json = jSONObject;
            Intrinsics.checkNotNullParameter(json, "json");
            G1.this.a(json);
            return Unit.INSTANCE;
        }
    }

    public G1(@NotNull C0867z1 eventStorage, @NotNull E1 eventsBuildersFactory, @NotNull ExecutorService threadExecutor, @NotNull C0710j analyticsPipeline, @NotNull Configuration configuration, @NotNull PreferencesStore preferencesStore, @NotNull C0858y1 eventSendingManager, @NotNull A1 eventUrlGenerator) {
        Intrinsics.checkNotNullParameter(eventStorage, "eventStorage");
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(threadExecutor, "threadExecutor");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(eventSendingManager, "eventSendingManager");
        Intrinsics.checkNotNullParameter(eventUrlGenerator, "eventUrlGenerator");
        this.a = eventStorage;
        this.b = eventsBuildersFactory;
        this.c = threadExecutor;
        this.d = configuration;
        this.e = preferencesStore;
        this.f = eventSendingManager;
        this.g = eventUrlGenerator;
        this.h = new Logger("EventsProcessor");
        this.i = 100;
        a aVar = new a();
        Job job = analyticsPipeline.g;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        analyticsPipeline.g = null;
        analyticsPipeline.g = BuildersKt__Builders_commonKt.launch$default(analyticsPipeline.c, null, null, new C0730l(analyticsPipeline, aVar, null), 3, null);
        preferencesStore.registerOnChangedListener(this);
        b();
    }

    public final void a() {
        C0721k0 c0721k0 = this.j;
        if (c0721k0 != null) {
            this.a.a();
            Intrinsics.checkNotNullExpressionValue(c0721k0.a.submit(new C0721k0.a(c0721k0)), "threadExecutor.submit(DispatchBucketsCallable())");
        }
    }

    public final void b() {
        JsonConfig.ProjectConfiguration projectConfig = this.d.getProjectConfig();
        if (projectConfig != null) {
            this.h.d("Updating the configuration in EventsProcessor with collector endpoint: " + projectConfig.getEndpoint() + " and maxBucketSize: " + projectConfig.getBucketSize());
            String collectorsEndpoint = UriBuilder.buildEventsUrl(projectConfig.getEndpoint());
            C0721k0 c0721k0 = this.j;
            if (c0721k0 != null) {
                Intrinsics.checkNotNullParameter(collectorsEndpoint, "collectorsEndpoint");
                c0721k0.d = collectorsEndpoint;
            }
            if (this.j == null) {
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
                this.j = new C0721k0(executorServiceNewSingleThreadExecutor, this.a, new HttpConnection(), collectorsEndpoint, this.b, this.e, this.f, this.g);
            }
            this.i = projectConfig.getBucketSize();
        }
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == PreferencesKey.RAW_CONFIGURATION_AS_JSON) {
            b();
        }
    }

    public final void a(final JSONObject jSONObject) {
        this.c.submit(new Runnable() { // from class: com.contentsquare.android.sdk.G1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                G1.a(this.f$0, jSONObject);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0020, B:6:0x0030, B:15:0x0056, B:17:0x005e, B:18:0x006e, B:11:0x003f), top: B:43:0x0020, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.contentsquare.android.sdk.G1 r7, org.json.JSONObject r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "$event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.contentsquare.android.core.features.logging.Logger r0 = r7.h
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "processing event: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.d(r1)
            com.contentsquare.android.sdk.z1 r0 = r7.a
            monitor-enter(r0)
            java.lang.String r1 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)     // Catch: java.lang.Throwable -> L3b
            r0.b()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r1 = "sn"
            boolean r1 = r8.has(r1)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L52
            java.lang.String r1 = "sn"
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L3b org.json.JSONException -> L3e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L3b org.json.JSONException -> L3e
            goto L53
        L3b:
            r7 = move-exception
            goto Lc4
        L3e:
            r1 = move-exception
            com.contentsquare.android.core.features.logging.Logger r2 = r0.d     // Catch: java.lang.Throwable -> L3b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "Error getting the session number for the event = "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3b
            r3.append(r8)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3b
            com.contentsquare.android.sdk.Q2.a(r2, r3, r1)     // Catch: java.lang.Throwable -> L3b
        L52:
            r1 = 0
        L53:
            r2 = 1
            if (r1 == 0) goto L6e
            int r3 = r0.h     // Catch: java.lang.Throwable -> L3b
            int r4 = r1.intValue()     // Catch: java.lang.Throwable -> L3b
            if (r4 == r3) goto L6e
            int r3 = r1.intValue()     // Catch: java.lang.Throwable -> L3b
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L3b
            int r1 = r0.a(r1)     // Catch: java.lang.Throwable -> L3b
            r0.a(r8, r3, r1)     // Catch: java.lang.Throwable -> L3b
            goto L7a
        L6e:
            int r1 = r0.h     // Catch: java.lang.Throwable -> L3b
            int r3 = r0.g     // Catch: java.lang.Throwable -> L3b
            r0.a(r8, r1, r3)     // Catch: java.lang.Throwable -> L3b
            int r1 = r0.i     // Catch: java.lang.Throwable -> L3b
            int r1 = r1 + r2
            r0.i = r1     // Catch: java.lang.Throwable -> L3b
        L7a:
            monitor-exit(r0)
            com.contentsquare.android.core.features.preferences.PreferencesStore r0 = r7.e
            com.contentsquare.android.core.features.preferences.PreferencesKey r1 = com.contentsquare.android.core.features.preferences.PreferencesKey.LOCAL_LOG_VISUALIZER_MODE
            r3 = 0
            boolean r0 = r0.getBoolean(r1, r3)
            com.contentsquare.android.sdk.z1 r1 = r7.a
            int r1 = r1.i
            int r4 = r7.i
            if (r1 < r4) goto L8e
            r1 = r2
            goto L8f
        L8e:
            r1 = r3
        L8f:
            java.lang.String r4 = "ea"
            boolean r4 = r8.has(r4)     // Catch: org.json.JSONException -> La2
            if (r4 == 0) goto La4
            java.lang.String r4 = "ea"
            int r8 = r8.getInt(r4)     // Catch: org.json.JSONException -> La2
            r4 = 24
            if (r8 != r4) goto La4
            goto Lba
        La2:
            r2 = move-exception
            goto La6
        La4:
            r2 = r3
            goto Lba
        La6:
            com.contentsquare.android.core.features.logging.Logger r4 = r7.h
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Error getting event action for the event "
            r5.<init>(r6)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            com.contentsquare.android.sdk.Q2.a(r4, r8, r2)
            goto La4
        Lba:
            if (r0 != 0) goto Lc0
            if (r1 != 0) goto Lc0
            if (r2 == 0) goto Lc3
        Lc0:
            r7.a()
        Lc3:
            return
        Lc4:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.G1.a(com.contentsquare.android.sdk.G1, org.json.JSONObject):void");
    }
}
