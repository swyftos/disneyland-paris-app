package com.contentsquare.android.error.analysis.apierror.v1.processors;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.error.analysis.util.ExtensionsKt;
import com.contentsquare.android.error.analysis.util.UrlExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventPIIAnonymizer;", "", "()V", "urlMaskingPatterns", "", "", "anonymize", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "event", "setUrlMaskingPatterns", "", "patterns", "", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkEventPIIAnonymizer {

    @NotNull
    private final List<String> urlMaskingPatterns = new ArrayList();

    @NotNull
    public final NetworkEvent anonymize(NetworkEvent event) {
        String strMaskUrl;
        Intrinsics.checkNotNullParameter(event, "event");
        String strAnonymizeFields = ExtensionsKt.anonymizeFields(UrlExtensionsKt.removeUrlParameters(event.getUrl()));
        synchronized (this.urlMaskingPatterns) {
            strMaskUrl = UrlExtensionsKt.maskUrl(strAnonymizeFields, this.urlMaskingPatterns);
        }
        return NetworkEvent.copy$default(event, 0L, null, strMaskUrl, 0, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 268435451, null);
    }

    public final void setUrlMaskingPatterns(List<String> patterns) {
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        synchronized (this.urlMaskingPatterns) {
            this.urlMaskingPatterns.clear();
            this.urlMaskingPatterns.addAll(patterns);
        }
    }
}
