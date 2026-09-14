package com.contentsquare.android.error.analysis.apierror.p019v1.processors;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.error.analysis.util.UrlExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, m1836d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventUrlProcessor;", "", "()V", "process", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "rawEvent", "error-analysis_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class NetworkEventUrlProcessor {
    @NotNull
    public final NetworkEvent process(NetworkEvent rawEvent) {
        Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
        return NetworkEvent.copy$default(rawEvent, 0L, null, UrlExtensionsKt.removeUrlParameters(rawEvent.getUrl()), 0, 0L, 0L, null, null, null, null, null, null, null, null, UrlExtensionsKt.extractQueryParameters(rawEvent.getUrl()), null, null, null, null, null, null, null, null, null, null, null, null, null, 268419067, null);
    }
}
