package com.urbanairship.android.layout.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.EmbeddedPresentation;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.ConstrainedSize;
import com.urbanairship.android.layout.property.EmbeddedPlacement;
import com.urbanairship.android.layout.property.Margin;
import com.urbanairship.android.layout.property.Size;
import com.urbanairship.android.layout.util.ConstraintSetBuilder;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.widget.ClippableFrameLayout;
import com.urbanairship.android.layout.widget.ConstrainedFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001cBI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0007J\b\u0010\u001b\u001a\u00020\u0018H\u0003R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/layout/ui/ThomasEmbeddedView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "presentation", "Lcom/urbanairship/android/layout/EmbeddedPresentation;", "environment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "fillHeight", "", "fillWidth", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/EmbeddedPresentation;Lcom/urbanairship/android/layout/environment/ViewEnvironment;ZZ)V", TypedValues.AttributesType.S_FRAME, "Lcom/urbanairship/android/layout/widget/ConstrainedFrameLayout;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/android/layout/ui/ThomasEmbeddedView$Listener;", "getListener$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/ui/ThomasEmbeddedView$Listener;", "setListener$urbanairship_layout_release", "(Lcom/urbanairship/android/layout/ui/ThomasEmbeddedView$Listener;)V", "configure", "", "dismiss", "isInternal", "removeSelf", "Listener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThomasEmbeddedView extends ConstraintLayout {
    private final ViewEnvironment environment;
    private final boolean fillHeight;
    private final boolean fillWidth;
    private ConstrainedFrameLayout frame;
    private Listener listener;
    private final BaseModel model;
    private final EmbeddedPresentation presentation;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/ui/ThomasEmbeddedView$Listener;", "", "onDismissed", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onDismissed();
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Size.DimensionType.values().length];
            try {
                iArr[Size.DimensionType.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ ThomasEmbeddedView(Context context, BaseModel baseModel, EmbeddedPresentation embeddedPresentation, ViewEnvironment viewEnvironment, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, baseModel, embeddedPresentation, viewEnvironment, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThomasEmbeddedView(@NotNull Context context, @NotNull BaseModel<?, ?, ?> model, @NotNull EmbeddedPresentation presentation, @NotNull ViewEnvironment environment, boolean z, boolean z2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.model = model;
        this.presentation = presentation;
        this.environment = environment;
        this.fillHeight = z;
        this.fillWidth = z2;
        setId(model.getViewId());
        configure();
    }

    @Nullable
    /* renamed from: getListener$urbanairship_layout_release, reason: from getter */
    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener$urbanairship_layout_release(@Nullable Listener listener) {
        this.listener = listener;
    }

    private final void configure() {
        EmbeddedPresentation embeddedPresentation = this.presentation;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        EmbeddedPlacement resolvedPlacement = embeddedPresentation.getResolvedPlacement(context);
        ConstrainedSize size = resolvedPlacement.getSize();
        Margin margin = resolvedPlacement.getMargin();
        Size.DimensionType type = size.getWidth().getType();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i = iArr[type.ordinal()] == 1 ? -2 : -1;
        int i2 = iArr[size.getHeight().getType().ordinal()] == 1 ? -2 : -1;
        ClippableFrameLayout clippableFrameLayout = new ClippableFrameLayout(getContext());
        clippableFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        ConstrainedFrameLayout constrainedFrameLayout = new ConstrainedFrameLayout(getContext(), size);
        constrainedFrameLayout.setId(View.generateViewId());
        constrainedFrameLayout.setLayoutParams(new ConstraintLayout.LayoutParams(0, 0));
        this.frame = constrainedFrameLayout;
        LayoutUtils.applyBorderAndBackground(clippableFrameLayout, null, resolvedPlacement.getBorder(), resolvedPlacement.getBackgroundColor());
        BaseModel baseModel = this.model;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        clippableFrameLayout.addView(baseModel.createView(context2, this.environment, null));
        constrainedFrameLayout.addView(clippableFrameLayout);
        addView(constrainedFrameLayout);
        int id = constrainedFrameLayout.getId();
        ConstraintSetBuilder constraintSetBuilderConstrainWithinParent = ConstraintSetBuilder.newBuilder(getContext()).constrainWithinParent(id, margin);
        boolean z = this.fillHeight;
        if (z && this.fillWidth) {
            constraintSetBuilderConstrainWithinParent.matchConstraintWidth(id).matchConstraintHeight(id);
        } else if (z) {
            constraintSetBuilderConstrainWithinParent.width(size, id).matchConstraintHeight(id);
        } else if (this.fillWidth) {
            constraintSetBuilderConstrainWithinParent.matchConstraintWidth(id).height(size, id);
        } else {
            constraintSetBuilderConstrainWithinParent.size(size, id);
        }
        constraintSetBuilderConstrainWithinParent.build().applyTo(this);
    }

    @MainThread
    public final void dismiss(boolean isInternal) {
        Listener listener;
        removeSelf();
        if (isInternal || (listener = this.listener) == null) {
            return;
        }
        listener.onDismissed();
    }

    private final void removeSelf() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
            this.frame = null;
        }
    }
}
