package com.contentsquare.android.error.analysis.apierror.p020v2.collectors;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.error.analysis.util.ExtensionsKt;
import com.contentsquare.android.error.analysis.util.UrlExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¨\u0006\u0005"}, m1836d2 = {"collectUrlV2", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "urlMaskingPatterns", "", "", "error-analysis_release"}, m1837k = 2, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class UrlCollectorKt {
    @NotNull
    public static final NetworkEvent collectUrlV2(NetworkEvent networkEvent, List<String> urlMaskingPatterns) {
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        Intrinsics.checkNotNullParameter(urlMaskingPatterns, "urlMaskingPatterns");
        return NetworkEvent.copy$default(networkEvent, 0L, null, UrlExtensionsKt.maskUrl(ExtensionsKt.anonymizeFields(UrlExtensionsKt.removeUrlParameters(networkEvent.getUrl())), urlMaskingPatterns), 0, 0L, 0L, null, null, null, null, null, null, null, null, UrlExtensionsKt.extractQueryParameters(networkEvent.getUrl()), null, null, null, null, null, null, null, null, null, null, null, null, null, 268419067, null);
    }
}
