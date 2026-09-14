package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSSplitViewHostManagerInterface;

/* JADX INFO: loaded from: classes3.dex */
public class RNSSplitViewHostManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSSplitViewHostManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSSplitViewHostManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "preferredSplitBehavior":
                ((RNSSplitViewHostManagerInterface) this.mViewManager).setPreferredSplitBehavior(t, (String) obj);
                break;
            case "orientation":
                ((RNSSplitViewHostManagerInterface) this.mViewManager).setOrientation(t, (String) obj);
                break;
            case "primaryEdge":
                ((RNSSplitViewHostManagerInterface) this.mViewManager).setPrimaryEdge(t, (String) obj);
                break;
            case "showInspector":
                ((RNSSplitViewHostManagerInterface) this.mViewManager).setShowInspector(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "showSecondaryToggleButton":
                ((RNSSplitViewHostManagerInterface) this.mViewManager).setShowSecondaryToggleButton(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "preferredDisplayMode":
                ((RNSSplitViewHostManagerInterface) this.mViewManager).setPreferredDisplayMode(t, (String) obj);
                break;
            case "presentsWithGesture":
                ((RNSSplitViewHostManagerInterface) this.mViewManager).setPresentsWithGesture(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "displayModeButtonVisibility":
                ((RNSSplitViewHostManagerInterface) this.mViewManager).setDisplayModeButtonVisibility(t, (String) obj);
                break;
            case "columnMetrics":
                ((RNSSplitViewHostManagerInterface) this.mViewManager).setColumnMetrics(t, (ReadableMap) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
