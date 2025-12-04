package com.urbanairship.preferencecenter.ui;

import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.preferencecenter.R;
import com.urbanairship.preferencecenter.ui.item.PrefCenterItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/CommonViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "Lcom/urbanairship/preferencecenter/ui/PrefCenterViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "descriptionView", "Landroid/widget/TextView;", "getDescriptionView", "()Landroid/widget/TextView;", "titleView", "getTitleView", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class CommonViewHolder<T extends PrefCenterItem> extends PrefCenterViewHolder<T> {
    private final TextView descriptionView;
    private final TextView titleView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.ua_pref_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.titleView = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.ua_pref_description);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.descriptionView = (TextView) viewFindViewById2;
    }

    @NotNull
    protected final TextView getTitleView() {
        return this.titleView;
    }

    @NotNull
    protected final TextView getDescriptionView() {
        return this.descriptionView;
    }
}
