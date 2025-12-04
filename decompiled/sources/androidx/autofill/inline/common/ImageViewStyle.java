package androidx.autofill.inline.common;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.common.ViewStyle;
import androidx.core.util.Preconditions;

@RequiresApi(api = 30)
/* loaded from: classes.dex */
public final class ImageViewStyle extends ViewStyle {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ImageViewStyle(@NonNull Bundle bundle) {
        super(bundle);
    }

    @Override // androidx.autofill.inline.common.ViewStyle, androidx.autofill.inline.common.BundledStyle
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected String getStyleKey() {
        return "image_view_style";
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void applyStyleOnImageViewIfValid(@NonNull ImageView imageView) {
        String string;
        ColorStateList colorStateList;
        if (isValid()) {
            super.applyStyleOnViewIfValid(imageView);
            if (this.mBundle.containsKey("image_max_width")) {
                imageView.setMaxWidth(this.mBundle.getInt("image_max_width"));
                imageView.setAdjustViewBounds(true);
            }
            if (this.mBundle.containsKey("image_max_height")) {
                imageView.setMaxHeight(this.mBundle.getInt("image_max_height"));
                imageView.setAdjustViewBounds(true);
            }
            if (this.mBundle.containsKey("image_tint_list") && (colorStateList = (ColorStateList) this.mBundle.getParcelable("image_tint_list")) != null) {
                imageView.setImageTintList(colorStateList);
            }
            if (!this.mBundle.containsKey("image_scale_type") || (string = this.mBundle.getString("image_scale_type")) == null) {
                return;
            }
            try {
                imageView.setScaleType(ImageView.ScaleType.valueOf(string));
            } catch (IllegalArgumentException unused) {
                Log.w("ImageViewStyle", "Cannot recognize the scale type: " + string);
            }
        }
    }

    public static final class Builder extends ViewStyle.BaseBuilder<ImageViewStyle, Builder> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.autofill.inline.common.ViewStyle.BaseBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super("image_view_style");
        }

        @NonNull
        public Builder setScaleType(@NonNull ImageView.ScaleType scaleType) {
            Preconditions.checkNotNull(scaleType, "scaleType should not be null");
            this.mBundle.putString("image_scale_type", scaleType.name());
            return this;
        }

        @NonNull
        public Builder setMaxWidth(int i) {
            this.mBundle.putInt("image_max_width", i);
            return this;
        }

        @NonNull
        public Builder setMaxHeight(int i) {
            this.mBundle.putInt("image_max_height", i);
            return this;
        }

        @NonNull
        public Builder setTintList(@NonNull ColorStateList colorStateList) {
            Preconditions.checkNotNull(colorStateList, "imageTintList should not be null");
            this.mBundle.putParcelable("image_tint_list", colorStateList);
            return this;
        }

        @Override // androidx.autofill.inline.common.BundledStyle.Builder
        @NonNull
        public ImageViewStyle build() {
            return new ImageViewStyle(this.mBundle);
        }
    }
}
