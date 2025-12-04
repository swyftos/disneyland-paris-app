package com.urbanairship.android.layout.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.model.PagerModel;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.view.PagerView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class PagerRecyclerView extends RecyclerView {
    private PagerAdapter adapter;
    private boolean isInternalScroll;
    private LinearLayoutManager layoutManager;
    private PagerView.OnScrollListener listener;
    private final PagerModel model;
    private final RecyclerView.OnScrollListener recyclerScrollListener;
    private PagerSnapHelper snapHelper;
    private final ViewEnvironment viewEnvironment;

    public PagerRecyclerView(@NonNull Context context, @NonNull PagerModel pagerModel, @NonNull ViewEnvironment viewEnvironment) throws IllegalStateException {
        super(context);
        this.isInternalScroll = false;
        this.listener = null;
        this.recyclerScrollListener = new RecyclerView.OnScrollListener() { // from class: com.urbanairship.android.layout.widget.PagerRecyclerView.1
            private int previousPosition = 0;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int i2;
                int displayedItemPosition = PagerRecyclerView.this.getDisplayedItemPosition();
                if (displayedItemPosition != -1 && displayedItemPosition != (i2 = this.previousPosition)) {
                    int i3 = displayedItemPosition > i2 ? 1 : -1;
                    int iAbs = Math.abs(displayedItemPosition - i2);
                    int i4 = 0;
                    while (i4 < iAbs) {
                        i4++;
                        int i5 = this.previousPosition + (i3 * i4);
                        if (PagerRecyclerView.this.listener != null) {
                            PagerRecyclerView.this.listener.onScrollTo(i5, PagerRecyclerView.this.isInternalScroll);
                        }
                    }
                }
                this.previousPosition = displayedItemPosition;
                if (i == 0) {
                    PagerRecyclerView.this.isInternalScroll = false;
                }
            }
        };
        this.model = pagerModel;
        this.viewEnvironment = viewEnvironment;
        setId(pagerModel.getRecyclerViewId());
        configure();
    }

    public void refresh() {
        this.adapter.setItems(this.model.getPages());
    }

    public void configure() throws IllegalStateException {
        setHorizontalScrollBarEnabled(false);
        SnapHelper snapHelper = new SnapHelper();
        this.snapHelper = snapHelper;
        snapHelper.attachToRecyclerView(this);
        if (this.model.isSinglePage() || this.model.getViewInfo().getIsSwipeDisabled()) {
            this.layoutManager = new SwipeDisabledLinearLayoutManager(getContext(), 0);
        } else {
            this.layoutManager = new ThomasLinearLayoutManager(getContext(), 0);
        }
        setLayoutManager(this.layoutManager);
        addOnScrollListener(this.recyclerScrollListener);
        PagerAdapter pagerAdapter = new PagerAdapter(this.model, this.viewEnvironment);
        this.adapter = pagerAdapter;
        pagerAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        this.adapter.setItems(this.model.getPages());
        setAdapter(this.adapter);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.android.layout.widget.PagerRecyclerView$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.lambda$configure$0(view, windowInsetsCompat);
            }
        });
        if (ViewExtensionsKt.isLayoutRtl(this)) {
            scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat lambda$configure$0(View view, WindowInsetsCompat windowInsetsCompat) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.dispatchApplyWindowInsets(getChildAt(i), windowInsetsCompat);
        }
        return windowInsetsCompat;
    }

    public int getDisplayedItemPosition() {
        View viewFindSnapView = this.snapHelper.findSnapView(this.layoutManager);
        if (viewFindSnapView != null) {
            return getChildAdapterPosition(viewFindSnapView);
        }
        return 0;
    }

    public void scrollTo(int i) {
        this.isInternalScroll = true;
        smoothScrollToPosition(i);
    }

    public void setPagerScrollListener(@Nullable PagerView.OnScrollListener onScrollListener) {
        this.listener = onScrollListener;
    }

    private static class ThomasLinearLayoutManager extends LinearLayoutManager {
        public ThomasLinearLayoutManager(Context context, int i) {
            super(context, i, false);
            setItemPrefetchEnabled(false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-1, -1);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            ThomasSmoothScroller thomasSmoothScroller = new ThomasSmoothScroller(recyclerView.getContext());
            thomasSmoothScroller.setTargetPosition(i);
            startSmoothScroll(thomasSmoothScroller);
        }
    }

    private static class SwipeDisabledLinearLayoutManager extends ThomasLinearLayoutManager {
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        public SwipeDisabledLinearLayoutManager(Context context, int i) {
            super(context, i);
        }

        @Override // com.urbanairship.android.layout.widget.PagerRecyclerView.ThomasLinearLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            SwipeDisabledSmoothScroller swipeDisabledSmoothScroller = new SwipeDisabledSmoothScroller(recyclerView.getContext());
            swipeDisabledSmoothScroller.setTargetPosition(i);
            startSmoothScroll(swipeDisabledSmoothScroller);
        }

        private static class SwipeDisabledSmoothScroller extends ThomasSmoothScroller {
            public SwipeDisabledSmoothScroller(Context context) {
                super(context);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int calculateDxToMakeVisible(View view, int i) {
                RecyclerView.LayoutManager layoutManager = getLayoutManager();
                if (layoutManager == null) {
                    return 0;
                }
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return calculateDtToFit(layoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, layoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i);
            }
        }
    }

    private static class ThomasSmoothScroller extends LinearSmoothScroller {
        public ThomasSmoothScroller(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 65.0f / displayMetrics.densityDpi;
        }
    }

    private static class SnapHelper extends PagerSnapHelper {
        private OrientationHelper horizontalHelper;
        private OrientationHelper verticalHelper;

        private SnapHelper() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (layoutManager.canScrollVertically()) {
                return findCenterView(layoutManager, getVerticalHelper(layoutManager));
            }
            if (layoutManager.canScrollHorizontally()) {
                return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
            }
            return null;
        }

        private View findCenterView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
            int childCount = layoutManager.getChildCount();
            View view = null;
            if (childCount == 0) {
                return null;
            }
            int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = layoutManager.getChildAt(i2);
                int iAbs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
                if (iAbs < i) {
                    view = childAt;
                    i = iAbs;
                }
            }
            return view;
        }

        private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
            OrientationHelper orientationHelper = this.verticalHelper;
            if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
                this.verticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
            }
            return this.verticalHelper;
        }

        private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
            OrientationHelper orientationHelper = this.horizontalHelper;
            if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
                this.horizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
            }
            return this.horizontalHelper;
        }
    }
}
