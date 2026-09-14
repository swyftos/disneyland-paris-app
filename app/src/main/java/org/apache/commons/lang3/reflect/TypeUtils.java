package org.apache.commons.lang3.reflect;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.AppendableJoiner;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.function.FailableBiConsumer;

/* JADX INFO: loaded from: classes6.dex */
public class TypeUtils {
    private static final AppendableJoiner AMP_JOINER = AppendableJoiner.builder().setDelimiter(" & ").setElementAppender(new FailableBiConsumer() { // from class: org.apache.commons.lang3.reflect.TypeUtils$$ExternalSyntheticLambda0
        @Override // org.apache.commons.lang3.function.FailableBiConsumer
        public final void accept(Object obj, Object obj2) throws IOException {
            TypeUtils.lambda$static$0((Appendable) obj, (Type) obj2);
        }
    }).get();
    private static final AppendableJoiner CTJ_JOINER = AppendableJoiner.builder().setDelimiter(", ").setElementAppender(new FailableBiConsumer() { // from class: org.apache.commons.lang3.reflect.TypeUtils$$ExternalSyntheticLambda1
        @Override // org.apache.commons.lang3.function.FailableBiConsumer
        public final void accept(Object obj, Object obj2) throws IOException {
            TypeUtils.lambda$static$1((Appendable) obj, (TypeVariable) obj2);
        }
    }).get();
    private static final AppendableJoiner GT_JOINER = AppendableJoiner.builder().setPrefix("<").setSuffix(">").setDelimiter(", ").setElementAppender(new FailableBiConsumer() { // from class: org.apache.commons.lang3.reflect.TypeUtils$$ExternalSyntheticLambda2
        @Override // org.apache.commons.lang3.function.FailableBiConsumer
        public final void accept(Object obj, Object obj2) throws IOException {
            TypeUtils.lambda$static$2((Appendable) obj, obj2);
        }
    }).get();
    public static final WildcardType WILDCARD_ALL = wildcardType().withUpperBounds(Object.class).build();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Type lambda$wrap$0(Type type) {
        return type;
    }

    private static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        private GenericArrayTypeImpl(Type type) {
            this.componentType = type;
        }

        public boolean equals(Object obj) {
            return obj == this || ((obj instanceof GenericArrayType) && TypeUtils.equals((GenericArrayType) this, (Type) obj));
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode() | 1072;
        }

