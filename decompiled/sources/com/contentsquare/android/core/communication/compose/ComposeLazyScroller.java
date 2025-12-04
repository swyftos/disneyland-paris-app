package com.contentsquare.android.core.communication.compose;

import android.graphics.Rect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function6;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0001\u0010\u0006\u001a\u00020\u00072\u008c\u0001\u0010\b\u001a\u0087\u0001\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/contentsquare/android/core/communication/compose/ComposeLazyScroller;", "Lcom/contentsquare/android/core/communication/compose/ComposeScroller;", "scrollableRect", "Landroid/graphics/Rect;", "getScrollableRect", "()Landroid/graphics/Rect;", "scrollForCapture", "", "scrollerCallback", "Lkotlin/Function6;", "", "Lkotlin/ParameterName;", "name", "itemCount", "processedItemCount", "", "Lcom/contentsquare/android/core/communication/compose/ViewNode;", "itemsToProcess", "pageRect", "", "isLastPage", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function6;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ComposeLazyScroller extends ComposeScroller {
    @NotNull
    Rect getScrollableRect();

    @Nullable
    Object scrollForCapture(Function6<? super Integer, ? super Integer, ? super List<ViewNode>, ? super Rect, ? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function6, Continuation<? super Unit> continuation);
}
