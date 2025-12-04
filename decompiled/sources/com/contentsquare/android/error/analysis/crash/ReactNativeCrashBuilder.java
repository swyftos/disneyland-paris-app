package com.contentsquare.android.error.analysis.crash;

import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.CrashWrapped;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.bouncycastle.i18n.ErrorBundle;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0014H\u0002J*\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/contentsquare/android/error/analysis/crash/ReactNativeCrashBuilder;", "", "()V", "KEY_APP_INFO", "", "KEY_COLUMN", "KEY_DESCRIPTION", "KEY_EXCEPTION", "KEY_FILE", "KEY_FRAMES", "KEY_FRAME_ID", "KEY_JS_VERSION", "KEY_LINE_NUMBER", "KEY_MAPPING_FILE_ID", "KEY_METHOD_NAME", "KEY_TIMESTAMP", "KEY_TYPE", "buildAppInfo", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo;", ErrorBundle.DETAIL_ENTRY, "", "applicationData", "Lcom/contentsquare/android/error/analysis/crash/ApplicationData;", "buildException", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception;", "buildFrame", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Frame;", "frameMap", "buildReactNativeCrash", "Lcom/contentsquare/android/core/communication/error/analysis/CrashWrapped;", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactNativeCrashBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactNativeCrashBuilder.kt\ncom/contentsquare/android/error/analysis/crash/ReactNativeCrashBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1603#2,9:94\n1855#2:103\n1856#2:106\n1612#2:107\n1#3:104\n1#3:105\n*S KotlinDebug\n*F\n+ 1 ReactNativeCrashBuilder.kt\ncom/contentsquare/android/error/analysis/crash/ReactNativeCrashBuilder\n*L\n72#1:94,9\n72#1:103\n72#1:106\n72#1:107\n72#1:105\n*E\n"})
/* loaded from: classes2.dex */
public final class ReactNativeCrashBuilder {

    @NotNull
    public static final ReactNativeCrashBuilder INSTANCE = new ReactNativeCrashBuilder();

    @NotNull
    private static final String KEY_APP_INFO = "appInfo";

    @NotNull
    private static final String KEY_COLUMN = "column";

    @NotNull
    private static final String KEY_DESCRIPTION = "description";

    @NotNull
    private static final String KEY_EXCEPTION = "exception";

    @NotNull
    private static final String KEY_FILE = "file";

    @NotNull
    private static final String KEY_FRAMES = "frames";

    @NotNull
    private static final String KEY_FRAME_ID = "frameId";

    @NotNull
    private static final String KEY_JS_VERSION = "jsVersion";

    @NotNull
    private static final String KEY_LINE_NUMBER = "lineNumber";

    @NotNull
    private static final String KEY_MAPPING_FILE_ID = "mappingFileId";

    @NotNull
    private static final String KEY_METHOD_NAME = "methodName";

    @NotNull
    private static final String KEY_TIMESTAMP = "timestamp";

    @NotNull
    private static final String KEY_TYPE = "type";

    private ReactNativeCrashBuilder() {
    }

    private final MobileStacktrace.ReactNativeThreadReport.AppInfo buildAppInfo(Map<String, ? extends Object> details, ApplicationData applicationData) {
        Object obj = details.get(KEY_APP_INFO);
        Map map = obj instanceof Map ? (Map) obj : null;
        MobileStacktrace.ReactNativeThreadReport.AppInfo.Builder version = MobileStacktrace.ReactNativeThreadReport.AppInfo.newBuilder().setBuildNumber(String.valueOf(applicationData.getVersionCode())).setPackageName(applicationData.getPackageName()).setVersion(applicationData.getVersionName());
        Object obj2 = map != null ? map.get(KEY_JS_VERSION) : null;
        if ((obj2 instanceof String ? (String) obj2 : null) != null) {
            Object obj3 = map.get(KEY_JS_VERSION);
            version.setJsVersion(obj3 instanceof String ? (String) obj3 : null);
        }
        MobileStacktrace.ReactNativeThreadReport.AppInfo appInfoBuild = version.build();
        Intrinsics.checkNotNullExpressionValue(appInfoBuild, "builder.build()");
        return appInfoBuild;
    }

