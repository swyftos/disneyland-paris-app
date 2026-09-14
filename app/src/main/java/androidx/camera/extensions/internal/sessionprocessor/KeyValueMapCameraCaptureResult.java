package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import java.nio.BufferUnderflowException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class KeyValueMapCameraCaptureResult implements CameraCaptureResult {
    private final Map mKeyValues;
    private TagBundle mTagBundle;
    private final long mTimestamp;

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CaptureResult getCaptureResult() {
        return null;
    }

    KeyValueMapCameraCaptureResult(long j, TagBundle tagBundle, Map map) {
        this.mKeyValues = map;
        this.mTagBundle = tagBundle;
        this.mTimestamp = j;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfMode getAfMode() {
        Integer num = (Integer) this.mKeyValues.get(CaptureResult.CONTROL_AF_MODE);
        if (num == null) {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue != 0) {
            if (iIntValue == 1 || iIntValue == 2) {
                return CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO;
            }
            if (iIntValue == 3 || iIntValue == 4) {
                return CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO;
            }
            if (iIntValue != 5) {
                Logger.m30e("KeyValueMapCameraCaptureResult", "Undefined af mode: " + num);
                return CameraCaptureMetaData.AfMode.UNKNOWN;
            }
        }
        return CameraCaptureMetaData.AfMode.OFF;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfState getAfState() {
        Integer num = (Integer) this.mKeyValues.get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData.AfState.INACTIVE;
            case 1:
            case 3:
                return CameraCaptureMetaData.AfState.SCANNING;
            case 2:
                return CameraCaptureMetaData.AfState.PASSIVE_FOCUSED;
            case 4:
                return CameraCaptureMetaData.AfState.LOCKED_FOCUSED;
            case 5:
                return CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED;
            case 6:
                return CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED;
            default:
                Logger.m30e("KeyValueMapCameraCaptureResult", "Undefined af state: " + num);
                return CameraCaptureMetaData.AfState.UNKNOWN;
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeState getAeState() {
        Integer num = (Integer) this.mKeyValues.get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData.AeState.INACTIVE;
        }
        if (iIntValue != 1) {
            if (iIntValue == 2) {
                return CameraCaptureMetaData.AeState.CONVERGED;
            }
            if (iIntValue == 3) {
                return CameraCaptureMetaData.AeState.LOCKED;
            }
            if (iIntValue == 4) {
                return CameraCaptureMetaData.AeState.FLASH_REQUIRED;
            }
            if (iIntValue != 5) {
                Logger.m30e("KeyValueMapCameraCaptureResult", "Undefined ae state: " + num);
                return CameraCaptureMetaData.AeState.UNKNOWN;
            }
        }
        return CameraCaptureMetaData.AeState.SEARCHING;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbState getAwbState() {
        Integer num = (Integer) this.mKeyValues.get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData.AwbState.INACTIVE;
        }
        if (iIntValue == 1) {
            return CameraCaptureMetaData.AwbState.METERING;
        }
        if (iIntValue == 2) {
            return CameraCaptureMetaData.AwbState.CONVERGED;
        }
        if (iIntValue == 3) {
            return CameraCaptureMetaData.AwbState.LOCKED;
        }
        Logger.m30e("KeyValueMapCameraCaptureResult", "Undefined awb state: " + num);
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.FlashState getFlashState() {
        Integer num = (Integer) this.mKeyValues.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0 || iIntValue == 1) {
            return CameraCaptureMetaData.FlashState.NONE;
        }
        if (iIntValue == 2) {
            return CameraCaptureMetaData.FlashState.READY;
        }
        if (iIntValue == 3 || iIntValue == 4) {
            return CameraCaptureMetaData.FlashState.FIRED;
        }
        Logger.m30e("KeyValueMapCameraCaptureResult", "Undefined flash state: " + num);
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeMode getAeMode() {
        Integer num = (Integer) this.mKeyValues.get(CaptureResult.CONTROL_AE_MODE);
        if (num == null) {
            return CameraCaptureMetaData.AeMode.UNKNOWN;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return CameraCaptureMetaData.AeMode.OFF;
        }
        if (iIntValue == 1) {
            return CameraCaptureMetaData.AeMode.ON;
        }
        if (iIntValue == 2) {
            return CameraCaptureMetaData.AeMode.ON_AUTO_FLASH;
        }
        if (iIntValue == 3) {
            return CameraCaptureMetaData.AeMode.ON_ALWAYS_FLASH;
        }
        if (iIntValue == 4) {
            return CameraCaptureMetaData.AeMode.ON_AUTO_FLASH_REDEYE;
        }
        if (iIntValue == 5) {
            return CameraCaptureMetaData.AeMode.ON_EXTERNAL_FLASH;
        }
        return CameraCaptureMetaData.AeMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbMode getAwbMode() {
        Integer num = (Integer) this.mKeyValues.get(CaptureResult.CONTROL_AWB_MODE);
        if (num == null) {
            return CameraCaptureMetaData.AwbMode.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData.AwbMode.OFF;
            case 1:
                return CameraCaptureMetaData.AwbMode.AUTO;
            case 2:
                return CameraCaptureMetaData.AwbMode.INCANDESCENT;
            case 3:
                return CameraCaptureMetaData.AwbMode.FLUORESCENT;
            case 4:
                return CameraCaptureMetaData.AwbMode.WARM_FLUORESCENT;
            case 5:
                return CameraCaptureMetaData.AwbMode.DAYLIGHT;
            case 6:
                return CameraCaptureMetaData.AwbMode.CLOUDY_DAYLIGHT;
            case 7:
                return CameraCaptureMetaData.AwbMode.TWILIGHT;
            case 8:
                return CameraCaptureMetaData.AwbMode.SHADE;
            default:
                return CameraCaptureMetaData.AwbMode.UNKNOWN;
        }
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        return this.mTimestamp;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public void populateExifData(ExifData.Builder builder) {
        super.populateExifData(builder);
        try {
            Integer num = (Integer) this.mKeyValues.get(CaptureResult.JPEG_ORIENTATION);
            if (num != null) {
                builder.setOrientationDegrees(num.intValue());
            }
        } catch (BufferUnderflowException unused) {
            Logger.m34w("KeyValueMapCameraCaptureResult", "Failed to get JPEG orientation.");
        }
        Long l = (Long) this.mKeyValues.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l != null) {
            builder.setExposureTimeNanos(l.longValue());
        }
        Float f = (Float) this.mKeyValues.get(CaptureResult.LENS_APERTURE);
        if (f != null) {
            builder.setLensFNumber(f.floatValue());
        }
        Integer numValueOf = (Integer) this.mKeyValues.get(CaptureResult.SENSOR_SENSITIVITY);
        if (numValueOf != null) {
            Integer num2 = (Integer) this.mKeyValues.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
            if (num2 != null) {
                numValueOf = Integer.valueOf(numValueOf.intValue() * ((int) (num2.intValue() / 100.0f)));
            }
            builder.setIso(numValueOf.intValue());
        }
        Float f2 = (Float) this.mKeyValues.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f2 != null) {
            builder.setFocalLength(f2.floatValue());
        }
        Integer num3 = (Integer) this.mKeyValues.get(CaptureResult.CONTROL_AWB_MODE);
        if (num3 != null) {
            ExifData.WhiteBalanceMode whiteBalanceMode = ExifData.WhiteBalanceMode.AUTO;
            if (num3.intValue() == 0) {
                whiteBalanceMode = ExifData.WhiteBalanceMode.MANUAL;
            }
            builder.setWhiteBalanceMode(whiteBalanceMode);
        }
    }
}
