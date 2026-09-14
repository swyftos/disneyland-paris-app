package com.swmansion.gesturehandler;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.camera.video.AudioStats;
import androidx.core.view.ViewGroupKt;
import com.horcrux.svg.SvgView;
import com.horcrux.svg.VirtualView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m1836d2 = {"Lcom/swmansion/gesturehandler/RNSVGHitTester;", "", "<init>", "()V", "Companion", "react-native-gesture-handler_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class RNSVGHitTester {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0001J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, m1836d2 = {"Lcom/swmansion/gesturehandler/RNSVGHitTester$Companion;", "", "<init>", "()V", "getRootSvgView", "Lcom/horcrux/svg/SvgView;", "view", "Landroid/view/View;", "isSvgElement", "", "hitTest", "posX", "", "posY", "react-native-gesture-handler_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final SvgView getRootSvgView(View view) {
            SvgView svgView;
            if (view instanceof VirtualView) {
                svgView = ((VirtualView) view).getSvgView();
                Intrinsics.checkNotNull(svgView);
            } else {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.horcrux.svg.SvgView");
                svgView = (SvgView) view;
            }
            while (true) {
                ViewParent parent = svgView.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                if (!isSvgElement(parent)) {
                    return svgView;
                }
                if (svgView.getParent() instanceof VirtualView) {
                    ViewParent parent2 = svgView.getParent();
                    Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type com.horcrux.svg.VirtualView");
                    svgView = ((VirtualView) parent2).getSvgView();
                    Intrinsics.checkNotNull(svgView);
                } else {
                    ViewParent parent3 = svgView.getParent();
                    Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type com.horcrux.svg.SvgView");
                    svgView = (SvgView) parent3;
                }
            }
        }

        public final boolean isSvgElement(@NotNull Object view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return (view instanceof VirtualView) || (view instanceof SvgView);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0056  */
        public final boolean hitTest(@NotNull View view, float posX, float posY) {
            boolean z;
            Intrinsics.checkNotNullParameter(view, "view");
            SvgView rootSvgView = getRootSvgView(view);
            int[] iArr = {0, 0};
            int[] iArr2 = {0, 0};
            view.getLocationOnScreen(iArr);
            rootSvgView.getLocationOnScreen(iArr2);
            int iReactTagForTouch = rootSvgView.reactTagForTouch((iArr[0] + posX) - iArr2[0], (iArr[1] + posY) - iArr2[1]);
            boolean z2 = view.getId() == iReactTagForTouch;
            double width = view.getWidth();
            double d = posX;
            if (AudioStats.AUDIO_AMPLITUDE_NONE > d || d > width) {
                z = false;
            } else {
                double height = view.getHeight();
                double d2 = posY;
                if (AudioStats.AUDIO_AMPLITUDE_NONE > d2 || d2 > height) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (view instanceof SvgView) {
                return (z2 || SequencesKt.contains(SequencesKt.map(ViewGroupKt.getChildren((ViewGroup) view), new Function1() { // from class: com.swmansion.gesturehandler.RNSVGHitTester$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(RNSVGHitTester.Companion.hitTest$lambda$0((View) obj));
                    }
                }), Integer.valueOf(iReactTagForTouch))) && z;
            }
            return z2 && z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int hitTest$lambda$0(View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getId();
        }
    }
}
