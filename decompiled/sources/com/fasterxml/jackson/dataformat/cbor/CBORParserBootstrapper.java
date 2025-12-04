package com.fasterxml.jackson.dataformat.cbor;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class CBORParserBootstrapper {
    protected final boolean _bufferRecyclable;
    protected final IOContext _context;
    protected final InputStream _in;
    protected final byte[] _inputBuffer;
    protected int _inputEnd;
    protected int _inputProcessed;
    protected int _inputPtr;

    public CBORParserBootstrapper(IOContext iOContext, InputStream inputStream) {
        this._context = iOContext;
        this._in = inputStream;
        this._inputBuffer = iOContext.allocReadIOBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._inputProcessed = 0;
        this._bufferRecyclable = true;
    }

    public CBORParserBootstrapper(IOContext iOContext, byte[] bArr, int i, int i2) {
        this._context = iOContext;
        this._in = null;
        this._inputBuffer = bArr;
        this._inputPtr = i;
        this._inputEnd = i2 + i;
        this._inputProcessed = -i;
        this._bufferRecyclable = false;
    }

    public CBORParser constructParser(int i, int i2, int i3, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer) throws IOException {
        ByteQuadsCanonicalizer byteQuadsCanonicalizerMakeChild = byteQuadsCanonicalizer.makeChild(i);
        ensureLoaded(1);
        return new CBORParser(this._context, i2, i3, objectCodec, byteQuadsCanonicalizerMakeChild, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);
    }

    public static MatchStrength hasCBORFormat(InputAccessor inputAccessor) throws IOException {
        if (!inputAccessor.hasMoreBytes()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte bNextByte = inputAccessor.nextByte();
        if (bNextByte == -65) {
            if (inputAccessor.hasMoreBytes()) {
                byte bNextByte2 = inputAccessor.nextByte();
                if (bNextByte2 == -1) {
                    return MatchStrength.SOLID_MATCH;
                }
                if (CBORConstants.hasMajorType(3, bNextByte2)) {
                    return MatchStrength.SOLID_MATCH;
                }
                return MatchStrength.INCONCLUSIVE;
            }
        } else if (bNextByte == -97) {
            if (inputAccessor.hasMoreBytes()) {
                if (inputAccessor.nextByte() == -1) {
                    return MatchStrength.SOLID_MATCH;
                }
                return MatchStrength.WEAK_MATCH;
            }
        } else {
            if (CBORConstants.hasMajorType(6, bNextByte)) {
                if (bNextByte == -39 && inputAccessor.hasMoreBytes() && inputAccessor.nextByte() == -39 && inputAccessor.hasMoreBytes() && inputAccessor.nextByte() == -9) {
                    return MatchStrength.FULL_MATCH;
                }
                return MatchStrength.WEAK_MATCH;
            }
            if (CBORConstants.hasMajorType(7, bNextByte)) {
                if (bNextByte == -12 || bNextByte == -11 || bNextByte == -10) {
                    return MatchStrength.SOLID_MATCH;
                }
                return MatchStrength.NO_MATCH;
            }
        }
        return MatchStrength.INCONCLUSIVE;
    }

    protected boolean ensureLoaded(int i) throws IOException {
        if (this._in == null) {
            return false;
        }
        int i2 = this._inputEnd - this._inputPtr;
        while (i2 < i) {
            InputStream inputStream = this._in;
            byte[] bArr = this._inputBuffer;
            int i3 = this._inputEnd;
            int i4 = inputStream.read(bArr, i3, bArr.length - i3);
            if (i4 < 1) {
                return false;
            }
            this._inputEnd += i4;
            i2 += i4;
        }
        return true;
    }
}
