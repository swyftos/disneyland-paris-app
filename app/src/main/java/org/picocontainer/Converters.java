package org.picocontainer;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes5.dex */
public interface Converters {
    boolean canConvert(Type type);

    Object convert(String str, Type type);
}
