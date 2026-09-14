package expo.modules.kotlin.views;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.UiThread;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.StateWrapper;
import expo.modules.kotlin.AppContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, m1836d2 = {"Lexpo/modules/kotlin/views/ExpoView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "getStateWrapper", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "shadowNodeProxy", "Lexpo/modules/kotlin/views/ShadowNodeProxy;", "getShadowNodeProxy", "()Lexpo/modules/kotlin/views/ShadowNodeProxy;", "shouldUseAndroidLayout", "", "getShouldUseAndroidLayout", "()Z", "measureAndLayout", "", "requestLayout", "clipToPaddingBox", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public abstract class ExpoView extends LinearLayout {

    @NotNull
    private final AppContext appContext;

    @NotNull
    private final ShadowNodeProxy shadowNodeProxy;
    private final boolean shouldUseAndroidLayout;

    @Nullable
    private StateWrapper stateWrapper;

    @NotNull
    public final AppContext getAppContext() {
        return this.appContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoView(@NotNull Context context, @NotNull AppContext appContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
        this.shadowNodeProxy = new ShadowNodeProxy(this);
    }

    @Nullable
    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper(@Nullable StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    @NotNull
    public final ShadowNodeProxy getShadowNodeProxy() {
        return this.shadowNodeProxy;
    }

    public boolean getShouldUseAndroidLayout() {
        return this.shouldUseAndroidLayout;
    }

    @UiThread
    public final void measureAndLayout() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (getShouldUseAndroidLayout()) {
            post(new Runnable() { // from class: expo.modules.kotlin.views.ExpoView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.measureAndLayout();
                }
            });
        }
    }

    public void clipToPaddingBox(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getClipToPadding()) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        clipToPaddingBox(canvas);
        super.dispatchDraw(canvas);
    }
}
