package com.contentsquare.android.sdk;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nLogStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogStorage.kt\ncom/contentsquare/android/internal/core/logmonitor/processing/LogStorage\n+ 2 SerialFormat.kt\nkotlinx/serialization/SerialFormatKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,94:1\n113#2:95\n1549#3:96\n1620#3,2:97\n1622#3:100\n96#4:99\n*S KotlinDebug\n*F\n+ 1 LogStorage.kt\ncom/contentsquare/android/internal/core/logmonitor/processing/LogStorage\n*L\n37#1:95\n55#1:96\n55#1:97,2\n55#1:100\n56#1:99\n*E\n"})
/* loaded from: classes2.dex */
public final class P2 {

    @NotNull
    public final Context a;

    @NotNull
    public final FileStorageUtil b;

    @NotNull
    public final Logger c;

    @NotNull
    public final String d;

    @NotNull
    public final String e;

    public P2(@NotNull Context context, @NotNull FileStorageUtil fileStorageUtil) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        this.a = context;
        this.b = fileStorageUtil;
        this.c = new Logger("LogStorage");
        this.d = "logs";
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
        this.e = sb.toString();
    }

    @WorkerThread
    public final void a() {
        try {
            this.b.deleteFileOrFolder(this.e);
        } catch (Throwable th) {
            this.c.e("Failed to delete log file at path: " + this.e + " | error message: " + th.getMessage());
        }
    }
}
