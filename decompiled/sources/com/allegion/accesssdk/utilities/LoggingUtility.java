package com.allegion.accesssdk.utilities;

import com.allegion.logging.AlLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/allegion/accesssdk/utilities/LoggingUtility;", "", "<init>", "()V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class LoggingUtility {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/allegion/accesssdk/utilities/LoggingUtility$Companion;", "", "", "methodName", "", "passParams", "", "logMethodEntry", "(Ljava/lang/String;Ljava/util/Map;)V", "returnResult", "additionalInformation", "logMethodExit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void logMethodEntry$default(Companion companion, String str, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            companion.logMethodEntry(str, map);
        }

        public static /* synthetic */ void logMethodExit$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            if ((i & 4) != 0) {
                str3 = "";
            }
            companion.logMethodExit(str, str2, str3);
        }

        @JvmStatic
        @JvmOverloads
        public final void logMethodEntry(@NotNull String str) {
            logMethodEntry$default(this, str, null, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        public final void logMethodEntry(@NotNull String methodName, @NotNull Map<String, String> passParams) {
            Intrinsics.checkParameterIsNotNull(methodName, "methodName");
            Intrinsics.checkParameterIsNotNull(passParams, "passParams");
            AlLog.i("Entering: " + methodName, new Object[0]);
            if (passParams.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("With Params:");
            for (Map.Entry<String, String> entry : passParams.entrySet()) {
                sb.append(" ");
                sb.append(entry.getKey());
                sb.append(":[");
                sb.append(entry.getValue());
                sb.append("]");
            }
            String string = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(string, "stringBuilder.toString()");
            AlLog.d(string, new Object[0]);
        }

        @JvmStatic
        @JvmOverloads
        public final void logMethodExit(@NotNull String str) {
            logMethodExit$default(this, str, null, null, 6, null);
        }

        @JvmStatic
        @JvmOverloads
        public final void logMethodExit(@NotNull String str, @NotNull String str2) {
            logMethodExit$default(this, str, str2, null, 4, null);
        }

        @JvmStatic
        @JvmOverloads
        public final void logMethodExit(@NotNull String methodName, @NotNull String returnResult, @NotNull String additionalInformation) {
            Intrinsics.checkParameterIsNotNull(methodName, "methodName");
            Intrinsics.checkParameterIsNotNull(returnResult, "returnResult");
            Intrinsics.checkParameterIsNotNull(additionalInformation, "additionalInformation");
            StringBuilder sb = new StringBuilder();
            sb.append("Exiting: " + methodName);
            if (additionalInformation.length() > 0) {
                sb.append(", additional information: " + additionalInformation);
            }
            String string = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(string, "stringBuilder.toString()");
            AlLog.i(string, new Object[0]);
            if (returnResult.length() > 0) {
                AlLog.d("Returning Result: " + returnResult, new Object[0]);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void logMethodEntry(@NotNull String str) {
        Companion.logMethodEntry$default(INSTANCE, str, null, 2, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void logMethodEntry(@NotNull String str, @NotNull Map<String, String> map) {
        INSTANCE.logMethodEntry(str, map);
    }

    @JvmStatic
    @JvmOverloads
    public static final void logMethodExit(@NotNull String str) {
        Companion.logMethodExit$default(INSTANCE, str, null, null, 6, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void logMethodExit(@NotNull String str, @NotNull String str2) {
        Companion.logMethodExit$default(INSTANCE, str, str2, null, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void logMethodExit(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        INSTANCE.logMethodExit(str, str2, str3);
    }
}
