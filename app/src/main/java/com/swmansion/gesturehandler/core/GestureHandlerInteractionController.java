package com.swmansion.gesturehandler.core;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\n"}, m1836d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;", "", "shouldWaitForHandlerFailure", "", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "otherHandler", "shouldRequireHandlerToWaitForFailure", "shouldRecognizeSimultaneously", "shouldHandlerBeCancelledBy", "react-native-gesture-handler_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface GestureHandlerInteractionController {
    boolean shouldHandlerBeCancelledBy(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler);

    boolean shouldRecognizeSimultaneously(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler);

    boolean shouldRequireHandlerToWaitForFailure(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler);

    boolean shouldWaitForHandlerFailure(@NotNull GestureHandler handler, @NotNull GestureHandler otherHandler);
}
