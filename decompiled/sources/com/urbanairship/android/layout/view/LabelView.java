package com.urbanairship.android.layout.view;

import android.content.Context;
import android.text.SpannableString;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.info.LabelInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.LabelModel;
import com.urbanairship.android.layout.property.HorizontalPosition;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.util.UAStringUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/android/layout/view/LabelView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/urbanairship/android/layout/view/BaseView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/LabelModel;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/LabelModel;)V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LabelView extends AppCompatTextView implements BaseView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.String] */
    public LabelView(@NotNull final Context context, @NotNull final LabelModel model) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        LayoutUtils.applyLabelModel(this, model, model.getViewInfo().getText());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = model.getViewInfo().getText();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        StringExtensionsKt.ifNotEmpty(model.contentDescription(context), new Function1() { // from class: com.urbanairship.android.layout.view.LabelView.1
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
                LabelView.this.setContentDescription(it);
            }
        });
        if (Intrinsics.areEqual(model.getViewInfo().getAccessibilityHidden(), Boolean.TRUE)) {
            setImportantForAccessibility(2);
        }
        LabelInfo.AccessibilityRole accessibilityRole = model.getViewInfo().getAccessibilityRole();
        ViewCompat.setAccessibilityHeading(this, (accessibilityRole != null ? accessibilityRole.getType() : null) == LabelInfo.AccessibilityRoleType.HEADING);
        setClickable(false);
        model.setListener$urbanairship_layout_release(new BaseModel.Listener() { // from class: com.urbanairship.android.layout.view.LabelView.2
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                LabelView.this.setVisibility(visible ? 0 : 8);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object, java.lang.String] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [T, android.graphics.drawable.Drawable] */
            /* JADX WARN: Type inference failed for: r2v6 */
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void onStateUpdated(@NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                ?? ResolveText = resolveText(state);
                if (!Intrinsics.areEqual((Object) ResolveText, objectRef.element)) {
                    LayoutUtils.applyLabelModel(LabelView.this, model, ResolveText);
                    objectRef.element = ResolveText;
                }
                LabelInfo.ViewOverrides viewOverrides = model.getViewInfo().getViewOverrides();
                ?? drawable = 0;
                LabelInfo.IconStart iconStart = (LabelInfo.IconStart) state.resolveOptional(viewOverrides != null ? viewOverrides.getIconStart() : null, model.getViewInfo().getIconStart());
                if (iconStart instanceof LabelInfo.IconStart.Floating) {
                    drawable = ((LabelInfo.IconStart.Floating) iconStart).getIcon().getDrawable(context, LabelView.this.isEnabled(), ViewExtensionsKt.isLayoutRtl(LabelView.this) ? HorizontalPosition.END : HorizontalPosition.START);
                }
                if (drawable == 0 && objectRef2.element != 0) {
                    LayoutUtils.applyLabelModel(LabelView.this, model, ResolveText);
                }
                objectRef2.element = drawable;
                if (drawable != 0) {
                    Context context2 = context;
                    LabelModel labelModel = model;
                    LabelView labelView = LabelView.this;
                    int iSpToPx = (int) ResourceUtils.spToPx(context2, labelModel.getViewInfo().getTextAppearance().getFontSize());
                    drawable.setBounds(0, 0, (iconStart != null ? (int) ResourceUtils.spToPx(context2, iconStart.getSpace()) : 0) + iSpToPx, iSpToPx);
                    Image.CenteredImageSpan centeredImageSpan = new Image.CenteredImageSpan(drawable);
                    if (ViewExtensionsKt.isLayoutRtl(labelView)) {
                        SpannableString spannableString = new SpannableString(((String) ResolveText) + ' ');
                        spannableString.setSpan(centeredImageSpan, spannableString.length() - 1, spannableString.length(), 33);
                        labelView.setText(spannableString);
                        return;
                    }
                    SpannableString spannableString2 = new SpannableString(' ' + ((String) ResolveText));
                    spannableString2.setSpan(centeredImageSpan, 0, 1, 33);
                    labelView.setText(spannableString2);
                }
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                LabelView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(LabelView.this, old, background);
            }

            private final String resolveText(ThomasState state) {
                LabelInfo.ViewOverrides viewOverrides = model.getViewInfo().getViewOverrides();
                String str = (String) state.resolveOptional(viewOverrides != null ? viewOverrides.getRef() : null, model.getViewInfo().getRef());
                LabelInfo.ViewOverrides viewOverrides2 = model.getViewInfo().getViewOverrides();
                Object objResolveRequired = state.resolveRequired(viewOverrides2 != null ? viewOverrides2.getText() : null, model.getViewInfo().getText());
                Intrinsics.checkNotNullExpressionValue(objResolveRequired, "resolveRequired(...)");
                String str2 = (String) objResolveRequired;
                if (str == null) {
                    return str2;
                }
                String strNamedStringResource = UAStringUtil.namedStringResource(LabelView.this.getContext(), str, str2);
                Intrinsics.checkNotNull(strNamedStringResource);
                return strNamedStringResource;
            }
        });
    }
}
