package com.contentsquare.android.error.analysis.apierror;

import com.google.common.net.HttpHeaders;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/ApiErrorConstants;", "", "()V", "BODY_ATTR_JSON_MAX_SIZE", "", "BODY_ATTR_MAX_SIZE", "", "EMAIL_REGEX", "Lkotlin/text/Regex;", "getEMAIL_REGEX", "()Lkotlin/text/Regex;", "EMAIL_REPLACEMENT", "", "FAST_LOOKUP_EMAIL_REGEX", "getFAST_LOOKUP_EMAIL_REGEX", "HEADERS_MAX_SIZE", "QUERY_PARAMS_MAX_SIZE", "REQUEST_BODY_MAX_SIZE", "RESPONSE_BODY_MAX_SIZE", "STANDARD_HEADERS_MAP", "", "getSTANDARD_HEADERS_MAP", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SUPPRESSED_MESSAGE_MARKER", "", "getSUPPRESSED_MESSAGE_MARKER", "()[B", "SUPPRESSED_MESSAGE_MARKER_STR", "TRUNCATED_MAP", "", "getTRUNCATED_MAP", "()Ljava/util/Map;", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApiErrorConstants {
    public static final long BODY_ATTR_JSON_MAX_SIZE = 64000;
    public static final int BODY_ATTR_MAX_SIZE = 100;

    @NotNull
    private static final Regex EMAIL_REGEX;

    @NotNull
    public static final String EMAIL_REPLACEMENT = "CS_ANONYMIZED_EMAIL";

    @NotNull
    private static final Regex FAST_LOOKUP_EMAIL_REGEX;
    public static final long HEADERS_MAX_SIZE = 8000;

    @NotNull
    public static final ApiErrorConstants INSTANCE = new ApiErrorConstants();
    public static final long QUERY_PARAMS_MAX_SIZE = 2000;
    public static final long REQUEST_BODY_MAX_SIZE = 64000;
    public static final long RESPONSE_BODY_MAX_SIZE = 5000;

    @NotNull
    private static final String[] STANDARD_HEADERS_MAP;

    @NotNull
    private static final byte[] SUPPRESSED_MESSAGE_MARKER;

    @NotNull
    public static final String SUPPRESSED_MESSAGE_MARKER_STR = "…";

    @NotNull
    private static final Map<String, String> TRUNCATED_MAP;

    static {
        byte[] bytes = "…".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        SUPPRESSED_MESSAGE_MARKER = bytes;
        TRUNCATED_MAP = MapsKt.mapOf(TuplesKt.to("…", "…"));
        RegexOption regexOption = RegexOption.IGNORE_CASE;
        EMAIL_REGEX = new Regex("[a-zA-Z0-9._%+-]+(?:@|%40)[a-zA-Z0-9.%+-]+", regexOption);
        FAST_LOOKUP_EMAIL_REGEX = new Regex("[a-zA-Z0-9+_-](?:@|%40)", regexOption);
        STANDARD_HEADERS_MAP = new String[]{HttpHeaders.AGE, "Cache-Control", "Clear-Site-Data", "Expires", HttpHeaders.PRAGMA, HttpHeaders.WARNING, HttpHeaders.DOWNLINK, HttpHeaders.ECT, HttpHeaders.RTT, "Last-Modified", "Connection", HttpHeaders.KEEP_ALIVE, "Accept", HttpHeaders.ACCEPT_ENCODING, HttpHeaders.ACCEPT_LANGUAGE, "Expect", HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.ACCESS_CONTROL_MAX_AGE, HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS, HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, HttpHeaders.ORIGIN, HttpHeaders.TIMING_ALLOW_ORIGIN, "Content-Length", "Content-Type", "Content-Encoding", "Content-Language", HttpHeaders.VIA, "Host", HttpHeaders.REFERRER_POLICY, "User-Agent", "Allow", "Server", HttpHeaders.ACCEPT_RANGES, "Range", HttpHeaders.IF_RANGE, "Content-Range", HttpHeaders.CROSS_ORIGIN_EMBEDDER_POLICY, HttpHeaders.CROSS_ORIGIN_OPENER_POLICY, HttpHeaders.CROSS_ORIGIN_RESOURCE_POLICY, HttpHeaders.CONTENT_SECURITY_POLICY, HttpHeaders.CONTENT_SECURITY_POLICY_REPORT_ONLY, "Expect-CT", "Feature-Policy", "Strict-Transport-Policy", HttpHeaders.UPGRADE_INSECURE_REQUESTS, HttpHeaders.X_CONTENT_TYPE_OPTIONS, HttpHeaders.X_DOWNLOAD_OPTIONS, HttpHeaders.X_FRAME_OPTIONS, "X-Permitted-Cross-Domain-Policies", HttpHeaders.X_POWERED_BY, HttpHeaders.X_XSS_PROTECTION, "Sec_Fetch-Site", HttpHeaders.SEC_FETCH_MODE, HttpHeaders.SEC_FETCH_USER, HttpHeaders.SEC_FETCH_DEST};
    }

    private ApiErrorConstants() {
    }

    @NotNull
    public final Regex getEMAIL_REGEX() {
        return EMAIL_REGEX;
    }

    @NotNull
    public final Regex getFAST_LOOKUP_EMAIL_REGEX() {
        return FAST_LOOKUP_EMAIL_REGEX;
    }

    @NotNull
    public final String[] getSTANDARD_HEADERS_MAP() {
        return STANDARD_HEADERS_MAP;
    }

    @NotNull
    public final byte[] getSUPPRESSED_MESSAGE_MARKER() {
        return SUPPRESSED_MESSAGE_MARKER;
    }

    @NotNull
    public final Map<String, String> getTRUNCATED_MAP() {
        return TRUNCATED_MAP;
    }
}
