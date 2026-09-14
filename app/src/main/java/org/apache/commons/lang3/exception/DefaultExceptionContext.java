package org.apache.commons.lang3.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultExceptionContext implements ExceptionContext, Serializable {
    private static final long serialVersionUID = 20110706;
    private final List contextValues = new ArrayList();

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext addContextValue(String str, Object obj) {
        this.contextValues.add(new ImmutablePair(str, obj));
        return this;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Pair<String, Object>> getContextEntries() {
        return this.contextValues;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Set<String> getContextLabels() {
        return (Set) stream().map(new Function() { // from class: org.apache.commons.lang3.exception.DefaultExceptionContext$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Pair) obj).getKey();
            }
        }).collect(Collectors.toSet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getContextValues$0(String str, Pair pair) {
        return Strings.f3987CS.equals(str, (String) pair.getKey());
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Object> getContextValues(final String str) {
        return (List) stream().filter(new Predicate() { // from class: org.apache.commons.lang3.exception.DefaultExceptionContext$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DefaultExceptionContext.lambda$getContextValues$0(str, (Pair) obj);
            }
        }).map(new DefaultExceptionContext$$ExternalSyntheticLambda1()).collect(Collectors.toList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getFirstContextValue$0(String str, Pair pair) {
        return Strings.f3987CS.equals(str, (String) pair.getKey());
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Object getFirstContextValue(final String str) {
        return stream().filter(new Predicate() { // from class: org.apache.commons.lang3.exception.DefaultExceptionContext$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DefaultExceptionContext.lambda$getFirstContextValue$0(str, (Pair) obj);
            }
        }).findFirst().map(new DefaultExceptionContext$$ExternalSyntheticLambda1()).orElse(null);
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public String getFormattedExceptionMessage(String str) {
        StringBuilder sb = new StringBuilder(256);
        if (str != null) {
            sb.append(str);
        }
        if (!this.contextValues.isEmpty()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append("Exception Context:\n");
            int i = 0;
            for (Pair pair : this.contextValues) {
                sb.append("\t[");
                i++;
                sb.append(i);
                sb.append(':');
                sb.append((String) pair.getKey());
                sb.append("=");
                try {
                    sb.append(Objects.toString(pair.getValue()));
                } catch (Exception e) {
                    sb.append("Exception thrown on toString(): ");
                    sb.append(ExceptionUtils.getStackTrace(e));
                }
                sb.append("]\n");
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setContextValue$0(String str, Pair pair) {
        return Strings.f3987CS.equals(str, (String) pair.getKey());
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext setContextValue(final String str, Object obj) {
        this.contextValues.removeIf(new Predicate() { // from class: org.apache.commons.lang3.exception.DefaultExceptionContext$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj2) {
                return DefaultExceptionContext.lambda$setContextValue$0(str, (Pair) obj2);
            }
        });
        addContextValue(str, obj);
        return this;
    }

    private Stream stream() {
        return this.contextValues.stream();
    }
}
