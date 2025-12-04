package com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.contentsquare.android.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.bouncycastle.i18n.ErrorBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR&\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u0012\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/components/ContentsquareTextPreference;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "getTitle", "()I", "setTitle", "(I)V", "title", "getSummary", "setSummary", ErrorBundle.SUMMARY_ENTRY, "", "getSummaryText", "()Ljava/lang/CharSequence;", "setSummaryText", "(Ljava/lang/CharSequence;)V", "summaryText", "", "isSummaryVisible", "()Z", "setSummaryVisible", "(Z)V", "library_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nContentsquareTextPreference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentsquareTextPreference.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/components/ContentsquareTextPreference\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,57:1\n260#2:58\n262#2,2:59\n*S KotlinDebug\n*F\n+ 1 ContentsquareTextPreference.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/components/ContentsquareTextPreference\n*L\n40#1:58\n42#1:59,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ContentsquareTextPreference extends ConstraintLayout {

    @NotNull
    public final TextView a;

    @NotNull
    public final TextView b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentsquareTextPreference(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int getSummary() {
        return 0;
    }

    @NotNull
    public final CharSequence getSummaryText() {
        CharSequence text = this.b.getText();
        Intrinsics.checkNotNullExpressionValue(text, "summaryTextView.text");
        return text;
    }

    public final int getTitle() {
        return 0;
    }

    public final void setSummary(@StringRes int i) {
        this.b.setText(i);
    }

    public final void setSummaryText(@NotNull CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.b.setText(value);
    }

    public final void setSummaryVisible(boolean z) {
        this.b.setVisibility(z ? 0 : 8);
    }

    public final void setTitle(@StringRes int i) {
        this.a.setText(i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentsquareTextPreference(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentsquareTextPreference(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.contentsquare_text_preference, this);
        View viewFindViewById = findViewById(R.id.contentsquare_preference_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.contentsquare_preference_title)");
        TextView textView = (TextView) viewFindViewById;
        this.a = textView;
        View viewFindViewById2 = findViewById(R.id.contentsquare_preference_summary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.conten…quare_preference_summary)");
        TextView textView2 = (TextView) viewFindViewById2;
        this.b = textView2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ContentsquareTextPreference);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tentsquareTextPreference)");
        try {
            textView.setText(typedArrayObtainStyledAttributes.getString(R.styleable.ContentsquareTextPreference_contentsquare_title));
            textView2.setText(typedArrayObtainStyledAttributes.getString(R.styleable.ContentsquareTextPreference_contentsquare_summary));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ ContentsquareTextPreference(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
