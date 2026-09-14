package com.urbanairship.locale;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface LocaleChangedListener {
    void onLocaleChanged(@NonNull Locale locale);
}
