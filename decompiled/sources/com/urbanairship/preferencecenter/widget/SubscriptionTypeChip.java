package com.urbanairship.preferencecenter.widget;

import android.content.Context;
import android.view.View;
import com.google.android.material.chip.Chip;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.urbanairship.preferencecenter.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/widget/SubscriptionTypeChip;", "Lcom/google/android/material/chip/Chip;", "context", "Landroid/content/Context;", "defStyleAttr", "", "(Landroid/content/Context;I)V", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionTypeChip extends Chip {
    public /* synthetic */ SubscriptionTypeChip(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? R.attr.urbanAirshipPreferenceCenterSubscriptionTypeChipStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionTypeChip(@NotNull Context context, int i) {
        super(MaterialThemeOverlay.wrap(context, null, i, R.style.UrbanAirship_PreferenceCenter_Item_Widget_SubscriptionTypeChip), null, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setId(View.generateViewId());
    }
}
