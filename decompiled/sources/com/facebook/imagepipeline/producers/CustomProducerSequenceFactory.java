package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.ProducerFactory;
import com.facebook.imagepipeline.core.ProducerSequenceFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.Nullable;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public class CustomProducerSequenceFactory {
    @Nullable
    public Producer<CloseableReference<CloseableImage>> getCustomDecodedImageSequence(ImageRequest imageRequest, ProducerSequenceFactory producerSequenceFactory) {
        return null;
    }

    @Nullable
    public Producer<CloseableReference<PooledByteBuffer>> getCustomEncodedImageSequence(ImageRequest imageRequest, ProducerSequenceFactory producerSequenceFactory, ProducerFactory producerFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        return null;
    }

    @Nullable
    public Producer<CloseableReference<CloseableImage>> getCustomDecodedImageSequence(ImageRequest imageRequest, ProducerSequenceFactory producerSequenceFactory, ProducerFactory producerFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z, boolean z2) {
        return getCustomDecodedImageSequence(imageRequest, producerSequenceFactory);
    }
}
