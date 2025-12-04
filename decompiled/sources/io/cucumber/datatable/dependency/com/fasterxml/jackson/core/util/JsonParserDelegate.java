package io.cucumber.datatable.dependency.com.fasterxml.jackson.core.util;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Base64Variant;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.FormatSchema;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonLocation;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonStreamContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.ObjectCodec;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Version;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public class JsonParserDelegate extends JsonParser {
    protected JsonParser delegate;

    public JsonParserDelegate(JsonParser jsonParser) {
        this.delegate = jsonParser;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public Object getCurrentValue() {
        return this.delegate.getCurrentValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public void setCurrentValue(Object obj) {
        this.delegate.setCurrentValue(obj);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this.delegate.setCodec(objectCodec);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonParser enable(JsonParser.Feature feature) {
        this.delegate.enable(feature);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonParser disable(JsonParser.Feature feature) {
        this.delegate.disable(feature);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean isEnabled(JsonParser.Feature feature) {
        return this.delegate.isEnabled(feature);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int getFeatureMask() {
        return this.delegate.getFeatureMask();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public JsonParser setFeatureMask(int i) {
        this.delegate.setFeatureMask(i);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonParser overrideStdFeatures(int i, int i2) {
        this.delegate.overrideStdFeatures(i, i2);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonParser overrideFormatFeatures(int i, int i2) {
        this.delegate.overrideFormatFeatures(i, i2);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public FormatSchema getSchema() {
        return this.delegate.getSchema();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public void setSchema(FormatSchema formatSchema) {
        this.delegate.setSchema(formatSchema);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean canUseSchema(FormatSchema formatSchema) {
        return this.delegate.canUseSchema(formatSchema);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Versioned
    public Version version() {
        return this.delegate.version();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this.delegate.getInputSource();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean requiresCustomCodec() {
        return this.delegate.requiresCustomCodec();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean isClosed() {
        return this.delegate.isClosed();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonToken currentToken() {
        return this.delegate.currentToken();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int currentTokenId() {
        return this.delegate.currentTokenId();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonToken getCurrentToken() {
        return this.delegate.getCurrentToken();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int getCurrentTokenId() {
        return this.delegate.getCurrentTokenId();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean hasCurrentToken() {
        return this.delegate.hasCurrentToken();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean hasTokenId(int i) {
        return this.delegate.hasTokenId(i);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean hasToken(JsonToken jsonToken) {
        return this.delegate.hasToken(jsonToken);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public String getCurrentName() throws IOException {
        return this.delegate.getCurrentName();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonStreamContext getParsingContext() {
        return this.delegate.getParsingContext();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartArrayToken() {
        return this.delegate.isExpectedStartArrayToken();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean isExpectedStartObjectToken() {
        return this.delegate.isExpectedStartObjectToken();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean isNaN() throws IOException {
        return this.delegate.isNaN();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public void clearCurrentToken() {
        this.delegate.clearCurrentToken();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonToken getLastClearedToken() {
        return this.delegate.getLastClearedToken();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public void overrideCurrentName(String str) {
        this.delegate.overrideCurrentName(str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public String getText() throws IOException {
        return this.delegate.getText();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        return this.delegate.hasTextCharacters();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() throws IOException {
        return this.delegate.getTextCharacters();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        return this.delegate.getTextLength();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() throws IOException {
        return this.delegate.getTextOffset();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int getText(Writer writer) throws UnsupportedOperationException, IOException {
        return this.delegate.getText(writer);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public BigInteger getBigIntegerValue() throws IOException {
        return this.delegate.getBigIntegerValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean getBooleanValue() throws IOException {
        return this.delegate.getBooleanValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public byte getByteValue() throws IOException {
        return this.delegate.getByteValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public short getShortValue() throws IOException {
        return this.delegate.getShortValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public BigDecimal getDecimalValue() throws IOException {
        return this.delegate.getDecimalValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public double getDoubleValue() throws IOException {
        return this.delegate.getDoubleValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public float getFloatValue() throws IOException {
        return this.delegate.getFloatValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int getIntValue() throws IOException {
        return this.delegate.getIntValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public long getLongValue() throws IOException {
        return this.delegate.getLongValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberType getNumberType() throws IOException {
        return this.delegate.getNumberType();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public Number getNumberValue() throws IOException {
        return this.delegate.getNumberValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt() throws IOException {
        return this.delegate.getValueAsInt();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int getValueAsInt(int i) throws IOException {
        return this.delegate.getValueAsInt(i);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong() throws IOException {
        return this.delegate.getValueAsLong();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public long getValueAsLong(long j) throws IOException {
        return this.delegate.getValueAsLong(j);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public double getValueAsDouble() throws IOException {
        return this.delegate.getValueAsDouble();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public double getValueAsDouble(double d) throws IOException {
        return this.delegate.getValueAsDouble(d);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean getValueAsBoolean() throws IOException {
        return this.delegate.getValueAsBoolean();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean getValueAsBoolean(boolean z) throws IOException {
        return this.delegate.getValueAsBoolean(z);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public String getValueAsString() throws IOException {
        return this.delegate.getValueAsString();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public String getValueAsString(String str) throws IOException {
        return this.delegate.getValueAsString(str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException {
        return this.delegate.getEmbeddedObject();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        return this.delegate.getBinaryValue(base64Variant);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        return this.delegate.readBinaryValue(base64Variant, outputStream);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws IOException {
        return this.delegate.nextToken();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonToken nextValue() throws IOException {
        return this.delegate.nextValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public void finishToken() throws IOException {
        this.delegate.finishToken();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public JsonParser skipChildren() throws IOException {
        this.delegate.skipChildren();
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean canReadObjectId() {
        return this.delegate.canReadObjectId();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public boolean canReadTypeId() {
        return this.delegate.canReadTypeId();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public Object getObjectId() throws IOException {
        return this.delegate.getObjectId();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser
    public Object getTypeId() throws IOException {
        return this.delegate.getTypeId();
    }
}
