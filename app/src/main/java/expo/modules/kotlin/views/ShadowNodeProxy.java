package expo.modules.kotlin.views;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.StateWrapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m1836d2 = {"Lexpo/modules/kotlin/views/ShadowNodeProxy;", "", "expoView", "Lexpo/modules/kotlin/views/ExpoView;", "<init>", "(Lexpo/modules/kotlin/views/ExpoView;)V", "getExpoView", "()Lexpo/modules/kotlin/views/ExpoView;", "setViewSize", "", "width", "", "height", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ShadowNodeProxy {
    private final ExpoView expoView;

    public ShadowNodeProxy(@NotNull ExpoView expoView) {
        Intrinsics.checkNotNullParameter(expoView, "expoView");
        this.expoView = expoView;
    }

    @NotNull
    public final ExpoView getExpoView() {
        return this.expoView;
    }

    public final void setViewSize(double width, double height) {
        StateWrapper stateWrapper = this.expoView.getStateWrapper();
        if (stateWrapper != null) {
            WritableNativeMap writableNativeMapMakeNativeMap = Arguments.makeNativeMap((Map<String, Object>) MapsKt.mapOf(TuplesKt.m1842to("width", Double.valueOf(width)), TuplesKt.m1842to("height", Double.valueOf(height))));
            Intrinsics.checkNotNullExpressionValue(writableNativeMapMakeNativeMap, "makeNativeMap(...)");
            stateWrapper.updateState(writableNativeMapMakeNativeMap);
        }
    }
}
