package com.contentsquare.android.core.features.config;

import android.app.Application;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.MimeTypes;
import com.contentsquare.android.core.features.config.network.ConfigDownloaderFactory;
import com.contentsquare.android.core.features.config.network.ConfigRetrieverTask;
import com.contentsquare.android.core.features.config.network.ConfigurationDownloader;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u000e\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015J\b\u0010\u001b\u001a\u00020\u0018H\u0002R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/contentsquare/android/core/features/config/ConfigurationRefresher;", "", "appLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "configDownloaderFactory", "Lcom/contentsquare/android/core/features/config/network/ConfigDownloaderFactory;", "userId", "", "configuration", "Lcom/contentsquare/android/core/features/config/Configuration;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/app/Application;Lcom/contentsquare/android/core/features/config/network/ConfigDownloaderFactory;Ljava/lang/String;Lcom/contentsquare/android/core/features/config/Configuration;)V", "appLifeCycleObserver", "com/contentsquare/android/core/features/config/ConfigurationRefresher$appLifeCycleObserver$1", "Lcom/contentsquare/android/core/features/config/ConfigurationRefresher$appLifeCycleObserver$1;", "isFirstDownloadTry", "", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "onFirstConfigLoaded", "Lcom/contentsquare/android/core/features/config/ConfigRetrieverCallback;", "processConfigCallback", "Lkotlin/Function0;", "", "bindToAppLifeCycle", "configRetrieverCallback", "startConfigurationDownload", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigurationRefresher {

    @NotNull
    private final ConfigurationRefresher$appLifeCycleObserver$1 appLifeCycleObserver;

    @NotNull
    private final LifecycleOwner appLifecycleOwner;

    @NotNull
    private final Application application;

    @NotNull
    private final ConfigDownloaderFactory configDownloaderFactory;

    @NotNull
    private final Configuration configuration;
    private boolean isFirstDownloadTry;

    @NotNull
    private final Logger logger;

    @Nullable
    private ConfigRetrieverCallback onFirstConfigLoaded;

    @NotNull
    private final Function0<Unit> processConfigCallback;

    @Nullable
    private final String userId;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.contentsquare.android.core.features.config.ConfigurationRefresher$appLifeCycleObserver$1] */
    public ConfigurationRefresher(LifecycleOwner appLifecycleOwner, Application application, ConfigDownloaderFactory configDownloaderFactory, String str, Configuration configuration) {
        Intrinsics.checkNotNullParameter(appLifecycleOwner, "appLifecycleOwner");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(configDownloaderFactory, "configDownloaderFactory");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.appLifecycleOwner = appLifecycleOwner;
        this.application = application;
        this.configDownloaderFactory = configDownloaderFactory;
        this.userId = str;
        this.configuration = configuration;
        this.isFirstDownloadTry = true;
        this.processConfigCallback = new Function0<Unit>() { // from class: com.contentsquare.android.core.features.config.ConfigurationRefresher$processConfigCallback$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (this.this$0.configuration.getProjectConfig() != null) {
                    ConfigurationRefresher configurationRefresher = this.this$0;
                    ConfigRetrieverCallback configRetrieverCallback = configurationRefresher.onFirstConfigLoaded;
                    if (configRetrieverCallback != null) {
                        configRetrieverCallback.onConfigRetrieved();
                    }
                    configurationRefresher.onFirstConfigLoaded = null;
                }
            }
        };
        this.appLifeCycleObserver = new DefaultLifecycleObserver() { // from class: com.contentsquare.android.core.features.config.ConfigurationRefresher$appLifeCycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onCreate(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                this.this$0.processConfigCallback.invoke();
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onResume(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                this.this$0.startConfigurationDownload();
            }
        };
        this.logger = new Logger("ConfigurationRefresher");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConfigurationDownload() {
        if (this.configuration.isFeatureFlagEnabled(JsonConfigFeatureFlagNames.FOREGROUND_REFRESH_CONFIG)) {
            this.isFirstDownloadTry = false;
            this.logger.d("Use the new ConfigurationDownloader to download the CS configuration.");
            ConfigurationDownloader configurationDownloaderProduceConfigDownloader = this.configDownloaderFactory.produceConfigDownloader(this.configuration);
            String str = this.userId;
            String packageName = this.application.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "application.packageName");
            configurationDownloaderProduceConfigDownloader.execute(str, packageName, this.processConfigCallback);
            return;
        }
        if (this.isFirstDownloadTry) {
            this.isFirstDownloadTry = false;
            this.logger.d("Use the deprecated ConfigRetrieverTask to download the CS configuration.");
            ConfigDownloaderFactory configDownloaderFactory = this.configDownloaderFactory;
            String str2 = this.userId;
            Configuration configuration = this.configuration;
            final Function0<Unit> function0 = this.processConfigCallback;
            configDownloaderFactory.produceConfigRetrieverTask(str2, configuration, new ConfigRetrieverTask.ConfigProviderCallback() { // from class: com.contentsquare.android.core.features.config.ConfigurationRefresher$$ExternalSyntheticLambda0
                @Override // com.contentsquare.android.core.features.config.network.ConfigRetrieverTask.ConfigProviderCallback
                public final void processConfig() {
                    ConfigurationRefresher.startConfigurationDownload$lambda$0(function0);
                }
            }).execute(this.application.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startConfigurationDownload$lambda$0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final void bindToAppLifeCycle(ConfigRetrieverCallback configRetrieverCallback) {
        Intrinsics.checkNotNullParameter(configRetrieverCallback, "configRetrieverCallback");
        this.onFirstConfigLoaded = configRetrieverCallback;
        this.appLifecycleOwner.getLifecycle().addObserver(this.appLifeCycleObserver);
    }
}
