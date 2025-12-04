package io.cucumber.datatable.dependency.com.fasterxml.jackson.core.util;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Base64Variant;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.FormatSchema;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonStreamContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.ObjectCodec;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.PrettyPrinter;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.SerializableString;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeNode;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Version;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public class JsonGeneratorDelegate extends JsonGenerator {
    protected JsonGenerator delegate;
    protected boolean delegateCopyMethods;

    public JsonGeneratorDelegate(JsonGenerator jsonGenerator) {
        this(jsonGenerator, true);
    }

    public JsonGeneratorDelegate(JsonGenerator jsonGenerator, boolean z) {
        this.delegate = jsonGenerator;
        this.delegateCopyMethods = z;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public Object getCurrentValue() {
        return this.delegate.getCurrentValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void setCurrentValue(Object obj) {
        this.delegate.setCurrentValue(obj);
    }

    public JsonGenerator getDelegate() {
        return this.delegate;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        this.delegate.setCodec(objectCodec);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void setSchema(FormatSchema formatSchema) {
        this.delegate.setSchema(formatSchema);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public FormatSchema getSchema() {
        return this.delegate.getSchema();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Versioned
    public Version version() {
        return this.delegate.version();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this.delegate.getOutputTarget();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public int getOutputBuffered() {
        return this.delegate.getOutputBuffered();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public boolean canUseSchema(FormatSchema formatSchema) {
        return this.delegate.canUseSchema(formatSchema);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteTypeId() {
        return this.delegate.canWriteTypeId();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteObjectId() {
        return this.delegate.canWriteObjectId();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteBinaryNatively() {
        return this.delegate.canWriteBinaryNatively();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public boolean canOmitFields() {
        return this.delegate.canOmitFields();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator enable(JsonGenerator.Feature feature) {
        this.delegate.enable(feature);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator disable(JsonGenerator.Feature feature) {
        this.delegate.disable(feature);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public boolean isEnabled(JsonGenerator.Feature feature) {
        return this.delegate.isEnabled(feature);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public int getFeatureMask() {
        return this.delegate.getFeatureMask();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    @Deprecated
    public JsonGenerator setFeatureMask(int i) {
        this.delegate.setFeatureMask(i);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator overrideStdFeatures(int i, int i2) {
        this.delegate.overrideStdFeatures(i, i2);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator overrideFormatFeatures(int i, int i2) {
        this.delegate.overrideFormatFeatures(i, i2);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        this.delegate.setPrettyPrinter(prettyPrinter);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public PrettyPrinter getPrettyPrinter() {
        return this.delegate.getPrettyPrinter();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator useDefaultPrettyPrinter() {
        this.delegate.useDefaultPrettyPrinter();
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setHighestNonEscapedChar(int i) {
        this.delegate.setHighestNonEscapedChar(i);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public int getHighestEscapedChar() {
        return this.delegate.getHighestEscapedChar();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public CharacterEscapes getCharacterEscapes() {
        return this.delegate.getCharacterEscapes();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setCharacterEscapes(CharacterEscapes characterEscapes) {
        this.delegate.setCharacterEscapes(characterEscapes);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setRootValueSeparator(SerializableString serializableString) {
        this.delegate.setRootValueSeparator(serializableString);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray() throws IOException {
        this.delegate.writeStartArray();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(int i) throws IOException {
        this.delegate.writeStartArray(i);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeEndArray() throws IOException {
        this.delegate.writeEndArray();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject() throws IOException {
        this.delegate.writeStartObject();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj) throws IOException {
        this.delegate.writeStartObject(obj);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeEndObject() throws IOException {
        this.delegate.writeEndObject();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(String str) throws IOException {
        this.delegate.writeFieldName(str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString serializableString) throws IOException {
        this.delegate.writeFieldName(serializableString);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldId(long j) throws IOException {
        this.delegate.writeFieldId(j);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeArray(int[] iArr, int i, int i2) throws IOException {
        this.delegate.writeArray(iArr, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeArray(long[] jArr, int i, int i2) throws IOException {
        this.delegate.writeArray(jArr, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeArray(double[] dArr, int i, int i2) throws IOException {
        this.delegate.writeArray(dArr, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        this.delegate.writeString(str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeString(Reader reader, int i) throws IOException {
        this.delegate.writeString(reader, i);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i, int i2) throws IOException {
        this.delegate.writeString(cArr, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeString(SerializableString serializableString) throws IOException {
        this.delegate.writeString(serializableString);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException {
        this.delegate.writeRawUTF8String(bArr, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException {
        this.delegate.writeUTF8String(bArr, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        this.delegate.writeRaw(str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i, int i2) throws IOException {
        this.delegate.writeRaw(str, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException {
        this.delegate.writeRaw(serializableString);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i, int i2) throws IOException {
        this.delegate.writeRaw(cArr, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c) throws IOException {
        this.delegate.writeRaw(c);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str) throws IOException {
        this.delegate.writeRawValue(str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i, int i2) throws IOException {
        this.delegate.writeRawValue(str, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i, int i2) throws IOException {
        this.delegate.writeRawValue(cArr, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        this.delegate.writeBinary(base64Variant, bArr, i, i2);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        return this.delegate.writeBinary(base64Variant, inputStream, i);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(short s) throws IOException {
        this.delegate.writeNumber(s);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i) throws IOException {
        this.delegate.writeNumber(i);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j) throws IOException {
        this.delegate.writeNumber(j);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        this.delegate.writeNumber(bigInteger);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d) throws IOException {
        this.delegate.writeNumber(d);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f) throws IOException {
        this.delegate.writeNumber(f);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        this.delegate.writeNumber(bigDecimal);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws UnsupportedOperationException, IOException {
        this.delegate.writeNumber(str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z) throws IOException {
        this.delegate.writeBoolean(z);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        this.delegate.writeNull();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeOmittedField(String str) throws IOException {
        this.delegate.writeOmittedField(str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectId(Object obj) throws IOException {
        this.delegate.writeObjectId(obj);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectRef(Object obj) throws IOException {
        this.delegate.writeObjectRef(obj);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeTypeId(Object obj) throws IOException {
        this.delegate.writeTypeId(obj);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeEmbeddedObject(Object obj) throws IOException {
        this.delegate.writeEmbeddedObject(obj);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeObject(Object obj) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeObject(obj);
            return;
        }
        if (obj == null) {
            writeNull();
            return;
        }
        ObjectCodec codec = getCodec();
        if (codec != null) {
            codec.writeValue(this, obj);
        } else {
            _writeSimpleObject(obj);
        }
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void writeTree(TreeNode treeNode) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeTree(treeNode);
            return;
        }
        if (treeNode == null) {
            writeNull();
            return;
        }
        ObjectCodec codec = getCodec();
        if (codec == null) {
            throw new IllegalStateException("No ObjectCodec defined");
        }
        codec.writeTree(this, treeNode);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void copyCurrentEvent(JsonParser jsonParser) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentEvent(jsonParser);
        } else {
            super.copyCurrentEvent(jsonParser);
        }
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public void copyCurrentStructure(JsonParser jsonParser) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentStructure(jsonParser);
        } else {
            super.copyCurrentStructure(jsonParser);
        }
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public JsonStreamContext getOutputContext() {
        return this.delegate.getOutputContext();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator
    public boolean isClosed() {
        return this.delegate.isClosed();
    }
}
