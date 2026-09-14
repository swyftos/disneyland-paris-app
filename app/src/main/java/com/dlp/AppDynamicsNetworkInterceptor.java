package com.dlp;

import com.appdynamics.eumagent.runtime.HttpRequestTracker;
import java.net.URL;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1836d2 = {"Lcom/dlp/AppDynamicsNetworkInterceptor;", "", "<init>", "()V", "mask", "", "httpRequestTracker", "Lcom/appdynamics/eumagent/runtime/HttpRequestTracker;", "1017160256_prod_fr.disneylandparis.android_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class AppDynamicsNetworkInterceptor {

    @NotNull
    public static final AppDynamicsNetworkInterceptor INSTANCE = new AppDynamicsNetworkInterceptor();

    private AppDynamicsNetworkInterceptor() {
    }

    public final boolean mask(@NotNull HttpRequestTracker httpRequestTracker) {
        Intrinsics.checkNotNullParameter(httpRequestTracker, "httpRequestTracker");
        String string = httpRequestTracker.getURL().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Iterator<AppDynamicsMaskRule> it = AppDynamicsMaskRule.INSTANCE.getDefaultRules().iterator();
        while (it.hasNext()) {
            string = it.next().apply(string);
        }
        try {
            httpRequestTracker.withURL(new URL(string));
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
