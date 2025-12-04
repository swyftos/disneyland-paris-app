package io.cucumber.cucumberexpressions;

import java.lang.reflect.Type;

/* loaded from: classes5.dex */
final class ObjectMapperTransformer implements Transformer {
    private final Type toValueType;
    private final ParameterByTypeTransformer transformer;

    ObjectMapperTransformer(ParameterByTypeTransformer parameterByTypeTransformer, Type type) {
        this.transformer = parameterByTypeTransformer;
        this.toValueType = type;
    }

    @Override // io.cucumber.cucumberexpressions.Transformer
    public Object transform(String str) {
        return this.transformer.transform(str, this.toValueType);
    }
}
