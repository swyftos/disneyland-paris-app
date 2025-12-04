package androidx.webkit;

import androidx.annotation.RestrictTo;

/* loaded from: classes2.dex */
public abstract class SafeBrowsingResponseCompat {
    public abstract void backToSafety(boolean z);

    public abstract void proceed(boolean z);

    public abstract void showInterstitial(boolean z);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public SafeBrowsingResponseCompat() {
    }
}
