package com.urbanairship.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;

/* loaded from: classes4.dex */
class AppCompatDelegateWrapper {
    private AppCompatDelegate delegate;

    AppCompatDelegateWrapper() {
    }

    static AppCompatDelegateWrapper create(Activity activity) {
        AppCompatDelegateWrapper appCompatDelegateWrapper = new AppCompatDelegateWrapper();
        appCompatDelegateWrapper.delegate = AppCompatDelegate.create(activity, (AppCompatCallback) null);
        return appCompatDelegateWrapper;
    }

    void onCreate(Bundle bundle) {
        AppCompatDelegate appCompatDelegate = this.delegate;
        if (appCompatDelegate != null) {
            appCompatDelegate.installViewFactory();
            this.delegate.onCreate(bundle);
        }
    }

    void onPostCreate(Bundle bundle) {
        this.delegate.onPostCreate(bundle);
    }

    MenuInflater getMenuInflater() {
        return this.delegate.getMenuInflater();
    }

    void setContentView(int i) {
        this.delegate.setContentView(i);
    }

    void setContentView(View view) {
        this.delegate.setContentView(view);
    }

    void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.delegate.setContentView(view, layoutParams);
    }

    void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.delegate.addContentView(view, layoutParams);
    }

    void onConfigurationChanged(Configuration configuration) {
        this.delegate.onConfigurationChanged(configuration);
    }

    void onPostResume() {
        this.delegate.onPostResume();
    }

    void onStop() {
        this.delegate.onStop();
    }

    void invalidateOptionsMenu() {
        this.delegate.invalidateOptionsMenu();
    }

    void setTitle(CharSequence charSequence) {
        this.delegate.setTitle(charSequence);
    }

    void onDestroy() {
        this.delegate.onDestroy();
    }

    ActionBar getSupportActionBar() {
        return this.delegate.getSupportActionBar();
    }
}
