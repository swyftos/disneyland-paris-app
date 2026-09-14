package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m1836d2 = {"Lcom/facebook/react/fabric/mounting/mountitems/FabricNameComponentMapping;", "", "<init>", "()V", "componentNames", "", "", "getFabricComponentName", "componentName", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class FabricNameComponentMapping {

    @NotNull
    public static final FabricNameComponentMapping INSTANCE = new FabricNameComponentMapping();

    @NotNull
    private static final Map<String, String> componentNames = MapsKt.mapOf(TuplesKt.m1842to("View", "RCTView"), TuplesKt.m1842to("Image", ReactImageManager.REACT_CLASS), TuplesKt.m1842to("ScrollView", ReactScrollViewManager.REACT_CLASS), TuplesKt.m1842to("Slider", "RCTSlider"), TuplesKt.m1842to("ModalHostView", ReactModalHostManager.REACT_CLASS), TuplesKt.m1842to("Paragraph", ReactTextViewManager.REACT_CLASS), TuplesKt.m1842to("Text", ReactTextViewManager.REACT_CLASS), TuplesKt.m1842to("RawText", ReactRawTextManager.REACT_CLASS), TuplesKt.m1842to("ActivityIndicatorView", ReactProgressBarViewManager.REACT_CLASS), TuplesKt.m1842to("ShimmeringView", "RKShimmeringView"), TuplesKt.m1842to("TemplateView", "RCTTemplateView"), TuplesKt.m1842to("AxialGradientView", "RCTAxialGradientView"), TuplesKt.m1842to("Video", "RCTVideo"), TuplesKt.m1842to("Map", "RCTMap"), TuplesKt.m1842to("WebView", "RCTWebView"), TuplesKt.m1842to("Keyframes", "RCTKeyframes"), TuplesKt.m1842to("ImpressionTrackingView", "RCTImpressionTrackingView"));

    private FabricNameComponentMapping() {
    }

    @JvmStatic
    @NotNull
    public static final String getFabricComponentName(@NotNull String componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        String str = componentNames.get(componentName);
        return str == null ? componentName : str;
    }
}
