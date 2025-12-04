package androidx.autofill.inline.common;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.common.BundledStyle;
import androidx.core.util.Preconditions;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;

@RequiresApi(api = 30)
/* loaded from: classes.dex */
public class ViewStyle extends BundledStyle {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ViewStyle(@NonNull Bundle bundle) {
        super(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void applyStyleOnViewIfValid(@NonNull View view) {
        int[] intArray;
        int[] intArray2;
        Icon icon;
        Drawable drawableLoadDrawable;
        if (isValid()) {
            if (this.mBundle.containsKey(AppStateModule.APP_STATE_BACKGROUND) && (icon = (Icon) this.mBundle.getParcelable(AppStateModule.APP_STATE_BACKGROUND)) != null && (drawableLoadDrawable = icon.loadDrawable(view.getContext())) != null) {
                view.setBackground(drawableLoadDrawable);
            }
            if (this.mBundle.containsKey("background_color")) {
                view.setBackgroundColor(this.mBundle.getInt("background_color"));
            }
            if (this.mBundle.containsKey(ViewProps.PADDING) && (intArray2 = this.mBundle.getIntArray(ViewProps.PADDING)) != null && intArray2.length == 4) {
                if (view.getLayoutDirection() == 0) {
                    view.setPadding(intArray2[0], intArray2[1], intArray2[2], intArray2[3]);
                } else {
                    view.setPadding(intArray2[2], intArray2[1], intArray2[0], intArray2[3]);
                }
            }
            if (this.mBundle.containsKey("layout_margin") && (intArray = this.mBundle.getIntArray("layout_margin")) != null && intArray.length == 4) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
                } else if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (view.getLayoutDirection() == 0) {
                    marginLayoutParams.setMargins(intArray[0], intArray[1], intArray[2], intArray[3]);
                } else {
                    marginLayoutParams.setMargins(intArray[2], intArray[1], intArray[0], intArray[3]);
                }
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // androidx.autofill.inline.common.BundledStyle
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    protected String getStyleKey() {
        return "view_style";
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class BaseBuilder<T extends ViewStyle, B extends BaseBuilder<T, B>> extends BundledStyle.Builder<T> {
        @NonNull
        protected abstract B getThis();

        protected BaseBuilder(@NonNull String str) {
            super(str);
        }

        @NonNull
        public B setBackground(@NonNull Icon icon) {
            Preconditions.checkNotNull(icon, "background icon should not be null");
            this.mBundle.putParcelable(AppStateModule.APP_STATE_BACKGROUND, icon);
            return (B) getThis();
        }

        @NonNull
        public B setBackgroundColor(@ColorInt int i) {
            this.mBundle.putInt("background_color", i);
            return (B) getThis();
        }

        @NonNull
        public B setPadding(int i, int i2, int i3, int i4) {
            this.mBundle.putIntArray(ViewProps.PADDING, new int[]{i, i2, i3, i4});
            return (B) getThis();
        }

        @NonNull
        public B setLayoutMargin(int i, int i2, int i3, int i4) {
            this.mBundle.putIntArray("layout_margin", new int[]{i, i2, i3, i4});
            return (B) getThis();
        }
    }

    public static final class Builder extends BaseBuilder<ViewStyle, Builder> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.autofill.inline.common.ViewStyle.BaseBuilder
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super("view_style");
        }

        @Override // androidx.autofill.inline.common.BundledStyle.Builder
        @NonNull
        public ViewStyle build() {
            return new ViewStyle(this.mBundle);
        }
    }
}
