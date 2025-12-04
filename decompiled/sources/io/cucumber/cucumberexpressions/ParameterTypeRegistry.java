package io.cucumber.cucumberexpressions;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class ParameterTypeRegistry {
    private ParameterByTypeTransformer defaultParameterTransformer;
    private final ParameterByTypeTransformer internalParameterTransformer;
    private final Map parameterTypeByName;
    private final Map parameterTypesByRegexp;
    private static final List INTEGER_REGEXPS = Arrays.asList(Pattern.compile("-?\\d+").pattern(), Pattern.compile("\\d+").pattern());
    private static final List FLOAT_REGEXPS = Collections.singletonList(Pattern.compile("-?\\d*[.,]\\d+").pattern());
    private static final List WORD_REGEXPS = Collections.singletonList(Pattern.compile("[^\\s]+").pattern());
    private static final List STRING_REGEXPS = Collections.singletonList(Pattern.compile("\"([^\"\\\\]*(\\\\.[^\"\\\\]*)*)\"|'([^'\\\\]*(\\\\.[^'\\\\]*)*)'").pattern());
    private static final String ANONYMOUS_REGEX = Pattern.compile(".*").pattern();

    public ParameterTypeRegistry(Locale locale) {
        this(new BuiltInParameterTransformer(locale));
    }

    private ParameterTypeRegistry(ParameterByTypeTransformer parameterByTypeTransformer) {
        this.parameterTypeByName = new HashMap();
        this.parameterTypesByRegexp = new HashMap();
        this.internalParameterTransformer = parameterByTypeTransformer;
        this.defaultParameterTransformer = parameterByTypeTransformer;
        List list = INTEGER_REGEXPS;
        defineParameterType(new ParameterType<>("biginteger", (List<String>) list, BigInteger.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.1
            @Override // io.cucumber.cucumberexpressions.Transformer
            public BigInteger transform(String str) {
                return (BigInteger) ParameterTypeRegistry.this.internalParameterTransformer.transform(str, BigInteger.class);
            }
        }, false, false));
        List list2 = FLOAT_REGEXPS;
        defineParameterType(new ParameterType<>("bigdecimal", (List<String>) list2, BigDecimal.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.2
            @Override // io.cucumber.cucumberexpressions.Transformer
            public BigDecimal transform(String str) {
                return (BigDecimal) ParameterTypeRegistry.this.internalParameterTransformer.transform(str, BigDecimal.class);
            }
        }, false, false));
        defineParameterType(new ParameterType<>("byte", (List<String>) list, Byte.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.3
            @Override // io.cucumber.cucumberexpressions.Transformer
            public Byte transform(String str) {
                return (Byte) ParameterTypeRegistry.this.internalParameterTransformer.transform(str, Byte.class);
            }
        }, false, false));
        defineParameterType(new ParameterType<>("short", (List<String>) list, Short.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.4
            @Override // io.cucumber.cucumberexpressions.Transformer
            public Short transform(String str) {
                return (Short) ParameterTypeRegistry.this.internalParameterTransformer.transform(str, Short.class);
            }
        }, false, false));
        defineParameterType(new ParameterType<>("int", (List<String>) list, Integer.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.5
            @Override // io.cucumber.cucumberexpressions.Transformer
            public Integer transform(String str) {
                return (Integer) ParameterTypeRegistry.this.internalParameterTransformer.transform(str, Integer.class);
            }
        }, true, true));
        defineParameterType(new ParameterType<>(LongTypedProperty.TYPE, (List<String>) list, Long.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.6
            @Override // io.cucumber.cucumberexpressions.Transformer
            public Long transform(String str) {
                return (Long) ParameterTypeRegistry.this.internalParameterTransformer.transform(str, Long.class);
            }
        }, false, false));
        defineParameterType(new ParameterType<>(TypedValues.Custom.S_FLOAT, (List<String>) list2, Float.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.7
            @Override // io.cucumber.cucumberexpressions.Transformer
            public Float transform(String str) {
                return (Float) ParameterTypeRegistry.this.internalParameterTransformer.transform(str, Float.class);
            }
        }, false, false));
        defineParameterType(new ParameterType<>(DoubleTypedProperty.TYPE, (List<String>) list2, Double.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.8
            @Override // io.cucumber.cucumberexpressions.Transformer
            public Double transform(String str) {
                return (Double) ParameterTypeRegistry.this.internalParameterTransformer.transform(str, Double.class);
            }
        }, true, true));
        defineParameterType(new ParameterType<>("word", (List<String>) WORD_REGEXPS, String.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.9
            @Override // io.cucumber.cucumberexpressions.Transformer
            public String transform(String str) {
                return (String) ParameterTypeRegistry.this.internalParameterTransformer.transform(str, String.class);
            }
        }, false, false));
        defineParameterType(new ParameterType<>("string", (List<String>) STRING_REGEXPS, String.class, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterTypeRegistry.10
            @Override // io.cucumber.cucumberexpressions.Transformer
            public String transform(String str) {
                if (str == null) {
                    return null;
                }
                return (String) ParameterTypeRegistry.this.internalParameterTransformer.transform(str.replaceAll("\\\\\"", "\"").replaceAll("\\\\'", "'"), String.class);
            }
        }, true, false));
        defineParameterType(ParameterType.createAnonymousParameterType(ANONYMOUS_REGEX));
    }

    public void defineParameterType(ParameterType<?> parameterType) {
        if (parameterType.getName() != null) {
            if (this.parameterTypeByName.containsKey(parameterType.getName())) {
                if (parameterType.getName().isEmpty()) {
                    throw new DuplicateTypeNameException("The anonymous parameter type has already been defined");
                }
                throw new DuplicateTypeNameException(String.format("There is already a parameter type with name %s", parameterType.getName()));
            }
            this.parameterTypeByName.put(parameterType.getName(), parameterType);
        }
        for (String str : parameterType.getRegexps()) {
            if (!this.parameterTypesByRegexp.containsKey(str)) {
                this.parameterTypesByRegexp.put(str, new TreeSet());
            }
            SortedSet sortedSet = (SortedSet) this.parameterTypesByRegexp.get(str);
            if (!sortedSet.isEmpty() && ((ParameterType) sortedSet.first()).preferForRegexpMatch() && parameterType.preferForRegexpMatch()) {
                throw new CucumberExpressionException(String.format("There can only be one preferential parameter type per regexp. The regexp /%s/ is used for two preferential parameter types, {%s} and {%s}", str, ((ParameterType) sortedSet.first()).getName(), parameterType.getName()));
            }
            sortedSet.add(parameterType);
        }
    }

    public ParameterByTypeTransformer getDefaultParameterTransformer() {
        return this.defaultParameterTransformer;
    }

    public void setDefaultParameterTransformer(ParameterByTypeTransformer parameterByTypeTransformer) {
        this.defaultParameterTransformer = parameterByTypeTransformer;
    }

    public <T> ParameterType<T> lookupByTypeName(String str) {
        return (ParameterType) this.parameterTypeByName.get(str);
    }

    public <T> ParameterType<T> lookupByRegexp(String str, Pattern pattern, String str2) {
        SortedSet sortedSet = (SortedSet) this.parameterTypesByRegexp.get(str);
        if (sortedSet == null) {
            return null;
        }
        if (sortedSet.size() > 1 && !((ParameterType) sortedSet.first()).preferForRegexpMatch()) {
            throw new AmbiguousParameterTypeException(str, pattern, sortedSet, new CucumberExpressionGenerator(this).generateExpressions(str2));
        }
        return (ParameterType) sortedSet.first();
    }

    public Collection<ParameterType<?>> getParameterTypes() {
        return this.parameterTypeByName.values();
    }
}
