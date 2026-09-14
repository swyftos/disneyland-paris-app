package com.contentsquare.android.sdk;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.j2 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nGestureTargetResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GestureTargetResolver.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/actioneventfactory/GestureTargetResolverChain\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,25:1\n1#2:26\n*E\n"})
public final class C2783j2 implements InterfaceC2773i2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final List<InterfaceC2773i2> f2764a;

    public C2783j2(@NotNull InterfaceC2773i2... resolvers) {
        Intrinsics.checkNotNullParameter(resolvers, "resolvers");
        this.f2764a = ArraysKt.toList(resolvers);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2773i2
    @Nullable
    /* JADX INFO: renamed from: a */
    public final C2763h2 mo1155a(@NotNull InterfaceC2773i2.a request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Iterator<T> it = this.f2764a.iterator();
        while (it.hasNext()) {
            C2763h2 c2763h2Mo1155a = ((InterfaceC2773i2) it.next()).mo1155a(request);
            if (c2763h2Mo1155a != null) {
                return c2763h2Mo1155a;
            }
        }
        return null;
    }
}
