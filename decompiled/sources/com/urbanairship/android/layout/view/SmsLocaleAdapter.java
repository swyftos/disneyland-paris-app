package com.urbanairship.android.layout.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.android.layout.R;
import com.urbanairship.android.layout.property.SmsLocale;
import com.urbanairship.android.layout.property.TextInputTextAppearance;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.util.StringExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\fH\u0016J$\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/layout/view/SmsLocaleAdapter;", "Landroid/widget/BaseAdapter;", "Landroid/widget/SpinnerAdapter;", "context", "Landroid/content/Context;", "locales", "", "Lcom/urbanairship/android/layout/property/SmsLocale;", "appearance", "Lcom/urbanairship/android/layout/property/TextInputTextAppearance;", "(Landroid/content/Context;Ljava/util/List;Lcom/urbanairship/android/layout/property/TextInputTextAppearance;)V", "getCount", "", "getDropDownView", "Landroid/view/View;", ViewProps.POSITION, "convertView", "parent", "Landroid/view/ViewGroup;", "getItem", "getItemId", "", "getView", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmsLocaleAdapter extends BaseAdapter implements SpinnerAdapter {
    private final TextInputTextAppearance appearance;
    private final Context context;
    private final List locales;

    public SmsLocaleAdapter(@NotNull Context context, @NotNull List<SmsLocale> locales, @Nullable TextInputTextAppearance textInputTextAppearance) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locales, "locales");
        this.context = context;
        this.locales = locales;
        this.appearance = textInputTextAppearance;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.locales.size();
    }

    @Override // android.widget.Adapter
    @NotNull
    public SmsLocale getItem(int position) {
        return (SmsLocale) this.locales.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return ((SmsLocale) this.locales.get(position)).getCountryCode().hashCode();
    }

    @Override // android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View viewInflate = View.inflate(this.context, R.layout.ua_layout_ic_dropdown, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.selected_item);
        textView.setText(StringExtensionsKt.getAirshipEmojiFlag(getItem(position).getCountryCode()));
        TextInputTextAppearance textInputTextAppearance = this.appearance;
        if (textInputTextAppearance != null) {
            LayoutUtils.applyTextAppearance(textView, textInputTextAppearance);
        }
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @NotNull
    public View getDropDownView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View viewInflate = View.inflate(this.context, R.layout.ua_layout_ic_dropdown_item, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.selected_item);
        textView.setText(SmsLocaleAdapterKt.displayValue(getItem(position)));
        TextInputTextAppearance textInputTextAppearance = this.appearance;
        if (textInputTextAppearance != null) {
            LayoutUtils.applyTextAppearance(textView, textInputTextAppearance);
        }
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }
}
