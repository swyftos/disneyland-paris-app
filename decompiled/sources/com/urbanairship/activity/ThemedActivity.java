package com.urbanairship.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;

/* loaded from: classes4.dex */
public abstract class ThemedActivity extends FragmentActivity {
    private static Boolean isAppCompatDependencyAvailable;
    private AppCompatDelegateWrapper delegate;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        InstrumentationCallbacks.onRestartCalled(this);
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        InstrumentationCallbacks.onCreateCalled(this, bundle);
        if (isAppCompatAvailable(this)) {
            this.delegate = AppCompatDelegateWrapper.create(this);
        }
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.onCreate(bundle);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.onPostCreate(bundle);
        }
    }

    @Override // android.app.Activity
    @NonNull
    public MenuInflater getMenuInflater() {
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            return appCompatDelegateWrapper.getMenuInflater();
        }
        return super.getMenuInflater();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(@LayoutRes int i) {
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.setContentView(i);
        } else {
            super.setContentView(i);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.setContentView(view);
        } else {
            super.setContentView(view);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.setContentView(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.addContentView(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        InstrumentationCallbacks.onConfigurationChangedCalled(this, configuration);
        super.onConfigurationChanged(configuration);
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.onStop();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.onPostResume();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        InstrumentationCallbacks.onDestroyCalled(this);
        super.onDestroy();
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.onDestroy();
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.setTitle(charSequence);
        }
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            appCompatDelegateWrapper.invalidateOptionsMenu();
        } else {
            super.invalidateOptionsMenu();
        }
    }

    protected void setDisplayHomeAsUpEnabled(boolean z) {
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            if (appCompatDelegateWrapper.getSupportActionBar() != null) {
                this.delegate.getSupportActionBar().setDisplayHomeAsUpEnabled(z);
                this.delegate.getSupportActionBar().setHomeButtonEnabled(z);
                return;
            }
            return;
        }
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(z);
            getActionBar().setHomeButtonEnabled(z);
        }
    }

    protected void hideActionBar() {
        AppCompatDelegateWrapper appCompatDelegateWrapper = this.delegate;
        if (appCompatDelegateWrapper != null) {
            if (appCompatDelegateWrapper.getSupportActionBar() != null) {
                this.delegate.getSupportActionBar().hide();
            }
        } else if (getActionBar() != null) {
            getActionBar().hide();
        }
    }

    static boolean isAppCompatAvailable(Activity activity) {
        int identifier;
        if (isAppCompatDependencyAvailable == null) {
            try {
                int i = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
                isAppCompatDependencyAvailable = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                isAppCompatDependencyAvailable = Boolean.FALSE;
            }
        }
        if (!isAppCompatDependencyAvailable.booleanValue() || (identifier = activity.getResources().getIdentifier("colorPrimary", "attr", activity.getPackageName())) == 0) {
            return false;
        }
        TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes(new int[]{identifier});
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        return zHasValue;
    }
}
