package com.contentsquare.android.core.communication.error;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.urbanairship.AirshipConfigOptions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import org.bouncycastle.i18n.ErrorBundle;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH&J\u0016\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/core/communication/error/ErrorAnalysisInterface;", "", "isApiErrorEnabled", "", "isCrashReportingEnabled", "sendNetworkEvent", "", "event", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "sendReactNativeError", ErrorBundle.DETAIL_ENTRY, "", "", "setUrlMaskingPatterns", "patterns", "", "NetworkEventSource", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ErrorAnalysisInterface {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/android/core/communication/error/ErrorAnalysisInterface$NetworkEventSource;", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface NetworkEventSource {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String NATIVE = "native";

        @NotNull
        public static final String REACT_NATIVE = "reactNative";

        @NotNull
        public static final String WEBVIEW = "webview";

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/contentsquare/android/core/communication/error/ErrorAnalysisInterface$NetworkEventSource$Companion;", "", "()V", "NATIVE", "", "REACT_NATIVE", "WEBVIEW", AirshipConfigOptions.FEATURE_ALL, "", "getAll", "()Ljava/util/List;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {

            @NotNull
            public static final String NATIVE = "native";

            @NotNull
            public static final String REACT_NATIVE = "reactNative";

            @NotNull
            public static final String WEBVIEW = "webview";
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            private static final List<String> all = CollectionsKt.listOf((Object[]) new String[]{"native", "webview", "reactNative"});

            private Companion() {
            }

            @NotNull
            public final List<String> getAll() {
                return all;
            }
        }
    }

    boolean isApiErrorEnabled();

    boolean isCrashReportingEnabled();

    void sendNetworkEvent(NetworkEvent event);

    void sendReactNativeError(Map<String, ? extends Object> details);

    void setUrlMaskingPatterns(List<String> patterns);
}
