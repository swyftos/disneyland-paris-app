package com.facebook.common.memory;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.facebook.infer.annotation.Nullsafe;
import java.nio.ByteBuffer;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public class DecodeBufferHelper implements Pools.Pool<ByteBuffer> {
    public static final DecodeBufferHelper INSTANCE = new DecodeBufferHelper();
    private static int sRecommendedDecodeBufferSize = 16384;
    private static final ThreadLocal sBuffer = new ThreadLocal() { // from class: com.facebook.common.memory.DecodeBufferHelper.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ByteBuffer initialValue() {
            return ByteBuffer.allocate(DecodeBufferHelper.sRecommendedDecodeBufferSize);
        }
    };

    @Override // androidx.core.util.Pools.Pool
    public boolean release(ByteBuffer byteBuffer) {
        return true;
    }

    public static int getRecommendedDecodeBufferSize() {
        return sRecommendedDecodeBufferSize;
    }

    public static void setRecommendedDecodeBufferSize(int i) {
        sRecommendedDecodeBufferSize = i;
    }

    @Override // androidx.core.util.Pools.Pool
    @Nullable
    public ByteBuffer acquire() {
        return (ByteBuffer) sBuffer.get();
    }
}
