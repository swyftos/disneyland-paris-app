package org.bouncycastle.gpg.keybox;

import java.io.IOException;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class Blob {
    protected static final byte[] magicBytes = Strings.toByteArray("KBXf");
    protected final int base;
    protected final long length;
    protected final BlobType type;
    protected final int version;

    /* renamed from: org.bouncycastle.gpg.keybox.Blob$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$gpg$keybox$BlobType;

        static {
            int[] iArr = new int[BlobType.values().length];
            $SwitchMap$org$bouncycastle$gpg$keybox$BlobType = iArr;
            try {
                iArr[BlobType.EMPTY_BLOB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$gpg$keybox$BlobType[BlobType.FIRST_BLOB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$gpg$keybox$BlobType[BlobType.X509_BLOB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$bouncycastle$gpg$keybox$BlobType[BlobType.OPEN_PGP_BLOB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected Blob(int i, long j, BlobType blobType, int i2) {
        this.base = i;
        this.length = j;
        this.type = blobType;
        this.version = i2;
    }

    static Blob getInstance(Object obj, KeyFingerPrintCalculator keyFingerPrintCalculator, BlobVerifier blobVerifier) throws IOException {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot take get instance of null");
        }
        KeyBoxByteBuffer keyBoxByteBufferWrap = KeyBoxByteBuffer.wrap(obj);
        if (!keyBoxByteBufferWrap.hasRemaining()) {
            return null;
        }
        int iPosition = keyBoxByteBufferWrap.position();
        long jU32 = keyBoxByteBufferWrap.u32();
        BlobType blobTypeFromByte = BlobType.fromByte(keyBoxByteBufferWrap.u8());
        int iU8 = keyBoxByteBufferWrap.u8();
        int i = AnonymousClass1.$SwitchMap$org$bouncycastle$gpg$keybox$BlobType[blobTypeFromByte.ordinal()];
        if (i == 2) {
            return FirstBlob.parseContent(iPosition, jU32, blobTypeFromByte, iU8, keyBoxByteBufferWrap);
        }
        if (i == 3) {
            return CertificateBlob.parseContent(iPosition, jU32, blobTypeFromByte, iU8, keyBoxByteBufferWrap, blobVerifier);
        }
        if (i != 4) {
            return null;
        }
        return PublicKeyRingBlob.parseContent(iPosition, jU32, blobTypeFromByte, iU8, keyBoxByteBufferWrap, keyFingerPrintCalculator, blobVerifier);
    }

    public BlobType getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }
}
