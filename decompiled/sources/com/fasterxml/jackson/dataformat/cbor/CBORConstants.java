package com.fasterxml.jackson.dataformat.cbor;

import androidx.media3.extractor.ts.PsExtractor;

/* loaded from: classes3.dex */
public final class CBORConstants {
    public static final byte BYTE_ARRAY_2_ELEMENTS = -126;
    public static final byte BYTE_ARRAY_INDEFINITE = -97;
    public static final byte BYTE_BREAK = -1;
    public static final byte BYTE_EMPTY_STRING = 96;
    public static final byte BYTE_FALSE = -12;
    public static final byte BYTE_FLOAT16 = -7;
    public static final byte BYTE_FLOAT32 = -6;
    public static final byte BYTE_FLOAT64 = -5;
    public static final byte BYTE_NULL = -10;
    public static final byte BYTE_OBJECT_INDEFINITE = -65;
    public static final byte BYTE_STRING_1BYTE_LEN = 120;
    public static final byte BYTE_STRING_2BYTE_LEN = 121;
    public static final byte BYTE_STRING_INDEFINITE = 127;
    public static final byte BYTE_TAG_BIGFLOAT = -59;
    public static final byte BYTE_TAG_BIGNUM_NEG = -61;
    public static final byte BYTE_TAG_BIGNUM_POS = -62;
    public static final byte BYTE_TAG_DECIMAL_FRACTION = -60;
    public static final byte BYTE_TRUE = -11;
    public static final int INT_BREAK = 255;
    public static final int MAJOR_TYPE_ARRAY = 4;
    public static final int MAJOR_TYPE_BYTES = 2;
    public static final int MAJOR_TYPE_INT_NEG = 1;
    public static final int MAJOR_TYPE_INT_POS = 0;
    public static final int MAJOR_TYPE_MISC = 7;
    public static final int MAJOR_TYPE_OBJECT = 5;
    public static final int MAJOR_TYPE_TAG = 6;
    public static final int MAJOR_TYPE_TEXT = 3;
    public static final int MASK_MAJOR_TYPE = 224;
    public static final int PREFIX_TYPE_ARRAY = 128;
    public static final int PREFIX_TYPE_BYTES = 64;
    public static final int PREFIX_TYPE_INT_NEG = 32;
    public static final int PREFIX_TYPE_INT_POS = 0;
    public static final int PREFIX_TYPE_MISC = 224;
    public static final int PREFIX_TYPE_OBJECT = 160;
    public static final int PREFIX_TYPE_TAG = 192;
    public static final int PREFIX_TYPE_TEXT = 96;
    public static final int SUFFIX_INDEFINITE = 31;
    public static final int SUFFIX_UINT16_ELEMENTS = 25;
    public static final int SUFFIX_UINT32_ELEMENTS = 26;
    public static final int SUFFIX_UINT64_ELEMENTS = 27;
    public static final int SUFFIX_UINT8_ELEMENTS = 24;
    public static final int TAG_BIGFLOAT = 5;
    public static final int TAG_BIGNUM_NEG = 3;
    public static final int TAG_BIGNUM_POS = 2;
    public static final int TAG_DECIMAL_FRACTION = 4;
    public static final int TAG_ID_SELF_DESCRIBE = 55799;
    public static final int[] sUtf8UnitLengths;

    public static boolean hasMajorType(int i, byte b) {
        return ((b & 224) >> 5) == i;
    }

    static {
        int[] iArr = new int[256];
        for (int i = 128; i < 256; i++) {
            iArr[i] = (i & 224) == 192 ? 1 : (i & PsExtractor.VIDEO_STREAM_MASK) == 224 ? 2 : (i & 248) == 240 ? 3 : -1;
        }
        sUtf8UnitLengths = iArr;
    }
}
