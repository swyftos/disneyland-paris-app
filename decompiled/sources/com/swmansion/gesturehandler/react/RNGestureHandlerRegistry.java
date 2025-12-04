package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerRegistry;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\bJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\fJ\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\bJ\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerRegistry;", "Lcom/swmansion/gesturehandler/core/GestureHandlerRegistry;", "<init>", "()V", "handlers", "Landroid/util/SparseArray;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "attachedTo", "", "handlersForView", "Ljava/util/ArrayList;", "registerHandler", "", "handler", "getHandler", "handlerTag", "attachHandlerToView", "", "viewTag", "actionType", "registerHandlerForViewWithTag", "detachHandler", "dropHandler", "dropAllHandlers", "getHandlersForViewWithTag", "getHandlersForView", "view", "Landroid/view/View;", "react-native-gesture-handler_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRNGestureHandlerRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RNGestureHandlerRegistry.kt\ncom/swmansion/gesturehandler/react/RNGestureHandlerRegistry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1#2:96\n*E\n"})
/* loaded from: classes4.dex */
public final class RNGestureHandlerRegistry implements GestureHandlerRegistry {

    @NotNull
    private final SparseArray<GestureHandler> handlers = new SparseArray<>();

    @NotNull
    private final SparseArray<Integer> attachedTo = new SparseArray<>();

    @NotNull
    private final SparseArray<ArrayList<GestureHandler>> handlersForView = new SparseArray<>();

    public final synchronized void registerHandler(@NotNull GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlers.put(handler.getTag(), handler);
    }

    @Nullable
    public final synchronized GestureHandler getHandler(int handlerTag) {
        return this.handlers.get(handlerTag);
    }

    public final synchronized boolean attachHandlerToView(int handlerTag, int viewTag, int actionType) {
        boolean z;
        GestureHandler gestureHandler = this.handlers.get(handlerTag);
        if (gestureHandler != null) {
            detachHandler(gestureHandler);
            gestureHandler.setActionType(actionType);
            registerHandlerForViewWithTag(viewTag, gestureHandler);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private final synchronized void registerHandlerForViewWithTag(int viewTag, GestureHandler handler) {
        try {
            if (this.attachedTo.get(handler.getTag()) != null) {
                throw new IllegalStateException(("Handler " + handler + " already attached").toString());
            }
            this.attachedTo.put(handler.getTag(), Integer.valueOf(viewTag));
            ArrayList<GestureHandler> arrayList = this.handlersForView.get(viewTag);
            if (arrayList == null) {
                ArrayList<GestureHandler> arrayList2 = new ArrayList<>(1);
                arrayList2.add(handler);
                this.handlersForView.put(viewTag, arrayList2);
            } else {
                synchronized (arrayList) {
                    arrayList.add(handler);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void detachHandler(final GestureHandler handler) {
        try {
            Integer num = this.attachedTo.get(handler.getTag());
            if (num != null) {
                this.attachedTo.remove(handler.getTag());
                ArrayList<GestureHandler> arrayList = this.handlersForView.get(num.intValue());
                if (arrayList != null) {
                    synchronized (arrayList) {
                        arrayList.remove(handler);
                    }
                    if (arrayList.size() == 0) {
                        this.handlersForView.remove(num.intValue());
                    }
                }
            }
            if (handler.getView() != null) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerRegistry$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        handler.cancel();
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void dropHandler(int handlerTag) {
        GestureHandler gestureHandler = this.handlers.get(handlerTag);
        if (gestureHandler != null) {
            detachHandler(gestureHandler);
            this.handlers.remove(handlerTag);
        }
    }

    public final synchronized void dropAllHandlers() {
        this.handlers.clear();
        this.attachedTo.clear();
        this.handlersForView.clear();
    }

    @Nullable
    public final synchronized ArrayList<GestureHandler> getHandlersForViewWithTag(int viewTag) {
        return this.handlersForView.get(viewTag);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandlerRegistry
    @Nullable
    public synchronized ArrayList<GestureHandler> getHandlersForView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return getHandlersForViewWithTag(view.getId());
    }
}
