package com.fasterxml.jackson.dataformat.cbor;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import com.fasterxml.jackson.dataformat.cbor.CBORParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

/* loaded from: classes3.dex */
public class CBORFactory extends JsonFactory {
    public static final String FORMAT_NAME = "CBOR";
    private static final long serialVersionUID = 1;
    protected int _formatGeneratorFeatures;
    protected int _formatParserFeatures;
    static final int DEFAULT_CBOR_PARSER_FEATURE_FLAGS = CBORParser.Feature.collectDefaults();
    static final int DEFAULT_CBOR_GENERATOR_FEATURE_FLAGS = CBORGenerator.Feature.collectDefaults();

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public boolean canHandleBinaryNatively() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public boolean canUseCharArrays() {
        return false;
    }

    public CBORFactory() {
        this((ObjectCodec) null);
    }

    public CBORFactory(ObjectCodec objectCodec) {
        super(objectCodec);
        this._formatParserFeatures = DEFAULT_CBOR_PARSER_FEATURE_FLAGS;
        this._formatGeneratorFeatures = DEFAULT_CBOR_GENERATOR_FEATURE_FLAGS;
    }

    public CBORFactory(CBORFactory cBORFactory, ObjectCodec objectCodec) {
        super(cBORFactory, objectCodec);
        this._formatParserFeatures = cBORFactory._formatParserFeatures;
        this._formatGeneratorFeatures = cBORFactory._formatGeneratorFeatures;
    }

