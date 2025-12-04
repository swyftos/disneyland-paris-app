package org.bouncycastle.bcpg;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.bcpg.sig.EmbeddedSignature;
import org.bouncycastle.bcpg.sig.Exportable;
import org.bouncycastle.bcpg.sig.Features;
import org.bouncycastle.bcpg.sig.IntendedRecipientFingerprint;
import org.bouncycastle.bcpg.sig.IssuerFingerprint;
import org.bouncycastle.bcpg.sig.IssuerKeyID;
import org.bouncycastle.bcpg.sig.KeyExpirationTime;
import org.bouncycastle.bcpg.sig.KeyFlags;
import org.bouncycastle.bcpg.sig.NotationData;
import org.bouncycastle.bcpg.sig.PreferredAlgorithms;
import org.bouncycastle.bcpg.sig.PrimaryUserID;
import org.bouncycastle.bcpg.sig.Revocable;
import org.bouncycastle.bcpg.sig.RevocationReason;
import org.bouncycastle.bcpg.sig.SignatureCreationTime;
import org.bouncycastle.bcpg.sig.SignatureExpirationTime;
import org.bouncycastle.bcpg.sig.SignatureTarget;
import org.bouncycastle.bcpg.sig.SignerUserID;
import org.bouncycastle.bcpg.sig.TrustSignature;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes6.dex */
public class SignatureSubpacketInputStream extends InputStream implements SignatureSubpacketTags {
    private final InputStream in;
    private final int limit;

    public SignatureSubpacketInputStream(InputStream inputStream) {
        this(inputStream, StreamUtil.findLimit(inputStream));
    }

    public SignatureSubpacketInputStream(InputStream inputStream, int i) {
        this.in = inputStream;
        this.limit = i;
    }

    private byte[] checkData(byte[] bArr, int i, int i2, String str) throws EOFException {
        if (i2 == i) {
            return Arrays.copyOfRange(bArr, 0, i);
        }
        throw new EOFException("truncated " + str + " subpacket data.");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.in.read();
    }

    public SignatureSubpacket readPacket() throws IOException {
        boolean z;
        String str;
        int i = read();
        if (i < 0) {
            return null;
        }
        if (i < 192) {
            z = false;
        } else if (i <= 223) {
            i = ((i - 192) << 8) + this.in.read() + 192;
            z = false;
        } else {
            if (i != 255) {
                throw new IOException("unexpected length header");
            }
            i = (this.in.read() << 24) | (this.in.read() << 16) | (this.in.read() << 8) | this.in.read();
            z = true;
        }
        int i2 = this.in.read();
        if (i2 < 0) {
            throw new EOFException("unexpected EOF reading signature sub packet");
        }
        if (i <= 0 || (i > this.limit && i > 2048)) {
            throw new EOFException("out of range data found in signature sub packet");
        }
        int i3 = i - 1;
        byte[] bArrCheckData = new byte[i3];
        int fully = Streams.readFully(this.in, bArrCheckData);
        boolean z2 = (i2 & 128) != 0;
        int i4 = i2 & 127;
        if (fully != i3) {
            if (i4 == 2) {
                str = "Signature Creation Time";
            } else if (i4 == 3) {
                str = "Signature Expiration Time";
            } else if (i4 == 9) {
                str = "Signature Key Expiration Time";
            } else {
                if (i4 != 16) {
                    throw new EOFException("truncated subpacket data.");
                }
                bArrCheckData = checkData(bArrCheckData, 8, fully, "Issuer");
            }
            bArrCheckData = checkData(bArrCheckData, 4, fully, str);
        }
        if (i4 == 2) {
            return new SignatureCreationTime(z2, z, bArrCheckData);
        }
        if (i4 == 3) {
            return new SignatureExpirationTime(z2, z, bArrCheckData);
        }
        if (i4 == 4) {
            return new Exportable(z2, z, bArrCheckData);
        }
        if (i4 == 5) {
            return new TrustSignature(z2, z, bArrCheckData);
        }
        if (i4 == 7) {
            return new Revocable(z2, z, bArrCheckData);
        }
        if (i4 == 9) {
            return new KeyExpirationTime(z2, z, bArrCheckData);
        }
        if (i4 != 11) {
            if (i4 == 16) {
                return new IssuerKeyID(z2, z, bArrCheckData);
            }
            if (i4 == 25) {
                return new PrimaryUserID(z2, z, bArrCheckData);
            }
            switch (i4) {
                case 20:
                    return new NotationData(z2, z, bArrCheckData);
                case 21:
                case 22:
                    break;
                default:
                    switch (i4) {
                        case 27:
                            return new KeyFlags(z2, z, bArrCheckData);
                        case 28:
                            return new SignerUserID(z2, z, bArrCheckData);
                        case 29:
                            return new RevocationReason(z2, z, bArrCheckData);
                        case 30:
                            return new Features(z2, z, bArrCheckData);
                        case 31:
                            return new SignatureTarget(z2, z, bArrCheckData);
                        case 32:
                            return new EmbeddedSignature(z2, z, bArrCheckData);
                        case 33:
                            return new IssuerFingerprint(z2, z, bArrCheckData);
                        case 34:
                            break;
                        case 35:
                            return new IntendedRecipientFingerprint(z2, z, bArrCheckData);
                        default:
                            return new SignatureSubpacket(i4, z2, z, bArrCheckData);
                    }
            }
        }
        return new PreferredAlgorithms(i4, z2, z, bArrCheckData);
    }
}
