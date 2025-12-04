package ch.qos.logback.core.pattern;

import ch.qos.logback.core.Context;

/* loaded from: classes2.dex */
public interface PostCompileProcessor<E> {
    void process(Context context, Converter<E> converter);
}
