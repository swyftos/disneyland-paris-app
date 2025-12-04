package com.urbanairship;

import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import com.contentsquare.android.core.system.DeviceInfo;
import com.urbanairship.AirshipConfigOptions;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010+\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010,J5\u0010'\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010+\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010/J\"\u0010'\u001a\u00020(2\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007J-\u00101\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010+\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010,J\u0010\u00101\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0007J5\u00101\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010+\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010/J\"\u00101\u001a\u00020(2\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007J3\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u00102\u001a\u00020\u00042\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010+\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u00103J)\u00104\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00042\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010+\"\u00020\u0001H\u0007¢\u0006\u0002\u0010,J5\u00104\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010+\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010/J\"\u00104\u001a\u00020(2\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007J*\u00105\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007J\u001a\u00106\u001a\u00020\u00152\b\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u00020\u0015H\u0007J\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J(\u0010:\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u00010.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J-\u0010;\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010+\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010,J\u0010\u0010;\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0007J\"\u0010;\u001a\u00020(2\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007J-\u0010<\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010+\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010,J\u0010\u0010<\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0007J5\u0010<\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020\u00042\u0016\u0010*\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010+\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010/J\"\u0010<\u001a\u00020(2\n\b\u0002\u00100\u001a\u0004\u0018\u00010.2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR&\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0002\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010&¨\u0006="}, d2 = {"Lcom/urbanairship/UALog;", "", "()V", "DEFAULT_TAG", "", "EMPTY", "Lkotlin/Function0;", "IGNORED_CALLING_CLASS_NAMES", "", "kotlin.jvm.PlatformType", "callingClassName", "getCallingClassName", "()Ljava/lang/String;", "logHandler", "Lcom/urbanairship/AirshipLogHandler;", "getLogHandler$annotations", "getLogHandler", "()Lcom/urbanairship/AirshipLogHandler;", "setLogHandler", "(Lcom/urbanairship/AirshipLogHandler;)V", "logLevel", "", "getLogLevel$annotations", "getLogLevel", "()I", "setLogLevel", "(I)V", "logPrivacyLevel", "Lcom/urbanairship/AirshipConfigOptions$PrivacyLevel;", "getLogPrivacyLevel$annotations", "getLogPrivacyLevel", "()Lcom/urbanairship/AirshipConfigOptions$PrivacyLevel;", "setLogPrivacyLevel", "(Lcom/urbanairship/AirshipConfigOptions$PrivacyLevel;)V", "tag", "getTag$annotations", "getTag", "setTag", "(Ljava/lang/String;)V", "d", "", "message", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "t", "", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "throwable", "e", "format", "(Ljava/lang/String;[Ljava/lang/Object;)Lkotlin/jvm/functions/Function0;", "i", "log", "parseLogLevel", "value", "defaultValue", "prependCallingClassName", "sendLog", "v", DeviceInfo.WIDTH, "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUALog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UALog.kt\ncom/urbanairship/UALog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,355:1\n731#2,9:356\n37#3,2:365\n*S KotlinDebug\n*F\n+ 1 UALog.kt\ncom/urbanairship/UALog\n*L\n347#1:356,9\n348#1:365,2\n*E\n"})
/* loaded from: classes4.dex */
public final class UALog {

    @NotNull
    public static final UALog INSTANCE = new UALog();

    @NotNull
    private static final List<String> IGNORED_CALLING_CLASS_NAMES = CollectionsKt.listOf(UALog.class.getName());

