package com.urbanairship.android.layout.widget;

import android.R;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.Dimension;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.android.layout.property.ScoreStyle;
import com.urbanairship.android.layout.property.TextAppearance;
import com.urbanairship.android.layout.shape.Shape;
import com.urbanairship.android.layout.util.LayoutUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/widget/ScoreItemView;", "Landroidx/appcompat/widget/AppCompatButton;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "label", "", "bindings", "Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings;", ViewProps.PADDING, "", "(Landroid/content/Context;Ljava/lang/String;Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings;I)V", "isChecked", "", "configure", "", "onCreateDrawableState", "", "extraSpace", "setChecked", "checked", "toggle", "updateTextState", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nScoreItemView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScoreItemView.kt\ncom/urbanairship/android/layout/widget/ScoreItemView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n163#2,2:112\n1#3:114\n*S KotlinDebug\n*F\n+ 1 ScoreItemView.kt\ncom/urbanairship/android/layout/widget/ScoreItemView\n*L\n57#1:112,2\n*E\n"})
/* loaded from: classes5.dex */
public final class ScoreItemView extends AppCompatButton implements Checkable {
    private final ScoreStyle.Bindings bindings;
    private final Context context;
    private boolean isChecked;
    private final String label;
    private final int padding;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScoreItemView(@NotNull Context context, @NotNull String label, @NotNull ScoreStyle.Bindings bindings, @Dimension(unit = 0) int i) {
        super(context, null, androidx.appcompat.R.style.Widget_AppCompat_Button_Borderless);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(bindings, "bindings");
        this.context = context;
        this.label = label;
        this.bindings = bindings;
        this.padding = i;
        setId(View.generateViewId());
        setAllCaps(false);
        setSingleLine(true);
        setIncludeFontPadding(true);
        StateListDrawable stateListDrawableBuildStateListDrawable = Shape.buildStateListDrawable(context, bindings.getSelected().getShapes(), bindings.getUnselected().getShapes(), null, null);
        Intrinsics.checkNotNullExpressionValue(stateListDrawableBuildStateListDrawable, "buildStateListDrawable(...)");
        setBackground(stateListDrawableBuildStateListDrawable);
        setForeground(ContextCompat.getDrawable(context, com.urbanairship.android.layout.R.drawable.ua_layout_imagebutton_ripple));
        configure();
    }

    private final void configure() {
        setText(this.label);
        updateTextState();
        int i = this.padding;
        setPadding(i, i, i, i);
    }

    private final void updateTextState() {
        TextAppearance textAppearance = this.bindings.getSelected().getTextAppearance();
        TextAppearance textAppearance2 = this.bindings.getUnselected().getTextAppearance();
        if (!this.isChecked) {
            textAppearance = textAppearance2;
        }
        post(new Runnable() { // from class: com.urbanairship.android.layout.widget.ScoreItemView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ScoreItemView.updateTextState$lambda$1(this.f$0);
            }
        });
        LayoutUtils.applyTextAppearance(this, textAppearance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTextState$lambda$1(ScoreItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Paint.FontMetrics fontMetrics = this$0.getPaint().getFontMetrics();
        this$0.setMinimumHeight(Math.max(LayoutUtils.dpToPx(this$0.context, 44), (int) (fontMetrics.descent - fontMetrics.ascent)));
        this$0.setMinimumWidth(this$0.getMinimumHeight());
        this$0.requestLayout();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (checked != this.isChecked) {
            this.isChecked = checked;
            refreshDrawableState();
            updateTextState();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.isChecked);
    }

    @Override // android.widget.TextView, android.view.View
    @NotNull
    public int[] onCreateDrawableState(int extraSpace) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        Intrinsics.checkNotNull(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/widget/ScoreItemView$Companion;", "", "()V", "CHECKED_STATE_SET", "", "getCHECKED_STATE_SET", "()[I", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final int[] getCHECKED_STATE_SET() {
            return ScoreItemView.CHECKED_STATE_SET;
        }
    }
}
