package com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.contentsquare.android.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rJ!\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/components/ContentsquareSwitchPreference;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "title", "", "setTitle", "(I)V", ErrorBundle.SUMMARY_ENTRY, "setSummary", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSwitchStateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "contentDescription", "setSwitchContentDescription", "(Ljava/lang/String;)V", "value", "isChecked", "()Z", "setChecked", "(Z)V", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class ContentsquareSwitchPreference extends ConstraintLayout {

    @NotNull
    public final SwitchCompat a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentsquareSwitchPreference(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void a(Function1 listener, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (compoundButton.isPressed()) {
            listener.invoke(Boolean.valueOf(z));
        }
    }

    public final void setChecked(boolean z) throws Resources.NotFoundException {
        this.a.setChecked(z);
    }

    public final void setOnSwitchStateChangeListener(@NotNull final Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components.ContentsquareSwitchPreference$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ContentsquareSwitchPreference.a(listener, compoundButton, z);
            }
        });
    }

    public final void setSummary(@StringRes int summary) {
        ((TextView) findViewById(R.id.contentsquare_preference_summary)).setText(getResources().getString(summary));
    }

    public final void setSwitchContentDescription(@NotNull String contentDescription) {
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        this.a.setContentDescription(contentDescription);
    }

    public final void setTitle(@StringRes int title) {
        ((TextView) findViewById(R.id.contentsquare_preference_title)).setText(getResources().getString(title));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentsquareSwitchPreference(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentsquareSwitchPreference(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.contentsquare_switch_preference, this);
        View viewFindViewById = findViewById(R.id.contentsquare_preference_switch);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.contentsquare_preference_switch)");
        this.a = (SwitchCompat) viewFindViewById;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ContentsquareSwitchPreference);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ntsquareSwitchPreference)");
        try {
            ((TextView) findViewById(R.id.contentsquare_preference_title)).setText(typedArrayObtainStyledAttributes.getString(R.styleable.ContentsquareSwitchPreference_contentsquare_title));
            ((TextView) findViewById(R.id.contentsquare_preference_summary)).setText(typedArrayObtainStyledAttributes.getString(R.styleable.ContentsquareSwitchPreference_contentsquare_summary));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ ContentsquareSwitchPreference(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
