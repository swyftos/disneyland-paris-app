package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CorePalette {

    /* JADX INFO: renamed from: a1 */
    public TonalPalette f3489a1;

    /* JADX INFO: renamed from: a2 */
    public TonalPalette f3490a2;

    /* JADX INFO: renamed from: a3 */
    public TonalPalette f3491a3;
    public TonalPalette error;

    /* JADX INFO: renamed from: n1 */
    public TonalPalette f3492n1;

    /* JADX INFO: renamed from: n2 */
    public TonalPalette f3493n2;

    /* JADX INFO: renamed from: of */
    public static CorePalette m1475of(int i) {
        return new CorePalette(i, false);
    }

    public static CorePalette contentOf(int i) {
        return new CorePalette(i, true);
    }

    private CorePalette(int i, boolean z) {
        Hct hctFromInt = Hct.fromInt(i);
        double hue = hctFromInt.getHue();
        double chroma = hctFromInt.getChroma();
        if (z) {
            this.f3489a1 = TonalPalette.fromHueAndChroma(hue, chroma);
            this.f3490a2 = TonalPalette.fromHueAndChroma(hue, chroma / 3.0d);
            this.f3491a3 = TonalPalette.fromHueAndChroma(60.0d + hue, chroma / 2.0d);
            this.f3492n1 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 12.0d, 4.0d));
            this.f3493n2 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 6.0d, 8.0d));
        } else {
            this.f3489a1 = TonalPalette.fromHueAndChroma(hue, Math.max(48.0d, chroma));
            this.f3490a2 = TonalPalette.fromHueAndChroma(hue, 16.0d);
            this.f3491a3 = TonalPalette.fromHueAndChroma(60.0d + hue, 24.0d);
            this.f3492n1 = TonalPalette.fromHueAndChroma(hue, 4.0d);
            this.f3493n2 = TonalPalette.fromHueAndChroma(hue, 8.0d);
        }
        this.error = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }
}
