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

/* loaded from: classes2.dex */
public final class T8 implements Window.Callback {

    @JvmField
    @NotNull
    public static final c d = new c();

    @NotNull
    public static final a e = new a();

    @NotNull
    public static final WeakHashMap f = new WeakHashMap();

    @NotNull
    public static List<? extends WeakReference<InterfaceC0860y3>> g = CollectionsKt.emptyList();

    @NotNull
    public final c a;

    @NotNull
    public final Window.Callback b;
    public boolean c;

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

    public static final class b {
        public static void a(@NotNull Window window) {
            c staticProvider = T8.d;
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(staticProvider, "staticProvider");
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(staticProvider, "staticProvider");
            if (window.getCallback() instanceof T8) {
                return;
            }
            Iterator it = T8.f.keySet().iterator();
            while (it.hasNext()) {
                ((T8) it.next()).c = false;
            }
            T8 t8 = new T8(window.getCallback());
            WeakHashMap weakHashMap = T8.f;
            Boolean TRUE = Boolean.TRUE;
            Intrinsics.checkNotNullExpressionValue(TRUE, "TRUE");
            weakHashMap.put(t8, TRUE);
            window.setCallback(t8);
        }
    }

    public static final class c {
    }

    public T8(@Nullable Window.Callback callback) {
        c staticProvider = d;
        Intrinsics.checkNotNullParameter(staticProvider, "staticProvider");
        this.a = staticProvider;
        this.b = callback == null ? e : callback;
        this.c = true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.b.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.b.dispatchKeyEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.b.dispatchKeyShortcutEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(@NotNull AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.b.dispatchPopulateAccessibilityEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.c) {
            this.a.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            Contentsquare.consumeEvent(event);
            this.a.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            Iterator<? extends WeakReference<InterfaceC0860y3>> it = g.iterator();
            while (it.hasNext()) {
                InterfaceC0860y3 interfaceC0860y3 = it.next().get();
                if (interfaceC0860y3 != null) {
                    interfaceC0860y3.a(event);
                }
            }
        }
        return this.b.dispatchTouchEvent(event);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.b.dispatchTrackballEvent(event);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(@NotNull ActionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.b.onActionModeFinished(mode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(@NotNull ActionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.b.onActionModeStarted(mode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.b.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.b.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        return this.b.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public final View onCreatePanelView(int i) {
        return this.b.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.b.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, @NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return this.b.onMenuItemSelected(i, item);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        return this.b.onMenuOpened(i, menu);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.b.onPanelClosed(i, menu);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 26)
    public final void onPointerCaptureChanged(boolean z) {
        this.b.onPointerCaptureChanged(z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, @Nullable View view, @NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        return this.b.onPreparePanel(i, view, menu);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 24)
    public final void onProvideKeyboardShortcuts(@NotNull List<KeyboardShortcutGroup> data, @Nullable Menu menu, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.b.onProvideKeyboardShortcuts(data, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.b.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(@NotNull WindowManager.LayoutParams attrs) {
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.b.onWindowAttributesChanged(attrs);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.b.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public final ActionMode onWindowStartingActionMode(@NotNull ActionMode.Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.b.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 23)
    public final boolean onSearchRequested(@NotNull SearchEvent searchEvent) {
        Intrinsics.checkNotNullParameter(searchEvent, "searchEvent");
        return this.b.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(api = 23)
    @Nullable
    public final ActionMode onWindowStartingActionMode(@NotNull ActionMode.Callback callback, int i) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.b.onWindowStartingActionMode(callback, i);
    }
}
