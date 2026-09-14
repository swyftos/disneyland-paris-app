package com.facebook.drawee.backends.pipeline.info;

import com.facebook.fresco.p027ui.common.ImageLoadStatus;
import com.facebook.fresco.p027ui.common.ImagePerfData;
import com.facebook.fresco.p027ui.common.ImagePerfDataListener;
import com.facebook.fresco.p027ui.common.VisibilityState;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class ForwardingImagePerfDataListener implements ImagePerfDataListener {
    private final Collection mListeners;

    public ForwardingImagePerfDataListener(Collection<ImagePerfDataListener> collection) {
        this.mListeners = collection;
    }

    @Override // com.facebook.fresco.p027ui.common.ImagePerfDataListener
    public void onImageLoadStatusUpdated(ImagePerfData imagePerfData, ImageLoadStatus imageLoadStatus) {
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((ImagePerfDataListener) it.next()).onImageLoadStatusUpdated(imagePerfData, imageLoadStatus);
        }
    }

    @Override // com.facebook.fresco.p027ui.common.ImagePerfDataListener
    public void onImageVisibilityUpdated(ImagePerfData imagePerfData, VisibilityState visibilityState) {
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((ImagePerfDataListener) it.next()).onImageVisibilityUpdated(imagePerfData, visibilityState);
        }
    }
}
