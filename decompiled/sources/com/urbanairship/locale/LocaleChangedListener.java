package com.urbanairship.locale;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface LocaleChangedListener {
    void onLocaleChanged(@NonNull Locale locale);
}
