package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public class BigIntegerNode extends NumericNode {
    protected final BigInteger _value;
    private static final BigInteger MIN_INTEGER = BigInteger.valueOf(-2147483648L);
    private static final BigInteger MAX_INTEGER = BigInteger.valueOf(2147483647L);
    private static final BigInteger MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean isBigInteger() {
        return true;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean isIntegralNumber() {
        return true;
    }

    public BigIntegerNode(BigInteger bigInteger) {
        this._value = bigInteger;
    }

    public static BigIntegerNode valueOf(BigInteger bigInteger) {
        return new BigIntegerNode(bigInteger);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.ValueNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeNode
    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeNode
    public JsonParser.NumberType numberType() {
        return JsonParser.NumberType.BIG_INTEGER;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean canConvertToInt() {
        return this._value.compareTo(MIN_INTEGER) >= 0 && this._value.compareTo(MAX_INTEGER) <= 0;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean canConvertToLong() {
        return this._value.compareTo(MIN_LONG) >= 0 && this._value.compareTo(MAX_LONG) <= 0;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public Number numberValue() {
        return this._value;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public short shortValue() {
        return this._value.shortValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public int intValue() {
        return this._value.intValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public long longValue() {
        return this._value.longValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public BigInteger bigIntegerValue() {
        return this._value;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public float floatValue() {
        return this._value.floatValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public double doubleValue() {
        return this._value.doubleValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public BigDecimal decimalValue() {
        return new BigDecimal(this._value);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.NumericNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public String asText() {
        return this._value.toString();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean asBoolean(boolean z) {
        return !BigInteger.ZERO.equals(this._value);
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
        if (obj != null && (obj instanceof BigIntegerNode)) {
            return ((BigIntegerNode) obj)._value.equals(this._value);
        }
        return false;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return this._value.hashCode();
    }
}
