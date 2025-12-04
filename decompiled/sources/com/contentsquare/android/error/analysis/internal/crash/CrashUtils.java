package com.contentsquare.android.error.analysis.internal.crash;

import android.app.Application;
import android.content.Context;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.GzipUtil;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.Q2;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/contentsquare/android/error/analysis/internal/crash/CrashUtils;", "", "()V", "CRASH_EVENT_CONTAINER", "", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "storagePath", "getStoragePath", "()Ljava/lang/String;", "storageUtil", "Lcom/contentsquare/android/core/utils/FileStorageUtil;", "crashEventToZippedBytes", "", "crashEvent", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash;", "getPendingCrashFiles", "", "logCrash", "", "crashData", "saveCrashToDisk", "crash", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCrashUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrashUtils.kt\ncom/contentsquare/android/error/analysis/internal/crash/CrashUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,70:1\n1549#2:71\n1620#2,3:72\n*S KotlinDebug\n*F\n+ 1 CrashUtils.kt\ncom/contentsquare/android/error/analysis/internal/crash/CrashUtils\n*L\n26#1:71\n26#1:72,3\n*E\n"})
/* loaded from: classes2.dex */
public final class CrashUtils {

    @NotNull
    private static final String CRASH_EVENT_CONTAINER = "crashes";

    @NotNull
    public static final CrashUtils INSTANCE = new CrashUtils();

    @NotNull
    private static final Logger logger = new Logger("CrashEventWriterReader");

    @NotNull
    private static final FileStorageUtil storageUtil = new FileStorageUtil();

    private CrashUtils() {
    }

    private final byte[] crashEventToZippedBytes(MobileStacktrace.Crash crashEvent) {
        GzipUtil gzipUtil = GzipUtil.INSTANCE;
        byte[] byteArray = crashEvent.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "crashEvent.toByteArray()");
        return GzipUtil.compress$default(gzipUtil, byteArray, null, 2, null);
    }

    private final String getStoragePath() {
        Application application;
        Context applicationContext;
        File filesDir;
        StringBuilder sb = new StringBuilder();
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        sb.append((csApplicationModule == null || (application = csApplicationModule.getApplication()) == null || (applicationContext = application.getApplicationContext()) == null || (filesDir = applicationContext.getFilesDir()) == null) ? null : filesDir.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append(CRASH_EVENT_CONTAINER);
        return sb.toString();
    }

    @NotNull
    public final List<String> getPendingCrashFiles() {
        ArrayList arrayList;
        List listAsList;
        String[] strArrListFolder = storageUtil.listFolder(getStoragePath());
        if (strArrListFolder == null || (listAsList = ArraysKt.asList(strArrListFolder)) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAsList, 10));
            Iterator it = listAsList.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.getStoragePath() + File.separator + ((String) it.next()));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    public final void logCrash(@NotNull byte[] crashData) {
        Intrinsics.checkNotNullParameter(crashData, "crashData");
        try {
            MobileStacktrace.Crash from = MobileStacktrace.Crash.parseFrom(GzipUtil.INSTANCE.decompress(crashData));
            String str = Intrinsics.areEqual(from.getContext().getErrorSource(), "reactNative") ? "ReactNative " : "";
            logger.i(str + "Crash event detected and sent for userID: \"" + from.getContext().getUserId() + "\" session: [" + from.getContext().getSessionNumber() + "] on screen: [" + from.getContext().getViewNumber() + "] crashID: [" + from.getCrashId() + AbstractJsonLexerKt.END_LIST);
        } catch (IOException e) {
            Q2.a(logger, "Failed to read crash file", e);
        }
    }

    public final void saveCrashToDisk(@NotNull MobileStacktrace.Crash crash) {
        Intrinsics.checkNotNullParameter(crash, "crash");
        try {
            byte[] bArrCrashEventToZippedBytes = crashEventToZippedBytes(crash);
            String str = getStoragePath() + File.separator + crash.getCrashId();
            logger.d("Saving crash to event to file: " + str);
            FileStorageUtil fileStorageUtil = storageUtil;
            fileStorageUtil.mkdirs(getStoragePath());
            fileStorageUtil.writeBytesToFile(str, bArrCrashEventToZippedBytes, true);
        } catch (IOException e) {
            Q2.a(logger, "Failed to write crash event to file", e);
        }
    }
}
