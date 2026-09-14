package com.allegion.core.utility;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m1836d2 = {"Lcom/allegion/core/utility/SystemUtility;", "", "()V", "getSDKVersion", "", "AlBle_release"}, m1837k = 1, m1838mv = {1, 1, 15})
public final class SystemUtility {
    public static final SystemUtility INSTANCE = new SystemUtility();

    private SystemUtility() {
    }

    public final int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }
}
