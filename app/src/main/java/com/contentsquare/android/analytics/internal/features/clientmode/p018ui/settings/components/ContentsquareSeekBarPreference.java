package com.contentsquare.android.analytics.internal.features.clientmode.p018ui.settings.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.contentsquare.android.C2362R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m1836d2 = {"Lcom/contentsquare/android/analytics/internal/features/clientmode/ui/settings/components/ContentsquareSeekBarPreference;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSeekBarChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "value", "getCurrentValue", "()I", "setCurrentValue", "(I)V", "currentValue", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0})
public final class ContentsquareSeekBarPreference extends ConstraintLayout {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final TextView f1185a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SeekBar f1186b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public Function1<? super Integer, Unit> f1187c;

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.clientmode.ui.settings.components.ContentsquareSeekBarPreference$a */
    public static final class C2369a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f1188a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ ContentsquareSeekBarPreference f1189b;

        public C2369a(int i, ContentsquareSeekBarPreference contentsquareSeekBarPreference) {
            this.f1188a = i;
            this.f1189b = contentsquareSeekBarPreference;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(@Nullable SeekBar seekBar, int i, boolean z) {
            int i2 = this.f1188a;
            if (i2 > 1) {
                int i3 = (i / i2) * i2;
                if (seekBar == null) {
                    return;
                }
                seekBar.setProgress(i3);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(@Nullable SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(@Nullable SeekBar seekBar) {
            int progress = this.f1189b.f1186b.getProgress();
            Function1<? super Integer, Unit> function1 = this.f1189b.f1187c;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(progress));
            }
            this.f1189b.f1185a.setText(String.valueOf(progress));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentsquareSeekBarPreference(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int getCurrentValue() {
        return this.f1186b.getProgress();
    }

    public final void setCurrentValue(int i) {
        this.f1186b.setProgress(i);
        this.f1185a.setText(String.valueOf(i));
    }

    public final void setOnSeekBarChangeListener(@NotNull Function1<? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f1187c = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentsquareSeekBarPreference(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContentsquareSeekBarPreference(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, C2362R.layout.contentsquare_seekbar_preference, this);
        View viewFindViewById = findViewById(C2362R.id.contentsquare_preference_seekbar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.conten…quare_preference_seekbar)");
        SeekBar seekBar = (SeekBar) viewFindViewById;
        this.f1186b = seekBar;
        View viewFindViewById2 = findViewById(C2362R.id.contentsquare_preference_seekbar_current_value);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.conten…ce_seekbar_current_value)");
        this.f1185a = (TextView) viewFindViewById2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2362R.styleable.ContentsquareSeekBarPreference);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tsquareSeekBarPreference)");
        seekBar.setOnSeekBarChangeListener(new C2369a(typedArrayObtainStyledAttributes.getInteger(C2362R.styleable.ContentsquareSeekBarPreference_contentsquare_rounding_range, 0), this));
        try {
            ((TextView) findViewById(C2362R.id.contentsquare_preference_title)).setText(typedArrayObtainStyledAttributes.getString(C2362R.styleable.ContentsquareSeekBarPreference_contentsquare_title));
            ((TextView) findViewById(C2362R.id.contentsquare_preference_summary)).setText(typedArrayObtainStyledAttributes.getString(C2362R.styleable.ContentsquareSeekBarPreference_contentsquare_summary));
            seekBar.setMax(typedArrayObtainStyledAttributes.getInteger(C2362R.styleable.ContentsquareSeekBarPreference_contentsquare_max_value, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ ContentsquareSeekBarPreference(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
