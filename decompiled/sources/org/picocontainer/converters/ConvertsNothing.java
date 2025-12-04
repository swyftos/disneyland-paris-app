package org.picocontainer.converters;

import java.lang.reflect.Type;
import org.picocontainer.Converters;

/* loaded from: classes6.dex */
public class ConvertsNothing implements Converters {
    @Override // org.picocontainer.Converters
    public boolean canConvert(Type type) {
        return false;
    }

    @Override // org.picocontainer.Converters
    public Object convert(String str, Type type) {
        return null;
    }
}