        public String toString() {
            return TypeUtils.toString(this);
        }
    }

    private static final class ParameterizedTypeImpl implements ParameterizedType {
        private final Class raw;
        private final Type[] typeArguments;
        private final Type useOwner;

        private ParameterizedTypeImpl(Class cls, Type type, Type[] typeArr) {
            this.raw = cls;
            this.useOwner = type;
            this.typeArguments = (Type[]) Arrays.copyOf(typeArr, typeArr.length, Type[].class);
        }

        public boolean equals(Object obj) {
            return obj == this || ((obj instanceof ParameterizedType) && TypeUtils.equals((ParameterizedType) this, (Type) obj));
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.useOwner;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.raw;
        }

        public int hashCode() {
            return Arrays.hashCode(this.typeArguments) | ((((this.raw.hashCode() | 1136) << 4) | Objects.hashCode(this.useOwner)) << 8);
        }

        public String toString() {
            return TypeUtils.toString(this);
        }
    }

    public static class WildcardTypeBuilder implements Builder<WildcardType> {
        private Type[] lowerBounds;
        private Type[] upperBounds;

        private WildcardTypeBuilder() {
        }

        @Override // org.apache.commons.lang3.builder.Builder
        public WildcardType build() {
            return new WildcardTypeImpl(this.upperBounds, this.lowerBounds);
        }

        public WildcardTypeBuilder withLowerBounds(Type... typeArr) {
            this.lowerBounds = typeArr;
            return this;
        }

        public WildcardTypeBuilder withUpperBounds(Type... typeArr) {
            this.upperBounds = typeArr;
            return this;
        }
    }

    private static final class WildcardTypeImpl implements WildcardType {
        private final Type[] lowerBounds;
        private final Type[] upperBounds;

        private WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Type[] typeArr3 = ArrayUtils.EMPTY_TYPE_ARRAY;
            this.upperBounds = (Type[]) ObjectUtils.getIfNull(typeArr, typeArr3);
            this.lowerBounds = (Type[]) ObjectUtils.getIfNull(typeArr2, typeArr3);
        }

        public boolean equals(Object obj) {
            return obj == this || ((obj instanceof WildcardType) && TypeUtils.equals((WildcardType) this, (Type) obj));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return (Type[]) this.lowerBounds.clone();
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return (Type[]) this.upperBounds.clone();
        }

        public int hashCode() {
            return Arrays.hashCode(this.lowerBounds) | ((Arrays.hashCode(this.upperBounds) | 18688) << 8);
        }

        public String toString() {
            return TypeUtils.toString(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Appendable appendable, Type type) throws IOException {
        appendable.append(toString(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(Appendable appendable, TypeVariable typeVariable) throws IOException {
        appendable.append(anyToString(typeVariable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$2(Appendable appendable, Object obj) throws IOException {
        appendable.append(anyToString(obj));
    }

    private static String anyToString(Object obj) {
        return obj instanceof Type ? toString((Type) obj) : obj.toString();
    }

    private static void appendRecursiveTypes(StringBuilder sb, int[] iArr, Type[] typeArr) {
        for (int i = 0; i < iArr.length; i++) {
            GT_JOINER.join(sb, typeArr[i].toString());
        }
        Type[] typeArr2 = (Type[]) ArrayUtils.removeAll((Object[]) typeArr, iArr);
        if (typeArr2.length > 0) {
            GT_JOINER.join(sb, typeArr2);
        }
    }

    private static String classToString(Class cls) {
        if (cls.isArray()) {
            return toString(cls.getComponentType()) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        if (isCyclical(cls)) {
            return cls.getSimpleName() + "(cycle)";
        }
        StringBuilder sb = new StringBuilder();
        if (cls.getEnclosingClass() != null) {
            sb.append(classToString(cls.getEnclosingClass()));
            sb.append('.');
            sb.append(cls.getSimpleName());
        } else {
            sb.append(cls.getName());
        }
        if (cls.getTypeParameters().length > 0) {
            GT_JOINER.join(sb, cls.getTypeParameters());
        }
        return sb.toString();
    }

    public static boolean containsTypeVariables(Type type) {
        if (type instanceof TypeVariable) {
            return true;
        }
        if (type instanceof Class) {
            return ((Class) type).getTypeParameters().length > 0;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (containsTypeVariables(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            return containsTypeVariables(getImplicitLowerBounds(wildcardType)[0]) || containsTypeVariables(getImplicitUpperBounds(wildcardType)[0]);
        }
        if (type instanceof GenericArrayType) {
            return containsTypeVariables(((GenericArrayType) type).getGenericComponentType());
        }
        return false;
    }

    private static boolean containsVariableTypeSameParametrizedTypeBound(TypeVariable typeVariable, ParameterizedType parameterizedType) {
        return ArrayUtils.contains(typeVariable.getBounds(), parameterizedType);
    }

    public static Map<TypeVariable<?>, Type> determineTypeArguments(Class<?> cls, ParameterizedType parameterizedType) {
        Objects.requireNonNull(cls, "cls");
        Objects.requireNonNull(parameterizedType, "superParameterizedType");
        Class rawType = getRawType(parameterizedType);
        if (!isAssignable((Type) cls, rawType)) {
            return null;
        }
        if (cls.equals(rawType)) {
            return getTypeArguments(parameterizedType, rawType, (Map) null);
        }
        Type closestParentType = getClosestParentType(cls, rawType);
        if (closestParentType instanceof Class) {
            return determineTypeArguments((Class) closestParentType, parameterizedType);
        }
        ParameterizedType parameterizedType2 = (ParameterizedType) closestParentType;
        Map<TypeVariable<?>, Type> mapDetermineTypeArguments = determineTypeArguments(getRawType(parameterizedType2), parameterizedType);
        mapTypeVariablesToArguments(cls, parameterizedType2, mapDetermineTypeArguments);
        return mapDetermineTypeArguments;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equals(GenericArrayType genericArrayType, Type type) {
        return (type instanceof GenericArrayType) && equals(genericArrayType.getGenericComponentType(), ((GenericArrayType) type).getGenericComponentType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equals(ParameterizedType parameterizedType, Type type) {
        if (!(type instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType2 = (ParameterizedType) type;
        if (equals(parameterizedType.getRawType(), parameterizedType2.getRawType()) && equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType())) {
            return equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        return false;
    }

    public static boolean equals(Type type, Type type2) {
        if (Objects.equals(type, type2)) {
            return true;
        }
        if (type instanceof ParameterizedType) {
            return equals((ParameterizedType) type, type2);
        }
        if (type instanceof GenericArrayType) {
            return equals((GenericArrayType) type, type2);
        }
        if (type instanceof WildcardType) {
            return equals((WildcardType) type, type2);
        }
        return false;
    }

    private static boolean equals(Type[] typeArr, Type[] typeArr2) {
        if (typeArr.length != typeArr2.length) {
            return false;
        }
        for (int i = 0; i < typeArr.length; i++) {
            if (!equals(typeArr[i], typeArr2[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equals(WildcardType wildcardType, Type type) {
        if (!(type instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType2 = (WildcardType) type;
        return equals(getImplicitLowerBounds(wildcardType), getImplicitLowerBounds(wildcardType2)) && equals(getImplicitUpperBounds(wildcardType), getImplicitUpperBounds(wildcardType2));
    }

    private static Type[] extractTypeArgumentsFrom(Map map, TypeVariable[] typeVariableArr) {
        Type[] typeArr = new Type[typeVariableArr.length];
        int length = typeVariableArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            final TypeVariable typeVariable = typeVariableArr[i];
            Validate.isTrue(map.containsKey(typeVariable), new Supplier() { // from class: org.apache.commons.lang3.reflect.TypeUtils$$ExternalSyntheticLambda4
                @Override // java.util.function.Supplier
                public final Object get() {
                    return TypeUtils.lambda$extractTypeArgumentsFrom$0(typeVariable);
                }
            });
            typeArr[i2] = (Type) map.get(typeVariable);
            i++;
            i2++;
        }
        return typeArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$extractTypeArgumentsFrom$0(TypeVariable typeVariable) {
        return String.format("missing argument mapping for %s", toString(typeVariable));
    }

    private static int[] findRecursiveTypes(ParameterizedType parameterizedType) {
        Type[] typeArr = (Type[]) Arrays.copyOf(parameterizedType.getActualTypeArguments(), parameterizedType.getActualTypeArguments().length);
        int[] iArrAdd = new int[0];
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if ((type instanceof TypeVariable) && containsVariableTypeSameParametrizedTypeBound((TypeVariable) type, parameterizedType)) {
                iArrAdd = ArrayUtils.add(iArrAdd, i);
            }
        }
        return iArrAdd;
    }

    public static GenericArrayType genericArrayType(Type type) {
        Objects.requireNonNull(type, "componentType");
        return new GenericArrayTypeImpl(type);
    }

    private static String genericArrayTypeToString(GenericArrayType genericArrayType) {
        return String.format("%s[]", toString(genericArrayType.getGenericComponentType()));
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return cls.getComponentType();
            }
            return null;
        }
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return null;
    }

    private static Type getClosestParentType(Class cls, Class cls2) {
        Class rawType;
        if (cls2.isInterface()) {
            Type type = null;
            for (Type type2 : cls.getGenericInterfaces()) {
                if (type2 instanceof ParameterizedType) {
                    rawType = getRawType((ParameterizedType) type2);
                } else if (type2 instanceof Class) {
                    rawType = (Class) type2;
                } else {
                    throw new IllegalStateException("Unexpected generic interface type found: " + type2);
                }
                if (isAssignable((Type) rawType, cls2) && isAssignable(type, (Type) rawType)) {
                    type = type2;
                }
            }
            if (type != null) {
                return type;
            }
        }
        return cls.getGenericSuperclass();
    }

    public static Type[] getImplicitBounds(TypeVariable<?> typeVariable) {
        Objects.requireNonNull(typeVariable, "typeVariable");
        return normalizeUpperToObject(typeVariable.getBounds());
    }

    public static Type[] getImplicitLowerBounds(WildcardType wildcardType) {
        Objects.requireNonNull(wildcardType, "wildcardType");
        Type[] lowerBounds = wildcardType.getLowerBounds();
        return lowerBounds.length == 0 ? new Type[]{null} : lowerBounds;
    }

    public static Type[] getImplicitUpperBounds(WildcardType wildcardType) {
        Objects.requireNonNull(wildcardType, "wildcardType");
        return normalizeUpperToObject(wildcardType.getUpperBounds());
    }

    private static Class getRawType(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        if (!(rawType instanceof Class)) {
            throw new IllegalStateException("Type of rawType: " + rawType);
        }
        return (Class) rawType;
    }

    public static Class<?> getRawType(Type type, Type type2) {
        Map<TypeVariable<?>, Type> typeArguments;
        Type type3;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawType((ParameterizedType) type);
        }
        if (type instanceof TypeVariable) {
            if (type2 == null) {
                return null;
            }
            GenericDeclaration genericDeclaration = ((TypeVariable) type).getGenericDeclaration();
            if (!(genericDeclaration instanceof Class) || (typeArguments = getTypeArguments(type2, (Class) genericDeclaration)) == null || (type3 = typeArguments.get(type)) == null) {
                return null;
            }
            return getRawType(type3, type2);
        }
        if (type instanceof GenericArrayType) {
            Class<?> rawType = getRawType(((GenericArrayType) type).getGenericComponentType(), type2);
            if (rawType != null) {
                return Array.newInstance(rawType, 0).getClass();
            }
            return null;
        }
        if (type instanceof WildcardType) {
            return null;
        }
        throw new IllegalArgumentException("unknown type: " + type);
    }

    private static Map getTypeArguments(Class cls, Class cls2, Map map) {
        if (!isAssignable((Type) cls, cls2)) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (cls2.isPrimitive()) {
                return new HashMap();
            }
            cls = ClassUtils.primitiveToWrapper(cls);
        }
        HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        return cls2.equals(cls) ? map2 : getTypeArguments(getClosestParentType(cls, cls2), cls2, map2);
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType parameterizedType) {
        return getTypeArguments(parameterizedType, getRawType(parameterizedType), (Map) null);
    }

    private static Map getTypeArguments(ParameterizedType parameterizedType, Class cls, Map map) {
        Map map2;
        Class rawType = getRawType(parameterizedType);
        if (!isAssignable((Type) rawType, cls)) {
            return null;
        }
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            ParameterizedType parameterizedType2 = (ParameterizedType) ownerType;
            map2 = getTypeArguments(parameterizedType2, getRawType(parameterizedType2), map);
        } else {
            map2 = map == null ? new HashMap() : new HashMap(map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable[] typeParameters = rawType.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            Type type = actualTypeArguments[i];
            map2.put(typeParameters[i], (Type) map2.getOrDefault(type, type));
        }
        return cls.equals(rawType) ? map2 : getTypeArguments(getClosestParentType(rawType, cls), cls, map2);
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(Type type, Class<?> cls) {
        return getTypeArguments(type, cls, (Map) null);
    }

    private static Map getTypeArguments(Type type, Class cls, Map map) {
        if (type instanceof Class) {
            return getTypeArguments((Class) type, cls, map);
        }
        if (type instanceof ParameterizedType) {
            return getTypeArguments((ParameterizedType) type, cls, map);
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (cls.isArray()) {
                cls = cls.getComponentType();
            }
            return getTypeArguments(genericComponentType, cls, map);
        }
        int i = 0;
        if (type instanceof WildcardType) {
            Type[] implicitUpperBounds = getImplicitUpperBounds((WildcardType) type);
            int length = implicitUpperBounds.length;
            while (i < length) {
                Type type2 = implicitUpperBounds[i];
                if (isAssignable(type2, cls)) {
                    return getTypeArguments(type2, cls, map);
                }
                i++;
            }
            return null;
        }
        if (type instanceof TypeVariable) {
            Type[] implicitBounds = getImplicitBounds((TypeVariable) type);
            int length2 = implicitBounds.length;
            while (i < length2) {
                Type type3 = implicitBounds[i];
                if (isAssignable(type3, cls)) {
                    return getTypeArguments(type3, cls, map);
                }
                i++;
            }
            return null;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    public static boolean isArrayType(Type type) {
        return (type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray());
    }

    private static boolean isAssignable(Type type, Class cls) {
        if (type == null) {
            return cls == null || !cls.isPrimitive();
        }
        if (cls == null) {
            return false;
        }
        if (cls.equals(type)) {
            return true;
        }
        if (type instanceof Class) {
            return ClassUtils.isAssignable((Class<?>) type, (Class<?>) cls);
        }
        if (type instanceof ParameterizedType) {
            return isAssignable((Type) getRawType((ParameterizedType) type), cls);
        }
        if (type instanceof TypeVariable) {
            for (Type type2 : ((TypeVariable) type).getBounds()) {
                if (isAssignable(type2, cls)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            if (cls.equals(Object.class)) {
                return true;
            }
            return cls.isArray() && isAssignable(((GenericArrayType) type).getGenericComponentType(), (Class) cls.getComponentType());
        }
        if (type instanceof WildcardType) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    private static boolean isAssignable(Type type, GenericArrayType genericArrayType, Map map) {
        if (type == null) {
            return true;
        }
        if (genericArrayType == null) {
            return false;
        }
        if (genericArrayType.equals(type)) {
            return true;
        }
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() && isAssignable(cls.getComponentType(), genericComponentType, map);
        }
        if (type instanceof GenericArrayType) {
            return isAssignable(((GenericArrayType) type).getGenericComponentType(), genericComponentType, map);
        }
        if (type instanceof WildcardType) {
            for (Type type2 : getImplicitUpperBounds((WildcardType) type)) {
                if (isAssignable(type2, genericArrayType)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof TypeVariable) {
            for (Type type3 : getImplicitBounds((TypeVariable) type)) {
                if (isAssignable(type3, genericArrayType)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof ParameterizedType) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    private static boolean isAssignable(Type type, ParameterizedType parameterizedType, Map map) {
        if (type == null) {
            return true;
        }
        if (parameterizedType == null || (type instanceof GenericArrayType)) {
            return false;
        }
        if (parameterizedType.equals(type)) {
            return true;
        }
        Class rawType = getRawType(parameterizedType);
        Map typeArguments = getTypeArguments(type, rawType, (Map) null);
        if (typeArguments == null) {
            return false;
        }
        if (typeArguments.isEmpty()) {
            return true;
        }
        Map typeArguments2 = getTypeArguments(parameterizedType, rawType, map);
        for (TypeVariable typeVariable : typeArguments2.keySet()) {
            Type typeUnrollVariableAssignments = unrollVariableAssignments(typeVariable, typeArguments2);
            Type typeUnrollVariableAssignments2 = unrollVariableAssignments(typeVariable, typeArguments);
            if (typeUnrollVariableAssignments != null || !(typeUnrollVariableAssignments2 instanceof Class)) {
                if (typeUnrollVariableAssignments2 != null && typeUnrollVariableAssignments != null && !typeUnrollVariableAssignments.equals(typeUnrollVariableAssignments2) && (!(typeUnrollVariableAssignments instanceof WildcardType) || !isAssignable(typeUnrollVariableAssignments2, typeUnrollVariableAssignments, map))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAssignable(Type type, Type type2) {
        return isAssignable(type, type2, (Map) null);
    }

    private static boolean isAssignable(Type type, Type type2, Map map) {
        if (type2 == null || (type2 instanceof Class)) {
            return isAssignable(type, (Class) type2);
        }
        if (type2 instanceof ParameterizedType) {
            return isAssignable(type, (ParameterizedType) type2, map);
        }
        if (type2 instanceof GenericArrayType) {
            return isAssignable(type, (GenericArrayType) type2, map);
        }
        if (type2 instanceof WildcardType) {
            return isAssignable(type, (WildcardType) type2, map);
        }
        if (type2 instanceof TypeVariable) {
            return isAssignable(type, (TypeVariable) type2, map);
        }
        throw new IllegalStateException("found an unhandled type: " + type2);
    }

    private static boolean isAssignable(Type type, TypeVariable typeVariable, Map map) {
        if (type == null) {
            return true;
        }
        if (typeVariable == null) {
            return false;
        }
        if (typeVariable.equals(type)) {
            return true;
        }
        if (type instanceof TypeVariable) {
            for (Type type2 : getImplicitBounds((TypeVariable) type)) {
                if (isAssignable(type2, typeVariable, map)) {
                    return true;
                }
            }
        }
        if ((type instanceof Class) || (type instanceof ParameterizedType) || (type instanceof GenericArrayType) || (type instanceof WildcardType)) {
            return false;
        }
        throw new IllegalStateException("found an unhandled type: " + type);
    }

    private static boolean isAssignable(Type type, WildcardType wildcardType, Map map) {
        if (type == null) {
            return true;
        }
        if (wildcardType == null) {
            return false;
        }
        if (wildcardType.equals(type)) {
            return true;
        }
        Type[] implicitUpperBounds = getImplicitUpperBounds(wildcardType);
        Type[] implicitLowerBounds = getImplicitLowerBounds(wildcardType);
        if (type instanceof WildcardType) {
            WildcardType wildcardType2 = (WildcardType) type;
            Type[] implicitUpperBounds2 = getImplicitUpperBounds(wildcardType2);
            Type[] implicitLowerBounds2 = getImplicitLowerBounds(wildcardType2);
            for (Type type2 : implicitUpperBounds) {
                Type typeSubstituteTypeVariables = substituteTypeVariables(type2, map);
                for (Type type3 : implicitUpperBounds2) {
                    if (!isAssignable(type3, typeSubstituteTypeVariables, map)) {
                        return false;
                    }
                }
            }
            for (Type type4 : implicitLowerBounds) {
                Type typeSubstituteTypeVariables2 = substituteTypeVariables(type4, map);
                for (Type type5 : implicitLowerBounds2) {
                    if (!isAssignable(typeSubstituteTypeVariables2, type5, map)) {
                        return false;
                    }
                }
            }
            return true;
        }
        for (Type type6 : implicitUpperBounds) {
            if (!isAssignable(type, substituteTypeVariables(type6, map), map)) {
                return false;
            }
        }
        for (Type type7 : implicitLowerBounds) {
            if (!isAssignable(substituteTypeVariables(type7, map), type, map)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCyclical(Class cls) {
        for (TypeVariable typeVariable : cls.getTypeParameters()) {
            for (Type type : typeVariable.getBounds()) {
                if (type.getTypeName().contains(cls.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isInstance(Object obj, Type type) {
        if (type == null) {
            return false;
        }
        if (obj == null) {
            return ((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true;
        }
        return isAssignable(obj.getClass(), type, (Map) null);
    }

    private static void mapTypeVariablesToArguments(Class cls, ParameterizedType parameterizedType, Map map) {
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            mapTypeVariablesToArguments(cls, (ParameterizedType) ownerType, map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable[] typeParameters = getRawType(parameterizedType).getTypeParameters();
        List listAsList = Arrays.asList(cls.getTypeParameters());
        for (int i = 0; i < actualTypeArguments.length; i++) {
            TypeVariable typeVariable = typeParameters[i];
            Type type = actualTypeArguments[i];
            if (listAsList.contains(type) && map.containsKey(typeVariable)) {
                map.put((TypeVariable) type, (Type) map.get(typeVariable));
            }
        }
    }

    public static Type[] normalizeUpperBounds(Type[] typeArr) {
        Objects.requireNonNull(typeArr, "bounds");
        if (typeArr.length < 2) {
            return typeArr;
        }
        HashSet hashSet = new HashSet(typeArr.length);
        for (Type type : typeArr) {
            int length = typeArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Type type2 = typeArr[i];
                    if (type != type2 && isAssignable(type2, type, (Map) null)) {
                        break;
                    }
                    i++;
                } else {
                    hashSet.add(type);
                    break;
                }
            }
        }
        return (Type[]) hashSet.toArray(ArrayUtils.EMPTY_TYPE_ARRAY);
    }

    private static Type[] normalizeUpperToObject(Type[] typeArr) {
        return typeArr.length == 0 ? new Type[]{Object.class} : normalizeUpperBounds(typeArr);
    }

    public static final ParameterizedType parameterize(Class<?> cls, Map<TypeVariable<?>, Type> map) {
        Objects.requireNonNull(cls, "rawClass");
        Objects.requireNonNull(map, "typeVariableMap");
        return parameterizeWithOwner((Type) null, cls, extractTypeArgumentsFrom(map, cls.getTypeParameters()));
    }

    public static final ParameterizedType parameterize(Class<?> cls, Type... typeArr) {
        return parameterizeWithOwner((Type) null, cls, typeArr);
    }

    private static String parameterizedTypeToString(ParameterizedType parameterizedType) {
        StringBuilder sb = new StringBuilder();
        Type ownerType = parameterizedType.getOwnerType();
        Class cls = (Class) parameterizedType.getRawType();
        if (ownerType == null) {
            sb.append(cls.getName());
        } else {
            if (ownerType instanceof Class) {
                sb.append(((Class) ownerType).getName());
            } else {
                sb.append(ownerType);
            }
            sb.append('.');
            sb.append(cls.getSimpleName());
        }
        int[] iArrFindRecursiveTypes = findRecursiveTypes(parameterizedType);
        if (iArrFindRecursiveTypes.length > 0) {
            appendRecursiveTypes(sb, iArrFindRecursiveTypes, parameterizedType.getActualTypeArguments());
        } else {
            GT_JOINER.join(sb, parameterizedType.getActualTypeArguments());
        }
        return sb.toString();
    }

    public static final ParameterizedType parameterizeWithOwner(Type type, Class<?> cls, Map<TypeVariable<?>, Type> map) {
        Objects.requireNonNull(cls, "rawClass");
        Objects.requireNonNull(map, "typeVariableMap");
        return parameterizeWithOwner(type, cls, extractTypeArgumentsFrom(map, cls.getTypeParameters()));
    }

    public static final ParameterizedType parameterizeWithOwner(Type type, Class<?> cls, Type... typeArr) {
        Objects.requireNonNull(cls, "rawClass");
        if (cls.getEnclosingClass() == null) {
            Validate.isTrue(type == null, "no owner allowed for top-level %s", cls);
            type = null;
        } else if (type == null) {
            type = cls.getEnclosingClass();
        } else {
            Validate.isTrue(isAssignable(type, (Class) cls.getEnclosingClass()), "%s is invalid owner type for parameterized %s", type, cls);
        }
        Validate.noNullElements(typeArr, "null type argument at index %s", new Object[0]);
        Validate.isTrue(cls.getTypeParameters().length == typeArr.length, "invalid number of type parameters specified: expected %d, got %d", Integer.valueOf(cls.getTypeParameters().length), Integer.valueOf(typeArr.length));
        return new ParameterizedTypeImpl(cls, type, typeArr);
    }

    private static Type substituteTypeVariables(Type type, Map map) {
        if (!(type instanceof TypeVariable) || map == null) {
            return type;
        }
        Type type2 = (Type) map.get(type);
        if (type2 != null) {
            return type2;
        }
        throw new IllegalArgumentException("missing assignment type for type variable " + type);
    }

    public static String toLongString(TypeVariable<?> typeVariable) {
        Objects.requireNonNull(typeVariable, "typeVariable");
        StringBuilder sb = new StringBuilder();
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            Class<?> enclosingClass = (Class) genericDeclaration;
            while (enclosingClass.getEnclosingClass() != null) {
                sb.insert(0, enclosingClass.getSimpleName()).insert(0, '.');
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            sb.insert(0, enclosingClass.getName());
        } else if (genericDeclaration instanceof Type) {
            sb.append(toString((Type) genericDeclaration));
        } else {
            sb.append(genericDeclaration);
        }
        sb.append(':');
        sb.append(typeVariableToString(typeVariable));
        return sb.toString();
    }

    public static String toString(Type type) {
        Objects.requireNonNull(type, "type");
        if (type instanceof Class) {
            return classToString((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return parameterizedTypeToString((ParameterizedType) type);
        }
        if (type instanceof WildcardType) {
            return wildcardTypeToString((WildcardType) type);
        }
        if (type instanceof TypeVariable) {
            return typeVariableToString((TypeVariable) type);
        }
        if (type instanceof GenericArrayType) {
            return genericArrayTypeToString((GenericArrayType) type);
        }
        throw new IllegalArgumentException(ObjectUtils.identityToString(type));
    }

    public static boolean typesSatisfyVariables(Map<TypeVariable<?>, Type> map) {
        Objects.requireNonNull(map, "typeVariableMap");
        for (Map.Entry<TypeVariable<?>, Type> entry : map.entrySet()) {
            TypeVariable<?> key = entry.getKey();
            Type value = entry.getValue();
            for (Type type : getImplicitBounds(key)) {
                if (!isAssignable(value, substituteTypeVariables(type, map), map)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    private static String typeVariableToString(TypeVariable typeVariable) {
        StringBuilder sb = new StringBuilder(typeVariable.getName());
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0 && (bounds.length != 1 || !Object.class.equals(bounds[0]))) {
            Type type = bounds[0];
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (!(rawType instanceof Class) || !((Class) rawType).isInterface()) {
                    sb.append(" extends ");
                    AMP_JOINER.join(sb, bounds);
                }
            } else {
                sb.append(" extends ");
                AMP_JOINER.join(sb, bounds);
            }
        }
        return sb.toString();
    }

    private static Type[] unrollBounds(Map map, Type[] typeArr) {
        int i = 0;
        while (i < typeArr.length) {
            Type typeUnrollVariables = unrollVariables(map, typeArr[i]);
            if (typeUnrollVariables == null) {
                typeArr = (Type[]) ArrayUtils.remove((Object[]) typeArr, i);
                i--;
            } else {
                typeArr[i] = typeUnrollVariables;
            }
            i++;
        }
        return typeArr;
    }

    private static Type unrollVariableAssignments(TypeVariable typeVariable, Map map) {
        Type type;
        while (true) {
            type = (Type) map.get(typeVariable);
            if (!(type instanceof TypeVariable) || type.equals(typeVariable)) {
                break;
            }
            typeVariable = (TypeVariable) type;
        }
        return type;
    }

    public static Type unrollVariables(Map<TypeVariable<?>, Type> map, Type type) {
        if (map == null) {
            map = Collections.emptyMap();
        }
        if (containsTypeVariables(type)) {
            if (type instanceof TypeVariable) {
                return unrollVariables(map, map.get(type));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getOwnerType() != null) {
                    HashMap map2 = new HashMap(map);
                    map2.putAll(getTypeArguments(parameterizedType));
                    map = map2;
                }
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    Type typeUnrollVariables = unrollVariables(map, actualTypeArguments[i]);
                    if (typeUnrollVariables != null) {
                        actualTypeArguments[i] = typeUnrollVariables;
                    }
                }
                return parameterizeWithOwner(parameterizedType.getOwnerType(), (Class<?>) parameterizedType.getRawType(), actualTypeArguments);
            }
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType().withUpperBounds(unrollBounds(map, wildcardType.getUpperBounds())).withLowerBounds(unrollBounds(map, wildcardType.getLowerBounds())).build();
            }
        }
        return type;
    }

    public static WildcardTypeBuilder wildcardType() {
        return new WildcardTypeBuilder();
    }

    private static String wildcardTypeToString(WildcardType wildcardType) {
        StringBuilder sb = new StringBuilder();
        sb.append('?');
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (lowerBounds.length > 1 || (lowerBounds.length == 1 && lowerBounds[0] != null)) {
            AppendableJoiner appendableJoiner = AMP_JOINER;
            sb.append(" super ");
            appendableJoiner.join(sb, lowerBounds);
        } else if (upperBounds.length > 1 || (upperBounds.length == 1 && !Object.class.equals(upperBounds[0]))) {
            AppendableJoiner appendableJoiner2 = AMP_JOINER;
            sb.append(" extends ");
            appendableJoiner2.join(sb, upperBounds);
        }
        return sb.toString();
    }

    public static <T> Typed<T> wrap(Class<T> cls) {
        return wrap((Type) cls);
    }

    public static <T> Typed<T> wrap(final Type type) {
        return new Typed() { // from class: org.apache.commons.lang3.reflect.TypeUtils$$ExternalSyntheticLambda3
            @Override // org.apache.commons.lang3.reflect.Typed
            public final Type getType() {
                return TypeUtils.lambda$wrap$0(type);
            }
        };
    }

    @Deprecated
    public TypeUtils() {
    }
}
