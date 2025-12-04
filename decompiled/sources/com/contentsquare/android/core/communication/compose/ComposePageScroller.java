package com.contentsquare.android.core.communication.compose;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0010\u001a\u00020\u00112\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/contentsquare/android/core/communication/compose/ComposePageScroller;", "Lcom/contentsquare/android/core/communication/compose/ComposeScroller;", "containerId", "", "getContainerId", "()Ljava/lang/String;", "initialOffset", "", "getInitialOffset", "()I", "numberOfPages", "getNumberOfPages", "scrollabeRect", "Landroid/graphics/Rect;", "getScrollabeRect", "()Landroid/graphics/Rect;", "scrollForCapture", "", "scrollListener", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ComposePageScroller extends ComposeScroller {
    @NotNull
    String getContainerId();

    int getInitialOffset();

    int getNumberOfPages();

    @NotNull
    Rect getScrollabeRect();

    @Nullable
    Object scrollForCapture(Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);
}
