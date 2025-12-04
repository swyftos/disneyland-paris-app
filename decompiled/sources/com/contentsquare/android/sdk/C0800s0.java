package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.view.View;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.communication.compose.ViewNode;
import com.contentsquare.android.sdk.C0693h2;
import com.contentsquare.android.sdk.InterfaceC0703i2;
import com.contentsquare.android.sdk.x8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nComposeGestureTargetResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposeGestureTargetResolver.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/compose/ComposeGestureTargetResolver\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,92:1\n533#2,6:93\n533#2,6:99\n1855#2,2:105\n*S KotlinDebug\n*F\n+ 1 ComposeGestureTargetResolver.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/compose/ComposeGestureTargetResolver\n*L\n70#1:93,6\n71#1:99,6\n86#1:105,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.s0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0800s0 implements InterfaceC0703i2 {

    @NotNull
    public static final a b = a.a;

    @NotNull
    public final InterfaceC0665e4<ComposeInterface> a;

    /* renamed from: com.contentsquare.android.sdk.s0$a */
    public static final class a extends Lambda implements Function1<Rect, String> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Rect rect) {
            Rect it = rect;
            Intrinsics.checkNotNullParameter(it, "it");
            return "";
        }
    }

    public C0800s0(@NotNull InterfaceC0665e4<ComposeInterface> composeInterfaceProvider) {
        Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
        this.a = composeInterfaceProvider;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0703i2
    @Nullable
    public final C0693h2 a(@NotNull InterfaceC0703i2.a request) {
        View view;
        Object objPrevious;
        Intrinsics.checkNotNullParameter(request, "request");
        ComposeInterface composeInterface = this.a.get();
        Object obj = null;
        if (composeInterface == null) {
            return null;
        }
        x8<View> x8Var = request.a;
        x8Var.getClass();
        ArrayList arrayList = new ArrayList();
        for (x8.a aVar = x8Var.b; aVar != null; aVar = aVar.c) {
            Object obj2 = aVar.a.get();
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        boolean z = false;
        View view2 = (View) CollectionsKt.getOrNull(arrayList, 0);
        if (view2 == null || (view = (View) CollectionsKt.getOrNull(arrayList, 1)) == null) {
            return null;
        }
        if (!composeInterface.isComposeRootView(view2)) {
            view2 = (composeInterface.isAndroidViewsHandler(view2) && composeInterface.isComposeRootView(view)) ? view : null;
        }
        if (view2 == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ViewNode viewNodeProcessComposeTree = composeInterface.processComposeTree(view2, true, (Function1<? super Rect, String>) b);
        if (viewNodeProcessComposeTree != null) {
            a(viewNodeProcessComposeTree, arrayList2, new C0810t0(request));
        }
        ListIterator listIterator = arrayList2.listIterator(arrayList2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            if (((ViewNode) objPrevious).isClickable()) {
                break;
            }
        }
        ViewNode viewNode = (ViewNode) objPrevious;
        if (viewNode == null) {
            ListIterator listIterator2 = arrayList2.listIterator(arrayList2.size());
            while (true) {
                if (!listIterator2.hasPrevious()) {
                    break;
                }
                Object objPrevious2 = listIterator2.previous();
                if (!((ViewNode) objPrevious2).isEmptyOverlay()) {
                    obj = objPrevious2;
                    break;
                }
            }
            viewNode = (ViewNode) obj;
        }
        C0693h2.b c0790r0 = viewNode == null ? C0693h2.d : new C0790r0(viewNode);
        if ((c0790r0 instanceof C0790r0) && ((C0790r0) c0790r0).a.isClickable()) {
            z = true;
        }
        return new C0693h2(view2, c0790r0, !z);
    }

    public static void a(ViewNode viewNode, ArrayList arrayList, C0810t0 c0810t0) {
        if (((Boolean) c0810t0.invoke(viewNode)).booleanValue()) {
            arrayList.add(viewNode);
            Iterator<T> it = viewNode.getChildren().iterator();
            while (it.hasNext()) {
                a((ViewNode) it.next(), arrayList, c0810t0);
            }
        }
    }
}
