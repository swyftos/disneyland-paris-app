package com.google.android.libraries.barhopper;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer;
import com.google.barhopper.deeplearning.BarhopperV3Options;
import com.google.photos.vision.barhopper.BarhopperProto$BarhopperResponse;
import java.io.Closeable;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class BarhopperV3 implements Closeable {
    private static final String TAG = "BarhopperV3";
    private long nativePointer;

    public BarhopperV3() {
        System.loadLibrary("barhopper_v3");
    }

    private native void closeNative(long j);

    private native long createNative();

    private native long createNativeWithClientOptions(byte[] bArr);

    private native byte[] recognizeBitmapNative(long j, Bitmap bitmap, RecognitionOptions recognitionOptions);

    private native byte[] recognizeBufferNative(long j, int i, int i2, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native byte[] recognizeNative(long j, int i, int i2, byte[] bArr, RecognitionOptions recognitionOptions);

    private native byte[] recognizeStridedBufferNative(long j, int i, int i2, int i3, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native byte[] recognizeStridedNative(long j, int i, int i2, int i3, byte[] bArr, RecognitionOptions recognitionOptions);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.nativePointer;
        if (j != 0) {
            closeNative(j);
            this.nativePointer = 0L;
        }
    }

    public void create() {
        if (this.nativePointer != 0) {
            Log.w(TAG, "Native pointer already exists.");
            return;
        }
        long jCreateNative = createNative();
        this.nativePointer = jCreateNative;
        if (jCreateNative == 0) {
            throw new IllegalStateException("Failed to create native pointer.");
        }
    }

    @NonNull
    public BarhopperProto$BarhopperResponse recognize(int i, int i2, int i3, @NonNull ByteBuffer byteBuffer, @NonNull RecognitionOptions recognitionOptions) {
        long j = this.nativePointer;
        if (j != 0) {
            return toProto(recognizeStridedBufferNative(j, i, i2, i3, byteBuffer, recognitionOptions));
        }
        throw new IllegalStateException("Native pointer does not exist.");
    }

    private static BarhopperProto$BarhopperResponse toProto(byte[] bArr) {
        bArr.getClass();
        try {
            return BarhopperProto$BarhopperResponse.zzb(bArr, zzds.zza());
        } catch (zzer e) {
            throw new IllegalStateException("Received unexpected BarhopperResponse buffer: {0}", e);
        }
    }

    public void create(@NonNull BarhopperV3Options barhopperV3Options) {
        if (this.nativePointer != 0) {
            Log.w(TAG, "Native pointer already exists.");
            return;
        }
        long jCreateNativeWithClientOptions = createNativeWithClientOptions(barhopperV3Options.zzD());
        this.nativePointer = jCreateNativeWithClientOptions;
        if (jCreateNativeWithClientOptions == 0) {
            throw new IllegalArgumentException("Failed to create native pointer with client options.");
        }
    }

    @NonNull
    public BarhopperProto$BarhopperResponse recognize(int i, int i2, int i3, @NonNull byte[] bArr, @NonNull RecognitionOptions recognitionOptions) {
        long j = this.nativePointer;
        if (j == 0) {
            throw new IllegalStateException("Native pointer does not exist.");
        }
        return toProto(recognizeStridedNative(j, i, i2, i3, bArr, recognitionOptions));
    }

    @NonNull
    public BarhopperProto$BarhopperResponse recognize(int i, int i2, @NonNull ByteBuffer byteBuffer, @NonNull RecognitionOptions recognitionOptions) {
        long j = this.nativePointer;
        if (j == 0) {
            throw new IllegalStateException("Native pointer does not exist.");
        }
        return toProto(recognizeBufferNative(j, i, i2, byteBuffer, recognitionOptions));
    }

    @NonNull
    public BarhopperProto$BarhopperResponse recognize(int i, int i2, @NonNull byte[] bArr, @NonNull RecognitionOptions recognitionOptions) {
        long j = this.nativePointer;
        if (j == 0) {
            throw new IllegalStateException("Native pointer does not exist.");
        }
        return toProto(recognizeNative(j, i, i2, bArr, recognitionOptions));
    }

    @NonNull
    public BarhopperProto$BarhopperResponse recognize(@NonNull Bitmap bitmap, @NonNull RecognitionOptions recognitionOptions) {
        if (this.nativePointer == 0) {
            throw new IllegalStateException("Native pointer does not exist.");
        }
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2) {
            Log.d(TAG, "Input bitmap config is not ARGB_8888. Converting it to ARGB_8888 from ".concat(String.valueOf(bitmap.getConfig())));
            bitmap = bitmap.copy(config2, bitmap.isMutable());
        }
        return toProto(recognizeBitmapNative(this.nativePointer, bitmap, recognitionOptions));
    }
}
