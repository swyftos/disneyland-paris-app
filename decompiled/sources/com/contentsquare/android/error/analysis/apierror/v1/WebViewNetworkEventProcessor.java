package com.contentsquare.android.error.analysis.apierror.v1;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.error.analysis.apierror.NetworkEventProcessor;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventCompressor;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventEncryptor;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventUrlProcessor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v1/WebViewNetworkEventProcessor;", "Lcom/contentsquare/android/error/analysis/apierror/NetworkEventProcessor;", "urlProcessor", "Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventUrlProcessor;", "eventCompressor", "Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventCompressor;", "encryptor", "Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventEncryptor;", "(Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventUrlProcessor;Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventCompressor;Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventEncryptor;)V", "processEvent", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "rawEvent", "setUrlMaskingPatterns", "", "patterns", "", "", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WebViewNetworkEventProcessor implements NetworkEventProcessor {

    @NotNull
    private final NetworkEventEncryptor encryptor;

    @NotNull
    private final NetworkEventCompressor eventCompressor;

    @NotNull
    private final NetworkEventUrlProcessor urlProcessor;

    public WebViewNetworkEventProcessor(NetworkEventUrlProcessor urlProcessor, NetworkEventCompressor eventCompressor, NetworkEventEncryptor encryptor) {
        Intrinsics.checkNotNullParameter(urlProcessor, "urlProcessor");
        Intrinsics.checkNotNullParameter(eventCompressor, "eventCompressor");
        Intrinsics.checkNotNullParameter(encryptor, "encryptor");
        this.urlProcessor = urlProcessor;
        this.eventCompressor = eventCompressor;
        this.encryptor = encryptor;
    }

    @Override // com.contentsquare.android.error.analysis.apierror.NetworkEventProcessor
    @Nullable
    public NetworkEvent processEvent(NetworkEvent rawEvent) {
        Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
        if (rawEvent.getStatusCode() < 400) {
            return null;
        }
        return this.encryptor.encrypt(this.eventCompressor.compress(this.urlProcessor.process(rawEvent)));
    }

    @Override // com.contentsquare.android.error.analysis.apierror.NetworkEventProcessor
    public void setUrlMaskingPatterns(List<String> patterns) {
        Intrinsics.checkNotNullParameter(patterns, "patterns");
    }
}
