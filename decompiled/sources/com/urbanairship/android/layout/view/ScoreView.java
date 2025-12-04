package com.urbanairship.android.layout.view;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.ScoreModel;
import com.urbanairship.android.layout.property.ScoreStyle;
import com.urbanairship.android.layout.util.ConstraintSetBuilder;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.widget.ScoreItemView;
import com.urbanairship.android.layout.widget.ShapeButton;
import com.urbanairship.android.layout.widget.TappableView;
import defpackage.WrappingViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001dH\u0002J8\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0017H\u0002J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0017H\u0002J\u0015\u0010)\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0,H\u0016J!\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\rH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018¨\u00065"}, d2 = {"Lcom/urbanairship/android/layout/view/ScoreView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/TappableView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/ScoreModel;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/ScoreModel;)V", "clicksChannel", "Lkotlinx/coroutines/channels/Channel;", "", "isEnabled", "", "scoreSelectedListener", "Lcom/urbanairship/android/layout/view/ScoreView$OnScoreSelectedListener;", "getScoreSelectedListener", "()Lcom/urbanairship/android/layout/view/ScoreView$OnScoreSelectedListener;", "setScoreSelectedListener", "(Lcom/urbanairship/android/layout/view/ScoreView$OnScoreSelectedListener;)V", "scoreToViewIds", "Landroid/util/SparseIntArray;", "selectedScore", "", "Ljava/lang/Integer;", "configureNumberRange", "style", "Lcom/urbanairship/android/layout/property/ScoreStyle$NumberRange;", "configureWrappingNumberRange", "Lcom/urbanairship/android/layout/property/ScoreStyle$WrappingNumberRange;", "createShapeButton", "Lcom/urbanairship/android/layout/widget/ShapeButton;", FirebaseAnalytics.Param.SCORE, "bindings", "Lcom/urbanairship/android/layout/property/ScoreStyle$Bindings;", "viewId", "constraints", "Lcom/urbanairship/android/layout/util/ConstraintSetBuilder;", ViewProps.MIN_HEIGHT, ViewProps.MIN_WIDTH, "onScoreClick", "setSelectedScore", "(Ljava/lang/Integer;)V", "taps", "Lkotlinx/coroutines/flow/Flow;", "updateCheckedState", "view", "Landroid/view/View;", "selectedId", "(Landroid/view/View;Ljava/lang/Integer;)V", "updateEnabledState", "enabled", "OnScoreSelectedListener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nScoreView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScoreView.kt\ncom/urbanairship/android/layout/view/ScoreView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,200:1\n1549#2:201\n1620#2,3:202\n1855#2,2:205\n*S KotlinDebug\n*F\n+ 1 ScoreView.kt\ncom/urbanairship/android/layout/view/ScoreView\n*L\n82#1:201\n82#1:202,3\n107#1:205,2\n*E\n"})
/* loaded from: classes5.dex */
public final class ScoreView extends ConstraintLayout implements BaseView, TappableView {
    private final Channel clicksChannel;
    private boolean isEnabled;
    private OnScoreSelectedListener scoreSelectedListener;
    private final SparseIntArray scoreToViewIds;
    private Integer selectedScore;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/view/ScoreView$OnScoreSelectedListener;", "", "onScoreSelected", "", FirebaseAnalytics.Param.SCORE, "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnScoreSelectedListener {
        void onScoreSelected(int score);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScoreView(@NotNull Context context, @NotNull ScoreModel model) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        this.clicksChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.scoreToViewIds = new SparseIntArray();
        this.isEnabled = true;
        setClipChildren(false);
        ScoreStyle style = model.getViewInfo().getStyle();
        if (style instanceof ScoreStyle.NumberRange) {
            configureNumberRange((ScoreStyle.NumberRange) style);
        } else if (style instanceof ScoreStyle.WrappingNumberRange) {
            configureWrappingNumberRange((ScoreStyle.WrappingNumberRange) style);
        }
        StringExtensionsKt.ifNotEmpty(model.contentDescription(context), new Function1() { // from class: com.urbanairship.android.layout.view.ScoreView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ScoreView.this.setContentDescription(it);
            }
        });
        model.setListener$urbanairship_layout_release(new ScoreModel.Listener() { // from class: com.urbanairship.android.layout.view.ScoreView.2
            @Override // com.urbanairship.android.layout.model.ScoreModel.Listener
            public void onSetSelectedScore(@Nullable Integer value) {
                if (value != null) {
                    ScoreView.this.setSelectedScore(Integer.valueOf(value.intValue()));
                }
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                ScoreView.this.updateEnabledState(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                ScoreView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(ScoreView.this, old, background);
            }
        });
    }

    @Nullable
    public final OnScoreSelectedListener getScoreSelectedListener() {
        return this.scoreSelectedListener;
    }

    public final void setScoreSelectedListener(@Nullable OnScoreSelectedListener onScoreSelectedListener) {
        this.scoreSelectedListener = onScoreSelectedListener;
    }

