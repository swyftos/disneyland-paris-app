package com.swmansion.rnscreens.gamma.tabs;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import com.swmansion.rnscreens.gamma.helpers.SystemDrawableKt;
import com.swmansion.rnscreens.utils.RNSLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0014J#\u0010A\u001a\u00020\n\"\u0004\b\u0000\u0010B2\u0006\u0010C\u001a\u0002HB2\u0006\u0010D\u001a\u0002HBH\u0002¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020\nH\u0014J\u0017\u0010K\u001a\u00020\n2\b\u0010L\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0002\bMJ\n\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020\nH\u0002J\b\u0010Q\u001a\u00020\nH\u0002J\r\u0010R\u001a\u00020\nH\u0000¢\u0006\u0002\bSR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R/\u0010#\u001a\u0004\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R/\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010'\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R/\u0010,\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010'\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R/\u00102\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010'\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R/\u00106\u001a\u0004\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010'\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R/\u0010;\u001a\u0004\u0018\u00010:2\b\u0010\"\u001a\u0004\u0018\u00010:8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010'\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010G\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006U"}, m1836d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/TabScreen;", "Landroid/view/ViewGroup;", "Lcom/swmansion/rnscreens/gamma/common/FragmentProviding;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "onLayout", "", "changed", "", CmcdData.Factory.STREAM_TYPE_LIVE, "", "t", "r", "b", "tabScreenDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreenDelegate;", "eventEmitter", "Lcom/swmansion/rnscreens/gamma/tabs/TabScreenEventEmitter;", "getEventEmitter$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/TabScreenEventEmitter;", "setEventEmitter$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/tabs/TabScreenEventEmitter;)V", "value", "", "tabKey", "getTabKey", "()Ljava/lang/String;", "setTabKey", "(Ljava/lang/String;)V", "<set-?>", "tabTitle", "getTabTitle", "setTabTitle", "tabTitle$delegate", "Lkotlin/properties/ReadWriteProperty;", "badgeValue", "getBadgeValue", "setBadgeValue", "badgeValue$delegate", "tabBarItemBadgeTextColor", "getTabBarItemBadgeTextColor", "()Ljava/lang/Integer;", "setTabBarItemBadgeTextColor", "(Ljava/lang/Integer;)V", "tabBarItemBadgeTextColor$delegate", "tabBarItemBadgeBackgroundColor", "getTabBarItemBadgeBackgroundColor", "setTabBarItemBadgeBackgroundColor", "tabBarItemBadgeBackgroundColor$delegate", "iconResourceName", "getIconResourceName", "setIconResourceName", "iconResourceName$delegate", "Landroid/graphics/drawable/Drawable;", "icon", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "icon$delegate", "updateMenuItemAttributesIfNeeded", ExifInterface.GPS_DIRECTION_TRUE, "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "onAttachedToWindow", "isFocusedTab", "()Z", "setFocusedTab", "(Z)V", "setTabScreenDelegate", "delegate", "setTabScreenDelegate$react_native_screens_release", "getAssociatedFragment", "Landroidx/fragment/app/Fragment;", "onTabFocusChangedFromJS", "onMenuItemAttributesChange", "onViewManagerAddEventEmitters", "onViewManagerAddEventEmitters$react_native_screens_release", "Companion", "react-native-screens_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nTabScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TabScreen.kt\ncom/swmansion/rnscreens/gamma/tabs/TabScreen\n+ 2 Delegates.kt\nkotlin/properties/Delegates\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n33#2,3:117\n33#2,3:120\n33#2,3:123\n33#2,3:126\n33#2,3:129\n33#2,3:132\n1#3:135\n*S KotlinDebug\n*F\n+ 1 TabScreen.kt\ncom/swmansion/rnscreens/gamma/tabs/TabScreen\n*L\n42#1:117,3\n47#1:120,3\n51#1:123,3\n55#1:126,3\n60#1:129,3\n66#1:132,3\n*E\n"})
public final class TabScreen extends ViewGroup implements FragmentProviding {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabScreen.class, "tabTitle", "getTabTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabScreen.class, "badgeValue", "getBadgeValue()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabScreen.class, "tabBarItemBadgeTextColor", "getTabBarItemBadgeTextColor()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabScreen.class, "tabBarItemBadgeBackgroundColor", "getTabBarItemBadgeBackgroundColor()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabScreen.class, "iconResourceName", "getIconResourceName()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabScreen.class, "icon", "getIcon()Landroid/graphics/drawable/Drawable;", 0))};

    @NotNull
    public static final String TAG = "TabScreen";

