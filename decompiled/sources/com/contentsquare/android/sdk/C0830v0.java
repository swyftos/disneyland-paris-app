package com.contentsquare.android.sdk;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.communication.compose.ViewNode;
import com.contentsquare.android.sdk.AbstractC0645c4;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.v0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0830v0 implements Function2<View, InterfaceC0679f8, AbstractC0645c4> {

    @NotNull
    public final InterfaceC0665e4<ComposeInterface> a;

    public C0830v0(@NotNull InterfaceC0665e4<ComposeInterface> composeInterfaceProvider) {
        Intrinsics.checkNotNullParameter(composeInterfaceProvider, "composeInterfaceProvider");
        this.a = composeInterfaceProvider;
    }

    public void a(@NotNull ViewNode rootNode) {
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
    }

    @Override // kotlin.jvm.functions.Function2
    public final AbstractC0645c4 invoke(View view, InterfaceC0679f8 interfaceC0679f8) {
        View group = view;
        InterfaceC0679f8 viewBitmapProviderResult = interfaceC0679f8;
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(viewBitmapProviderResult, "viewBitmapProviderResult");
        ComposeInterface composeInterface = this.a.get();
        if (composeInterface != null && composeInterface.isComposeRootView(group)) {
            ViewNode rootNode = composeInterface.processComposeTree(group, false, (Function1<? super Rect, String>) new C0820u0(viewBitmapProviderResult));
            if (rootNode != null) {
                a(rootNode);
            }
            List listEmptyList = null;
            if (rootNode != null) {
                ViewGroup group2 = group instanceof ViewGroup ? (ViewGroup) group : null;
                if (group2 != null) {
                    I3 pathDescriptor = new I3(new J3());
                    Intrinsics.checkNotNullParameter(group2, "group");
                    Intrinsics.checkNotNullParameter(rootNode, "rootNode");
                    Intrinsics.checkNotNullParameter(pathDescriptor, "pathDescriptor");
                    listEmptyList = CollectionsKt.listOf(C0798r8.a(rootNode, pathDescriptor.a(group2)));
                }
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return new AbstractC0645c4.b(listEmptyList);
        }
        return AbstractC0645c4.a.a;
    }
}
