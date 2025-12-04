package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.SerializerProvider;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class MissingNode extends ValueNode {
    private static final MissingNode instance = new MissingNode();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public String asText(String str) {
        return str;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.ValueNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public <T extends JsonNode> T deepCopy() {
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeNode
    public boolean isMissingNode() {
        return true;
    }

    protected MissingNode() {
    }

    public static MissingNode getInstance() {
        return instance;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public JsonNodeType getNodeType() {
        return JsonNodeType.MISSING;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.ValueNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeNode
    public JsonToken asToken() {
        return JsonToken.NOT_AVAILABLE;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public String asText() {
        return "";
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNull();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.ValueNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonSerializable
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.writeNull();
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.ValueNode, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonNode
    public String toString() {
        return "";
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return JsonNodeType.MISSING.ordinal();
    }
}
