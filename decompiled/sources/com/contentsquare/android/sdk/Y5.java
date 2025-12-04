package com.contentsquare.android.sdk;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import androidx.core.net.MailTo;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.config.model.QualityLevel;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.BuildInformation;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSettingsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsViewModel.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SettingsViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,555:1\n1855#2,2:556\n13579#3,2:558\n*S KotlinDebug\n*F\n+ 1 SettingsViewModel.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SettingsViewModel\n*L\n470#1:556,2\n481#1:558,2\n*E\n"})
/* loaded from: classes2.dex */
public final class Y5 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final DeviceInfo b;

    @NotNull
    public final BuildInformation c;

    @NotNull
    public final Configuration d;

    @Nullable
    public final C5 e;

    @NotNull
    public final K5 f;

    @NotNull
    public final F5 g;

    @NotNull
    public final CoroutineScope h;

    @NotNull
    public final List<String> i;

    public Y5(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.i = CollectionsKt.sorted(JsonConfigFeatureFlagNames.INSTANCE.getFeatureFlags());
        CoreModule.Companion companion = CoreModule.INSTANCE;
        PreferencesStore preferencesStore = companion.safeInstance(application).getPreferencesStore();
        this.a = preferencesStore;
        this.d = companion.safeInstance(application).getConfiguration();
        this.b = new DeviceInfo(application, new DisplayMetrics(), null, null, null, null, 60, null);
        this.c = new BuildInformation(application);
        this.e = C5.k;
        this.g = F5.c.getValue();
        this.f = new K5(application, preferencesStore);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.h = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewSingleThreadExecutor));
        new Logger("SettingsViewModel");
    }

    public static final Intent a(Y5 y5, Context context, File file) {
        Configuration configuration;
        JsonConfig.ProjectConfiguration projectConfig;
        Intent intent = new Intent("android.intent.action.SEND");
        Intent intent2 = new Intent("android.intent.action.SENDTO");
        intent2.setData(Uri.parse(MailTo.MAILTO_SCHEME));
        intent.setSelector(intent2);
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        Integer numValueOf = (companion == null || (configuration = companion.getConfiguration()) == null || (projectConfig = configuration.getProjectConfig()) == null) ? null : Integer.valueOf(projectConfig.getCsProjectId());
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"mobile-devices@contentsquare.com"});
        intent.putExtra("android.intent.extra.SUBJECT", "Debug Information for " + y5.c.getApplicationName() + ": " + y5.c.getApplicationId() + " - pid " + numValueOf);
        intent.putExtra("android.intent.extra.TEXT", StringsKt.trimMargin$default("Thank you to share logs with the Contentsquare support team, this will help us to investigate your issue.\n                    |\n                    |Details:\n                    |App name: " + y5.c.getApplicationName() + "\n                    |App id: " + y5.c.getApplicationId() + "\n                    |Cs project ID: " + numValueOf + "\n                    |App version name: " + y5.c.getApplicationVersion() + "\n                    |App version code: " + y5.c.getApplicationVersionCode() + "\n                    |App min sdk: " + y5.c.getMinSdkVersion() + "\n                    |App compile sdk: " + y5.c.getCompileSdkVersion() + "\n                    |App target sdk: " + y5.c.getTargetSdkVersion() + "\n                    |App Kotlin version: " + y5.c.getAppKotlinVersion() + "\n                    |Sdk version name: " + y5.c.getSdkVersion() + "\n                    |Sdk version code: " + y5.c.getSdkBuild() + "\n                ", null, 1, null));
        intent.addFlags(1);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".provider");
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, sb.toString(), file));
        return intent;
    }

    public static void a(File file, String str, ZipOutputStream zipOutputStream) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                String zipEntryName = str.length() == 0 ? file2.getName() : str + '/' + file2.getName();
                if (file2.isDirectory()) {
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntryName + '/'));
                    zipOutputStream.closeEntry();
                    Intrinsics.checkNotNullExpressionValue(file2, "file");
                    Intrinsics.checkNotNullExpressionValue(zipEntryName, "zipEntryName");
                    a(file2, zipEntryName, zipOutputStream);
                } else {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(zipEntryName));
                        byte[] bytes = ByteStreamsKt.readBytes(fileInputStream);
                        zipOutputStream.write(bytes, 0, bytes.length);
                        zipOutputStream.closeEntry();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileInputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileInputStream, th);
                            throw th2;
                        }
                    }
                }
            }
        }
    }

    public final String a() {
        JsonConfig.ProjectConfiguration projectConfig = this.d.getProjectConfig();
        if (projectConfig == null) {
            return QualityLevel.INSTANCE.getDEFAULT_RECORDING_QUALITY();
        }
        JsonConfig.SessionReplay sessionReplay = projectConfig.getSessionReplay();
        return this.b.getActiveConnectionType() == ConnectionType.WIFI ? sessionReplay.getRecordingQualityWifi() : sessionReplay.getRecordingQualityCellular();
    }
}
