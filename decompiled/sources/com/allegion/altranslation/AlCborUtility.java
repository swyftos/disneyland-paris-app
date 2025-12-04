package com.allegion.altranslation;

import com.allegion.altranslation.interfaces.IAlCborUtility;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import com.fasterxml.jackson.dataformat.cbor.CBORGenerator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0004J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/allegion/altranslation/AlCborUtility;", "Lcom/allegion/altranslation/interfaces/IAlCborUtility;", "()V", "CBOR_FAIL_MSG", "", "NULL_MSG", "factory", "Lcom/fasterxml/jackson/dataformat/cbor/CBORFactory;", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "cborType", "Lcom/fasterxml/jackson/databind/node/JsonNodeType;", "cborData", "", "fromCbor", "", "object", "Ljava/lang/Class;", "getCborGenerator", "Lcom/fasterxml/jackson/dataformat/cbor/CBORGenerator;", "stream", "Ljava/io/ByteArrayOutputStream;", "toCbor", "AlTranslation_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlCborUtility implements IAlCborUtility {
    private final String CBOR_FAIL_MSG = "Failed to convert CBOR data";
    private final String NULL_MSG = "Null object provided";
    private final CBORFactory factory;
    private final ObjectMapper mapper;

    public AlCborUtility() {
        CBORFactory cBORFactory = new CBORFactory();
        this.factory = cBORFactory;
        this.mapper = new ObjectMapper(cBORFactory);
    }

    @Override // com.allegion.altranslation.interfaces.IAlCborUtility
    @NotNull
    public byte[] toCbor(@NotNull Object object) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(object, "object");
        try {
            byte[] bArrWriteValueAsBytes = this.mapper.writeValueAsBytes(object);
            Intrinsics.checkExpressionValueIsNotNull(bArrWriteValueAsBytes, "mapper.writeValueAsBytes(`object`)");
            return bArrWriteValueAsBytes;
        } catch (IOException e) {
            throw new AlTranslationComponentException(this.CBOR_FAIL_MSG, e);
        }
    }

    @Override // com.allegion.altranslation.interfaces.IAlCborUtility
    @NotNull
    public CBORGenerator getCborGenerator(@NotNull ByteArrayOutputStream stream) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(stream, "stream");
        try {
            CBORGenerator cBORGeneratorCreateGenerator = this.factory.createGenerator((OutputStream) stream);
            Intrinsics.checkExpressionValueIsNotNull(cBORGeneratorCreateGenerator, "factory.createGenerator(stream)");
            return cBORGeneratorCreateGenerator;
        } catch (IOException e) {
            throw new AlTranslationComponentException(this.CBOR_FAIL_MSG, e);
        }
    }

    @Override // com.allegion.altranslation.interfaces.IAlCborUtility
    @Nullable
    public Object fromCbor(@NotNull byte[] cborData, @NotNull Class<?> object) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(cborData, "cborData");
        Intrinsics.checkParameterIsNotNull(object, "object");
        try {
            if (Intrinsics.areEqual("ARRAY", cborType(cborData).name())) {
                return this.mapper.readValue(cborData, new TypeReference<List<? extends Object>>() { // from class: com.allegion.altranslation.AlCborUtility.fromCbor.1
                });
            }
            return this.mapper.readValue(cborData, object);
        } catch (IOException e) {
            throw new AlTranslationComponentException(this.CBOR_FAIL_MSG, e);
        }
    }

    @NotNull
    protected final JsonNodeType cborType(@NotNull byte[] cborData) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(cborData, "cborData");
        try {
            JsonNode tree = this.mapper.readTree(cborData);
            Intrinsics.checkExpressionValueIsNotNull(tree, "mapper.readTree(cborData)");
            JsonNodeType nodeType = tree.getNodeType();
            Intrinsics.checkExpressionValueIsNotNull(nodeType, "mapper.readTree(cborData).nodeType");
            return nodeType;
        } catch (IOException e) {
            throw new AlTranslationComponentException("Failed to build CBOR tree data", e);
        }
    }
}
