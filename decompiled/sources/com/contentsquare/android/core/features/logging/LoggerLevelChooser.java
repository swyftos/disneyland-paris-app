package com.contentsquare.android.core.features.logging;

import android.content.Context;
import com.contentsquare.android.core.features.logging.LogPrinter;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LoggerLevelChooser;", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore$PreferencesStoreListener;", "loggerNonStatic", "Lcom/contentsquare/android/core/features/logging/LoggerLevelChooser$LoggerNonStatic;", "preferencesStore", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore;", "context", "Landroid/content/Context;", "(Lcom/contentsquare/android/core/features/logging/LoggerLevelChooser$LoggerNonStatic;Lcom/contentsquare/android/core/features/preferences/PreferencesStore;Landroid/content/Context;)V", "debugLogWriterFolder", "", "kotlin.jvm.PlatformType", "onPreferenceChanged", "", "key", "Lcom/contentsquare/android/core/features/preferences/PreferencesKey;", "resolveLogLevel", "LoggerNonStatic", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoggerLevelChooser implements PreferencesStore.PreferencesStoreListener {
    private final String debugLogWriterFolder;

    @NotNull
    private final LoggerNonStatic loggerNonStatic;

    @NotNull
    private final PreferencesStore preferencesStore;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LoggerLevelChooser$LoggerNonStatic;", "", "()V", "setLogLevel", "", "logLevel", "Lcom/contentsquare/android/core/features/logging/LogPrinter$LogLevel;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LoggerNonStatic {
        public final void setLogLevel(LogPrinter.LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            Logger.INSTANCE.setLogLevel$core_release(logLevel);
        }
    }

    public LoggerLevelChooser(LoggerNonStatic loggerNonStatic, PreferencesStore preferencesStore, Context context) {
        Intrinsics.checkNotNullParameter(loggerNonStatic, "loggerNonStatic");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(context, "context");
        this.loggerNonStatic = loggerNonStatic;
        this.preferencesStore = preferencesStore;
        this.debugLogWriterFolder = context.getFilesDir().getAbsolutePath();
        preferencesStore.registerOnChangedListener(this);
        resolveLogLevel();
    }

    private final void resolveLogLevel() {
        LogPrinter.LogLevel logLevel = this.preferencesStore.getBoolean(PreferencesKey.VERBOSE_LOG, false) ? LogPrinter.LogLevel.DEBUG : this.preferencesStore.getBoolean(PreferencesKey.CLIENT_MODE_ACTIVATION_STATE, false) ? LogPrinter.LogLevel.CS_IN_APP : LogPrinter.LogLevel.PUBLIC;
        this.loggerNonStatic.setLogLevel(logLevel);
        if (logLevel == LogPrinter.LogLevel.PUBLIC) {
            Logger.INSTANCE.setDebugLogWriter(null);
            return;
        }
        Logger.Companion companion = Logger.INSTANCE;
        String debugLogWriterFolder = this.debugLogWriterFolder;
        Intrinsics.checkNotNullExpressionValue(debugLogWriterFolder, "debugLogWriterFolder");
        companion.setDebugLogWriter(new DebugLogWriter(null, null, null, 0, 0, debugLogWriterFolder, 31, null));
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public void onPreferenceChanged(PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key == PreferencesKey.VERBOSE_LOG || key == PreferencesKey.CLIENT_MODE_ACTIVATION_STATE) {
            resolveLogLevel();
        }
    }
}
