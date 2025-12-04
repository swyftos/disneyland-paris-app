package com.contentsquare.android.core.communication.compose;

import android.graphics.Rect;
import android.view.View;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0016J0\u0010\f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0016¨\u0006\u0017"}, d2 = {"Lcom/contentsquare/android/core/communication/compose/ComposeInterface;", "", "getComposeScroller", "Lcom/contentsquare/android/core/communication/compose/ComposeScroller;", "view", "Landroid/view/View;", "targetCoordinates", "Lkotlin/Pair;", "", "isAndroidViewsHandler", "", "isComposeRootView", "processComposeTree", "", "nativeViewLight", "Lcom/contentsquare/android/core/communication/sessionreplay/ViewLight;", "isSnapshotFromSrEnabled", "Lcom/contentsquare/android/core/communication/compose/ViewNode;", "clipToParent", "bitmapProvider", "Lkotlin/Function1;", "Landroid/graphics/Rect;", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ComposeInterface {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        public static ComposeScroller getComposeScroller(ComposeInterface composeInterface, View view, Pair<Integer, Integer> pair) {
            Intrinsics.checkNotNullParameter(view, "view");
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ComposeScroller getComposeScroller$default(ComposeInterface composeInterface, View view, Pair pair, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getComposeScroller");
            }
            if ((i & 2) != 0) {
                pair = null;
            }
            return composeInterface.getComposeScroller(view, pair);
        }

        public static boolean isAndroidViewsHandler(ComposeInterface composeInterface, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return false;
        }

        public static boolean isComposeRootView(ComposeInterface composeInterface, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return false;
        }

        @Nullable
        public static ViewNode processComposeTree(ComposeInterface composeInterface, View view, boolean z, Function1<? super Rect, String> bitmapProvider) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(bitmapProvider, "bitmapProvider");
            return null;
        }

        public static /* synthetic */ ViewNode processComposeTree$default(ComposeInterface composeInterface, View view, boolean z, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processComposeTree");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return composeInterface.processComposeTree(view, z, (Function1<? super Rect, String>) function1);
        }

        public static void processComposeTree(ComposeInterface composeInterface, View view, ViewLight nativeViewLight, boolean z) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(nativeViewLight, "nativeViewLight");
        }
    }

    @Nullable
    ComposeScroller getComposeScroller(View view, Pair<Integer, Integer> targetCoordinates);

    boolean isAndroidViewsHandler(View view);

    boolean isComposeRootView(View view);

    @Nullable
    ViewNode processComposeTree(View view, boolean clipToParent, Function1<? super Rect, String> bitmapProvider);

    void processComposeTree(View view, ViewLight nativeViewLight, boolean isSnapshotFromSrEnabled);
}
