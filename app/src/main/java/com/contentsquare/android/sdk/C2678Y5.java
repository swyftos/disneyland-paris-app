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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p163io.ByteStreamsKt;
import kotlin.p163io.CloseableKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Y5 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSettingsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsViewModel.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SettingsViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,555:1\n1855#2,2:556\n13579#3,2:558\n*S KotlinDebug\n*F\n+ 1 SettingsViewModel.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/SettingsViewModel\n*L\n470#1:556,2\n481#1:558,2\n*E\n"})
public final class C2678Y5 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f2301a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final DeviceInfo f2302b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final BuildInformation f2303c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Configuration f2304d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final C2462C5 f2305e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final C2542K5 f2306f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final C2492F5 f2307g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final CoroutineScope f2308h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final List<String> f2309i;

    public C2678Y5(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f2309i = CollectionsKt.sorted(JsonConfigFeatureFlagNames.INSTANCE.getFeatureFlags());
        CoreModule.Companion companion = CoreModule.INSTANCE;
        PreferencesStore preferencesStore = companion.safeInstance(application).getPreferencesStore();
        this.f2301a = preferencesStore;
        this.f2304d = companion.safeInstance(application).getConfiguration();
        this.f2302b = new DeviceInfo(application, new DisplayMetrics(), null, null, null, null, 60, null);
        this.f2303c = new BuildInformation(application);
        this.f2305e = C2462C5.f1468k;
        this.f2307g = C2492F5.f1615c.getValue();
        this.f2306f = new C2542K5(application, preferencesStore);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor()");
        this.f2308h = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(executorServiceNewSingleThreadExecutor));
        new Logger("SettingsViewModel");
    }

    /* JADX INFO: renamed from: a */
    public static final Intent m1072a(C2678Y5 c2678y5, Context context, File file) {
        Configuration configuration;
        JsonConfig.ProjectConfiguration projectConfig;
        Intent intent = new Intent("android.intent.action.SEND");
        Intent intent2 = new Intent("android.intent.action.SENDTO");
        intent2.setData(Uri.parse(MailTo.MAILTO_SCHEME));
        intent.setSelector(intent2);
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        Integer numValueOf = (companion == null || (configuration = companion.getConfiguration()) == null || (projectConfig = configuration.getProjectConfig()) == null) ? null : Integer.valueOf(projectConfig.getCsProjectId());
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"mobile-devices@contentsquare.com"});
        intent.putExtra("android.intent.extra.SUBJECT", "Debug Information for " + c2678y5.f2303c.getApplicationName() + ": " + c2678y5.f2303c.getApplicationId() + " - pid " + numValueOf);
        intent.putExtra("android.intent.extra.TEXT", StringsKt.trimMargin$default("Thank you to share logs with the Contentsquare support team, this will help us to investigate your issue.\n                    |\n                    |Details:\n                    |App name: " + c2678y5.f2303c.getApplicationName() + "\n                    |App id: " + c2678y5.f2303c.getApplicationId() + "\n                    |Cs project ID: " + numValueOf + "\n                    |App version name: " + c2678y5.f2303c.getApplicationVersion() + "\n                    |App version code: " + c2678y5.f2303c.getApplicationVersionCode() + "\n                    |App min sdk: " + c2678y5.f2303c.getMinSdkVersion() + "\n                    |App compile sdk: " + c2678y5.f2303c.getCompileSdkVersion() + "\n                    |App target sdk: " + c2678y5.f2303c.getTargetSdkVersion() + "\n                    |App Kotlin version: " + c2678y5.f2303c.getAppKotlinVersion() + "\n                    |Sdk version name: " + c2678y5.f2303c.getSdkVersion() + "\n                    |Sdk version code: " + c2678y5.f2303c.getSdkBuild() + "\n                ", null, 1, null));
        intent.addFlags(1);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".provider");
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, sb.toString(), file));
        return intent;
    }

    /* JADX INFO: renamed from: a */
    public static void m1073a(File file, String str, ZipOutputStream zipOutputStream) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                String zipEntryName = str.length() == 0 ? file2.getName() : str + '/' + file2.getName();
                if (file2.isDirectory()) {
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntryName + '/'));
                    zipOutputStream.closeEntry();
                    Intrinsics.checkNotNullExpressionValue(file2, "file");
                    Intrinsics.checkNotNullExpressionValue(zipEntryName, "zipEntryName");
                    m1073a(file2, zipEntryName, zipOutputStream);
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

    /* JADX INFO: renamed from: a */
    public final String m1074a() {
        JsonConfig.ProjectConfiguration projectConfig = this.f2304d.getProjectConfig();
        if (projectConfig == null) {
            return QualityLevel.INSTANCE.getDEFAULT_RECORDING_QUALITY();
        }
        JsonConfig.SessionReplay sessionReplay = projectConfig.getSessionReplay();
        return this.f2302b.getActiveConnectionType() == ConnectionType.WIFI ? sessionReplay.getRecordingQualityWifi() : sessionReplay.getRecordingQualityCellular();
    }
}
