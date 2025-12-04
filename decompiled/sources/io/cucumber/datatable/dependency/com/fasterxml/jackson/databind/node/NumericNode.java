package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public abstract class NumericNode extends ValueNode {
    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public abstract String asText();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public abstract BigInteger bigIntegerValue();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public abstract boolean canConvertToInt();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public abstract boolean canConvertToLong();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public abstract BigDecimal decimalValue();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public abstract double doubleValue();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public abstract int intValue();

    public boolean isNaN() {
        return false;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public abstract long longValue();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeNode
    public abstract JsonParser.NumberType numberType();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public abstract Number numberValue();

    protected NumericNode() {
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public final JsonNodeType getNodeType() {
        return JsonNodeType.NUMBER;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public final int asInt() {
        return intValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public final int asInt(int i) {
        return intValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public final long asLong() {
        return longValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public final long asLong(long j) {
        return longValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public final double asDouble() {
        return doubleValue();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public final double asDouble(double d) {
        return doubleValue();
    }
}
