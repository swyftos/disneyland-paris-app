package com.facebook.fresco.p027ui.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, m1836d2 = {"Lcom/facebook/fresco/ui/common/ImagePerfDataListener;", "", "onImageLoadStatusUpdated", "", "imagePerfData", "Lcom/facebook/fresco/ui/common/ImagePerfData;", "imageLoadStatus", "Lcom/facebook/fresco/ui/common/ImageLoadStatus;", "onImageVisibilityUpdated", "visibilityState", "Lcom/facebook/fresco/ui/common/VisibilityState;", "ui-common_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface ImagePerfDataListener {
    void onImageLoadStatusUpdated(@NotNull ImagePerfData imagePerfData, @NotNull ImageLoadStatus imageLoadStatus);

    void onImageVisibilityUpdated(@NotNull ImagePerfData imagePerfData, @NotNull VisibilityState visibilityState);
}
