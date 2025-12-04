package com.contentsquare.android.api.bridge.flutter;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.internal.crash.CrashUtils;
import com.contentsquare.android.sdk.C5;
import com.contentsquare.android.sdk.G0;
import com.contentsquare.android.sdk.Q2;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/contentsquare/android/api/bridge/flutter/FlutterCrashProcessor;", "", "crashBuilder", "Lcom/contentsquare/android/api/bridge/flutter/FlutterCrashBuilder;", "(Lcom/contentsquare/android/api/bridge/flutter/FlutterCrashBuilder;)V", "crashUtils", "Lcom/contentsquare/android/error/analysis/internal/crash/CrashUtils;", "getCrashUtils", "()Lcom/contentsquare/android/error/analysis/internal/crash/CrashUtils;", "setCrashUtils", "(Lcom/contentsquare/android/error/analysis/internal/crash/CrashUtils;)V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "parseReport", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport;", "data", "", "process", "", "reports", "", "processCrash", "crash", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash;", "timestamp", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFlutterCrashProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlutterCrashProcessor.kt\ncom/contentsquare/android/api/bridge/flutter/FlutterCrashProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n1855#2,2:50\n*S KotlinDebug\n*F\n+ 1 FlutterCrashProcessor.kt\ncom/contentsquare/android/api/bridge/flutter/FlutterCrashProcessor\n*L\n20#1:50,2\n*E\n"})
/* loaded from: classes2.dex */
public final class FlutterCrashProcessor {

    @NotNull
    private final FlutterCrashBuilder crashBuilder;

    @VisibleForTesting
    @NotNull
    private CrashUtils crashUtils;

    @NotNull
    private final Logger logger;

    public FlutterCrashProcessor(@NotNull FlutterCrashBuilder crashBuilder) {
        Intrinsics.checkNotNullParameter(crashBuilder, "crashBuilder");
        this.crashBuilder = crashBuilder;
        this.crashUtils = CrashUtils.INSTANCE;
        this.logger = new Logger("FlutterCrashProcessor");
    }

    private final MobileStacktrace.FlutterThreadReport parseReport(byte[] data) {
        try {
            return MobileStacktrace.FlutterThreadReport.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            Q2.a(this.logger, "Failed to build crash report", e);
            return null;
        }
    }

    private final void processCrash(MobileStacktrace.Crash crash, long timestamp) {
        C5 c5 = C5.k;
        if (c5 != null) {
            long crashId = crash.getCrashId();
            long relativeTime = crash.getRelativeTime();
            String errorSource = crash.getContext().getErrorSource();
            Intrinsics.checkNotNullExpressionValue(errorSource, "crash.context.errorSource");
            G0 event = new G0(timestamp, crashId, relativeTime, errorSource);
            Intrinsics.checkNotNullParameter(event, "event");
            c5.j.addCrashAndSaveToDisk(event);
        }
        this.crashUtils.saveCrashToDisk(crash);
    }

    @NotNull
    public final CrashUtils getCrashUtils() {
        return this.crashUtils;
    }

    public final void process(@NotNull List<byte[]> reports) {
        Intrinsics.checkNotNullParameter(reports, "reports");
        Iterator<T> it = reports.iterator();
        while (it.hasNext()) {
            MobileStacktrace.FlutterThreadReport report = parseReport((byte[]) it.next());
            if (report != null) {
                processCrash(this.crashBuilder.build(report), report.getTimestamp());
            }
        }
    }

    public final void setCrashUtils(@NotNull CrashUtils crashUtils) {
        Intrinsics.checkNotNullParameter(crashUtils, "<set-?>");
        this.crashUtils = crashUtils;
    }
}
