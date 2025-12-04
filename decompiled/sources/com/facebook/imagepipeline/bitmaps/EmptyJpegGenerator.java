package com.facebook.imagepipeline.bitmaps;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;
import com.fasterxml.jackson.dataformat.cbor.CBORConstants;
import com.google.common.base.Ascii;
import java.io.IOException;
import okio.Utf8;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public class EmptyJpegGenerator {
    private static final byte[] EMPTY_JPEG_PREFIX = {-1, -40, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -64, 0, 17, 8};
    private static final byte[] EMPTY_JPEG_SUFFIX = {3, 1, 34, 0, 2, 17, 0, 3, 17, 0, -1, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, 0, Ascii.US, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, -1, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, 0, -75, Ascii.DLE, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, Ascii.DC2, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, Ascii.DC4, 50, -127, -111, -95, 8, 35, 66, -79, -63, Ascii.NAK, 82, -47, -16, 36, 51, 98, 114, CBORConstants.BYTE_ARRAY_2_ELEMENTS, 9, 10, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, CBORConstants.BYTE_STRING_1BYTE_LEN, CBORConstants.BYTE_STRING_2BYTE_LEN, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, CBORConstants.BYTE_TAG_BIGNUM_POS, CBORConstants.BYTE_TAG_BIGNUM_NEG, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, CBORConstants.BYTE_TAG_BIGFLOAT, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, CBORConstants.BYTE_FALSE, CBORConstants.BYTE_TRUE, -10, -9, -8, -7, -6, -1, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, 0, Ascii.US, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, -1, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, 33, 49, 6, Ascii.DC2, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, Ascii.DC4, 66, -111, -95, -79, -63, 9, 35, 51, 82, -16, Ascii.NAK, 98, 114, -47, 10, Ascii.SYN, 36, 52, -31, 37, -15, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, CBORConstants.BYTE_STRING_1BYTE_LEN, CBORConstants.BYTE_STRING_2BYTE_LEN, 122, CBORConstants.BYTE_ARRAY_2_ELEMENTS, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, CBORConstants.BYTE_TAG_BIGNUM_POS, CBORConstants.BYTE_TAG_BIGNUM_NEG, CBORConstants.BYTE_TAG_DECIMAL_FRACTION, CBORConstants.BYTE_TAG_BIGFLOAT, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, CBORConstants.BYTE_FALSE, CBORConstants.BYTE_TRUE, -10, -9, -8, -7, -6, -1, -38, 0, Ascii.FF, 3, 1, 0, 2, 17, 3, 17, 0, Utf8.REPLACEMENT_BYTE, 0, -114, -118, 40, -96, Ascii.SI, -1, -39};
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public EmptyJpegGenerator(PooledByteBufferFactory pooledByteBufferFactory) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public CloseableReference<PooledByteBuffer> generate(short s, short s2) throws Throwable {
        PooledByteBufferOutputStream pooledByteBufferOutputStreamNewOutputStream = null;
        try {
            try {
                PooledByteBufferFactory pooledByteBufferFactory = this.mPooledByteBufferFactory;
                byte[] bArr = EMPTY_JPEG_PREFIX;
                int length = bArr.length;
                byte[] bArr2 = EMPTY_JPEG_SUFFIX;
                pooledByteBufferOutputStreamNewOutputStream = pooledByteBufferFactory.newOutputStream(length + bArr2.length + 4);
                pooledByteBufferOutputStreamNewOutputStream.write(bArr);
                pooledByteBufferOutputStreamNewOutputStream.write((byte) (s2 >> 8));
                pooledByteBufferOutputStreamNewOutputStream.write((byte) (s2 & 255));
                pooledByteBufferOutputStreamNewOutputStream.write((byte) (s >> 8));
                pooledByteBufferOutputStreamNewOutputStream.write((byte) (s & 255));
                pooledByteBufferOutputStreamNewOutputStream.write(bArr2);
                CloseableReference<PooledByteBuffer> closeableReferenceOf = CloseableReference.of(pooledByteBufferOutputStreamNewOutputStream.toByteBuffer());
                pooledByteBufferOutputStreamNewOutputStream.close();
                return closeableReferenceOf;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            if (pooledByteBufferOutputStreamNewOutputStream != null) {
                pooledByteBufferOutputStreamNewOutputStream.close();
            }
            throw th;
        }
    }
}
