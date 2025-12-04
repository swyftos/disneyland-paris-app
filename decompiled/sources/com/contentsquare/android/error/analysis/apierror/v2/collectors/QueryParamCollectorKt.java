package com.contentsquare.android.error.analysis.apierror.v2.collectors;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.error.analysis.apierror.encryption.SymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.v2.AggregatedRules;
import com.contentsquare.android.error.analysis.apierror.v2.ApiErrorTelemetrySender;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"collectQueryParamsV2", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "aggregatedRules", "Lcom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules;", "symmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "telemetryBuilder", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QueryParamCollectorKt {
    @NotNull
    public static final NetworkEvent collectQueryParamsV2(NetworkEvent networkEvent, AggregatedRules aggregatedRules, SymmetricCryptor symmetricCryptor, final ApiErrorTelemetrySender telemetryBuilder) {
        byte[] bArrEncrypt;
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        Intrinsics.checkNotNullParameter(aggregatedRules, "aggregatedRules");
        Intrinsics.checkNotNullParameter(symmetricCryptor, "symmetricCryptor");
        Intrinsics.checkNotNullParameter(telemetryBuilder, "telemetryBuilder");
        if (aggregatedRules.getShouldCollectQueryParams()) {
            byte[] queryParameters = networkEvent.getQueryParameters();
            byte[] queryParameters2 = networkEvent.getQueryParameters();
            bArrEncrypt = symmetricCryptor.encrypt(queryParameters, true, queryParameters2 != null ? Integer.valueOf(queryParameters2.length) : null, 2000L, new Function1<Integer, Unit>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.collectors.QueryParamCollectorKt$collectQueryParamsV2$queryParams$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    telemetryBuilder.sendTelemetry(ApiErrorTelemetrySender.QUERY_PARAMS_TOO_LARGE, i, 2000L);
                }
            });
        } else {
            bArrEncrypt = null;
        }
        return NetworkEvent.copy$default(networkEvent, 0L, null, null, 0, 0L, 0L, null, null, null, null, null, null, null, null, bArrEncrypt, null, null, null, null, null, null, null, null, null, null, null, null, null, 268419071, null);
    }
}