    @NotNull
    private static final Function0<String> EMPTY = new Function0() { // from class: com.urbanairship.UALog$EMPTY$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "";
        }
    };

    @NotNull
    public static final String DEFAULT_TAG = "UALib";

    @NotNull
    private static String tag = DEFAULT_TAG;
    private static int logLevel = 6;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    private static AirshipConfigOptions.PrivacyLevel logPrivacyLevel = AirshipConfigOptions.PrivacyLevel.PRIVATE;

    @Nullable
    private static AirshipLogHandler logHandler = new DefaultLogHandler();

    @JvmStatic
    public static /* synthetic */ void getLogHandler$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLogLevel$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLogPrivacyLevel$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getTag$annotations() {
    }

    private UALog() {
    }

    @NotNull
    public static final String getTag() {
        return tag;
    }

    public static final void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        tag = str;
    }

    public static final int getLogLevel() {
        return logLevel;
    }

    public static final void setLogLevel(int i) {
        logLevel = i;
    }

    @NotNull
    public static final AirshipConfigOptions.PrivacyLevel getLogPrivacyLevel() {
        return logPrivacyLevel;
    }

    public static final void setLogPrivacyLevel(@NotNull AirshipConfigOptions.PrivacyLevel privacyLevel) {
        Intrinsics.checkNotNullParameter(privacyLevel, "<set-?>");
        logPrivacyLevel = privacyLevel;
    }

    @Nullable
    public static final AirshipLogHandler getLogHandler() {
        return logHandler;
    }

    public static final void setLogHandler(@Nullable AirshipLogHandler airshipLogHandler) {
        logHandler = airshipLogHandler;
    }

    @JvmStatic
    public static final void w(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        UALog uALog = INSTANCE;
        uALog.sendLog(5, null, uALog.format(message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void w(@NotNull Throwable t, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        UALog uALog = INSTANCE;
        uALog.sendLog(5, t, uALog.format(message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void w(@NotNull Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        INSTANCE.sendLog(5, t, EMPTY);
    }

    @JvmStatic
    public static final void v(@NotNull Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        INSTANCE.sendLog(2, t, EMPTY);
    }

    @JvmStatic
    public static final void v(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        UALog uALog = INSTANCE;
        uALog.sendLog(2, null, uALog.format(message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void d(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        UALog uALog = INSTANCE;
        uALog.sendLog(3, null, uALog.format(message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void d(@NotNull Throwable t, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        UALog uALog = INSTANCE;
        uALog.sendLog(3, t, uALog.format(message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void i(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        UALog uALog = INSTANCE;
        uALog.sendLog(4, null, uALog.format(message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void i(@NotNull Throwable t, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        UALog uALog = INSTANCE;
        uALog.sendLog(4, t, uALog.format(message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void e(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        UALog uALog = INSTANCE;
        uALog.sendLog(6, null, uALog.format(message, Arrays.copyOf(args, args.length)));
    }

    @JvmStatic
    public static final void e(@NotNull Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        INSTANCE.sendLog(6, t, EMPTY);
    }

    @JvmStatic
    public static final void e(@NotNull Throwable t, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        UALog uALog = INSTANCE;
        uALog.sendLog(6, t, uALog.format(message, Arrays.copyOf(args, args.length)));
    }

    public static /* synthetic */ void v$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        v(th, (Function0<String>) function0);
    }

    @JvmStatic
    public static final void v(@Nullable Throwable throwable, @NotNull Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.sendLog(2, throwable, message);
    }

    public static /* synthetic */ void d$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        d(th, (Function0<String>) function0);
    }

    @JvmStatic
    public static final void d(@Nullable Throwable throwable, @NotNull Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.sendLog(3, throwable, message);
    }

    public static /* synthetic */ void i$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        i(th, (Function0<String>) function0);
    }

    @JvmStatic
    public static final void i(@Nullable Throwable throwable, @NotNull Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.sendLog(4, throwable, message);
    }

    public static /* synthetic */ void w$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        w(th, (Function0<String>) function0);
    }

    @JvmStatic
    public static final void w(@Nullable Throwable throwable, @NotNull Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.sendLog(5, throwable, message);
    }

    public static /* synthetic */ void e$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        e(th, (Function0<String>) function0);
    }

    @JvmStatic
    public static final void e(@Nullable Throwable throwable, @NotNull Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.sendLog(6, throwable, message);
    }

    public static /* synthetic */ void log$default(int i, Throwable th, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        log(i, th, function0);
    }

    @JvmStatic
    public static final void log(int logLevel2, @Nullable Throwable throwable, @NotNull Function0<String> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.sendLog(logLevel2, throwable, message);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (r0.equals("ASSERT") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
    
        if (r0.equals("NONE") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        return 7;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b A[ADDED_TO_REGION] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int parseLogLevel(@org.jetbrains.annotations.Nullable java.lang.String r4, int r5) throws java.lang.IllegalArgumentException {
        /*
            if (r4 == 0) goto L99
            int r0 = r4.length()
            if (r0 != 0) goto La
            goto L99
        La:
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r0 = r4.toUpperCase(r0)
            java.lang.String r1 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.hashCode()
            r2 = 7
            r3 = 2
            switch(r1) {
                case 2251950: goto L5d;
                case 2402104: goto L53;
                case 2656902: goto L48;
                case 64921139: goto L3d;
                case 66247144: goto L32;
                case 1069090146: goto L28;
                case 1940088646: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L65
        L1f:
            java.lang.String r1 = "ASSERT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5c
            goto L65
        L28:
            java.lang.String r1 = "VERBOSE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L31
            goto L65
        L31:
            return r3
        L32:
            java.lang.String r1 = "ERROR"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3b
            goto L65
        L3b:
            r4 = 6
            return r4
        L3d:
            java.lang.String r1 = "DEBUG"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L46
            goto L65
        L46:
            r4 = 3
            return r4
        L48:
            java.lang.String r1 = "WARN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L51
            goto L65
        L51:
            r4 = 5
            return r4
        L53:
            java.lang.String r1 = "NONE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5c
            goto L65
        L5c:
            return r2
        L5d:
            java.lang.String r1 = "INFO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L97
        L65:
            int r0 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L80
            if (r0 > r2) goto L6e
            if (r0 < r3) goto L6e
            return r0
        L6e:
            java.lang.String r1 = "%s is not a valid log level. Falling back to %s."
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.NumberFormatException -> L80
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.NumberFormatException -> L80
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r2}     // Catch: java.lang.NumberFormatException -> L80
            w(r1, r0)     // Catch: java.lang.NumberFormatException -> L80
            return r5
        L80:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid log level: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L97:
            r4 = 4
            return r4
        L99:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.UALog.parseLogLevel(java.lang.String, int):int");
    }

    private final void sendLog(int logLevel2, Throwable throwable, Function0<String> message) {
        AirshipLogHandler airshipLogHandler;
        if (logLevel <= logLevel2 && (airshipLogHandler = logHandler) != null) {
            if (logLevel2 == 2 || logLevel2 == 3) {
                message = prependCallingClassName(message);
            }
            if (logPrivacyLevel == AirshipConfigOptions.PrivacyLevel.PUBLIC && (logLevel2 == 2 || logLevel2 == 3)) {
                airshipLogHandler.log(tag, 4, throwable, message);
            } else {
                airshipLogHandler.log(tag, logLevel2, throwable, message);
            }
        }
    }

    private final Function0<String> prependCallingClassName(final Function0<String> message) {
        final String callingClassName = getCallingClassName();
        return callingClassName == null ? message : new Function0() { // from class: com.urbanairship.UALog.prependCallingClassName.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = (String) message.invoke();
                if (StringsKt.startsWith$default(str, callingClassName, false, 2, (Object) null)) {
                    return str;
                }
                return callingClassName + " - " + str;
            }
        };
    }

    private final Function0<String> format(final String format, final Object... args) {
        return new Function0() { // from class: com.urbanairship.UALog.format.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r4v6 */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                try {
                    Object[] objArr = args;
                    if (objArr.length == 0) {
                        this = format;
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Locale locale = Locale.ROOT;
                        String str = format;
                        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        this = str2;
                    }
                    return this;
                } catch (Exception unused) {
                    UALog.e("Unable to format log message: " + format, new Object[0]);
                    return format;
                }
            }
        };
    }

    private final String getCallingClassName() {
        List listEmptyList;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        for (int i = 1; i < length; i++) {
            String className = stackTrace[i].getClassName();
            if (!IGNORED_CALLING_CLASS_NAMES.contains(className)) {
                Intrinsics.checkNotNull(className);
                List<String> listSplit = new Regex("\\.").split(className, 0);
                if (!listSplit.isEmpty()) {
                    ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                return new Regex("(\\$.+)+$").replace(strArr[strArr.length - 1], "");
            }
        }
        return null;
    }
}
