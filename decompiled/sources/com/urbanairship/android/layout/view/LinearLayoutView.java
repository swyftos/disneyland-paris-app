package com.urbanairship.android.layout.view;

import android.animation.LayoutTransition;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.BV.LinearGradient.LinearGradientManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.LinearLayoutItemInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.ItemProperties;
import com.urbanairship.android.layout.model.LinearLayoutModel;
import com.urbanairship.android.layout.property.Direction;
import com.urbanairship.android.layout.property.Margin;
import com.urbanairship.android.layout.property.Size;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.android.layout.widget.Clippable;
import com.urbanairship.android.layout.widget.ClippableViewDelegate;
import com.urbanairship.android.layout.widget.ShrinkableView;
import com.urbanairship.android.layout.widget.WeightlessLinearLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/layout/view/LinearLayoutView;", "Lcom/urbanairship/android/layout/widget/WeightlessLinearLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/Clippable;", "Lcom/urbanairship/android/layout/widget/ShrinkableView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/LinearLayoutModel;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/LinearLayoutModel;Lcom/urbanairship/android/layout/environment/ViewEnvironment;)V", "clippableViewDelegate", "Lcom/urbanairship/android/layout/widget/ClippableViewDelegate;", "addItems", "", "items", "", "Lcom/urbanairship/android/layout/model/LinearLayoutModel$Item;", "generateItemLayoutParams", "Lcom/urbanairship/android/layout/widget/WeightlessLinearLayout$LayoutParams;", "itemInfo", "Lcom/urbanairship/android/layout/info/LinearLayoutItemInfo;", "isShrinkable", "", "setClipPathBorderRadius", "borderRadius", "", LinearGradientManager.PROP_BORDER_RADII, "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LinearLayoutView extends WeightlessLinearLayout implements BaseView, Clippable, ShrinkableView {
    private final ClippableViewDelegate clippableViewDelegate;
    private final LinearLayoutModel model;
    private final ViewEnvironment viewEnvironment;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Size.DimensionType.values().length];
            try {
                iArr[Size.DimensionType.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Size.DimensionType.ABSOLUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Size.DimensionType.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearLayoutView(@NotNull Context context, @NotNull LinearLayoutModel model, @NotNull ViewEnvironment viewEnvironment) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.model = model;
        this.viewEnvironment = viewEnvironment;
        this.clippableViewDelegate = new ClippableViewDelegate();
        setClipChildren(false);
        Direction direction = model.getViewInfo().getDirection();
        Direction direction2 = Direction.VERTICAL;
        setOrientation(direction == direction2 ? 1 : 0);
        setGravity(model.getViewInfo().getDirection() != direction2 ? 16 : 1);
        addItems(model.getItems());
        model.setListener$urbanairship_layout_release(new BaseModel.Listener() { // from class: com.urbanairship.android.layout.view.LinearLayoutView.1
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                LinearLayoutView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                LinearLayoutView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(LinearLayoutView.this, old, background);
            }
        });
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.disableTransitionType(2);
        setLayoutTransition(layoutTransition);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.android.layout.view.LinearLayoutView$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return LinearLayoutView._init_$lambda$1(this.f$0, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat _init_$lambda$1(LinearLayoutView this$0, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "<anonymous parameter 1>");
        WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setInsets(WindowInsetsCompat.Type.systemBars(), Insets.NONE).build();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatBuild, "build(...)");
        int childCount = this$0.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.dispatchApplyWindowInsets(this$0.getChildAt(i), windowInsetsCompatBuild);
        }
        return windowInsetsCompatBuild;
    }

    @Override // com.urbanairship.android.layout.widget.ShrinkableView
    public boolean isShrinkable() {
        return this.model.getIsShrinkable();
    }

    private final void addItems(List items) {
        int size = items.size();
        for (int i = 0; i < size; i++) {
            LinearLayoutModel.Item item = (LinearLayoutModel.Item) items.get(i);
            LinearLayoutItemInfo info = item.getInfo();
            BaseModel<?, ?, ?> baseModelComponent2 = item.component2();
            WeightlessLinearLayout.LayoutParams layoutParamsGenerateItemLayoutParams = generateItemLayoutParams(info);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            View viewCreateView = baseModelComponent2.createView(context, this.viewEnvironment, new ItemProperties(info.getSize()));
            viewCreateView.setLayoutParams(layoutParamsGenerateItemLayoutParams);
            addViewInLayout(viewCreateView, -1, layoutParamsGenerateItemLayoutParams, true);
        }
    }

    private final WeightlessLinearLayout.LayoutParams generateItemLayoutParams(LinearLayoutItemInfo itemInfo) {
        Pair pair;
        Pair pair2;
        Size size = itemInfo.getSize();
        Size.Dimension width = size.getWidth();
        Intrinsics.checkNotNullExpressionValue(width, "getWidth(...)");
        Size.Dimension height = size.getHeight();
        Intrinsics.checkNotNullExpressionValue(height, "getHeight(...)");
        Size.DimensionType type = width.getType();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i = iArr[type.ordinal()];
        if (i == 1) {
            pair = TuplesKt.to(-2, Float.valueOf(BitmapDescriptorFactory.HUE_RED));
        } else if (i == 2) {
            pair = TuplesKt.to(Integer.valueOf((int) ResourceUtils.dpToPx(getContext(), width.getInt())), Float.valueOf(BitmapDescriptorFactory.HUE_RED));
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            pair = TuplesKt.to(0, Float.valueOf(width.getFloat()));
        }
        int iIntValue = ((Number) pair.component1()).intValue();
        float fFloatValue = ((Number) pair.component2()).floatValue();
        int i2 = iArr[height.getType().ordinal()];
        if (i2 == 1) {
            pair2 = TuplesKt.to(-2, Float.valueOf(BitmapDescriptorFactory.HUE_RED));
        } else if (i2 == 2) {
            pair2 = TuplesKt.to(Integer.valueOf((int) ResourceUtils.dpToPx(getContext(), height.getInt())), Float.valueOf(BitmapDescriptorFactory.HUE_RED));
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            pair2 = TuplesKt.to(0, Float.valueOf(height.getFloat()));
        }
        WeightlessLinearLayout.LayoutParams layoutParams = new WeightlessLinearLayout.LayoutParams(iIntValue, ((Number) pair2.component1()).intValue(), fFloatValue, ((Number) pair2.component2()).floatValue());
        Margin margin = itemInfo.getMargin();
        if (margin != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) ResourceUtils.dpToPx(getContext(), margin.getTop());
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ResourceUtils.dpToPx(getContext(), margin.getBottom());
            layoutParams.setMarginStart((int) ResourceUtils.dpToPx(getContext(), margin.getStart()));
            layoutParams.setMarginEnd((int) ResourceUtils.dpToPx(getContext(), margin.getEnd()));
        }
        return layoutParams;
    }

    @Override // com.urbanairship.android.layout.widget.Clippable
    public void setClipPathBorderRadius(float borderRadius) {
        this.clippableViewDelegate.setClipPathBorderRadius(this, borderRadius);
    }

    @Override // com.urbanairship.android.layout.widget.Clippable
    public void setClipPathBorderRadius(@Nullable float[] borderRadii) {
        this.clippableViewDelegate.setClipPathBorderRadii(this, borderRadii);
    }
}
