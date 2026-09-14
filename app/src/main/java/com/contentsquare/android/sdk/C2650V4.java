package com.contentsquare.android.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.V4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2650V4 {
    /* JADX WARN: Code duplicated, block: B:27:0x0084  */
    /* JADX WARN: Code duplicated, block: B:36:0x009e  */
    @NotNull
    /* JADX INFO: renamed from: a */
    public static List m1044a(@NotNull C2499G2 node, boolean z) {
        Intrinsics.checkNotNullParameter(node, "node");
        List<C2499G2> list = node.f1639c;
        if (list == null) {
            return CollectionsKt.listOf(new C2499G2(node));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C2499G2> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(m1044a(it.next(), false));
        }
        boolean z2 = false;
        for (int i = 0; !z && i < arrayList.size() && !z2; i++) {
            C2499G2 c2499g2 = (C2499G2) arrayList.get(i);
            JSONObject jSONObject = node.f1642f;
            JSONObject jSONObject2 = c2499g2.f1642f;
            if (jSONObject != null && jSONObject2 != null) {
                int iOptInt = jSONObject.optInt("x");
                int iOptInt2 = jSONObject.optInt("y");
                int iOptInt3 = jSONObject.optInt("width");
                int iOptInt4 = jSONObject.optInt("height");
                int iOptInt5 = jSONObject2.optInt("x");
                int iOptInt6 = jSONObject2.optInt("y");
                int iOptInt7 = jSONObject2.optInt("width");
                int iOptInt8 = jSONObject2.optInt("height");
                if (iOptInt < iOptInt5 || iOptInt2 < iOptInt6 || iOptInt + iOptInt3 > iOptInt5 + iOptInt7 || iOptInt2 + iOptInt4 > iOptInt6 + iOptInt8) {
                    z2 = jSONObject == null ? false : false;
                } else {
                    z2 = true;
                }
            } else if ((jSONObject == null && (jSONObject.optInt("width") == 0 || jSONObject.optInt("height") == 0)) || (jSONObject != null && !jSONObject.optBoolean("visibility"))) {
                z2 = true;
            }
        }
        if (z2) {
            return arrayList;
        }
        C2499G2 c2499g3 = new C2499G2(node);
        c2499g3.f1639c = arrayList;
        return CollectionsKt.listOf(c2499g3);
    }
}
