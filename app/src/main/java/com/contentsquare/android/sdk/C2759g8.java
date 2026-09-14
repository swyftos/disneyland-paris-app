package com.contentsquare.android.sdk;

import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.g8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2759g8 extends Lambda implements Function1<View, List<? extends SurfaceView>> {

    /* JADX INFO: renamed from: a */
    public static final C2759g8 f2671a = new C2759g8();

    public C2759g8() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final List<? extends SurfaceView> invoke(View view) {
        Sequence<View> children;
        Sequence map;
        Sequence sequenceFlattenSequenceOfIterable;
        View child = view;
        Intrinsics.checkNotNullParameter(child, "child");
        if ((child instanceof SurfaceView) && child.getWidth() > 0 && ((SurfaceView) child).getHeight() > 0) {
            return CollectionsKt.listOf(child);
        }
        ViewGroup viewGroup = child instanceof ViewGroup ? (ViewGroup) child : null;
        List<? extends SurfaceView> list = (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null || (map = SequencesKt.map(children, f2671a)) == null || (sequenceFlattenSequenceOfIterable = SequencesKt.flattenSequenceOfIterable(map)) == null) ? null : SequencesKt.toList(sequenceFlattenSequenceOfIterable);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
