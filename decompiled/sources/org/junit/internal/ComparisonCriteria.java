package org.junit.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import okhttp3.HttpUrl;
import org.junit.Assert;

/* loaded from: classes6.dex */
public abstract class ComparisonCriteria {
    private static final Object END_OF_ARRAY_SENTINEL = objectWithToString("end of array");

    protected abstract void assertElementsEqual(Object obj, Object obj2);

    public void arrayEquals(String str, Object obj, Object obj2) throws ArrayComparisonFailure, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        arrayEquals(str, obj, obj2, true);
    }

    private void arrayEquals(String str, Object obj, Object obj2, boolean z) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == obj2 || Arrays.deepEquals(new Object[]{obj}, new Object[]{obj2})) {
            return;
        }
        String str2 = str == null ? "" : str + ": ";
        String str3 = z ? str2 : "";
        if (obj == null) {
            Assert.fail(str3 + "expected array was null");
        }
        if (obj2 == null) {
            Assert.fail(str3 + "actual array was null");
        }
        int length = Array.getLength(obj2);
        int length2 = Array.getLength(obj);
        if (length != length2) {
            str2 = str2 + "array lengths differed, expected.length=" + length2 + " actual.length=" + length + "; ";
        }
        int iMin = Math.min(length, length2);
        for (int i = 0; i < iMin; i++) {
            Object obj3 = Array.get(obj, i);
            Object obj4 = Array.get(obj2, i);
            if (isArray(obj3) && isArray(obj4)) {
                try {
                    arrayEquals(str, obj3, obj4, false);
                } catch (ArrayComparisonFailure e) {
                    e.addDimension(i);
                    throw e;
                } catch (AssertionError e2) {
                    throw new ArrayComparisonFailure(str2, e2, i);
                }
            } else {
                try {
                    assertElementsEqual(obj3, obj4);
                } catch (AssertionError e3) {
                    throw new ArrayComparisonFailure(str2, e3, i);
                }
            }
        }
        if (length != length2) {
            try {
                Assert.assertEquals(getToStringableArrayElement(obj, length2, iMin), getToStringableArrayElement(obj2, length, iMin));
            } catch (AssertionError e4) {
                throw new ArrayComparisonFailure(str2, e4, iMin);
            }
        }
    }

    private Object getToStringableArrayElement(Object obj, int i, int i2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (i2 < i) {
            Object obj2 = Array.get(obj, i2);
            if (!isArray(obj2)) {
                return obj2;
            }
            return objectWithToString(componentTypeName(obj2.getClass()) + "[" + Array.getLength(obj2) + "]");
        }
        return END_OF_ARRAY_SENTINEL;
    }

    private static Object objectWithToString(final String str) {
        return new Object() { // from class: org.junit.internal.ComparisonCriteria.1
            public String toString() {
                return str;
            }
        };
    }

    private String componentTypeName(Class cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType.isArray()) {
            return componentTypeName(componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return componentType.getName();
    }

    private boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }
}
