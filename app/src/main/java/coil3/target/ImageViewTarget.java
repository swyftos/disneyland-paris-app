package coil3.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1836d2 = {"Lcoil3/target/ImageViewTarget;", "Lcoil3/target/GenericViewTarget;", "Landroid/widget/ImageView;", "view", "<init>", "(Landroid/widget/ImageView;)V", "getView", "()Landroid/widget/ImageView;", "value", "Landroid/graphics/drawable/Drawable;", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public class ImageViewTarget extends GenericViewTarget<ImageView> {
    private final ImageView view;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageViewTarget) && Intrinsics.areEqual(this.view, ((ImageViewTarget) obj).view);
    }

    public int hashCode() {
        return this.view.hashCode();
    }

    @NotNull
    public String toString() {
        return "ImageViewTarget(view=" + this.view + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Override // coil3.target.ViewTarget, coil3.transition.TransitionTarget
    @NotNull
    public ImageView getView() {
        return this.view;
    }

    public ImageViewTarget(@NotNull ImageView imageView) {
        this.view = imageView;
    }

    @Override // coil3.target.GenericViewTarget, coil3.transition.TransitionTarget
    @Nullable
    public Drawable getDrawable() {
        return getView().getDrawable();
    }

    @Override // coil3.target.GenericViewTarget
    public void setDrawable(@Nullable Drawable drawable) {
        getView().setImageDrawable(drawable);
    }
}
