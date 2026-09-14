package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.V */
/* JADX INFO: loaded from: classes2.dex */
public final class C2645V {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final FileStorageUtil f2185a;

    /* JADX INFO: renamed from: b */
    public final long f2186b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f2187c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final AtomicInteger f2188d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final String f2189e;

    public C2645V(String appFilesLocation) {
        FileStorageUtil storageUtil = new FileStorageUtil();
        Intrinsics.checkNotNullParameter(appFilesLocation, "appFilesLocation");
        Intrinsics.checkNotNullParameter(storageUtil, "storageUtil");
        this.f2185a = storageUtil;
        this.f2186b = 20971520L;
        this.f2187c = new Logger("BatchWriterReader");
        this.f2188d = new AtomicInteger(0);
        StringBuilder sb = new StringBuilder();
        sb.append(appFilesLocation);
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append("replay");
        this.f2189e = sb.toString();
    }
}
