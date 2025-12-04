package com.contentsquare.android.error.analysis.util;

import android.net.Uri;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.apierror.v1.processors.UrlMasker;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0000\u001a\u001a\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0002*\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"anonymizeValues", "", "", "extractQueryParameters", "", "maskUrl", "patterns", "", "removeUrlParameters", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUrlExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UrlExtensions.kt\ncom/contentsquare/android/error/analysis/util/UrlExtensionsKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n442#2:58\n392#2:59\n483#2,7:73\n1238#3,4:60\n766#3:64\n857#3,2:65\n1271#3,2:67\n1285#3,4:69\n*S KotlinDebug\n*F\n+ 1 UrlExtensions.kt\ncom/contentsquare/android/error/analysis/util/UrlExtensionsKt\n*L\n31#1:58\n31#1:59\n46#1:73,7\n31#1:60,4\n44#1:64\n44#1:65,2\n45#1:67,2\n45#1:69,4\n*E\n"})
/* loaded from: classes2.dex */
public final class UrlExtensionsKt {
    @NotNull
    public static final Map<String, String> anonymizeValues(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ExtensionsKt.anonymizeFields((String) entry.getValue()));
        }
        return linkedHashMap;
    }

    @Nullable
    public static final byte[] extractQueryParameters(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Uri uri = Uri.parse(str);
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = queryParameterNames.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String str2 = (String) next;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    z = false;
                }
                if (!z) {
                    arrayList.add(next);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj : arrayList) {
                linkedHashMap.put(obj, uri.getQueryParameter((String) obj));
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str3 = (String) entry.getValue();
                if (!(str3 == null || StringsKt.isBlank(str3))) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            String string = new JSONObject(linkedHashMap2).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONObject(queryParameters).toString()");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (Throwable th) {
            new Logger("NetworkEventMetric").d(th, "Exception received while parsing query parameters");
            return null;
        }
    }

    @NotNull
    public static final String maskUrl(String str, List<String> patterns) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        return UrlMasker.INSTANCE.maskUrl(str, patterns);
    }

    @NotNull
    public static final String removeUrlParameters(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            URI uri = new URI(str);
            String string = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
            Intrinsics.checkNotNullExpressionValue(string, "{\n        val uri = URI(…       ).toString()\n    }");
            return string;
        } catch (Throwable th) {
            new Logger(null, 1, null).d(th, "Exception received while parsing url");
            return str;
        }
    }
}
