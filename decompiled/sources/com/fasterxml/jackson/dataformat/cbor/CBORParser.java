package com.fasterxml.jackson.dataformat.cbor;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes3.dex */
public class CBORParser extends ParserMinimalBase {
    static final BigDecimal BD_MAX_INT;
    static final BigDecimal BD_MAX_LONG;
    static final BigDecimal BD_MIN_INT;
    static final BigDecimal BD_MIN_LONG;
    private static final BigInteger BIT_63;
    static final BigInteger BI_MAX_INT;
    static final BigInteger BI_MAX_LONG;
    static final BigInteger BI_MIN_INT;
    static final BigInteger BI_MIN_LONG;
    protected byte[] _binaryValue;
    protected boolean _bufferRecyclable;
    protected ByteArrayBuilder _byteArrayBuilder;
    private int _chunkEnd;
    private int _chunkLeft;
    protected boolean _closed;
    protected long _currInputProcessed;
    protected int _currInputRow;
    protected int _currInputRowStart;
    protected byte[] _inputBuffer;
    protected int _inputEnd;
    protected int _inputPtr;
    protected InputStream _inputStream;
    protected final IOContext _ioContext;
    protected boolean _nameCopied;
    protected char[] _nameCopyBuffer;
    protected int _numTypesValid;
    protected BigDecimal _numberBigDecimal;
    protected BigInteger _numberBigInt;
    protected double _numberDouble;
    protected float _numberFloat;
    protected int _numberInt;
    protected long _numberLong;
    protected ObjectCodec _objectCodec;
    protected CBORReadContext _parsingContext;
    protected int _quad1;
    protected int _quad2;
    protected int _quad3;
    protected int[] _quadBuffer;
    protected final ByteQuadsCanonicalizer _symbols;
    protected int _tagValue;
    protected final TextBuffer _textBuffer;
    protected boolean _tokenIncomplete;
    protected int _tokenInputCol;
    protected int _tokenInputRow;
    protected long _tokenInputTotal;
    protected int _typeByte;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final int[] UTF8_UNIT_CODES = CBORConstants.sUtf8UnitLengths;
    private static final double MATH_POW_2_10 = Math.pow(2.0d, 10.0d);
    private static final double MATH_POW_2_NEG14 = Math.pow(2.0d, -14.0d);

