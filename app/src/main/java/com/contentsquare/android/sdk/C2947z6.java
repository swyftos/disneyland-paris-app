package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.SystemInstantiable;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.z6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2947z6 {

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final String f3311f = "srm" + File.separator + "files";

    /* JADX INFO: renamed from: a */
    @NotNull
    public final FileStorageUtil f3312a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SystemInstantiable f3313b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f3314c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final AtomicInteger f3315d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final String f3316e;

    @JvmOverloads
    public C2947z6(@NotNull FileStorageUtil fileStorageUtil, @NotNull String filesLocation) {
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(filesLocation, "filesLocation");
        SystemInstantiable systemInstantiable = new SystemInstantiable();
        Logger logger = new Logger("SrmFileStorage");
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(filesLocation, "filesLocation");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f3312a = fileStorageUtil;
        this.f3313b = systemInstantiable;
        this.f3314c = logger;
        this.f3315d = new AtomicInteger(0);
        StringBuilder sb = new StringBuilder();
        sb.append(filesLocation);
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append(f3311f);
        this.f3316e = sb.toString();
    }
}
