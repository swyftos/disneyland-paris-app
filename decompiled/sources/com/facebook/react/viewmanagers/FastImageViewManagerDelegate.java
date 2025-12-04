package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.FastImageViewManagerInterface;

/* loaded from: classes3.dex */
public class FastImageViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & FastImageViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public FastImageViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        switch (str) {
            case "source":
                ((FastImageViewManagerInterface) this.mViewManager).setSource(t, (ReadableMap) obj);
                break;
            case "defaultSource":
                ((FastImageViewManagerInterface) this.mViewManager).setDefaultSource(t, obj == null ? null : (String) obj);
                break;
            case "tintColor":
                ((FastImageViewManagerInterface) this.mViewManager).setTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "resizeMode":
                ((FastImageViewManagerInterface) this.mViewManager).setResizeMode(t, (String) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
