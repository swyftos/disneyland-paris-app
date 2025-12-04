package com.reactcommunity.rndatetimepicker;

import androidx.annotation.Nullable;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class ReflectionHelper {
    @Nullable
    public static Field findField(Class cls, Class cls2, String str) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType() == cls2) {
                    field.setAccessible(true);
                    return field;
                }
            }
            return null;
        }
    }
}
