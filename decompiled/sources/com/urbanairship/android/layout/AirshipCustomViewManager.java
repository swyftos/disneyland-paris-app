package com.urbanairship.android.layout;

import android.content.Context;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\fJ\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005J\r\u0010\u0015\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\u0016R(\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/layout/AirshipCustomViewManager;", "", "()V", "handlers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/urbanairship/android/layout/AirshipCustomViewHandler;", "getHandlers$urbanairship_layout_release$annotations", "getHandlers$urbanairship_layout_release", "()Ljava/util/concurrent/ConcurrentHashMap;", "get", "name", "get$urbanairship_layout_release", "register", "", "factory", "Lkotlin/Function1;", "Lcom/urbanairship/android/layout/AirshipCustomViewArguments;", "Landroid/view/View;", "handler", "unregister", "unregisterAll", "unregisterAll$urbanairship_layout_release", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipCustomViewManager {

    @NotNull
    public static final AirshipCustomViewManager INSTANCE = new AirshipCustomViewManager();
    private static final ConcurrentHashMap handlers = new ConcurrentHashMap();

    @VisibleForTesting
    public static /* synthetic */ void getHandlers$urbanairship_layout_release$annotations() {
    }

    private AirshipCustomViewManager() {
    }

    @NotNull
    public final ConcurrentHashMap<String, AirshipCustomViewHandler> getHandlers$urbanairship_layout_release() {
        return handlers;
    }

    public final void register(@NotNull String name, @NotNull AirshipCustomViewHandler handler) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(handler, "handler");
        handlers.put(name, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View register$lambda$0(Function1 factory, Context context, AirshipCustomViewArguments args) {
        Intrinsics.checkNotNullParameter(factory, "$factory");
        Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(args, "args");
        return (View) factory.invoke(args);
    }

    public final void register(@NotNull String name, @NotNull final Function1<? super AirshipCustomViewArguments, ? extends View> factory) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(factory, "factory");
        handlers.put(name, new AirshipCustomViewHandler() { // from class: com.urbanairship.android.layout.AirshipCustomViewManager$$ExternalSyntheticLambda0
            @Override // com.urbanairship.android.layout.AirshipCustomViewHandler
            public final View onCreateView(Context context, AirshipCustomViewArguments airshipCustomViewArguments) {
                return AirshipCustomViewManager.register$lambda$0(factory, context, airshipCustomViewArguments);
            }
        });
    }

    public final void unregister(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        handlers.remove(name);
    }

    @VisibleForTesting
    public final void unregisterAll$urbanairship_layout_release() {
        handlers.clear();
    }

    @Nullable
    public final AirshipCustomViewHandler get$urbanairship_layout_release(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (AirshipCustomViewHandler) handlers.get(name);
    }
}
