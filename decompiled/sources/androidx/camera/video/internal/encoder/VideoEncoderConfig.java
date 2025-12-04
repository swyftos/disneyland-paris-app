package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.AutoValue_VideoEncoderConfig;
import com.google.auto.value.AutoValue;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;

@AutoValue
/* loaded from: classes.dex */
public abstract class VideoEncoderConfig implements EncoderConfig {
    public abstract int getBitrate();

    public abstract int getColorFormat();

    @NonNull
    public abstract VideoEncoderDataSpace getDataSpace();

    public abstract int getFrameRate();

    public abstract int getIFrameInterval();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    @NonNull
    public abstract Size getResolution();

    VideoEncoderConfig() {
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_VideoEncoderConfig.Builder().setProfile(-1).setIFrameInterval(1).setColorFormat(2130708361).setDataSpace(VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED);
    }

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public MediaFormat toMediaFormat() {
        Size resolution = getResolution();
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(getMimeType(), resolution.getWidth(), resolution.getHeight());
        mediaFormatCreateVideoFormat.setInteger("color-format", getColorFormat());
        mediaFormatCreateVideoFormat.setInteger(TCVideoEventPropertiesNames.TCV_BITRATE, getBitrate());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", getFrameRate());
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", getIFrameInterval());
        if (getProfile() != -1) {
            mediaFormatCreateVideoFormat.setInteger("profile", getProfile());
        }
        VideoEncoderDataSpace dataSpace = getDataSpace();
        if (dataSpace.getStandard() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-standard", dataSpace.getStandard());
        }
        if (dataSpace.getTransfer() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-transfer", dataSpace.getTransfer());
        }
        if (dataSpace.getRange() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-range", dataSpace.getRange());
        }
        return mediaFormatCreateVideoFormat;
    }

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract VideoEncoderConfig build();

        @NonNull
        public abstract Builder setBitrate(int i);

        @NonNull
        public abstract Builder setColorFormat(int i);

        @NonNull
        public abstract Builder setDataSpace(@NonNull VideoEncoderDataSpace videoEncoderDataSpace);

        @NonNull
        public abstract Builder setFrameRate(int i);

        @NonNull
        public abstract Builder setIFrameInterval(int i);

        @NonNull
        public abstract Builder setInputTimebase(@NonNull Timebase timebase);

        @NonNull
        public abstract Builder setMimeType(@NonNull String str);

        @NonNull
        public abstract Builder setProfile(int i);

        @NonNull
        public abstract Builder setResolution(@NonNull Size size);

        Builder() {
        }
    }
}