    private static final long _long(int i, int i2) {
        return (i << 32) + ((i2 << 32) >>> 32);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getFormatFeatures() {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() throws IOException {
        return 0;
    }

    public enum Feature implements FormatFeature {
        ;

        final boolean _defaultState;
        final int _mask;

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature
        public boolean enabledByDefault() {
            return this._defaultState;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature
        public int getMask() {
            return this._mask;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature
        public boolean enabledIn(int i) {
            return (this._mask & i) != 0;
        }
    }

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(-2147483648L);
        BI_MIN_INT = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2147483647L);
        BI_MAX_INT = bigIntegerValueOf2;
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        BI_MIN_LONG = bigIntegerValueOf3;
        BigInteger bigIntegerValueOf4 = BigInteger.valueOf(Long.MAX_VALUE);
        BI_MAX_LONG = bigIntegerValueOf4;
        BD_MIN_LONG = new BigDecimal(bigIntegerValueOf3);
        BD_MAX_LONG = new BigDecimal(bigIntegerValueOf4);
        BD_MIN_INT = new BigDecimal(bigIntegerValueOf);
        BD_MAX_INT = new BigDecimal(bigIntegerValueOf2);
        BIT_63 = BigInteger.ONE.shiftLeft(63);
    }

    public CBORParser(IOContext iOContext, int i, int i2, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer, InputStream inputStream, byte[] bArr, int i3, int i4, boolean z) {
        super(i);
        this._currInputProcessed = 0L;
        this._currInputRow = 1;
        this._currInputRowStart = 0;
        this._tokenInputTotal = 0L;
        this._tokenInputRow = 1;
        this._tokenInputCol = 0;
        this._nameCopyBuffer = null;
        this._nameCopied = false;
        this._byteArrayBuilder = null;
        this._tagValue = -1;
        this._tokenIncomplete = false;
        this._quadBuffer = ParserMinimalBase.NO_INTS;
        this._numTypesValid = 0;
        this._ioContext = iOContext;
        this._objectCodec = objectCodec;
        this._symbols = byteQuadsCanonicalizer;
        this._inputStream = inputStream;
        this._inputBuffer = bArr;
        this._inputPtr = i3;
        this._inputEnd = i4;
        this._bufferRecyclable = z;
        this._textBuffer = iOContext.constructTextBuffer();
        this._parsingContext = CBORReadContext.createRootContext(JsonParser.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(i) ? DupDetector.rootDetector(this) : null);
        this._tokenInputRow = -1;
        this._tokenInputCol = -1;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }

    @Override // com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    public int getCurrentTag() {
        return this._tagValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(OutputStream outputStream) throws IOException {
        int i = this._inputEnd;
        int i2 = this._inputPtr;
        int i3 = i - i2;
        if (i3 < 1) {
            return 0;
        }
        outputStream.write(this._inputBuffer, i2, i3);
        return i3;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this._inputStream;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        Object sourceReference = this._ioContext.getSourceReference();
        long j = this._tokenInputTotal;
        return new JsonLocation(sourceReference, j, -1L, -1, (int) j);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        long j = this._currInputProcessed + this._inputPtr;
        return new JsonLocation(this._ioContext.getSourceReference(), j, -1L, -1, (int) j);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getCurrentName() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            return this._parsingContext.getParent().getCurrentName();
        }
        return this._parsingContext.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public void overrideCurrentName(String str) {
        CBORReadContext parent = this._parsingContext;
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.START_OBJECT || jsonToken == JsonToken.START_ARRAY) {
            parent = parent.getParent();
        }
        try {
            parent.setCurrentName(str);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this._closed) {
            return;
        }
        this._closed = true;
        this._symbols.release();
        try {
            _closeInput();
        } finally {
            _releaseBuffers();
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public boolean isClosed() {
        return this._closed;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public CBORReadContext getParsingContext() {
        return this._parsingContext;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.hasTextAsCharacters();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this._nameCopied;
        }
        return false;
    }

    protected void _releaseBuffers() throws IOException {
        byte[] bArr;
        if (this._bufferRecyclable && (bArr = this._inputBuffer) != null) {
            this._inputBuffer = null;
            this._ioContext.releaseReadIOBuffer(bArr);
        }
        this._textBuffer.releaseBuffers();
        char[] cArr = this._nameCopyBuffer;
        if (cArr != null) {
            this._nameCopyBuffer = null;
            this._ioContext.releaseNameCopyBuffer(cArr);
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
        this._numTypesValid = 0;
        if (this._tokenIncomplete) {
            _skipIncomplete();
        }
        this._tokenInputTotal = this._currInputProcessed + this._inputPtr;
        this._binaryValue = null;
        if (this._parsingContext.inObject()) {
            if (this._currToken != JsonToken.FIELD_NAME) {
                this._tagValue = -1;
                if (!this._parsingContext.expectMoreValues()) {
                    this._parsingContext = this._parsingContext.getParent();
                    JsonToken jsonToken = JsonToken.END_OBJECT;
                    this._currToken = jsonToken;
                    return jsonToken;
                }
                JsonToken jsonToken_decodeFieldName = _decodeFieldName();
                this._currToken = jsonToken_decodeFieldName;
                return jsonToken_decodeFieldName;
            }
        } else if (!this._parsingContext.expectMoreValues()) {
            this._tagValue = -1;
            this._parsingContext = this._parsingContext.getParent();
            JsonToken jsonToken2 = JsonToken.END_ARRAY;
            this._currToken = jsonToken2;
            return jsonToken2;
        }
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            return _handleCBOREOF();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        int i2 = (b >> 5) & 7;
        if (i2 == 6) {
            this._tagValue = _decodeTag(b & Ascii.US);
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                return _handleCBOREOF();
            }
            byte[] bArr2 = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            b = bArr2[i3];
            i2 = (b >> 5) & 7;
        } else {
            this._tagValue = -1;
        }
        int i4 = b & Ascii.US;
        switch (i2) {
            case 0:
                this._numTypesValid = 1;
                if (i4 <= 23) {
                    this._numberInt = i4;
                } else {
                    int i5 = i4 - 24;
                    if (i5 == 0) {
                        this._numberInt = _decode8Bits();
                    } else if (i5 == 1) {
                        this._numberInt = _decode16Bits();
                    } else if (i5 == 2) {
                        int i_decode32Bits = _decode32Bits();
                        if (i_decode32Bits >= 0) {
                            this._numberInt = i_decode32Bits;
                        } else {
                            this._numberLong = i_decode32Bits & BodyPartID.bodyIdMax;
                            this._numTypesValid = 2;
                        }
                    } else if (i5 == 3) {
                        long j_decode64Bits = _decode64Bits();
                        if (j_decode64Bits >= 0) {
                            this._numberLong = j_decode64Bits;
                            this._numTypesValid = 2;
                        } else {
                            this._numberBigInt = _bigPositive(j_decode64Bits);
                            this._numTypesValid = 4;
                        }
                    } else {
                        _invalidToken(b);
                    }
                }
                JsonToken jsonToken3 = JsonToken.VALUE_NUMBER_INT;
                this._currToken = jsonToken3;
                return jsonToken3;
            case 1:
                this._numTypesValid = 1;
                if (i4 <= 23) {
                    this._numberInt = (-i4) - 1;
                } else {
                    int i6 = i4 - 24;
                    if (i6 == 0) {
                        this._numberInt = (-_decode8Bits()) - 1;
                    } else if (i6 == 1) {
                        this._numberInt = (-_decode16Bits()) - 1;
                    } else if (i6 == 2) {
                        int i_decode32Bits2 = _decode32Bits();
                        if (i_decode32Bits2 < 0) {
                            this._numberLong = (-(i_decode32Bits2 & BodyPartID.bodyIdMax)) - 1;
                            this._numTypesValid = 2;
                        } else {
                            this._numberInt = (-i_decode32Bits2) - 1;
                        }
                    } else if (i6 == 3) {
                        long j_decode64Bits2 = _decode64Bits();
                        if (j_decode64Bits2 >= 0) {
                            this._numberLong = (-j_decode64Bits2) - 1;
                            this._numTypesValid = 2;
                        } else {
                            this._numberBigInt = _bigNegative(j_decode64Bits2);
                            this._numTypesValid = 4;
                        }
                    } else {
                        _invalidToken(b);
                    }
                }
                JsonToken jsonToken4 = JsonToken.VALUE_NUMBER_INT;
                this._currToken = jsonToken4;
                return jsonToken4;
            case 2:
                this._typeByte = b;
                this._tokenIncomplete = true;
                int i7 = this._tagValue;
                if (i7 >= 0) {
                    return _handleTaggedBinary(i7);
                }
                JsonToken jsonToken5 = JsonToken.VALUE_EMBEDDED_OBJECT;
                this._currToken = jsonToken5;
                return jsonToken5;
            case 3:
                this._typeByte = b;
                this._tokenIncomplete = true;
                JsonToken jsonToken6 = JsonToken.VALUE_STRING;
                this._currToken = jsonToken6;
                return jsonToken6;
            case 4:
                int i_decodeExplicitLength = _decodeExplicitLength(i4);
                int i8 = this._tagValue;
                if (i8 >= 0) {
                    return _handleTaggedArray(i8, i_decodeExplicitLength);
                }
                this._parsingContext = this._parsingContext.createChildArrayContext(i_decodeExplicitLength);
                JsonToken jsonToken7 = JsonToken.START_ARRAY;
                this._currToken = jsonToken7;
                return jsonToken7;
            case 5:
                this._currToken = JsonToken.START_OBJECT;
                this._parsingContext = this._parsingContext.createChildObjectContext(_decodeExplicitLength(i4));
                return this._currToken;
            case 6:
                _reportError("Multiple tags not allowed per value (first tag: " + this._tagValue + ")");
                break;
        }
        switch (i4) {
            case 20:
                JsonToken jsonToken8 = JsonToken.VALUE_FALSE;
                this._currToken = jsonToken8;
                return jsonToken8;
            case 21:
                JsonToken jsonToken9 = JsonToken.VALUE_TRUE;
                this._currToken = jsonToken9;
                return jsonToken9;
            case 22:
                JsonToken jsonToken10 = JsonToken.VALUE_NULL;
                this._currToken = jsonToken10;
                return jsonToken10;
            case 23:
                JsonToken jsonToken_decodeUndefinedValue = _decodeUndefinedValue();
                this._currToken = jsonToken_decodeUndefinedValue;
                return jsonToken_decodeUndefinedValue;
            case 25:
                this._numberFloat = _decodeHalfSizeFloat();
                this._numTypesValid = 32;
                JsonToken jsonToken11 = JsonToken.VALUE_NUMBER_FLOAT;
                this._currToken = jsonToken11;
                return jsonToken11;
            case 26:
                this._numberFloat = Float.intBitsToFloat(_decode32Bits());
                this._numTypesValid = 32;
                JsonToken jsonToken12 = JsonToken.VALUE_NUMBER_FLOAT;
                this._currToken = jsonToken12;
                return jsonToken12;
            case 27:
                this._numberDouble = Double.longBitsToDouble(_decode64Bits());
                this._numTypesValid = 8;
                JsonToken jsonToken13 = JsonToken.VALUE_NUMBER_FLOAT;
                this._currToken = jsonToken13;
                return jsonToken13;
            case 31:
                if (this._parsingContext.inArray() && !this._parsingContext.hasExpectedLength()) {
                    this._parsingContext = this._parsingContext.getParent();
                    JsonToken jsonToken14 = JsonToken.END_ARRAY;
                    this._currToken = jsonToken14;
                    return jsonToken14;
                }
                _reportUnexpectedBreak();
                break;
        }
        _invalidToken(b);
        return null;
    }

    protected String _numberToName(int i, boolean z) throws IOException {
        int i_decode8Bits = i & 31;
        if (i_decode8Bits > 23) {
            switch (i_decode8Bits) {
                case 24:
                    i_decode8Bits = _decode8Bits();
                    break;
                case 25:
                    i_decode8Bits = _decode16Bits();
                    break;
                case 26:
                    i_decode8Bits = _decode32Bits();
                    break;
                case 27:
                    long j_decode64Bits = _decode64Bits();
                    if (z) {
                        j_decode64Bits = (-j_decode64Bits) - 1;
                    }
                    return String.valueOf(j_decode64Bits);
                default:
                    throw _constructError("Invalid length indicator for ints (" + i_decode8Bits + "), token 0x" + Integer.toHexString(i));
            }
        }
        if (z) {
            i_decode8Bits = (-i_decode8Bits) - 1;
        }
        return String.valueOf(i_decode8Bits);
    }

    protected JsonToken _handleTaggedBinary(int i) throws IOException {
        boolean z;
        if (i == 2) {
            z = false;
        } else {
            if (i != 3) {
                JsonToken jsonToken = JsonToken.VALUE_EMBEDDED_OBJECT;
                this._currToken = jsonToken;
                return jsonToken;
            }
            z = true;
        }
        _finishToken();
        BigInteger bigInteger = new BigInteger(this._binaryValue);
        if (z) {
            bigInteger = bigInteger.negate();
        }
        this._numberBigInt = bigInteger;
        this._numTypesValid = 4;
        this._tagValue = -1;
        JsonToken jsonToken2 = JsonToken.VALUE_NUMBER_INT;
        this._currToken = jsonToken2;
        return jsonToken2;
    }

    protected JsonToken _handleTaggedArray(int i, int i2) throws IOException {
        BigDecimal bigDecimalValueOf;
        this._parsingContext = this._parsingContext.createChildArrayContext(i2);
        if (i != 4) {
            JsonToken jsonToken = JsonToken.START_ARRAY;
            this._currToken = jsonToken;
            return jsonToken;
        }
        this._currToken = JsonToken.START_ARRAY;
        if (i2 != 2) {
            _reportError("Unexpected array size (" + i2 + ") for tagged 'bigfloat' value; should have exactly 2 number elements");
        }
        JsonToken jsonTokenNextToken = nextToken();
        JsonToken jsonToken2 = JsonToken.VALUE_NUMBER_INT;
        if (jsonTokenNextToken != jsonToken2) {
            _reportError("Unexpected token (" + jsonTokenNextToken + ") as the first part of 'bigfloat' value: should get VALUE_NUMBER_INT");
        }
        int i3 = -getIntValue();
        JsonToken jsonTokenNextToken2 = nextToken();
        if (jsonTokenNextToken2 != jsonToken2) {
            _reportError("Unexpected token (" + jsonTokenNextToken2 + ") as the second part of 'bigfloat' value: should get VALUE_NUMBER_INT");
        }
        if (getNumberType() == JsonParser.NumberType.BIG_INTEGER) {
            bigDecimalValueOf = new BigDecimal(getBigIntegerValue(), i3);
        } else {
            bigDecimalValueOf = BigDecimal.valueOf(getLongValue(), i3);
        }
        JsonToken jsonTokenNextToken3 = nextToken();
        if (jsonTokenNextToken3 != JsonToken.END_ARRAY) {
            _reportError("Unexpected token (" + jsonTokenNextToken3 + ") after 2 elements of 'bigfloat' value");
        }
        this._numberBigDecimal = bigDecimalValueOf;
        this._numTypesValid = 16;
        JsonToken jsonToken3 = JsonToken.VALUE_NUMBER_FLOAT;
        this._currToken = jsonToken3;
        return jsonToken3;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void finishToken() throws IOException {
        if (this._tokenIncomplete) {
            _finishToken();
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean nextFieldName(SerializableString serializableString) throws IOException {
        int i;
        if (this._parsingContext.inObject() && this._currToken != JsonToken.FIELD_NAME) {
            this._numTypesValid = 0;
            if (this._tokenIncomplete) {
                _skipIncomplete();
            }
            this._tokenInputTotal = this._currInputProcessed + this._inputPtr;
            this._binaryValue = null;
            this._tagValue = -1;
            if (!this._parsingContext.expectMoreValues()) {
                this._parsingContext = this._parsingContext.getParent();
                this._currToken = JsonToken.END_OBJECT;
                return false;
            }
            byte[] bArrAsQuotedUTF8 = serializableString.asQuotedUTF8();
            int length = bArrAsQuotedUTF8.length;
            int i2 = this._inputPtr;
            if (i2 + length + 1 < this._inputEnd) {
                byte[] bArr = this._inputBuffer;
                int i3 = i2 + 1;
                byte b = bArr[i2];
                if (((b >> 5) & 7) == 3 && (i = b & Ascii.US) <= 24) {
                    if (i == 23) {
                        i = bArr[i3] & 255;
                        i3 = i2 + 2;
                    }
                    if (i == length) {
                        int i4 = 0;
                        while (i4 != i) {
                            if (bArrAsQuotedUTF8[i4] == this._inputBuffer[i3 + i4]) {
                                i4++;
                            }
                        }
                        this._inputPtr = i3 + i4;
                        this._parsingContext.setCurrentName(serializableString.getValue());
                        this._currToken = JsonToken.FIELD_NAME;
                        return true;
                    }
                }
            }
        }
        return nextToken() == JsonToken.FIELD_NAME && serializableString.getValue().equals(getCurrentName());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextFieldName() throws IOException {
        String str_decodeLongerName;
        if (this._parsingContext.inObject()) {
            JsonToken jsonToken = this._currToken;
            JsonToken jsonToken2 = JsonToken.FIELD_NAME;
            if (jsonToken != jsonToken2) {
                this._numTypesValid = 0;
                if (this._tokenIncomplete) {
                    _skipIncomplete();
                }
                this._tokenInputTotal = this._currInputProcessed + this._inputPtr;
                this._binaryValue = null;
                this._tagValue = -1;
                if (!this._parsingContext.expectMoreValues()) {
                    this._parsingContext = this._parsingContext.getParent();
                    this._currToken = JsonToken.END_OBJECT;
                    return null;
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                byte b = bArr[i];
                if (((b >> 5) & 7) != 3) {
                    if (b == -1) {
                        if (!this._parsingContext.hasExpectedLength()) {
                            this._parsingContext = this._parsingContext.getParent();
                            this._currToken = JsonToken.END_OBJECT;
                            return null;
                        }
                        _reportUnexpectedBreak();
                    }
                    _decodeNonStringName(b);
                    this._currToken = jsonToken2;
                    return getText();
                }
                int i2 = b & Ascii.US;
                if (i2 > 23) {
                    int i_decodeExplicitLength = _decodeExplicitLength(i2);
                    if (i_decodeExplicitLength < 0) {
                        str_decodeLongerName = _decodeChunkedName();
                    } else {
                        str_decodeLongerName = _decodeLongerName(i_decodeExplicitLength);
                    }
                } else if (i2 == 0) {
                    str_decodeLongerName = "";
                } else {
                    String str_findDecodedFromSymbols = _findDecodedFromSymbols(i2);
                    if (str_findDecodedFromSymbols != null) {
                        this._inputPtr += i2;
                        str_decodeLongerName = str_findDecodedFromSymbols;
                    } else {
                        str_decodeLongerName = _addDecodedToSymbols(i2, _decodeShortName(i2));
                    }
                }
                this._parsingContext.setCurrentName(str_decodeLongerName);
                this._currToken = jsonToken2;
                return str_decodeLongerName;
            }
        }
        if (nextToken() == JsonToken.FIELD_NAME) {
            return getCurrentName();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextTextValue() throws IOException {
        this._numTypesValid = 0;
        if (this._tokenIncomplete) {
            _skipIncomplete();
        }
        this._tokenInputTotal = this._currInputProcessed + this._inputPtr;
        this._binaryValue = null;
        this._tagValue = -1;
        if (this._parsingContext.inObject()) {
            if (this._currToken != JsonToken.FIELD_NAME) {
                this._tagValue = -1;
                if (!this._parsingContext.expectMoreValues()) {
                    this._parsingContext = this._parsingContext.getParent();
                    this._currToken = JsonToken.END_OBJECT;
                    return null;
                }
                this._currToken = _decodeFieldName();
                return null;
            }
        } else if (!this._parsingContext.expectMoreValues()) {
            this._tagValue = -1;
            this._parsingContext = this._parsingContext.getParent();
            this._currToken = JsonToken.END_ARRAY;
            return null;
        }
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _handleCBOREOF();
            return null;
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        int i2 = (b >> 5) & 7;
        if (i2 == 6) {
            this._tagValue = _decodeTag(b & Ascii.US);
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _handleCBOREOF();
                return null;
            }
            byte[] bArr2 = this._inputBuffer;
            int i3 = this._inputPtr;
            this._inputPtr = i3 + 1;
            b = bArr2[i3];
            i2 = (b >> 5) & 7;
        } else {
            this._tagValue = -1;
        }
        int i4 = b & Ascii.US;
        switch (i2) {
            case 0:
                this._numTypesValid = 1;
                if (i4 <= 23) {
                    this._numberInt = i4;
                } else {
                    int i5 = i4 - 24;
                    if (i5 == 0) {
                        this._numberInt = _decode8Bits();
                    } else if (i5 == 1) {
                        this._numberInt = _decode16Bits();
                    } else if (i5 == 2) {
                        int i_decode32Bits = _decode32Bits();
                        if (i_decode32Bits < 0) {
                            this._numberLong = i_decode32Bits & BodyPartID.bodyIdMax;
                            this._numTypesValid = 2;
                        } else {
                            this._numberInt = i_decode32Bits;
                        }
                    } else if (i5 == 3) {
                        long j_decode64Bits = _decode64Bits();
                        if (j_decode64Bits >= 0) {
                            this._numberLong = j_decode64Bits;
                            this._numTypesValid = 2;
                        } else {
                            this._numberBigInt = _bigPositive(j_decode64Bits);
                            this._numTypesValid = 4;
                        }
                    } else {
                        _invalidToken(b);
                    }
                }
                this._currToken = JsonToken.VALUE_NUMBER_INT;
                return null;
            case 1:
                this._numTypesValid = 1;
                if (i4 <= 23) {
                    this._numberInt = (-i4) - 1;
                } else {
                    int i6 = i4 - 24;
                    if (i6 == 0) {
                        this._numberInt = (-_decode8Bits()) - 1;
                    } else if (i6 == 1) {
                        this._numberInt = (-_decode16Bits()) - 1;
                    } else if (i6 == 2) {
                        int i_decode32Bits2 = _decode32Bits();
                        if (i_decode32Bits2 < 0) {
                            this._numberLong = (-(i_decode32Bits2 & BodyPartID.bodyIdMax)) - 1;
                            this._numTypesValid = 2;
                        } else {
                            this._numberInt = (-i_decode32Bits2) - 1;
                        }
                    } else if (i6 == 3) {
                        long j_decode64Bits2 = _decode64Bits();
                        if (j_decode64Bits2 >= 0) {
                            this._numberLong = j_decode64Bits2;
                            this._numTypesValid = 2;
                        } else {
                            this._numberBigInt = _bigNegative(j_decode64Bits2);
                            this._numTypesValid = 4;
                        }
                    } else {
                        _invalidToken(b);
                    }
                }
                this._currToken = JsonToken.VALUE_NUMBER_INT;
                return null;
            case 2:
                this._typeByte = b;
                this._tokenIncomplete = true;
                this._currToken = JsonToken.VALUE_EMBEDDED_OBJECT;
                return null;
            case 3:
                this._typeByte = b;
                this._tokenIncomplete = true;
                this._currToken = JsonToken.VALUE_STRING;
                return _finishTextToken(b);
            case 4:
                this._currToken = JsonToken.START_ARRAY;
                this._parsingContext = this._parsingContext.createChildArrayContext(_decodeExplicitLength(i4));
                return null;
            case 5:
                this._currToken = JsonToken.START_OBJECT;
                this._parsingContext = this._parsingContext.createChildObjectContext(_decodeExplicitLength(i4));
                return null;
            case 6:
                _reportError("Multiple tags not allowed per value (first tag: " + this._tagValue + ")");
                break;
        }
        switch (i4) {
            case 20:
                this._currToken = JsonToken.VALUE_FALSE;
                return null;
            case 21:
                this._currToken = JsonToken.VALUE_TRUE;
                return null;
            case 22:
                this._currToken = JsonToken.VALUE_NULL;
                return null;
            case 23:
                this._currToken = _decodeUndefinedValue();
                return null;
            case 25:
                this._numberFloat = _decodeHalfSizeFloat();
                this._numTypesValid = 32;
                this._currToken = JsonToken.VALUE_NUMBER_FLOAT;
                return null;
            case 26:
                this._numberFloat = Float.intBitsToFloat(_decode32Bits());
                this._numTypesValid = 32;
                this._currToken = JsonToken.VALUE_NUMBER_FLOAT;
                return null;
            case 27:
                this._numberDouble = Double.longBitsToDouble(_decode64Bits());
                this._numTypesValid = 8;
                this._currToken = JsonToken.VALUE_NUMBER_FLOAT;
                return null;
            case 31:
                if (this._parsingContext.inArray() && !this._parsingContext.hasExpectedLength()) {
                    this._parsingContext = this._parsingContext.getParent();
                    this._currToken = JsonToken.END_ARRAY;
                    return null;
                }
                _reportUnexpectedBreak();
                break;
        }
        _invalidToken(b);
        if (nextToken() == JsonToken.VALUE_STRING) {
            return getText();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int nextIntValue(int i) throws IOException {
        return nextToken() == JsonToken.VALUE_NUMBER_INT ? getIntValue() : i;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long nextLongValue(long j) throws IOException {
        return nextToken() == JsonToken.VALUE_NUMBER_INT ? getLongValue() : j;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Boolean nextBooleanValue() throws IOException {
        JsonToken jsonTokenNextToken = nextToken();
        if (jsonTokenNextToken == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (jsonTokenNextToken == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (this._tokenIncomplete && jsonToken == JsonToken.VALUE_STRING) {
            return _finishTextToken(this._typeByte);
        }
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.contentsAsString();
        }
        if (jsonToken == null) {
            return null;
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this._parsingContext.getCurrentName();
        }
        if (jsonToken.isNumeric()) {
            return getNumberValue().toString();
        }
        return this._currToken.asString();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException {
        if (this._currToken == null) {
            return null;
        }
        if (this._tokenIncomplete) {
            _finishToken();
        }
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.getTextBuffer();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this._parsingContext.getCurrentName().toCharArray();
        }
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return getNumberValue().toString().toCharArray();
        }
        return jsonToken.asCharArray();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        if (this._currToken == null) {
            return 0;
        }
        if (this._tokenIncomplete) {
            _finishToken();
        }
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.size();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this._parsingContext.getCurrentName().length();
        }
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return getNumberValue().toString().length();
        }
        return jsonToken.asCharArray().length;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws IOException {
        if (this._tokenIncomplete && this._currToken == JsonToken.VALUE_STRING) {
            return _finishTextToken(this._typeByte);
        }
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.contentsAsString();
        }
        if (jsonToken == null || jsonToken == JsonToken.VALUE_NULL || !jsonToken.isScalarValue()) {
            return null;
        }
        return getText();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException {
        JsonToken jsonToken = this._currToken;
        return (jsonToken == JsonToken.VALUE_STRING || !(jsonToken == null || jsonToken == JsonToken.VALUE_NULL || !jsonToken.isScalarValue())) ? getText() : str;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getText(Writer writer) throws IOException {
        if (this._tokenIncomplete) {
            _finishToken();
        }
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this._textBuffer.contentsToWriter(writer);
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            String currentName = this._parsingContext.getCurrentName();
            writer.write(currentName);
            return currentName.length();
        }
        if (jsonToken == null) {
            return 0;
        }
        if (jsonToken.isNumeric()) {
            return this._textBuffer.contentsToWriter(writer);
        }
        char[] cArrAsCharArray = jsonToken.asCharArray();
        writer.write(cArrAsCharArray);
        return cArrAsCharArray.length;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        if (this._tokenIncomplete) {
            _finishToken();
        }
        if (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT) {
            _reportError("Current token (" + getCurrentToken() + ") not VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        return this._binaryValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException {
        if (this._tokenIncomplete) {
            _finishToken();
        }
        if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
            return this._binaryValue;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        if (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT) {
            _reportError("Current token (" + getCurrentToken() + ") not VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        int i_readAndWriteBytes = 0;
        if (!this._tokenIncomplete) {
            byte[] bArr = this._binaryValue;
            if (bArr == null) {
                return 0;
            }
            int length = bArr.length;
            outputStream.write(bArr, 0, length);
            return length;
        }
        this._tokenIncomplete = false;
        int i_decodeExplicitLength = _decodeExplicitLength(this._typeByte & 31);
        if (i_decodeExplicitLength >= 0) {
            return _readAndWriteBytes(outputStream, i_decodeExplicitLength);
        }
        while (true) {
            int i_decodeChunkLength = _decodeChunkLength(2);
            if (i_decodeChunkLength < 0) {
                return i_readAndWriteBytes;
            }
            i_readAndWriteBytes += _readAndWriteBytes(outputStream, i_decodeChunkLength);
        }
    }

    private int _readAndWriteBytes(OutputStream outputStream, int i) throws IOException {
        int i2 = i;
        while (i2 > 0) {
            int i3 = this._inputEnd;
            int i4 = this._inputPtr;
            int i5 = i3 - i4;
            if (i4 >= i3) {
                loadMoreGuaranteed();
                i5 = this._inputEnd - this._inputPtr;
            }
            int iMin = Math.min(i5, i2);
            outputStream.write(this._inputBuffer, this._inputPtr, iMin);
            this._inputPtr += iMin;
            i2 -= iMin;
        }
        this._tokenIncomplete = false;
        return i;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean isNaN() {
        if (this._currToken != JsonToken.VALUE_NUMBER_FLOAT) {
            return false;
        }
        int i = this._numTypesValid;
        if ((i & 8) != 0) {
            double d = this._numberDouble;
            return Double.isNaN(d) || Double.isInfinite(d);
        }
        if ((i & 32) == 0) {
            return false;
        }
        float f = this._numberFloat;
        return Float.isNaN(f) || Float.isInfinite(f);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() throws IOException {
        if (this._numTypesValid == 0) {
            _checkNumericValue(0);
        }
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int i = this._numTypesValid;
            if ((i & 1) != 0) {
                return Integer.valueOf(this._numberInt);
            }
            if ((i & 2) != 0) {
                return Long.valueOf(this._numberLong);
            }
            if ((i & 4) != 0) {
                return this._numberBigInt;
            }
            return this._numberBigDecimal;
        }
        int i2 = this._numTypesValid;
        if ((i2 & 16) != 0) {
            return this._numberBigDecimal;
        }
        if ((i2 & 8) != 0) {
            return Double.valueOf(this._numberDouble);
        }
        if ((i2 & 32) == 0) {
            _throwInternal();
        }
        return Float.valueOf(this._numberFloat);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws IOException {
        if (this._numTypesValid == 0) {
            _checkNumericValue(0);
        }
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int i = this._numTypesValid;
            if ((i & 1) != 0) {
                return JsonParser.NumberType.INT;
            }
            if ((i & 2) != 0) {
                return JsonParser.NumberType.LONG;
            }
            return JsonParser.NumberType.BIG_INTEGER;
        }
        int i2 = this._numTypesValid;
        if ((i2 & 16) != 0) {
            return JsonParser.NumberType.BIG_DECIMAL;
        }
        if ((i2 & 8) != 0) {
            return JsonParser.NumberType.DOUBLE;
        }
        return JsonParser.NumberType.FLOAT;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getIntValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 1) == 0) {
            if (i == 0) {
                _checkNumericValue(1);
            }
            if ((this._numTypesValid & 1) == 0) {
                convertNumberToInt();
            }
        }
        return this._numberInt;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public long getLongValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 2) == 0) {
            if (i == 0) {
                _checkNumericValue(2);
            }
            if ((this._numTypesValid & 2) == 0) {
                convertNumberToLong();
            }
        }
        return this._numberLong;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 4) == 0) {
            if (i == 0) {
                _checkNumericValue(4);
            }
            if ((this._numTypesValid & 4) == 0) {
                convertNumberToBigInteger();
            }
        }
        return this._numberBigInt;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 32) == 0) {
            if (i == 0) {
                _checkNumericValue(32);
            }
            if ((this._numTypesValid & 32) == 0) {
                convertNumberToFloat();
            }
        }
        return this._numberFloat;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 8) == 0) {
            if (i == 0) {
                _checkNumericValue(8);
            }
            if ((this._numTypesValid & 8) == 0) {
                convertNumberToDouble();
            }
        }
        return this._numberDouble;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        int i = this._numTypesValid;
        if ((i & 16) == 0) {
            if (i == 0) {
                _checkNumericValue(16);
            }
            if ((this._numTypesValid & 16) == 0) {
                convertNumberToBigDecimal();
            }
        }
        return this._numberBigDecimal;
    }

    protected void _checkNumericValue(int i) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT || jsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return;
        }
        _reportError("Current token (" + getCurrentToken() + ") not numeric, can not use numeric value accessors");
    }

    protected void convertNumberToInt() throws IOException {
        int i = this._numTypesValid;
        if ((i & 2) != 0) {
            long j = this._numberLong;
            int i2 = (int) j;
            if (i2 != j) {
                _reportError("Numeric value (" + getText() + ") out of range of int");
            }
            this._numberInt = i2;
        } else if ((i & 4) != 0) {
            if (BI_MIN_INT.compareTo(this._numberBigInt) > 0 || BI_MAX_INT.compareTo(this._numberBigInt) < 0) {
                reportOverflowInt();
            }
            this._numberInt = this._numberBigInt.intValue();
        } else if ((i & 8) != 0) {
            double d = this._numberDouble;
            if (d < -2.147483648E9d || d > 2.147483647E9d) {
                reportOverflowInt();
            }
            this._numberInt = (int) this._numberDouble;
        } else if ((i & 32) != 0) {
            float f = this._numberFloat;
            if (f < -2.147483648E9d || f > 2.147483647E9d) {
                reportOverflowInt();
            }
            this._numberInt = (int) this._numberFloat;
        } else if ((i & 16) != 0) {
            if (BD_MIN_INT.compareTo(this._numberBigDecimal) > 0 || BD_MAX_INT.compareTo(this._numberBigDecimal) < 0) {
                reportOverflowInt();
            }
            this._numberInt = this._numberBigDecimal.intValue();
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 1;
    }

    protected void convertNumberToLong() throws IOException {
        int i = this._numTypesValid;
        if ((i & 1) != 0) {
            this._numberLong = this._numberInt;
        } else if ((i & 4) != 0) {
            if (BI_MIN_LONG.compareTo(this._numberBigInt) > 0 || BI_MAX_LONG.compareTo(this._numberBigInt) < 0) {
                reportOverflowLong();
            }
            this._numberLong = this._numberBigInt.longValue();
        } else if ((i & 8) != 0) {
            double d = this._numberDouble;
            if (d < -9.223372036854776E18d || d > 9.223372036854776E18d) {
                reportOverflowLong();
            }
            this._numberLong = (long) this._numberDouble;
        } else if ((i & 32) != 0) {
            float f = this._numberFloat;
            if (f < -9.223372036854776E18d || f > 9.223372036854776E18d) {
                reportOverflowInt();
            }
            this._numberLong = (long) this._numberFloat;
        } else if ((i & 16) != 0) {
            if (BD_MIN_LONG.compareTo(this._numberBigDecimal) > 0 || BD_MAX_LONG.compareTo(this._numberBigDecimal) < 0) {
                reportOverflowLong();
            }
            this._numberLong = this._numberBigDecimal.longValue();
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 2;
    }

    protected void convertNumberToBigInteger() throws IOException {
        int i = this._numTypesValid;
        if ((i & 16) != 0) {
            this._numberBigInt = this._numberBigDecimal.toBigInteger();
        } else if ((i & 2) != 0) {
            this._numberBigInt = BigInteger.valueOf(this._numberLong);
        } else if ((i & 1) != 0) {
            this._numberBigInt = BigInteger.valueOf(this._numberInt);
        } else if ((i & 8) != 0) {
            this._numberBigInt = BigDecimal.valueOf(this._numberDouble).toBigInteger();
        } else if ((i & 32) != 0) {
            this._numberBigInt = BigDecimal.valueOf(this._numberFloat).toBigInteger();
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 4;
    }

    protected void convertNumberToFloat() throws IOException {
        int i = this._numTypesValid;
        if ((i & 16) != 0) {
            this._numberFloat = this._numberBigDecimal.floatValue();
        } else if ((i & 4) != 0) {
            this._numberFloat = this._numberBigInt.floatValue();
        } else if ((i & 8) != 0) {
            this._numberFloat = (float) this._numberDouble;
        } else if ((i & 2) != 0) {
            this._numberFloat = this._numberLong;
        } else if ((i & 1) != 0) {
            this._numberFloat = this._numberInt;
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 32;
    }

    protected void convertNumberToDouble() throws IOException {
        int i = this._numTypesValid;
        if ((i & 16) != 0) {
            this._numberDouble = this._numberBigDecimal.doubleValue();
        } else if ((i & 32) != 0) {
            this._numberDouble = this._numberFloat;
        } else if ((i & 4) != 0) {
            this._numberDouble = this._numberBigInt.doubleValue();
        } else if ((i & 2) != 0) {
            this._numberDouble = this._numberLong;
        } else if ((i & 1) != 0) {
            this._numberDouble = this._numberInt;
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 8;
    }

    protected void convertNumberToBigDecimal() throws IOException {
        int i = this._numTypesValid;
        if ((i & 40) != 0) {
            this._numberBigDecimal = NumberInput.parseBigDecimal(getText());
        } else if ((i & 4) != 0) {
            this._numberBigDecimal = new BigDecimal(this._numberBigInt);
        } else if ((i & 2) != 0) {
            this._numberBigDecimal = BigDecimal.valueOf(this._numberLong);
        } else if ((i & 1) != 0) {
            this._numberBigDecimal = BigDecimal.valueOf(this._numberInt);
        } else {
            _throwInternal();
        }
        this._numTypesValid |= 16;
    }

    protected void _finishToken() throws IOException {
        this._tokenIncomplete = false;
        int i = this._typeByte;
        int i2 = (i >> 5) & 7;
        int i3 = i & 31;
        if (i2 != 3) {
            if (i2 == 2) {
                this._binaryValue = _finishBytes(_decodeExplicitLength(i3));
                return;
            }
            _throwInternal();
        }
        int i_decodeExplicitLength = _decodeExplicitLength(i3);
        if (i_decodeExplicitLength <= 0) {
            if (i_decodeExplicitLength < 0) {
                _finishChunkedText();
                return;
            } else {
                this._textBuffer.resetWithEmpty();
                return;
            }
        }
        if (i_decodeExplicitLength > this._inputEnd - this._inputPtr) {
            if (i_decodeExplicitLength >= this._inputBuffer.length) {
                _finishLongText(i_decodeExplicitLength);
                return;
            }
            _loadToHaveAtLeast(i_decodeExplicitLength);
        }
        _finishShortText(i_decodeExplicitLength);
    }

    protected String _finishTextToken(int i) throws IOException {
        this._tokenIncomplete = false;
        int i2 = (i >> 5) & 7;
        int i3 = i & 31;
        if (i2 != 3) {
            _throwInternal();
        }
        int i_decodeExplicitLength = _decodeExplicitLength(i3);
        if (i_decodeExplicitLength <= 0) {
            if (i_decodeExplicitLength == 0) {
                this._textBuffer.resetWithEmpty();
                return "";
            }
            _finishChunkedText();
            return this._textBuffer.contentsAsString();
        }
        if (i_decodeExplicitLength > this._inputEnd - this._inputPtr) {
            if (i_decodeExplicitLength >= this._inputBuffer.length) {
                _finishLongText(i_decodeExplicitLength);
                return this._textBuffer.contentsAsString();
            }
            _loadToHaveAtLeast(i_decodeExplicitLength);
        }
        return _finishShortText(i_decodeExplicitLength);
    }

    private final String _finishShortText(int i) throws JsonParseException {
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        if (cArrEmptyAndGetCurrentSegment.length < i) {
            cArrEmptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment(i);
        }
        int i2 = this._inputPtr;
        this._inputPtr = i2 + i;
        byte[] bArr = this._inputBuffer;
        int i3 = i + i2;
        int i4 = 0;
        while (true) {
            byte b = bArr[i2];
            if (b >= 0) {
                int i5 = i4 + 1;
                cArrEmptyAndGetCurrentSegment[i4] = (char) b;
                i2++;
                if (i2 == i3) {
                    return this._textBuffer.setCurrentAndReturn(i5);
                }
                i4 = i5;
            } else {
                int[] iArr = UTF8_UNIT_CODES;
                while (true) {
                    int i6 = i2 + 1;
                    byte b2 = bArr[i2];
                    int i7 = b2 & 255;
                    int i8 = iArr[i7];
                    if (i8 == 0) {
                        i2 = i6;
                    } else if (i8 == 1) {
                        i2 += 2;
                        i7 = ((b2 & Ascii.US) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE);
                    } else if (i8 == 2) {
                        int i9 = i2 + 2;
                        i2 += 3;
                        i7 = ((bArr[i6] & Utf8.REPLACEMENT_BYTE) << 6) | ((b2 & Ascii.SI) << 12) | (bArr[i9] & Utf8.REPLACEMENT_BYTE);
                    } else if (i8 == 3) {
                        int i10 = ((bArr[i6] & Utf8.REPLACEMENT_BYTE) << 12) | ((b2 & 7) << 18);
                        int i11 = i2 + 3;
                        int i12 = i10 | ((bArr[i2 + 2] & Utf8.REPLACEMENT_BYTE) << 6);
                        i2 += 4;
                        int i13 = (i12 | (bArr[i11] & Utf8.REPLACEMENT_BYTE)) - 65536;
                        cArrEmptyAndGetCurrentSegment[i4] = (char) ((i13 >> 10) | 55296);
                        i7 = (i13 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) | 56320;
                        i4++;
                    } else {
                        _reportError("Invalid byte " + Integer.toHexString(i7) + " in Unicode text block");
                        i2 = i6;
                    }
                    int i14 = i4 + 1;
                    cArrEmptyAndGetCurrentSegment[i4] = (char) i7;
                    if (i2 >= i3) {
                        return this._textBuffer.setCurrentAndReturn(i14);
                    }
                    i4 = i14;
                }
            }
        }
    }

    private final void _finishLongText(int i) throws IOException {
        int i2;
        int i3;
        int i4;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = UTF8_UNIT_CODES;
        int length = cArrEmptyAndGetCurrentSegment.length;
        int i5 = 0;
        while (true) {
            i--;
            if (i >= 0) {
                int i_nextByte = _nextByte();
                int i_decodeUTF8_3 = i_nextByte & 255;
                int i6 = iArr[i_decodeUTF8_3];
                if (i6 != 0 || i5 >= length) {
                    i -= i6;
                    if (i < 0) {
                        throw _constructError("Malformed UTF-8 character at end of long (non-chunked) text segment");
                    }
                    if (i6 != 0) {
                        if (i6 == 1) {
                            int i_nextByte2 = _nextByte();
                            if ((i_nextByte2 & 192) != 128) {
                                _reportInvalidOther(i_nextByte2 & 255, this._inputPtr);
                            }
                            i3 = (i_nextByte & 31) << 6;
                            i4 = i_nextByte2 & 63;
                        } else if (i6 == 2) {
                            i_decodeUTF8_3 = _decodeUTF8_3(i_decodeUTF8_3);
                        } else if (i6 == 3) {
                            int i_decodeUTF8_4 = _decodeUTF8_4(i_decodeUTF8_3);
                            int i7 = i5 + 1;
                            cArrEmptyAndGetCurrentSegment[i5] = (char) ((i_decodeUTF8_4 >> 10) | 55296);
                            if (i7 >= cArrEmptyAndGetCurrentSegment.length) {
                                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                                length = cArrEmptyAndGetCurrentSegment.length;
                                i5 = 0;
                            } else {
                                i5 = i7;
                            }
                            i3 = i_decodeUTF8_4 & AnalyticsListener.EVENT_DRM_KEYS_LOADED;
                            i4 = 56320;
                        } else {
                            _reportInvalidChar(i_decodeUTF8_3);
                        }
                        i_decodeUTF8_3 = i4 | i3;
                    }
                    if (i5 >= length) {
                        cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                        length = cArrEmptyAndGetCurrentSegment.length;
                        i5 = 0;
                    }
                    i2 = i5 + 1;
                    cArrEmptyAndGetCurrentSegment[i5] = (char) i_decodeUTF8_3;
                } else {
                    i2 = i5 + 1;
                    cArrEmptyAndGetCurrentSegment[i5] = (char) i_decodeUTF8_3;
                }
                i5 = i2;
            } else {
                this._textBuffer.setCurrentLength(i5);
                return;
            }
        }
    }

    private final void _finishChunkedText() throws IOException {
        int i;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = UTF8_UNIT_CODES;
        int length = cArrEmptyAndGetCurrentSegment.length;
        byte[] bArr = this._inputBuffer;
        this._chunkEnd = this._inputPtr;
        this._chunkLeft = 0;
        int i2 = 0;
        while (true) {
            if (this._inputPtr >= this._chunkEnd) {
                if (this._chunkLeft == 0) {
                    int i_decodeChunkLength = _decodeChunkLength(3);
                    if (i_decodeChunkLength >= 0) {
                        this._chunkLeft = i_decodeChunkLength;
                        int i3 = this._inputPtr + i_decodeChunkLength;
                        int i4 = this._inputEnd;
                        if (i3 <= i4) {
                            this._chunkLeft = 0;
                            this._chunkEnd = i3;
                        } else {
                            this._chunkLeft = i3 - i4;
                            this._chunkEnd = i4;
                        }
                    } else {
                        this._textBuffer.setCurrentLength(i2);
                        return;
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                    int i5 = this._inputPtr + this._chunkLeft;
                    int i6 = this._inputEnd;
                    if (i5 <= i6) {
                        this._chunkLeft = 0;
                        this._chunkEnd = i5;
                    } else {
                        this._chunkLeft = i5 - i6;
                        this._chunkEnd = i6;
                    }
                }
            }
            int i7 = this._inputPtr;
            this._inputPtr = i7 + 1;
            byte b = bArr[i7];
            int i_decodeChunkedUTF8_3 = b & 255;
            int i8 = iArr[i_decodeChunkedUTF8_3];
            if (i8 == 0 && i2 < length) {
                i = i2 + 1;
                cArrEmptyAndGetCurrentSegment[i2] = (char) i_decodeChunkedUTF8_3;
            } else {
                if (i8 != 0) {
                    if (i8 == 1) {
                        int i_nextChunkedByte = _nextChunkedByte();
                        if ((i_nextChunkedByte & 192) != 128) {
                            _reportInvalidOther(i_nextChunkedByte & 255, this._inputPtr);
                        }
                        i_decodeChunkedUTF8_3 = (i_nextChunkedByte & 63) | ((b & Ascii.US) << 6);
                    } else if (i8 == 2) {
                        i_decodeChunkedUTF8_3 = _decodeChunkedUTF8_3(i_decodeChunkedUTF8_3);
                    } else if (i8 == 3) {
                        int i_decodeChunkedUTF8_4 = _decodeChunkedUTF8_4(i_decodeChunkedUTF8_3);
                        if (i2 >= cArrEmptyAndGetCurrentSegment.length) {
                            cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                            length = cArrEmptyAndGetCurrentSegment.length;
                            i2 = 0;
                        }
                        cArrEmptyAndGetCurrentSegment[i2] = (char) ((i_decodeChunkedUTF8_4 >> 10) | 55296);
                        i_decodeChunkedUTF8_3 = (i_decodeChunkedUTF8_4 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) | 56320;
                        i2++;
                    } else {
                        _reportInvalidChar(i_decodeChunkedUTF8_3);
                    }
                }
                if (i2 >= length) {
                    cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                    length = cArrEmptyAndGetCurrentSegment.length;
                    i2 = 0;
                }
                i = i2 + 1;
                cArrEmptyAndGetCurrentSegment[i2] = (char) i_decodeChunkedUTF8_3;
            }
            i2 = i;
        }
    }

    private final int _nextByte() throws IOException {
        int i = this._inputPtr;
        if (i < this._inputEnd) {
            byte b = this._inputBuffer[i];
            this._inputPtr = i + 1;
            return b;
        }
        loadMoreGuaranteed();
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        return bArr[i2];
    }

    private final int _nextChunkedByte() {
        int i = this._inputPtr;
        if (i >= this._chunkEnd) {
            return _nextChunkedByte2();
        }
        byte b = this._inputBuffer[i];
        this._inputPtr = i + 1;
        return b;
    }

    private final int _nextChunkedByte2() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
            int i = this._chunkLeft;
            if (i > 0) {
                int i2 = this._inputPtr;
                int i3 = i + i2;
                int i4 = this._inputEnd;
                if (i3 <= i4) {
                    this._chunkLeft = 0;
                    this._chunkEnd = i3;
                } else {
                    this._chunkLeft = i3 - i4;
                    this._chunkEnd = i4;
                }
                byte[] bArr = this._inputBuffer;
                this._inputPtr = i2 + 1;
                return bArr[i2];
            }
        }
        int i_decodeChunkLength = _decodeChunkLength(3);
        if (i_decodeChunkLength < 0) {
            _reportInvalidEOF(": chunked Text ends with partial UTF-8 character", JsonToken.VALUE_STRING);
        }
        int i5 = this._inputPtr;
        int i6 = i_decodeChunkLength + i5;
        int i7 = this._inputEnd;
        if (i6 <= i7) {
            this._chunkLeft = 0;
            this._chunkEnd = i6;
        } else {
            this._chunkLeft = i6 - i7;
            this._chunkEnd = i7;
        }
        byte[] bArr2 = this._inputBuffer;
        this._inputPtr = i5 + 1;
        return bArr2[i5];
    }

    protected byte[] _finishBytes(int i) throws IOException {
        if (i < 0) {
            ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
            while (true) {
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                byte[] bArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                byte b = bArr[i2];
                int i3 = b & 255;
                if (i3 == 255) {
                    return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                }
                int i4 = i3 >> 5;
                if (i4 != 2) {
                    throw _constructError("Mismatched chunk in chunked content: expected 2 but encountered " + i4);
                }
                int i_decodeExplicitLength = _decodeExplicitLength(b & Ascii.US);
                if (i_decodeExplicitLength < 0) {
                    throw _constructError("Illegal chunked-length indicator within chunked-length value (type 2)");
                }
                while (i_decodeExplicitLength > 0) {
                    int i5 = this._inputEnd;
                    int i6 = this._inputPtr;
                    int i7 = i5 - i6;
                    if (i6 >= i5) {
                        loadMoreGuaranteed();
                        i7 = this._inputEnd - this._inputPtr;
                    }
                    int iMin = Math.min(i7, i_decodeExplicitLength);
                    byteArrayBuilder_getByteArrayBuilder.write(this._inputBuffer, this._inputPtr, iMin);
                    this._inputPtr += iMin;
                    i_decodeExplicitLength -= iMin;
                }
            }
        } else {
            if (i == 0) {
                return ParserMinimalBase.NO_BYTES;
            }
            byte[] bArr2 = new byte[i];
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            int i8 = 0;
            while (true) {
                int iMin2 = Math.min(i, this._inputEnd - this._inputPtr);
                System.arraycopy(this._inputBuffer, this._inputPtr, bArr2, i8, iMin2);
                this._inputPtr += iMin2;
                i8 += iMin2;
                i -= iMin2;
                if (i <= 0) {
                    return bArr2;
                }
                loadMoreGuaranteed();
            }
        }
    }

    protected final JsonToken _decodeFieldName() throws IOException {
        String str_decodeLongerName;
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        byte b = bArr[i];
        if (((b >> 5) & 7) != 3) {
            if (b == -1) {
                if (!this._parsingContext.hasExpectedLength()) {
                    this._parsingContext = this._parsingContext.getParent();
                    return JsonToken.END_OBJECT;
                }
                _reportUnexpectedBreak();
            }
            _decodeNonStringName(b);
            return JsonToken.FIELD_NAME;
        }
        int i2 = b & Ascii.US;
        if (i2 > 23) {
            int i_decodeExplicitLength = _decodeExplicitLength(i2);
            if (i_decodeExplicitLength < 0) {
                str_decodeLongerName = _decodeChunkedName();
            } else {
                str_decodeLongerName = _decodeLongerName(i_decodeExplicitLength);
            }
        } else if (i2 == 0) {
            str_decodeLongerName = "";
        } else {
            String str_findDecodedFromSymbols = _findDecodedFromSymbols(i2);
            if (str_findDecodedFromSymbols != null) {
                this._inputPtr += i2;
                str_decodeLongerName = str_findDecodedFromSymbols;
            } else {
                str_decodeLongerName = _addDecodedToSymbols(i2, _decodeShortName(i2));
            }
        }
        this._parsingContext.setCurrentName(str_decodeLongerName);
        return JsonToken.FIELD_NAME;
    }

    private final String _decodeShortName(int i) throws JsonParseException {
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        if (cArrEmptyAndGetCurrentSegment.length < i) {
            cArrEmptyAndGetCurrentSegment = this._textBuffer.expandCurrentSegment(i);
        }
        int i2 = this._inputPtr;
        this._inputPtr = i2 + i;
        int[] iArr = UTF8_UNIT_CODES;
        byte[] bArr = this._inputBuffer;
        int i3 = i + i2;
        int i4 = 0;
        while (true) {
            int i5 = bArr[i2] & 255;
            if (iArr[i5] == 0) {
                int i6 = i4 + 1;
                cArrEmptyAndGetCurrentSegment[i4] = (char) i5;
                i2++;
                if (i2 == i3) {
                    return this._textBuffer.setCurrentAndReturn(i6);
                }
                i4 = i6;
            } else {
                while (i2 < i3) {
                    int i7 = i2 + 1;
                    byte b = bArr[i2];
                    int i8 = b & 255;
                    int i9 = iArr[i8];
                    if (i9 == 0) {
                        i2 = i7;
                    } else if (i9 == 1) {
                        i2 += 2;
                        i8 = ((b & Ascii.US) << 6) | (bArr[i7] & Utf8.REPLACEMENT_BYTE);
                    } else if (i9 == 2) {
                        int i10 = i2 + 2;
                        i2 += 3;
                        i8 = ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 6) | ((b & Ascii.SI) << 12) | (bArr[i10] & Utf8.REPLACEMENT_BYTE);
                    } else if (i9 == 3) {
                        int i11 = ((bArr[i7] & Utf8.REPLACEMENT_BYTE) << 12) | ((b & 7) << 18);
                        int i12 = i2 + 3;
                        int i13 = i11 | ((bArr[i2 + 2] & Utf8.REPLACEMENT_BYTE) << 6);
                        i2 += 4;
                        int i14 = (i13 | (bArr[i12] & Utf8.REPLACEMENT_BYTE)) - 65536;
                        cArrEmptyAndGetCurrentSegment[i4] = (char) ((i14 >> 10) | 55296);
                        i8 = (i14 & AnalyticsListener.EVENT_DRM_KEYS_LOADED) | 56320;
                        i4++;
                    } else {
                        _reportError("Invalid byte " + Integer.toHexString(i8) + " in Object name");
                        i2 = i7;
                    }
                    cArrEmptyAndGetCurrentSegment[i4] = (char) i8;
                    i4++;
                }
                return this._textBuffer.setCurrentAndReturn(i4);
            }
        }
    }

    private final String _decodeLongerName(int i) throws IOException {
        if (this._inputEnd - this._inputPtr < i) {
            if (i >= this._inputBuffer.length) {
                _finishLongText(i);
                return this._textBuffer.contentsAsString();
            }
            _loadToHaveAtLeast(i);
        }
        String str_findDecodedFromSymbols = _findDecodedFromSymbols(i);
        if (str_findDecodedFromSymbols != null) {
            this._inputPtr += i;
            return str_findDecodedFromSymbols;
        }
        return _addDecodedToSymbols(i, _decodeShortName(i));
    }

    private final String _decodeChunkedName() throws IOException {
        _finishChunkedText();
        return this._textBuffer.contentsAsString();
    }

    protected final void _decodeNonStringName(int i) throws IOException {
        String str;
        int i2 = (i >> 5) & 7;
        if (i2 == 0) {
            str = _numberToName(i, false);
        } else if (i2 == 1) {
            str = _numberToName(i, true);
        } else if (i2 == 2) {
            str = new String(_finishBytes(_decodeExplicitLength(i & 31)), UTF8);
        } else {
            if ((i & 255) == 255) {
                _reportUnexpectedBreak();
            }
            throw _constructError("Unsupported major type (" + i2 + ") for CBOR Objects, not (yet?) supported, only Strings");
        }
        this._parsingContext.setCurrentName(str);
    }

    private final String _findDecodedFromSymbols(int i) throws IOException {
        if (this._inputEnd - this._inputPtr < i) {
            _loadToHaveAtLeast(i);
        }
        if (i < 5) {
            int i2 = this._inputPtr;
            byte[] bArr = this._inputBuffer;
            int i3 = bArr[i2] & 255;
            if (i > 1) {
                i3 = (bArr[i2 + 1] & 255) + (i3 << 8);
                if (i > 2) {
                    i3 = (i3 << 8) + (bArr[i2 + 2] & 255);
                    if (i > 3) {
                        i3 = (i3 << 8) + (bArr[i2 + 3] & 255);
                    }
                }
            }
            this._quad1 = i3;
            return this._symbols.findName(i3);
        }
        byte[] bArr2 = this._inputBuffer;
        int i4 = this._inputPtr;
        int i5 = i4 + 4;
        int i6 = (((((bArr2[i4 + 1] & 255) | ((bArr2[i4] & 255) << 8)) << 8) | (bArr2[i4 + 2] & 255)) << 8) | (bArr2[i4 + 3] & 255);
        if (i < 9) {
            int i7 = i4 + 5;
            int i8 = bArr2[i5] & 255;
            int i9 = i - 5;
            if (i9 > 0) {
                int i10 = i8 << 8;
                int i11 = i4 + 6;
                int i12 = i10 + (bArr2[i7] & 255);
                if (i9 > 1) {
                    int i13 = i4 + 7;
                    i8 = (i12 << 8) + (bArr2[i11] & 255);
                    if (i9 > 2) {
                        i8 = (i8 << 8) + (bArr2[i13] & 255);
                    }
                } else {
                    i8 = i12;
                }
            }
            this._quad1 = i6;
            this._quad2 = i8;
            return this._symbols.findName(i6, i8);
        }
        int i14 = i4 + 8;
        int i15 = (((((bArr2[i4 + 5] & 255) | ((bArr2[i5] & 255) << 8)) << 8) | (bArr2[i4 + 6] & 255)) << 8) | (bArr2[i4 + 7] & 255);
        if (i < 13) {
            int i16 = i4 + 9;
            int i17 = bArr2[i14] & 255;
            int i18 = i - 9;
            if (i18 > 0) {
                int i19 = i17 << 8;
                int i20 = i4 + 10;
                int i21 = i19 + (bArr2[i16] & 255);
                if (i18 > 1) {
                    int i22 = i4 + 11;
                    i17 = (i21 << 8) + (bArr2[i20] & 255);
                    if (i18 > 2) {
                        i17 = (i17 << 8) + (bArr2[i22] & 255);
                    }
                } else {
                    i17 = i21;
                }
            }
            this._quad1 = i6;
            this._quad2 = i15;
            this._quad3 = i17;
            return this._symbols.findName(i6, i15, i17);
        }
        return _findDecodedLong(i, i6, i15);
    }

    private final String _findDecodedLong(int i, int i2, int i3) {
        int i4;
        int[] iArr;
        int i5;
        int i6 = (i + 3) >> 2;
        int[] iArr2 = this._quadBuffer;
        if (i6 > iArr2.length) {
            this._quadBuffer = _growArrayTo(iArr2, i6);
        }
        int[] iArr3 = this._quadBuffer;
        iArr3[0] = i2;
        iArr3[1] = i3;
        int i7 = this._inputPtr + 8;
        int i8 = i - 8;
        byte[] bArr = this._inputBuffer;
        int i9 = 2;
        while (true) {
            i4 = i7 + 4;
            int i10 = (((((bArr[i7 + 1] & 255) | ((bArr[i7] & 255) << 8)) << 8) | (bArr[i7 + 2] & 255)) << 8) | (bArr[i7 + 3] & 255);
            iArr = this._quadBuffer;
            i5 = i9 + 1;
            iArr[i9] = i10;
            i8 -= 4;
            if (i8 <= 3) {
                break;
            }
            i7 = i4;
            i9 = i5;
        }
        if (i8 > 0) {
            int i11 = bArr[i4] & 255;
            if (i8 > 1) {
                i11 = (bArr[i7 + 5] & 255) + (i11 << 8);
                if (i8 > 2) {
                    i11 = (i11 << 8) + (bArr[i7 + 6] & 255);
                }
            }
            iArr[i5] = i11;
            i5 = i9 + 2;
        }
        return this._symbols.findName(iArr, i5);
    }

    private final String _addDecodedToSymbols(int i, String str) {
        if (i < 5) {
            return this._symbols.addName(str, this._quad1);
        }
        if (i < 9) {
            return this._symbols.addName(str, this._quad1, this._quad2);
        }
        if (i < 13) {
            return this._symbols.addName(str, this._quad1, this._quad2, this._quad3);
        }
        return this._symbols.addName(str, this._quadBuffer, (i + 3) >> 2);
    }

    private static int[] _growArrayTo(int[] iArr, int i) {
        return Arrays.copyOf(iArr, i + 4);
    }

    protected void _skipIncomplete() throws IOException {
        this._tokenIncomplete = false;
        int i = (this._typeByte >> 5) & 7;
        if (i != 3 && i == 3) {
            _throwInternal();
        }
        int i2 = this._typeByte;
        int i3 = i2 & 31;
        if (i3 <= 23) {
            if (i3 > 0) {
                _skipBytes(i3);
            }
        } else {
            if (i3 != 31) {
                switch (i3) {
                    case 24:
                        _skipBytes(_decode8Bits());
                        break;
                    case 25:
                        _skipBytes(_decode16Bits());
                        break;
                    case 26:
                        _skipBytes(_decode32Bits());
                        break;
                    case 27:
                        _skipBytesL(_decode64Bits());
                        break;
                    default:
                        _invalidToken(i2);
                        break;
                }
            }
            _skipChunked(i);
        }
    }

    protected void _skipChunked(int i) throws IOException {
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            byte[] bArr = this._inputBuffer;
            int i2 = this._inputPtr;
            this._inputPtr = i2 + 1;
            byte b = bArr[i2];
            int i3 = b & 255;
            if (i3 == 255) {
                return;
            }
            int i4 = i3 >> 5;
            if (i4 != i) {
                throw _constructError("Mismatched chunk in chunked content: expected " + i + " but encountered " + i4);
            }
            int i5 = b & Ascii.US;
            if (i5 <= 23) {
                if (i5 > 0) {
                    _skipBytes(i5);
                }
            } else if (i5 != 31) {
                switch (i5) {
                    case 24:
                        _skipBytes(_decode8Bits());
                        break;
                    case 25:
                        _skipBytes(_decode16Bits());
                        break;
                    case 26:
                        _skipBytes(_decode32Bits());
                        break;
                    case 27:
                        _skipBytesL(_decode64Bits());
                        break;
                    default:
                        _invalidToken(this._typeByte);
                        break;
                }
            } else {
                throw _constructError("Illegal chunked-length indicator within chunked-length value (type " + i + ")");
            }
        }
    }

    protected void _skipBytesL(long j) throws IOException {
        while (j > 2147483647L) {
            _skipBytes(Integer.MAX_VALUE);
            j -= 2147483647L;
        }
        _skipBytes((int) j);
    }

    protected void _skipBytes(int i) throws IOException {
        while (true) {
            int iMin = Math.min(i, this._inputEnd - this._inputPtr);
            this._inputPtr += iMin;
            i -= iMin;
            if (i <= 0) {
                return;
            } else {
                loadMoreGuaranteed();
            }
        }
    }

    private final int _decodeTag(int i) throws JsonParseException {
        if (i <= 23) {
            return i;
        }
        int i2 = i - 24;
        if (i2 == 0) {
            return _decode8Bits();
        }
        if (i2 == 1) {
            return _decode16Bits();
        }
        if (i2 == 2) {
            return _decode32Bits();
        }
        if (i2 == 3) {
            long j_decode64Bits = _decode64Bits();
            if (j_decode64Bits < -2147483648L || j_decode64Bits > 2147483647L) {
                _reportError("Illegal Tag value: " + j_decode64Bits);
            }
            return (int) j_decode64Bits;
        }
        throw _constructError("Invalid low bits for Tag token: 0x" + Integer.toHexString(i));
    }

    private final int _decodeExplicitLength(int i) throws JsonParseException {
        if (i == 31) {
            return -1;
        }
        if (i <= 23) {
            return i;
        }
        int i2 = i - 24;
        if (i2 == 0) {
            return _decode8Bits();
        }
        if (i2 == 1) {
            return _decode16Bits();
        }
        if (i2 == 2) {
            return _decode32Bits();
        }
        if (i2 == 3) {
            long j_decode64Bits = _decode64Bits();
            if (j_decode64Bits >= 0 && j_decode64Bits <= 2147483647L) {
                return (int) j_decode64Bits;
            }
            throw _constructError("Illegal length for " + getCurrentToken() + ": " + j_decode64Bits);
        }
        throw _constructError("Invalid length for " + getCurrentToken() + ": 0x" + Integer.toHexString(i));
    }

    private int _decodeChunkLength(int i) throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = this._inputPtr;
        this._inputPtr = i2 + 1;
        byte b = bArr[i2];
        int i3 = b & 255;
        if (i3 == 255) {
            return -1;
        }
        int i4 = i3 >> 5;
        if (i4 != i) {
            throw _constructError("Mismatched chunk in chunked content: expected " + i + " but encountered " + i4 + " (byte 0x" + Integer.toHexString(i3) + ")");
        }
        int i_decodeExplicitLength = _decodeExplicitLength(b & Ascii.US);
        if (i_decodeExplicitLength >= 0) {
            return i_decodeExplicitLength;
        }
        throw _constructError("Illegal chunked-length indicator within chunked-length value (type " + i + ")");
    }

    private float _decodeHalfSizeFloat() {
        int i_decode16Bits = _decode16Bits();
        int i = 65535 & i_decode16Bits;
        boolean z = (i >> 15) != 0;
        int i2 = (i >> 10) & 31;
        int i3 = i_decode16Bits & AnalyticsListener.EVENT_DRM_KEYS_LOADED;
        if (i2 == 0) {
            float f = (float) (MATH_POW_2_NEG14 * (i3 / MATH_POW_2_10));
            return z ? -f : f;
        }
        if (i2 != 31) {
            float fPow = (float) (Math.pow(2.0d, i2 - 15) * ((i3 / MATH_POW_2_10) + 1.0d));
            return z ? -fPow : fPow;
        }
        if (i3 != 0) {
            return Float.NaN;
        }
        return z ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
    }

    private final int _decode8Bits() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        return bArr[i] & 255;
    }

    private final int _decode16Bits() {
        int i = this._inputPtr;
        int i2 = i + 1;
        if (i2 >= this._inputEnd) {
            return _slow16();
        }
        byte[] bArr = this._inputBuffer;
        int i3 = ((bArr[i] & 255) << 8) + (bArr[i2] & 255);
        this._inputPtr = i + 2;
        return i3;
    }

    private final int _slow16() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        int i2 = i + 1;
        this._inputPtr = i2;
        int i3 = bArr[i] & 255;
        if (i2 >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i4 = this._inputPtr;
        this._inputPtr = i4 + 1;
        return (i3 << 8) + (bArr2[i4] & 255);
    }

    private final int _decode32Bits() {
        int i = this._inputPtr;
        if (i + 3 >= this._inputEnd) {
            return _slow32();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = (bArr[i] << Ascii.CAN) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8);
        int i3 = i2 + (bArr[i + 3] & 255);
        this._inputPtr = i + 4;
        return i3;
    }

    private final int _slow32() throws IOException {
        if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr = this._inputBuffer;
        int i = this._inputPtr;
        int i2 = i + 1;
        this._inputPtr = i2;
        byte b = bArr[i];
        if (i2 >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr2 = this._inputBuffer;
        int i3 = this._inputPtr;
        int i4 = i3 + 1;
        this._inputPtr = i4;
        int i5 = (b << 8) + (bArr2[i3] & 255);
        if (i4 >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr3 = this._inputBuffer;
        int i6 = this._inputPtr;
        int i7 = i6 + 1;
        this._inputPtr = i7;
        int i8 = (i5 << 8) + (bArr3[i6] & 255);
        if (i7 >= this._inputEnd) {
            loadMoreGuaranteed();
        }
        byte[] bArr4 = this._inputBuffer;
        int i9 = this._inputPtr;
        this._inputPtr = i9 + 1;
        return (i8 << 8) + (bArr4[i9] & 255);
    }

    private final long _decode64Bits() {
        int i = this._inputPtr;
        if (i + 7 >= this._inputEnd) {
            return _slow64();
        }
        byte[] bArr = this._inputBuffer;
        int i2 = (bArr[i] << Ascii.CAN) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
        int i3 = (bArr[i + 4] << Ascii.CAN) + ((bArr[i + 5] & 255) << 16) + ((bArr[i + 6] & 255) << 8);
        int i4 = i3 + (bArr[i + 7] & 255);
        this._inputPtr = i + 8;
        return _long(i2, i4);
    }

    private final long _slow64() {
        return _long(_decode32Bits(), _decode32Bits());
    }

    protected JsonToken _decodeUndefinedValue() throws IOException {
        return JsonToken.VALUE_NULL;
    }

    private final int _decodeUTF8_3(int i) throws IOException {
        int i2 = i & 15;
        int i_nextByte = _nextByte();
        if ((i_nextByte & 192) != 128) {
            _reportInvalidOther(i_nextByte & 255, this._inputPtr);
        }
        int i3 = (i2 << 6) | (i_nextByte & 63);
        int i_nextByte2 = _nextByte();
        if ((i_nextByte2 & 192) != 128) {
            _reportInvalidOther(i_nextByte2 & 255, this._inputPtr);
        }
        return (i3 << 6) | (i_nextByte2 & 63);
    }

    private final int _decodeChunkedUTF8_3(int i) throws JsonParseException {
        int i2 = i & 15;
        int i_nextChunkedByte = _nextChunkedByte();
        if ((i_nextChunkedByte & 192) != 128) {
            _reportInvalidOther(i_nextChunkedByte & 255, this._inputPtr);
        }
        int i3 = (i2 << 6) | (i_nextChunkedByte & 63);
        int i_nextChunkedByte2 = _nextChunkedByte();
        if ((i_nextChunkedByte2 & 192) != 128) {
            _reportInvalidOther(i_nextChunkedByte2 & 255, this._inputPtr);
        }
        return (i3 << 6) | (i_nextChunkedByte2 & 63);
    }

    private final int _decodeUTF8_4(int i) throws IOException {
        int i_nextByte = _nextByte();
        if ((i_nextByte & 192) != 128) {
            _reportInvalidOther(i_nextByte & 255, this._inputPtr);
        }
        int i2 = ((i & 7) << 6) | (i_nextByte & 63);
        int i_nextByte2 = _nextByte();
        if ((i_nextByte2 & 192) != 128) {
            _reportInvalidOther(i_nextByte2 & 255, this._inputPtr);
        }
        int i3 = (i2 << 6) | (i_nextByte2 & 63);
        int i_nextByte3 = _nextByte();
        if ((i_nextByte3 & 192) != 128) {
            _reportInvalidOther(i_nextByte3 & 255, this._inputPtr);
        }
        return ((i3 << 6) | (i_nextByte3 & 63)) - 65536;
    }

    private final int _decodeChunkedUTF8_4(int i) throws JsonParseException {
        int i_nextChunkedByte = _nextChunkedByte();
        if ((i_nextChunkedByte & 192) != 128) {
            _reportInvalidOther(i_nextChunkedByte & 255, this._inputPtr);
        }
        int i2 = ((i & 7) << 6) | (i_nextChunkedByte & 63);
        int i_nextChunkedByte2 = _nextChunkedByte();
        if ((i_nextChunkedByte2 & 192) != 128) {
            _reportInvalidOther(i_nextChunkedByte2 & 255, this._inputPtr);
        }
        int i3 = (i2 << 6) | (i_nextChunkedByte2 & 63);
        int i_nextChunkedByte3 = _nextChunkedByte();
        if ((i_nextChunkedByte3 & 192) != 128) {
            _reportInvalidOther(i_nextChunkedByte3 & 255, this._inputPtr);
        }
        return ((i3 << 6) | (i_nextChunkedByte3 & 63)) - 65536;
    }

    protected final boolean loadMore() throws IOException {
        InputStream inputStream = this._inputStream;
        if (inputStream != null) {
            this._currInputProcessed += this._inputEnd;
            byte[] bArr = this._inputBuffer;
            int i = inputStream.read(bArr, 0, bArr.length);
            if (i > 0) {
                this._inputPtr = 0;
                this._inputEnd = i;
                return true;
            }
            _closeInput();
            if (i == 0) {
                throw new IOException("InputStream.read() returned 0 characters when trying to read " + this._inputBuffer.length + " bytes");
            }
        }
        return false;
    }

    protected final void loadMoreGuaranteed() throws IOException {
        if (loadMore()) {
            return;
        }
        _reportInvalidEOF();
    }

    protected final void _loadToHaveAtLeast(int i) throws IOException {
        if (this._inputStream == null) {
            throw _constructError("Needed to read " + i + " bytes, reached end-of-input");
        }
        int i2 = this._inputEnd;
        int i3 = this._inputPtr;
        int i4 = i2 - i3;
        if (i4 > 0 && i3 > 0) {
            byte[] bArr = this._inputBuffer;
            System.arraycopy(bArr, i3, bArr, 0, i4);
            this._inputEnd = i4;
        } else {
            this._inputEnd = 0;
        }
        this._currInputProcessed += this._inputPtr;
        this._inputPtr = 0;
        while (true) {
            int i5 = this._inputEnd;
            if (i5 >= i) {
                return;
            }
            InputStream inputStream = this._inputStream;
            byte[] bArr2 = this._inputBuffer;
            int i6 = inputStream.read(bArr2, i5, bArr2.length - i5);
            if (i6 < 1) {
                _closeInput();
                if (i6 == 0) {
                    throw new IOException("InputStream.read() returned 0 characters when trying to read " + i4 + " bytes");
                }
                throw _constructError("Needed to read " + i + " bytes, missed " + i + " before end-of-input");
            }
            this._inputEnd += i6;
        }
    }

    protected ByteArrayBuilder _getByteArrayBuilder() {
        ByteArrayBuilder byteArrayBuilder = this._byteArrayBuilder;
        if (byteArrayBuilder == null) {
            this._byteArrayBuilder = new ByteArrayBuilder();
        } else {
            byteArrayBuilder.reset();
        }
        return this._byteArrayBuilder;
    }

    protected void _closeInput() throws IOException {
        if (this._inputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this._inputStream.close();
            }
            this._inputStream = null;
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase
    protected void _handleEOF() throws JsonParseException {
        if (this._parsingContext.inRoot()) {
            return;
        }
        _reportInvalidEOF(String.format(": expected close marker for %s (start marker at %s)", this._parsingContext.inArray() ? "Array" : "Object", this._parsingContext.getStartLocation(this._ioContext.getSourceReference())), null);
    }

    protected JsonToken _handleCBOREOF() throws IOException {
        this._tagValue = -1;
        close();
        this._currToken = null;
        return null;
    }

    protected void _invalidToken(int i) throws JsonParseException {
        int i2 = i & 255;
        if (i2 == 255) {
            throw _constructError("Mismatched BREAK byte (0xFF): encountered where value expected");
        }
        throw _constructError("Invalid CBOR value token (first byte): 0x" + Integer.toHexString(i2));
    }

    protected void _reportUnexpectedBreak() throws IOException {
        if (this._parsingContext.inRoot()) {
            throw _constructError("Unexpected Break (0xFF) token in Root context");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected Break (0xFF) token in definite length (");
        sb.append(this._parsingContext.getExpectedLength());
        sb.append(") ");
        sb.append(this._parsingContext.inObject() ? "Object" : "Array");
        throw _constructError(sb.toString());
    }

    protected void _reportInvalidChar(int i) throws JsonParseException {
        if (i < 32) {
            _throwInvalidSpace(i);
        }
        _reportInvalidInitial(i);
    }

    protected void _reportInvalidInitial(int i) throws JsonParseException {
        _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    protected void _reportInvalidOther(int i) throws JsonParseException {
        _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    protected void _reportInvalidOther(int i, int i2) throws JsonParseException {
        this._inputPtr = i2;
        _reportInvalidOther(i);
    }

    private final BigInteger _bigPositive(long j) {
        return BigInteger.valueOf((j << 1) >>> 1).or(BIT_63);
    }

    private final BigInteger _bigNegative(long j) {
        return _bigPositive(j).negate().subtract(BigInteger.ONE);
    }
}
