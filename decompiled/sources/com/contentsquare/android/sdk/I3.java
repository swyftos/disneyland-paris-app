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

/* loaded from: classes2.dex */
public final class I3 {

    @NotNull
    public final J3 a;

    public I3(@NotNull J3 pathFilter) {
        Intrinsics.checkNotNullParameter(pathFilter, "pathFilter");
        this.a = pathFilter;
    }

    public final void a(View view, StringBuilder sb, boolean z) {
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
                J3 j3 = this.a;
                Intrinsics.checkNotNullExpressionValue(child, "child");
                if (!j3.a(child, viewGroup)) {
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
                String strA = I4.a(view, "");
                Intrinsics.checkNotNullExpressionValue(strA, "getResourceEntryName(chi…rceUtils.EMPTY_STRING_ID)");
                if (strA.length() > 0) {
                    sb.append('#');
                    sb.append(strA);
                }
            }
        }
    }

    @NotNull
    public final String a(@Nullable View view) {
        StringBuilder sb = new StringBuilder("[root]");
        if (view != null) {
            a(view, sb);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "data.toString()");
        return string;
    }

    public final void a(View view, StringBuilder sb) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            String string = view.getClass().toString();
            Intrinsics.checkNotNullExpressionValue(string, "view.javaClass.toString()");
            if (StringsKt.endsWith$default(string, "DecorView", false, 2, (Object) null)) {
                return;
            }
            a((View) parent, sb);
            a(view, sb, true);
        }
    }
}
