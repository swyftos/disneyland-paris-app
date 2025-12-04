package androidx.autofill.inline.common;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(api = 30)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public abstract class BundledStyle {

    @NonNull
    protected final Bundle mBundle;

    @NonNull
    protected abstract String getStyleKey();

    protected BundledStyle(@NonNull Bundle bundle) {
        this.mBundle = bundle;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Bundle getBundle() {
        return this.mBundle;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isValid() {
        Bundle bundle = this.mBundle;
        return bundle != null && bundle.getBoolean(getStyleKey(), false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void assertIsValid() {
        if (isValid()) {
            return;
        }
        throw new IllegalStateException("Invalid style, missing bundle key " + getStyleKey());
    }

    public static abstract class Builder<T extends BundledStyle> {

        @NonNull
        protected final Bundle mBundle;

        @NonNull
        public abstract T build();

        protected Builder(@NonNull String str) {
            Bundle bundle = new Bundle();
            this.mBundle = bundle;
            bundle.putBoolean(str, true);
        }
    }
}
