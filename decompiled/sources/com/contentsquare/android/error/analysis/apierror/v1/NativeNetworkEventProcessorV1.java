package com.contentsquare.android.error.analysis.apierror.v1;

import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.error.analysis.apierror.NetworkEventFilterKt;
import com.contentsquare.android.error.analysis.apierror.NetworkEventProcessor;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventCompressor;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventConfigurator;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventEncryptor;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventPIIAnonymizer;
import com.contentsquare.android.error.analysis.apierror.v1.processors.NetworkEventUrlProcessor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v1/NativeNetworkEventProcessorV1;", "Lcom/contentsquare/android/error/analysis/apierror/NetworkEventProcessor;", "urlProcessor", "Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventUrlProcessor;", "eventConfigurator", "Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventConfigurator;", "piiAnonymizer", "Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventPIIAnonymizer;", "eventCompressor", "Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventCompressor;", "encryptor", "Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventEncryptor;", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "(Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventUrlProcessor;Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventConfigurator;Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventPIIAnonymizer;Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventCompressor;Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventEncryptor;Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;)V", "processEvent", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "rawEvent", "setUrlMaskingPatterns", "", "patterns", "", "", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NativeNetworkEventProcessorV1 implements NetworkEventProcessor {

    @NotNull
    private final NetworkEventEncryptor encryptor;

    @NotNull
    private final NetworkEventCompressor eventCompressor;

    @NotNull
    private final NetworkEventConfigurator eventConfigurator;

    @NotNull
    private final ErrorAnalysisLibraryInterface libraryInterface;

    @NotNull
    private final NetworkEventPIIAnonymizer piiAnonymizer;

    @NotNull
    private final NetworkEventUrlProcessor urlProcessor;

    public NativeNetworkEventProcessorV1(NetworkEventUrlProcessor urlProcessor, NetworkEventConfigurator eventConfigurator, NetworkEventPIIAnonymizer piiAnonymizer, NetworkEventCompressor eventCompressor, NetworkEventEncryptor encryptor, ErrorAnalysisLibraryInterface libraryInterface) {
        Intrinsics.checkNotNullParameter(urlProcessor, "urlProcessor");
        Intrinsics.checkNotNullParameter(eventConfigurator, "eventConfigurator");
        Intrinsics.checkNotNullParameter(piiAnonymizer, "piiAnonymizer");
        Intrinsics.checkNotNullParameter(eventCompressor, "eventCompressor");
        Intrinsics.checkNotNullParameter(encryptor, "encryptor");
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        this.urlProcessor = urlProcessor;
        this.eventConfigurator = eventConfigurator;
        this.piiAnonymizer = piiAnonymizer;
        this.eventCompressor = eventCompressor;
        this.encryptor = encryptor;
        this.libraryInterface = libraryInterface;
    }

    @Override // com.contentsquare.android.error.analysis.apierror.NetworkEventProcessor
    @Nullable
    public NetworkEvent processEvent(NetworkEvent rawEvent) {
        JsonConfig.ProjectConfiguration projectConfig;
        Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
        if (rawEvent.getStatusCode() < 400) {
            return null;
        }
        Configuration configuration = this.libraryInterface.getConfiguration();
        JsonConfig.ApiErrors apiErrors = (configuration == null || (projectConfig = configuration.getProjectConfig()) == null) ? null : projectConfig.getApiErrors();
        NetworkEvent networkEventCompress = this.eventCompressor.compress(this.piiAnonymizer.anonymize(this.eventConfigurator.configure(this.urlProcessor.process(rawEvent), apiErrors)));
        return NetworkEventFilterKt.isValidUrl(networkEventCompress, apiErrors != null ? apiErrors.getValidUrls() : null) ? this.encryptor.encrypt(networkEventCompress) : networkEventCompress.copyWithoutDetails();
    }

    @Override // com.contentsquare.android.error.analysis.apierror.NetworkEventProcessor
    public void setUrlMaskingPatterns(List<String> patterns) {
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        this.piiAnonymizer.setUrlMaskingPatterns(patterns);
    }
}
