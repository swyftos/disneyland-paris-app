package com.urbanairship.reactnative;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.urbanairship.embedded.AirshipEmbeddedView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/reactnative/ReactEmbeddedView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "embeddedId", "", "load", "", "requestLayout", "measureAndLayout", "Ljava/lang/Runnable;", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactEmbeddedView extends FrameLayout {
    private String embeddedId;
    private final Runnable measureAndLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactEmbeddedView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.measureAndLayout = new Runnable() { // from class: com.urbanairship.reactnative.ReactEmbeddedView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ReactEmbeddedView.measureAndLayout$lambda$0(this.f$0);
            }
        };
    }

    public final void load(@NotNull String embeddedId) {
        Intrinsics.checkNotNullParameter(embeddedId, "embeddedId");
        if (Intrinsics.areEqual(this.embeddedId, embeddedId)) {
            return;
        }
        removeAllViews();
        this.embeddedId = embeddedId;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        addView(new AirshipEmbeddedView(context, embeddedId, null, null, 12, null));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void measureAndLayout$lambda$0(ReactEmbeddedView reactEmbeddedView) {
        reactEmbeddedView.measure(View.MeasureSpec.makeMeasureSpec(reactEmbeddedView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(reactEmbeddedView.getHeight(), 1073741824));
        reactEmbeddedView.layout(reactEmbeddedView.getLeft(), reactEmbeddedView.getTop(), reactEmbeddedView.getRight(), reactEmbeddedView.getBottom());
    }
}
