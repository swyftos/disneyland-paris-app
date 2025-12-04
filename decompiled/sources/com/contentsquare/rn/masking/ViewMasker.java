package com.contentsquare.rn.masking;

import android.view.View;
import androidx.annotation.NonNull;
import com.contentsquare.android.Contentsquare;
import com.contentsquare.rn.utils.ReactNativeViewFinder;
import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes3.dex */
public class ViewMasker {

    @NonNull
    private final ReactNativeViewFinder mReactNativeViewFinder;

    public ViewMasker(@NonNull ReactNativeViewFinder reactNativeViewFinder) {
        this.mReactNativeViewFinder = reactNativeViewFinder;
    }

    public void maskView(@NonNull ReactApplicationContext reactApplicationContext, int i) {
        if (reactApplicationContext.getCurrentActivity() == null) {
            return;
        }
        this.mReactNativeViewFinder.findView(reactApplicationContext, i, new ReactNativeViewFinder.OnViewFoundListener() { // from class: com.contentsquare.rn.masking.ViewMasker$$ExternalSyntheticLambda1
            @Override // com.contentsquare.rn.utils.ReactNativeViewFinder.OnViewFoundListener
            public final void onViewFound(View view) {
                Contentsquare.mask(view);
            }
        });
    }

    public void unmaskView(@NonNull ReactApplicationContext reactApplicationContext, int i) {
        if (reactApplicationContext.getCurrentActivity() == null) {
            return;
        }
        this.mReactNativeViewFinder.findView(reactApplicationContext, i, new ReactNativeViewFinder.OnViewFoundListener() { // from class: com.contentsquare.rn.masking.ViewMasker$$ExternalSyntheticLambda0
            @Override // com.contentsquare.rn.utils.ReactNativeViewFinder.OnViewFoundListener
            public final void onViewFound(View view) {
                Contentsquare.unMask(view);
            }
        });
    }
}
