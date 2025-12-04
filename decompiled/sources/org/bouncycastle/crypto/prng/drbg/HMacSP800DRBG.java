package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public class HMacSP800DRBG implements SP80090DRBG {
    private byte[] _K;
    private byte[] _V;
    private EntropySource _entropySource;
    private Mac _hMac;
    private long _reseedCounter;
    private int _securityStrength;

    public HMacSP800DRBG(Mac mac, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        if (i > Utils.getMaxSecurityStrength(mac)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (entropySource.entropySize() < i) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        this._securityStrength = i;
        this._entropySource = entropySource;
        this._hMac = mac;
        byte[] bArrConcatenate = Arrays.concatenate(getEntropy(), bArr2, bArr);
        byte[] bArr3 = new byte[mac.getMacSize()];
        this._K = bArr3;
        byte[] bArr4 = new byte[bArr3.length];
        this._V = bArr4;
        Arrays.fill(bArr4, (byte) 1);
        hmac_DRBG_Update(bArrConcatenate);
        this._reseedCounter = 1L;
    }

    private byte[] getEntropy() {
        byte[] entropy = this._entropySource.getEntropy();
        if (entropy.length >= (this._securityStrength + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private void hmac_DRBG_Update(byte[] bArr) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        hmac_DRBG_Update_Func(bArr, (byte) 0);
        if (bArr != null) {
            hmac_DRBG_Update_Func(bArr, (byte) 1);
        }
    }

    private void hmac_DRBG_Update_Func(byte[] bArr, byte b) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        this._hMac.init(new KeyParameter(this._K));
        Mac mac = this._hMac;
        byte[] bArr2 = this._V;
        mac.update(bArr2, 0, bArr2.length);
        this._hMac.update(b);
        if (bArr != null) {
            this._hMac.update(bArr, 0, bArr.length);
        }
        this._hMac.doFinal(this._K, 0);
        this._hMac.init(new KeyParameter(this._K));
        Mac mac2 = this._hMac;
        byte[] bArr3 = this._V;
        mac2.update(bArr3, 0, bArr3.length);
        this._hMac.doFinal(this._V, 0);
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        }
        if (this._reseedCounter > 140737488355328L) {
            return -1;
        }
        if (z) {
            reseed(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            hmac_DRBG_Update(bArr2);
        }
        int length2 = bArr.length;
        byte[] bArr3 = new byte[length2];
        int length3 = bArr.length / this._V.length;
        this._hMac.init(new KeyParameter(this._K));
        for (int i = 0; i < length3; i++) {
            Mac mac = this._hMac;
            byte[] bArr4 = this._V;
            mac.update(bArr4, 0, bArr4.length);
            this._hMac.doFinal(this._V, 0);
            byte[] bArr5 = this._V;
            System.arraycopy(bArr5, 0, bArr3, bArr5.length * i, bArr5.length);
        }
        byte[] bArr6 = this._V;
        if (bArr6.length * length3 < length2) {
            this._hMac.update(bArr6, 0, bArr6.length);
            this._hMac.doFinal(this._V, 0);
            byte[] bArr7 = this._V;
            System.arraycopy(bArr7, 0, bArr3, bArr7.length * length3, length2 - (length3 * bArr7.length));
        }
        hmac_DRBG_Update(bArr2);
        this._reseedCounter++;
        System.arraycopy(bArr3, 0, bArr, 0, bArr.length);
        return length;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public int getBlockSize() {
        return this._V.length * 8;
    }

    @Override // org.bouncycastle.crypto.prng.drbg.SP80090DRBG
    public void reseed(byte[] bArr) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        hmac_DRBG_Update(Arrays.concatenate(getEntropy(), bArr));
        this._reseedCounter = 1L;
    }
}
