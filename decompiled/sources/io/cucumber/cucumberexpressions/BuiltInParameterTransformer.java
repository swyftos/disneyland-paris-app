package io.cucumber.cucumberexpressions;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes5.dex */
final class BuiltInParameterTransformer implements ParameterByTypeTransformer {
    private final NumberParser numberParser;

    BuiltInParameterTransformer(Locale locale) {
        this.numberParser = new NumberParser(locale);
    }

    @Override // io.cucumber.cucumberexpressions.ParameterByTypeTransformer
    public Object transform(String str, Type type) {
        if (!(type instanceof Class)) {
            throw createIllegalArgumentException(str, type);
        }
        Objects.requireNonNull(type);
        Class cls = (Class) type;
        if (str == null) {
            return null;
        }
        if (String.class.equals(cls) || Object.class.equals(cls)) {
            return str;
        }
        if (BigInteger.class.equals(cls)) {
            return new BigInteger(str);
        }
        if (BigDecimal.class.equals(cls)) {
            return this.numberParser.parseBigDecimal(str);
        }
        if (Byte.class.equals(cls) || Byte.TYPE.equals(cls)) {
            return Byte.decode(str);
        }
        if (Short.class.equals(cls) || Short.TYPE.equals(cls)) {
            return Short.decode(str);
        }
        if (Integer.class.equals(cls) || Integer.TYPE.equals(cls)) {
            return Integer.decode(str);
        }
        if (Long.class.equals(cls) || Long.TYPE.equals(cls)) {
            return Long.decode(str);
        }
        if (Float.class.equals(cls) || Float.TYPE.equals(cls)) {
            return Float.valueOf(this.numberParser.parseFloat(str));
        }
        if (Double.class.equals(cls) || Double.TYPE.equals(cls)) {
            return Double.valueOf(this.numberParser.parseDouble(str));
        }
        if (Boolean.class.equals(cls) || Boolean.TYPE.equals(cls)) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (cls.isEnum()) {
            for (Enum r2 : (Enum[]) cls.getEnumConstants()) {
                if (r2.name().equals(str)) {
                    return r2;
                }
            }
            throw new CucumberExpressionException("Can't transform '" + str + "' to " + type + ". Not an enum constant");
        }
        throw createIllegalArgumentException(str, type);
    }

    private IllegalArgumentException createIllegalArgumentException(String str, Type type) {
        return new IllegalArgumentException("Can't transform '" + str + "' to " + type + "\nBuiltInParameterTransformer only supports a limited number of class types\nConsider using a different object mapper or register a parameter type for " + type);
    }
}
