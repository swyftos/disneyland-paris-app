package com.reactnativecommunity.viewpager;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.reactnativecommunity.viewpager.event.PageScrollEvent;
import com.reactnativecommunity.viewpager.event.PageScrollStateChangedEvent;
import com.reactnativecommunity.viewpager.event.PageSelectedEvent;
import java.util.Map;

/* loaded from: classes4.dex */
public class ReactViewPagerManager extends ViewGroupManager<ViewPager2> {
    private static final int COMMAND_SET_PAGE = 1;
    private static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;
    private static final int COMMAND_SET_SCROLL_ENABLED = 3;
    private static final String REACT_CLASS = "RNCViewPager";
    private EventDispatcher eventDispatcher;

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @NonNull
    public ViewPager2 createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        final ViewPager2 viewPager2 = new ViewPager2(themedReactContext);
        viewPager2.setAdapter(new FragmentAdapter((FragmentActivity) themedReactContext.getCurrentActivity()));
        viewPager2.setSaveEnabled(false);
        this.eventDispatcher = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.reactnativecommunity.viewpager.ReactViewPagerManager.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i, float f, int i2) {
                super.onPageScrolled(i, f, i2);
                ReactViewPagerManager.this.eventDispatcher.dispatchEvent(new PageScrollEvent(viewPager2.getId(), i, f));
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                ReactViewPagerManager.this.eventDispatcher.dispatchEvent(new PageSelectedEvent(viewPager2.getId(), i));
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i) {
                String str;
                super.onPageScrollStateChanged(i);
                if (i == 0) {
                    str = "idle";
                } else if (i == 1) {
                    str = "dragging";
                } else if (i == 2) {
                    str = "settling";
                } else {
                    throw new IllegalStateException("Unsupported pageScrollState");
                }
                ReactViewPagerManager.this.eventDispatcher.dispatchEvent(new PageScrollStateChangedEvent(viewPager2.getId(), str));
            }
        });
        return viewPager2;
    }

    private void setCurrentItem(final ViewPager2 viewPager2, int i, boolean z) {
        viewPager2.post(new Runnable() { // from class: com.reactnativecommunity.viewpager.ReactViewPagerManager.2
            @Override // java.lang.Runnable
            public void run() {
                ViewPager2 viewPager22 = viewPager2;
                viewPager22.measure(View.MeasureSpec.makeMeasureSpec(viewPager22.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(viewPager2.getHeight(), 1073741824));
                ViewPager2 viewPager23 = viewPager2;
                viewPager23.layout(viewPager23.getLeft(), viewPager2.getTop(), viewPager2.getRight(), viewPager2.getBottom());
            }
        });
        viewPager2.setCurrentItem(i, z);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(ViewPager2 viewPager2, View view, int i) {
        if (view == null) {
            return;
        }
        ((FragmentAdapter) viewPager2.getAdapter()).addFragment(view, i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(ViewPager2 viewPager2) {
        return viewPager2.getAdapter().getItemCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(ViewPager2 viewPager2, int i) {
        return ((FragmentAdapter) viewPager2.getAdapter()).getChildViewAt(i);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(ViewPager2 viewPager2, View view) {
        ((FragmentAdapter) viewPager2.getAdapter()).removeFragment(view);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(ViewPager2 viewPager2) {
        viewPager2.setUserInputEnabled(false);
        ((FragmentAdapter) viewPager2.getAdapter()).removeAll();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(ViewPager2 viewPager2, int i) {
        ((FragmentAdapter) viewPager2.getAdapter()).removeFragmentAt(i);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ViewPager2 viewPager2, boolean z) {
        viewPager2.setUserInputEnabled(z);
    }

    @ReactProp(name = "orientation")
    public void setOrientation(ViewPager2 viewPager2, String str) {
        viewPager2.setOrientation(str.equals("vertical") ? 1 : 0);
    }

    @ReactProp(defaultInt = -1, name = "offscreenPageLimit")
    public void set(ViewPager2 viewPager2, int i) {
        viewPager2.setOffscreenPageLimit(i);
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(ViewPager2 viewPager2, String str) {
        View childAt = viewPager2.getChildAt(0);
        if (str.equals(ReactScrollViewHelper.OVER_SCROLL_NEVER)) {
            childAt.setOverScrollMode(2);
        } else if (str.equals(ReactScrollViewHelper.OVER_SCROLL_ALWAYS)) {
            childAt.setOverScrollMode(0);
        } else {
            childAt.setOverScrollMode(1);
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(PageScrollEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScroll"), PageScrollStateChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScrollStateChanged"), PageSelectedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageSelected"));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("setPage", 1, "setPageWithoutAnimation", 2, "setScrollEnabled", 3);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull ViewPager2 viewPager2, int i, @Nullable ReadableArray readableArray) {
        super.receiveCommand((ReactViewPagerManager) viewPager2, i, readableArray);
        Assertions.assertNotNull(viewPager2);
        Assertions.assertNotNull(readableArray);
        if (i == 1) {
            setCurrentItem(viewPager2, readableArray.getInt(0), true);
            this.eventDispatcher.dispatchEvent(new PageSelectedEvent(viewPager2.getId(), readableArray.getInt(0)));
        } else if (i == 2) {
            setCurrentItem(viewPager2, readableArray.getInt(0), false);
            this.eventDispatcher.dispatchEvent(new PageSelectedEvent(viewPager2.getId(), readableArray.getInt(0)));
        } else {
            if (i == 3) {
                viewPager2.setUserInputEnabled(readableArray.getBoolean(0));
                return;
            }
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i), getClass().getSimpleName()));
        }
    }

    @ReactProp(defaultFloat = BitmapDescriptorFactory.HUE_RED, name = "pageMargin")
    public void setPageMargin(final ViewPager2 viewPager2, float f) {
        final int pixelFromDIP = (int) PixelUtil.toPixelFromDIP(f);
        viewPager2.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.reactnativecommunity.viewpager.ReactViewPagerManager.3
            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public void transformPage(View view, float f2) {
                float f3 = pixelFromDIP * f2;
                if (viewPager2.getOrientation() == 0) {
                    if (viewPager2.getLayoutDirection() == 1) {
                        f3 = -f3;
                    }
                    view.setTranslationX(f3);
                    return;
                }
                view.setTranslationY(f3);
            }
        });
    }
}
