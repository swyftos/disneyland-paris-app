package com.dylanvann.fastimage;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes3.dex */
class FastImageViewModule extends NativeFastImageViewModuleSpec {
    FastImageViewModuleImplementation impl;

    FastImageViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.impl = new FastImageViewModuleImplementation(reactApplicationContext);
    }

    @Override // com.dylanvann.fastimage.NativeFastImageViewModuleSpec, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NativeFastImageViewModuleSpec.NAME;
    }

    @Override // com.dylanvann.fastimage.NativeFastImageViewModuleSpec
    public void preload(ReadableArray readableArray) {
        this.impl.preload(readableArray);
    }

    @Override // com.dylanvann.fastimage.NativeFastImageViewModuleSpec
    public void clearMemoryCache(Promise promise) {
        this.impl.clearMemoryCache(promise);
    }

    @Override // com.dylanvann.fastimage.NativeFastImageViewModuleSpec
    public void clearDiskCache(Promise promise) {
        this.impl.clearDiskCache(promise);
    }
}
