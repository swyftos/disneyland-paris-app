package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class V {

    @NotNull
    public final FileStorageUtil a;
    public final long b;

    @NotNull
    public final Logger c;

    @NotNull
    public final AtomicInteger d;

    @NotNull
    public final String e;

    public V(String appFilesLocation) {
        FileStorageUtil storageUtil = new FileStorageUtil();
        Intrinsics.checkNotNullParameter(appFilesLocation, "appFilesLocation");
        Intrinsics.checkNotNullParameter(storageUtil, "storageUtil");
        this.a = storageUtil;
        this.b = 20971520L;
        this.c = new Logger("BatchWriterReader");
        this.d = new AtomicInteger(0);
        StringBuilder sb = new StringBuilder();
        sb.append(appFilesLocation);
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append("replay");
        this.e = sb.toString();
    }
}
