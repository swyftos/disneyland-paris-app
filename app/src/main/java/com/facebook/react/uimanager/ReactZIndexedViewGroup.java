package com.facebook.react.uimanager;

import com.urbanairship.json.matchers.ArrayContainsMatcher;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, m1836d2 = {"Lcom/facebook/react/uimanager/ReactZIndexedViewGroup;", "", "getZIndexMappedChildIndex", "", ArrayContainsMatcher.INDEX_KEY, "updateDrawingOrder", "", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface ReactZIndexedViewGroup {
    int getZIndexMappedChildIndex(int index);

    void updateDrawingOrder();
}
