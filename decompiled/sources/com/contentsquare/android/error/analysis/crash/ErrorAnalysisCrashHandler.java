package com.contentsquare.android.error.analysis.crash;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.CrashWrapped;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.proto.mobilestacktrace.v1.AndroidThreadReportKt;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\u001d\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\"\u001a\u00020\u0017H\u0082\u0010J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0002J!\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0002J\u0018\u0010/\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/contentsquare/android/error/analysis/crash/ErrorAnalysisCrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "chainedHandler", "appData", "Lcom/contentsquare/android/error/analysis/crash/ApplicationData;", "crashEventReporter", "Lcom/contentsquare/android/error/analysis/crash/CrashEventReporter;", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "(Ljava/lang/Thread$UncaughtExceptionHandler;Lcom/contentsquare/android/error/analysis/crash/ApplicationData;Lcom/contentsquare/android/error/analysis/crash/CrashEventReporter;Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;)V", "getChainedHandler", "()Ljava/lang/Thread$UncaughtExceptionHandler;", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "buildErrorStackTrace", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "thread", "Ljava/lang/Thread;", "throwable", "", "appPackage", "", "causeDepth", "", "compareJavaFrames", "", TypedValues.AttributesType.S_FRAME, "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame;", ETCPaymentMethod.OTHER, "gatherThreads", "", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Thread;", "getCauseDepth", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "result", "handleException", "", "incrementRepeatedCount", "removeRepeatedFrames", "list", "stackTraceToFrames", "stackTrace", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;)Ljava/util/List;", "threadToThreadData", "trimFrames", "uncaughtException", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nErrorAnalysisCrashHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ErrorAnalysisCrashHandler.kt\ncom/contentsquare/android/error/analysis/crash/ErrorAnalysisCrashHandler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 7 AndroidThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKtKt\n*L\n1#1,217:1\n1#2:218\n1#2:240\n1#2:242\n11425#3:219\n11536#3,4:220\n515#4:224\n500#4,6:225\n125#5:231\n152#5,3:232\n1549#6:235\n1620#6,3:236\n783#7:239\n789#7:241\n*S KotlinDebug\n*F\n+ 1 ErrorAnalysisCrashHandler.kt\ncom/contentsquare/android/error/analysis/crash/ErrorAnalysisCrashHandler\n*L\n202#1:240\n203#1:242\n120#1:219\n120#1:220,4\n154#1:224\n154#1:225,6\n155#1:231\n155#1:232,3\n157#1:235\n157#1:236,3\n202#1:239\n203#1:241\n*E\n"})
/* loaded from: classes2.dex */
public final class ErrorAnalysisCrashHandler implements Thread.UncaughtExceptionHandler {

    @NotNull
    private static final List<String> EXCEPTIONS_TO_IGNORE = CollectionsKt.listOf("com.facebook.react.common.JavascriptException");
    private static final int MAX_CAUSE_DEPTH = 8;
    private static final int MAX_FRAMES = 30;
    private static final int MAX_FRAMES_TO_KEEP_FROM_BOTTOM = 15;
    private static final int MAX_FRAMES_TO_KEEP_FROM_TOP = 15;
    private static final int MAX_THREADS_TO_KEEP = 64;

    @NotNull
    private final ApplicationData appData;

    @Nullable
    private final Thread.UncaughtExceptionHandler chainedHandler;

    @NotNull
    private final CrashEventReporter crashEventReporter;

    @NotNull
    private final ErrorAnalysisLibraryInterface libraryInterface;

    @NotNull
    private final Logger logger;

