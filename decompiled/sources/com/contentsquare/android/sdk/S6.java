package com.contentsquare.android.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.contentsquare.android.core.utils.FileStorageUtil;
import java.io.File;

/* loaded from: classes2.dex */
public final class S6 {
    public final FileStorageUtil a;
    public final String b;

    public S6(@NonNull Context context) {
        FileStorageUtil fileStorageUtil = new FileStorageUtil();
        String absolutePath = context.getFilesDir().getAbsolutePath();
        this.a = fileStorageUtil;
        this.b = absolutePath + File.separator + "cs";
    }
}
