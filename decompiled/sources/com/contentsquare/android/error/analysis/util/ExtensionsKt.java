package com.contentsquare.android.error.analysis.util;

import com.contentsquare.android.error.analysis.apierror.ApiErrorConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a(\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u001a7\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\u0010\f\u001a\n\u0010\r\u001a\u00020\u0005*\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"BODY_MAX_SIZE", "", "anonymizeFields", "", "filterCustomHeaders", "", "", "validCustomHeaders", "", "filterStandardHeaders", "standardHeadersMap", "", "(Ljava/util/Map;[Ljava/lang/String;)Ljava/util/Map;", "truncateBody", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extensions.kt\ncom/contentsquare/android/error/analysis/util/ExtensionsKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,62:1\n515#2:63\n500#2,6:64\n515#2:71\n500#2,2:72\n502#2,4:77\n1#3:70\n1747#4,3:74\n*S KotlinDebug\n*F\n+ 1 Extensions.kt\ncom/contentsquare/android/error/analysis/util/ExtensionsKt\n*L\n22#1:63\n22#1:64,6\n30#1:71\n30#1:72,2\n30#1:77,4\n31#1:74,3\n*E\n"})
/* loaded from: classes2.dex */
public final class ExtensionsKt {
    private static final int BODY_MAX_SIZE = 1048576;

    @NotNull
    public static final String anonymizeFields(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ApiErrorConstants apiErrorConstants = ApiErrorConstants.INSTANCE;
        return apiErrorConstants.getFAST_LOOKUP_EMAIL_REGEX().containsMatchIn(str) ? apiErrorConstants.getEMAIL_REGEX().replace(str, new Function1<MatchResult, CharSequence>() { // from class: com.contentsquare.android.error.analysis.util.ExtensionsKt.anonymizeFields.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(MatchResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ApiErrorConstants.EMAIL_REPLACEMENT;
            }
        }) : str;
    }

    @Nullable
    public static final byte[] filterCustomHeaders(Map<String, String> map, List<String> list) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (list != null && !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (StringsKt.equals((String) it.next(), entry.getKey(), true)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                        break;
                    }
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return null;
        }
        String string = new JSONObject(linkedHashMap).toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject(headerFiltered).toString()");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @Nullable
    public static final Map<String, String> filterStandardHeaders(Map<String, String> map, final String[] standardHeadersMap) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(standardHeadersMap, "standardHeadersMap");
        Function1<String, Boolean> function1 = new Function1<String, Boolean>() { // from class: com.contentsquare.android.error.analysis.util.ExtensionsKt$filterStandardHeaders$isStandardHeader$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(String header) {
                Intrinsics.checkNotNullParameter(header, "header");
                String[] strArr = standardHeadersMap;
                int length = strArr.length;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (StringsKt.equals(strArr[i], header, true)) {
                        z = true;
                        break;
                    }
                    i++;
                }
                return Boolean.valueOf(z);
            }
        };
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (function1.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map2 = MapsKt.toMap(linkedHashMap);
        if (map2.isEmpty()) {
            return null;
        }
        return map2;
    }

    @NotNull
    public static final byte[] truncateBody(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length < 1048576 ? bArr.length : 1048576);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }
}