    /* JADX INFO: renamed from: badgeValue$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty badgeValue;
    public TabScreenEventEmitter eventEmitter;

    /* JADX INFO: renamed from: icon$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty icon;

    /* JADX INFO: renamed from: iconResourceName$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty iconResourceName;
    private boolean isFocusedTab;

    @NotNull
    private final ThemedReactContext reactContext;

    /* JADX INFO: renamed from: tabBarItemBadgeBackgroundColor$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty tabBarItemBadgeBackgroundColor;

    /* JADX INFO: renamed from: tabBarItemBadgeTextColor$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty tabBarItemBadgeTextColor;

    @Nullable
    private String tabKey;

    @NotNull
    private WeakReference<TabScreenDelegate> tabScreenDelegate;

    /* JADX INFO: renamed from: tabTitle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty tabTitle;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @NotNull
    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabScreen(@NotNull ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        final Object obj = null;
        this.tabScreenDelegate = new WeakReference<>(null);
        Delegates delegates = Delegates.INSTANCE;
        this.tabTitle = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreen$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabScreen tabScreen = this;
                tabScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        this.badgeValue = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreen$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabScreen tabScreen = this;
                tabScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        this.tabBarItemBadgeTextColor = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreen$special$$inlined$observable$3
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Integer oldValue, Integer newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabScreen tabScreen = this;
                tabScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        this.tabBarItemBadgeBackgroundColor = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreen$special$$inlined$observable$4
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Integer oldValue, Integer newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabScreen tabScreen = this;
                tabScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
        this.iconResourceName = new ObservableProperty<String>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreen$special$$inlined$observable$5
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, String oldValue, String newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                String str = newValue;
                if (Intrinsics.areEqual(str, oldValue)) {
                    return;
                }
                TabScreen tabScreen = this;
                tabScreen.setIcon(SystemDrawableKt.getSystemDrawableResource(tabScreen.getReactContext(), str));
            }
        };
        this.icon = new ObservableProperty<Drawable>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabScreen$special$$inlined$observable$6
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Drawable oldValue, Drawable newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabScreen tabScreen = this;
                tabScreen.updateMenuItemAttributesIfNeeded(oldValue, newValue);
            }
        };
    }

    @NotNull
    public final TabScreenEventEmitter getEventEmitter$react_native_screens_release() {
        TabScreenEventEmitter tabScreenEventEmitter = this.eventEmitter;
        if (tabScreenEventEmitter != null) {
            return tabScreenEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(@NotNull TabScreenEventEmitter tabScreenEventEmitter) {
        Intrinsics.checkNotNullParameter(tabScreenEventEmitter, "<set-?>");
        this.eventEmitter = tabScreenEventEmitter;
    }

    @Nullable
    public final String getTabKey() {
        return this.tabKey;
    }

    public final void setTabKey(@Nullable String str) {
        if (str != null && StringsKt.isBlank(str)) {
            str = null;
        }
        this.tabKey = str;
    }

    @Nullable
    public final String getTabTitle() {
        return (String) this.tabTitle.getValue(this, $$delegatedProperties[0]);
    }

    public final void setTabTitle(@Nullable String str) {
        this.tabTitle.setValue(this, $$delegatedProperties[0], str);
    }

    @Nullable
    public final String getBadgeValue() {
        return (String) this.badgeValue.getValue(this, $$delegatedProperties[1]);
    }

    public final void setBadgeValue(@Nullable String str) {
        this.badgeValue.setValue(this, $$delegatedProperties[1], str);
    }

    @Nullable
    public final Integer getTabBarItemBadgeTextColor() {
        return (Integer) this.tabBarItemBadgeTextColor.getValue(this, $$delegatedProperties[2]);
    }

    public final void setTabBarItemBadgeTextColor(@Nullable Integer num) {
        this.tabBarItemBadgeTextColor.setValue(this, $$delegatedProperties[2], num);
    }

    @Nullable
    public final Integer getTabBarItemBadgeBackgroundColor() {
        return (Integer) this.tabBarItemBadgeBackgroundColor.getValue(this, $$delegatedProperties[3]);
    }

    public final void setTabBarItemBadgeBackgroundColor(@Nullable Integer num) {
        this.tabBarItemBadgeBackgroundColor.setValue(this, $$delegatedProperties[3], num);
    }

    @Nullable
    public final String getIconResourceName() {
        return (String) this.iconResourceName.getValue(this, $$delegatedProperties[4]);
    }

    public final void setIconResourceName(@Nullable String str) {
        this.iconResourceName.setValue(this, $$delegatedProperties[4], str);
    }

    @Nullable
    public final Drawable getIcon() {
        return (Drawable) this.icon.getValue(this, $$delegatedProperties[5]);
    }

    public final void setIcon(@Nullable Drawable drawable) {
        this.icon.setValue(this, $$delegatedProperties[5], drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void updateMenuItemAttributesIfNeeded(T oldValue, T newValue) {
        if (Intrinsics.areEqual(newValue, oldValue)) {
            return;
        }
        onMenuItemAttributesChange();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RNSLog.INSTANCE.m1739d(TAG, "TabScreen [" + getId() + "] attached to window");
        super.onAttachedToWindow();
    }

    /* JADX INFO: renamed from: isFocusedTab, reason: from getter */
    public final boolean getIsFocusedTab() {
        return this.isFocusedTab;
    }

    public final void setFocusedTab(boolean z) {
        if (this.isFocusedTab != z) {
            this.isFocusedTab = z;
            onTabFocusChangedFromJS();
        }
    }

    public final void setTabScreenDelegate$react_native_screens_release(@Nullable TabScreenDelegate delegate) {
        this.tabScreenDelegate = new WeakReference<>(delegate);
    }

    @Override // com.swmansion.rnscreens.gamma.common.FragmentProviding
    @Nullable
    public Fragment getAssociatedFragment() {
        TabScreenDelegate tabScreenDelegate = this.tabScreenDelegate.get();
        if (tabScreenDelegate != null) {
            return tabScreenDelegate.getFragmentForTabScreen(this);
        }
        return null;
    }

    private final void onTabFocusChangedFromJS() {
        TabScreenDelegate tabScreenDelegate = this.tabScreenDelegate.get();
        if (tabScreenDelegate != null) {
            tabScreenDelegate.onTabFocusChangedFromJS(this, this.isFocusedTab);
        }
    }

    private final void onMenuItemAttributesChange() {
        TabScreenDelegate tabScreenDelegate = this.tabScreenDelegate.get();
        if (tabScreenDelegate != null) {
            tabScreenDelegate.onMenuItemAttributesChange(this);
        }
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] TabScreen must have its tag set when registering event emitters");
        }
        setEventEmitter$react_native_screens_release(new TabScreenEventEmitter(this.reactContext, getId()));
    }
}
