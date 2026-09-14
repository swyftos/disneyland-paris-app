package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.I3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2520I3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2530J3 f1705a;

    public C2520I3(@NotNull C2530J3 pathFilter) {
        Intrinsics.checkNotNullParameter(pathFilter, "pathFilter");
        this.f1705a = pathFilter;
    }

    /* JADX INFO: renamed from: a */
    public final void m941a(View view, StringBuilder sb, boolean z) {
        ViewParent parent = view.getParent();
        String string = view.getClass().toString();
        Intrinsics.checkNotNullExpressionValue(string, "view.javaClass.toString()");
        int i = 0;
        if (StringsKt.endsWith$default(string, "DecorView", false, 2, (Object) null)) {
            sb.append("[root]");
            return;
        }
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            int childAdapterPosition = 0;
            while (true) {
                if (i >= childCount) {
                    childAdapterPosition = -1;
                    break;
                }
                View child = viewGroup.getChildAt(i);
                if (child == view) {
                    break;
                }
                C2530J3 c2530j3 = this.f1705a;
                Intrinsics.checkNotNullExpressionValue(child, "child");
                if (!c2530j3.mo955a(child, viewGroup)) {
                    childAdapterPosition++;
                }
                i++;
            }
            if (childAdapterPosition != -1) {
                if (z) {
                    sb.append(Typography.greater);
                }
                sb.append(view.getClass().getSimpleName());
                if (viewGroup instanceof RecyclerView) {
                    childAdapterPosition = ((RecyclerView) viewGroup).getChildAdapterPosition(view);
                }
                sb.append(":eq(");
                sb.append(childAdapterPosition);
                sb.append(")");
                String strM942a = C2521I4.m942a(view, "");
                Intrinsics.checkNotNullExpressionValue(strM942a, "getResourceEntryName(chi…rceUtils.EMPTY_STRING_ID)");
                if (strM942a.length() > 0) {
                    sb.append('#');
                    sb.append(strM942a);
                }
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final String m939a(@Nullable View view) {
        StringBuilder sb = new StringBuilder("[root]");
        if (view != null) {
            m940a(view, sb);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "data.toString()");
        return string;
    }

    /* JADX INFO: renamed from: a */
    public final void m940a(View view, StringBuilder sb) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            String string = view.getClass().toString();
            Intrinsics.checkNotNullExpressionValue(string, "view.javaClass.toString()");
            if (StringsKt.endsWith$default(string, "DecorView", false, 2, (Object) null)) {
                return;
            }
            m940a((View) parent, sb);
            m941a(view, sb, true);
        }
    }
}
