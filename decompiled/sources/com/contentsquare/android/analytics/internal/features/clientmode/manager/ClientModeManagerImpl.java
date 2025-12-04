package com.contentsquare.android.analytics.internal.features.clientmode.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.util.Predicate;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.deactivationdialog.DeactivationActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.developer.DeveloperActivationActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayService;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.SettingsActivity;
import com.contentsquare.android.analytics.internal.features.clientmode.ui.tutorial.ClientModeTutorialActivity;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.sdk.C0724k3;
import com.contentsquare.android.sdk.M2;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class ClientModeManagerImpl implements PreferencesStore.PreferencesStoreListener {

    @NotNull
    public final C0724k3 a;

    @NotNull
    public final Logger b;

    @NotNull
    public final Configuration c;
    public boolean d;
    public boolean e;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/android/analytics/internal/features/clientmode/manager/ClientModeManagerImpl$ClientModeLifecycleMonitor;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "library_release"}, k = 1, mv = {1, 8, 0})
    public final class ClientModeLifecycleMonitor implements DefaultLifecycleObserver, Application.ActivityLifecycleCallbacks {
        public ClientModeLifecycleMonitor() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ClientModeManagerImpl.this.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public final void onPause(@NotNull LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            ClientModeManagerImpl clientModeManagerImpl = ClientModeManagerImpl.this;
            if (clientModeManagerImpl.d) {
                C0724k3 c0724k3 = clientModeManagerImpl.a;
                if (c0724k3.f == 1) {
                    c0724k3.a.stopService(new Intent(c0724k3.a, (Class<?>) OverlayService.class));
                }
                ClientModeManagerImpl.this.e = false;
            }
        }
    }

    public static final class a implements Predicate<Activity> {

        @NotNull
        public static final Set<Class<?>> a = SetsKt.setOf((Object[]) new Class[]{ClientModeTutorialActivity.class, SettingsActivity.class, DeactivationActivity.class, DeveloperActivationActivity.class});

        @Override // androidx.core.util.Predicate
        public final boolean test(Activity activity) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            return a.contains(activity2.getClass());
        }
    }

    public ClientModeManagerImpl(@NotNull C0724k3 navigator, @NotNull Application application, @NotNull LifecycleOwner lifecycleOwner, @NotNull M2 liveActivityProvider) {
        JsonConfig.InAppConfig inAppConfig;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(liveActivityProvider, "liveActivityProvider");
        this.a = navigator;
        Logger logger = new Logger("ClientModeManagerImpl");
        this.b = logger;
        CoreModule.Companion companion = CoreModule.INSTANCE;
        Configuration configuration = companion.safeInstance(application).getConfiguration();
        this.c = configuration;
        companion.safeInstance(application).getPreferencesStore().registerOnChangedListener(this);
        JsonConfig.ProjectConfiguration projectConfig = configuration.getProjectConfig();
        boolean enabled = (projectConfig == null || (inAppConfig = projectConfig.getInAppConfig()) == null) ? false : inAppConfig.getEnabled();
        this.d = enabled;
        logger.i(enabled ? "Contentsquare in-app features configuration is enabled" : "Contentsquare in-app features configuration is disabled");
        ClientModeLifecycleMonitor clientModeLifecycleMonitor = new ClientModeLifecycleMonitor();
        lifecycleOwner.getLifecycle().addObserver(clientModeLifecycleMonitor);
        application.registerActivityLifecycleCallbacks(clientModeLifecycleMonitor);
        Activity activity = liveActivityProvider.a.get();
        if (activity != null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            a();
        }
    }

    public final void a() {
        if (!this.d || this.e) {
            return;
        }
        this.e = true;
        C0724k3 c0724k3 = this.a;
        int i = c0724k3.f;
        if (i != 0) {
            if (i == 1) {
                c0724k3.a();
                return;
            }
            return;
        }
        c0724k3.f = 2;
        if (c0724k3.c.getBoolean(PreferencesKey.CLIENT_MODE_ACTIVATION_STATE, false)) {
            if (!c0724k3.c.getBoolean(PreferencesKey.CLIENT_MODE_TUTORIAL, true)) {
                c0724k3.a();
                return;
            }
            int i2 = ClientModeTutorialActivity.d;
            Application source = c0724k3.a;
            Intrinsics.checkNotNullParameter(source, "source");
            Intent intent = new Intent(source, (Class<?>) ClientModeTutorialActivity.class);
            intent.addFlags(268435456);
            source.startActivity(intent);
        }
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Logger logger;
        String str;
        JsonConfig.InAppConfig inAppConfig;
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == PreferencesKey.RAW_CONFIGURATION_AS_JSON) {
            JsonConfig.ProjectConfiguration projectConfig = this.c.getProjectConfig();
            boolean enabled = (projectConfig == null || (inAppConfig = projectConfig.getInAppConfig()) == null) ? false : inAppConfig.getEnabled();
            this.d = enabled;
            if (enabled) {
                logger = this.b;
                str = "Contentsquare in-app features configuration is enabled";
            } else {
                logger = this.b;
                str = "Contentsquare in-app features configuration is disabled";
            }
            logger.i(str);
            a();
        }
    }
}
