package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.view.View;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.communication.compose.ViewNode;
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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.s0 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nComposeGestureTargetResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposeGestureTargetResolver.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/compose/ComposeGestureTargetResolver\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,92:1\n533#2,6:93\n533#2,6:99\n1855#2,2:105\n*S KotlinDebug\n*F\n+ 1 ComposeGestureTargetResolver.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/compose/ComposeGestureTargetResolver\n*L\n70#1:93,6\n71#1:99,6\n86#1:105,2\n*E\n"})
public final class C2871s0 implements InterfaceC2773i2 {

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final a f3089b = a.f3091a;

    /* JADX INFO: renamed from: a */
    @NotNull
    public final InterfaceC2735e4<ComposeInterface> f3090a;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.s0$a */
    public static final class a extends Lambda implements Function1<Rect, String> {

        /* JADX INFO: renamed from: a */
        public static final a f3091a = new a();

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

    public C2871s0(@NotNull InterfaceC2735e4<ComposeInterface> composeInterfaceProvider) {
        Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
        this.f3090a = composeInterfaceProvider;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2773i2
    @Nullable
    /* JADX INFO: renamed from: a */
    public final C2763h2 mo1155a(@NotNull InterfaceC2773i2.a request) {
        View view;
        Object objPrevious;
        Intrinsics.checkNotNullParameter(request, "request");
        ComposeInterface composeInterface = this.f3090a.get();
        Object obj = null;
        if (composeInterface == null) {
            return null;
        }
        C2929x8<View> c2929x8 = request.f2739a;
        c2929x8.getClass();
        ArrayList arrayList = new ArrayList();
        for (C2929x8.a aVar = c2929x8.f3248b; aVar != null; aVar = aVar.f3251c) {
            Object obj2 = aVar.f3249a.get();
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
        ViewNode viewNodeProcessComposeTree = composeInterface.processComposeTree(view2, true, (Function1<? super Rect, String>) f3089b);
        if (viewNodeProcessComposeTree != null) {
            m1198a(viewNodeProcessComposeTree, arrayList2, new C2881t0(request));
        }
        ListIterator listIterator = arrayList2.listIterator(arrayList2.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((ViewNode) objPrevious).isClickable());
        ViewNode viewNode = (ViewNode) objPrevious;
        if (viewNode == null) {
            ListIterator listIterator2 = arrayList2.listIterator(arrayList2.size());
            while (listIterator2.hasPrevious()) {
                Object objPrevious2 = listIterator2.previous();
                if (!((ViewNode) objPrevious2).isEmptyOverlay()) {
                    obj = objPrevious2;
                    break;
                }
            }
            viewNode = (ViewNode) obj;
        }
        C2763h2.b c2861r0 = viewNode == null ? C2763h2.f2684d : new C2861r0(viewNode);
        if ((c2861r0 instanceof C2861r0) && ((C2861r0) c2861r0).f3056a.isClickable()) {
            z = true;
        }
        return new C2763h2(view2, c2861r0, !z);
    }

    /* JADX INFO: renamed from: a */
    public static void m1198a(ViewNode viewNode, ArrayList arrayList, C2881t0 c2881t0) {
        if (((Boolean) c2881t0.invoke(viewNode)).booleanValue()) {
            arrayList.add(viewNode);
            Iterator<T> it = viewNode.getChildren().iterator();
            while (it.hasNext()) {
                m1198a((ViewNode) it.next(), arrayList, c2881t0);
            }
        }
    }
}
