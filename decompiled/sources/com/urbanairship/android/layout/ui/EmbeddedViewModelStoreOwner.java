package com.urbanairship.android.layout.ui;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/* loaded from: classes5.dex */
final class EmbeddedViewModelStoreOwner implements ViewModelStoreOwner {
    public static final EmbeddedViewModelStoreOwner INSTANCE = new EmbeddedViewModelStoreOwner();

    private EmbeddedViewModelStoreOwner() {
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return EmbeddedViewModelStore.INSTANCE;
    }
}
