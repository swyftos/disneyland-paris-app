package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.communication.compose.ViewNode;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.v0 */
/* JADX INFO: loaded from: classes2.dex */
public class C2901v0 implements Function2<View, InterfaceC2749f8, AbstractC2715c4> {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final InterfaceC2735e4<ComposeInterface> f3166a;

    public C2901v0(@NotNull InterfaceC2735e4<ComposeInterface> composeInterfaceProvider) {
        Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
        this.f3166a = composeInterfaceProvider;
    }

    /* JADX INFO: renamed from: a */
    public void mo1018a(@NotNull ViewNode rootNode) {
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
    }

    @Override // kotlin.jvm.functions.Function2
    public final AbstractC2715c4 invoke(View view, InterfaceC2749f8 interfaceC2749f8) {
        View group = view;
        InterfaceC2749f8 viewBitmapProviderResult = interfaceC2749f8;
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(viewBitmapProviderResult, "viewBitmapProviderResult");
        ComposeInterface composeInterface = this.f3166a.get();
        if (composeInterface != null && composeInterface.isComposeRootView(group)) {
            ViewNode rootNode = composeInterface.processComposeTree(group, false, (Function1<? super Rect, String>) new C2891u0(viewBitmapProviderResult));
            if (rootNode != null) {
                mo1018a(rootNode);
            }
            List listEmptyList = null;
            if (rootNode != null) {
                ViewGroup group2 = group instanceof ViewGroup ? (ViewGroup) group : null;
                if (group2 != null) {
                    C2520I3 pathDescriptor = new C2520I3(new C2530J3());
                    Intrinsics.checkNotNullParameter(group2, "group");
                    Intrinsics.checkNotNullParameter(rootNode, "rootNode");
                    Intrinsics.checkNotNullParameter(pathDescriptor, "pathDescriptor");
                    listEmptyList = CollectionsKt.listOf(C2869r8.m1197a(rootNode, pathDescriptor.m939a(group2)));
                }
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return new AbstractC2715c4.b(listEmptyList);
        }
        return AbstractC2715c4.a.f2444a;
    }
}
