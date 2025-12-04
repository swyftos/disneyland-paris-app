package com.swmansion.reanimated.layoutReanimation;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class TabNavigatorObserver {
    private final Set<Integer> mFragmentsWithListenerRegistry = new HashSet();
    private final ReaLayoutAnimator mReaLayoutAnimator;

    public TabNavigatorObserver(ReaLayoutAnimator reaLayoutAnimator) {
        this.mReaLayoutAnimator = reaLayoutAnimator;
    }

    public void handleScreenContainerUpdate(View view) {
        try {
            Fragment fragment = (Fragment) view.getClass().getMethod("getFragment", new Class[0]).invoke(view, new Object[0]);
            int id = fragment.getId();
            if (this.mFragmentsWithListenerRegistry.contains(Integer.valueOf(id))) {
                return;
            }
            this.mFragmentsWithListenerRegistry.add(Integer.valueOf(id));
            fragment.getParentFragmentManager().registerFragmentLifecycleCallbacks(new FragmentLifecycleCallbacks(fragment), true);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("[Reanimated]", e.getMessage() != null ? e.getMessage() : "Unable to get screen fragment");
        }
    }

    class FragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
        private View firstScreen;
        private Method getActivityState;
        private Method getScreen;
        private final Set<Integer> screenTagsWithListener = new HashSet();
        private final List<View> nextTransition = new ArrayList();

        public FragmentLifecycleCallbacks(Fragment fragment) throws NoSuchMethodException, SecurityException {
            if (ScreensHelper.isScreenFragment(fragment)) {
                try {
                    Method method = fragment.getClass().getMethod("getScreen", new Class[0]);
                    this.getScreen = method;
                    View view = (View) method.invoke(fragment, new Object[0]);
                    this.getActivityState = view.getClass().getMethod("getActivityState", new Class[0]);
                    addScreenListener(view);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    Log.e("[Reanimated]", e.getMessage() != null ? e.getMessage() : "Unable to get screen activity state");
                }
            }
        }

        private void addScreenListener(View view) throws IllegalAccessException, InvocationTargetException {
            if (this.screenTagsWithListener.contains(Integer.valueOf(view.getId()))) {
                return;
            }
            this.screenTagsWithListener.add(Integer.valueOf(view.getId()));
            view.addOnAttachStateChangeListener(TabNavigatorObserver.this.new OnAttachStateChangeListener());
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.swmansion.reanimated.layoutReanimation.TabNavigatorObserver$FragmentLifecycleCallbacks$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    this.f$0.lambda$addScreenListener$0(view2, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addScreenListener$0(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.nextTransition.isEmpty()) {
                return;
            }
            TabNavigatorObserver.this.mReaLayoutAnimator.getAnimationsManager().navigationTabChanged(this.nextTransition.get(0), this.nextTransition.get(1));
            this.nextTransition.clear();
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
            onFragmentUpdate(fragment, true);
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
            onFragmentUpdate(fragment, false);
        }

        private void onFragmentUpdate(Fragment fragment, boolean z) {
            if (ScreensHelper.isScreenFragment(fragment)) {
                try {
                    View view = (View) this.getScreen.invoke(fragment, new Object[0]);
                    if (this.getActivityState.invoke(view, new Object[0]) == null) {
                        return;
                    }
                    addScreenListener(view);
                    View view2 = this.firstScreen;
                    if (view2 == null) {
                        this.firstScreen = view;
                        return;
                    }
                    if (z) {
                        this.nextTransition.add(view2);
                        this.nextTransition.add(view);
                    } else {
                        this.nextTransition.add(view);
                        this.nextTransition.add(this.firstScreen);
                    }
                    this.firstScreen = null;
                } catch (IllegalAccessException | NullPointerException | InvocationTargetException e) {
                    Log.e("[Reanimated]", e.getMessage() != null ? e.getMessage() : "Unable to get screen view");
                }
            }
        }
    }

    class OnAttachStateChangeListener implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
        }

        OnAttachStateChangeListener() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NonNull View view) {
            TabNavigatorObserver.this.mReaLayoutAnimator.getAnimationsManager().visitNativeTreeAndMakeSnapshot(view);
        }
    }
}
