package expo.modules.blur;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderEffectBlur;
import eightbitlab.com.blurview.RenderScriptBlur;
import expo.modules.blur.enums.BlurMethod;
import expo.modules.blur.enums.TintStyle;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.views.ExpoView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1836d2 = {"Lexpo/modules/blur/ExpoBlurView;", "Lexpo/modules/kotlin/views/ExpoView;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "blurMethod", "Lexpo/modules/blur/enums/BlurMethod;", "blurReduction", "", "blurRadius", "tint", "Lexpo/modules/blur/enums/TintStyle;", "getTint$expo_blur_release", "()Lexpo/modules/blur/enums/TintStyle;", "setTint$expo_blur_release", "(Lexpo/modules/blur/enums/TintStyle;)V", "blurView", "Leightbitlab/com/blurview/BlurView;", "setBlurRadius", "", "radius", "setBlurMethod", TCEventPropertiesNames.TCE_METHOD, "applyBlurReduction", "reductionFactor", "applyTint", "expo-blur_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SuppressLint({"ViewConstructor"})
public final class ExpoBlurView extends ExpoView {

    @NotNull
    private BlurMethod blurMethod;
    private float blurRadius;
    private float blurReduction;

    @NotNull
    private final BlurView blurView;

    @NotNull
    private TintStyle tint;

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlurMethod.values().length];
            try {
                iArr[BlurMethod.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlurMethod.DIMEZIS_BLUR_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoBlurView(@NotNull Context context, @NotNull AppContext appContext) throws Exceptions.MissingRootView {
        ViewGroup viewGroup;
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.blurMethod = BlurMethod.NONE;
        this.blurReduction = 4.0f;
        this.blurRadius = 50.0f;
        this.tint = TintStyle.DEFAULT;
        BlurView blurView = new BlurView(context);
        blurView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        Window window = appContext.getThrowingActivity().getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView == null || (viewGroup = (ViewGroup) decorView.findViewById(android.R.id.content)) == null) {
            throw new Exceptions.MissingRootView();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            blurView.setupWith(viewGroup, new RenderEffectBlur()).setFrameClearDrawable(decorView.getBackground());
        } else {
            blurView.setupWith(viewGroup, new RenderScriptBlur(context)).setFrameClearDrawable(decorView.getBackground());
        }
        addView(blurView);
        this.blurView = blurView;
    }

    @NotNull
    /* JADX INFO: renamed from: getTint$expo_blur_release, reason: from getter */
    public final TintStyle getTint() {
        return this.tint;
    }

    public final void setTint$expo_blur_release(@NotNull TintStyle tintStyle) {
        Intrinsics.checkNotNullParameter(tintStyle, "<set-?>");
        this.tint = tintStyle;
    }

    public final void setBlurRadius(float radius) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.blurMethod.ordinal()];
        if (i == 1) {
            setBackgroundColor(this.tint.toBlurEffect(this.blurRadius));
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.blurView.setBlurEnabled(true ^ (radius == BitmapDescriptorFactory.HUE_RED));
            if (radius > BitmapDescriptorFactory.HUE_RED) {
                this.blurView.setBlurRadius(radius / this.blurReduction);
                this.blurView.invalidate();
            }
        }
        this.blurRadius = radius;
    }

    public final void setBlurMethod(@NotNull BlurMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        this.blurMethod = method;
        int i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
        if (i == 1) {
            this.blurView.setBlurEnabled(false);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.blurView.setBlurEnabled(true);
            setBackgroundColor(0);
        }
        setBlurRadius(this.blurRadius);
    }

    public final void applyBlurReduction(float reductionFactor) {
        this.blurReduction = reductionFactor;
        setBlurRadius(this.blurRadius);
    }

    public final void applyTint() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.blurMethod.ordinal()];
        if (i == 1) {
            setBackgroundColor(this.tint.toBlurEffect(this.blurRadius));
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.blurView.setOverlayColor(this.tint.toBlurEffect(this.blurRadius));
        }
        this.blurView.invalidate();
    }
}
