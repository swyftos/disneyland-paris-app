package com.urbanairship.android.layout.ui;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/* loaded from: classes5.dex */
final class BannerViewModelStoreOwner implements ViewModelStoreOwner {
    public static final BannerViewModelStoreOwner INSTANCE = new BannerViewModelStoreOwner();

    private BannerViewModelStoreOwner() {
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return BannerViewModelStore.INSTANCE;
    }
}
