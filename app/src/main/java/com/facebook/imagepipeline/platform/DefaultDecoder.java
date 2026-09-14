package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.DecodeBufferHelper;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.DummyBitmapPool;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: classes3.dex */
@ThreadSafe
@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class DefaultDecoder implements PlatformDecoder {
    private boolean mAvoidPoolGet;
    private boolean mAvoidPoolRelease;
    private final BitmapPool mBitmapPool;
    final Pools.Pool mDecodeBuffers;
    private final PreverificationHelper mPreverificationHelper = new PreverificationHelper();
    private static final Class TAG = DefaultDecoder.class;
    private static final byte[] EOI_TAIL = {-1, -39};

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

    public DefaultDecoder(BitmapPool bitmapPool, Pools.Pool<ByteBuffer> pool, PlatformDecoderOptions platformDecoderOptions) {
        this.mBitmapPool = bitmapPool;
        if (bitmapPool instanceof DummyBitmapPool) {
            this.mAvoidPoolGet = platformDecoderOptions.getAvoidPoolGet();
            this.mAvoidPoolRelease = platformDecoderOptions.getAvoidPoolRelease();
        }
        this.mDecodeBuffers = pool;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @Nullable
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @Nullable
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @Nullable
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config, this.mAvoidPoolGet);
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream((InputStream) Preconditions.checkNotNull(encodedImage.getInputStream()), decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    @Nullable
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace) {
        boolean zIsCompleteAt = encodedImage.isCompleteAt(i);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config, this.mAvoidPoolGet);
        InputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        if (!zIsCompleteAt) {
            inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            try {
                CloseableReference<Bitmap> closeableReferenceDecodeFromStream = decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return closeableReferenceDecodeFromStream;
            } catch (RuntimeException e2) {
                if (z) {
                    CloseableReference<Bitmap> closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace = decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return closeableReferenceDecodeJPEGFromEncodedImageWithColorSpace;
                }
                throw e2;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    @Nullable
    protected CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        return decodeFromStream(inputStream, options, rect, null);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b5 A[Catch: all -> 0x0098, RuntimeException -> 0x009b, IllegalArgumentException -> 0x009d, TryCatch #4 {IllegalArgumentException -> 0x009d, blocks: (B:32:0x0072, B:35:0x007c, B:45:0x0094, B:64:0x00bc, B:60:0x00b5, B:61:0x00b8, B:58:0x00af), top: B:95:0x0072, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc A[Catch: all -> 0x0098, RuntimeException -> 0x009b, IllegalArgumentException -> 0x009d, TRY_LEAVE, TryCatch #4 {IllegalArgumentException -> 0x009d, blocks: (B:32:0x0072, B:35:0x007c, B:45:0x0094, B:64:0x00bc, B:60:0x00b5, B:61:0x00b8, B:58:0x00af), top: B:95:0x0072, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:75:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    private CloseableReference decodeFromStream(InputStream inputStream, BitmapFactory.Options options, Rect rect, ColorSpace colorSpace) {
        Bitmap bitmap;
        ByteBuffer byteBufferAllocate;
        Bitmap bitmapDecodeStream;
        Bitmap.Config config;
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        Preconditions.checkNotNull(inputStream);
        int iWidth = options.outWidth;
        int iHeight = options.outHeight;
        if (rect != null) {
            iWidth = rect.width() / options.inSampleSize;
            iHeight = rect.height() / options.inSampleSize;
        }
        PreverificationHelper preverificationHelper = this.mPreverificationHelper;
        boolean z = preverificationHelper != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
        BitmapRegionDecoder bitmapRegionDecoder = null;
        try {
            try {
                try {
                    if (rect == null && z) {
                        options.inMutable = false;
                    } else {
                        if (rect != null && z) {
                            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        }
                        if (!this.mAvoidPoolGet) {
                            bitmap = this.mBitmapPool.get(getBitmapSize(iWidth, iHeight, options));
                            if (bitmap == null) {
                                throw new NullPointerException("BitmapPool.get returned null");
                            }
                        }
                        options.inBitmap = bitmap;
                        if (colorSpace == null) {
                            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                        }
                        options.inPreferredColorSpace = colorSpace;
                        byteBufferAllocate = (ByteBuffer) this.mDecodeBuffers.acquire();
                        if (byteBufferAllocate == null) {
                            byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
                        }
                        options.inTempStorage = byteBufferAllocate.array();
                        if (rect != null || bitmap == null || (config = options.inPreferredConfig) == null) {
                            bitmapDecodeStream = null;
                        } else {
                            try {
                                bitmap.reconfigure(iWidth, iHeight, config);
                                bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStream, true);
                                if (bitmapRegionDecoderNewInstance != null) {
                                    try {
                                        try {
                                            bitmapDecodeStream = bitmapRegionDecoderNewInstance.decodeRegion(rect, options);
                                        } catch (Throwable th) {
                                            th = th;
                                            bitmapRegionDecoder = bitmapRegionDecoderNewInstance;
                                            if (bitmapRegionDecoder != null) {
                                                bitmapRegionDecoder.recycle();
                                            }
                                            throw th;
                                        }
                                    } catch (IOException unused) {
                                        FLog.m1289e((Class<?>) TAG, "Could not decode region %s, decoding full bitmap instead.", rect);
                                        if (bitmapRegionDecoderNewInstance != null) {
                                            bitmapRegionDecoderNewInstance.recycle();
                                        }
                                        bitmapDecodeStream = null;
                                        if (bitmapDecodeStream == null) {
                                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                                        }
                                        this.mDecodeBuffers.release(byteBufferAllocate);
                                        if (bitmap == null) {
                                        }
                                        if (this.mAvoidPoolRelease) {
                                            return CloseableReference.m1347of(bitmapDecodeStream, NoOpResourceReleaser.INSTANCE);
                                        }
                                        return CloseableReference.m1347of(bitmapDecodeStream, this.mBitmapPool);
                                    }
                                } else {
                                    bitmapDecodeStream = null;
                                }
                                if (bitmapRegionDecoderNewInstance != null) {
                                    bitmapRegionDecoderNewInstance.recycle();
                                }
                            } catch (IOException unused2) {
                                bitmapRegionDecoderNewInstance = null;
                            } catch (Throwable th2) {
                                th = th2;
                                if (bitmapRegionDecoder != null) {
                                    bitmapRegionDecoder.recycle();
                                }
                                throw th;
                            }
                        }
                        if (bitmapDecodeStream == null) {
                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                        }
                        this.mDecodeBuffers.release(byteBufferAllocate);
                        if (bitmap == null && bitmap != bitmapDecodeStream) {
                            this.mBitmapPool.release(bitmap);
                            if (bitmapDecodeStream != null) {
                                bitmapDecodeStream.recycle();
                            }
                            throw new IllegalStateException();
                        }
                        if (this.mAvoidPoolRelease) {
                            return CloseableReference.m1347of(bitmapDecodeStream, NoOpResourceReleaser.INSTANCE);
                        }
                        return CloseableReference.m1347of(bitmapDecodeStream, this.mBitmapPool);
                    }
                    options.inTempStorage = byteBufferAllocate.array();
                    if (rect != null) {
                        bitmapDecodeStream = null;
                    } else {
                        bitmapDecodeStream = null;
                    }
                    if (bitmapDecodeStream == null) {
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    }
                    this.mDecodeBuffers.release(byteBufferAllocate);
                    if (bitmap == null) {
                    }
                    if (this.mAvoidPoolRelease) {
                        return CloseableReference.m1347of(bitmapDecodeStream, NoOpResourceReleaser.INSTANCE);
                    }
                    return CloseableReference.m1347of(bitmapDecodeStream, this.mBitmapPool);
                } catch (RuntimeException e) {
                    if (bitmap != null) {
                        this.mBitmapPool.release(bitmap);
                    }
                    throw e;
                }
            } catch (IllegalArgumentException e2) {
                if (bitmap != null) {
                    this.mBitmapPool.release(bitmap);
                }
                try {
                    inputStream.reset();
                    Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStream);
                    if (bitmapDecodeStream2 == null) {
                        throw e2;
                    }
                    CloseableReference closeableReferenceM1347of = CloseableReference.m1347of(bitmapDecodeStream2, SimpleBitmapReleaser.getInstance());
                    this.mDecodeBuffers.release(byteBufferAllocate);
                    return closeableReferenceM1347of;
                } catch (IOException unused3) {
                    throw e2;
                }
            }
        } catch (Throwable th3) {
            this.mDecodeBuffers.release(byteBufferAllocate);
            throw th3;
        }
        bitmap = null;
        options.inBitmap = bitmap;
        if (colorSpace == null) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        options.inPreferredColorSpace = colorSpace;
        byteBufferAllocate = (ByteBuffer) this.mDecodeBuffers.acquire();
        if (byteBufferAllocate == null) {
            byteBufferAllocate = ByteBuffer.allocate(DecodeBufferHelper.getRecommendedDecodeBufferSize());
        }
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        boolean z2 = config == Bitmap.Config.HARDWARE;
        if (!z2) {
            options.inPreferredConfig = config;
        }
        options.inMutable = true;
        if (!z) {
            BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
            if (options.outWidth == -1 || options.outHeight == -1) {
                throw new IllegalArgumentException();
            }
        }
        if (z2) {
            options.inPreferredConfig = config;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    private static final class NoOpResourceReleaser implements ResourceReleaser {
        private static final NoOpResourceReleaser INSTANCE = new NoOpResourceReleaser();

        @Override // com.facebook.common.references.ResourceReleaser
        public void release(Bitmap bitmap) {
        }

        private NoOpResourceReleaser() {
        }
    }
}
