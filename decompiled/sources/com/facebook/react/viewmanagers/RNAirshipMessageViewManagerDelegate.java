package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNAirshipMessageViewManagerInterface;
import com.google.firebase.messaging.Constants;

/* loaded from: classes3.dex */
public class RNAirshipMessageViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNAirshipMessageViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNAirshipMessageViewManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, @Nullable Object obj) {
        str.hashCode();
        if (str.equals(Constants.FirelogAnalytics.PARAM_MESSAGE_ID)) {
            ((RNAirshipMessageViewManagerInterface) this.mViewManager).setMessageId(t, obj == null ? null : (String) obj);
        } else {
            super.kotlinCompat$setProperty(t, str, obj);
        }
    }
}
