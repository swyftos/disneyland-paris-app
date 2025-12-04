package com.fasterxml.jackson.dataformat.cbor;

import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.ts.PsExtractor;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.DupDetector;
import com.google.android.material.internal.ViewUtils;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class CBORGenerator extends GeneratorBase {
    private static final int[] NO_INTS = new int[0];
    protected boolean _bufferRecyclable;
    protected int _bytesWritten;
    protected CBORWriteContext _cborContext;
    protected boolean _cfgMinimalInts;
    protected char[] _charBuffer;
    protected final int _charBufferLength;
    protected int _currentRemainingElements;
    protected int[] _elementCounts;
    protected int _elementCountsPtr;
    protected int _formatFeatures;
    protected final IOContext _ioContext;
    protected final OutputStream _out;
    protected byte[] _outputBuffer;
    protected final int _outputEnd;
    protected int _outputTail;

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteBinaryNatively() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        return this;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator useDefaultPrettyPrinter() {
        return this;
    }

    public enum Feature implements FormatFeature {
        WRITE_MINIMAL_INTS(true),
        WRITE_TYPE_HEADER(false);

        protected final boolean _defaultState;
        protected final int _mask = 1 << ordinal();

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        Feature(boolean z) {
            this._defaultState = z;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature
        public boolean enabledByDefault() {
            return this._defaultState;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature
        public boolean enabledIn(int i) {
            return (getMask() & i) != 0;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature
        public int getMask() {
            return this._mask;
        }
    }

    public CBORGenerator(IOContext iOContext, int i, int i2, ObjectCodec objectCodec, OutputStream outputStream) {
        super(i, objectCodec, null);
        this._outputTail = 0;
        this._elementCounts = NO_INTS;
        this._currentRemainingElements = -2;
        this._cborContext = CBORWriteContext.createRootContext(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? DupDetector.rootDetector(this) : null);
        this._formatFeatures = i2;
        this._cfgMinimalInts = Feature.WRITE_MINIMAL_INTS.enabledIn(i2);
        this._ioContext = iOContext;
        this._out = outputStream;
        this._bufferRecyclable = true;
        byte[] bArrAllocWriteEncodingBuffer = iOContext.allocWriteEncodingBuffer(AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND);
        this._outputBuffer = bArrAllocWriteEncodingBuffer;
        int length = bArrAllocWriteEncodingBuffer.length;
        this._outputEnd = length;
        char[] cArrAllocConcatBuffer = iOContext.allocConcatBuffer();
        this._charBuffer = cArrAllocConcatBuffer;
        this._charBufferLength = cArrAllocConcatBuffer.length;
        if (length >= 770) {
            return;
        }
        throw new IllegalStateException("Internal encoding buffer length (" + length + ") too short, must be at least 770");
    }

    public CBORGenerator(IOContext iOContext, int i, int i2, ObjectCodec objectCodec, OutputStream outputStream, byte[] bArr, int i3, boolean z) {
        super(i, objectCodec, null);
        this._outputTail = 0;
        this._elementCounts = NO_INTS;
        this._currentRemainingElements = -2;
        this._cborContext = CBORWriteContext.createRootContext(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? DupDetector.rootDetector(this) : null);
        this._formatFeatures = i2;
        this._cfgMinimalInts = Feature.WRITE_MINIMAL_INTS.enabledIn(i2);
        this._ioContext = iOContext;
        this._out = outputStream;
        this._bufferRecyclable = z;
        this._outputTail = i3;
        this._outputBuffer = bArr;
        int length = bArr.length;
        this._outputEnd = length;
        char[] cArrAllocConcatBuffer = iOContext.allocConcatBuffer();
        this._charBuffer = cArrAllocConcatBuffer;
        this._charBufferLength = cArrAllocConcatBuffer.length;
        if (length >= 770) {
            return;
        }
        throw new IllegalStateException("Internal encoding buffer length (" + length + ") too short, must be at least 770");
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this._out;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getOutputBuffered() {
        return this._outputTail;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getFormatFeatures() {
        return this._formatFeatures;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator overrideStdFeatures(int i, int i2) {
        int i3 = this._features;
        int i4 = (i & i2) | ((~i2) & i3);
        if (i3 != i4) {
            this._features = i4;
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator overrideFormatFeatures(int i, int i2) {
        int i3 = this._formatFeatures;
        int i4 = (i & i2) | ((~i2) & i3);
        if (i3 != i4) {
            this._formatFeatures = i4;
            this._cfgMinimalInts = Feature.WRITE_MINIMAL_INTS.enabledIn(i4);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public Object getCurrentValue() {
        return this._cborContext.getCurrentValue();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void setCurrentValue(Object obj) {
        this._cborContext.setCurrentValue(obj);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public JsonStreamContext getOutputContext() {
        return this._cborContext;
    }

    public CBORGenerator enable(Feature feature) {
        this._formatFeatures |= feature.getMask();
        if (feature == Feature.WRITE_MINIMAL_INTS) {
            this._cfgMinimalInts = true;
        }
        return this;
    }

    public CBORGenerator disable(Feature feature) {
        this._formatFeatures &= ~feature.getMask();
        if (feature == Feature.WRITE_MINIMAL_INTS) {
            this._cfgMinimalInts = false;
        }
        return this;
    }

    public final boolean isEnabled(Feature feature) {
        return (this._formatFeatures & feature.getMask()) != 0;
    }

    public CBORGenerator configure(Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(String str) throws IOException {
        if (!this._cborContext.writeFieldName(str)) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeString(str);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldName(SerializableString serializableString) throws IOException {
        if (!this._cborContext.writeFieldName(serializableString.getValue())) {
            _reportError("Can not write a field name, expecting a value");
        }
        byte[] bArrAsUnquotedUTF8 = serializableString.asUnquotedUTF8();
        int length = bArrAsUnquotedUTF8.length;
        if (length == 0) {
            _writeByte(CBORConstants.BYTE_EMPTY_STRING);
        } else {
            _writeLengthMarker(96, length);
            _writeBytes(bArrAsUnquotedUTF8, 0, length);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeFieldId(long j) throws IOException {
        if (!this._cborContext.writeFieldId(j)) {
            _reportError("Can not write a field id, expecting a value");
        }
        _writeNumberNoCheck(j);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStringField(String str, String str2) throws IOException {
        if (!this._cborContext.writeFieldName(str)) {
            _reportError("Can not write a field name, expecting a value");
        }
        _writeString(str);
        if (str2 == null) {
            writeNull();
        } else {
            _verifyValueWrite("write String value");
            _writeString(str2);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void copyCurrentEvent(JsonParser jsonParser) throws IOException {
        maybeCopyTag(jsonParser);
        super.copyCurrentEvent(jsonParser);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void copyCurrentStructure(JsonParser jsonParser) throws IOException {
        maybeCopyTag(jsonParser);
        super.copyCurrentStructure(jsonParser);
    }

    protected void maybeCopyTag(JsonParser jsonParser) throws IOException {
        int currentTag;
        if ((jsonParser instanceof CBORParser) && jsonParser.hasCurrentToken() && (currentTag = ((CBORParser) jsonParser).getCurrentTag()) != -1) {
            writeTag(currentTag);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartArray() throws IOException {
        _verifyValueWrite("start an array");
        this._cborContext = this._cborContext.createChildArrayContext(null);
        if (this._elementCountsPtr > 0) {
            _pushRemainingElements();
        }
        this._currentRemainingElements = -2;
        _writeByte(CBORConstants.BYTE_ARRAY_INDEFINITE);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(int i) throws IOException {
        _verifyValueWrite("start an array");
        this._cborContext = this._cborContext.createChildArrayContext(null);
        _pushRemainingElements();
        this._currentRemainingElements = i;
        _writeLengthMarker(128, i);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndArray() throws IOException {
        if (!this._cborContext.inArray()) {
            _reportError("Current context not Array but " + this._cborContext.typeDesc());
        }
        closeComplexElement();
        this._cborContext = this._cborContext.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject() throws IOException {
        _verifyValueWrite("start an object");
        this._cborContext = this._cborContext.createChildObjectContext(null);
        if (this._elementCountsPtr > 0) {
            _pushRemainingElements();
        }
        this._currentRemainingElements = -2;
        _writeByte((byte) -65);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeStartObject(Object obj) throws IOException {
        _verifyValueWrite("start an object");
        this._cborContext = this._cborContext.createChildObjectContext(obj);
        if (this._elementCountsPtr > 0) {
            _pushRemainingElements();
        }
        this._currentRemainingElements = -2;
        _writeByte((byte) -65);
    }

    public final void writeStartObject(int i) throws IOException {
        _verifyValueWrite("start an object");
        this._cborContext = this._cborContext.createChildObjectContext(null);
        _pushRemainingElements();
        this._currentRemainingElements = i;
        _writeLengthMarker(160, i);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeEndObject() throws IOException {
        if (!this._cborContext.inObject()) {
            _reportError("Current context not Object but " + this._cborContext.typeDesc());
        }
        closeComplexElement();
        this._cborContext = this._cborContext.getParent();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeArray(int[] iArr, int i, int i2) throws IOException {
        _verifyOffsets(iArr.length, i, i2);
        _verifyValueWrite("write int array");
        _writeLengthMarker(128, i2);
        int i3 = i2 + i;
        while (i < i3) {
            _writeNumberNoCheck(iArr[i]);
            i++;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeArray(long[] jArr, int i, int i2) throws IOException {
        _verifyOffsets(jArr.length, i, i2);
        _verifyValueWrite("write int array");
        _writeLengthMarker(128, i2);
        int i3 = i2 + i;
        while (i < i3) {
            _writeNumberNoCheck(jArr[i]);
            i++;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeArray(double[] dArr, int i, int i2) throws IOException {
        _verifyOffsets(dArr.length, i, i2);
        _verifyValueWrite("write int array");
        _writeLengthMarker(128, i2);
        int i3 = i2 + i;
        while (i < i3) {
            _writeNumberNoCheck(dArr[i]);
            i++;
        }
    }

    private final void _pushRemainingElements() {
        int[] iArr = this._elementCounts;
        if (iArr.length == this._elementCountsPtr) {
            this._elementCounts = Arrays.copyOf(iArr, iArr.length + 10);
        }
        int[] iArr2 = this._elementCounts;
        int i = this._elementCountsPtr;
        this._elementCountsPtr = i + 1;
        iArr2[i] = this._currentRemainingElements;
    }

    private final void _writeNumberNoCheck(int i) throws IOException {
        int i2;
        byte b;
        int i3;
        if (i < 0) {
            i = (-i) - 1;
            i2 = 32;
        } else {
            i2 = 0;
        }
        _ensureRoomForOutput(5);
        if (!this._cfgMinimalInts) {
            b = (byte) i;
            i3 = i >> 8;
        } else {
            if (i < 24) {
                byte[] bArr = this._outputBuffer;
                int i4 = this._outputTail;
                this._outputTail = i4 + 1;
                bArr[i4] = (byte) (i2 + i);
                return;
            }
            if (i <= 255) {
                byte[] bArr2 = this._outputBuffer;
                int i5 = this._outputTail;
                int i6 = i5 + 1;
                this._outputTail = i6;
                bArr2[i5] = (byte) (i2 + 24);
                this._outputTail = i5 + 2;
                bArr2[i6] = (byte) i;
                return;
            }
            b = (byte) i;
            i3 = i >> 8;
            if (i3 <= 255) {
                byte[] bArr3 = this._outputBuffer;
                int i7 = this._outputTail;
                int i8 = i7 + 1;
                this._outputTail = i8;
                bArr3[i7] = (byte) (i2 + 25);
                int i9 = i7 + 2;
                this._outputTail = i9;
                bArr3[i8] = (byte) i3;
                this._outputTail = i7 + 3;
                bArr3[i9] = b;
                return;
            }
        }
        byte[] bArr4 = this._outputBuffer;
        int i10 = this._outputTail;
        int i11 = i10 + 1;
        this._outputTail = i11;
        bArr4[i10] = (byte) (i2 + 26);
        int i12 = i10 + 2;
        this._outputTail = i12;
        bArr4[i11] = (byte) (i3 >> 16);
        int i13 = i10 + 3;
        this._outputTail = i13;
        bArr4[i12] = (byte) (i3 >> 8);
        int i14 = i10 + 4;
        this._outputTail = i14;
        bArr4[i13] = (byte) i3;
        this._outputTail = i10 + 5;
        bArr4[i14] = b;
    }

    private final void _writeNumberNoCheck(long j) throws IOException {
        if (this._cfgMinimalInts && j <= 2147483647L && j >= -2147483648L) {
            _writeNumberNoCheck((int) j);
            return;
        }
        _ensureRoomForOutput(9);
        if (j < 0) {
            j = -(j + 1);
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = 59;
        } else {
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = Ascii.ESC;
        }
        int i3 = (int) (j >> 32);
        byte[] bArr3 = this._outputBuffer;
        int i4 = this._outputTail;
        int i5 = i4 + 1;
        this._outputTail = i5;
        bArr3[i4] = (byte) (i3 >> 24);
        int i6 = i4 + 2;
        this._outputTail = i6;
        bArr3[i5] = (byte) (i3 >> 16);
        int i7 = i4 + 3;
        this._outputTail = i7;
        bArr3[i6] = (byte) (i3 >> 8);
        int i8 = i4 + 4;
        this._outputTail = i8;
        bArr3[i7] = (byte) i3;
        int i9 = (int) j;
        int i10 = i4 + 5;
        this._outputTail = i10;
        bArr3[i8] = (byte) (i9 >> 24);
        int i11 = i4 + 6;
        this._outputTail = i11;
        bArr3[i10] = (byte) (i9 >> 16);
        int i12 = i4 + 7;
        this._outputTail = i12;
        bArr3[i11] = (byte) (i9 >> 8);
        this._outputTail = i4 + 8;
        bArr3[i12] = (byte) i9;
    }

    private final void _writeNumberNoCheck(double d) throws IOException {
        _ensureRoomForOutput(11);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        int i2 = i + 1;
        this._outputTail = i2;
        bArr[i] = -5;
        int i3 = (int) (jDoubleToRawLongBits >> 32);
        int i4 = i + 2;
        this._outputTail = i4;
        bArr[i2] = (byte) (i3 >> 24);
        int i5 = i + 3;
        this._outputTail = i5;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i + 4;
        this._outputTail = i6;
        bArr[i5] = (byte) (i3 >> 8);
        int i7 = i + 5;
        this._outputTail = i7;
        bArr[i6] = (byte) i3;
        int i8 = (int) jDoubleToRawLongBits;
        int i9 = i + 6;
        this._outputTail = i9;
        bArr[i7] = (byte) (i8 >> 24);
        int i10 = i + 7;
        this._outputTail = i10;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i + 8;
        this._outputTail = i11;
        bArr[i10] = (byte) (i8 >> 8);
        this._outputTail = i + 9;
        bArr[i11] = (byte) i8;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        if (str == null) {
            writeNull();
        } else {
            _verifyValueWrite("write String value");
            _writeString(str);
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public final void writeString(SerializableString serializableString) throws IOException {
        _verifyValueWrite("write String value");
        byte[] bArrAsUnquotedUTF8 = serializableString.asUnquotedUTF8();
        int length = bArrAsUnquotedUTF8.length;
        if (length == 0) {
            _writeByte(CBORConstants.BYTE_EMPTY_STRING);
        } else {
            _writeLengthMarker(96, length);
            _writeBytes(bArrAsUnquotedUTF8, 0, length);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i2) throws IOException {
        _verifyValueWrite("write String value");
        if (i2 == 0) {
            _writeByte(CBORConstants.BYTE_EMPTY_STRING);
        } else {
            _writeString(cArr, i, i2);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException {
        _verifyValueWrite("write String value");
        if (i2 == 0) {
            _writeByte(CBORConstants.BYTE_EMPTY_STRING);
        } else {
            _writeLengthMarker(96, i2);
            _writeBytes(bArr, 0, i2);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public final void writeUTF8String(byte[] bArr, int i, int i2) throws IOException {
        writeRawUTF8String(bArr, i, i2);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        throw _notSupported();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i2) throws IOException {
        throw _notSupported();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        throw _notSupported();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c) throws IOException {
        throw _notSupported();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str) throws IOException {
        throw _notSupported();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i, int i2) throws IOException {
        throw _notSupported();
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i, int i2) throws IOException {
        throw _notSupported();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write Binary value");
        _writeLengthMarker(64, i2);
        _writeBytes(bArr, i, i2);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(InputStream inputStream, int i) throws IOException {
        if (i < 0) {
            throw new UnsupportedOperationException("Must pass actual length for CBOR encoded data");
        }
        _verifyValueWrite("write Binary value");
        _writeLengthMarker(64, i);
        int i_writeBytes = _writeBytes(inputStream, i);
        if (i_writeBytes > 0) {
            _reportError("Too few bytes available: missing " + i_writeBytes + " bytes (out of " + i + ")");
        }
        return i;
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        return writeBinary(inputStream, i);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z) throws IOException {
        _verifyValueWrite("write boolean value");
        if (z) {
            _writeByte(CBORConstants.BYTE_TRUE);
        } else {
            _writeByte(CBORConstants.BYTE_FALSE);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        _verifyValueWrite("write null value");
        _writeByte((byte) -10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        int i2;
        byte b;
        int i3;
        _verifyValueWrite("write number");
        if (i < 0) {
            i = (-i) - 1;
            i2 = 32;
        } else {
            i2 = 0;
        }
        _ensureRoomForOutput(5);
        if (!this._cfgMinimalInts) {
            b = (byte) i;
            i3 = i >> 8;
        } else {
            if (i < 24) {
                byte[] bArr = this._outputBuffer;
                int i4 = this._outputTail;
                this._outputTail = i4 + 1;
                bArr[i4] = (byte) (i2 + i);
                return;
            }
            if (i <= 255) {
                byte[] bArr2 = this._outputBuffer;
                int i5 = this._outputTail;
                int i6 = i5 + 1;
                this._outputTail = i6;
                bArr2[i5] = (byte) (i2 + 24);
                this._outputTail = i5 + 2;
                bArr2[i6] = (byte) i;
                return;
            }
            b = (byte) i;
            i3 = i >> 8;
            if (i3 <= 255) {
                byte[] bArr3 = this._outputBuffer;
                int i7 = this._outputTail;
                int i8 = i7 + 1;
                this._outputTail = i8;
                bArr3[i7] = (byte) (i2 + 25);
                int i9 = i7 + 2;
                this._outputTail = i9;
                bArr3[i8] = (byte) i3;
                this._outputTail = i7 + 3;
                bArr3[i9] = b;
                return;
            }
        }
        byte[] bArr4 = this._outputBuffer;
        int i10 = this._outputTail;
        int i11 = i10 + 1;
        this._outputTail = i11;
        bArr4[i10] = (byte) (i2 + 26);
        int i12 = i10 + 2;
        this._outputTail = i12;
        bArr4[i11] = (byte) (i3 >> 16);
        int i13 = i10 + 3;
        this._outputTail = i13;
        bArr4[i12] = (byte) (i3 >> 8);
        int i14 = i10 + 4;
        this._outputTail = i14;
        bArr4[i13] = (byte) i3;
        this._outputTail = i10 + 5;
        bArr4[i14] = b;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j) throws IOException {
        if (this._cfgMinimalInts && j <= 2147483647L && j >= -2147483648L) {
            writeNumber((int) j);
            return;
        }
        _verifyValueWrite("write number");
        _ensureRoomForOutput(9);
        if (j < 0) {
            j = -(j + 1);
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = 59;
        } else {
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = Ascii.ESC;
        }
        int i3 = (int) (j >> 32);
        byte[] bArr3 = this._outputBuffer;
        int i4 = this._outputTail;
        int i5 = i4 + 1;
        this._outputTail = i5;
        bArr3[i4] = (byte) (i3 >> 24);
        int i6 = i4 + 2;
        this._outputTail = i6;
        bArr3[i5] = (byte) (i3 >> 16);
        int i7 = i4 + 3;
        this._outputTail = i7;
        bArr3[i6] = (byte) (i3 >> 8);
        int i8 = i4 + 4;
        this._outputTail = i8;
        bArr3[i7] = (byte) i3;
        int i9 = (int) j;
        int i10 = i4 + 5;
        this._outputTail = i10;
        bArr3[i8] = (byte) (i9 >> 24);
        int i11 = i4 + 6;
        this._outputTail = i11;
        bArr3[i10] = (byte) (i9 >> 16);
        int i12 = i4 + 7;
        this._outputTail = i12;
        bArr3[i11] = (byte) (i9 >> 8);
        this._outputTail = i4 + 8;
        bArr3[i12] = (byte) i9;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        if (bigInteger == null) {
            writeNull();
        } else {
            _verifyValueWrite("write number");
            _write(bigInteger);
        }
    }

    protected void _write(BigInteger bigInteger) throws IOException {
        if (bigInteger.signum() < 0) {
            _writeByte(CBORConstants.BYTE_TAG_BIGNUM_NEG);
            bigInteger = bigInteger.negate();
        } else {
            _writeByte(CBORConstants.BYTE_TAG_BIGNUM_POS);
        }
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        _writeLengthMarker(64, length);
        _writeBytes(byteArray, 0, length);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        _verifyValueWrite("write number");
        _ensureRoomForOutput(11);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        int i2 = i + 1;
        this._outputTail = i2;
        bArr[i] = -5;
        int i3 = (int) (jDoubleToRawLongBits >> 32);
        int i4 = i + 2;
        this._outputTail = i4;
        bArr[i2] = (byte) (i3 >> 24);
        int i5 = i + 3;
        this._outputTail = i5;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i + 4;
        this._outputTail = i6;
        bArr[i5] = (byte) (i3 >> 8);
        int i7 = i + 5;
        this._outputTail = i7;
        bArr[i6] = (byte) i3;
        int i8 = (int) jDoubleToRawLongBits;
        int i9 = i + 6;
        this._outputTail = i9;
        bArr[i7] = (byte) (i8 >> 24);
        int i10 = i + 7;
        this._outputTail = i10;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i + 8;
        this._outputTail = i11;
        bArr[i10] = (byte) (i8 >> 8);
        this._outputTail = i + 9;
        bArr[i11] = (byte) i8;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f) throws IOException {
        _ensureRoomForOutput(6);
        _verifyValueWrite("write number");
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        int i2 = i + 1;
        this._outputTail = i2;
        bArr[i] = -6;
        int i3 = i + 2;
        this._outputTail = i3;
        bArr[i2] = (byte) (iFloatToRawIntBits >> 24);
        int i4 = i + 3;
        this._outputTail = i4;
        bArr[i3] = (byte) (iFloatToRawIntBits >> 16);
        int i5 = i + 4;
        this._outputTail = i5;
        bArr[i4] = (byte) (iFloatToRawIntBits >> 8);
        this._outputTail = i + 5;
        bArr[i5] = (byte) iFloatToRawIntBits;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        if (bigDecimal == null) {
            writeNull();
            return;
        }
        _verifyValueWrite("write number");
        _writeByte(CBORConstants.BYTE_TAG_DECIMAL_FRACTION);
        _writeByte(CBORConstants.BYTE_ARRAY_2_ELEMENTS);
        _writeIntValue(-bigDecimal.scale());
        BigInteger bigIntegerUnscaledValue = bigDecimal.unscaledValue();
        int iBitLength = bigIntegerUnscaledValue.bitLength();
        if (iBitLength <= 31) {
            _writeIntValue(bigIntegerUnscaledValue.intValue());
        } else if (iBitLength <= 63) {
            _writeLongValue(bigIntegerUnscaledValue.longValue());
        } else {
            _write(bigIntegerUnscaledValue);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws UnsupportedOperationException, IOException {
        writeString(str);
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    protected final void _verifyValueWrite(String str) throws IOException {
        if (!this._cborContext.writeValue()) {
            _reportError("Can not " + str + ", expecting field name/id");
        }
        int i = this._currentRemainingElements;
        if (i != -2) {
            int i2 = i - 1;
            if (i2 < 0) {
                _failSizedArrayOrObject();
            } else {
                this._currentRemainingElements = i2;
            }
        }
    }

    private void _failSizedArrayOrObject() throws JsonGenerationException {
        _reportError(String.format("%s size mismatch: number of element encoded is not equal to reported array/map size.", this._cborContext.typeDesc()));
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public final void flush() throws IOException {
        _flushBuffer();
        if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this._out.flush();
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase, com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this._outputBuffer != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonStreamContext outputContext = getOutputContext();
                if (outputContext.inArray()) {
                    writeEndArray();
                } else if (!outputContext.inObject()) {
                    break;
                } else {
                    writeEndObject();
                }
            }
        }
        super.close();
        _flushBuffer();
        if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
            this._out.close();
        } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this._out.flush();
        }
        _releaseBuffers();
    }

    public void writeTag(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Can not write negative tag ids (" + i + ")");
        }
        _writeLengthMarker(192, i);
    }

    public void writeRaw(byte b) throws IOException {
        _writeByte(b);
    }

    public void writeBytes(byte[] bArr, int i, int i2) throws IOException {
        _writeBytes(bArr, i, i2);
    }

    protected final void _writeString(String str) throws IOException {
        int length = str.length();
        if (length == 0) {
            _writeByte(CBORConstants.BYTE_EMPTY_STRING);
            return;
        }
        if (length <= 23) {
            _ensureSpace(71);
            int i_encode = _encode(this._outputTail + 1, str, length);
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            if (i_encode <= 23) {
                bArr[i] = (byte) (i_encode + 96);
                this._outputTail = i + 1 + i_encode;
                return;
            }
            int i2 = i + 1;
            System.arraycopy(bArr, i2, bArr, i + 2, i_encode);
            bArr[i] = CBORConstants.BYTE_STRING_1BYTE_LEN;
            bArr[i2] = (byte) i_encode;
            this._outputTail = i + 2 + i_encode;
            return;
        }
        char[] cArr = this._charBuffer;
        if (length > cArr.length) {
            cArr = new char[Math.max(cArr.length + 32, length)];
            this._charBuffer = cArr;
        }
        str.getChars(0, length, cArr, 0);
        _writeString(cArr, 0, length);
    }

    protected final void _ensureSpace(int i) throws IOException {
        if (this._outputTail + i + 3 > this._outputEnd) {
            _flushBuffer();
        }
    }

    protected final void _writeString(char[] cArr, int i, int i2) throws IOException {
        if (i2 <= 23) {
            _ensureSpace(71);
            int i_encode = _encode(this._outputTail + 1, cArr, i, i2 + i);
            byte[] bArr = this._outputBuffer;
            int i3 = this._outputTail;
            if (i_encode <= 23) {
                bArr[i3] = (byte) (i_encode + 96);
                this._outputTail = i3 + 1 + i_encode;
                return;
            }
            int i4 = i3 + 1;
            System.arraycopy(bArr, i4, bArr, i3 + 2, i_encode);
            bArr[i3] = CBORConstants.BYTE_STRING_1BYTE_LEN;
            bArr[i4] = (byte) i_encode;
            this._outputTail = i3 + 2 + i_encode;
            return;
        }
        if (i2 > 255) {
            if (i2 <= 3996) {
                _ensureSpace(11991);
                int i5 = this._outputTail;
                int i_encode2 = _encode(i5 + 3, cArr, i, i2 + i);
                byte[] bArr2 = this._outputBuffer;
                bArr2[i5] = CBORConstants.BYTE_STRING_2BYTE_LEN;
                bArr2[i5 + 1] = (byte) (i_encode2 >> 8);
                bArr2[i5 + 2] = (byte) i_encode2;
                this._outputTail = i5 + 3 + i_encode2;
                return;
            }
            _writeChunkedString(cArr, i, i2);
            return;
        }
        _ensureSpace(ViewUtils.EDGE_TO_EDGE_FLAGS);
        int i_encode3 = _encode(this._outputTail + 2, cArr, i, i2 + i);
        byte[] bArr3 = this._outputBuffer;
        int i6 = this._outputTail;
        if (i_encode3 <= 255) {
            bArr3[i6] = CBORConstants.BYTE_STRING_1BYTE_LEN;
            bArr3[i6 + 1] = (byte) i_encode3;
            this._outputTail = i6 + 2 + i_encode3;
            return;
        }
        System.arraycopy(bArr3, i6 + 2, bArr3, i6 + 3, i_encode3);
        bArr3[i6] = CBORConstants.BYTE_STRING_2BYTE_LEN;
        bArr3[i6 + 1] = (byte) (i_encode3 >> 8);
        bArr3[i6 + 2] = (byte) i_encode3;
        this._outputTail = i6 + 3 + i_encode3;
    }

    protected final void _writeChunkedString(char[] cArr, int i, int i2) throws IOException {
        _writeByte((byte) 127);
        while (true) {
            int i3 = 3996;
            if (i2 <= 3996) {
                break;
            }
            _ensureSpace(11991);
            int i4 = this._outputTail;
            int i5 = i + 3996;
            char c = cArr[i + 3995];
            if (c >= 55296 && c <= 56319) {
                i5 = i + 3995;
                i3 = 3995;
            }
            int i_encode = _encode(i4 + 3, cArr, i, i5);
            byte[] bArr = this._outputBuffer;
            bArr[i4] = CBORConstants.BYTE_STRING_2BYTE_LEN;
            bArr[i4 + 1] = (byte) (i_encode >> 8);
            bArr[i4 + 2] = (byte) i_encode;
            this._outputTail = i4 + 3 + i_encode;
            i += i3;
            i2 -= i3;
        }
        if (i2 > 0) {
            _writeString(cArr, i, i2);
        }
        _writeByte((byte) -1);
    }

    private final int _encode(int i, char[] cArr, int i2, int i3) {
        byte[] bArr = this._outputBuffer;
        int i4 = i;
        int i5 = i2;
        while (true) {
            char c = cArr[i5];
            if (c > 127) {
                return _shortUTF8Encode2(cArr, i5, i3, i4, i);
            }
            int i6 = i4 + 1;
            bArr[i4] = (byte) c;
            i5++;
            if (i5 >= i3) {
                return i6 - i;
            }
            i4 = i6;
        }
    }

    private final int _shortUTF8Encode2(char[] cArr, int i, int i2, int i3, int i4) {
        byte[] bArr = this._outputBuffer;
        while (i < i2) {
            int i5 = i + 1;
            char c = cArr[i];
            if (c <= 127) {
                bArr[i3] = (byte) c;
                i3++;
            } else if (c < 2048) {
                int i6 = i3 + 1;
                bArr[i3] = (byte) ((c >> 6) | 192);
                i3 += 2;
                bArr[i6] = (byte) ((c & '?') | 128);
            } else if (c < 55296 || c > 57343) {
                bArr[i3] = (byte) ((c >> '\f') | 224);
                int i7 = i3 + 2;
                bArr[i3 + 1] = (byte) (((c >> 6) & 63) | 128);
                i3 += 3;
                bArr[i7] = (byte) ((c & '?') | 128);
            } else {
                if (c > 56319) {
                    _throwIllegalSurrogate(c);
                }
                if (i5 >= i2) {
                    _throwIllegalSurrogate(c);
                }
                i += 2;
                int i_convertSurrogate = _convertSurrogate(c, cArr[i5]);
                if (i_convertSurrogate > 1114111) {
                    _throwIllegalSurrogate(i_convertSurrogate);
                }
                bArr[i3] = (byte) ((i_convertSurrogate >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                bArr[i3 + 1] = (byte) (((i_convertSurrogate >> 12) & 63) | 128);
                int i8 = i3 + 3;
                bArr[i3 + 2] = (byte) (((i_convertSurrogate >> 6) & 63) | 128);
                i3 += 4;
                bArr[i8] = (byte) ((i_convertSurrogate & 63) | 128);
            }
            i = i5;
        }
        return i3 - i4;
    }

    private final int _encode(int i, String str, int i2) {
        byte[] bArr = this._outputBuffer;
        int i3 = i;
        int i4 = 0;
        while (i4 < i2) {
            char cCharAt = str.charAt(i4);
            if (cCharAt > 127) {
                return _encode2(i4, i3, str, i2, i);
            }
            bArr[i3] = (byte) cCharAt;
            i4++;
            i3++;
        }
        return i3 - i;
    }

    private final int _encode2(int i, int i2, String str, int i3, int i4) {
        byte[] bArr = this._outputBuffer;
        while (i < i3) {
            int i5 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt <= 127) {
                bArr[i2] = (byte) cCharAt;
                i2++;
            } else if (cCharAt < 2048) {
                int i6 = i2 + 1;
                bArr[i2] = (byte) ((cCharAt >> 6) | 192);
                i2 += 2;
                bArr[i6] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                bArr[i2] = (byte) ((cCharAt >> '\f') | 224);
                int i7 = i2 + 2;
                bArr[i2 + 1] = (byte) (((cCharAt >> 6) & 63) | 128);
                i2 += 3;
                bArr[i7] = (byte) ((cCharAt & '?') | 128);
            } else {
                if (cCharAt > 56319) {
                    _throwIllegalSurrogate(cCharAt);
                }
                if (i5 >= i3) {
                    _throwIllegalSurrogate(cCharAt);
                }
                i += 2;
                int i_convertSurrogate = _convertSurrogate(cCharAt, str.charAt(i5));
                if (i_convertSurrogate > 1114111) {
                    _throwIllegalSurrogate(i_convertSurrogate);
                }
                bArr[i2] = (byte) ((i_convertSurrogate >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                bArr[i2 + 1] = (byte) (((i_convertSurrogate >> 12) & 63) | 128);
                int i8 = i2 + 3;
                bArr[i2 + 2] = (byte) (((i_convertSurrogate >> 6) & 63) | 128);
                i2 += 4;
                bArr[i8] = (byte) ((i_convertSurrogate & 63) | 128);
            }
            i = i5;
        }
        return i2 - i4;
    }

    private int _convertSurrogate(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - 55296) << 10) + 65536 + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private void _throwIllegalSurrogate(int i) {
        if (i > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i < 55296) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        }
        if (i <= 56319) {
            throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
    }

    private final void _ensureRoomForOutput(int i) throws IOException {
        if (this._outputTail + i >= this._outputEnd) {
            _flushBuffer();
        }
    }

    private final void _writeIntValue(int i) throws IOException {
        int i2;
        if (i < 0) {
            i = (-i) - 1;
            i2 = 32;
        } else {
            i2 = 0;
        }
        _writeLengthMarker(i2, i);
    }

    private final void _writeLongValue(long j) throws IOException {
        _ensureRoomForOutput(9);
        if (j < 0) {
            j = -(j + 1);
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = 59;
        } else {
            byte[] bArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            bArr2[i2] = Ascii.ESC;
        }
        int i3 = (int) (j >> 32);
        byte[] bArr3 = this._outputBuffer;
        int i4 = this._outputTail;
        int i5 = i4 + 1;
        this._outputTail = i5;
        bArr3[i4] = (byte) (i3 >> 24);
        int i6 = i4 + 2;
        this._outputTail = i6;
        bArr3[i5] = (byte) (i3 >> 16);
        int i7 = i4 + 3;
        this._outputTail = i7;
        bArr3[i6] = (byte) (i3 >> 8);
        int i8 = i4 + 4;
        this._outputTail = i8;
        bArr3[i7] = (byte) i3;
        int i9 = (int) j;
        int i10 = i4 + 5;
        this._outputTail = i10;
        bArr3[i8] = (byte) (i9 >> 24);
        int i11 = i4 + 6;
        this._outputTail = i11;
        bArr3[i10] = (byte) (i9 >> 16);
        int i12 = i4 + 7;
        this._outputTail = i12;
        bArr3[i11] = (byte) (i9 >> 8);
        this._outputTail = i4 + 8;
        bArr3[i12] = (byte) i9;
    }

    private final void _writeLengthMarker(int i, int i2) throws IOException {
        _ensureRoomForOutput(5);
        if (i2 < 24) {
            byte[] bArr = this._outputBuffer;
            int i3 = this._outputTail;
            this._outputTail = i3 + 1;
            bArr[i3] = (byte) (i + i2);
            return;
        }
        if (i2 <= 255) {
            byte[] bArr2 = this._outputBuffer;
            int i4 = this._outputTail;
            int i5 = i4 + 1;
            this._outputTail = i5;
            bArr2[i4] = (byte) (i + 24);
            this._outputTail = i4 + 2;
            bArr2[i5] = (byte) i2;
            return;
        }
        byte b = (byte) i2;
        int i6 = i2 >> 8;
        if (i6 <= 255) {
            byte[] bArr3 = this._outputBuffer;
            int i7 = this._outputTail;
            int i8 = i7 + 1;
            this._outputTail = i8;
            bArr3[i7] = (byte) (i + 25);
            int i9 = i7 + 2;
            this._outputTail = i9;
            bArr3[i8] = (byte) i6;
            this._outputTail = i7 + 3;
            bArr3[i9] = b;
            return;
        }
        byte[] bArr4 = this._outputBuffer;
        int i10 = this._outputTail;
        int i11 = i10 + 1;
        this._outputTail = i11;
        bArr4[i10] = (byte) (i + 26);
        int i12 = i10 + 2;
        this._outputTail = i12;
        bArr4[i11] = (byte) (i2 >> 24);
        int i13 = i10 + 3;
        this._outputTail = i13;
        bArr4[i12] = (byte) (i2 >> 16);
        int i14 = i10 + 4;
        this._outputTail = i14;
        bArr4[i13] = (byte) i6;
        this._outputTail = i10 + 5;
        bArr4[i14] = b;
    }

    private final void _writeByte(byte b) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = b;
    }

    private final void _writeBytes(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return;
        }
        int i3 = this._outputTail;
        if (i3 + i2 >= this._outputEnd) {
            _writeBytesLong(bArr, i, i2);
        } else {
            System.arraycopy(bArr, i, this._outputBuffer, i3, i2);
            this._outputTail += i2;
        }
    }

    private final int _writeBytes(InputStream inputStream, int i) throws IOException {
        while (i > 0) {
            int i2 = this._outputEnd - this._outputTail;
            if (i2 <= 0) {
                _flushBuffer();
                i2 = this._outputEnd - this._outputTail;
            }
            int i3 = inputStream.read(this._outputBuffer, this._outputTail, i2);
            if (i3 < 0) {
                break;
            }
            this._outputTail += i3;
            i -= i3;
        }
        return i;
    }

    private final void _writeBytesLong(byte[] bArr, int i, int i2) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        while (true) {
            int iMin = Math.min(i2, this._outputEnd - this._outputTail);
            System.arraycopy(bArr, i, this._outputBuffer, this._outputTail, iMin);
            this._outputTail += iMin;
            i2 -= iMin;
            if (i2 == 0) {
                return;
            }
            i += iMin;
            _flushBuffer();
        }
    }

    @Override // com.fasterxml.jackson.core.base.GeneratorBase
    protected void _releaseBuffers() {
        byte[] bArr = this._outputBuffer;
        if (bArr != null && this._bufferRecyclable) {
            this._outputBuffer = null;
            this._ioContext.releaseWriteEncodingBuffer(bArr);
        }
        char[] cArr = this._charBuffer;
        if (cArr != null) {
            this._charBuffer = null;
            this._ioContext.releaseConcatBuffer(cArr);
        }
    }

    protected final void _flushBuffer() throws IOException {
        int i = this._outputTail;
        if (i > 0) {
            this._bytesWritten += i;
            this._out.write(this._outputBuffer, 0, i);
            this._outputTail = 0;
        }
    }

    private final void closeComplexElement() throws IOException {
        int i = this._currentRemainingElements;
        int i2 = -2;
        if (i == -2) {
            _writeByte((byte) -1);
        } else if (i != 0) {
            _reportError(String.format("%s size mismatch: expected %d more elements", this._cborContext.typeDesc(), Integer.valueOf(this._currentRemainingElements)));
        }
        int i3 = this._elementCountsPtr;
        if (i3 != 0) {
            int[] iArr = this._elementCounts;
            int i4 = i3 - 1;
            this._elementCountsPtr = i4;
            i2 = iArr[i4];
        }
        this._currentRemainingElements = i2;
    }

    protected UnsupportedOperationException _notSupported() {
        return new UnsupportedOperationException();
    }
}
