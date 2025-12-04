package com.urbanairship.android.layout.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import com.dlp.BluetoothManager;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.info.IconViewInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.IconModel;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/android/layout/view/IconView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/urbanairship/android/layout/view/BaseView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/IconModel;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/IconModel;)V", "updateIcon", "", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/environment/ThomasState;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IconView extends AppCompatImageView implements BaseView {
    private final IconModel model;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconView(@NotNull Context context, @NotNull IconModel model) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        StringExtensionsKt.ifNotEmpty(model.contentDescription(context), new Function1() { // from class: com.urbanairship.android.layout.view.IconView.1
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
                IconView.this.setContentDescription(it);
            }
        });
        if (Intrinsics.areEqual(model.getViewInfo().getAccessibilityHidden(), Boolean.TRUE)) {
            setImportantForAccessibility(2);
        }
        setClickable(false);
        setAdjustViewBounds(true);
        model.setListener$urbanairship_layout_release(new BaseModel.Listener() { // from class: com.urbanairship.android.layout.view.IconView.2
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(IconView.this, old, background);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                IconView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                IconView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void onStateUpdated(@NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                IconView.this.updateIcon(state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateIcon(ThomasState state) {
        Drawable drawable;
        IconViewInfo.ViewOverrides viewOverrides = this.model.getViewInfo().getViewOverrides();
        Image.Icon icon = (Image.Icon) state.resolveOptional(viewOverrides != null ? viewOverrides.getIcon() : null, this.model.getViewInfo().getImage());
        if (icon == null || (drawable = icon.getDrawable(getContext(), isEnabled())) == null) {
            return;
        }
        setImageDrawable(drawable);
    }
}
