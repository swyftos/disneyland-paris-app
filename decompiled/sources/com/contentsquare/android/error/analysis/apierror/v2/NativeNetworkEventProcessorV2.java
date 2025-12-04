package com.contentsquare.android.error.analysis.apierror.v2;

import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.error.analysis.apierror.NetworkEventProcessor;
import com.contentsquare.android.error.analysis.apierror.encryption.AsymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.encryption.SymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.v2.collectors.BodyAttributeCollectorKt;
import com.contentsquare.android.error.analysis.apierror.v2.collectors.HeaderCollectorKt;
import com.contentsquare.android.error.analysis.apierror.v2.collectors.MetaDataCollectorKt;
import com.contentsquare.android.error.analysis.apierror.v2.collectors.QueryParamCollectorKt;
import com.contentsquare.android.error.analysis.apierror.v2.collectors.UrlCollectorKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/NativeNetworkEventProcessorV2;", "Lcom/contentsquare/android/error/analysis/apierror/NetworkEventProcessor;", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "asymmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/AsymmetricCryptor;", "symmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "msTimer", "Lkotlin/Function0;", "", "(Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;Lcom/contentsquare/android/error/analysis/apierror/encryption/AsymmetricCryptor;Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;Lkotlin/jvm/functions/Function0;)V", "performanceManager", "Lcom/contentsquare/android/error/analysis/apierror/v2/EventProcessorPerformanceManager;", "telemetrySender", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;", "urlMaskingPatterns", "", "", "processEvent", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "rawEvent", "setUrlMaskingPatterns", "", "patterns", "", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NativeNetworkEventProcessorV2 implements NetworkEventProcessor {

    @NotNull
    private final AsymmetricCryptor asymmetricCryptor;

    @NotNull
    private final ErrorAnalysisLibraryInterface libraryInterface;

    @NotNull
    private final EventProcessorPerformanceManager performanceManager;

    @NotNull
    private final SymmetricCryptor symmetricCryptor;

    @NotNull
    private final ApiErrorTelemetrySender telemetrySender;

    @NotNull
    private final List<String> urlMaskingPatterns;

    public NativeNetworkEventProcessorV2(ErrorAnalysisLibraryInterface libraryInterface, AsymmetricCryptor asymmetricCryptor, SymmetricCryptor symmetricCryptor, Function0<Long> msTimer) {
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        Intrinsics.checkNotNullParameter(asymmetricCryptor, "asymmetricCryptor");
        Intrinsics.checkNotNullParameter(symmetricCryptor, "symmetricCryptor");
        Intrinsics.checkNotNullParameter(msTimer, "msTimer");
        this.libraryInterface = libraryInterface;
        this.asymmetricCryptor = asymmetricCryptor;
        this.symmetricCryptor = symmetricCryptor;
        ApiErrorTelemetrySender apiErrorTelemetrySender = new ApiErrorTelemetrySender(libraryInterface);
        this.telemetrySender = apiErrorTelemetrySender;
        this.urlMaskingPatterns = new ArrayList();
        this.performanceManager = new EventProcessorPerformanceManager(msTimer, apiErrorTelemetrySender);
    }

    @Override // com.contentsquare.android.error.analysis.apierror.NetworkEventProcessor
    @Nullable
    public NetworkEvent processEvent(NetworkEvent rawEvent) {
        Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
        return this.performanceManager.processEvent(rawEvent, new Function2<NetworkEvent, Boolean, NetworkEvent>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.NativeNetworkEventProcessorV2.processEvent.1
            {
                super(2);
            }

            @Nullable
            public final NetworkEvent invoke(NetworkEvent event, boolean z) {
                NetworkEvent networkEventCollectUrlV2;
                Intrinsics.checkNotNullParameter(event, "event");
                LazyBodyHolder lazyBodyHolder = new LazyBodyHolder(event, NativeNetworkEventProcessorV2.this.telemetrySender);
                Configuration configuration = NativeNetworkEventProcessorV2.this.libraryInterface.getConfiguration();
                JsonConfig.ProjectConfiguration projectConfig = configuration != null ? configuration.getProjectConfig() : null;
                AggregatedRules aggregatedRulesAggregateRules = ApiErrorRuleMatcher.INSTANCE.aggregateRules(event, projectConfig != null ? projectConfig.getApiErrorsV2() : null, lazyBodyHolder);
                if (aggregatedRulesAggregateRules == null) {
                    return null;
                }
                NativeNetworkEventProcessorV2 nativeNetworkEventProcessorV2 = NativeNetworkEventProcessorV2.this;
                synchronized (nativeNetworkEventProcessorV2.urlMaskingPatterns) {
                    networkEventCollectUrlV2 = UrlCollectorKt.collectUrlV2(event, nativeNetworkEventProcessorV2.urlMaskingPatterns);
                }
                return BodyCollectorKt.collectBodiesV2(BodyAttributeCollectorKt.collectBodyAttributesV2(MetaDataCollectorKt.collectMetaDataV2(QueryParamCollectorKt.collectQueryParamsV2(HeaderCollectorKt.collectHeadersV2(networkEventCollectUrlV2, aggregatedRulesAggregateRules, nativeNetworkEventProcessorV2.symmetricCryptor, nativeNetworkEventProcessorV2.telemetrySender), aggregatedRulesAggregateRules, nativeNetworkEventProcessorV2.symmetricCryptor, nativeNetworkEventProcessorV2.telemetrySender), aggregatedRulesAggregateRules, nativeNetworkEventProcessorV2.symmetricCryptor, nativeNetworkEventProcessorV2.asymmetricCryptor, projectConfig), z, aggregatedRulesAggregateRules, nativeNetworkEventProcessorV2.symmetricCryptor, lazyBodyHolder, nativeNetworkEventProcessorV2.telemetrySender), aggregatedRulesAggregateRules, nativeNetworkEventProcessorV2.symmetricCryptor, nativeNetworkEventProcessorV2.telemetrySender);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ NetworkEvent invoke(NetworkEvent networkEvent, Boolean bool) {
                return invoke(networkEvent, bool.booleanValue());
            }
        });
    }

    @Override // com.contentsquare.android.error.analysis.apierror.NetworkEventProcessor
    public void setUrlMaskingPatterns(List<String> patterns) {
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        synchronized (this.urlMaskingPatterns) {
            this.urlMaskingPatterns.clear();
            this.urlMaskingPatterns.addAll(patterns);
        }
    }

    public /* synthetic */ NativeNetworkEventProcessorV2(ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface, AsymmetricCryptor asymmetricCryptor, SymmetricCryptor symmetricCryptor, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(errorAnalysisLibraryInterface, asymmetricCryptor, symmetricCryptor, (i & 8) != 0 ? new Function0<Long>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.NativeNetworkEventProcessorV2.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                return Long.valueOf(System.currentTimeMillis());
            }
        } : function0);
    }
}
