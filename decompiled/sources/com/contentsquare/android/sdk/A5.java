package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.BuildInformation;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.internal.features.bridge.heap.HeapBridge;
import com.contentsquare.android.sdk.AbstractC0660e;
import com.contentsquare.android.sdk.C0646c5;
import com.contentsquare.android.sdk.C0822u2;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Session.kt\ncom/contentsquare/android/analytics/internal/session/Session\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,348:1\n8676#2,2:349\n9358#2,4:351\n*S KotlinDebug\n*F\n+ 1 Session.kt\ncom/contentsquare/android/analytics/internal/session/Session\n*L\n339#1:349,2\n339#1:351,4\n*E\n"})
/* loaded from: classes2.dex */
public final class A5 implements B5, PreferencesStore.PreferencesStoreListener {

    @NotNull
    public final L5 a;

    @NotNull
    public final C0710j b;

    @NotNull
    public final Configuration c;

    @NotNull
    public final BuildInformation d;

    @NotNull
    public final I1 e;

    @NotNull
    public final PreferencesStore f;

    @NotNull
    public final HeapBridge g;

    @NotNull
    public final Logger h;

    @Nullable
    public C0646c5.a i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;

    public static final class a {
        public static final boolean a(AbstractC0660e.a aVar) {
            return aVar.a == 1;
        }

        public static final boolean b(AbstractC0660e.a aVar) {
            return aVar.a == 4;
        }

        public static boolean c(AbstractC0660e.a aVar) {
            return aVar.a == -2;
        }
    }

