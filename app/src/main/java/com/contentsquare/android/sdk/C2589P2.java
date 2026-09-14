package com.contentsquare.android.sdk;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.P2 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nLogStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogStorage.kt\ncom/contentsquare/android/internal/core/logmonitor/processing/LogStorage\n+ 2 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,94:1\n113#2:95\n1549#3:96\n1620#3,2:97\n1622#3:100\n96#4:99\n*S KotlinDebug\n*F\n+ 1 LogStorage.kt\ncom/contentsquare/android/internal/core/logmonitor/processing/LogStorage\n*L\n37#1:95\n55#1:96\n55#1:97,2\n55#1:100\n56#1:99\n*E\n"})
public final class C2589P2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Context f1956a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final FileStorageUtil f1957b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f1958c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final String f1959d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final String f1960e;

    public C2589P2(@NotNull Context context, @NotNull FileStorageUtil fileStorageUtil) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        this.f1956a = context;
        this.f1957b = fileStorageUtil;
        this.f1958c = new Logger("LogStorage");
        this.f1959d = "logs";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("cs");
        sb2.append(str);
        sb2.append("logs");
        sb.append(sb2.toString());
        sb.append(str);
        sb.append("logfile");
        this.f1960e = sb.toString();
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void m1001a() {
        try {
            this.f1957b.deleteFileOrFolder(this.f1960e);
        } catch (Throwable th) {
            this.f1958c.m829e("Failed to delete log file at path: " + this.f1960e + " | error message: " + th.getMessage());
        }
    }
}
