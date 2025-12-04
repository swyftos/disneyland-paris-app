package com.urbanairship.util;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class UriUtils {
    @NonNull
    public static Map<String, List<String>> getQueryParameters(@NonNull Uri uri) {
        HashMap map = new HashMap();
        String encodedQuery = uri.getEncodedQuery();
        if (UAStringUtil.isEmpty(encodedQuery)) {
            return map;
        }
        for (String str : encodedQuery.split("&")) {
            String[] strArrSplit = str.split("=");
            String strDecode = strArrSplit.length >= 1 ? Uri.decode(strArrSplit[0]) : null;
            String strDecode2 = strArrSplit.length >= 2 ? Uri.decode(strArrSplit[1]) : null;
            if (!UAStringUtil.isEmpty(strDecode)) {
                List arrayList = (List) map.get(strDecode);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(strDecode, arrayList);
                }
                arrayList.add(strDecode2);
            }
        }
        return map;
    }

    @Nullable
    public static Uri parse(@Nullable Object obj) {
        if ((obj instanceof String) || (obj instanceof Uri) || (obj instanceof URL)) {
            return Uri.parse(String.valueOf(obj));
        }
        return null;
    }
}
