package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes2.dex */
interface ArrayAdapterInterface {
    int getArrayLength(Object obj);

    int getElementSizeInBytes();

    String getTag();

    Object newArray(int i);
}
