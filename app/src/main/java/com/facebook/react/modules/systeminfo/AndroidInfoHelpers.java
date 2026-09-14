package com.facebook.react.modules.systeminfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.facebook.common.logging.FLog;
import com.facebook.react.C3142R;
import com.urbanairship.deferred.DeferredApiClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0016\u001a\u00020\u0005H\u0007J \u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0007J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1836d2 = {"Lcom/facebook/react/modules/systeminfo/AndroidInfoHelpers;", "", "<init>", "()V", "EMULATOR_LOCALHOST", "", "GENYMOTION_LOCALHOST", "DEVICE_LOCALHOST", "METRO_HOST_PROP_NAME", "TAG", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "metroHostPropValue", "isRunningOnGenymotion", "", "isRunningOnStockEmulator", "getServerHost", "port", "", "context", "Landroid/content/Context;", "getAdbReverseTcpCommand", "getFriendlyDeviceName", "getInspectorHostMetadata", "", "applicationContext", "getReactNativeVersionString", "getDevServerPort", "getServerIpAddress", "getMetroHostPropValue", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAndroidInfoHelpers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidInfoHelpers.kt\ncom/facebook/react/modules/systeminfo/AndroidInfoHelpers\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n1#2:128\n*E\n"})
public final class AndroidInfoHelpers {

    @NotNull
    public static final String DEVICE_LOCALHOST = "localhost";

    @NotNull
    public static final String EMULATOR_LOCALHOST = "10.0.2.2";

    @NotNull
    public static final String GENYMOTION_LOCALHOST = "10.0.3.2";

    @NotNull
    public static final String METRO_HOST_PROP_NAME = "metro.host";

    @Nullable
    private static String metroHostPropValue;

    @NotNull
    public static final AndroidInfoHelpers INSTANCE = new AndroidInfoHelpers();
    private static final String TAG = AndroidInfoHelpers.class.getSimpleName();

    private AndroidInfoHelpers() {
    }

    private final boolean isRunningOnGenymotion() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        return StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "vbox", false, 2, (Object) null);
    }

    private final boolean isRunningOnStockEmulator() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (!StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "generic", false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
            if (!StringsKt.startsWith$default(FINGERPRINT, "google/sdk_gphone", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    @NotNull
    public static final String getServerHost(int port) {
        return INSTANCE.getServerIpAddress(port);
    }

    @JvmStatic
    @NotNull
    public static final String getServerHost(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AndroidInfoHelpers androidInfoHelpers = INSTANCE;
        return androidInfoHelpers.getServerIpAddress(androidInfoHelpers.getDevServerPort(context));
    }

    @JvmStatic
    @NotNull
    public static final String getAdbReverseTcpCommand(int port) {
        return "adb reverse tcp:" + port + " tcp:" + port;
    }

    @JvmStatic
    @NotNull
    public static final String getAdbReverseTcpCommand(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getAdbReverseTcpCommand(INSTANCE.getDevServerPort(context));
    }

    @JvmStatic
    @NotNull
    public static final String getFriendlyDeviceName() {
        if (INSTANCE.isRunningOnGenymotion()) {
            String str = Build.MODEL;
            Intrinsics.checkNotNull(str);
            return str;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> getInspectorHostMetadata(@Nullable Context applicationContext) {
        String packageName;
        String string;
        if (applicationContext != null) {
            ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
            int i = applicationInfo.labelRes;
            packageName = applicationContext.getPackageName();
            if (i == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = applicationContext.getString(i);
                Intrinsics.checkNotNull(string);
            }
        } else {
            packageName = null;
            string = null;
        }
        return MapsKt.mapOf(TuplesKt.m1842to("appDisplayName", string), TuplesKt.m1842to("appIdentifier", packageName), TuplesKt.m1842to(DeferredApiClient.KEY_PLATFORM, "android"), TuplesKt.m1842to("deviceName", Build.MODEL), TuplesKt.m1842to("reactNativeVersion", INSTANCE.getReactNativeVersionString()));
    }

    /* JADX WARN: Code duplicated, block: B:6:0x002f  */
    private final String getReactNativeVersionString() {
        String str;
        Map<String, Object> map = ReactNativeVersion.VERSION;
        Object obj = map.get("major");
        Object obj2 = map.get("minor");
        Object obj3 = map.get("patch");
        Object obj4 = map.get("prerelease");
        if (obj4 != null) {
            str = "-" + obj4;
            if (str == null) {
                str = "";
            }
        } else {
            str = "";
        }
        return obj + InstructionFileId.DOT + obj2 + InstructionFileId.DOT + obj3 + str;
    }

    private final int getDevServerPort(Context context) {
        return context.getResources().getInteger(C3142R.integer.react_native_dev_server_port);
    }

    private final String getServerIpAddress(int port) {
        String metroHostPropValue2;
        if (getMetroHostPropValue().length() > 0) {
            metroHostPropValue2 = getMetroHostPropValue();
        } else if (isRunningOnGenymotion()) {
            metroHostPropValue2 = GENYMOTION_LOCALHOST;
        } else {
            metroHostPropValue2 = isRunningOnStockEmulator() ? EMULATOR_LOCALHOST : DEVICE_LOCALHOST;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%s:%d", Arrays.copyOf(new Object[]{metroHostPropValue2, Integer.valueOf(port)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    private final synchronized String getMetroHostPropValue() {
        BufferedReader bufferedReader;
        Throwable th;
        Process processExec;
        Exception e;
        String str;
        String str2 = metroHostPropValue;
        if (str2 != null) {
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        try {
            try {
                processExec = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", METRO_HOST_PROP_NAME});
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream(), Charset.forName("UTF-8")));
                    String str3 = "";
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            str3 = line;
                        } catch (Exception e2) {
                            e = e2;
                            FLog.m1332w(TAG, "Failed to query for metro.host prop:", e);
                            metroHostPropValue = "";
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (processExec != null) {
                            }
                            str = metroHostPropValue;
                            if (str == null) {
                                str = "";
                            }
                            return str;
                        }
                    }
                    metroHostPropValue = str3;
                    bufferedReader.close();
                } catch (Exception e3) {
                    bufferedReader = null;
                    e = e3;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                bufferedReader = null;
                e = e4;
                processExec = null;
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
                processExec = null;
            }
            processExec.destroy();
            str = metroHostPropValue;
            if (str == null) {
                str = "";
            }
            return str;
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
