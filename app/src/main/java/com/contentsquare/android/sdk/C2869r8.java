package com.contentsquare.android.sdk;

import android.graphics.Rect;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.compose.ViewNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.r8 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nViewNodeConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewNodeConverter.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/compose/ViewNodeConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1549#2:66\n1620#2,3:67\n*S KotlinDebug\n*F\n+ 1 ViewNodeConverter.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/compose/ViewNodeConverter\n*L\n24#1:66\n24#1:67,3\n*E\n"})
public final class C2869r8 {
    /* JADX INFO: renamed from: a */
    public static C2499G2 m1197a(ViewNode viewNode, String str) {
        String str2 = str + Typography.greater + viewNode.getName() + ":eq(" + viewNode.getChildOrder() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        C2469D2 c2469d2 = new C2469D2(viewNode.getChildOrder(), viewNode.getName(), str2);
        Rect bounds = viewNode.getBounds();
        C2489F2 c2489f2 = new C2489F2(bounds.width(), bounds.height(), bounds.left, bounds.top, viewNode.getPosZ(), viewNode.getBitmap(), viewNode.getBackground(), viewNode.isVisible(), viewNode.getViewAlpha(), 512);
        if (viewNode.isEmptyOverlay()) {
            c2489f2.f1604j = Boolean.FALSE;
        }
        C2499G2 c2499g2 = new C2499G2();
        String id = viewNode.getId();
        Intrinsics.checkNotNullParameter(id, "<set-?>");
        c2499g2.f1637a = id;
        JSONObject jSONObjectM897a = c2469d2.m897a();
        Intrinsics.checkNotNullParameter(jSONObjectM897a, "<set-?>");
        c2499g2.f1638b = jSONObjectM897a;
        JSONObject jSONObjectM916a = c2489f2.m916a();
        Intrinsics.checkNotNullParameter(jSONObjectM916a, "<set-?>");
        c2499g2.f1642f = jSONObjectM916a;
        C2499G2.a aVar = C2499G2.a.COMPOSE_NODE;
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        c2499g2.f1644h = aVar;
        Pair pair = new Pair(c2499g2, str2);
        C2499G2 c2499g3 = (C2499G2) pair.component1();
        String str3 = (String) pair.component2();
        List<ViewNode> children = viewNode.getChildren();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(children, 10));
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            arrayList.add(m1197a((ViewNode) it.next(), str3));
        }
        c2499g3.f1639c = arrayList;
        return c2499g3;
    }
}
