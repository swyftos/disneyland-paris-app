package org.apache.commons.lang3.builder;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
abstract class Reflection {
    static Object getUnchecked(Field field, Object obj) {
        try {
            Objects.requireNonNull(field, "field");
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