    private final void configureNumberRange(ScoreStyle.NumberRange style) {
        ConstraintSetBuilder constraintSetBuilderNewBuilder = ConstraintSetBuilder.newBuilder(getContext());
        Intrinsics.checkNotNullExpressionValue(constraintSetBuilderNewBuilder, "newBuilder(...)");
        ScoreStyle.Bindings bindings = style.getBindings();
        IntRange intRange = new IntRange(style.getStart(), style.getEnd());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            int iGenerateViewId = View.generateViewId();
            ShapeButton shapeButtonCreateShapeButton = createShapeButton(iNextInt, bindings, iGenerateViewId, constraintSetBuilderNewBuilder, 16, 16);
            this.scoreToViewIds.append(iNextInt, iGenerateViewId);
            addView(shapeButtonCreateShapeButton, new ConstraintLayout.LayoutParams(0, 0));
            arrayList.add(Integer.valueOf(iGenerateViewId));
        }
        int[] intArray = CollectionsKt.toIntArray(arrayList);
        constraintSetBuilderNewBuilder.setHorizontalChainStyle(intArray, 2).createHorizontalChainInParent(intArray, 0, style.getSpacing()).build().applyTo(this);
    }

    private final void configureWrappingNumberRange(ScoreStyle.WrappingNumberRange style) {
        int iGenerateViewId = View.generateViewId();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WrappingViewGroup wrappingViewGroup = new WrappingViewGroup(context, null, 0, 6, null);
        wrappingViewGroup.setId(iGenerateViewId);
        wrappingViewGroup.setItemSpacing(LayoutUtils.dpToPx(wrappingViewGroup.getContext(), style.getSpacing()));
        wrappingViewGroup.setLineSpacing(LayoutUtils.dpToPx(wrappingViewGroup.getContext(), style.getWrapping().getLineSpacing()));
        wrappingViewGroup.setMaxItemsPerLine(style.getWrapping().getMaxItemsPerLine());
        Iterator<Integer> it = new IntRange(style.getStart(), style.getEnd()).iterator();
        while (it.hasNext()) {
            final int iNextInt = ((IntIterator) it).nextInt();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            ScoreItemView scoreItemView = new ScoreItemView(context2, String.valueOf(iNextInt), style.getBindings(), 0);
            InstrumentationCallbacks.setOnClickListenerCalled(scoreItemView, new View.OnClickListener() { // from class: com.urbanairship.android.layout.view.ScoreView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ScoreView.configureWrappingNumberRange$lambda$4$lambda$3$lambda$2(this.f$0, iNextInt, view);
                }
            });
            this.scoreToViewIds.append(iNextInt, scoreItemView.getId());
            wrappingViewGroup.addView(scoreItemView);
        }
        addView(wrappingViewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configureWrappingNumberRange$lambda$4$lambda$3$lambda$2(ScoreView this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onScoreClick(i);
    }

    private final ShapeButton createShapeButton(final int score, ScoreStyle.Bindings bindings, int viewId, ConstraintSetBuilder constraints, int minHeight, int minWidth) {
        ShapeButton shapeButton = new ShapeButton(getContext(), bindings.getSelected().getShapes(), bindings.getUnselected().getShapes(), String.valueOf(score), bindings.getSelected().getTextAppearance(), bindings.getUnselected().getTextAppearance());
        shapeButton.setId(viewId);
        InstrumentationCallbacks.setOnClickListenerCalled(shapeButton, new View.OnClickListener() { // from class: com.urbanairship.android.layout.view.ScoreView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScoreView.createShapeButton$lambda$6$lambda$5(this.f$0, score, view);
            }
        });
        constraints.squareAspectRatio(viewId);
        constraints.minWidth(viewId, minWidth);
        constraints.minHeight(viewId, minHeight);
        return shapeButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createShapeButton$lambda$6$lambda$5(ScoreView this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onScoreClick(i);
    }

    static /* synthetic */ void updateCheckedState$default(ScoreView scoreView, View view, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        scoreView.updateCheckedState(view, num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateCheckedState(View view, Integer selectedId) {
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(selectedId != null && view.getId() == selectedId.intValue());
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                updateCheckedState(childAt, selectedId);
            }
        }
    }

    public final void setSelectedScore(@Nullable Integer score) {
        this.selectedScore = score;
        if (score != null) {
            updateCheckedState(this, Integer.valueOf(this.scoreToViewIds.get(score.intValue(), -1)));
        } else {
            updateCheckedState$default(this, this, null, 2, null);
        }
    }

    private final void onScoreClick(int score) {
        if (this.isEnabled) {
            Integer num = this.selectedScore;
            if (num != null && score == num.intValue()) {
                return;
            }
            this.selectedScore = Integer.valueOf(score);
            setSelectedScore(Integer.valueOf(score));
            OnScoreSelectedListener onScoreSelectedListener = this.scoreSelectedListener;
            if (onScoreSelectedListener != null) {
                onScoreSelectedListener.onScoreSelected(score);
            }
            this.clicksChannel.mo3620trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEnabledState(boolean enabled) {
        this.isEnabled = enabled;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(enabled);
        }
    }

    @Override // com.urbanairship.android.layout.widget.TappableView
    @NotNull
    public Flow<Unit> taps() {
        return FlowKt.receiveAsFlow(this.clicksChannel);
    }
}
