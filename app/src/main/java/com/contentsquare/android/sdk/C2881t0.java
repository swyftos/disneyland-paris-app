package com.contentsquare.android.sdk;

import android.graphics.Rect;
import com.contentsquare.android.core.communication.compose.ViewNode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.t0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2881t0 extends Lambda implements Function1<ViewNode, Boolean> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ InterfaceC2773i2.a f3107a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2881t0(InterfaceC2773i2.a aVar) {
        super(1);
        this.f3107a = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(ViewNode viewNode) {
        boolean z;
        ViewNode child = viewNode;
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.getExcludeFromGestureRecognition()) {
            z = false;
        } else {
            Rect bounds = child.getBounds();
            InterfaceC2773i2.a aVar = this.f3107a;
            if (bounds.contains(aVar.f2740b, aVar.f2741c)) {
                z = true;
            } else {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
