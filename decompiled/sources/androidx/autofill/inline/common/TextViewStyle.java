package androidx.autofill.inline.common;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.common.ViewStyle;
import androidx.core.util.Preconditions;

@RequiresApi(api = 30)
/* loaded from: classes.dex */
public final class TextViewStyle extends ViewStyle {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TextViewStyle(@NonNull Bundle bundle) {
        super(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void applyStyleOnTextViewIfValid(@NonNull TextView textView) {
        if (isValid()) {
            super.applyStyleOnViewIfValid(textView);
            if (this.mBundle.containsKey("text_color")) {
                textView.setTextColor(this.mBundle.getInt("text_color"));
            }
            if (this.mBundle.containsKey("text_size")) {
                textView.setTextSize(this.mBundle.containsKey("text_size_unit") ? this.mBundle.getInt("text_size_unit") : 2, this.mBundle.getFloat("text_size"));
            }
            if (this.mBundle.containsKey("text_font_family")) {
                String string = this.mBundle.getString("text_font_family");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                textView.setTypeface(Typeface.create(string, this.mBundle.getInt("text_font_style")));
            }
        }
    }

    @Override // androidx.autofill.inline.common.ViewStyle, androidx.autofill.inline.common.BundledStyle
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected String getStyleKey() {
        return "text_view_style";
    }

    public static final class Builder extends ViewStyle.BaseBuilder<TextViewStyle, Builder> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.autofill.inline.common.ViewStyle.BaseBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super("text_view_style");
        }

        @NonNull
        public Builder setTextSize(float f) {
            this.mBundle.putFloat("text_size", f);
            return this;
        }

        @NonNull
        public Builder setTextSize(int i, float f) {
            this.mBundle.putInt("text_size_unit", i);
            this.mBundle.putFloat("text_size", f);
            return this;
        }

        @NonNull
        public Builder setTextColor(@ColorInt int i) {
            this.mBundle.putInt("text_color", i);
            return this;
        }

        @NonNull
        public Builder setTypeface(@NonNull String str, int i) {
            Preconditions.checkNotNull(str, "fontFamily should not be null");
            this.mBundle.putString("text_font_family", str);
            this.mBundle.putInt("text_font_style", i);
            return this;
        }

        @Override // androidx.autofill.inline.common.BundledStyle.Builder
        @NonNull
        public TextViewStyle build() {
            return new TextViewStyle(this.mBundle);
        }
    }
}
