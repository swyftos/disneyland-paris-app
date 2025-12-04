package com.facebook.react.bridge;

import android.app.Activity;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class ReactContextBaseJavaModule extends BaseJavaModule {
    public ReactContextBaseJavaModule() {
        super(null);
    }

    public ReactContextBaseJavaModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Nullable
    protected final Activity getCurrentActivity() {
        return getReactApplicationContext().getCurrentActivity();
    }
}
