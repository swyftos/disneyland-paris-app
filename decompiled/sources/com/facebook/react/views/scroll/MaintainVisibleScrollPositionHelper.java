package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.scroll.ReactScrollViewHelper.HasSmoothScroll;
import com.facebook.react.views.view.ReactViewGroup;
import java.lang.ref.WeakReference;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
class MaintainVisibleScrollPositionHelper<ScrollViewT extends ViewGroup & ReactScrollViewHelper.HasSmoothScroll> implements UIManagerListener {

    @Nullable
    private Config mConfig;
    private final boolean mHorizontal;
    private final ScrollViewT mScrollView;

    @Nullable
    private WeakReference<View> mFirstVisibleView = null;

    @Nullable
    private Rect mPrevFirstVisibleFrame = null;
    private boolean mListening = false;

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didDispatchMountItems(UIManager uIManager) {
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(UIManager uIManager) {
    }

    public static class Config {

        @Nullable
        public final Integer autoScrollToTopThreshold;
        public final int minIndexForVisible;

        Config(int i, @Nullable Integer num) {
            this.minIndexForVisible = i;
            this.autoScrollToTopThreshold = num;
        }

        static Config fromReadableMap(ReadableMap readableMap) {
            return new Config(readableMap.getInt("minIndexForVisible"), readableMap.hasKey("autoscrollToTopThreshold") ? Integer.valueOf(readableMap.getInt("autoscrollToTopThreshold")) : null);
        }
    }

    public MaintainVisibleScrollPositionHelper(ScrollViewT scrollviewt, boolean z) {
        this.mScrollView = scrollviewt;
        this.mHorizontal = z;
    }

    public void setConfig(@Nullable Config config) {
        this.mConfig = config;
    }

    public void start() {
        if (this.mListening) {
            return;
        }
        this.mListening = true;
        getUIManagerModule().addUIManagerEventListener(this);
    }

    public void stop() {
        if (this.mListening) {
            this.mListening = false;
            getUIManagerModule().removeUIManagerEventListener(this);
        }
    }

    public void updateScrollPosition() {
        if (ViewUtil.getUIManagerType(this.mScrollView.getId()) == 2) {
            return;
        }
        updateScrollPositionInternal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateScrollPositionInternal() {
        WeakReference<View> weakReference;
        View view;
        if (this.mConfig == null || (weakReference = this.mFirstVisibleView) == null || this.mPrevFirstVisibleFrame == null || (view = weakReference.get()) == null) {
            return;
        }
        Rect rect = new Rect();
        view.getHitRect(rect);
        if (this.mHorizontal) {
            int i = rect.left - this.mPrevFirstVisibleFrame.left;
            if (i != 0) {
                int scrollX = this.mScrollView.getScrollX();
                ScrollViewT scrollviewt = this.mScrollView;
                scrollviewt.scrollToPreservingMomentum(i + scrollX, scrollviewt.getScrollY());
                this.mPrevFirstVisibleFrame = rect;
                Integer num = this.mConfig.autoScrollToTopThreshold;
                if (num == null || scrollX > num.intValue()) {
                    return;
                }
                ScrollViewT scrollviewt2 = this.mScrollView;
                scrollviewt2.reactSmoothScrollTo(0, scrollviewt2.getScrollY());
                return;
            }
            return;
        }
        int i2 = rect.top - this.mPrevFirstVisibleFrame.top;
        if (i2 != 0) {
            int scrollY = this.mScrollView.getScrollY();
            ScrollViewT scrollviewt3 = this.mScrollView;
            scrollviewt3.scrollToPreservingMomentum(scrollviewt3.getScrollX(), i2 + scrollY);
            this.mPrevFirstVisibleFrame = rect;
            Integer num2 = this.mConfig.autoScrollToTopThreshold;
            if (num2 == null || scrollY > num2.intValue()) {
                return;
            }
            ScrollViewT scrollviewt4 = this.mScrollView;
            scrollviewt4.reactSmoothScrollTo(scrollviewt4.getScrollX(), 0);
        }
    }

    @Nullable
    private ReactViewGroup getContentView() {
        return (ReactViewGroup) this.mScrollView.getChildAt(0);
    }

    private UIManager getUIManagerModule() {
        return (UIManager) Assertions.assertNotNull(UIManagerHelper.getUIManager((ReactContext) this.mScrollView.getContext(), ViewUtil.getUIManagerType(this.mScrollView.getId())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void computeTargetView() {
        ReactViewGroup contentView;
        float y;
        int height;
        if (this.mConfig == null || (contentView = getContentView()) == null) {
            return;
        }
        int scrollX = this.mHorizontal ? this.mScrollView.getScrollX() : this.mScrollView.getScrollY();
        for (int i = this.mConfig.minIndexForVisible; i < contentView.getChildCount(); i++) {
            View childAt = contentView.getChildAt(i);
            if (this.mHorizontal) {
                y = childAt.getX();
                height = childAt.getWidth();
            } else {
                y = childAt.getY();
                height = childAt.getHeight();
            }
            if (y + height > scrollX || i == contentView.getChildCount() - 1) {
                this.mFirstVisibleView = new WeakReference<>(childAt);
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                this.mPrevFirstVisibleFrame = rect;
                return;
            }
        }
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willDispatchViewUpdates(UIManager uIManager) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.views.scroll.MaintainVisibleScrollPositionHelper.1
            @Override // java.lang.Runnable
            public void run() {
                MaintainVisibleScrollPositionHelper.this.computeTargetView();
            }
        });
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(UIManager uIManager) {
        computeTargetView();
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uIManager) {
        updateScrollPositionInternal();
    }
}
