package androidx.ads.identifier;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class AdvertisingIdNotAvailableException extends Exception {
    public AdvertisingIdNotAvailableException(@NonNull String str) {
        super(str);
    }

    public AdvertisingIdNotAvailableException(@NonNull String str, @NonNull Throwable th) {
        super(str, th);
    }
}