    @JvmOverloads
    public A5(@NotNull L5 sessionRestoreHelper, @NotNull M7 userIdRestoreHelper, @NotNull C0710j analyticsPipeline, @NotNull Configuration configuration, @NotNull BuildInformation buildInformation, @NotNull I1 eventsStatusPrefsHelper, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(sessionRestoreHelper, "sessionRestoreHelper");
        Intrinsics.checkNotNullParameter(userIdRestoreHelper, "userIdRestoreHelper");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        Intrinsics.checkNotNullParameter(eventsStatusPrefsHelper, "eventsStatusPrefsHelper");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        HeapBridge heapBridge = HeapBridge.INSTANCE;
        Intrinsics.checkNotNullParameter(sessionRestoreHelper, "sessionRestoreHelper");
        Intrinsics.checkNotNullParameter(userIdRestoreHelper, "userIdRestoreHelper");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        Intrinsics.checkNotNullParameter(eventsStatusPrefsHelper, "eventsStatusPrefsHelper");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(heapBridge, "heapBridge");
        this.a = sessionRestoreHelper;
        this.b = analyticsPipeline;
        this.c = configuration;
        this.d = buildInformation;
        this.e = eventsStatusPrefsHelper;
        this.f = preferencesStore;
        this.g = heapBridge;
        Logger logger = new Logger("Session");
        this.h = logger;
        this.j = sessionRestoreHelper.a.getInt(PreferencesKey.SCREEN_NUMBER, 0);
        PreferencesStore preferencesStore2 = sessionRestoreHelper.a;
        PreferencesKey preferencesKey = PreferencesKey.SESSION_ID;
        if (!preferencesStore2.contains(preferencesKey)) {
            sessionRestoreHelper.a.putInt(preferencesKey, 1);
        }
        this.k = sessionRestoreHelper.a.getInt(preferencesKey, 1);
        this.m = true;
        analyticsPipeline.h = this;
        preferencesStore.registerOnChangedListener(this);
        logger.i("Starting with user id: " + userIdRestoreHelper.a() + " session number: " + this.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map] */
    @Override // com.contentsquare.android.sdk.B5
    @NotNull
    public final AbstractC0660e a(@NotNull AbstractC0660e actionEvent) {
        LinkedHashMap linkedHashMapEmptyMap;
        Intrinsics.checkNotNullParameter(actionEvent, "actionEvent");
        if (actionEvent instanceof C0646c5) {
            this.h.d("Pushing screen view event: [ " + actionEvent + " ] through Heap");
            HeapBridge heapBridge = this.g;
            C0646c5 c0646c5 = (C0646c5) actionEvent;
            String str = c0646c5.n;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            long j = actionEvent.j;
            CustomVar[] customVarArr = c0646c5.o;
            if (customVarArr != null) {
                linkedHashMapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(customVarArr.length), 16));
                for (CustomVar customVar : customVarArr) {
                    Pair pair = TuplesKt.to(customVar.getName(), customVar.getValue());
                    linkedHashMapEmptyMap.put(pair.getFirst(), pair.getSecond());
                }
            } else {
                linkedHashMapEmptyMap = null;
            }
            if (linkedHashMapEmptyMap == null) {
                linkedHashMapEmptyMap = MapsKt.emptyMap();
            }
            heapBridge.onScreenViewEvent(str2, j, linkedHashMapEmptyMap, c0646c5.p);
        }
        return actionEvent;
    }

    @Override // com.contentsquare.android.sdk.B5
    @NotNull
    public final AbstractC0660e.a<?> b(@NotNull AbstractC0660e.a<?> actionEventBuilder) {
        Intrinsics.checkNotNullParameter(actionEventBuilder, "actionEventBuilder");
        if (a.b(actionEventBuilder)) {
            this.h.d("incrementScreenNumber");
            L5 l5 = this.a;
            int i = this.j + 1;
            this.j = i;
            l5.a.putInt(PreferencesKey.SCREEN_NUMBER, i);
        }
        return actionEventBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
    @Override // com.contentsquare.android.sdk.B5
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.contentsquare.android.sdk.AbstractC0660e.a<?> c(@org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.AbstractC0660e.a<?> r9) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.A5.c(com.contentsquare.android.sdk.e$a):com.contentsquare.android.sdk.e$a");
    }

    public final boolean d(AbstractC0660e.a<?> aVar) {
        PreferencesStore preferencesStore = this.e.a;
        PreferencesKey preferencesKey = PreferencesKey.LAST_EVENT_TIMESTAMP;
        long j = preferencesStore.getLong(preferencesKey, 0L);
        this.e.a.putLong(preferencesKey, aVar.i);
        JsonConfig.ProjectConfiguration projectConfig = this.c.getProjectConfig();
        if (j == 0 || projectConfig == null) {
            return false;
        }
        if (!C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.UNIFIED_SESSION_DEFINITION) && !a.a(aVar) && aVar.a != 0 && !a.c(aVar)) {
            return false;
        }
        if (a.c(aVar)) {
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.contentsquare.android.analytics.internal.model.data.HeapSessionStartEvent.HeapSessionStartEventBuilder");
            return ((C0822u2.a) aVar).k;
        }
        if (aVar.a == 0) {
            PreferencesStore preferencesStore2 = this.f;
            PreferencesKey preferencesKey2 = PreferencesKey.LAST_APP_VERSION_NUMBER;
            long j2 = preferencesStore2.getLong(preferencesKey2, -1L);
            long applicationVersionCode = this.d.getApplicationVersionCode();
            if (j2 != applicationVersionCode) {
                this.f.putLong(preferencesKey2, applicationVersionCode);
            }
            boolean z = j2 != applicationVersionCode;
            PreferencesStore preferencesStore3 = this.f;
            PreferencesKey preferencesKey3 = PreferencesKey.LAST_SDK_VERSION_NUMBER;
            int i = preferencesStore3.getInt(preferencesKey3, -1);
            int sdkBuild = this.d.getSdkBuild();
            if (i != sdkBuild) {
                this.f.putInt(preferencesKey3, sdkBuild);
            }
            boolean z2 = i != sdkBuild;
            if (z || z2) {
                return true;
            }
        }
        return aVar.i - j >= ((long) (this.f.getBoolean(PreferencesKey.DEVELOPER_SESSION_TIMEOUT_TO_0, false) ? 500 : projectConfig.getSessionTimeout()));
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        PreferencesKey preferencesKey = PreferencesKey.SESSION_ID;
        if (key != preferencesKey || this.f.contains(preferencesKey)) {
            return;
        }
        L5 l5 = this.a;
        if (!l5.a.contains(preferencesKey)) {
            l5.a.putInt(preferencesKey, 1);
        }
        this.k = l5.a.getInt(preferencesKey, 1);
        this.j = this.a.a.getInt(PreferencesKey.SCREEN_NUMBER, 0);
        this.h.i("Starting session number: " + this.k);
    }

    @Override // com.contentsquare.android.sdk.B5
    @Nullable
    public final AbstractC0660e.a<?> a(@NotNull AbstractC0660e.a<?> actionEventBuilder) {
        Intrinsics.checkNotNullParameter(actionEventBuilder, "actionEventBuilder");
        if (a.c(actionEventBuilder)) {
            C0646c5.a aVar = this.i;
            if (aVar == null || aVar.n) {
                return null;
            }
            this.h.d("incrementScreenNumber");
            L5 l5 = this.a;
            int i = this.j + 1;
            this.j = i;
            l5.a.putInt(PreferencesKey.SCREEN_NUMBER, i);
            aVar.h = this.k;
            aVar.c = this.j;
            this.f.putLong(PreferencesKey.SCREEN_TIMESTAMP, actionEventBuilder.i);
            return aVar;
        }
        if (a.b(actionEventBuilder)) {
            this.i = (C0646c5.a) actionEventBuilder;
        }
        actionEventBuilder.h = this.k;
        actionEventBuilder.c = this.j;
        return actionEventBuilder;
    }
}
