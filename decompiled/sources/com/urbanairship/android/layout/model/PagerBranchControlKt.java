package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.property.PageBranching;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"nextPageId", "", "Lcom/urbanairship/android/layout/property/PageBranching;", "payload", "Lcom/urbanairship/json/JsonSerializable;", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPagerBranchControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerBranchControl.kt\ncom/urbanairship/android/layout/model/PagerBranchControlKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,150:1\n288#2,2:151\n*S KotlinDebug\n*F\n+ 1 PagerBranchControl.kt\ncom/urbanairship/android/layout/model/PagerBranchControlKt\n*L\n147#1:151,2\n*E\n"})
/* loaded from: classes5.dex */
public final class PagerBranchControlKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String nextPageId(PageBranching pageBranching, JsonSerializable jsonSerializable) {
        Object next;
        List<PageBranching.PageSelector> nextPageSelectors = pageBranching.getNextPageSelectors();
        if (nextPageSelectors == null) {
            return null;
        }
        Iterator<T> it = nextPageSelectors.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            JsonPredicate predicate = ((PageBranching.PageSelector) next).getPredicate();
            boolean z = false;
            if (predicate != null && !predicate.apply(jsonSerializable)) {
                z = true;
            }
            if (!z) {
                break;
            }
        }
        PageBranching.PageSelector pageSelector = (PageBranching.PageSelector) next;
        if (pageSelector != null) {
            return pageSelector.getPageId();
        }
        return null;
    }
}