    private final MobileStacktrace.ReactNativeThreadReport.Exception buildException(Map<String, ? extends Object> details) {
        Object obj = details.get(KEY_EXCEPTION);
        List listEmptyList = null;
        Map map = obj instanceof Map ? (Map) obj : null;
        Object obj2 = map != null ? map.get("type") : null;
        String str = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map != null ? map.get(KEY_DESCRIPTION) : null;
        String str2 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map != null ? map.get("frames") : null;
        List list = obj4 instanceof List ? (List) obj4 : null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj5 : list) {
                Map<?, ?> map2 = obj5 instanceof Map ? (Map) obj5 : null;
                MobileStacktrace.ReactNativeThreadReport.Frame frameBuildFrame = map2 != null ? INSTANCE.buildFrame(map2) : null;
                if (frameBuildFrame != null) {
                    arrayList.add(frameBuildFrame);
                }
            }
            listEmptyList = arrayList;
        }
        MobileStacktrace.ReactNativeThreadReport.Exception.Builder builderNewBuilder = MobileStacktrace.ReactNativeThreadReport.Exception.newBuilder();
        if (str2 == null) {
            str2 = "";
        }
        MobileStacktrace.ReactNativeThreadReport.Exception.Builder description = builderNewBuilder.setDescription(str2);
        if (str == null) {
            str = "";
        }
        MobileStacktrace.ReactNativeThreadReport.Exception.Builder type = description.setType(str);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        MobileStacktrace.ReactNativeThreadReport.Exception exceptionBuild = type.addAllFrames(listEmptyList).build();
        Intrinsics.checkNotNullExpressionValue(exceptionBuild, "newBuilder()\n           …y())\n            .build()");
        return exceptionBuild;
    }

    private final MobileStacktrace.ReactNativeThreadReport.Frame buildFrame(Map<?, ?> frameMap) {
        MobileStacktrace.ReactNativeThreadReport.Frame.Builder builderNewBuilder = MobileStacktrace.ReactNativeThreadReport.Frame.newBuilder();
        Object obj = frameMap.get("column");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        MobileStacktrace.ReactNativeThreadReport.Frame.Builder column = builderNewBuilder.setColumn(num != null ? num.intValue() : 0);
        Object obj2 = frameMap.get("file");
        String str = obj2 instanceof String ? (String) obj2 : null;
        if (str == null) {
            str = "";
        }
        MobileStacktrace.ReactNativeThreadReport.Frame.Builder file = column.setFile(str);
        Object obj3 = frameMap.get("methodName");
        String str2 = obj3 instanceof String ? (String) obj3 : null;
        MobileStacktrace.ReactNativeThreadReport.Frame.Builder methodName = file.setMethodName(str2 != null ? str2 : "");
        Object obj4 = frameMap.get(KEY_FRAME_ID);
        Integer num2 = obj4 instanceof Integer ? (Integer) obj4 : null;
        MobileStacktrace.ReactNativeThreadReport.Frame.Builder frameId = methodName.setFrameId(num2 != null ? num2.intValue() : 0);
        Object obj5 = frameMap.get("lineNumber");
        Integer num3 = obj5 instanceof Integer ? (Integer) obj5 : null;
        MobileStacktrace.ReactNativeThreadReport.Frame frameBuild = frameId.setLineNumber(num3 != null ? num3.intValue() : 0).build();
        Intrinsics.checkNotNullExpressionValue(frameBuild, "newBuilder()\n           …: 0)\n            .build()");
        return frameBuild;
    }

    @NotNull
    public final CrashWrapped buildReactNativeCrash(ErrorAnalysisLibraryInterface libraryInterface, Map<String, ? extends Object> details, ApplicationData applicationData) {
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(applicationData, "applicationData");
        Object obj = details.get("timestamp");
        Long l = obj instanceof Long ? (Long) obj : null;
        long jLongValue = l != null ? l.longValue() : System.currentTimeMillis();
        Object obj2 = details.get(KEY_MAPPING_FILE_ID);
        String str = obj2 instanceof String ? (String) obj2 : null;
        CrashBuilder crashBuilder = CrashBuilder.INSTANCE;
        MobileStacktrace.ThreadReport.Builder builderNewBuilder = MobileStacktrace.ThreadReport.newBuilder();
        MobileStacktrace.ReactNativeThreadReport.Builder timestamp = MobileStacktrace.ReactNativeThreadReport.newBuilder().setAppInfo(buildAppInfo(details, applicationData)).setException(buildException(details)).setTimestamp(jLongValue);
        if (str == null) {
            str = "";
        }
        MobileStacktrace.ThreadReport threadReportBuild = builderNewBuilder.setReactNative(timestamp.setMappingFileId(str).build()).build();
        Intrinsics.checkNotNullExpressionValue(threadReportBuild, "newBuilder().setReactNat…d()\n            ).build()");
        return new CrashWrapped(jLongValue, crashBuilder.buildCrash(libraryInterface, threadReportBuild, "reactNative", jLongValue));
    }
}
