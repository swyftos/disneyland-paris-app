package com.disney.id.android.services;

import android.os.Build;
import com.appdynamics.eumagent.runtime.networkrequests.OkHttp3;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/disney/id/android/services/UserAgentInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UserAgentInterceptor implements Interceptor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final String USER_AGENT;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/disney/id/android/services/UserAgentInterceptor$Companion;", "", "()V", "USER_AGENT", "", "getUSER_AGENT", "()Ljava/lang/String;", "safeValue", "value", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nHTTPInterceptors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HTTPInterceptors.kt\ncom/disney/id/android/services/UserAgentInterceptor$Companion\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,295:1\n429#2:296\n502#2,5:297\n*S KotlinDebug\n*F\n+ 1 HTTPInterceptors.kt\ncom/disney/id/android/services/UserAgentInterceptor$Companion\n*L\n37#1:296\n37#1:297,5\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getUSER_AGENT() {
            return UserAgentInterceptor.USER_AGENT;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String safeValue(String value) throws IOException {
            StringBuilder sb = new StringBuilder();
            int length = value.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = value.charAt(i);
                if (cCharAt == '\t' || (' ' <= cCharAt && cCharAt < 127)) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        String strSafeValue = companion.safeValue("4.12.5");
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        String strSafeValue2 = companion.safeValue(RELEASE);
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        String strSafeValue3 = companion.safeValue(MANUFACTURER);
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        USER_AGENT = "OneID/" + strSafeValue + " (Build 250431538; Android " + strSafeValue2 + "; " + strSafeValue3 + " " + companion.safeValue(MODEL) + ")";
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        builderNewBuilder.addHeader("User-Agent", USER_AGENT);
        OkHttp3.Request.Builder.build.Enter(builderNewBuilder);
        Response responseProceed = chain.proceed(builderNewBuilder.build());
        Intrinsics.checkNotNullExpressionValue(responseProceed, "proceed(...)");
        return responseProceed;
    }
}
