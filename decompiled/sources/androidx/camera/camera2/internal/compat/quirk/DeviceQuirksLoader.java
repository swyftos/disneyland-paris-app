package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DeviceQuirksLoader {
    static List loadQuirks(QuirkSettings quirkSettings) {
        ArrayList arrayList = new ArrayList();
        if (quirkSettings.shouldEnableQuirk(ImageCapturePixelHDRPlusQuirk.class, ImageCapturePixelHDRPlusQuirk.load())) {
            arrayList.add(new ImageCapturePixelHDRPlusQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(ExtraCroppingQuirk.class, ExtraCroppingQuirk.load())) {
            arrayList.add(new ExtraCroppingQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(Nexus4AndroidLTargetAspectRatioQuirk.class, Nexus4AndroidLTargetAspectRatioQuirk.load())) {
            arrayList.add(new Nexus4AndroidLTargetAspectRatioQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(ExcludedSupportedSizesQuirk.class, ExcludedSupportedSizesQuirk.load())) {
            arrayList.add(new ExcludedSupportedSizesQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class, CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.load())) {
            arrayList.add(new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(PreviewPixelHDRnetQuirk.class, PreviewPixelHDRnetQuirk.load())) {
            arrayList.add(new PreviewPixelHDRnetQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(StillCaptureFlashStopRepeatingQuirk.class, StillCaptureFlashStopRepeatingQuirk.load())) {
            arrayList.add(new StillCaptureFlashStopRepeatingQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(ExtraSupportedSurfaceCombinationsQuirk.class, ExtraSupportedSurfaceCombinationsQuirk.load())) {
            arrayList.add(new ExtraSupportedSurfaceCombinationsQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(FlashAvailabilityBufferUnderflowQuirk.class, FlashAvailabilityBufferUnderflowQuirk.load())) {
            arrayList.add(new FlashAvailabilityBufferUnderflowQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(RepeatingStreamConstraintForVideoRecordingQuirk.class, RepeatingStreamConstraintForVideoRecordingQuirk.load())) {
            arrayList.add(new RepeatingStreamConstraintForVideoRecordingQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(TextureViewIsClosedQuirk.class, TextureViewIsClosedQuirk.load())) {
            arrayList.add(new TextureViewIsClosedQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(CaptureSessionOnClosedNotCalledQuirk.class, CaptureSessionOnClosedNotCalledQuirk.load())) {
            arrayList.add(new CaptureSessionOnClosedNotCalledQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(TorchIsClosedAfterImageCapturingQuirk.class, TorchIsClosedAfterImageCapturingQuirk.load())) {
            arrayList.add(new TorchIsClosedAfterImageCapturingQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(ZslDisablerQuirk.class, ZslDisablerQuirk.load())) {
            arrayList.add(new ZslDisablerQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(ExtraSupportedOutputSizeQuirk.class, ExtraSupportedOutputSizeQuirk.load())) {
            arrayList.add(new ExtraSupportedOutputSizeQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(InvalidVideoProfilesQuirk.class, InvalidVideoProfilesQuirk.load())) {
            arrayList.add(new InvalidVideoProfilesQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(Preview3AThreadCrashQuirk.class, Preview3AThreadCrashQuirk.load())) {
            arrayList.add(new Preview3AThreadCrashQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(SmallDisplaySizeQuirk.class, SmallDisplaySizeQuirk.load())) {
            arrayList.add(new SmallDisplaySizeQuirk());
        }
        if (quirkSettings.shouldEnableQuirk(PreviewUnderExposureQuirk.class, PreviewUnderExposureQuirk.load())) {
            arrayList.add(PreviewUnderExposureQuirk.INSTANCE);
        }
        return arrayList;
    }
}
