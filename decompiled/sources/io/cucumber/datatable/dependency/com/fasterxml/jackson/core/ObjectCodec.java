package io.cucumber.datatable.dependency.com.fasterxml.jackson.core;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.ResolvedType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes5.dex */
public abstract class ObjectCodec extends TreeCodec implements Versioned {
    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeCodec
    public abstract TreeNode createArrayNode();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeCodec
    public abstract TreeNode createObjectNode();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeCodec
    public abstract <T extends TreeNode> T readTree(JsonParser jsonParser) throws IOException;

    public abstract <T> T readValue(JsonParser jsonParser, ResolvedType resolvedType) throws IOException;

    public abstract <T> T readValue(JsonParser jsonParser, TypeReference<?> typeReference) throws IOException;

    public abstract <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException;

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, ResolvedType resolvedType) throws IOException;

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, TypeReference<?> typeReference) throws IOException;

    public abstract <T> Iterator<T> readValues(JsonParser jsonParser, Class<T> cls) throws IOException;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeCodec
    public abstract JsonParser treeAsTokens(TreeNode treeNode);

    public abstract <T> T treeToValue(TreeNode treeNode, Class<T> cls) throws JsonProcessingException;

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Versioned
    public abstract Version version();

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.TreeCodec
    public abstract void writeTree(JsonGenerator jsonGenerator, TreeNode treeNode) throws IOException;

    public abstract void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException;

    protected ObjectCodec() {
    }

    @Deprecated
    public JsonFactory getJsonFactory() {
        return getFactory();
    }

    public JsonFactory getFactory() {
        return getJsonFactory();
    }
}
