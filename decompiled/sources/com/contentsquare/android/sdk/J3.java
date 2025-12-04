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

@SourceDebugExtension({"SMAP\nPathFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathFilter.kt\ncom/contentsquare/android/analytics/internal/features/pathfilter/PathFilter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,22:1\n1747#2,3:23\n*S KotlinDebug\n*F\n+ 1 PathFilter.kt\ncom/contentsquare/android/analytics/internal/features/pathfilter/PathFilter\n*L\n18#1:23,3\n*E\n"})
/* loaded from: classes2.dex */
public final class J3 implements K3 {

    @NotNull
    public final List<K3> a = CollectionsKt.listOf((Object[]) new K3[]{new U6(), new C0809t((ComposeInterface) C0644c3.c.getValue())});

    @Override // com.contentsquare.android.sdk.K3
    public final boolean a(@NotNull View thisView, @NotNull ViewGroup withThisParent) {
        Intrinsics.checkNotNullParameter(thisView, "thisView");
        Intrinsics.checkNotNullParameter(withThisParent, "withThisParent");
        List<K3> list = this.a;
        if (list == null || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((K3) it.next()).a(thisView, withThisParent)) {
                    return true;
                }
            }
        }
        return false;
    }
}
