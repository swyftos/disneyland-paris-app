package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.J3 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nPathFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathFilter.kt\ncom/contentsquare/android/analytics/internal/features/pathfilter/PathFilter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,22:1\n1747#2,3:23\n*S KotlinDebug\n*F\n+ 1 PathFilter.kt\ncom/contentsquare/android/analytics/internal/features/pathfilter/PathFilter\n*L\n18#1:23,3\n*E\n"})
public final class C2530J3 implements InterfaceC2540K3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final List<InterfaceC2540K3> f1742a = CollectionsKt.listOf((Object[]) new InterfaceC2540K3[]{new C2642U6(), new C2880t((ComposeInterface) C2714c3.f2440c.getValue())});

    @Override // com.contentsquare.android.sdk.InterfaceC2540K3
    /* JADX INFO: renamed from: a */
    public final boolean mo955a(@NotNull View thisView, @NotNull ViewGroup withThisParent) {
        Intrinsics.checkNotNullParameter(thisView, "thisView");
        Intrinsics.checkNotNullParameter(withThisParent, "withThisParent");
        List<InterfaceC2540K3> list = this.f1742a;
        if (list == null || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((InterfaceC2540K3) it.next()).mo955a(thisView, withThisParent)) {
                    return true;
                }
            }
        }
        return false;
    }
}
