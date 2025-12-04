package com.urbanairship.android.layout.util;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/layout/util/FullScreenAdjustResizeWorkaround;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "child", "Landroid/view/View;", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "previousUsableHeight", "", "adjustResizeIfNeeded", "", "getUsableHeight", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFullScreenAdjustResizeWorkaround.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullScreenAdjustResizeWorkaround.kt\ncom/urbanairship/android/layout/util/FullScreenAdjustResizeWorkaround\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,56:1\n1#2:57\n*E\n"})
/* loaded from: classes5.dex */
public final class FullScreenAdjustResizeWorkaround {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final View child;
    private final FrameLayout.LayoutParams layoutParams;
    private int previousUsableHeight;

    public /* synthetic */ FullScreenAdjustResizeWorkaround(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    private FullScreenAdjustResizeWorkaround(Activity activity) {
        View childAt = ((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
        this.child = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.urbanairship.android.layout.util.FullScreenAdjustResizeWorkaround$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                FullScreenAdjustResizeWorkaround._init_$lambda$0(this.f$0);
            }
        });
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        this.layoutParams = (FrameLayout.LayoutParams) layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(FullScreenAdjustResizeWorkaround this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.adjustResizeIfNeeded();
    }

    private final void adjustResizeIfNeeded() {
        int usableHeight = getUsableHeight();
        if (usableHeight != this.previousUsableHeight) {
            int height = this.child.getRootView().getHeight();
            int i = height - usableHeight;
            if (i > height / 4) {
                this.layoutParams.height = height - i;
            } else {
                this.layoutParams.height = height;
            }
            this.child.requestLayout();
            this.previousUsableHeight = usableHeight;
        }
    }

    private final int getUsableHeight() {
        Rect rect = new Rect();
        this.child.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/layout/util/FullScreenAdjustResizeWorkaround$Companion;", "", "()V", "applyAdjustResizeWorkaround", "", "Landroid/app/Activity;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void applyAdjustResizeWorkaround(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "<this>");
            new FullScreenAdjustResizeWorkaround(activity, null);
        }
    }
}