    public ErrorAnalysisCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, ApplicationData appData, CrashEventReporter crashEventReporter, ErrorAnalysisLibraryInterface libraryInterface) {
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(crashEventReporter, "crashEventReporter");
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        this.chainedHandler = uncaughtExceptionHandler;
        this.appData = appData;
        this.crashEventReporter = crashEventReporter;
        this.libraryInterface = libraryInterface;
        this.logger = new Logger("ErrorAnalysisCrashHandler");
    }

    private final MobileStacktrace.AndroidThreadReport.ErrorStacktrace buildErrorStackTrace(Thread thread, Throwable throwable, String appPackage, int causeDepth) {
        Throwable cause;
        MobileStacktrace.AndroidThreadReport.ErrorStacktrace errorStacktraceBuildErrorStackTrace = (causeDepth >= 8 || (cause = throwable.getCause()) == null) ? null : buildErrorStackTrace(thread, cause, appPackage, causeDepth + 1);
        int causeDepth$default = 0;
        if (errorStacktraceBuildErrorStackTrace == null && throwable.getCause() != null) {
            causeDepth$default = getCauseDepth$default(this, throwable, 0, 2, null);
        }
        MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Builder overflowCount = MobileStacktrace.AndroidThreadReport.ErrorStacktrace.newBuilder().setThreadId((int) thread.getId()).setOverflowCount(causeDepth$default);
        MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable.Builder builderNewBuilder = MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable.newBuilder();
        String message = throwable.getMessage();
        if (message == null) {
            message = "";
        }
        MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Builder exception = overflowCount.setException(builderNewBuilder.setMessage(message).setClass_(throwable.getClass().getName()).build());
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "throwable.stackTrace");
        MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Builder builderAddAllFrames = exception.addAllFrames(stackTraceToFrames(stackTrace));
        if (errorStacktraceBuildErrorStackTrace != null) {
            builderAddAllFrames.setCause(errorStacktraceBuildErrorStackTrace);
        }
        MobileStacktrace.AndroidThreadReport.ErrorStacktrace errorStacktraceBuild = builderAddAllFrames.build();
        Intrinsics.checkNotNullExpressionValue(errorStacktraceBuild, "builder.build()");
        return errorStacktraceBuild;
    }

    public static /* synthetic */ MobileStacktrace.AndroidThreadReport.ErrorStacktrace buildErrorStackTrace$default(ErrorAnalysisCrashHandler errorAnalysisCrashHandler, Thread thread, Throwable th, String str, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return errorAnalysisCrashHandler.buildErrorStackTrace(thread, th, str, i);
    }

    private final boolean compareJavaFrames(MobileStacktrace.AndroidThreadReport.Frame frame, MobileStacktrace.AndroidThreadReport.Frame other) {
        return Intrinsics.areEqual(frame.getJavaFrame().getFile(), other.getJavaFrame().getFile()) && Intrinsics.areEqual(frame.getJavaFrame().getClass_(), other.getJavaFrame().getClass_()) && Intrinsics.areEqual(frame.getJavaFrame().getMethod(), other.getJavaFrame().getMethod()) && frame.getJavaFrame().getLine() == other.getJavaFrame().getLine();
    }

    private final List<MobileStacktrace.AndroidThreadReport.Thread> gatherThreads() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Intrinsics.checkNotNullExpressionValue(allStackTraces, "getAllStackTraces()");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            StackTraceElement[] value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "stackTrace.value");
            if (!(value.length == 0)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((Thread) ((Map.Entry) it.next()).getKey());
        }
        List<Thread> listTake = CollectionsKt.take(arrayList, 64);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTake, 10));
        for (Thread it2 : listTake) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            arrayList2.add(threadToThreadData(it2));
        }
        return arrayList2;
    }

    private final int getCauseDepth(Throwable error, int result) {
        while (true) {
            if ((error != null ? error.getCause() : null) == null) {
                return result;
            }
            error = error.getCause();
            result++;
        }
    }

    public static /* synthetic */ int getCauseDepth$default(ErrorAnalysisCrashHandler errorAnalysisCrashHandler, Throwable th, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return errorAnalysisCrashHandler.getCauseDepth(th, i);
    }

    private final void handleException(Thread thread, Throwable throwable) {
        try {
            if (EXCEPTIONS_TO_IGNORE.contains(throwable.getClass().getName())) {
                this.logger.d("Discarding crash of type ".concat(throwable.getClass().getName()));
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            CrashBuilder crashBuilder = CrashBuilder.INSTANCE;
            ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface = this.libraryInterface;
            MobileStacktrace.ThreadReport threadReportBuild = MobileStacktrace.ThreadReport.newBuilder().setAndroid(MobileStacktrace.AndroidThreadReport.newBuilder().setPackageName(this.appData.getPackageName()).setApplicationVersion(this.appData.getVersionName()).setMappingVersion(this.appData.getNativeMappingVersion()).setErrorStacktrace(buildErrorStackTrace$default(this, thread, throwable, this.appData.getPackageName(), 0, 8, null)).addAllThreads(gatherThreads()).build()).build();
            Intrinsics.checkNotNullExpressionValue(threadReportBuild, "newBuilder().setAndroid(…                ).build()");
            this.crashEventReporter.saveCrashEvent(new CrashWrapped(jCurrentTimeMillis, crashBuilder.buildCrash(errorAnalysisLibraryInterface, threadReportBuild, "native", jCurrentTimeMillis)));
        } catch (Throwable th) {
            this.logger.e(th, "Failed to deal with crash");
        }
    }

    private final MobileStacktrace.AndroidThreadReport.Frame incrementRepeatedCount(MobileStacktrace.AndroidThreadReport.Frame frame) {
        int repeatedCount = frame.getJavaFrame().getRepeatedCount() + 1;
        AndroidThreadReportKt.FrameKt.Dsl.Companion companion = AndroidThreadReportKt.FrameKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.Frame.Builder builder = frame.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AndroidThreadReportKt.FrameKt.Dsl dsl_create = companion._create(builder);
        MobileStacktrace.AndroidThreadReport.JavaFrame javaFrame = frame.getJavaFrame();
        Intrinsics.checkNotNullExpressionValue(javaFrame, "frame.javaFrame");
        AndroidThreadReportKt.JavaFrameKt.Dsl.Companion companion2 = AndroidThreadReportKt.JavaFrameKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.JavaFrame.Builder builder2 = javaFrame.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder2, "this.toBuilder()");
        AndroidThreadReportKt.JavaFrameKt.Dsl dsl_create2 = companion2._create(builder2);
        dsl_create2.setRepeatedCount(repeatedCount);
        dsl_create.setJavaFrame(dsl_create2._build());
        return dsl_create._build();
    }

    private final List<MobileStacktrace.AndroidThreadReport.Frame> removeRepeatedFrames(List<MobileStacktrace.AndroidThreadReport.Frame> list) {
        if (list.size() <= 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        MobileStacktrace.AndroidThreadReport.Frame frameIncrementRepeatedCount = list.get(0);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            MobileStacktrace.AndroidThreadReport.Frame frame = list.get(i);
            if (compareJavaFrames(frameIncrementRepeatedCount, frame)) {
                frameIncrementRepeatedCount = incrementRepeatedCount(frameIncrementRepeatedCount);
            } else {
                arrayList.add(frameIncrementRepeatedCount);
                frameIncrementRepeatedCount = frame;
            }
        }
        arrayList.add(frameIncrementRepeatedCount);
        return arrayList;
    }

    private final List<MobileStacktrace.AndroidThreadReport.Frame> stackTraceToFrames(StackTraceElement[] stackTrace) {
        ArrayList arrayList = new ArrayList(stackTrace.length);
        int length = stackTrace.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            int i3 = i2 + 1;
            MobileStacktrace.AndroidThreadReport.JavaFrame.Builder frameId = MobileStacktrace.AndroidThreadReport.JavaFrame.newBuilder().setFrameId(i2);
            String fileName = stackTraceElement.getFileName();
            String str = "";
            if (fileName == null) {
                fileName = "";
            }
            MobileStacktrace.AndroidThreadReport.JavaFrame.Builder file = frameId.setFile(fileName);
            String className = stackTraceElement.getClassName();
            if (className == null) {
                className = "";
            }
            MobileStacktrace.AndroidThreadReport.JavaFrame.Builder class_ = file.setClass_(className);
            String methodName = stackTraceElement.getMethodName();
            if (methodName != null) {
                str = methodName;
            }
            arrayList.add(MobileStacktrace.AndroidThreadReport.Frame.newBuilder().setJavaFrame(class_.setMethod(str).setLine(stackTraceElement.getLineNumber()).setRepeatedCount(0).build()).build());
            i++;
            i2 = i3;
        }
        return trimFrames(removeRepeatedFrames(arrayList));
    }

    private final MobileStacktrace.AndroidThreadReport.Thread threadToThreadData(Thread thread) {
        MobileStacktrace.AndroidThreadReport.Thread.Builder threadName = MobileStacktrace.AndroidThreadReport.Thread.newBuilder().setThreadId((int) thread.getId()).setThreadName(thread.getName());
        StackTraceElement[] stackTrace = thread.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "thread.stackTrace");
        MobileStacktrace.AndroidThreadReport.Thread threadBuild = threadName.addAllFrames(stackTraceToFrames(stackTrace)).build();
        Intrinsics.checkNotNullExpressionValue(threadBuild, "newBuilder()\n           …ce))\n            .build()");
        return threadBuild;
    }

    private final List<MobileStacktrace.AndroidThreadReport.Frame> trimFrames(List<MobileStacktrace.AndroidThreadReport.Frame> list) {
        return list.size() <= 30 ? list : CollectionsKt.plus((Collection) CollectionsKt.take(list, 15), (Iterable) CollectionsKt.takeLast(list, 15));
    }

    @Nullable
    public final Thread.UncaughtExceptionHandler getChainedHandler() {
        return this.chainedHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable error) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(error, "error");
        handleException(thread, error);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.chainedHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, error);
        }
    }
}
