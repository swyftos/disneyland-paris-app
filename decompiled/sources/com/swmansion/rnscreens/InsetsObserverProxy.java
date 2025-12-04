package com.swmansion.rnscreens;

import android.util.Log;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0001J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0001J\u000e\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\u0017J\n\u0010#\u001a\u0004\u0018\u00010\nH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/swmansion/rnscreens/InsetsObserverProxy;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "<init>", "()V", "listeners", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "eventSourceView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "hasBeenRegistered", "", "isObservingContextLifetime", "shouldForwardInsetsToView", "allowRegistration", "getAllowRegistration", "()Z", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "insets", "registerWithContext", "", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "onHostResume", "onHostPause", "onHostDestroy", "addOnApplyWindowInsetsListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeOnApplyWindowInsetsListener", "registerOnView", "view", "unregister", "getObservedView", "react-native-screens_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInsetsObserverProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InsetsObserverProxy.kt\ncom/swmansion/rnscreens/InsetsObserverProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1863#2,2:106\n1#3:108\n*S KotlinDebug\n*F\n+ 1 InsetsObserverProxy.kt\ncom/swmansion/rnscreens/InsetsObserverProxy\n*L\n42#1:106,2\n*E\n"})
/* loaded from: classes4.dex */
public final class InsetsObserverProxy implements OnApplyWindowInsetsListener, LifecycleEventListener {
    private static boolean hasBeenRegistered;
    private static boolean isObservingContextLifetime;

    @NotNull
    public static final InsetsObserverProxy INSTANCE = new InsetsObserverProxy();

    @NotNull
    private static final HashSet<OnApplyWindowInsetsListener> listeners = new HashSet<>();

    @NotNull
    private static WeakReference<View> eventSourceView = new WeakReference<>(null);
    private static boolean shouldForwardInsetsToView = true;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    private InsetsObserverProxy() {
    }

    private final boolean getAllowRegistration() {
        return !hasBeenRegistered || eventSourceView.get() == null;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    @NotNull
    public WindowInsetsCompat onApplyWindowInsets(@NotNull View v, @NotNull WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = shouldForwardInsetsToView ? ViewCompat.onApplyWindowInsets(v, insets) : insets;
        Intrinsics.checkNotNull(windowInsetsCompatOnApplyWindowInsets);
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            windowInsetsCompatOnApplyWindowInsets = ((OnApplyWindowInsetsListener) it.next()).onApplyWindowInsets(v, insets);
        }
        return windowInsetsCompatOnApplyWindowInsets;
    }

    public final void registerWithContext(@NotNull ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isObservingContextLifetime) {
            Log.w("[RNScreens]", "InsetObserverProxy registers on new context while it has not been invalidated on the old one. Please report this as issue at https://github.com/software-mansion/react-native-screens/issues");
        }
        isObservingContextLifetime = true;
        context.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        View observedView = getObservedView();
        if (hasBeenRegistered && observedView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(observedView, null);
            hasBeenRegistered = false;
            eventSourceView.clear();
        }
        isObservingContextLifetime = false;
    }

    public final void addOnApplyWindowInsetsListener(@NotNull OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    public final void removeOnApplyWindowInsetsListener(@NotNull OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final boolean registerOnView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!getAllowRegistration()) {
            return false;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, this);
        eventSourceView = new WeakReference<>(view);
        hasBeenRegistered = true;
        return true;
    }

    public final void unregister() {
        View observedView = getObservedView();
        if (observedView != null) {
            if (!hasBeenRegistered) {
                observedView = null;
            }
            if (observedView != null) {
                ViewCompat.setOnApplyWindowInsetsListener(observedView, null);
            }
        }
    }

    private final View getObservedView() {
        return eventSourceView.get();
    }
}
