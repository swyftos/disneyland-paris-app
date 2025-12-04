package com.contentsquare.android.error.analysis;

import androidx.annotation.RestrictTo;
import com.contentsquare.android.core.communication.error.ErrorAnalysisInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.urbanairship.AirshipConfigOptions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", "", "()V", "errorAnalysisModule", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisInterface;", "isEnabled", "", "newNetworkMetric", "Lcom/contentsquare/android/error/analysis/NetworkMetric;", "url", "", "httpMethod", "source", "sendEvent", "", "rawEvent", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "setErrorAnalysisModule", "Companion", "HttpMethod", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ErrorAnalysis {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ErrorAnalysis instance = new ErrorAnalysis();

    @Nullable
    private ErrorAnalysisInterface errorAnalysisModule;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/contentsquare/android/error/analysis/ErrorAnalysis$Companion;", "", "()V", "instance", "Lcom/contentsquare/android/error/analysis/ErrorAnalysis;", "getInstance", "setUrlMaskingPatterns", "", "patterns", "", "", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ErrorAnalysis getInstance() {
            return ErrorAnalysis.instance;
        }

        @JvmStatic
        public final void setUrlMaskingPatterns(List<String> patterns) {
            Intrinsics.checkNotNullParameter(patterns, "patterns");
            ErrorAnalysisInterface errorAnalysisInterface = getInstance().errorAnalysisModule;
            if (errorAnalysisInterface != null) {
                errorAnalysisInterface.setUrlMaskingPatterns(patterns);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/android/error/analysis/ErrorAnalysis$HttpMethod;", "", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface HttpMethod {

        @NotNull
        public static final String CONNECT = "CONNECT";

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String DELETE = "DELETE";

        @NotNull
        public static final String GET = "GET";

        @NotNull
        public static final String HEAD = "HEAD";

        @NotNull
        public static final String OPTIONS = "OPTIONS";

        @NotNull
        public static final String PATCH = "PATCH";

        @NotNull
        public static final String POST = "POST";

        @NotNull
        public static final String PUT = "PUT";

        @NotNull
        public static final String TRACE = "TRACE";

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/error/analysis/ErrorAnalysis$HttpMethod$Companion;", "", "()V", "CONNECT", "", "DELETE", "GET", "HEAD", "OPTIONS", "PATCH", "POST", "PUT", "TRACE", AirshipConfigOptions.FEATURE_ALL, "", "getAll$error_analysis_release", "()Ljava/util/List;", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {

            @NotNull
            public static final String CONNECT = "CONNECT";

            @NotNull
            public static final String DELETE = "DELETE";

            @NotNull
            public static final String GET = "GET";

            @NotNull
            public static final String HEAD = "HEAD";

            @NotNull
            public static final String OPTIONS = "OPTIONS";

            @NotNull
            public static final String PATCH = "PATCH";

            @NotNull
            public static final String POST = "POST";

            @NotNull
            public static final String PUT = "PUT";

            @NotNull
            public static final String TRACE = "TRACE";
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            private static final List<String> all = CollectionsKt.listOf((Object[]) new String[]{"GET", "PUT", "POST", "DELETE", "HEAD", "PATCH", "OPTIONS", "TRACE", "CONNECT"});

            private Companion() {
            }

            @NotNull
            public final List<String> getAll$error_analysis_release() {
                return all;
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.contentsquare.android.error.analysis.ErrorAnalysis$newNetworkMetric$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<NetworkEvent, Unit> {
        public AnonymousClass1(Object obj) {
            super(1, obj, ErrorAnalysis.class, "sendEvent", "sendEvent(Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NetworkEvent networkEvent) {
            invoke2(networkEvent);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NetworkEvent p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ErrorAnalysis) this.receiver).sendEvent(p0);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.contentsquare.android.error.analysis.ErrorAnalysis$newNetworkMetric$2, reason: invalid class name */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    @JvmStatic
    @NotNull
    public static final ErrorAnalysis getInstance() {
        return INSTANCE.getInstance();
    }

    public static /* synthetic */ NetworkMetric newNetworkMetric$default(ErrorAnalysis errorAnalysis, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "native";
        }
        return errorAnalysis.newNetworkMetric(str, str2, str3);
    }

    @JvmStatic
    public static final void setUrlMaskingPatterns(List<String> list) {
        INSTANCE.setUrlMaskingPatterns(list);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isEnabled() {
        ErrorAnalysisInterface errorAnalysisInterface = this.errorAnalysisModule;
        if (errorAnalysisInterface != null) {
            return errorAnalysisInterface.isApiErrorEnabled();
        }
        return false;
    }

    @NotNull
    public final NetworkMetric newNetworkMetric(String url, String httpMethod, String source) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(source, "source");
        return new NetworkMetric(url, httpMethod, source, AnonymousClass2.INSTANCE, new AnonymousClass1(this));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void sendEvent(NetworkEvent rawEvent) {
        Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
        ErrorAnalysisInterface errorAnalysisInterface = this.errorAnalysisModule;
        if (errorAnalysisInterface != null) {
            errorAnalysisInterface.sendNetworkEvent(rawEvent);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setErrorAnalysisModule(ErrorAnalysisInterface errorAnalysisModule) {
        this.errorAnalysisModule = errorAnalysisModule;
    }
}
