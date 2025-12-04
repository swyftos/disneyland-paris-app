package com.contentsquare.android.error.analysis.apierror.v2.collectors;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.error.analysis.apierror.ApiErrorConstants;
import com.contentsquare.android.error.analysis.apierror.encryption.SymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.v2.AggregatedRules;
import com.contentsquare.android.error.analysis.apierror.v2.ApiErrorTelemetrySender;
import com.contentsquare.android.error.analysis.apierror.v2.ApiErrorsType;
import com.contentsquare.android.error.analysis.apierror.v2.LazyBodyHolder;
import com.contentsquare.android.error.analysis.util.JSONBody;
import com.contentsquare.android.error.analysis.util.JSONPath;
import com.contentsquare.android.error.analysis.util.UrlExtensionsKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0002\u001a(\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u0002\u001a$\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002\u001a4\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u001a"}, d2 = {"collectBodyAttributes", "", "", "aggregatedRules", "Lcom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules;", "telemetrySender", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;", "encrypted", "", "type", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorsType;", "json", "Lkotlin/Function0;", "Lcom/contentsquare/android/error/analysis/util/JSONBody;", "encryptAsJson", "", "symmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "data", "limitBodyAttributeSize", "bodyAttrVal", "collectBodyAttributesV2", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "enabled", "lazyBodyHolder", "Lcom/contentsquare/android/error/analysis/apierror/v2/LazyBodyHolder;", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBodyAttributeCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BodyAttributeCollector.kt\ncom/contentsquare/android/error/analysis/apierror/v2/collectors/BodyAttributeCollectorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,127:1\n1855#2,2:128\n1#3:130\n*S KotlinDebug\n*F\n+ 1 BodyAttributeCollector.kt\ncom/contentsquare/android/error/analysis/apierror/v2/collectors/BodyAttributeCollectorKt\n*L\n83#1:128,2\n*E\n"})
/* loaded from: classes2.dex */
public final class BodyAttributeCollectorKt {
    private static final Map<String, String> collectBodyAttributes(AggregatedRules aggregatedRules, ApiErrorTelemetrySender apiErrorTelemetrySender, boolean z, ApiErrorsType apiErrorsType, Function0<JSONBody> function0) {
        List<JsonConfig.ApiErrorsV2.BodyAttributePath> bodyAttributes = aggregatedRules.getBodyAttributes(z, apiErrorsType);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (JsonConfig.ApiErrorsV2.BodyAttributePath bodyAttributePath : bodyAttributes) {
            String strLimitBodyAttributeSize = limitBodyAttributeSize(JSONPath.getJSONPathValue$default(JSONPath.INSTANCE, bodyAttributePath.getPath(), function0.invoke(), false, 4, null), apiErrorTelemetrySender, apiErrorsType);
            if (strLimitBodyAttributeSize != null) {
                linkedHashMap.put(bodyAttributePath.getPath(), strLimitBodyAttributeSize);
            }
        }
        if (linkedHashMap.isEmpty()) {
            return null;
        }
        return linkedHashMap;
    }

    @NotNull
    public static final NetworkEvent collectBodyAttributesV2(NetworkEvent networkEvent, boolean z, AggregatedRules aggregatedRules, SymmetricCryptor symmetricCryptor, final LazyBodyHolder lazyBodyHolder, ApiErrorTelemetrySender telemetrySender) {
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        Intrinsics.checkNotNullParameter(aggregatedRules, "aggregatedRules");
        Intrinsics.checkNotNullParameter(symmetricCryptor, "symmetricCryptor");
        Intrinsics.checkNotNullParameter(lazyBodyHolder, "lazyBodyHolder");
        Intrinsics.checkNotNullParameter(telemetrySender, "telemetrySender");
        if (!z) {
            ApiErrorConstants apiErrorConstants = ApiErrorConstants.INSTANCE;
            return NetworkEvent.copy$default(networkEvent, 0L, null, null, 0, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, apiErrorConstants.getTRUNCATED_MAP(), encryptAsJson(symmetricCryptor, apiErrorConstants.getTRUNCATED_MAP()), apiErrorConstants.getTRUNCATED_MAP(), encryptAsJson(symmetricCryptor, apiErrorConstants.getTRUNCATED_MAP()), null, null, 205520895, null);
        }
        ApiErrorsType apiErrorsType = ApiErrorsType.REQUEST;
        Map<String, String> mapCollectBodyAttributes = collectBodyAttributes(aggregatedRules, telemetrySender, false, apiErrorsType, new Function0<JSONBody>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.collectors.BodyAttributeCollectorKt$collectBodyAttributesV2$plainRequestBodyAttrs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final JSONBody invoke() {
                return lazyBodyHolder.getRequestBodyJSON();
            }
        });
        ApiErrorsType apiErrorsType2 = ApiErrorsType.RESPONSE;
        Map<String, String> mapCollectBodyAttributes2 = collectBodyAttributes(aggregatedRules, telemetrySender, false, apiErrorsType2, new Function0<JSONBody>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.collectors.BodyAttributeCollectorKt$collectBodyAttributesV2$plainResponseBodyAttrs$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final JSONBody invoke() {
                return lazyBodyHolder.getResponseBodyJSON();
            }
        });
        Map<String, String> mapCollectBodyAttributes3 = collectBodyAttributes(aggregatedRules, telemetrySender, true, apiErrorsType, new Function0<JSONBody>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.collectors.BodyAttributeCollectorKt$collectBodyAttributesV2$requestBodyAttrsToEncrypt$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final JSONBody invoke() {
                return lazyBodyHolder.getRequestBodyJSON();
            }
        });
        Map<String, String> mapCollectBodyAttributes4 = collectBodyAttributes(aggregatedRules, telemetrySender, true, apiErrorsType2, new Function0<JSONBody>() { // from class: com.contentsquare.android.error.analysis.apierror.v2.collectors.BodyAttributeCollectorKt$collectBodyAttributesV2$responseBodyAttrsToEncrypt$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final JSONBody invoke() {
                return lazyBodyHolder.getResponseBodyJSON();
            }
        });
        return NetworkEvent.copy$default(networkEvent, 0L, null, null, 0, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, mapCollectBodyAttributes != null ? UrlExtensionsKt.anonymizeValues(mapCollectBodyAttributes) : null, encryptAsJson(symmetricCryptor, mapCollectBodyAttributes3), mapCollectBodyAttributes2 != null ? UrlExtensionsKt.anonymizeValues(mapCollectBodyAttributes2) : null, encryptAsJson(symmetricCryptor, mapCollectBodyAttributes4), null, null, 205520895, null);
    }

    private static final byte[] encryptAsJson(SymmetricCryptor symmetricCryptor, Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        String string = new JSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject(data).toString()");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return symmetricCryptor.encrypt(bytes);
    }

    private static final String limitBodyAttributeSize(String str, ApiErrorTelemetrySender apiErrorTelemetrySender, ApiErrorsType apiErrorsType) {
        if (str == null || str.length() <= 100) {
            return str;
        }
        apiErrorTelemetrySender.sendTelemetry(apiErrorsType == ApiErrorsType.REQUEST ? ApiErrorTelemetrySender.REQUEST_BODY_ATTR_VALUE_TOO_LARGE : ApiErrorTelemetrySender.RESPONSE_BODY_ATTR_VALUE_TOO_LARGE, str.length(), 100L);
        return StringsKt.take(str, 99) + Typography.ellipsis;
    }
}
