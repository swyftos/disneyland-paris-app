package com.urbanairship.android.framework.proxy.proxies;

import com.urbanairship.locale.LocaleManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LocaleProxy;", "", "localeProvider", "Lkotlin/Function0;", "Lcom/urbanairship/locale/LocaleManager;", "(Lkotlin/jvm/functions/Function0;)V", "clearLocale", "", "getCurrentLocale", "", "setCurrentLocale", "localeIdentifier", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class LocaleProxy {
    private final Function0 localeProvider;

    public LocaleProxy(@NotNull Function0<? extends LocaleManager> localeProvider) {
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        this.localeProvider = localeProvider;
    }

    public final void setCurrentLocale(@NotNull String localeIdentifier) {
        Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
        ((LocaleManager) this.localeProvider.invoke()).setLocaleOverride(Locale.forLanguageTag(localeIdentifier));
    }

    @NotNull
    public final String getCurrentLocale() {
        String string = ((LocaleManager) this.localeProvider.invoke()).getLocale().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void clearLocale() {
        ((LocaleManager) this.localeProvider.invoke()).setLocaleOverride(null);
    }
}
