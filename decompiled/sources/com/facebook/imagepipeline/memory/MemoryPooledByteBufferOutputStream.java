package com.facebook.imagepipeline.memory;

import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.reactnative.ReactMessageView;
import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@NotThreadSafe
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0005H\u0007J\b\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream;", "Lcom/facebook/common/memory/PooledByteBufferOutputStream;", "pool", "Lcom/facebook/imagepipeline/memory/MemoryChunkPool;", "initialCapacity", "", "<init>", "(Lcom/facebook/imagepipeline/memory/MemoryChunkPool;I)V", "bufRef", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/memory/MemoryChunk;", "count", "toByteBuffer", "Lcom/facebook/imagepipeline/memory/MemoryPooledByteBuffer;", TCEventPropertiesNames.TCP_SIZE, "write", "", "oneByte", "buffer", "", TypedValues.CycleType.S_WAVE_OFFSET, ReactMessageView.EVENT_CLOSE, "realloc", "newLength", "ensureValid", "InvalidStreamException", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    private CloseableReference bufRef;
    private int count;
    private final MemoryChunkPool pool;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemoryPooledByteBufferOutputStream(@NotNull MemoryChunkPool pool) {
        this(pool, 0, 2, null);
        Intrinsics.checkNotNullParameter(pool, "pool");
    }

    public /* synthetic */ MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(memoryChunkPool, (i2 & 2) != 0 ? memoryChunkPool.getMinBufferSize() : i);
    }

    @JvmOverloads
    public MemoryPooledByteBufferOutputStream(@NotNull MemoryChunkPool pool, int i) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        if (i <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        this.pool = pool;
        this.count = 0;
        this.bufRef = CloseableReference.of(pool.get(i), pool);
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    @NotNull
    public MemoryPooledByteBuffer toByteBuffer() {
        ensureValid();
        CloseableReference closeableReference = this.bufRef;
        if (closeableReference != null) {
            return new MemoryPooledByteBuffer(closeableReference, this.count);
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    /* renamed from: size, reason: from getter */
    public int getCount() {
        return this.count;
    }

    @Override // java.io.OutputStream
    public void write(int oneByte) throws IOException {
        write(new byte[]{(byte) oneByte});
    }

    @Override // java.io.OutputStream
    public void write(@NotNull byte[] buffer, int offset, int count) throws Throwable {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (offset < 0 || count < 0 || offset + count > buffer.length) {
            throw new ArrayIndexOutOfBoundsException("length=" + buffer.length + "; regionStart=" + offset + "; regionLength=" + count);
        }
        ensureValid();
        realloc(this.count + count);
        CloseableReference closeableReference = this.bufRef;
        if (closeableReference == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ((MemoryChunk) closeableReference.get()).write(this.count, buffer, offset, count);
        this.count += count;
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely((CloseableReference<?>) this.bufRef);
        this.bufRef = null;
        this.count = -1;
        super.close();
    }

    @VisibleForTesting
    public final void realloc(int newLength) throws Throwable {
        ensureValid();
        CloseableReference closeableReference = this.bufRef;
        if (closeableReference == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Intrinsics.checkNotNull(closeableReference);
        if (newLength <= ((MemoryChunk) closeableReference.get()).getSize()) {
            return;
        }
        MemoryChunk memoryChunk = this.pool.get(newLength);
        Intrinsics.checkNotNullExpressionValue(memoryChunk, "get(...)");
        MemoryChunk memoryChunk2 = memoryChunk;
        CloseableReference closeableReference2 = this.bufRef;
        if (closeableReference2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Intrinsics.checkNotNull(closeableReference2);
        ((MemoryChunk) closeableReference2.get()).copy(0, memoryChunk2, 0, this.count);
        CloseableReference closeableReference3 = this.bufRef;
        Intrinsics.checkNotNull(closeableReference3);
        closeableReference3.close();
        this.bufRef = CloseableReference.of(memoryChunk2, this.pool);
    }

    private final void ensureValid() {
        if (!CloseableReference.isValid(this.bufRef)) {
            throw new InvalidStreamException();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0002j\u0002`\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream$InvalidStreamException;", "Lkotlin/RuntimeException;", "Ljava/lang/RuntimeException;", "<init>", "()V", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }
}
