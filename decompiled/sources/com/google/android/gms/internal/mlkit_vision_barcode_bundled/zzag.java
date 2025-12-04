package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import ch.qos.logback.core.net.SyslogConstants;
import com.contentsquare.android.api.Currencies;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.math.Primes;

/* loaded from: classes3.dex */
final class zzag implements zzel {
    static final zzel zza = new zzag();

    private zzag() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel
    public final boolean zza(int i) {
        if (i == 129 || i == 161 || i == 209 || i == 2705 || i == 20753 || i == 20769 || i == 215 || i == 216 || i == 1297 || i == 1298) {
            return true;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                switch (i) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        return true;
                    default:
                        switch (i) {
                            case EACTags.ANSWER_TO_RESET /* 81 */:
                            case EACTags.HISTORICAL_BYTES /* 82 */:
                            case 83:
                            case Currencies.BZD /* 84 */:
                            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                                return true;
                            default:
                                switch (i) {
                                    case 163:
                                    case 164:
                                    case 165:
                                    case 166:
                                    case 167:
                                    case SyslogConstants.LOG_LOCAL5 /* 168 */:
                                    case 169:
                                        return true;
                                    default:
                                        switch (i) {
                                            case Primes.SMALL_FACTOR_LIMIT /* 211 */:
                                            case 212:
                                            case 213:
                                                return true;
                                            default:
                                                return false;
                                        }
                                }
                        }
                }
        }
    }
}
