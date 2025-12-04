package com.contentsquare.android.core.system;

import android.app.Application;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.contentsquare.android.core.R;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.BuildConfigInstantiable;
import com.contentsquare.android.core.utils.BuildInformation;
import com.contentsquare.android.core.utils.BuildInstantiable;
import com.facebook.fbreact.specs.NativeDeviceInfoSpec;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 I2\u00020\u0001:\u0003IJKB?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020;2\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010=\u001a\u00020\u001bH\u0002J\u000e\u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0016J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ\n\u0010D\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010E\u001a\u00020AH\u0002J\n\u0010F\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010G\u001a\u00020\u001bH\u0002J\u0006\u0010H\u001a\u00020;R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0011\u0010\"\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u001e\u0010%\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b1\u0010\u001dR\u0011\u00102\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b7\u0010\u001dR\u0011\u00108\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b9\u0010\u001d¨\u0006L"}, d2 = {"Lcom/contentsquare/android/core/system/DeviceInfo;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "metrics", "Landroid/util/DisplayMetrics;", "buildInformation", "Lcom/contentsquare/android/core/utils/BuildInformation;", "networkInfoProvider", "Lcom/contentsquare/android/core/system/NetworkInfoProvider;", "buildConfigInstantiable", "Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;", "buildInstantiable", "Lcom/contentsquare/android/core/utils/BuildInstantiable;", "(Landroid/app/Application;Landroid/util/DisplayMetrics;Lcom/contentsquare/android/core/utils/BuildInformation;Lcom/contentsquare/android/core/system/NetworkInfoProvider;Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;Lcom/contentsquare/android/core/utils/BuildInstantiable;)V", "activeConnectionType", "Lcom/contentsquare/android/core/system/ConnectionType;", "getActiveConnectionType", "()Lcom/contentsquare/android/core/system/ConnectionType;", "getBuildInformation", "()Lcom/contentsquare/android/core/utils/BuildInformation;", "<set-?>", "", "deviceHeight", "getDeviceHeight", "()I", "deviceManufacturer", "", "getDeviceManufacturer", "()Ljava/lang/String;", "deviceModel", "getDeviceModel", "deviceOs", "getDeviceOs", "deviceOsApi", "getDeviceOsApi", "", "deviceScale", "getDeviceScale", "()F", "deviceType", "Lcom/contentsquare/android/core/system/DeviceInfo$DeviceType;", "getDeviceType", "()Lcom/contentsquare/android/core/system/DeviceInfo$DeviceType;", "deviceWidth", "getDeviceWidth", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "networkOperator", "getNetworkOperator", "screenOrientation", "Lcom/contentsquare/android/core/system/DeviceInfo$Orientation;", "getScreenOrientation", "()Lcom/contentsquare/android/core/system/DeviceInfo$Orientation;", "userLanguage", "getUserLanguage", "userTimezone", "getUserTimezone", "deviceResolutionJson", "Lorg/json/JSONObject;", "getVersionOrigin", "parseOsReleaseVersion", "pixelsToDp", "pixels", "registerOnNetworkStateChangedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/contentsquare/android/core/system/OnNetworkStateChangeListener;", "resolveDeviceModel", "resolveDeviceResolution", "resolveManufacturer", "resolveNetworkOperatorName", "typeOrigin", "Companion", "DeviceType", ExifInterface.TAG_ORIENTATION, "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeviceInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceInfo.kt\ncom/contentsquare/android/core/system/DeviceInfo\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,360:1\n107#2:361\n79#2,22:362\n1#3:384\n*S KotlinDebug\n*F\n+ 1 DeviceInfo.kt\ncom/contentsquare/android/core/system/DeviceInfo\n*L\n220#1:361\n220#1:362,22\n*E\n"})
/* loaded from: classes2.dex */
public final class DeviceInfo {

    @NotNull
    private static final String ANDROID_SDK_DEBUG = "debug";

    @NotNull
    private static final String ANDROID_SDK_IDENTIFIER = "sdk-android";

    @NotNull
    private static final String ANDROID_SDK_RELEASE = "release";

    @NotNull
    public static final String BATCH_APP_NAME = "an";

    @NotNull
    public static final String BATCH_SDK_FLAVOR = "sf";

    @NotNull
    public static final String BATCH_SDK_TYPE = "st";

    @NotNull
    public static final String HEIGHT = "h";

    @NotNull
    public static final String LABEL_APP_BUILD_NUMBER = "ab";

    @NotNull
    public static final String LABEL_APP_VERSION = "av";

    @NotNull
    public static final String LABEL_SDK_BUILD = "sb";

    @NotNull
    public static final String LABEL_SDK_VERSION = "sv";
    public static final int LANDSCAPE_INT = 1;
    public static final int PHONE_INT = 4;
    public static final int PORTRAIT_INT = 0;

    @NotNull
    public static final String SCALE = "d";
    public static final int TABLET_INT = 5;

    @NotNull
    public static final String WIDTH = "w";

    @NotNull
    private final Application application;

    @NotNull
    private final BuildConfigInstantiable buildConfigInstantiable;

    @NotNull
    private final BuildInformation buildInformation;

    @NotNull
    private final BuildInstantiable buildInstantiable;
    private int deviceHeight;
    private float deviceScale;
    private int deviceWidth;

    @NotNull
    private final Logger logger;

    @NotNull
    private final DisplayMetrics metrics;

    @NotNull
    private final NetworkInfoProvider networkInfoProvider;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/core/system/DeviceInfo$DeviceType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PHONE", "TABLET", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum DeviceType {
        PHONE(4),
        TABLET(5);

        private final int value;

        DeviceType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/core/system/DeviceInfo$Orientation;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PORTRAIT", "LANDSCAPE", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Orientation {
        PORTRAIT(0),
        LANDSCAPE(1);

        private final int value;

        Orientation(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DeviceInfo(Application application, DisplayMetrics metrics) {
        this(application, metrics, null, null, null, null, 60, null);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
    }

    private final String parseOsReleaseVersion() {
        Object obj = null;
        List list = SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("^[0-9]*|\\.[0-9]*"), new Regex("^\\.").replaceFirst(this.buildInstantiable.getOsReleaseVersion(), "0."), 0, 2, null), new Function1<MatchResult, String>() { // from class: com.contentsquare.android.core.system.DeviceInfo$parseOsReleaseVersion$matches$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(MatchResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt.replace$default(it.getValue(), InstructionFileId.DOT, "", false, 4, (Object) null);
            }
        }));
        Object orNull = CollectionsKt.getOrNull(list, 0);
        String str = (String) orNull;
        if (str == null || str.length() == 0) {
            orNull = null;
        }
        String str2 = (String) orNull;
        if (str2 == null) {
            str2 = "0";
        }
        Object orNull2 = CollectionsKt.getOrNull(list, 1);
        String str3 = (String) orNull2;
        if (str3 == null || str3.length() == 0) {
            orNull2 = null;
        }
        String str4 = (String) orNull2;
        if (str4 == null) {
            str4 = "0";
        }
        Object orNull3 = CollectionsKt.getOrNull(list, 2);
        String str5 = (String) orNull3;
        if (str5 != null && str5.length() != 0) {
            obj = orNull3;
        }
        String str6 = (String) obj;
        return str2 + '.' + str4 + '.' + (str6 != null ? str6 : "0");
    }

    private final String resolveDeviceModel() {
        StringBuilder sb;
        String strValueOf;
        String model = this.buildInstantiable.getModel();
        String manufacturer = this.buildInstantiable.getManufacturer();
        if (model == null || model.length() == 0 || manufacturer == null || manufacturer.length() == 0) {
            return null;
        }
        Locale locale = Locale.ROOT;
        String lowerCase = model.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String lowerCase2 = manufacturer.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (StringsKt.startsWith$default(lowerCase, lowerCase2, false, 2, (Object) null) && model.length() > manufacturer.length()) {
            String strSubstring = model.substring(manufacturer.length() + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            int length = strSubstring.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) strSubstring.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            model = strSubstring.subSequence(i, length + 1).toString();
            if (model.length() <= 0) {
                return model;
            }
            sb = new StringBuilder();
            strValueOf = String.valueOf(model.charAt(0));
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            locale = Locale.ROOT;
        } else {
            if (model.length() <= 0) {
                return model;
            }
            sb = new StringBuilder();
            strValueOf = String.valueOf(model.charAt(0));
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = strValueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        sb.append((Object) upperCase);
        String strSubstring2 = model.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    private final void resolveDeviceResolution() {
        DisplayMetrics displayMetrics;
        float density;
        WindowManager windowManager = (WindowManager) this.application.getSystemService("window");
        if (windowManager != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "windowManager.currentWindowMetrics");
                this.deviceHeight = currentWindowMetrics.getBounds().height();
                this.deviceWidth = currentWindowMetrics.getBounds().width();
                if (i >= 34) {
                    density = currentWindowMetrics.getDensity();
                    this.deviceScale = density;
                } else {
                    displayMetrics = this.application.getResources().getDisplayMetrics();
                }
            } else {
                windowManager.getDefaultDisplay().getRealMetrics(this.metrics);
                displayMetrics = this.metrics;
                this.deviceHeight = displayMetrics.heightPixels;
                this.deviceWidth = displayMetrics.widthPixels;
            }
            density = displayMetrics.density;
            this.deviceScale = density;
        }
        this.logger.d("DeviceWidth: " + this.deviceHeight + "  DeviceHeight: " + this.deviceWidth + "  DeviceScale: " + this.deviceScale);
    }

    private final String resolveManufacturer() {
        String manufacturer = this.buildInstantiable.getManufacturer();
        if (manufacturer == null || manufacturer.length() == 0) {
            return null;
        }
        if (manufacturer.length() <= 0) {
            return manufacturer;
        }
        StringBuilder sb = new StringBuilder();
        String strValueOf = String.valueOf(manufacturer.charAt(0));
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        sb.append((Object) upperCase);
        String strSubstring = manufacturer.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        return sb.toString();
    }

    private final String resolveNetworkOperatorName() {
        TelephonyManager telephonyManager = (TelephonyManager) this.application.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : null;
        return networkOperatorName == null ? "" : networkOperatorName;
    }

    @NotNull
    public final JSONObject deviceResolutionJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(WIDTH, pixelsToDp(this.deviceWidth));
            jSONObject.put("h", pixelsToDp(this.deviceHeight));
            jSONObject.put("d", this.deviceScale);
        } catch (JSONException e) {
            this.logger.e(e, "Failed to process device resolution for bundle.");
        }
        return jSONObject;
    }

    @NotNull
    public final ConnectionType getActiveConnectionType() {
        return this.networkInfoProvider.getConnectionType();
    }

    @NotNull
    public final BuildInformation getBuildInformation() {
        return this.buildInformation;
    }

    public final int getDeviceHeight() {
        return this.deviceHeight;
    }

    @Nullable
    public final String getDeviceManufacturer() {
        return resolveManufacturer();
    }

    @Nullable
    public final String getDeviceModel() {
        return resolveDeviceModel();
    }

    @NotNull
    public final String getDeviceOs() {
        return parseOsReleaseVersion();
    }

    public final int getDeviceOsApi() {
        return this.buildInstantiable.getAndroidSdkVersion();
    }

    public final float getDeviceScale() {
        return this.deviceScale;
    }

    @NotNull
    public final DeviceType getDeviceType() {
        return this.application.getResources().getBoolean(R.bool.contentsquare_isTablet) ? DeviceType.TABLET : DeviceType.PHONE;
    }

    public final int getDeviceWidth() {
        return this.deviceWidth;
    }

    @NotNull
    public final String getNetworkOperator() {
        return resolveNetworkOperatorName();
    }

    @NotNull
    public final Orientation getScreenOrientation() {
        return this.application.getResources().getConfiguration().orientation == 2 ? Orientation.LANDSCAPE : Orientation.PORTRAIT;
    }

    @NotNull
    public final String getUserLanguage() {
        String string = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(string, "getDefault().toString()");
        return string;
    }

    @NotNull
    public final String getUserTimezone() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getDefault().id");
        return id;
    }

    @NotNull
    public final JSONObject getVersionOrigin(BuildInformation buildInformation) throws JSONException {
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LABEL_SDK_VERSION, buildInformation.getSdkVersion());
            jSONObject.put(LABEL_SDK_BUILD, buildInformation.getSdkBuild());
            jSONObject.put("av", buildInformation.getApplicationVersion());
            jSONObject.put(LABEL_APP_BUILD_NUMBER, buildInformation.getApplicationVersionCode());
        } catch (JSONException e) {
            this.logger.e(e, "Failed to get json version Origin for DeviceInfo.");
        }
        return jSONObject;
    }

    public final int pixelsToDp(int pixels) {
        return (int) Math.rint(pixels / this.deviceScale);
    }

    public final void registerOnNetworkStateChangedListener(OnNetworkStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.networkInfoProvider.registerOnNetworkStateChangedListener(listener);
    }

    @NotNull
    public final JSONObject typeOrigin() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sf", this.buildConfigInstantiable.isDebug() ? ANDROID_SDK_DEBUG : "release");
            jSONObject.put(BATCH_APP_NAME, this.buildInformation.getApplicationName());
            jSONObject.put("st", ANDROID_SDK_IDENTIFIER);
        } catch (JSONException e) {
            this.logger.e(e, "Failed to get Type Origin json for event.");
        }
        return jSONObject;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DeviceInfo(Application application, DisplayMetrics metrics, BuildInformation buildInformation) {
        this(application, metrics, buildInformation, null, null, null, 56, null);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DeviceInfo(Application application, DisplayMetrics metrics, BuildInformation buildInformation, NetworkInfoProvider networkInfoProvider) {
        this(application, metrics, buildInformation, networkInfoProvider, null, null, 48, null);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DeviceInfo(Application application, DisplayMetrics metrics, BuildInformation buildInformation, NetworkInfoProvider networkInfoProvider, BuildConfigInstantiable buildConfigInstantiable) {
        this(application, metrics, buildInformation, networkInfoProvider, buildConfigInstantiable, null, 32, null);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(buildConfigInstantiable, "buildConfigInstantiable");
    }

    @JvmOverloads
    public DeviceInfo(Application application, DisplayMetrics metrics, BuildInformation buildInformation, NetworkInfoProvider networkInfoProvider, BuildConfigInstantiable buildConfigInstantiable, BuildInstantiable buildInstantiable) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(buildInformation, "buildInformation");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(buildConfigInstantiable, "buildConfigInstantiable");
        Intrinsics.checkNotNullParameter(buildInstantiable, "buildInstantiable");
        this.application = application;
        this.metrics = metrics;
        this.buildInformation = buildInformation;
        this.networkInfoProvider = networkInfoProvider;
        this.buildConfigInstantiable = buildConfigInstantiable;
        this.buildInstantiable = buildInstantiable;
        this.logger = new Logger(NativeDeviceInfoSpec.NAME);
        resolveDeviceResolution();
    }

    public /* synthetic */ DeviceInfo(Application application, DisplayMetrics displayMetrics, BuildInformation buildInformation, NetworkInfoProvider networkInfoProvider, BuildConfigInstantiable buildConfigInstantiable, BuildInstantiable buildInstantiable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, displayMetrics, (i & 4) != 0 ? new BuildInformation(application) : buildInformation, (i & 8) != 0 ? new NetworkInfoProvider(application, null, null, 6, null) : networkInfoProvider, (i & 16) != 0 ? new BuildConfigInstantiable() : buildConfigInstantiable, (i & 32) != 0 ? new BuildInstantiable() : buildInstantiable);
    }
}
