package org.bouncycastle.gpg.keybox;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;

/* loaded from: classes6.dex */
public class KeyBox {
    private final FirstBlob firstBlob;
    private final List keyBlobs;

    public KeyBox(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator, BlobVerifier blobVerifier) throws IOException {
        this(KeyBoxByteBuffer.wrap(inputStream), keyFingerPrintCalculator, blobVerifier);
    }

    private KeyBox(KeyBoxByteBuffer keyBoxByteBuffer, KeyFingerPrintCalculator keyFingerPrintCalculator, BlobVerifier blobVerifier) throws IOException {
        Blob blob = Blob.getInstance(keyBoxByteBuffer, keyFingerPrintCalculator, blobVerifier);
        if (blob == null) {
            throw new IOException("No first blob, is the source zero length?");
        }
        if (!(blob instanceof FirstBlob)) {
            throw new IOException("First blob is not KeyBox 'First Blob'.");
        }
        FirstBlob firstBlob = (FirstBlob) blob;
        ArrayList arrayList = new ArrayList();
        while (true) {
            Blob blob2 = Blob.getInstance(keyBoxByteBuffer, keyFingerPrintCalculator, blobVerifier);
            if (blob2 == null) {
                this.firstBlob = firstBlob;
                this.keyBlobs = Collections.unmodifiableList(arrayList);
                return;
            } else {
                if (blob2.getType() == BlobType.FIRST_BLOB) {
                    throw new IOException("Unexpected second 'FirstBlob', there should only be one FirstBlob at the start of the file.");
                }
                arrayList.add((KeyBlob) blob2);
            }
        }
    }

    public KeyBox(byte[] bArr, KeyFingerPrintCalculator keyFingerPrintCalculator, BlobVerifier blobVerifier) throws IOException {
        this(KeyBoxByteBuffer.wrap(bArr), keyFingerPrintCalculator, blobVerifier);
    }

    public FirstBlob getFirstBlob() {
        return this.firstBlob;
    }

    public List<KeyBlob> getKeyBlobs() {
        return this.keyBlobs;
    }
}
