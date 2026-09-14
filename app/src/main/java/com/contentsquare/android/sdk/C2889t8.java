package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.communication.compose.ViewNode;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.t8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2889t8 implements InterfaceC2679Y6 {

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final C2520I3 f3127b = new C2520I3(new C2530J3());

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f3128a;

    public C2889t8(@NotNull View containerView, @NotNull ViewNode view) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(view, "view");
        String strM939a = f3127b.m939a(containerView);
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        C2879s8.m1200a(view, arrayList);
        this.f3128a = ArraysKt.joinToString$default(new String[]{strM939a, CollectionsKt.joinToString$default(arrayList, ">", null, null, 0, null, null, 62, null)}, ">", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2679Y6
    @NotNull
    /* JADX INFO: renamed from: a */
    public final String mo1022a() {
        return this.f3128a;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2679Y6
    @NotNull
    /* JADX INFO: renamed from: b */
    public final String mo1023b() {
        return "null";
    }
}
