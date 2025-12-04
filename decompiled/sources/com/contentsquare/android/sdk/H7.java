package com.contentsquare.android.sdk;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.util.Predicate;
import com.contentsquare.android.api.bridge.flutter.ExternalViewGraphListener;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.sdk.K1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nTreeTraverser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TreeTraverser.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/TreeTraverser\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,261:1\n179#2,2:262\n1#3:264\n*S KotlinDebug\n*F\n+ 1 TreeTraverser.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/TreeTraverser\n*L\n180#1:262,2\n*E\n"})
/* loaded from: classes2.dex */
public final class H7 {

    @NotNull
    public final Predicate<View> a;

    @NotNull
    public final InterfaceC0665e4<ComposeInterface> b;

    public H7(@NotNull InterfaceC0665e4 composeInterfaceProvider) {
        Predicate<View> filterOutViews = Q1.e;
        Intrinsics.checkNotNullParameter(filterOutViews, "filterOutViews");
        Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
        this.a = filterOutViews;
        this.b = composeInterfaceProvider;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00a3  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.contentsquare.android.sdk.U4 a(@org.jetbrains.annotations.NotNull android.view.ViewGroup r18, @org.jetbrains.annotations.NotNull com.contentsquare.android.api.model.CustomVar[] r19, @org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.K1 r20, @org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.InterfaceC0679f8 r21, @org.jetbrains.annotations.NotNull com.contentsquare.android.sdk.W4 r22, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super android.view.View, ? super com.contentsquare.android.sdk.InterfaceC0679f8, ? extends com.contentsquare.android.sdk.AbstractC0645c4> r23, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super android.view.View, ? super com.contentsquare.android.sdk.G2, kotlin.Unit> r24) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.H7.a(android.view.ViewGroup, com.contentsquare.android.api.model.CustomVar[], com.contentsquare.android.sdk.K1, com.contentsquare.android.sdk.f8, com.contentsquare.android.sdk.W4, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2):com.contentsquare.android.sdk.U4");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List a(LinkedList linkedList, ViewGroup viewGroup, K1 k1, InterfaceC0679f8 interfaceC0679f8, W4 w4) {
        int childCount = viewGroup.getChildCount();
        if (childCount <= 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            View view = viewGroup.getChildAt(i);
            if (!this.a.test(view)) {
                Intrinsics.checkNotNullExpressionValue(view, "child");
                G2 jsonView = H2.a(view, interfaceC0679f8, w4, this.b.get());
                arrayList.add(jsonView);
                if (view instanceof ViewGroup) {
                    linkedList.add(new Pair(view, jsonView));
                }
                k1.getClass();
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(jsonView, "jsonView");
                if (view instanceof WebView) {
                    k1.e.put(view, jsonView);
                } else {
                    ExternalViewGraphListener externalViewGraphListener = K1.g.get(view);
                    if (externalViewGraphListener != null) {
                        k1.f.put(view, new K1.b(jsonView, externalViewGraphListener));
                    }
                }
            }
        }
        return arrayList;
    }
}
