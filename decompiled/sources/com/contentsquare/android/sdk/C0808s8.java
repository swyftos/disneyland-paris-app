package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.compose.ViewNode;
import java.util.ArrayList;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nViewNodePathDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewNodePathDescriptor.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/compose/viewhierarchy/ViewNodePathDescriptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.s8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0808s8 {
    public static void a(ViewNode viewNode, ArrayList arrayList) {
        ViewNode parent = viewNode.getParent();
        if (parent != null) {
            a(parent, arrayList);
        }
        int childOrder = viewNode.getChildOrder();
        arrayList.add(viewNode.getName() + ":eq(" + childOrder + CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }
}
