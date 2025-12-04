package androidx.camera.video.internal.compat;

import android.media.AudioFormat;
import android.media.AudioRecord;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

@RequiresApi(23)
/* loaded from: classes.dex */
public final class Api23Impl {
    @NonNull
    public static AudioRecord.Builder createAudioRecordBuilder() {
        return new AudioRecord.Builder();
    }

    public static void setAudioSource(@NonNull AudioRecord.Builder builder, int i) throws IllegalArgumentException {
        builder.setAudioSource(i);
    }

    public static void setAudioFormat(@NonNull AudioRecord.Builder builder, @NonNull AudioFormat audioFormat) throws IllegalArgumentException {
        builder.setAudioFormat(audioFormat);
    }

    public static void setBufferSizeInBytes(@NonNull AudioRecord.Builder builder, int i) throws IllegalArgumentException {
        builder.setBufferSizeInBytes(i);
    }

    @NonNull
    @RequiresPermission("android.permission.RECORD_AUDIO")
    public static AudioRecord build(@NonNull AudioRecord.Builder builder) {
        return builder.build();
    }
}
