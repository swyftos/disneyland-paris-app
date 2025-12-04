package com.contentsquare.android.sdk;

import android.os.SystemClock;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.system.OnNetworkStateChangeListener;
import com.contentsquare.android.sdk.C0695h4;
import com.contentsquare.android.sdk.C5;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.j4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0715j4 implements PreferencesStore.PreferencesStoreListener, OnNetworkStateChangeListener {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final Configuration b;

    @NotNull
    public final DeviceInfo c;

    @NotNull
    public final C0695h4 d;

    @NotNull
    public final R3 e;

    @NotNull
    public final Logger f;
    public int g;
    public int h;

    @NotNull
    public QualityLevel i;

    @NotNull
    public String j;

    @NotNull
    public ConnectionType k;

    /* renamed from: com.contentsquare.android.sdk.j4$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[PreferencesKey.values().length];
            try {
                iArr[PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreferencesKey.DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreferencesKey.DEVELOPER_SESSION_REPLAY_FPS_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreferencesKey.RAW_CONFIGURATION_AS_JSON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[QualityLevel.values().length];
            try {
                iArr2[QualityLevel.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[QualityLevel.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[QualityLevel.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    public C0715j4(PreferencesStore preferencesStore, Configuration configuration, DeviceInfo deviceInfo, C0695h4 srEventProvider) {
        R3 performanceMeasurement = new R3(new V6());
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(srEventProvider, "srEventProvider");
        Intrinsics.checkNotNullParameter(performanceMeasurement, "performanceMeasurement");
        this.a = preferencesStore;
        this.b = configuration;
        this.c = deviceInfo;
        this.d = srEventProvider;
        this.e = performanceMeasurement;
        Logger logger = new Logger("QualitySettings");
        this.f = logger;
        QualityLevel.Companion companion = QualityLevel.INSTANCE;
        this.i = companion.valueOfIgnoreCase(companion.getDEFAULT_RECORDING_QUALITY());
        this.j = companion.getDEFAULT_RECORDING_QUALITY();
        preferencesStore.registerOnChangedListener(this);
        this.k = deviceInfo.getActiveConnectionType();
        deviceInfo.registerOnNetworkStateChangedListener(this);
        a();
        QualityLevel qualityLevel = QualityLevel.values()[this.h];
        Intrinsics.checkNotNullParameter(qualityLevel, "<set-?>");
        srEventProvider.b = qualityLevel;
        logger.d("Parameters at instantiation:\nIs forced quality: " + preferencesStore.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, false) + "\nFPS: " + this.g + "\nImage quality: " + this.h + "\nMax millisecond ui thread usage: " + preferencesStore.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC, 40) + "\nSample number: 10");
    }

    public final void a() {
        JsonConfig.SessionReplay sessionReplay;
        String str;
        if (this.a.getBoolean(PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL, false)) {
            PreferencesStore preferencesStore = this.a;
            PreferencesKey preferencesKey = PreferencesKey.DEVELOPER_SESSION_REPLAY_FPS_VALUE;
            QualityLevel qualityLevel = QualityLevel.MEDIUM;
            this.g = preferencesStore.getInt(preferencesKey, qualityLevel.getFPS());
            this.h = this.a.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE, qualityLevel.ordinal());
        } else {
            QualityLevel.Companion companion = QualityLevel.INSTANCE;
            String default_recording_quality = companion.getDEFAULT_RECORDING_QUALITY();
            JsonConfig.ProjectConfiguration projectConfig = this.b.getProjectConfig();
            if (projectConfig != null && (sessionReplay = projectConfig.getSessionReplay()) != null) {
                ConnectionType activeConnectionType = this.c.getActiveConnectionType();
                this.k = activeConnectionType;
                default_recording_quality = activeConnectionType == ConnectionType.WIFI ? sessionReplay.getRecordingQualityWifi() : sessionReplay.getRecordingQualityCellular();
            }
            this.j = default_recording_quality;
            QualityLevel qualityLevelValueOfIgnoreCase = companion.valueOfIgnoreCase(default_recording_quality);
            this.i = qualityLevelValueOfIgnoreCase;
            this.g = qualityLevelValueOfIgnoreCase.getFPS();
            this.h = this.i.ordinal();
        }
        try {
            int i = a.b[QualityLevel.INSTANCE.valueOfIgnoreCase(this.j).ordinal()];
            if (i == 1) {
                str = "Best quality";
            } else if (i == 2) {
                str = "Standard";
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "Optimized";
            }
        } catch (IllegalArgumentException unused) {
            str = "UNKNOWN";
        }
        String str2 = this.c.getActiveConnectionType() == ConnectionType.WIFI ? "Wifi" : "Cellular";
        this.f.i("Session Replay quality settings applied: " + str2 + " - Data usage " + str + " (Image: " + this.h + " - FPS: " + this.g + CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }

    public final void b() {
        R3 r3;
        R3 r32 = this.e;
        long[] jArr = r32.b;
        int i = r32.c;
        r32.a.getClass();
        jArr[i] = SystemClock.elapsedRealtime() - r32.d;
        int i2 = r32.c + 1;
        r32.c = i2;
        if (i2 >= r32.b.length) {
            r32.c = 0;
            r32.e = true;
        }
        R3 r33 = this.e;
        long jRoundToLong = r33.e ? MathKt.roundToLong(ArraysKt.average(r33.b)) : -1L;
        if (jRoundToLong != -1) {
            Logger logger = this.f;
            StringBuilder sb = new StringBuilder("Session Replay quality performance was ");
            sb.append(jRoundToLong);
            sb.append(" ms. Forced Quality: ");
            PreferencesStore preferencesStore = this.a;
            PreferencesKey preferencesKey = PreferencesKey.DEVELOPER_SESSION_REPLAY_FORCE_QUALITY_LEVEL;
            sb.append(preferencesStore.getBoolean(preferencesKey, false));
            logger.d(sb.toString());
            if (this.a.getBoolean(preferencesKey, false)) {
                PreferencesStore preferencesStore2 = this.a;
                PreferencesKey preferencesKey2 = PreferencesKey.DEVELOPER_SESSION_REPLAY_FPS_VALUE;
                QualityLevel qualityLevel = QualityLevel.MEDIUM;
                this.g = preferencesStore2.getInt(preferencesKey2, qualityLevel.getFPS());
                this.h = this.a.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_IMAGE_QUALITY_VALUE, qualityLevel.ordinal());
                return;
            }
            if (jRoundToLong >= this.a.getInt(PreferencesKey.DEVELOPER_SESSION_REPLAY_MAXIMUM_USAGE_ON_UI_THREAD_IN_MILLI_SEC, 40)) {
                int iOrdinal = this.i.ordinal();
                if (iOrdinal <= 0) {
                    C5 c5 = C5.k;
                    C5.a.a();
                    this.f.d("Session Replay stopped due to too much performance impact on UI thread");
                } else {
                    QualityLevel qualityLevel2 = QualityLevel.values()[iOrdinal - 1];
                    this.i = qualityLevel2;
                    this.g = qualityLevel2.getFPS();
                    this.h = this.i.ordinal();
                    a(EnumC0705i4.CPU_USAGE);
                    this.f.d("Session Replay quality reduced from " + QualityLevel.values()[iOrdinal] + " to " + this.i);
                }
                r3 = this.e;
            } else {
                QualityLevel qualityLevelValueOfIgnoreCase = QualityLevel.INSTANCE.valueOfIgnoreCase(this.j);
                if (this.i.ordinal() >= qualityLevelValueOfIgnoreCase.ordinal()) {
                    return;
                }
                this.i = qualityLevelValueOfIgnoreCase;
                this.g = qualityLevelValueOfIgnoreCase.getFPS();
                this.h = this.i.ordinal();
                a(EnumC0705i4.CPU_USAGE);
                this.f.d("Session Replay quality increased to " + this.i);
                r3 = this.e;
            }
            r3.c = 0;
            r3.e = false;
        }
    }

    @Override // com.contentsquare.android.core.system.OnNetworkStateChangeListener
    public final void onNetworkStateChanged() {
        this.k = this.c.getActiveConnectionType();
        EnumC0705i4 enumC0705i4 = EnumC0705i4.NETWORK_CHANGED;
        a();
        a(enumC0705i4);
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int i = a.a[key.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            EnumC0705i4 enumC0705i4 = EnumC0705i4.CONFIG_APPLIED;
            a();
            a(enumC0705i4);
        }
    }

    public final void a(EnumC0705i4 reason) {
        C0695h4 c0695h4 = this.d;
        QualityLevel currentQualityLevel = this.i;
        ConnectionType currentConnectionType = this.k;
        synchronized (c0695h4) {
            try {
                Intrinsics.checkNotNullParameter(reason, "reason");
                Intrinsics.checkNotNullParameter(currentQualityLevel, "currentQualityLevel");
                Intrinsics.checkNotNullParameter(currentConnectionType, "currentConnectionType");
                if (currentConnectionType != ConnectionType.OFFLINE && currentQualityLevel != c0695h4.b) {
                    c0695h4.a.a(new C0725k4(System.currentTimeMillis(), reason, c0695h4.b, currentQualityLevel, c0695h4.c, currentConnectionType));
                    QualityLevel qualityLevel = c0695h4.b;
                    ConnectionType connectionType = c0695h4.c;
                    String string = "Sr QualityChanged event added: " + reason + " | " + qualityLevel.name() + " -> " + currentQualityLevel.name();
                    if (reason == EnumC0705i4.NETWORK_CHANGED) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(string);
                        sb.append(" | ");
                        int[] iArr = C0695h4.a.a;
                        int i = iArr[connectionType.ordinal()];
                        sb.append((i == 1 || i == 2) ? "Error" : i != 3 ? "Cellular" : "Wifi");
                        sb.append(" -> ");
                        int i2 = iArr[currentConnectionType.ordinal()];
                        sb.append((i2 == 1 || i2 == 2) ? "Error" : i2 != 3 ? "Cellular" : "Wifi");
                        string = sb.toString();
                    }
                    c0695h4.d.d(string);
                    c0695h4.b = currentQualityLevel;
                    c0695h4.c = currentConnectionType;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
