package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.InterfaceC0703i2;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGestureTargetResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GestureTargetResolver.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/actioneventfactory/GestureTargetResolverChain\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,25:1\n1#2:26\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.j2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0713j2 implements InterfaceC0703i2 {

    @NotNull
    public final List<InterfaceC0703i2> a;

    public C0713j2(@NotNull InterfaceC0703i2... resolvers) {
        Intrinsics.checkNotNullParameter(resolvers, "resolvers");
        this.a = ArraysKt.toList(resolvers);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC0703i2
    @Nullable
    public final C0693h2 a(@NotNull InterfaceC0703i2.a request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            C0693h2 c0693h2A = ((InterfaceC0703i2) it.next()).a(request);
            if (c0693h2A != null) {
                return c0693h2A;
            }
        }
        return null;
    }
}
