package com.urbanairship.util;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes5.dex */
public interface PermissionsRequester {
    @NonNull
    int[] requestPermissions(@NonNull Context context, @NonNull List<String> list);
}
