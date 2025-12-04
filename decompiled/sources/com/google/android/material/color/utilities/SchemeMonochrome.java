package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class SchemeMonochrome extends DynamicScheme {
    public SchemeMonochrome(Hct hct, boolean z, double d) {
        super(hct, Variant.MONOCHROME, z, d, TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE), TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE), TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE), TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE), TonalPalette.fromHueAndChroma(hct.getHue(), AudioStats.AUDIO_AMPLITUDE_NONE));
    }
}
