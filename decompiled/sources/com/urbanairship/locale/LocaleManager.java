package com.urbanairship.locale;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.ConfigurationCompat;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class LocaleManager {
    public static final String LOCALE_OVERRIDE_COUNTRY_KEY = "com.urbanairship.LOCALE_OVERRIDE_COUNTRY";
    public static final String LOCALE_OVERRIDE_LANGUAGE_KEY = "com.urbanairship.LOCALE_OVERRIDE_LANGUAGE";
    public static final String LOCALE_OVERRIDE_VARIANT_KEY = "com.urbanairship.LOCALE_OVERRIDE_VARIANT";
    private final Context context;
    private volatile Locale deviceLocale;
    private final List localeChangedListeners = new CopyOnWriteArrayList();
    private final PreferenceDataStore preferenceDataStore;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public LocaleManager(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore) {
        this.preferenceDataStore = preferenceDataStore;
        this.context = context.getApplicationContext();
    }

    public void addListener(@NonNull LocaleChangedListener localeChangedListener) {
        this.localeChangedListeners.add(localeChangedListener);
    }

    public void removeListener(@NonNull LocaleChangedListener localeChangedListener) {
        this.localeChangedListeners.remove(localeChangedListener);
    }

    void onDeviceLocaleChanged() {
        synchronized (this) {
            try {
                this.deviceLocale = ConfigurationCompat.getLocales(this.context.getResources().getConfiguration()).get(0);
                UALog.d("Device Locale changed. Locale: %s.", this.deviceLocale);
                if (getLocaleOverride() == null) {
                    notifyLocaleChanged(this.deviceLocale);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void notifyLocaleChanged(Locale locale) {
        Iterator it = this.localeChangedListeners.iterator();
        while (it.hasNext()) {
            ((LocaleChangedListener) it.next()).onLocaleChanged(locale);
        }
    }

    public void setLocaleOverride(@Nullable Locale locale) {
        synchronized (this) {
            try {
                Locale locale2 = getLocale();
                if (locale != null) {
                    this.preferenceDataStore.put(LOCALE_OVERRIDE_COUNTRY_KEY, locale.getCountry());
                    this.preferenceDataStore.put(LOCALE_OVERRIDE_LANGUAGE_KEY, locale.getLanguage());
                    this.preferenceDataStore.put(LOCALE_OVERRIDE_VARIANT_KEY, locale.getVariant());
                } else {
                    this.preferenceDataStore.remove(LOCALE_OVERRIDE_COUNTRY_KEY);
                    this.preferenceDataStore.remove(LOCALE_OVERRIDE_LANGUAGE_KEY);
                    this.preferenceDataStore.remove(LOCALE_OVERRIDE_VARIANT_KEY);
                }
                if (locale2 != getLocale()) {
                    notifyLocaleChanged(getLocale());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Locale getLocaleOverride() {
        String string = this.preferenceDataStore.getString(LOCALE_OVERRIDE_LANGUAGE_KEY, null);
        String string2 = this.preferenceDataStore.getString(LOCALE_OVERRIDE_COUNTRY_KEY, null);
        String string3 = this.preferenceDataStore.getString(LOCALE_OVERRIDE_VARIANT_KEY, null);
        if (string == null || string2 == null || string3 == null) {
            return null;
        }
        return new Locale(string, string2, string3);
    }

    @NonNull
    public Locale getLocale() {
        if (getLocaleOverride() != null) {
            return getLocaleOverride();
        }
        if (this.deviceLocale == null) {
            this.deviceLocale = ConfigurationCompat.getLocales(this.context.getResources().getConfiguration()).get(0);
        }
        return this.deviceLocale;
    }
}
