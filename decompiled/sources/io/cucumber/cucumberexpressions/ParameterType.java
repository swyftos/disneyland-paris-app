package io.cucumber.cucumberexpressions;

import gherkin.GherkinLanguageConstants;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class ParameterType<T> implements Comparable<ParameterType<?>> {
    private static final Pattern ILLEGAL_PARAMETER_NAME_PATTERN = Pattern.compile("([\\[\\]()$.|?*+])");
    private static final Pattern UNESCAPE_PATTERN = Pattern.compile("(\\\\([\\[$.|?*+\\]]))");
    private final boolean anonymous;
    private final String name;
    private final boolean preferForRegexpMatch;
    private final List regexps;
    private final CaptureGroupTransformer transformer;
    private final Type type;
    private final boolean useForSnippets;

    static void checkParameterTypeName(String str) {
        String strReplaceAll = UNESCAPE_PATTERN.matcher(str).replaceAll("$2");
        Matcher matcher = ILLEGAL_PARAMETER_NAME_PATTERN.matcher(strReplaceAll);
        if (matcher.find()) {
            throw new CucumberExpressionException(String.format("Illegal character '%s' in parameter name {%s}.", matcher.group(1), strReplaceAll));
        }
    }

    static ParameterType createAnonymousParameterType(String str) {
        return new ParameterType("", Collections.singletonList(str), Object.class, new CaptureGroupTransformer() { // from class: io.cucumber.cucumberexpressions.ParameterType.1
            @Override // io.cucumber.cucumberexpressions.CaptureGroupTransformer
            public Object transform(String[] strArr) {
                throw new UnsupportedOperationException("Anonymous transform must be deanonymized before use");
            }
        }, false, true, true);
    }

    public static <E extends Enum> ParameterType<E> fromEnum(final Class<E> cls) {
        E[] enumConstants = cls.getEnumConstants();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < enumConstants.length; i++) {
            if (i > 0) {
                sb.append(GherkinLanguageConstants.TABLE_CELL_SEPARATOR);
            }
            sb.append(enumConstants[i].name());
        }
        return new ParameterType<>(cls.getSimpleName(), sb.toString(), cls, new Transformer() { // from class: io.cucumber.cucumberexpressions.ParameterType.2
            @Override // io.cucumber.cucumberexpressions.Transformer
            public Enum transform(String str) {
                return Enum.valueOf(cls, str);
            }
        });
    }

    private ParameterType(String str, List list, Type type, CaptureGroupTransformer captureGroupTransformer, boolean z, boolean z2, boolean z3) {
        if (list == null) {
            throw new NullPointerException("regexps cannot be null");
        }
        if (type == null) {
            throw new NullPointerException("type cannot be null");
        }
        if (captureGroupTransformer == null) {
            throw new NullPointerException("transformer cannot be null");
        }
        if (str != null) {
            checkParameterTypeName(str);
        }
        this.name = str;
        this.regexps = list;
        this.type = type;
        this.transformer = captureGroupTransformer;
        this.useForSnippets = z;
        this.preferForRegexpMatch = z2;
        this.anonymous = z3;
    }

    public ParameterType(String str, List<String> list, Type type, CaptureGroupTransformer<T> captureGroupTransformer, boolean z, boolean z2) {
        this(str, list, type, captureGroupTransformer, z, z2, false);
    }

    public ParameterType(String str, List<String> list, Class<T> cls, CaptureGroupTransformer<T> captureGroupTransformer, boolean z, boolean z2) {
        this(str, list, (Type) cls, (CaptureGroupTransformer) captureGroupTransformer, z, z2);
    }

    public ParameterType(String str, String str2, Class<T> cls, CaptureGroupTransformer<T> captureGroupTransformer, boolean z, boolean z2) {
        this(str, (List<String>) Collections.singletonList(str2), (Class) cls, (CaptureGroupTransformer) captureGroupTransformer, z, z2);
    }

    public ParameterType(String str, List<String> list, Class<T> cls, CaptureGroupTransformer<T> captureGroupTransformer) {
        this(str, list, (Class) cls, (CaptureGroupTransformer) captureGroupTransformer, true, false);
    }

    public ParameterType(String str, String str2, Class<T> cls, CaptureGroupTransformer<T> captureGroupTransformer) {
        this(str, (List<String>) Collections.singletonList(str2), (Class) cls, (CaptureGroupTransformer) captureGroupTransformer, true, false);
    }

    public ParameterType(String str, List<String> list, Type type, Transformer<T> transformer, boolean z, boolean z2) {
        this(str, list, type, new TransformerAdaptor(transformer), z, z2);
    }

    public ParameterType(String str, List<String> list, Class<T> cls, Transformer<T> transformer, boolean z, boolean z2) {
        this(str, list, (Type) cls, (Transformer) transformer, z, z2);
    }

    public ParameterType(String str, String str2, Class<T> cls, Transformer<T> transformer, boolean z, boolean z2) {
        this(str, (List<String>) Collections.singletonList(str2), (Class) cls, (Transformer) transformer, z, z2);
    }

    public ParameterType(String str, List<String> list, Class<T> cls, Transformer<T> transformer) {
        this(str, list, (Class) cls, (Transformer) transformer, true, false);
    }

    public ParameterType(String str, String str2, Class<T> cls, Transformer<T> transformer) {
        this(str, (List<String>) Collections.singletonList(str2), (Class) cls, (Transformer) transformer, true, false);
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public List<String> getRegexps() {
        return this.regexps;
    }

    public boolean preferForRegexpMatch() {
        return this.preferForRegexpMatch;
    }

    public boolean useForSnippets() {
        return this.useForSnippets;
    }

    boolean isAnonymous() {
        return this.anonymous;
    }

    ParameterType deAnonymize(Type type, Transformer transformer) {
        return new ParameterType("anonymous", this.regexps, type, new TransformerAdaptor(transformer), this.useForSnippets, this.preferForRegexpMatch, this.anonymous);
    }

    Object transform(List list) {
        if ((this.transformer instanceof TransformerAdaptor) && list.size() > 1) {
            if (isAnonymous()) {
                throw new CucumberExpressionException(String.format("Anonymous ParameterType has multiple capture groups %s. You can only use a single capture group in an anonymous ParameterType.", this.regexps));
            }
            throw new CucumberExpressionException(String.format("ParameterType {%s} was registered with a Transformer but has multiple capture groups %s. Did you mean to use a CaptureGroupTransformer?", this.name, this.regexps));
        }
        try {
            return this.transformer.transform((String[]) list.toArray(new String[0]));
        } catch (CucumberExpressionException e) {
            throw e;
        } catch (Throwable th) {
            throw new CucumberExpressionException(String.format("ParameterType {%s} failed to transform %s to %s", this.name, list, this.type), th);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(ParameterType<?> parameterType) {
        if (preferForRegexpMatch() && !parameterType.preferForRegexpMatch()) {
            return -1;
        }
        if (!parameterType.preferForRegexpMatch() || preferForRegexpMatch()) {
            return (getName() != null ? getName() : "").compareTo(parameterType.getName() != null ? parameterType.getName() : "");
        }
        return 1;
    }

    private static final class TransformerAdaptor implements CaptureGroupTransformer {
        private final Transformer transformer;

        private TransformerAdaptor(Transformer transformer) {
            if (transformer == null) {
                throw new NullPointerException("transformer cannot be null");
            }
            this.transformer = transformer;
        }

        @Override // io.cucumber.cucumberexpressions.CaptureGroupTransformer
        public Object transform(String[] strArr) {
            return this.transformer.transform(strArr.length == 0 ? null : strArr[0]);
        }
    }
}
