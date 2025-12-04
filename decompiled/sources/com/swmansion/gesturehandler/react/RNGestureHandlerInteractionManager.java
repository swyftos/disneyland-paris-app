package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerInteractionController;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u0006\u0010\u001b\u001a\u00020\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager;", "Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;", "<init>", "()V", "waitForRelations", "Landroid/util/SparseArray;", "", "simultaneousRelations", "blockingRelations", "dropRelationsForHandlerWithTag", "", "handlerTag", "", "convertHandlerTagsArray", "config", "Lcom/facebook/react/bridge/ReadableMap;", "key", "", "configureInteractions", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "shouldWaitForHandlerFailure", "", "otherHandler", "shouldRequireHandlerToWaitForFailure", "shouldHandlerBeCancelledBy", "shouldRecognizeSimultaneously", "reset", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRNGestureHandlerInteractionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RNGestureHandlerInteractionManager.kt\ncom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,75:1\n12604#2,2:76\n12604#2,2:78\n12604#2,2:80\n*S KotlinDebug\n*F\n+ 1 RNGestureHandlerInteractionManager.kt\ncom/swmansion/gesturehandler/react/RNGestureHandlerInteractionManager\n*L\n45#1:76,2\n48#1:78,2\n62#1:80,2\n*E\n"})
/* loaded from: classes4.dex */
public final class RNGestureHandlerInteractionManager implements GestureHandlerInteractionController {

    @NotNull
    private static final String KEY_BLOCKS_HANDLERS = "blocksHandlers";

    @NotNull
    private static final String KEY_SIMULTANEOUS_HANDLERS = "simultaneousHandlers";

    @NotNull
    private static final String KEY_WAIT_FOR = "waitFor";

    @NotNull
    private final SparseArray<int[]> waitForRelations = new SparseArray<>();

    @NotNull
    private final SparseArray<int[]> simultaneousRelations = new SparseArray<>();

    @NotNull
    private final SparseArray<int[]> blockingRelations = new SparseArray<>();

    public final void dropRelationsForHandlerWithTag(int handlerTag) {
        this.waitForRelations.remove(handlerTag);
        this.simultaneousRelations.remove(handlerTag);
    }

    private final int[] convertHandlerTagsArray(ReadableMap config, String key) {
        ReadableArray array = config.getArray(key);
        Intrinsics.checkNotNull(array);
        int size = array.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = array.getInt(i);
        }
        return iArr;
    }

    public final void configureInteractions(@NotNull GestureHandler handler, @NotNull ReadableMap config) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(config, "config");
        handler.setInteractionController(this);
        if (config.hasKey(KEY_WAIT_FOR)) {
            this.waitForRelations.put(handler.getTag(), convertHandlerTagsArray(config, KEY_WAIT_FOR));
        }
        if (config.hasKey(KEY_SIMULTANEOUS_HANDLERS)) {
            this.simultaneousRelations.put(handler.getTag(), convertHandlerTagsArray(config, KEY_SIMULTANEOUS_HANDLERS));
        }
        if (config.hasKey(KEY_BLOCKS_HANDLERS)) {
            this.blockingRelations.put(handler.getTag(), convertHandlerTagsArray(config, KEY_BLOCKS_HANDLERS));
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldWaitForHandlerFailure(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        int[] iArr = this.waitForRelations.get(handler.getTag());
        if (iArr == null) {
            return false;
        }
        for (int i : iArr) {
            if (i == otherHandler.getTag()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldRequireHandlerToWaitForFailure(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        int[] iArr = this.blockingRelations.get(handler.getTag());
        if (iArr == null) {
            return false;
        }
        for (int i : iArr) {
            if (i == otherHandler.getTag()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldHandlerBeCancelledBy(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        if (otherHandler instanceof NativeViewGestureHandler) {
            return ((NativeViewGestureHandler) otherHandler).getDisallowInterruption();
        }
        return otherHandler instanceof RNGestureHandlerRootHelper.RootViewGestureHandler;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerInteractionController
    public boolean shouldRecognizeSimultaneously(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(otherHandler, "otherHandler");
        int[] iArr = this.simultaneousRelations.get(handler.getTag());
        if (iArr == null) {
            return false;
        }
        for (int i : iArr) {
            if (i == otherHandler.getTag()) {
                return true;
            }
        }
        return false;
    }

    public final void reset() {
        this.waitForRelations.clear();
        this.simultaneousRelations.clear();
    }
}
