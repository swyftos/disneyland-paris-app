package io.cucumber.datatable.dependency.com.fasterxml.jackson.core.p103io;

import androidx.media3.extractor.p007ts.PsExtractor;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.util.BufferRecycler;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.util.BufferRecyclers;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.util.TextBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class JsonStringEncoder {
    protected ByteArrayBuilder _bytes;
    protected final char[] _qbuf = {'\\', 0, '0', '0', 0, 0};
    protected TextBuffer _text;

    /* JADX INFO: renamed from: HC */
    private static final char[] f3806HC = CharTypes.copyHexChars();

    /* JADX INFO: renamed from: HB */
    private static final byte[] f3805HB = CharTypes.copyHexBytes();

    @Deprecated
    public static JsonStringEncoder getInstance() {
        return BufferRecyclers.getJsonStringEncoder();
    }

    public char[] quoteAsString(String str) {
        int i_appendNamed;
        TextBuffer textBuffer = this._text;
        if (textBuffer == null) {
            textBuffer = new TextBuffer(null);
            this._text = textBuffer;
        }
        char[] cArrEmptyAndGetCurrentSegment = textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = CharTypes.get7BitOutputEscapes();
        int length = iArr.length;
        int length2 = str.length();
        int i = 0;
        int i2 = 0;
        loop0: while (i < length2) {
            while (true) {
                char cCharAt = str.charAt(i);
                if (cCharAt >= length || iArr[cCharAt] == 0) {
                    if (i2 >= cArrEmptyAndGetCurrentSegment.length) {
                        cArrEmptyAndGetCurrentSegment = textBuffer.finishCurrentSegment();
                        i2 = 0;
                    }
                    int i3 = i2 + 1;
                    cArrEmptyAndGetCurrentSegment[i2] = cCharAt;
                    i++;
                    if (i >= length2) {
                        i2 = i3;
                        break loop0;
                    }
                    i2 = i3;
                }
            }
            int i4 = i + 1;
            char cCharAt2 = str.charAt(i);
            int i5 = iArr[cCharAt2];
            if (i5 < 0) {
                i_appendNamed = _appendNumeric(cCharAt2, this._qbuf);
            } else {
                i_appendNamed = _appendNamed(i5, this._qbuf);
            }
            int i6 = i2 + i_appendNamed;
            if (i6 > cArrEmptyAndGetCurrentSegment.length) {
                int length3 = cArrEmptyAndGetCurrentSegment.length - i2;
                if (length3 > 0) {
                    System.arraycopy(this._qbuf, 0, cArrEmptyAndGetCurrentSegment, i2, length3);
                }
                cArrEmptyAndGetCurrentSegment = textBuffer.finishCurrentSegment();
                int i7 = i_appendNamed - length3;
                System.arraycopy(this._qbuf, length3, cArrEmptyAndGetCurrentSegment, 0, i7);
                i2 = i7;
            } else {
                System.arraycopy(this._qbuf, 0, cArrEmptyAndGetCurrentSegment, i2, i_appendNamed);
                i2 = i6;
            }
            i = i4;
        }
        textBuffer.setCurrentLength(i2);
        return textBuffer.contentsAsArray();
    }

    public void quoteAsString(CharSequence charSequence, StringBuilder sb) {
        int i_appendNamed;
        int[] iArr = CharTypes.get7BitOutputEscapes();
        int length = iArr.length;
        int length2 = charSequence.length();
        int i = 0;
        while (i < length2) {
            do {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= length || iArr[cCharAt] == 0) {
                    sb.append(cCharAt);
                    i++;
                } else {
                    int i2 = i + 1;
                    char cCharAt2 = charSequence.charAt(i);
                    int i3 = iArr[cCharAt2];
                    if (i3 < 0) {
                        i_appendNamed = _appendNumeric(cCharAt2, this._qbuf);
                    } else {
                        i_appendNamed = _appendNamed(i3, this._qbuf);
                    }
                    sb.append(this._qbuf, 0, i_appendNamed);
                    i = i2;
                }
            } while (i < length2);
            return;
        }
    }

    public byte[] quoteAsUTF8(String str) {
        int i;
        int i2;
        int i3;
        ByteArrayBuilder byteArrayBuilder = this._bytes;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._bytes = byteArrayBuilder;
        }
        int length = str.length();
        byte[] bArrResetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int i4 = 0;
        int i_appendByte = 0;
        loop0: while (i4 < length) {
            int[] iArr = CharTypes.get7BitOutputEscapes();
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt > 127 || iArr[cCharAt] != 0) {
                    break;
                }
                if (i_appendByte >= bArrResetAndGetFirstSegment.length) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    i_appendByte = 0;
                }
                int i5 = i_appendByte + 1;
                bArrResetAndGetFirstSegment[i_appendByte] = (byte) cCharAt;
                i4++;
                if (i4 >= length) {
                    i_appendByte = i5;
                    break loop0;
                }
                i_appendByte = i5;
            }
            if (i_appendByte >= bArrResetAndGetFirstSegment.length) {
                bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                i_appendByte = 0;
            }
            int i6 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 <= 127) {
                i_appendByte = _appendByte(cCharAt2, iArr[cCharAt2], byteArrayBuilder, i_appendByte);
                bArrResetAndGetFirstSegment = byteArrayBuilder.getCurrentSegment();
            } else {
                if (cCharAt2 <= 2047) {
                    i3 = i_appendByte + 1;
                    bArrResetAndGetFirstSegment[i_appendByte] = (byte) ((cCharAt2 >> 6) | 192);
                    i2 = (cCharAt2 & '?') | 128;
                } else {
                    if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                        int i7 = i_appendByte + 1;
                        bArrResetAndGetFirstSegment[i_appendByte] = (byte) ((cCharAt2 >> '\f') | 224);
                        if (i7 >= bArrResetAndGetFirstSegment.length) {
                            bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                            i7 = 0;
                        }
                        bArrResetAndGetFirstSegment[i7] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                        i = i7 + 1;
                        i2 = (cCharAt2 & '?') | 128;
                    } else {
                        if (cCharAt2 > 56319) {
                            _illegal(cCharAt2);
                        }
                        if (i6 >= length) {
                            _illegal(cCharAt2);
                        }
                        int i8 = i4 + 2;
                        int i_convert = _convert(cCharAt2, str.charAt(i6));
                        if (i_convert > 1114111) {
                            _illegal(i_convert);
                        }
                        int i9 = i_appendByte + 1;
                        bArrResetAndGetFirstSegment[i_appendByte] = (byte) ((i_convert >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        if (i9 >= bArrResetAndGetFirstSegment.length) {
                            bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                            i9 = 0;
                        }
                        int i10 = i9 + 1;
                        bArrResetAndGetFirstSegment[i9] = (byte) (((i_convert >> 12) & 63) | 128);
                        if (i10 >= bArrResetAndGetFirstSegment.length) {
                            bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                            i10 = 0;
                        }
                        int i11 = i10 + 1;
                        bArrResetAndGetFirstSegment[i10] = (byte) (((i_convert >> 6) & 63) | 128);
                        i2 = (i_convert & 63) | 128;
                        i = i11;
                        i6 = i8;
                    }
                    i3 = i;
                }
                if (i3 >= bArrResetAndGetFirstSegment.length) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    i3 = 0;
                }
                bArrResetAndGetFirstSegment[i3] = (byte) i2;
                i_appendByte = i3 + 1;
            }
            i4 = i6;
        }
        return this._bytes.completeAndCoalesce(i_appendByte);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00dc A[SYNTHETIC] */
    public byte[] encodeAsUTF8(String str) {
        int i;
        int i2;
        ByteArrayBuilder byteArrayBuilder = this._bytes;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._bytes = byteArrayBuilder;
        }
        int length = str.length();
        byte[] bArrResetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int length2 = bArrResetAndGetFirstSegment.length;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i3 < length) {
            int i5 = i3 + 1;
            char cCharAt = str.charAt(i3);
            while (cCharAt <= 127) {
                if (i4 >= length2) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArrResetAndGetFirstSegment.length;
                    i4 = 0;
                }
                int i6 = i4 + 1;
                bArrResetAndGetFirstSegment[i4] = (byte) cCharAt;
                if (i5 >= length) {
                    i4 = i6;
                    break loop0;
                }
                char cCharAt2 = str.charAt(i5);
                i5++;
                cCharAt = cCharAt2;
                i4 = i6;
            }
            if (i4 >= length2) {
                bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                length2 = bArrResetAndGetFirstSegment.length;
                i4 = 0;
            }
            if (cCharAt < 2048) {
                i = i4 + 1;
                bArrResetAndGetFirstSegment[i4] = (byte) ((cCharAt >> 6) | 192);
            } else {
                if (cCharAt < 55296 || cCharAt > 57343) {
                    int i7 = i4 + 1;
                    bArrResetAndGetFirstSegment[i4] = (byte) ((cCharAt >> '\f') | 224);
                    if (i7 >= length2) {
                        bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        length2 = bArrResetAndGetFirstSegment.length;
                        i7 = 0;
                    }
                    bArrResetAndGetFirstSegment[i7] = (byte) (((cCharAt >> 6) & 63) | 128);
                    i = i7 + 1;
                } else {
                    if (cCharAt > 56319) {
                        _illegal(cCharAt);
                    }
                    if (i5 >= length) {
                        _illegal(cCharAt);
                    }
                    int i8 = i5 + 1;
                    int i_convert = _convert(cCharAt, str.charAt(i5));
                    if (i_convert > 1114111) {
                        _illegal(i_convert);
                    }
                    int i9 = i4 + 1;
                    bArrResetAndGetFirstSegment[i4] = (byte) ((i_convert >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                    if (i9 >= length2) {
                        bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        length2 = bArrResetAndGetFirstSegment.length;
                        i9 = 0;
                    }
                    int i10 = i9 + 1;
                    bArrResetAndGetFirstSegment[i9] = (byte) (((i_convert >> 12) & 63) | 128);
                    if (i10 >= length2) {
                        bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        length2 = bArrResetAndGetFirstSegment.length;
                        i10 = 0;
                    }
                    int i11 = i10 + 1;
                    bArrResetAndGetFirstSegment[i10] = (byte) (((i_convert >> 6) & 63) | 128);
                    i2 = i_convert;
                    i3 = i8;
                    i = i11;
                }
                if (i >= length2) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArrResetAndGetFirstSegment.length;
                    i = 0;
                }
                bArrResetAndGetFirstSegment[i] = (byte) ((i2 & 63) | 128);
                i4 = i + 1;
            }
            i2 = cCharAt;
            i3 = i5;
            if (i >= length2) {
                bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                length2 = bArrResetAndGetFirstSegment.length;
                i = 0;
            }
            bArrResetAndGetFirstSegment[i] = (byte) ((i2 & 63) | 128);
            i4 = i + 1;
        }
        return this._bytes.completeAndCoalesce(i4);
    }

    private int _appendNumeric(int i, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = f3806HC;
        cArr[4] = cArr2[i >> 4];
        cArr[5] = cArr2[i & 15];
        return 6;
    }

    private int _appendNamed(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int _appendByte(int i, int i2, ByteArrayBuilder byteArrayBuilder, int i3) {
        byteArrayBuilder.setCurrentSegmentLength(i3);
        byteArrayBuilder.append(92);
        if (i2 < 0) {
            byteArrayBuilder.append(117);
            if (i > 255) {
                byte[] bArr = f3805HB;
                byteArrayBuilder.append(bArr[i >> 12]);
                byteArrayBuilder.append(bArr[(i >> 8) & 15]);
                i &= 255;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byte[] bArr2 = f3805HB;
            byteArrayBuilder.append(bArr2[i >> 4]);
            byteArrayBuilder.append(bArr2[i & 15]);
        } else {
            byteArrayBuilder.append((byte) i2);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private static int _convert(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - 55296) << 10) + 65536 + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void _illegal(int i) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(i));
    }
}
