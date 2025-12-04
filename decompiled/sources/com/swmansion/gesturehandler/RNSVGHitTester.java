package com.swmansion.gesturehandler;

import android.view.View;
import android.view.ViewParent;
import com.horcrux.svg.SvgView;
import com.horcrux.svg.VirtualView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/swmansion/gesturehandler/RNSVGHitTester;", "", "<init>", "()V", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RNSVGHitTester {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0001J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/swmansion/gesturehandler/RNSVGHitTester$Companion;", "", "<init>", "()V", "getRootSvgView", "Lcom/horcrux/svg/SvgView;", "view", "Landroid/view/View;", "isSvgElement", "", "hitTest", "posX", "", "posY", "react-native-gesture-handler_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

        /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean hitTest(@org.jetbrains.annotations.NotNull android.view.View r10, float r11, float r12) {
            /*
                r9 = this;
                java.lang.String r0 = "view"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                com.horcrux.svg.SvgView r9 = r9.getRootSvgView(r10)
                r0 = 0
                int[] r1 = new int[]{r0, r0}
                int[] r2 = new int[]{r0, r0}
                r10.getLocationOnScreen(r1)
                r9.getLocationOnScreen(r2)
                r3 = r1[r0]
                float r3 = (float) r3
                float r3 = r3 + r11
                r4 = r2[r0]
                float r4 = (float) r4
                float r3 = r3 - r4
                r4 = 1
                r1 = r1[r4]
                float r1 = (float) r1
                float r1 = r1 + r12
                r2 = r2[r4]
                float r2 = (float) r2
                float r1 = r1 - r2
                int r9 = r9.reactTagForTouch(r3, r1)
                int r1 = r10.getId()
                if (r1 != r9) goto L35
                r1 = r4
                goto L36
            L35:
                r1 = r0
            L36:
                int r2 = r10.getWidth()
                double r2 = (double) r2
                double r5 = (double) r11
                r7 = 0
                int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r11 > 0) goto L56
                int r11 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                if (r11 > 0) goto L56
                int r11 = r10.getHeight()
                double r2 = (double) r11
                double r11 = (double) r12
                int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r5 > 0) goto L56
                int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r11 > 0) goto L56
                r11 = r4
                goto L57
            L56:
                r11 = r0
            L57:
                boolean r12 = r10 instanceof com.horcrux.svg.SvgView
                if (r12 == 0) goto L7a
                android.view.ViewGroup r10 = (android.view.ViewGroup) r10
                kotlin.sequences.Sequence r10 = androidx.core.view.ViewGroupKt.getChildren(r10)
                com.swmansion.gesturehandler.RNSVGHitTester$Companion$$ExternalSyntheticLambda0 r12 = new com.swmansion.gesturehandler.RNSVGHitTester$Companion$$ExternalSyntheticLambda0
                r12.<init>()
                kotlin.sequences.Sequence r10 = kotlin.sequences.SequencesKt.map(r10, r12)
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
                boolean r9 = kotlin.sequences.SequencesKt.contains(r10, r9)
                if (r1 != 0) goto L76
                if (r9 == 0) goto L79
            L76:
                if (r11 == 0) goto L79
                r0 = r4
            L79:
                return r0
            L7a:
                if (r1 == 0) goto L7f
                if (r11 == 0) goto L7f
                r0 = r4
            L7f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.RNSVGHitTester.Companion.hitTest(android.view.View, float, float):boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int hitTest$lambda$0(View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getId();
        }
    }
}
