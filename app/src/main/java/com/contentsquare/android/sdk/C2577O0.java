package com.contentsquare.android.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.O0 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nCssDependencyResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CssDependencyResolver.kt\ncom/contentsquare/android/internal/features/webviewbridge/util/CssDependencyResolver\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,49:1\n1855#2,2:50\n1855#2,2:52\n*S KotlinDebug\n*F\n+ 1 CssDependencyResolver.kt\ncom/contentsquare/android/internal/features/webviewbridge/util/CssDependencyResolver\n*L\n41#1:50,2\n35#1:52,2\n*E\n"})
public final class C2577O0 {
    /* JADX INFO: renamed from: a */
    public static final void m995a(LinkedHashSet linkedHashSet, LinkedHashMap linkedHashMap, ArrayList arrayList, String str) {
        if (linkedHashSet.contains(str)) {
            throw new IllegalArgumentException("Circular dependency detected for " + str);
        }
        linkedHashSet.add(str);
        List listEmptyList = (List) linkedHashMap.get(str);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            m995a(linkedHashSet, linkedHashMap, arrayList, (String) it.next());
        }
        arrayList.add(str);
    }
}
