package com.appdynamics.eum.reactnative;

import android.util.Log;
import com.appdynamics.eumagent.runtime.AgentConfiguration;
import com.appdynamics.eumagent.runtime.CallTracker;
import com.appdynamics.eumagent.runtime.CrashReportCallback;
import com.appdynamics.eumagent.runtime.CrashReportSummary;
import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.appdynamics.eumagent.runtime.ServerCorrelationHeaders;
import com.appdynamics.eumagent.runtime.SessionFrame;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import com.urbanairship.analytics.CustomEvent;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 u2\u00020\u0001:\u0002uvB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0016J*\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010'\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010(\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010)\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010*\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010+\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010.\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ2\u0010/\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u00010\n2\b\u00101\u001a\u0004\u0018\u00010\n2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001dJ \u00106\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u00010\n2\u0006\u00108\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ \u00109\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u00010\n2\u0006\u0010:\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010>\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010?\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010@\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010A\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010D\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010E\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010F\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010G\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\n2\u0006\u0010\"\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010H\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010I\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010K\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010L\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010Q\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010T\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010U\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010W\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010Z\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\n2\u0006\u0010[\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\\\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010^\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\n2\u0006\u0010_\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010`\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ&\u0010a\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ&\u0010b\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ&\u0010c\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010\"\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001dJ&\u0010d\u001a\u00020\u00132\u0006\u0010X\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0019\u0010e\u001a\u0004\u0018\u00010f2\b\u0010J\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010gJ\u001a\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0i2\b\u0010j\u001a\u0004\u0018\u000103H\u0002J\u001d\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010l2\u0006\u0010j\u001a\u000203H\u0002¢\u0006\u0002\u0010mJ\u001e\u0010n\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00162\u0006\u0010o\u001a\u00020\u0019H\u0002J\u001c\u0010p\u001a\u00020\u00192\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0016H\u0002J\u0016\u0010r\u001a\u0002032\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00010tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Lcom/appdynamics/eum/reactnative/ReactNativeAppdynamicsModuleImpl;", "", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "trackers", "", "", "Lcom/appdynamics/eumagent/runtime/CallTracker;", "sessionFrames", "Lcom/appdynamics/eumagent/runtime/SessionFrame;", "customRequestTrackers", "Lcom/appdynamics/eumagent/runtime/HttpRequestTracker;", "reactCrashRequestCallback", "Lcom/facebook/react/bridge/Callback;", "setCrashReportCallback", "", "cb", "getConstants", "", ViewProps.START, CustomEvent.PROPERTIES, "Lcom/facebook/react/bridge/ReadableMap;", "hybridAgentType", "hybridAgentVersion", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "changeAppKey", "appKey", "reportMetric", "name", "value", "", "reportError", "hybridExceptionData", "severityLevel", "createCrashReport", "startTimer", "stopTimer", "shutdownAgent", "restartAgent", "trackScreenStart", "trackedScreen", "trackScreenEnd", "beginCall", "className", "methodName", "args", "Lcom/facebook/react/bridge/ReadableArray;", "isStaticMethod", "", "endCallWithSuccess", "callId", "data", "endCallWithError", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "leaveBreadcrumb", "breadcrumb", "mode", "unblockScreenshots", "blockScreenshots", "screenshotsBlocked", "takeScreenshot", "setUserData", "key", "removeUserData", "setUserDataNumber", "removeUserDataNumber", "setUserDataBoolean", "removeUserDataBoolean", "setUserDataDate", "valueStr", "removeUserDataDate", "startNextSession", "startSessionFrame", "sessionFrameName", "updateSessionFrameName", "id", "endSessionFrame", "trackUIEvent", "eventInfo", "getServerCorrelationHeaders", "getRequestTrackerWithUrl", "urlString", "setRequestTrackerErrorInfo", "trackerId", "errorDict", "setRequestTrackerStatusCode", "statusCode", "setRequestTrackerResponseHeaders", "responseHeaders", "setRequestTrackerRequestHeaders", "requestHeaders", "requestTrackerReport", "setRequestTrackerUserData", "setRequestTrackerUserDataNumber", "setRequestTrackerUserDataBoolean", "setRequestTrackerUserDataDate", "parseLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "deserializeStringSet", "", "readableArray", "deserializeArray", "", "(Lcom/facebook/react/bridge/ReadableArray;)[Ljava/lang/Object;", "deserializeMap", "readableMap", "convertToReadableMap", "map", "convertToReadableArray", "list", "", "Companion", "CrashCallbackObject", "appdynamics_react-native-agent_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactNativeAppdynamicsModuleImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactNativeAppdynamicsModuleImpl.kt\ncom/appdynamics/eum/reactnative/ReactNativeAppdynamicsModuleImpl\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,678:1\n216#2,2:679\n1863#3,2:681\n*S KotlinDebug\n*F\n+ 1 ReactNativeAppdynamicsModuleImpl.kt\ncom/appdynamics/eum/reactnative/ReactNativeAppdynamicsModuleImpl\n*L\n650#1:679,2\n665#1:681,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ReactNativeAppdynamicsModuleImpl {

    @NotNull
    public static final String NAME = "ReactNativeAppdynamics";
    private final ReactApplicationContext context;
    private final Map customRequestTrackers;
    private Callback reactCrashRequestCallback;
    private final Map sessionFrames;
    private final Map trackers;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Null.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ReactNativeAppdynamicsModuleImpl(@NotNull ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.trackers = new HashMap();
        this.sessionFrames = new HashMap();
        this.customRequestTrackers = new HashMap();
    }

    @NotNull
    public final ReactApplicationContext getContext() {
        return this.context;
    }

    public final void setCrashReportCallback(@NotNull Callback cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.reactCrashRequestCallback = cb;
    }

    private static final class CrashCallbackObject implements CrashReportCallback {
        private final Callback reactCrashReportCallback;

        public CrashCallbackObject(Callback reactCrashReportCallback) {
            Intrinsics.checkNotNullParameter(reactCrashReportCallback, "reactCrashReportCallback");
            this.reactCrashReportCallback = reactCrashReportCallback;
        }

        @Override // com.appdynamics.eumagent.runtime.CrashReportCallback
        public void onCrashesReported(Collection summaries) {
            Intrinsics.checkNotNullParameter(summaries, "summaries");
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator it = summaries.iterator();
            while (it.hasNext()) {
                CrashReportSummary crashReportSummary = (CrashReportSummary) it.next();
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("crashId", crashReportSummary.crashId);
                writableMapCreateMap.putString("exceptionClass", crashReportSummary.exceptionClass);
                writableMapCreateMap.putString("exceptionMessage", crashReportSummary.exceptionMessage);
                writableArrayCreateArray.pushMap(writableMapCreateMap);
            }
            this.reactCrashReportCallback.invoke(writableArrayCreateArray);
        }
    }

    @NotNull
    public final Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("BREADCRUMB_VISIBILITY_CRASHES_AND_SESSIONS", 1);
        map.put("BREADCRUMB_VISIBILITY_CRASHES_ONLY", 0);
        map.put("ERROR_SEVERITY_LEVEL_CRITICAL", 2);
        map.put("ERROR_SEVERITY_LEVEL_INFO", 0);
        map.put("ERROR_SEVERITY_LEVEL_WARNING", 1);
        map.put("LOGGING_LEVEL_INFO", 2);
        map.put("LOGGING_LEVEL_NONE", 4);
        map.put("LOGGING_LEVEL_VERBOSE", 1);
        map.put("MAX_USER_DATA_STRING_LENGTH", 2048);
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.facebook.react.bridge.Promise] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final void start(@NotNull ReadableMap properties, @Nullable String hybridAgentType, @Nullable String hybridAgentVersion, @NotNull Promise promise) {
        ?? r1;
        ReadableMap properties2 = properties;
        Intrinsics.checkNotNullParameter(properties2, "properties");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            try {
                if (properties2.hasKey("appKey")) {
                    ReadableType type = properties2.getType("appKey");
                    try {
                        ReadableType readableType = ReadableType.String;
                        if (type == readableType) {
                            AgentConfiguration.Builder builderWithContext = AgentConfiguration.builder().withAppKey(properties2.getString("appKey")).withContext(this.context);
                            Intrinsics.checkNotNullExpressionValue(builderWithContext, "withContext(...)");
                            if (properties2.hasKey("applicationName") && properties2.getType("applicationName") == readableType) {
                                builderWithContext.withApplicationName(properties2.getString("applicationName"));
                            }
                            if (properties2.hasKey("autoInstrument") && properties2.getType("autoInstrument") == ReadableType.Boolean) {
                                builderWithContext.withAutoInstrument(properties2.getBoolean("autoInstrument"));
                            }
                            if (properties2.hasKey("collectorURL") && properties2.getType("collectorURL") == readableType) {
                                builderWithContext.withCollectorURL(properties2.getString("collectorURL"));
                            }
                            if (properties2.hasKey("screenshotURL") && properties2.getType("screenshotURL") == readableType) {
                                builderWithContext.withScreenshotURL(properties2.getString("screenshotURL"));
                            }
                            if (properties2.hasKey("screenshotsEnabled") && properties2.getType("screenshotsEnabled") == ReadableType.Boolean) {
                                builderWithContext.withScreenshotsEnabled(properties2.getBoolean("screenshotsEnabled"));
                            }
                            if (properties2.hasKey("excludedURLPatterns") && properties2.getType("excludedURLPatterns") == ReadableType.Array) {
                                builderWithContext.withExcludedUrlPatterns(deserializeStringSet(properties2.getArray("excludedURLPatterns")));
                            }
                            if (properties2.hasKey("loggingLevel") && properties2.getType("loggingLevel") == ReadableType.Number) {
                                builderWithContext.withLoggingLevel(properties2.getInt("loggingLevel"));
                            }
                            if (properties2.hasKey("compileTimeInstrumentationCheck") && properties2.getType("compileTimeInstrumentationCheck") == ReadableType.Boolean) {
                                builderWithContext.withCompileTimeInstrumentationCheck(properties2.getBoolean("compileTimeInstrumentationCheck"));
                            }
                            if (properties2.hasKey("jsAgentInjectionEnabled") && properties2.getType("jsAgentInjectionEnabled") == ReadableType.Boolean) {
                                builderWithContext.withJSAgentInjectionEnabled(properties2.getBoolean("jsAgentInjectionEnabled"));
                            }
                            if (properties2.hasKey("jsAgentAjaxEnabled") && properties2.getType("jsAgentAjaxEnabled") == ReadableType.Boolean) {
                                builderWithContext.withJSAgentAjaxEnabled(properties2.getBoolean("jsAgentAjaxEnabled"));
                            }
                            if (properties2.hasKey("crashReportingEnabled") && properties2.getType("crashReportingEnabled") == ReadableType.Boolean) {
                                builderWithContext.withCrashReportingEnabled(properties2.getBoolean("crashReportingEnabled"));
                            }
                            Callback callback = this.reactCrashRequestCallback;
                            if (callback != null) {
                                Intrinsics.checkNotNull(callback);
                                builderWithContext.withCrashCallback(new CrashCallbackObject(callback));
                            }
                            builderWithContext.withInteractionCaptureMode(0);
                            Instrumentation.startFromHybrid(builderWithContext.build(), hybridAgentType, hybridAgentVersion);
                            promise.resolve(null);
                            return;
                        }
                    } catch (RuntimeException e) {
                        e = e;
                        r1 = promise;
                        r1.reject(e);
                        return;
                    }
                }
                Log.e(ReactNativeAppdynamicsModuleImpl.class.getName(), "Could not start AppDynamics instrumentation: Invalid or missing appKey");
            } catch (RuntimeException e2) {
                e = e2;
                r1 = properties2;
            }
        } catch (RuntimeException e3) {
            e = e3;
            r1 = promise;
        }
    }

    public final void changeAppKey(@NotNull String appKey, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.changeAppKey(appKey);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to change app key", th.getMessage());
        }
    }

    public final void reportMetric(@NotNull String name, double value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.reportMetric(name, (long) value);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to report metric", th.getMessage());
        }
    }

    public final void reportError(@NotNull String hybridExceptionData, double severityLevel, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(hybridExceptionData, "hybridExceptionData");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.reportRawError(hybridExceptionData, (int) severityLevel);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to report error", th.getMessage());
        }
    }

    public final void createCrashReport(@NotNull String hybridExceptionData, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(hybridExceptionData, "hybridExceptionData");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.createRawCrashReport(hybridExceptionData);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to send crash report", th.getMessage());
        }
    }

    public final void startTimer(@NotNull String name, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.startTimer(name);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to start timer", th.getMessage());
        }
    }

    public final void stopTimer(@NotNull String name, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.stopTimer(name);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to stop timer", th.getMessage());
        }
    }

    public final void shutdownAgent(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.shutdownAgent();
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to shutdown agent", th.getMessage());
        }
    }

    public final void restartAgent(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.restartAgent();
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to restart agent", th.getMessage());
        }
    }

    public final void trackScreenStart(@NotNull ReadableMap trackedScreen, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackedScreen, "trackedScreen");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            String string = trackedScreen.getString("screenName");
            double d = trackedScreen.getDouble("startDate");
            UUID uuidRandomUUID = UUID.randomUUID();
            Instrumentation.trackPageStart(string, uuidRandomUUID, (long) d);
            promise.resolve(uuidRandomUUID.toString());
        } catch (Throwable th) {
            promise.reject("Failed to create track page start", th);
        }
    }

    public final void trackScreenEnd(@NotNull ReadableMap trackedScreen, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackedScreen, "trackedScreen");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.trackPageEnd(trackedScreen.getString("screenName"), UUID.fromString(trackedScreen.getString("uuidString")), (long) trackedScreen.getDouble("startDate"), (long) trackedScreen.getDouble("endDate"));
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to create track page start", th);
        }
    }

    public final void beginCall(@Nullable String className, @Nullable String methodName, @NotNull ReadableArray args, boolean isStaticMethod, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Object[] objArrDeserializeArray = deserializeArray(args);
            CallTracker callTrackerBeginCall = Instrumentation.beginCall(isStaticMethod, className, methodName, Arrays.copyOf(objArrDeserializeArray, objArrDeserializeArray.length));
            Intrinsics.checkNotNullExpressionValue(callTrackerBeginCall, "beginCall(...)");
            this.trackers.put(string, callTrackerBeginCall);
            promise.resolve(string);
        } catch (Throwable th) {
            promise.reject("Failed to start function tracking", th);
        }
    }

    public final void endCallWithSuccess(@Nullable String callId, @NotNull ReadableMap data, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            CallTracker callTracker = (CallTracker) this.trackers.get(callId);
            if (callTracker != null) {
                TypeIntrinsics.asMutableMap(this.trackers).remove(callId);
                callTracker.reportCallEndedWithReturnValue(deserializeMap(data).get("result"));
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to end function tracking", th);
        }
    }

    public final void endCallWithError(@Nullable String callId, @NotNull ReadableMap error, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            CallTracker callTracker = (CallTracker) this.trackers.get(callId);
            if (callTracker != null) {
                TypeIntrinsics.asMutableMap(this.trackers).remove(callId);
                callTracker.reportCallEndedWithException(new Exception(StringsKt.trimIndent("\n  " + error.getString("message") + "\n  " + error.getString("stack") + "\n  ")));
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to end function tracking", th);
        }
    }

    public final void leaveBreadcrumb(@NotNull String breadcrumb, double mode, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(breadcrumb, "breadcrumb");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.leaveBreadcrumb(breadcrumb, (int) mode);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to leave breadcrumb", th);
        }
    }

    public final void unblockScreenshots(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.unblockScreenshots();
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to unblock screenshots.", th);
        }
    }

    public final void blockScreenshots(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.blockScreenshots();
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to block screenshots.", th);
        }
    }

    public final void screenshotsBlocked(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Instrumentation.screenshotsBlocked()));
        } catch (Throwable th) {
            promise.reject("Failed to check if screenshots are blocked.", th);
        }
    }

    public final void takeScreenshot(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.takeScreenshot();
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to take screenshot.", th);
        }
    }

    public final void setUserData(@NotNull String key, @NotNull String value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.setUserData(key, value);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set user data.", th);
        }
    }

    public final void removeUserData(@NotNull String key, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.setUserData(key, null);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to remove user data.", th);
        }
    }

    public final void setUserDataNumber(@NotNull String key, double value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.setUserDataDouble(key, Double.valueOf(value));
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set user data number.", th);
        }
    }

    public final void removeUserDataNumber(@NotNull String key, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.setUserDataDouble(key, null);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to remove user data number.", th);
        }
    }

    public final void setUserDataBoolean(@NotNull String key, boolean value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.setUserDataBoolean(key, Boolean.valueOf(value));
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set user data boolean.", th);
        }
    }

    public final void removeUserDataBoolean(@NotNull String key, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.setUserDataBoolean(key, null);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to remove user data boolean.", th);
        }
    }

    public final void setUserDataDate(@NotNull String key, @NotNull String valueStr, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(valueStr, "valueStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Long l = parseLong(valueStr);
            Intrinsics.checkNotNull(l);
            Instrumentation.setUserDataDate(key, new Date(l.longValue()));
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set user data date.", th);
        }
    }

    public final void removeUserDataDate(@NotNull String key, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.setUserDataDate(key, null);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed remove user data date.", th);
        }
    }

    public final void startNextSession(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.startNextSession();
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to start next session", th);
        }
    }

    public final void startSessionFrame(@NotNull String sessionFrameName, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(sessionFrameName, "sessionFrameName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            this.sessionFrames.put(string, Instrumentation.startSessionFrame(sessionFrameName));
            promise.resolve(string);
        } catch (Throwable th) {
            promise.reject("Failed to create session frame", th);
        }
    }

    public final void updateSessionFrameName(@NotNull String id, @NotNull String name, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            SessionFrame sessionFrame = (SessionFrame) this.sessionFrames.get(id);
            if (sessionFrame != null) {
                sessionFrame.updateName(name);
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to update session frame", th);
        }
    }

    public final void endSessionFrame(@NotNull String id, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            SessionFrame sessionFrame = (SessionFrame) this.sessionFrames.get(id);
            if (sessionFrame != null) {
                sessionFrame.end();
            }
            this.sessionFrames.remove(id);
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to end session frame", th);
        }
    }

    public final void trackUIEvent(@NotNull ReadableMap eventInfo, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(eventInfo, "eventInfo");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Instrumentation.trackUIEvent(eventInfo.getString("screenName"), eventInfo.getString("eventName"), eventInfo.getString("className"), Calendar.getInstance().getTimeInMillis(), eventInfo.getString("label"), eventInfo.getString(ViewProps.ACCESSIBILITY_LABEL), !eventInfo.hasKey("tag") ? 0 : eventInfo.getInt("tag"), eventInfo.getString("index"), eventInfo.getString("uiResponder"));
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to track UI event", th);
        }
    }

    public final void getServerCorrelationHeaders(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Map<String, List<String>> mapGenerate = ServerCorrelationHeaders.generate();
            Intrinsics.checkNotNull(mapGenerate);
            promise.resolve(convertToReadableMap(mapGenerate));
        } catch (Throwable th) {
            promise.reject("Failed to get server correlation headers", th);
        }
    }

    public final void getRequestTrackerWithUrl(@NotNull String urlString, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            this.customRequestTrackers.put(string, Instrumentation.beginHttpRequest(new URL(urlString)));
            promise.resolve(string);
        } catch (Throwable th) {
            promise.reject("Failed to create request tracker", th);
        }
    }

    public final void setRequestTrackerErrorInfo(@NotNull String trackerId, @NotNull ReadableMap errorDict, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(errorDict, "errorDict");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            String string = errorDict.getString("message");
            if (string == null) {
                string = "RN error without a message.";
            }
            HttpRequestTracker httpRequestTracker = (HttpRequestTracker) this.customRequestTrackers.get(trackerId);
            if (httpRequestTracker != null) {
                httpRequestTracker.withError(string);
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set request tracker error info", th);
        }
    }

    public final void setRequestTrackerStatusCode(@NotNull String trackerId, double statusCode, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            HttpRequestTracker httpRequestTracker = (HttpRequestTracker) this.customRequestTrackers.get(trackerId);
            if (httpRequestTracker != null) {
                httpRequestTracker.withResponseCode((int) statusCode);
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set request tracker status code", th);
        }
    }

    public final void setRequestTrackerResponseHeaders(@NotNull String trackerId, @NotNull ReadableMap responseHeaders, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : responseHeaders.toHashMap().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!(value instanceof String)) {
                    value = "undefined";
                }
                map.put(key, CollectionsKt.listOf(value));
            }
            HttpRequestTracker httpRequestTracker = (HttpRequestTracker) this.customRequestTrackers.get(trackerId);
            if (httpRequestTracker != null) {
                httpRequestTracker.withResponseHeaderFields(map);
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set request tracker response headers", th);
        }
    }

    public final void setRequestTrackerRequestHeaders(@NotNull String trackerId, @NotNull ReadableMap requestHeaders, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            HashMap map = new HashMap();
            for (Map.Entry<String, Object> entry : requestHeaders.toHashMap().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!(value instanceof String)) {
                    value = "undefined";
                }
                map.put(key, CollectionsKt.listOf(value));
            }
            HttpRequestTracker httpRequestTracker = (HttpRequestTracker) this.customRequestTrackers.get(trackerId);
            if (httpRequestTracker != null) {
                httpRequestTracker.withRequestHeaderFields(map);
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set request tracker request headers", th);
        }
    }

    public final void requestTrackerReport(@NotNull String trackerId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            HttpRequestTracker httpRequestTracker = (HttpRequestTracker) this.customRequestTrackers.get(trackerId);
            if (httpRequestTracker != null) {
                httpRequestTracker.reportDone();
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to report request tracker", th);
        }
    }

    public final void setRequestTrackerUserData(@NotNull String trackerId, @NotNull String key, @NotNull String value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            HttpRequestTracker httpRequestTracker = (HttpRequestTracker) this.customRequestTrackers.get(trackerId);
            if (httpRequestTracker != null) {
                httpRequestTracker.withUserData(key, value);
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set request tracker data", th);
        }
    }

    public final void setRequestTrackerUserDataNumber(@NotNull String trackerId, @NotNull String key, double value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            HttpRequestTracker httpRequestTracker = (HttpRequestTracker) this.customRequestTrackers.get(trackerId);
            if (httpRequestTracker != null) {
                httpRequestTracker.withUserDataDouble(key, Double.valueOf(value));
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set request tracker data", th);
        }
    }

    public final void setRequestTrackerUserDataBoolean(@NotNull String trackerId, @NotNull String key, boolean value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            HttpRequestTracker httpRequestTracker = (HttpRequestTracker) this.customRequestTrackers.get(trackerId);
            if (httpRequestTracker != null) {
                httpRequestTracker.withUserDataBoolean(key, Boolean.valueOf(value));
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set request tracker data", th);
        }
    }

    public final void setRequestTrackerUserDataDate(@NotNull String trackerId, @NotNull String key, double value, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(trackerId, "trackerId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            HttpRequestTracker httpRequestTracker = (HttpRequestTracker) this.customRequestTrackers.get(trackerId);
            if (httpRequestTracker != null) {
                httpRequestTracker.withUserDataDate(key, new Date((long) value));
            }
            promise.resolve(null);
        } catch (Throwable th) {
            promise.reject("Failed to set request tracker data", th);
        }
    }

    private final Long parseLong(String valueStr) {
        if (valueStr != null) {
            return Long.valueOf(Long.parseLong(valueStr, CharsKt.checkRadix(10)));
        }
        return null;
    }

    private final Set deserializeStringSet(ReadableArray readableArray) {
        Intrinsics.checkNotNull(readableArray);
        HashSet hashSet = new HashSet(readableArray.size());
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            if (WhenMappings.$EnumSwitchMapping$0[readableArray.getType(i).ordinal()] == 1) {
                hashSet.add(readableArray.getString(i));
            } else {
                hashSet.add(null);
            }
        }
        return hashSet;
    }

    private final Object[] deserializeArray(ReadableArray readableArray) {
        Object[] objArr = new Object[readableArray.size()];
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[readableArray.getType(i).ordinal()];
            if (i2 == 1) {
                objArr[i] = readableArray.getString(i);
            } else if (i2 == 2) {
                objArr[i] = null;
            } else if (i2 == 3) {
                objArr[i] = Boolean.valueOf(readableArray.getBoolean(i));
            } else if (i2 == 4) {
                objArr[i] = Double.valueOf(readableArray.getDouble(i));
            } else {
                System.out.println((Object) "deserializeArray else statement triggered.");
            }
        }
        return objArr;
    }

    private final Map deserializeMap(ReadableMap readableMap) {
        HashMap map = new HashMap();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            int i = WhenMappings.$EnumSwitchMapping$0[readableMap.getType(strNextKey).ordinal()];
            if (i == 1) {
                map.put(strNextKey, readableMap.getString(strNextKey));
            } else if (i == 2) {
                map.put(strNextKey, null);
            } else if (i == 3) {
                map.put(strNextKey, Boolean.valueOf(readableMap.getBoolean(strNextKey)));
            } else if (i == 4) {
                map.put(strNextKey, Double.valueOf(readableMap.getDouble(strNextKey)));
            } else {
                System.out.println((Object) "deserializeMap else statement triggered.");
            }
        }
        return map;
    }

    private final ReadableMap convertToReadableMap(Map map) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                writableMapCreateMap.putString(str, (String) value);
            } else if (value instanceof Integer) {
                writableMapCreateMap.putInt(str, ((Number) value).intValue());
            } else if (value instanceof Double) {
                writableMapCreateMap.putDouble(str, ((Number) value).doubleValue());
            } else if (value instanceof Boolean) {
                writableMapCreateMap.putBoolean(str, ((Boolean) value).booleanValue());
            } else if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                writableMapCreateMap.putMap(str, convertToReadableMap((Map) value));
            } else if (value instanceof List) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                writableMapCreateMap.putArray(str, convertToReadableArray((List) value));
            }
        }
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    private final ReadableArray convertToReadableArray(List list) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (Object obj : list) {
            if (obj instanceof String) {
                writableArrayCreateArray.pushString((String) obj);
            } else if (obj instanceof Integer) {
                writableArrayCreateArray.pushInt(((Number) obj).intValue());
            } else if (obj instanceof Double) {
                writableArrayCreateArray.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                writableArrayCreateArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Map) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                writableArrayCreateArray.pushMap(convertToReadableMap((Map) obj));
            } else if (obj instanceof List) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                writableArrayCreateArray.pushArray(convertToReadableArray((List) obj));
            }
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }
}
