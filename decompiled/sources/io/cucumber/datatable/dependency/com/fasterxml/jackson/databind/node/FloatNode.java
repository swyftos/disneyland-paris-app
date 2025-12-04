package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.io.NumberOutput;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public class FloatNode extends NumericNode {
    protected final float _value;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean isFloat() {
        return true;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean isFloatingPointNumber() {
        return true;
    }

    public FloatNode(float f) {
        this._value = f;
    }

    public static FloatNode valueOf(float f) {
        return new FloatNode(f);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.ValueNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeNode
    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeNode
    public JsonParser.NumberType numberType() {
        return JsonParser.NumberType.FLOAT;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean canConvertToInt() {
        float f = this._value;
        return f >= -2.1474836E9f && f <= 2.1474836E9f;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean canConvertToLong() {
        float f = this._value;
        return f >= -9.223372E18f && f <= 9.223372E18f;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public Number numberValue() {
        return Float.valueOf(this._value);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public short shortValue() {
        return (short) this._value;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public int intValue() {
        return (int) this._value;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public long longValue() {
        return (long) this._value;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public float floatValue() {
        return this._value;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public double doubleValue() {
        return this._value;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public BigDecimal decimalValue() {
        return BigDecimal.valueOf(this._value);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public BigInteger bigIntegerValue() {
        return decimalValue().toBigInteger();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public String asText() {
        return NumberOutput.toString(this._value);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode
    public boolean isNaN() {
        return Float.isNaN(this._value) || Float.isInfinite(this._value);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(this._value);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof FloatNode)) {
            return Float.compare(this._value, ((FloatNode) obj)._value) == 0;
        }
        return false;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return Float.floatToIntBits(this._value);
    }
}
