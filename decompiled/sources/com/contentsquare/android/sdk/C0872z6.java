package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.FileStorageUtil;
import com.contentsquare.android.core.utils.SystemInstantiable;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.z6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0872z6 {

    @NotNull
    public static final String f = "srm" + File.separator + "files";

    @NotNull
    public final FileStorageUtil a;

    @NotNull
    public final SystemInstantiable b;

    @NotNull
    public final Logger c;

    @NotNull
    public final AtomicInteger d;

    @NotNull
    public final String e;

    @JvmOverloads
    public C0872z6(@NotNull FileStorageUtil fileStorageUtil, @NotNull String filesLocation) {
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(filesLocation, "filesLocation");
        SystemInstantiable systemInstantiable = new SystemInstantiable();
        Logger logger = new Logger("SrmFileStorage");
        Intrinsics.checkNotNullParameter(fileStorageUtil, "fileStorageUtil");
        Intrinsics.checkNotNullParameter(filesLocation, "filesLocation");
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = fileStorageUtil;
        this.b = systemInstantiable;
        this.c = logger;
        this.d = new AtomicInteger(0);
        StringBuilder sb = new StringBuilder();
        sb.append(filesLocation);
        String str = File.separator;
        sb.append(str);
        sb.append("cs");
        sb.append(str);
        sb.append(f);
        this.e = sb.toString();
    }
}
