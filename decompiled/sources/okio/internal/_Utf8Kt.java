package okio.internal;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\n-Utf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n+ 2 Utf8.kt\nokio/Utf8\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,60:1\n260#2,16:61\n277#2:78\n397#2,9:79\n127#2:88\n406#2,20:90\n279#2,3:110\n440#2,4:113\n127#2:117\n446#2,10:118\n127#2:128\n456#2,5:129\n127#2:134\n461#2,24:135\n283#2,3:159\n500#2,3:162\n286#2,12:165\n503#2:177\n127#2:178\n506#2,2:179\n127#2:181\n510#2,10:182\n127#2:192\n520#2,5:193\n127#2:198\n525#2,5:199\n127#2:204\n530#2,28:205\n302#2,6:233\n138#2,67:239\n68#3:77\n74#3:89\n*S KotlinDebug\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n*L\n34#1:61,16\n34#1:78\n34#1:79,9\n34#1:88\n34#1:90,20\n34#1:110,3\n34#1:113,4\n34#1:117\n34#1:118,10\n34#1:128\n34#1:129,5\n34#1:134\n34#1:135,24\n34#1:159,3\n34#1:162,3\n34#1:165,12\n34#1:177\n34#1:178\n34#1:179,2\n34#1:181\n34#1:182,10\n34#1:192\n34#1:193,5\n34#1:198\n34#1:199,5\n34#1:204\n34#1:205,28\n34#1:233,6\n50#1:239,67\n34#1:77\n34#1:89\n*E\n"})
/* loaded from: classes6.dex */
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    @NotNull
    public static final String commonToUtf8String(@NotNull byte[] bArr, int i, int i2) {
        byte b;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        int i10 = 3;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i9 < 0 || i2 > bArr.length || i9 > i2) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i9 + " endIndex=" + i2);
        }
        char[] cArr = new char[i2 - i9];
        int i11 = 0;
        while (i9 < i2) {
            byte b2 = bArr[i9];
            if (b2 >= 0) {
                int i12 = i11 + 1;
                cArr[i11] = (char) b2;
                i9++;
                while (true) {
                    i11 = i12;
                    if (i9 >= i2 || (b = bArr[i9]) < 0) {
                        break;
                    }
                    i9++;
                    i12 = i11 + 1;
                    cArr[i11] = (char) b;
                }
            } else if ((b2 >> 5) == -2) {
                int i13 = i9 + 1;
                if (i2 <= i13) {
                    i3 = i11 + 1;
                    cArr[i11] = (char) Utf8.REPLACEMENT_CODE_POINT;
                } else {
                    byte b3 = bArr[i13];
                    if ((b3 & 192) == 128) {
                        int i14 = (b2 << 6) ^ (b3 ^ 3968);
                        if (i14 < 128) {
                            i3 = i11 + 1;
                            cArr[i11] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        } else {
                            i3 = i11 + 1;
                            cArr[i11] = (char) i14;
                        }
                        Unit unit = Unit.INSTANCE;
                        i4 = 2;
                        i11 = i3;
                        i9 += i4;
                    } else {
                        i3 = i11 + 1;
                        cArr[i11] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                i4 = 1;
                i11 = i3;
                i9 += i4;
            } else if ((b2 >> 4) == -2) {
                int i15 = i9 + 2;
                if (i2 <= i15) {
                    int i16 = i11 + 1;
                    cArr[i11] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    Unit unit3 = Unit.INSTANCE;
                    int i17 = i9 + 1;
                    i6 = (i2 <= i17 || (bArr[i17] & 192) != 128) ? 1 : 2;
                    i11 = i16;
                } else {
                    byte b4 = bArr[i9 + 1];
                    if ((b4 & 192) == 128) {
                        byte b5 = bArr[i15];
                        if ((b5 & 192) == 128) {
                            int i18 = ((b5 ^ (-123008)) ^ (b4 << 6)) ^ (b2 << Ascii.FF);
                            if (i18 < 2048) {
                                i5 = i11 + 1;
                                cArr[i11] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else if (55296 > i18 || i18 >= 57344) {
                                char c = (char) i18;
                                i5 = i11 + 1;
                                cArr[i11] = c;
                            } else {
                                i5 = i11 + 1;
                                cArr[i11] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            }
                            Unit unit4 = Unit.INSTANCE;
                            i6 = i10;
                        } else {
                            i5 = i11 + 1;
                            cArr[i11] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            Unit unit5 = Unit.INSTANCE;
                            i6 = 2;
                        }
                    } else {
                        i5 = i11 + 1;
                        cArr[i11] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        Unit unit6 = Unit.INSTANCE;
                        i6 = 1;
                    }
                    i11 = i5;
                }
                i9 += i6;
            } else {
                if ((b2 >> 3) == -2) {
                    int i19 = i9 + 3;
                    if (i2 <= i19) {
                        i7 = i11 + 1;
                        cArr[i11] = Utf8.REPLACEMENT_CHARACTER;
                        Unit unit7 = Unit.INSTANCE;
                        int i20 = i9 + 1;
                        if (i2 <= i20 || (bArr[i20] & 192) != 128) {
                            i11 = i7;
                            i10 = 1;
                        } else {
                            int i21 = i9 + 2;
                            if (i2 <= i21 || (bArr[i21] & 192) != 128) {
                                i11 = i7;
                                i10 = 2;
                            } else {
                                i11 = i7;
                            }
                        }
                        i9 += i10;
                    } else {
                        byte b6 = bArr[i9 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i9 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i19];
                                if ((b8 & 192) == 128) {
                                    int i22 = (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.FF)) ^ (b2 << Ascii.DC2);
                                    if (i22 > 1114111) {
                                        i8 = i11 + 1;
                                        cArr[i11] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if ((55296 > i22 || i22 >= 57344) && i22 >= 65536 && i22 != 65533) {
                                        cArr[i11] = (char) ((i22 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                        cArr[i11 + 1] = (char) ((i22 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) + 56320);
                                        i8 = i11 + 2;
                                    } else {
                                        i8 = i11 + 1;
                                        cArr[i11] = Utf8.REPLACEMENT_CHARACTER;
                                    }
                                    Unit unit8 = Unit.INSTANCE;
                                    i11 = i8;
                                    i10 = 4;
                                } else {
                                    cArr[i11] = Utf8.REPLACEMENT_CHARACTER;
                                    Unit unit9 = Unit.INSTANCE;
                                    i11++;
                                    i10 = 3;
                                }
                                i9 += i10;
                            } else {
                                i7 = i11 + 1;
                                cArr[i11] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit10 = Unit.INSTANCE;
                                i11 = i7;
                                i10 = 2;
                                i9 += i10;
                            }
                        } else {
                            i7 = i11 + 1;
                            cArr[i11] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit11 = Unit.INSTANCE;
                            i11 = i7;
                            i10 = 1;
                            i9 += i10;
                        }
                    }
                } else {
                    cArr[i11] = Utf8.REPLACEMENT_CHARACTER;
                    i9++;
                    i11++;
                }
                i10 = 3;
            }
        }
        return StringsKt.concatToString(cArr, 0, i11);
    }

    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String str) {
        int i;
        char cCharAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = str.charAt(i2);
            if (Intrinsics.compare((int) cCharAt2, 128) >= 0) {
                int length2 = str.length();
                int i3 = i2;
                while (i2 < length2) {
                    char cCharAt3 = str.charAt(i2);
                    if (Intrinsics.compare((int) cCharAt3, 128) < 0) {
                        int i4 = i3 + 1;
                        bArr[i3] = (byte) cCharAt3;
                        i2++;
                        while (true) {
                            i3 = i4;
                            if (i2 >= length2 || Intrinsics.compare((int) str.charAt(i2), 128) >= 0) {
                                break;
                            }
                            i4 = i3 + 1;
                            bArr[i3] = (byte) str.charAt(i2);
                            i2++;
                        }
                    } else {
                        if (Intrinsics.compare((int) cCharAt3, 2048) < 0) {
                            bArr[i3] = (byte) ((cCharAt3 >> 6) | 192);
                            i3 += 2;
                            bArr[i3 + 1] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (55296 > cCharAt3 || cCharAt3 >= 57344) {
                            bArr[i3] = (byte) ((cCharAt3 >> '\f') | 224);
                            bArr[i3 + 1] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            i3 += 3;
                            bArr[i3 + 2] = (byte) ((cCharAt3 & '?') | 128);
                        } else if (Intrinsics.compare((int) cCharAt3, 56319) > 0 || length2 <= (i = i2 + 1) || 56320 > (cCharAt = str.charAt(i)) || cCharAt >= 57344) {
                            bArr[i3] = Utf8.REPLACEMENT_BYTE;
                            i2++;
                            i3++;
                        } else {
                            int iCharAt = ((cCharAt3 << '\n') + str.charAt(i)) - 56613888;
                            bArr[i3] = (byte) ((iCharAt >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            bArr[i3 + 1] = (byte) (((iCharAt >> 12) & 63) | 128);
                            bArr[i3 + 2] = (byte) (((iCharAt >> 6) & 63) | 128);
                            i3 += 4;
                            bArr[i3 + 3] = (byte) ((iCharAt & 63) | 128);
                            i2 += 2;
                        }
                        i2++;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i2] = (byte) cCharAt2;
            i2++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(this, newSize)");
        return bArrCopyOf2;
    }
}
