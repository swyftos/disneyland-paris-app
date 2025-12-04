package org.picocontainer;

import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public interface Converters {
    boolean canConvert(Type type);

    Object convert(String str, Type type);
}
