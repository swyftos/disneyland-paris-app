package androidx.test.espresso;

import android.view.View;
import android.view.WindowManager;
import androidx.test.espresso.core.internal.deps.guava.base.MoreObjects;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.espresso.util.HumanReadables;

/* loaded from: classes2.dex */
public final class Root {
    private final View decorView;
    private final EspressoOptional windowLayoutParams;

    public static class Builder {
        private View decorView;
        private WindowManager.LayoutParams windowLayoutParams;

        public Root build() {
            return new Root(this);
        }

        public Builder withDecorView(View view) {
            this.decorView = view;
            return this;
        }

        public Builder withWindowLayoutParams(WindowManager.LayoutParams layoutParams) {
            this.windowLayoutParams = layoutParams;
            return this;
        }
    }

    private Root(Builder builder) {
        this.decorView = (View) Preconditions.checkNotNull(builder.decorView);
        this.windowLayoutParams = EspressoOptional.fromNullable(builder.windowLayoutParams);
    }

    public View getDecorView() {
        return this.decorView;
    }

    public EspressoOptional<WindowManager.LayoutParams> getWindowLayoutParams() {
        return this.windowLayoutParams;
    }

    public boolean isReady() {
        if (this.decorView.isLayoutRequested()) {
            return false;
        }
        return this.decorView.hasWindowFocus() || (((WindowManager.LayoutParams) this.windowLayoutParams.get()).flags & 8) == 8;
    }

    public String toString() {
        MoreObjects.ToStringHelper toStringHelperAdd = MoreObjects.toStringHelper(this).add("application-window-token", this.decorView.getApplicationWindowToken()).add("window-token", this.decorView.getWindowToken()).add("has-window-focus", this.decorView.hasWindowFocus());
        if (this.windowLayoutParams.isPresent()) {
            toStringHelperAdd.add("layout-params-type", ((WindowManager.LayoutParams) this.windowLayoutParams.get()).type).add("layout-params-string", this.windowLayoutParams.get());
        }
        toStringHelperAdd.add("decor-view-string", HumanReadables.describe(this.decorView));
        return toStringHelperAdd.toString();
    }
}
