package com.contentsquare.android.error.analysis.apierror.v2.collectors;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.error.analysis.apierror.ApiErrorConstants;
import com.contentsquare.android.error.analysis.apierror.encryption.SymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.v2.AggregatedRules;
import com.contentsquare.android.error.analysis.apierror.v2.ApiErrorTelemetrySender;
import com.contentsquare.android.error.analysis.apierror.v2.ApiErrorsType;
import com.contentsquare.android.error.analysis.util.ExtensionsKt;
import com.contentsquare.android.error.analysis.util.SizeUtilsKt;
import com.contentsquare.android.error.analysis.util.UrlExtensionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a2\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002\u001a(\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002\u001a@\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a$\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u001a\u0010\u001b\u001a\u00020\u001c*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002¨\u0006\u001d"}, d2 = {"collectHeaders", "Lcom/contentsquare/android/error/analysis/apierror/v2/collectors/ProcessedHeaders;", "rules", "Lcom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules;", "headers", "", "", "type", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorsType;", "symmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "telemetrySender", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;", "collectStandardHeaders", "aggregatedRules", "requestHeaders", "encryptAsJson", "", "data", "filterHeaders", "headerRules", "", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CustomHeader;", "anonymize", "", "collectHeadersV2", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "sizeInBytes", "", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHeaderCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeaderCollector.kt\ncom/contentsquare/android/error/analysis/apierror/v2/collectors/HeaderCollectorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,201:1\n1855#2:202\n1856#2:204\n1789#2,3:205\n1#3:203\n*S KotlinDebug\n*F\n+ 1 HeaderCollector.kt\ncom/contentsquare/android/error/analysis/apierror/v2/collectors/HeaderCollectorKt\n*L\n165#1:202\n165#1:204\n197#1:205,3\n*E\n"})
/* loaded from: classes2.dex */
public final class HeaderCollectorKt {
    private static final ProcessedHeaders collectHeaders(AggregatedRules aggregatedRules, Map<String, String> map, ApiErrorsType apiErrorsType, SymmetricCryptor symmetricCryptor, ApiErrorTelemetrySender apiErrorTelemetrySender) {
        Truncator truncator = new Truncator(symmetricCryptor, filterHeaders(aggregatedRules.getCustomHeaders(false, apiErrorsType), map, true), filterHeaders(aggregatedRules.getCustomHeaders(true, apiErrorsType), map, false), collectStandardHeaders(aggregatedRules, map), apiErrorsType);
        truncator.reportTelemetry(apiErrorTelemetrySender);
        return truncator.truncateHeaders();
    }

    @NotNull
    public static final NetworkEvent collectHeadersV2(NetworkEvent networkEvent, AggregatedRules rules, SymmetricCryptor symmetricCryptor, ApiErrorTelemetrySender telemetrySender) {
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        Intrinsics.checkNotNullParameter(rules, "rules");
        Intrinsics.checkNotNullParameter(symmetricCryptor, "symmetricCryptor");
        Intrinsics.checkNotNullParameter(telemetrySender, "telemetrySender");
        ProcessedHeaders processedHeadersCollectHeaders = collectHeaders(rules, networkEvent.getRequestHeaders(), ApiErrorsType.REQUEST, symmetricCryptor, telemetrySender);
        ProcessedHeaders processedHeadersCollectHeaders2 = collectHeaders(rules, networkEvent.getResponseHeaders(), ApiErrorsType.RESPONSE, symmetricCryptor, telemetrySender);
        byte[] encryptedHeaders = processedHeadersCollectHeaders.getEncryptedHeaders();
        Map<String, String> plainHeaders = processedHeadersCollectHeaders.getPlainHeaders();
        return NetworkEvent.copy$default(networkEvent, 0L, null, null, 0, 0L, 0L, null, null, null, null, processedHeadersCollectHeaders.getStandardHeaders(), processedHeadersCollectHeaders2.getStandardHeaders(), encryptedHeaders, processedHeadersCollectHeaders2.getEncryptedHeaders(), null, null, null, null, null, null, null, null, null, null, null, null, plainHeaders, processedHeadersCollectHeaders2.getPlainHeaders(), 67093503, null);
    }

    private static final Map<String, String> collectStandardHeaders(AggregatedRules aggregatedRules, Map<String, String> map) {
        Map<String, String> mapFilterStandardHeaders;
        if (aggregatedRules.getShouldCollectStandardHeaders()) {
            Map<String, String> mapAnonymizeValues = (map == null || (mapFilterStandardHeaders = ExtensionsKt.filterStandardHeaders(map, ApiErrorConstants.INSTANCE.getSTANDARD_HEADERS_MAP())) == null) ? null : UrlExtensionsKt.anonymizeValues(mapFilterStandardHeaders);
            if (mapAnonymizeValues != null) {
                return mapAnonymizeValues;
            }
        }
        return MapsKt.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] encryptAsJson(SymmetricCryptor symmetricCryptor, Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        String string = new JSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject(data).toString()");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return symmetricCryptor.encrypt(bytes, false, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Map<String, String> filterHeaders(List<JsonConfig.ApiErrorsV2.CustomHeader> list, Map<String, String> map, boolean z) {
        Set<Map.Entry<String, String>> setEntrySet;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (JsonConfig.ApiErrorsV2.CustomHeader customHeader : list) {
            Map.Entry entry = null;
            if (map != null && (setEntrySet = map.entrySet()) != null) {
                Iterator<T> it = setEntrySet.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String str = (String) ((Map.Entry) next).getKey();
                    Locale locale = Locale.ROOT;
                    String lowerCase = str.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String lowerCase2 = customHeader.getHeaderName().toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        entry = next;
                        break;
                    }
                }
                entry = entry;
            }
            if (entry != null) {
                String str2 = (String) entry.getKey();
                String strAnonymizeFields = (String) entry.getValue();
                if (z) {
                    strAnonymizeFields = ExtensionsKt.anonymizeFields(strAnonymizeFields);
                }
                linkedHashMap.put(str2, strAnonymizeFields);
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long sizeInBytes(Map<String, String> map) {
        Set<String> setKeySet;
        long jUtf8Size = 0;
        if (map != null && (setKeySet = map.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                jUtf8Size = jUtf8Size + SizeUtilsKt.utf8Size(r3) + (map.get((String) it.next()) != null ? SizeUtilsKt.utf8Size(r3) : 0);
            }
        }
        return jUtf8Size;
    }
}
