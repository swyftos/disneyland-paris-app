package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.tuple.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class EqualsBuilder implements Builder<Boolean> {
    private static final ThreadLocal REGISTRY = ThreadLocal.withInitial(new EqualsBuilder$$ExternalSyntheticLambda0());
    private List bypassReflectionClasses;
    private String[] excludeFields;
    private boolean isEquals = true;
    private Class reflectUpToClass;
    private boolean testRecursive;
    private boolean testTransients;

    static Pair getRegisterPair(Object obj, Object obj2) {
        return Pair.m1982of(new IDKey(obj), new IDKey(obj2));
    }

    static Set getRegistry() {
        return (Set) REGISTRY.get();
    }

    static boolean isRegistered(Object obj, Object obj2) {
        Set registry = getRegistry();
        Pair registerPair = getRegisterPair(obj, obj2);
        return registry != null && (registry.contains(registerPair) || registry.contains(Pair.m1982of((IDKey) registerPair.getRight(), (IDKey) registerPair.getLeft())));
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z) {
        return reflectionEquals(obj, obj2, z, null, new String[0]);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z, Class<?> cls, boolean z2, String... strArr) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return new EqualsBuilder().setExcludeFields(strArr).setReflectUpToClass(cls).setTestTransients(z).setTestRecursive(z2).reflectionAppend(obj, obj2).isEquals();
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z, Class<?> cls, String... strArr) {
        return reflectionEquals(obj, obj2, z, cls, false, strArr);
    }

    public static boolean reflectionEquals(Object obj, Object obj2, Collection<String> collection) {
        return reflectionEquals(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static boolean reflectionEquals(Object obj, Object obj2, String... strArr) {
        return reflectionEquals(obj, obj2, false, null, strArr);
    }

    private static void register(Object obj, Object obj2) {
        getRegistry().add(getRegisterPair(obj, obj2));
    }

    private static void unregister(Object obj, Object obj2) {
        Set registry = getRegistry();
        registry.remove(getRegisterPair(obj, obj2));
        if (registry.isEmpty()) {
            REGISTRY.remove();
        }
    }

    public EqualsBuilder() {
        ArrayList arrayList = new ArrayList(1);
        this.bypassReflectionClasses = arrayList;
        arrayList.add(String.class);
    }

    public EqualsBuilder append(boolean z, boolean z2) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z == z2;
        return this;
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (!this.isEquals || zArr == zArr2) {
            return this;
        }
        if (zArr == null || zArr2 == null) {
            setEquals(false);
            return this;
        }
        if (zArr.length != zArr2.length) {
            setEquals(false);
            return this;
        }
        for (int i = 0; i < zArr.length && this.isEquals; i++) {
            append(zArr[i], zArr2[i]);
        }
        return this;
    }

    public EqualsBuilder append(byte b, byte b2) {
        if (this.isEquals) {
            this.isEquals = b == b2;
        }
        return this;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        if (!this.isEquals || bArr == bArr2) {
            return this;
        }
        if (bArr == null || bArr2 == null) {
            setEquals(false);
            return this;
        }
        if (bArr.length != bArr2.length) {
            setEquals(false);
            return this;
        }
        for (int i = 0; i < bArr.length && this.isEquals; i++) {
            append(bArr[i], bArr2[i]);
        }
        return this;
    }

    public EqualsBuilder append(char c, char c2) {
        if (this.isEquals) {
            this.isEquals = c == c2;
        }
        return this;
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        if (!this.isEquals || cArr == cArr2) {
            return this;
        }
        if (cArr == null || cArr2 == null) {
            setEquals(false);
            return this;
        }
        if (cArr.length != cArr2.length) {
            setEquals(false);
            return this;
        }
        for (int i = 0; i < cArr.length && this.isEquals; i++) {
            append(cArr[i], cArr2[i]);
        }
        return this;
    }

    public EqualsBuilder append(double d, double d2) {
        return this.isEquals ? append(Double.doubleToLongBits(d), Double.doubleToLongBits(d2)) : this;
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        if (!this.isEquals || dArr == dArr2) {
            return this;
        }
        if (dArr == null || dArr2 == null) {
            setEquals(false);
            return this;
        }
        if (dArr.length != dArr2.length) {
            setEquals(false);
            return this;
        }
        for (int i = 0; i < dArr.length && this.isEquals; i++) {
            append(dArr[i], dArr2[i]);
        }
        return this;
    }

    public EqualsBuilder append(float f, float f2) {
        return this.isEquals ? append(Float.floatToIntBits(f), Float.floatToIntBits(f2)) : this;
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        if (!this.isEquals || fArr == fArr2) {
            return this;
        }
        if (fArr == null || fArr2 == null) {
            setEquals(false);
            return this;
        }
        if (fArr.length != fArr2.length) {
            setEquals(false);
            return this;
        }
        for (int i = 0; i < fArr.length && this.isEquals; i++) {
            append(fArr[i], fArr2[i]);
        }
        return this;
    }

    public EqualsBuilder append(int i, int i2) {
        if (this.isEquals) {
            this.isEquals = i == i2;
        }
        return this;
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        if (!this.isEquals || iArr == iArr2) {
            return this;
        }
        if (iArr == null || iArr2 == null) {
            setEquals(false);
            return this;
        }
        if (iArr.length != iArr2.length) {
            setEquals(false);
            return this;
        }
        for (int i = 0; i < iArr.length && this.isEquals; i++) {
            append(iArr[i], iArr2[i]);
        }
        return this;
    }

    public EqualsBuilder append(long j, long j2) {
        if (this.isEquals) {
            this.isEquals = j == j2;
        }
        return this;
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        if (!this.isEquals || jArr == jArr2) {
            return this;
        }
        if (jArr == null || jArr2 == null) {
            setEquals(false);
            return this;
        }
        if (jArr.length != jArr2.length) {
            setEquals(false);
            return this;
        }
        for (int i = 0; i < jArr.length && this.isEquals; i++) {
            append(jArr[i], jArr2[i]);
        }
        return this;
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (!this.isEquals || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            setEquals(false);
            return this;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            appendArray(obj, obj2);
        } else if (this.testRecursive && !ClassUtils.isPrimitiveOrWrapper(cls)) {
            reflectionAppend(obj, obj2);
        } else {
            this.isEquals = obj.equals(obj2);
        }
        return this;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (!this.isEquals || objArr == objArr2) {
            return this;
        }
        if (objArr == null || objArr2 == null) {
            setEquals(false);
            return this;
        }
        if (objArr.length != objArr2.length) {
            setEquals(false);
            return this;
        }
        for (int i = 0; i < objArr.length && this.isEquals; i++) {
            append(objArr[i], objArr2[i]);
        }
        return this;
    }

    public EqualsBuilder append(short s, short s2) {
        if (this.isEquals) {
            this.isEquals = s == s2;
        }
        return this;
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        if (!this.isEquals || sArr == sArr2) {
            return this;
        }
        if (sArr == null || sArr2 == null) {
            setEquals(false);
            return this;
        }
        if (sArr.length != sArr2.length) {
            setEquals(false);
            return this;
        }
        for (int i = 0; i < sArr.length && this.isEquals; i++) {
            append(sArr[i], sArr2[i]);
        }
        return this;
    }

    private void appendArray(Object obj, Object obj2) {
        if (obj.getClass() != obj2.getClass()) {
            setEquals(false);
            return;
        }
        if (obj instanceof long[]) {
            append((long[]) obj, (long[]) obj2);
            return;
        }
        if (obj instanceof int[]) {
            append((int[]) obj, (int[]) obj2);
            return;
        }
        if (obj instanceof short[]) {
            append((short[]) obj, (short[]) obj2);
            return;
        }
        if (obj instanceof char[]) {
            append((char[]) obj, (char[]) obj2);
            return;
        }
        if (obj instanceof byte[]) {
            append((byte[]) obj, (byte[]) obj2);
            return;
        }
        if (obj instanceof double[]) {
            append((double[]) obj, (double[]) obj2);
            return;
        }
        if (obj instanceof float[]) {
            append((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj, (boolean[]) obj2);
        } else {
            append((Object[]) obj, (Object[]) obj2);
        }
    }

    public EqualsBuilder appendSuper(boolean z) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.builder.Builder
    public Boolean build() {
        return Boolean.valueOf(isEquals());
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0031  */
    public EqualsBuilder reflectionAppend(Object obj, Object obj2) {
        Class<?> superclass;
        if (!this.isEquals || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            this.isEquals = false;
            return this;
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (cls.isInstance(obj2)) {
            if (cls2.isInstance(obj)) {
                superclass = cls;
            } else {
                superclass = cls2;
            }
        } else if (cls2.isInstance(obj)) {
            if (cls.isInstance(obj2)) {
                superclass = cls2;
            } else {
                superclass = cls;
            }
        } else {
            this.isEquals = false;
            return this;
        }
        try {
            if (superclass.isArray()) {
                append(obj, obj2);
            } else {
                List list = this.bypassReflectionClasses;
                if (list != null && (list.contains(cls) || this.bypassReflectionClasses.contains(cls2))) {
                    this.isEquals = obj.equals(obj2);
                } else {
                    reflectionAppend(obj, obj2, superclass);
                    while (superclass.getSuperclass() != null && superclass != this.reflectUpToClass) {
                        superclass = superclass.getSuperclass();
                        reflectionAppend(obj, obj2, superclass);
                    }
                }
            }
        } catch (IllegalArgumentException unused) {
            this.isEquals = false;
        }
        return this;
    }

    private void reflectionAppend(Object obj, Object obj2, Class cls) {
        if (isRegistered(obj, obj2)) {
            return;
        }
        try {
            register(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i = 0; i < declaredFields.length && this.isEquals; i++) {
                Field field = declaredFields[i];
                if (!ArrayUtils.contains(this.excludeFields, field.getName()) && !field.getName().contains("$") && (this.testTransients || !Modifier.isTransient(field.getModifiers()))) {
                    if (!Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(EqualsExclude.class)) {
                        append(Reflection.getUnchecked(field, obj), Reflection.getUnchecked(field, obj2));
                    }
                }
            }
        } finally {
            unregister(obj, obj2);
        }
    }

    public void reset() {
        this.isEquals = true;
    }

    public EqualsBuilder setBypassReflectionClasses(List<Class<?>> list) {
        this.bypassReflectionClasses = list;
        return this;
    }

    protected void setEquals(boolean z) {
        this.isEquals = z;
    }

    public EqualsBuilder setExcludeFields(String... strArr) {
        this.excludeFields = strArr;
        return this;
    }

    public EqualsBuilder setReflectUpToClass(Class<?> cls) {
        this.reflectUpToClass = cls;
        return this;
    }

    public EqualsBuilder setTestRecursive(boolean z) {
        this.testRecursive = z;
        return this;
    }

    public EqualsBuilder setTestTransients(boolean z) {
        this.testTransients = z;
        return this;
    }
}
