package com.contentsquare.android.error.analysis.apierror.v1.processors;

import androidx.exifinterface.media.ExifInterface;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.error.analysis.apierror.ApiErrorConstants;
import com.contentsquare.android.error.analysis.util.ExtensionsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Languages;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J)\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\tH\u0002¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventConfigurator;", "", "()V", "configure", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "rawEvent", "conf", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrors;", "getDetail", ExifInterface.GPS_DIRECTION_TRUE, "collectionEnabled", "", Languages.ANY, "(Ljava/lang/Boolean;Ljava/lang/Object;)Ljava/lang/Object;", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkEventConfigurator {
    private final <T> T getDetail(Boolean collectionEnabled, T any) {
        if (Intrinsics.areEqual(collectionEnabled, Boolean.TRUE)) {
            return any;
        }
        return null;
    }

    @NotNull
    public final NetworkEvent configure(NetworkEvent rawEvent, JsonConfig.ApiErrors conf) {
        byte[] bArrFilterCustomHeaders;
        byte[] bArrFilterCustomHeaders2;
        Intrinsics.checkNotNullParameter(rawEvent, "rawEvent");
        String url = rawEvent.getUrl();
        byte[] bArr = (byte[]) getDetail(conf != null ? Boolean.valueOf(conf.getCollectRequestBody()) : null, rawEvent.getRequestBody());
        byte[] bArr2 = (byte[]) getDetail(conf != null ? Boolean.valueOf(conf.getCollectResponseBody()) : null, rawEvent.getResponseBody());
        Boolean boolValueOf = conf != null ? Boolean.valueOf(conf.getCollectStandardHeaders()) : null;
        Map<String, String> requestHeaders = rawEvent.getRequestHeaders();
        Map map = (Map) getDetail(boolValueOf, requestHeaders != null ? ExtensionsKt.filterStandardHeaders(requestHeaders, ApiErrorConstants.INSTANCE.getSTANDARD_HEADERS_MAP()) : null);
        Boolean boolValueOf2 = conf != null ? Boolean.valueOf(conf.getCollectStandardHeaders()) : null;
        Map<String, String> responseHeaders = rawEvent.getResponseHeaders();
        Map map2 = (Map) getDetail(boolValueOf2, responseHeaders != null ? ExtensionsKt.filterStandardHeaders(responseHeaders, ApiErrorConstants.INSTANCE.getSTANDARD_HEADERS_MAP()) : null);
        List<String> validCustomHeaders = conf != null ? conf.getValidCustomHeaders() : null;
        Boolean boolValueOf3 = Boolean.valueOf(!(validCustomHeaders == null || validCustomHeaders.isEmpty()));
        Map<String, String> requestHeaders2 = rawEvent.getRequestHeaders();
        if (requestHeaders2 != null) {
            bArrFilterCustomHeaders = ExtensionsKt.filterCustomHeaders(requestHeaders2, conf != null ? conf.getValidCustomHeaders() : null);
        } else {
            bArrFilterCustomHeaders = null;
        }
        byte[] bArr3 = (byte[]) getDetail(boolValueOf3, bArrFilterCustomHeaders);
        List<String> validCustomHeaders2 = conf != null ? conf.getValidCustomHeaders() : null;
        Boolean boolValueOf4 = Boolean.valueOf(!(validCustomHeaders2 == null || validCustomHeaders2.isEmpty()));
        Map<String, String> responseHeaders2 = rawEvent.getResponseHeaders();
        if (responseHeaders2 != null) {
            bArrFilterCustomHeaders2 = ExtensionsKt.filterCustomHeaders(responseHeaders2, conf != null ? conf.getValidCustomHeaders() : null);
        } else {
            bArrFilterCustomHeaders2 = null;
        }
        return NetworkEvent.copy$default(rawEvent, 0L, null, url, 0, 0L, 0L, bArr, null, bArr2, null, map, map2, bArr3, (byte[]) getDetail(boolValueOf4, bArrFilterCustomHeaders2), (byte[]) getDetail(conf != null ? Boolean.valueOf(conf.getCollectQueryParams()) : null, rawEvent.getQueryParameters()), null, null, null, null, null, null, null, null, null, null, null, null, null, 268403387, null);
    }
}
