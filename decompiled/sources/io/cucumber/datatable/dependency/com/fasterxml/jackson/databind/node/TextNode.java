package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Base64Variant;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Base64Variants;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.io.CharTypes;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.io.NumberInput;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.IOException;
import org.picocontainer.Characteristics;

/* loaded from: classes5.dex */
public class TextNode extends ValueNode {
    static final TextNode EMPTY_STRING_NODE = new TextNode("");
    protected final String _value;

    public TextNode(String str) {
        this._value = str;
    }

    public static TextNode valueOf(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return EMPTY_STRING_NODE;
        }
        return new TextNode(str);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public JsonNodeType getNodeType() {
        return JsonNodeType.STRING;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.ValueNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeNode
    public JsonToken asToken() {
        return JsonToken.VALUE_STRING;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public String textValue() {
        return this._value;
    }

    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        String strTrim = this._value.trim();
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder(((strTrim.length() * 3) << 2) + 4);
        try {
            base64Variant.decode(strTrim, byteArrayBuilder);
            return byteArrayBuilder.toByteArray();
        } catch (IllegalArgumentException e) {
            throw InvalidFormatException.from(null, String.format("Cannot access contents of TextNode as binary due to broken Base64 encoding: %s", e.getMessage()), strTrim, byte[].class);
        }
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public byte[] binaryValue() throws IOException {
        return getBinaryValue(Base64Variants.getDefaultVariant());
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public String asText() {
        return this._value;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public String asText(String str) {
        String str2 = this._value;
        return str2 == null ? str : str2;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean asBoolean(boolean z) {
        String str = this._value;
        if (str != null) {
            String strTrim = str.trim();
            if (Characteristics.TRUE.equals(strTrim)) {
                return true;
            }
            if ("false".equals(strTrim)) {
                return false;
            }
        }
        return z;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public int asInt(int i) {
        return NumberInput.parseAsInt(this._value, i);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public long asLong(long j) {
        return NumberInput.parseAsLong(this._value, j);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public double asDouble(double d) {
        return NumberInput.parseAsDouble(this._value, d);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String str = this._value;
        if (str == null) {
            jsonGenerator.writeNull();
        } else {
            jsonGenerator.writeString(str);
        }
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof TextNode)) {
            return ((TextNode) obj)._value.equals(this._value);
        }
        return false;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return this._value.hashCode();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.ValueNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public String toString() {
        int length = this._value.length();
        StringBuilder sb = new StringBuilder(length + 2 + (length >> 4));
        appendQuoted(sb, this._value);
        return sb.toString();
    }

    protected static void appendQuoted(StringBuilder sb, String str) {
        sb.append('\"');
        CharTypes.appendQuoted(sb, str);
        sb.append('\"');
    }
}
