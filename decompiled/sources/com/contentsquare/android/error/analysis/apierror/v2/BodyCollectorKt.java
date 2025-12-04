package com.contentsquare.android.error.analysis.apierror.v2;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.error.analysis.apierror.encryption.SymmetricCryptor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\n\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u000b"}, d2 = {"collectBodiesV2", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "aggregatedRules", "Lcom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules;", "symmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "telemetrySender", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;", "shouldCollectRequestBody", "", "shouldCollectResponseBody", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BodyCollectorKt {
    @NotNull
    public static final NetworkEvent collectBodiesV2(NetworkEvent networkEvent, AggregatedRules aggregatedRules, SymmetricCryptor symmetricCryptor, final ApiErrorTelemetrySender telemetrySender) {
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        Intrinsics.checkNotNullParameter(aggregatedRules, "aggregatedRules");
        Intrinsics.checkNotNullParameter(symmetricCryptor, "symmetricCryptor");
        Intrinsics.checkNotNullParameter(telemetrySender, "telemetrySender");
        return NetworkEvent.copy$default(networkEvent, 0L, null, null, 0, 0L, 0L, shouldCollectRequestBody(networkEvent, aggregatedRules) ? symmetricCryptor.encrypt(networkEvent.getRequestBody(), true, networkEvent.getRequestBodySize(), 64000L, new Function1<Integer, Unit>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.BodyCollectorKt$collectBodiesV2$requestBody$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                telemetrySender.sendTelemetry(ApiErrorTelemetrySender.REQUEST_BODY_TOO_LARGE, i, 64000L);
            }
        }) : null, null, shouldCollectResponseBody(networkEvent, aggregatedRules) ? symmetricCryptor.encrypt(networkEvent.getResponseBody(), true, networkEvent.getResponseBodySize(), 5000L, new Function1<Integer, Unit>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.BodyCollectorKt$collectBodiesV2$responseBody$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                telemetrySender.sendTelemetry(ApiErrorTelemetrySender.RESPONSE_BODY_TOO_LARGE, i, 5000L);
            }
        }) : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 268435135, null);
    }

    public static final boolean shouldCollectRequestBody(NetworkEvent networkEvent, AggregatedRules aggregatedRules) {
        byte[] requestBody;
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        Intrinsics.checkNotNullParameter(aggregatedRules, "aggregatedRules");
        if (!aggregatedRules.getShouldCollectRequestBody() || (requestBody = networkEvent.getRequestBody()) == null) {
            return false;
        }
        return (requestBody.length == 0) ^ true;
    }

    public static final boolean shouldCollectResponseBody(NetworkEvent networkEvent, AggregatedRules aggregatedRules) {
        byte[] responseBody;
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        Intrinsics.checkNotNullParameter(aggregatedRules, "aggregatedRules");
        if (!aggregatedRules.getShouldCollectResponseBody() || (responseBody = networkEvent.getResponseBody()) == null) {
            return false;
        }
        return (responseBody.length == 0) ^ true;
    }
}
