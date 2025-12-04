package org.bouncycastle.openpgp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.PacketTags;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.util.Iterable;

/* loaded from: classes6.dex */
public class PGPObjectFactory implements Iterable {
    private KeyFingerPrintCalculator fingerPrintCalculator;
    private BCPGInputStream in;

    public PGPObjectFactory(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator) {
        this.in = new BCPGInputStream(inputStream);
        this.fingerPrintCalculator = keyFingerPrintCalculator;
    }

    public PGPObjectFactory(byte[] bArr, KeyFingerPrintCalculator keyFingerPrintCalculator) {
        this(new ByteArrayInputStream(bArr), keyFingerPrintCalculator);
    }

    @Override // org.bouncycastle.util.Iterable, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: org.bouncycastle.openpgp.PGPObjectFactory.1
            private boolean triedNext = false;
            private Object obj = null;

            private Object getObject() {
                try {
                    return PGPObjectFactory.this.nextObject();
                } catch (IOException e) {
                    throw new PGPRuntimeOperationException("Iterator failed to get next object: " + e.getMessage(), e);
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (!this.triedNext) {
                    this.triedNext = true;
                    this.obj = getObject();
                }
                return this.obj != null;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.triedNext = false;
                return this.obj;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove element from factory.");
            }
        };
    }

    public Object nextObject() throws IOException {
        int iNextPacketTag = this.in.nextPacketTag();
        if (iNextPacketTag == -1) {
            return null;
        }
        if (iNextPacketTag == 8) {
            return new PGPCompressedData(this.in);
        }
        if (iNextPacketTag == 14) {
            try {
                return PGPPublicKeyRing.readSubkey(this.in, this.fingerPrintCalculator);
            } catch (PGPException e) {
                throw new IOException("processing error: " + e.getMessage());
            }
        }
        if (iNextPacketTag == 10) {
            return new PGPMarker(this.in);
        }
        if (iNextPacketTag == 11) {
            return new PGPLiteralData(this.in);
        }
        switch (iNextPacketTag) {
            case 1:
            case 3:
                return new PGPEncryptedDataList(this.in);
            case 2:
                ArrayList arrayList = new ArrayList();
                while (this.in.nextPacketTag() == 2) {
                    try {
                        arrayList.add(new PGPSignature(this.in));
                    } catch (PGPException e2) {
                        throw new IOException("can't create signature object: " + e2);
                    }
                }
                return new PGPSignatureList((PGPSignature[]) arrayList.toArray(new PGPSignature[arrayList.size()]));
            case 4:
                ArrayList arrayList2 = new ArrayList();
                while (this.in.nextPacketTag() == 4) {
                    try {
                        arrayList2.add(new PGPOnePassSignature(this.in));
                    } catch (PGPException e3) {
                        throw new IOException("can't create one pass signature object: " + e3);
                    }
                }
                return new PGPOnePassSignatureList((PGPOnePassSignature[]) arrayList2.toArray(new PGPOnePassSignature[arrayList2.size()]));
            case 5:
                try {
                    return new PGPSecretKeyRing(this.in, this.fingerPrintCalculator);
                } catch (PGPException e4) {
                    throw new IOException("can't create secret key object: " + e4);
                }
            case 6:
                return new PGPPublicKeyRing(this.in, this.fingerPrintCalculator);
            default:
                switch (iNextPacketTag) {
                    case 60:
                    case 61:
                    case PacketTags.EXPERIMENTAL_3 /* 62 */:
                    case 63:
                        return this.in.readPacket();
                    default:
                        throw new IOException("unknown object in stream: " + this.in.nextPacketTag());
                }
        }
    }
}