    protected CBORFactory(CBORFactoryBuilder cBORFactoryBuilder) {
        super((TSFBuilder<?, ?>) cBORFactoryBuilder, false);
        this._formatParserFeatures = cBORFactoryBuilder.formatParserFeaturesMask();
        this._formatGeneratorFeatures = cBORFactoryBuilder.formatGeneratorFeaturesMask();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public CBORFactoryBuilder rebuild() {
        return new CBORFactoryBuilder(this);
    }

    public static CBORFactoryBuilder builder() {
        return new CBORFactoryBuilder();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public CBORFactory copy() {
        _checkInvalidCopy(CBORFactory.class);
        return new CBORFactory(this, null);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    protected Object readResolve() {
        return new CBORFactory(this, this._objectCodec);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public String getFormatName() {
        return FORMAT_NAME;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    public MatchStrength hasFormat(InputAccessor inputAccessor) throws IOException {
        return CBORParserBootstrapper.hasCBORFormat(inputAccessor);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public Class<CBORParser.Feature> getFormatReadFeatureType() {
        return CBORParser.Feature.class;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public Class<CBORGenerator.Feature> getFormatWriteFeatureType() {
        return CBORGenerator.Feature.class;
    }

    public final CBORFactory configure(CBORParser.Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
        return this;
    }

    public CBORFactory enable(CBORParser.Feature feature) {
        this._formatParserFeatures = feature.getMask() | this._formatParserFeatures;
        return this;
    }

    public CBORFactory disable(CBORParser.Feature feature) {
        this._formatParserFeatures = (~feature.getMask()) & this._formatParserFeatures;
        return this;
    }

    public final boolean isEnabled(CBORParser.Feature feature) {
        return (this._formatParserFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatParserFeatures() {
        return this._formatParserFeatures;
    }

    public final CBORFactory configure(CBORGenerator.Feature feature, boolean z) {
        if (z) {
            enable(feature);
        } else {
            disable(feature);
        }
        return this;
    }

    public CBORFactory enable(CBORGenerator.Feature feature) {
        this._formatGeneratorFeatures = feature.getMask() | this._formatGeneratorFeatures;
        return this;
    }

    public CBORFactory disable(CBORGenerator.Feature feature) {
        this._formatGeneratorFeatures = (~feature.getMask()) & this._formatGeneratorFeatures;
        return this;
    }

    public final boolean isEnabled(CBORGenerator.Feature feature) {
        return (this._formatGeneratorFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatGeneratorFeatures() {
        return this._formatGeneratorFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public CBORParser createParser(File file) throws IOException {
        IOContext iOContext_createContext = _createContext(file, true);
        return _createParser(_decorate(new FileInputStream(file), iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public CBORParser createParser(URL url) throws IOException {
        IOContext iOContext_createContext = _createContext(url, true);
        return _createParser(_decorate(_optimizedStreamFromURL(url), iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public CBORParser createParser(InputStream inputStream) throws IOException {
        IOContext iOContext_createContext = _createContext(inputStream, false);
        return _createParser(_decorate(inputStream, iOContext_createContext), iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public CBORParser createParser(byte[] bArr) throws IOException {
        return createParser(bArr, 0, bArr.length);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public CBORParser createParser(byte[] bArr, int i, int i2) throws IOException {
        InputStream inputStreamDecorate;
        IOContext iOContext_createContext = _createContext(bArr, true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (inputStreamDecorate = inputDecorator.decorate(iOContext_createContext, bArr, 0, bArr.length)) != null) {
            return _createParser(inputStreamDecorate, iOContext_createContext);
        }
        return _createParser(bArr, i, i2, iOContext_createContext);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public CBORGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        IOContext iOContext_createContext = _createContext(outputStream, false);
        return _createCBORGenerator(iOContext_createContext, this._generatorFeatures, this._formatGeneratorFeatures, this._objectCodec, _decorate(outputStream, iOContext_createContext));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory, com.fasterxml.jackson.core.TokenStreamFactory
    public CBORGenerator createGenerator(OutputStream outputStream) throws IOException {
        IOContext iOContext_createContext = _createContext(outputStream, false);
        return _createCBORGenerator(iOContext_createContext, this._generatorFeatures, this._formatGeneratorFeatures, this._objectCodec, _decorate(outputStream, iOContext_createContext));
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    protected IOContext _createContext(Object obj, boolean z) {
        return super._createContext(obj, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public CBORParser _createParser(InputStream inputStream, IOContext iOContext) throws IOException {
        return new CBORParserBootstrapper(iOContext, inputStream).constructParser(this._factoryFeatures, this._parserFeatures, this._formatParserFeatures, this._objectCodec, this._byteSymbolCanonicalizer);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    protected JsonParser _createParser(Reader reader, IOContext iOContext) throws IOException {
        return (JsonParser) _nonByteSource();
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    protected JsonParser _createParser(char[] cArr, int i, int i2, IOContext iOContext, boolean z) throws IOException {
        return (JsonParser) _nonByteSource();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public CBORParser _createParser(byte[] bArr, int i, int i2, IOContext iOContext) throws IOException {
        return new CBORParserBootstrapper(iOContext, bArr, i, i2).constructParser(this._factoryFeatures, this._parserFeatures, this._formatParserFeatures, this._objectCodec, this._byteSymbolCanonicalizer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public CBORGenerator _createGenerator(Writer writer, IOContext iOContext) throws IOException {
        return (CBORGenerator) _nonByteTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.core.JsonFactory
    public CBORGenerator _createUTF8Generator(OutputStream outputStream, IOContext iOContext) throws IOException {
        return _createCBORGenerator(iOContext, this._generatorFeatures, this._formatGeneratorFeatures, this._objectCodec, outputStream);
    }

    @Override // com.fasterxml.jackson.core.JsonFactory
    protected Writer _createWriter(OutputStream outputStream, JsonEncoding jsonEncoding, IOContext iOContext) throws IOException {
        return (Writer) _nonByteTarget();
    }

    private final CBORGenerator _createCBORGenerator(IOContext iOContext, int i, int i2, ObjectCodec objectCodec, OutputStream outputStream) throws IOException {
        CBORGenerator cBORGenerator = new CBORGenerator(iOContext, i, i2, this._objectCodec, outputStream);
        if (CBORGenerator.Feature.WRITE_TYPE_HEADER.enabledIn(i2)) {
            cBORGenerator.writeTag(CBORConstants.TAG_ID_SELF_DESCRIBE);
        }
        return cBORGenerator;
    }

    protected <T> T _nonByteSource() {
        throw new UnsupportedOperationException("Can not create parser for non-byte-based source");
    }

    protected <T> T _nonByteTarget() {
        throw new UnsupportedOperationException("Can not create generator for non-byte-based target");
    }
}
