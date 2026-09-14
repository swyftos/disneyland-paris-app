package com.contentsquare.android.sdk;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RequiresApi;
import com.contentsquare.android.Contentsquare;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.T8 */
/* JADX INFO: loaded from: classes2.dex */
public final class WindowCallbackC2634T8 implements Window.Callback {

    /* JADX INFO: renamed from: d */
    @JvmField
    @NotNull
    public static final c f2159d = new c();

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final a f2160e = new a();

    /* JADX INFO: renamed from: f */
    @NotNull
    public static final WeakHashMap f2161f = new WeakHashMap();

    /* JADX INFO: renamed from: g */
    @NotNull
    public static List<? extends WeakReference<InterfaceC2934y3>> f2162g = CollectionsKt.emptyList();

    /* JADX INFO: renamed from: a */
    @NotNull
    public final c f2163a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Window.Callback f2164b;

    /* JADX INFO: renamed from: c */
    public boolean f2165c;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T8$a */
    public static final class a implements Window.Callback {
        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(@NotNull KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(@NotNull KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(@NotNull AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(@NotNull ActionMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(@NotNull ActionMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
        }

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i, @NotNull Menu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            return false;
        }

        @Override // android.view.Window.Callback
        @Nullable
        public final View onCreatePanelView(int i) {
            return null;
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int i, @NotNull MenuItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return false;
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int i, @NotNull Menu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            return false;
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int i, @NotNull Menu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int i, @Nullable View view, @NotNull Menu menu) {
            Intrinsics.checkNotNullParameter(menu, "menu");
            return false;
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return false;
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(@NotNull WindowManager.LayoutParams attrs) {
            Intrinsics.checkNotNullParameter(attrs, "attrs");
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean z) {
        }

        @Override // android.view.Window.Callback
        @Nullable
        public final ActionMode onWindowStartingActionMode(@NotNull ActionMode.Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            return null;
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(@NotNull SearchEvent searchEvent) {
            Intrinsics.checkNotNullParameter(searchEvent, "searchEvent");
            return false;
        }

        @Override // android.view.Window.Callback
        @Nullable
        public final ActionMode onWindowStartingActionMode(@NotNull ActionMode.Callback callback, int i) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            return null;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T8$b */
    public static final class b {
        /* JADX INFO: renamed from: a */
        public static void m1038a(@NotNull Window window) {
            c staticProvider = WindowCallbackC2634T8.f2159d;
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(staticProvider, "staticProvider");
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(staticProvider, "staticProvider");
            if (window.getCallback() instanceof WindowCallbackC2634T8) {
                return;
            }
            Iterator it = WindowCallbackC2634T8.f2161f.keySet().iterator();
            while (it.hasNext()) {
                ((WindowCallbackC2634T8) it.next()).f2165c = false;
            }
            WindowCallbackC2634T8 windowCallbackC2634T8 = new WindowCallbackC2634T8(window.getCallback());
            WeakHashMap weakHashMap = WindowCallbackC2634T8.f2161f;
            Boolean TRUE = Boolean.TRUE;
            Intrinsics.checkNotNullExpressionValue(TRUE, "TRUE");
            weakHashMap.put(windowCallbackC2634T8, TRUE);
            window.setCallback(windowCallbackC2634T8);
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.T8$c */
    public static final class c {
    }

    public WindowCallbackC2634T8(@Nullable Window.Callback callback) {
        c staticProvider = f2159d;
        Intrinsics.checkNotNullParameter(staticProvider, "staticProvider");
        this.f2163a = staticProvider;
        this.f2164b = callback == null ? f2160e : callback;
        this.f2165c = true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.f2164b.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.f2164b.dispatchKeyEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.f2164b.dispatchKeyShortcutEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(@NotNull AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.f2164b.dispatchPopulateAccessibilityEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.f2165c) {
            this.f2163a.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            Contentsquare.consumeEvent(event);
            this.f2163a.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            Iterator<? extends WeakReference<InterfaceC2934y3>> it = f2162g.iterator();
            while (it.hasNext()) {
                InterfaceC2934y3 interfaceC2934y3 = it.next().get();
                if (interfaceC2934y3 != null) {
                    interfaceC2934y3.mo889a(event);
                }
            }
        }
        return this.f2164b.dispatchTouchEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.f2164b.dispatchTrackballEvent(event);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(@NotNull ActionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.f2164b.onActionModeFinished(mode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(@NotNull ActionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.f2164b.onActionModeStarted(mode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f2164b.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f2164b.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        return this.f2164b.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public final View onCreatePanelView(int i) {
        return this.f2164b.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f2164b.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, @NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return this.f2164b.onMenuItemSelected(i, item);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        return this.f2164b.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.f2164b.onPanelClosed(i, menu);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 26)
    public final void onPointerCaptureChanged(boolean z) {
        this.f2164b.onPointerCaptureChanged(z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, @Nullable View view, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        return this.f2164b.onPreparePanel(i, view, menu);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 24)
    public final void onProvideKeyboardShortcuts(@NotNull List<KeyboardShortcutGroup> data, @Nullable Menu menu, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f2164b.onProvideKeyboardShortcuts(data, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f2164b.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(@NotNull WindowManager.LayoutParams attrs) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.f2164b.onWindowAttributesChanged(attrs);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.f2164b.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public final ActionMode onWindowStartingActionMode(@NotNull ActionMode.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.f2164b.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 23)
    public final boolean onSearchRequested(@NotNull SearchEvent searchEvent) {
        Intrinsics.checkNotNullParameter(searchEvent, "searchEvent");
        return this.f2164b.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 23)
    @Nullable
    public final ActionMode onWindowStartingActionMode(@NotNull ActionMode.Callback callback, int i) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.f2164b.onWindowStartingActionMode(callback, i);
    }
}
