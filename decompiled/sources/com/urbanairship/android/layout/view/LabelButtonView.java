package com.urbanairship.android.layout.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.R;
import com.dlp.BluetoothManager;
import com.google.android.material.button.MaterialButton;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.info.LabelButtonInfo;
import com.urbanairship.android.layout.info.LabelInfo;
import com.urbanairship.android.layout.model.ButtonModel;
import com.urbanairship.android.layout.model.LabelButtonModel;
import com.urbanairship.android.layout.property.HorizontalPosition;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.widget.TappableView;
import com.urbanairship.util.UAStringUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/layout/view/LabelButtonView;", "Lcom/google/android/material/button/MaterialButton;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/TappableView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/LabelButtonModel;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/LabelButtonModel;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "resolveText", "", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/environment/ThomasState;", "taps", "Lkotlinx/coroutines/flow/Flow;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LabelButtonView extends MaterialButton implements BaseView, TappableView {
    private LabelButtonModel model;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, java.lang.String] */
    public LabelButtonView(@NotNull final Context context, @NotNull LabelButtonModel model) {
        super(context, null, R.attr.borderlessButtonStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        setAllCaps(false);
        setMinHeight(0);
        setMinimumHeight(0);
        setInsetTop(0);
        setInsetBottom(0);
        LayoutUtils.applyLabelModel(this, this.model.getLabel(), ((LabelButtonInfo) this.model.getViewInfo()).getLabel().getText());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = ((LabelButtonInfo) this.model.getViewInfo()).getLabel().getText();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        setSingleLine(false);
        setIncludeFontPadding(false);
        setEllipsize(TextUtils.TruncateAt.END);
        String strContentDescription = this.model.contentDescription(context);
        if (strContentDescription != null) {
            StringExtensionsKt.ifNotEmpty(strContentDescription, new Function1() { // from class: com.urbanairship.android.layout.view.LabelButtonView.1
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
                    LabelButtonView.this.setContentDescription(it);
                }
            });
        }
        this.model.setListener$urbanairship_layout_release(new ButtonModel.Listener() { // from class: com.urbanairship.android.layout.view.LabelButtonView.2
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                LabelButtonView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                LabelButtonView.this.setVisibility(visible ? 0 : 8);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object, java.lang.String] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [T, android.graphics.drawable.Drawable] */
            /* JADX WARN: Type inference failed for: r2v7 */
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void onStateUpdated(@NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                ?? ResolveText = LabelButtonView.this.resolveText(state);
                if (!Intrinsics.areEqual((Object) ResolveText, objectRef.element)) {
                    LabelButtonView labelButtonView = LabelButtonView.this;
                    LayoutUtils.applyLabelModel(labelButtonView, labelButtonView.model.getLabel(), ResolveText);
                    objectRef.element = ResolveText;
                }
                LabelInfo.ViewOverrides viewOverrides = ((LabelButtonInfo) LabelButtonView.this.model.getViewInfo()).getLabel().getViewOverrides();
                ?? drawable = 0;
                LabelInfo.IconStart iconStart = (LabelInfo.IconStart) state.resolveOptional(viewOverrides != null ? viewOverrides.getIconStart() : null, ((LabelButtonInfo) LabelButtonView.this.model.getViewInfo()).getLabel().getIconStart());
                if (iconStart instanceof LabelInfo.IconStart.Floating) {
                    drawable = ((LabelInfo.IconStart.Floating) iconStart).getIcon().getDrawable(context, LabelButtonView.this.isEnabled(), ViewExtensionsKt.isLayoutRtl(LabelButtonView.this) ? HorizontalPosition.END : HorizontalPosition.START);
                }
                if (drawable == 0 && objectRef2.element != 0) {
                    LabelButtonView labelButtonView2 = LabelButtonView.this;
                    LayoutUtils.applyLabelModel(labelButtonView2, labelButtonView2.model.getLabel(), ResolveText);
                }
                objectRef2.element = drawable;
                if (drawable != 0) {
                    Context context2 = context;
                    LabelButtonView labelButtonView3 = LabelButtonView.this;
                    int iSpToPx = (int) ResourceUtils.spToPx(context2, ((LabelButtonInfo) labelButtonView3.model.getViewInfo()).getLabel().getTextAppearance().getFontSize());
                    drawable.setBounds(0, 0, (iconStart != null ? (int) ResourceUtils.spToPx(context2, iconStart.getSpace()) : 0) + iSpToPx, iSpToPx);
                    Image.CenteredImageSpan centeredImageSpan = new Image.CenteredImageSpan(drawable);
                    if (ViewExtensionsKt.isLayoutRtl(labelButtonView3)) {
                        SpannableString spannableString = new SpannableString(((String) ResolveText) + ' ');
                        spannableString.setSpan(centeredImageSpan, spannableString.length() - 1, spannableString.length(), 33);
                        labelButtonView3.setText(spannableString);
                        return;
                    }
                    SpannableString spannableString2 = new SpannableString(' ' + ((String) ResolveText));
                    spannableString2.setSpan(centeredImageSpan, 0, 1, 33);
                    labelButtonView3.setText(spannableString2);
                }
            }

            @Override // com.urbanairship.android.layout.model.ButtonModel.Listener
            public void dismissSoftKeyboard() {
                LayoutUtils.dismissSoftKeyboard(LabelButtonView.this);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void setBackground(@org.jetbrains.annotations.Nullable com.urbanairship.android.layout.model.Background r11, @org.jetbrains.annotations.NotNull com.urbanairship.android.layout.model.Background r12) {
                /*
                    r10 = this;
                    java.lang.String r11 = "new"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r11)
                    com.urbanairship.android.layout.property.Border r11 = r12.getBorder()
                    com.urbanairship.android.layout.property.Color r12 = r12.getColor()
                    com.urbanairship.android.layout.view.LabelButtonView r0 = com.urbanairship.android.layout.view.LabelButtonView.this
                    com.urbanairship.android.layout.model.LabelButtonModel r0 = com.urbanairship.android.layout.view.LabelButtonView.access$getModel$p(r0)
                    com.urbanairship.android.layout.model.LabelModel r0 = r0.getLabel()
                    com.urbanairship.android.layout.info.View r0 = r0.getViewInfo()
                    com.urbanairship.android.layout.info.LabelInfo r0 = (com.urbanairship.android.layout.info.LabelInfo) r0
                    com.urbanairship.android.layout.property.TextAppearance r0 = r0.getTextAppearance()
                    com.urbanairship.android.layout.property.Color r0 = r0.getColor()
                    android.content.Context r1 = r3
                    int r0 = r0.resolve(r1)
                    r1 = 0
                    if (r12 == 0) goto L35
                    android.content.Context r2 = r3
                    int r12 = r12.resolve(r2)
                    goto L36
                L35:
                    r12 = r1
                L36:
                    com.urbanairship.android.layout.view.LabelButtonView r2 = com.urbanairship.android.layout.view.LabelButtonView.this
                    com.urbanairship.android.layout.model.LabelButtonModel r2 = com.urbanairship.android.layout.view.LabelButtonView.access$getModel$p(r2)
                    com.urbanairship.android.layout.info.View r2 = r2.getViewInfo()
                    com.urbanairship.android.layout.info.LabelButtonInfo r2 = (com.urbanairship.android.layout.info.LabelButtonInfo) r2
                    com.urbanairship.android.layout.property.TapEffect r2 = r2.getTapEffect()
                    boolean r2 = r2 instanceof com.urbanairship.android.layout.property.TapEffect.None
                    if (r2 == 0) goto L4c
                    r0 = r1
                    goto L5c
                L4c:
                    float r2 = com.urbanairship.android.layout.property.Color.alpha(r0)
                    r3 = 1045220557(0x3e4ccccd, float:0.2)
                    float r2 = r2 * r3
                    int r2 = java.lang.Math.round(r2)
                    int r0 = androidx.core.graphics.ColorUtils.setAlphaComponent(r0, r2)
                L5c:
                    int r2 = com.urbanairship.android.layout.util.LayoutUtils.generateDisabledColor(r12)
                    if (r11 == 0) goto L6b
                    java.lang.Integer r3 = r11.strokeWidth
                    if (r3 == 0) goto L6b
                    int r3 = r3.intValue()
                    goto L6c
                L6b:
                    r3 = 2
                L6c:
                    if (r11 == 0) goto L79
                    com.urbanairship.android.layout.property.Color r4 = r11.strokeColor
                    if (r4 == 0) goto L79
                    android.content.Context r5 = r3
                    int r4 = r4.resolve(r5)
                    goto L7a
                L79:
                    r4 = r12
                L7a:
                    int r5 = com.urbanairship.android.layout.util.LayoutUtils.generateDisabledColor(r4)
                    com.google.android.material.shape.ShapeAppearanceModel$Builder r6 = com.google.android.material.shape.ShapeAppearanceModel.builder()
                    java.lang.String r7 = "builder(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                    r7 = 1
                    if (r11 == 0) goto L98
                    com.urbanairship.android.layout.view.LabelButtonView$2$setBackground$1 r8 = new com.urbanairship.android.layout.view.LabelButtonView$2$setBackground$1
                    android.content.Context r9 = r3
                    r8.<init>()
                    boolean r11 = r11.applyToShape(r6, r8)
                    if (r11 != r7) goto L98
                    goto La1
                L98:
                    android.content.Context r11 = r3
                    float r11 = com.urbanairship.android.layout.util.ResourceUtils.dpToPx(r11, r1)
                    r6.setAllCorners(r1, r11)
                La1:
                    com.urbanairship.android.layout.view.LabelButtonView r11 = com.urbanairship.android.layout.view.LabelButtonView.this
                    r11.setClipToOutline(r7)
                    com.urbanairship.android.layout.view.LabelButtonView r11 = com.urbanairship.android.layout.view.LabelButtonView.this
                    com.urbanairship.android.layout.util.ColorStateListBuilder r1 = new com.urbanairship.android.layout.util.ColorStateListBuilder
                    r1.<init>()
                    r7 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
                    int[] r8 = new int[]{r7}
                    com.urbanairship.android.layout.util.ColorStateListBuilder r1 = r1.add(r2, r8)
                    com.urbanairship.android.layout.util.ColorStateListBuilder r12 = r1.add(r12)
                    android.content.res.ColorStateList r12 = r12.build()
                    r11.setBackgroundTintList(r12)
                    com.urbanairship.android.layout.view.LabelButtonView r11 = com.urbanairship.android.layout.view.LabelButtonView.this
                    android.content.res.ColorStateList r12 = android.content.res.ColorStateList.valueOf(r0)
                    r11.setRippleColor(r12)
                    com.urbanairship.android.layout.view.LabelButtonView r11 = com.urbanairship.android.layout.view.LabelButtonView.this
                    android.content.Context r12 = r3
                    float r12 = com.urbanairship.android.layout.util.ResourceUtils.dpToPx(r12, r3)
                    int r12 = (int) r12
                    r11.setStrokeWidth(r12)
                    com.urbanairship.android.layout.view.LabelButtonView r11 = com.urbanairship.android.layout.view.LabelButtonView.this
                    com.urbanairship.android.layout.util.ColorStateListBuilder r12 = new com.urbanairship.android.layout.util.ColorStateListBuilder
                    r12.<init>()
                    int[] r0 = new int[]{r7}
                    com.urbanairship.android.layout.util.ColorStateListBuilder r12 = r12.add(r5, r0)
                    com.urbanairship.android.layout.util.ColorStateListBuilder r12 = r12.add(r4)
                    android.content.res.ColorStateList r12 = r12.build()
                    r11.setStrokeColor(r12)
                    com.urbanairship.android.layout.view.LabelButtonView r11 = com.urbanairship.android.layout.view.LabelButtonView.this
                    com.google.android.material.shape.ShapeAppearanceModel r12 = r6.build()
                    r11.setShapeAppearanceModel(r12)
                    com.urbanairship.android.layout.view.LabelButtonView r10 = com.urbanairship.android.layout.view.LabelButtonView.this
                    r10.invalidate()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.view.LabelButtonView.AnonymousClass2.setBackground(com.urbanairship.android.layout.model.Background, com.urbanairship.android.layout.model.Background):void");
            }
        });
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int strokeWidth = getStrokeWidth();
        boolean z = View.MeasureSpec.getMode(heightMeasureSpec) != 1073741824;
        boolean z2 = View.MeasureSpec.getMode(widthMeasureSpec) != 1073741824;
        if (z || z2) {
            int iDpToPx = (int) ResourceUtils.dpToPx(getContext(), 12);
            int i = (z2 ? iDpToPx : 0) + strokeWidth;
            int i2 = (z ? iDpToPx : 0) + strokeWidth;
            setPadding(i, i2, i, i2);
        } else {
            setPadding(strokeWidth, strokeWidth, strokeWidth, strokeWidth);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // com.urbanairship.android.layout.widget.TappableView
    @NotNull
    public Flow<Unit> taps() {
        return ViewExtensionsKt.debouncedClicks$default(this, 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String resolveText(ThomasState state) {
        LabelInfo.ViewOverrides viewOverrides = ((LabelButtonInfo) this.model.getViewInfo()).getLabel().getViewOverrides();
        String str = (String) state.resolveOptional(viewOverrides != null ? viewOverrides.getRef() : null, ((LabelButtonInfo) this.model.getViewInfo()).getLabel().getRef());
        LabelInfo.ViewOverrides viewOverrides2 = ((LabelButtonInfo) this.model.getViewInfo()).getLabel().getViewOverrides();
        Object objResolveRequired = state.resolveRequired(viewOverrides2 != null ? viewOverrides2.getText() : null, ((LabelButtonInfo) this.model.getViewInfo()).getLabel().getText());
        Intrinsics.checkNotNullExpressionValue(objResolveRequired, "resolveRequired(...)");
        String str2 = (String) objResolveRequired;
        if (str == null) {
            return str2;
        }
        String strNamedStringResource = UAStringUtil.namedStringResource(getContext(), str, str2);
        Intrinsics.checkNotNull(strNamedStringResource);
        return strNamedStringResource;
    }
}
