package com.urbanairship.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipComponent;
import com.urbanairship.UAirship;
import java.util.concurrent.Callable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class AirshipComponentUtils {
    @NonNull
    public static <T extends AirshipComponent> Callable<T> callableForComponent(@NonNull final Class<T> cls) {
        return new Callable() { // from class: com.urbanairship.util.AirshipComponentUtils.1
            @Override // java.util.concurrent.Callable
            public AirshipComponent call() {
                return UAirship.shared().requireComponent(cls);
            }
        };
    }
}
