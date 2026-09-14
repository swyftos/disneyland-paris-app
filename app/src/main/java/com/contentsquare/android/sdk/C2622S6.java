package com.contentsquare.android.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.contentsquare.android.core.utils.FileStorageUtil;
import java.io.File;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.S6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2622S6 {

    /* JADX INFO: renamed from: a */
    public final FileStorageUtil f2099a;

    /* JADX INFO: renamed from: b */
    public final String f2100b;

    public C2622S6(@NonNull Context context) {
        FileStorageUtil fileStorageUtil = new FileStorageUtil();
        String absolutePath = context.getFilesDir().getAbsolutePath();
        this.f2099a = fileStorageUtil;
        this.f2100b = absolutePath + File.separator + "cs";
    }
}
