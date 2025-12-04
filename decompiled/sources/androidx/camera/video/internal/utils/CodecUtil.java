package androidx.camera.video.internal.utils;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import java.io.IOException;

/* loaded from: classes.dex */
public final class CodecUtil {
    private static final LruCache sCodecInfoCache = new LruCache(10);

    @NonNull
    public static MediaCodec createCodec(@NonNull EncoderConfig encoderConfig) throws InvalidConfigException {
        return createCodec(encoderConfig.getMimeType());
    }

    @NonNull
    public static MediaCodecInfo findCodecAndGetCodecInfo(@NonNull EncoderConfig encoderConfig) throws Throwable {
        MediaCodecInfo mediaCodecInfo;
        MediaCodec mediaCodecCreateCodec;
        String mimeType = encoderConfig.getMimeType();
        LruCache lruCache = sCodecInfoCache;
        synchronized (lruCache) {
            mediaCodecInfo = (MediaCodecInfo) lruCache.get(mimeType);
        }
        if (mediaCodecInfo != null) {
            return mediaCodecInfo;
        }
        try {
            mediaCodecCreateCodec = createCodec(mimeType);
        } catch (Throwable th) {
            th = th;
            mediaCodecCreateCodec = null;
        }
        try {
            MediaCodecInfo codecInfo = mediaCodecCreateCodec.getCodecInfo();
            synchronized (lruCache) {
                lruCache.put(mimeType, codecInfo);
            }
            mediaCodecCreateCodec.release();
            return codecInfo;
        } catch (Throwable th2) {
            th = th2;
            if (mediaCodecCreateCodec != null) {
                mediaCodecCreateCodec.release();
            }
            throw th;
        }
    }

    private static MediaCodec createCodec(String str) throws InvalidConfigException {
        try {
            return MediaCodec.createEncoderByType(str);
        } catch (IOException | IllegalArgumentException e) {
            throw new InvalidConfigException(e);
        }
    }
}
