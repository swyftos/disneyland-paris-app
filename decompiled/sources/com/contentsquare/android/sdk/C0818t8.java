package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.communication.compose.ViewNode;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.t8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0818t8 implements Y6 {

    @NotNull
    public static final I3 b = new I3(new J3());

    @NotNull
    public final String a;

    public C0818t8(@NotNull View containerView, @NotNull ViewNode view) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(view, "view");
        String strA = b.a(containerView);
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        C0808s8.a(view, arrayList);
        this.a = ArraysKt.joinToString$default(new String[]{strA, CollectionsKt.joinToString$default(arrayList, ">", null, null, 0, null, null, 62, null)}, ">", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @Override // com.contentsquare.android.sdk.Y6
    @NotNull
    public final String a() {
        return this.a;
    }

    @Override // com.contentsquare.android.sdk.Y6
    @NotNull
    public final String b() {
        return "null";
    }
}
