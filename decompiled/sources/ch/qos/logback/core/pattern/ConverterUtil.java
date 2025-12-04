package ch.qos.logback.core.pattern;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAware;

/* loaded from: classes2.dex */
public class ConverterUtil {
    public static <E> Converter<E> findTail(Converter<E> converter) {
        while (converter != null) {
            Converter<E> next = converter.getNext();
            if (next == null) {
                break;
            }
            converter = next;
        }
        return converter;
    }

    public static <E> void setContextForConverters(Context context, Converter<E> converter) {
        while (converter != null) {
            if (converter instanceof ContextAware) {
                ((ContextAware) converter).setContext(context);
            }
            converter = converter.getNext();
        }
    }

    public static <E> void startConverters(Converter<E> converter) {
        DynamicConverter dynamicConverter;
        while (converter != null) {
            if (converter instanceof CompositeConverter) {
                CompositeConverter compositeConverter = (CompositeConverter) converter;
                startConverters(compositeConverter.childConverter);
                dynamicConverter = compositeConverter;
            } else if (converter instanceof DynamicConverter) {
                dynamicConverter = (DynamicConverter) converter;
            } else {
                converter = converter.getNext();
            }
            dynamicConverter.start();
            converter = converter.getNext();
        }
    }
}
