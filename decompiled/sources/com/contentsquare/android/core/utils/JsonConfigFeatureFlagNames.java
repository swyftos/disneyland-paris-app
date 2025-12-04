package com.contentsquare.android.core.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/contentsquare/android/core/utils/JsonConfigFeatureFlagNames;", "", "()V", "API_ERRORS", "", "CRASH_REPORTER", "ENABLE_HEAP_TRIPLET", "END_OF_SCREEN_VIEW", "EXPOSURE_METRICS", "FOREGROUND_REFRESH_CONFIG", "HEATMAP", "LOG_MONITORING", "LONG_SNAPSHOT_JETPACK_COMPOSE", "SESSION_RECORDING_ENABLED", "SNAPSHOT_CAPTURE_SR", "SR_DETECT_ANIMATIONS", "SR_JETPACK_COMPOSE", "TELEMETRY", "TELEMETRY_LIFECYCLE", "TELEMETRY_NETWORK", "TELEMETRY_PUBLIC_USAGE", "TELEMETRY_TIME", "UNIFIED_SESSION_DEFINITION", "WEBVIEW_API_ERRORS", "WEBVIEW_CUSTOM_ERRORS", "WEBVIEW_HANDLE_DATA_ASSET", "WEBVIEW_JS_ERRORS", "featureFlags", "", "getFeatureFlags", "()Ljava/util/List;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JsonConfigFeatureFlagNames {

    @NotNull
    public static final String WEBVIEW_API_ERRORS = "webview_api_errors";

    @NotNull
    public static final JsonConfigFeatureFlagNames INSTANCE = new JsonConfigFeatureFlagNames();

    @NotNull
    public static final String SESSION_RECORDING_ENABLED = "session_recording";

    @NotNull
    public static final String SR_JETPACK_COMPOSE = "sr_jetpack_compose";

    @NotNull
    public static final String SR_DETECT_ANIMATIONS = "sr_detect_animations";

    @NotNull
    public static final String API_ERRORS = "api_errors";

    @NotNull
    public static final String WEBVIEW_JS_ERRORS = "webview_javascript_errors";

    @NotNull
    public static final String WEBVIEW_HANDLE_DATA_ASSET = "webview_handle_data_assets";

    @NotNull
    public static final String WEBVIEW_CUSTOM_ERRORS = "webview_custom_errors";

    @NotNull
    public static final String CRASH_REPORTER = "crash_reporter";

    @NotNull
    public static final String END_OF_SCREEN_VIEW = "endofscreenview_event";

    @NotNull
    public static final String LONG_SNAPSHOT_JETPACK_COMPOSE = "long_snapshot_jetpack_compose";

    @NotNull
    public static final String EXPOSURE_METRICS = "exposure_metrics";

    @NotNull
    public static final String SNAPSHOT_CAPTURE_SR = "snapshot_capture_SR";

    @NotNull
    public static final String ENABLE_HEAP_TRIPLET = "enable_heap_triplet";

    @NotNull
    public static final String FOREGROUND_REFRESH_CONFIG = "foreground_refresh_config";

    @NotNull
    public static final String UNIFIED_SESSION_DEFINITION = "unified_session_definition";

    @NotNull
    public static final String TELEMETRY = "telemetry";

    @NotNull
    public static final String TELEMETRY_NETWORK = "telemetry_network";

    @NotNull
    public static final String TELEMETRY_TIME = "telemetry_time";

    @NotNull
    public static final String TELEMETRY_LIFECYCLE = "telemetry_lifecycle";

    @NotNull
    public static final String TELEMETRY_PUBLIC_USAGE = "telemetry_public_usage";

    @NotNull
    public static final String LOG_MONITORING = "log_monitoring";

    @NotNull
    public static final String HEATMAP = "heatmap";

    @NotNull
    private static final List<String> featureFlags = CollectionsKt.listOf((Object[]) new String[]{SESSION_RECORDING_ENABLED, SR_JETPACK_COMPOSE, SR_DETECT_ANIMATIONS, API_ERRORS, WEBVIEW_JS_ERRORS, WEBVIEW_HANDLE_DATA_ASSET, WEBVIEW_CUSTOM_ERRORS, CRASH_REPORTER, END_OF_SCREEN_VIEW, LONG_SNAPSHOT_JETPACK_COMPOSE, EXPOSURE_METRICS, SNAPSHOT_CAPTURE_SR, ENABLE_HEAP_TRIPLET, FOREGROUND_REFRESH_CONFIG, UNIFIED_SESSION_DEFINITION, TELEMETRY, TELEMETRY_NETWORK, TELEMETRY_TIME, TELEMETRY_LIFECYCLE, TELEMETRY_PUBLIC_USAGE, LOG_MONITORING, HEATMAP});

    private JsonConfigFeatureFlagNames() {
    }

    @NotNull
    public final List<String> getFeatureFlags() {
        return featureFlags;
    }
}
