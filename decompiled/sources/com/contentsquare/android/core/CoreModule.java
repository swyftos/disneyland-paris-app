package com.contentsquare.android.core;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/contentsquare/android/core/CoreModule;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "Lcom/contentsquare/android/core/features/config/Configuration;", "configuration", "getConfiguration", "()Lcom/contentsquare/android/core/features/config/Configuration;", "Lcom/contentsquare/android/core/system/DeviceInfo;", ErrorLogHelper.DEVICE_INFO_FILE, "getDeviceInfo", "()Lcom/contentsquare/android/core/system/DeviceInfo;", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore;", "preferencesStore", "getPreferencesStore", "()Lcom/contentsquare/android/core/features/preferences/PreferencesStore;", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CoreModule {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static CoreModule instance;

    @NotNull
    private Configuration configuration;

    @NotNull
    private DeviceInfo deviceInfo;

    @NotNull
    private PreferencesStore preferencesStore;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007R0\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@GX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/core/CoreModule$Companion;", "", "()V", "<set-?>", "Lcom/contentsquare/android/core/CoreModule;", "instance", "getInstance$annotations", "getInstance", "()Lcom/contentsquare/android/core/CoreModule;", "setInstance", "(Lcom/contentsquare/android/core/CoreModule;)V", "safeInstance", "context", "Landroid/content/Context;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @Nullable
        public final CoreModule getInstance() {
            return CoreModule.instance;
        }

        @JvmStatic
        @NotNull
        public final synchronized CoreModule safeInstance(Context context) {
            CoreModule companion;
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                if (getInstance() == null) {
                    setInstance(new CoreModule(context, null));
                }
                companion = getInstance();
                Intrinsics.checkNotNull(companion);
            } catch (Throwable th) {
                throw th;
            }
            return companion;
        }

        @VisibleForTesting
        public final void setInstance(CoreModule coreModule) {
            CoreModule.instance = coreModule;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private CoreModule(Context context) {
        this.preferencesStore = new PreferencesStore(context);
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Application");
        this.deviceInfo = new DeviceInfo((Application) context, new DisplayMetrics(), null, null, null, null, 60, null);
        this.configuration = new Configuration(this.preferencesStore, null, 2, null);
    }

    @Nullable
    public static final CoreModule getInstance() {
        return INSTANCE.getInstance();
    }

    @JvmStatic
    @NotNull
    public static final synchronized CoreModule safeInstance(Context context) {
        return INSTANCE.safeInstance(context);
    }

    @VisibleForTesting
    public static final void setInstance(CoreModule coreModule) {
        INSTANCE.setInstance(coreModule);
    }

    @NotNull
    public final Configuration getConfiguration() {
        return this.configuration;
    }

    @NotNull
    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    @NotNull
    public final PreferencesStore getPreferencesStore() {
        return this.preferencesStore;
    }

    public /* synthetic */ CoreModule(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }
}
