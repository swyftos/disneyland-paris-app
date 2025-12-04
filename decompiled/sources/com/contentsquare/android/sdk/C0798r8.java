package com.contentsquare.android.sdk;

import android.graphics.Rect;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.compose.ViewNode;
import com.contentsquare.android.sdk.G2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nViewNodeConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewNodeConverter.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/compose/ViewNodeConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1549#2:66\n1620#2,3:67\n*S KotlinDebug\n*F\n+ 1 ViewNodeConverter.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/compose/ViewNodeConverter\n*L\n24#1:66\n24#1:67,3\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.r8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0798r8 {
    public static G2 a(ViewNode viewNode, String str) throws JSONException {
        String str2 = str + Typography.greater + viewNode.getName() + ":eq(" + viewNode.getChildOrder() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        D2 d2 = new D2(viewNode.getChildOrder(), viewNode.getName(), str2);
        Rect bounds = viewNode.getBounds();
        F2 f2 = new F2(bounds.width(), bounds.height(), bounds.left, bounds.top, viewNode.getPosZ(), viewNode.getBitmap(), viewNode.getBackground(), viewNode.isVisible(), viewNode.getViewAlpha(), 512);
        if (viewNode.isEmptyOverlay()) {
            f2.j = Boolean.FALSE;
        }
        G2 g2 = new G2();
        String id = viewNode.getId();
        Intrinsics.checkNotNullParameter(id, "<set-?>");
        g2.a = id;
        JSONObject jSONObjectA = d2.a();
        Intrinsics.checkNotNullParameter(jSONObjectA, "<set-?>");
        g2.b = jSONObjectA;
        JSONObject jSONObjectA2 = f2.a();
        Intrinsics.checkNotNullParameter(jSONObjectA2, "<set-?>");
        g2.f = jSONObjectA2;
        G2.a aVar = G2.a.COMPOSE_NODE;
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        g2.h = aVar;
        Pair pair = new Pair(g2, str2);
        G2 g22 = (G2) pair.component1();
        String str3 = (String) pair.component2();
        List<ViewNode> children = viewNode.getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(children, 10));
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            arrayList.add(a((ViewNode) it.next(), str3));
        }
        g22.c = arrayList;
        return g22;
    }
}
