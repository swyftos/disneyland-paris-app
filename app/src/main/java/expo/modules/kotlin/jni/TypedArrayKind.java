package expo.modules.kotlin.jni;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'Int16Array' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, m1836d2 = {"Lexpo/modules/kotlin/jni/TypedArrayKind;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Int8Array", "Int16Array", "Int32Array", "Uint8Array", "Uint8ClampedArray", "Uint16Array", "Uint32Array", "Float32Array", "Float64Array", "BigInt64Array", "BigUint64Array", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class TypedArrayKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TypedArrayKind[] $VALUES;
    public static final TypedArrayKind BigInt64Array;
    public static final TypedArrayKind BigUint64Array;
    public static final TypedArrayKind Float32Array;
    public static final TypedArrayKind Float64Array;
    public static final TypedArrayKind Int16Array;
    public static final TypedArrayKind Int32Array;
    public static final TypedArrayKind Int8Array = new TypedArrayKind("Int8Array", 0, 0, 1, null);
    public static final TypedArrayKind Uint16Array;
    public static final TypedArrayKind Uint32Array;
    public static final TypedArrayKind Uint8Array;
    public static final TypedArrayKind Uint8ClampedArray;
    private final int value;

    private static final /* synthetic */ TypedArrayKind[] $values() {
        return new TypedArrayKind[]{Int8Array, Int16Array, Int32Array, Uint8Array, Uint8ClampedArray, Uint16Array, Uint32Array, Float32Array, Float64Array, BigInt64Array, BigUint64Array};
    }

    @NotNull
    public static EnumEntries<TypedArrayKind> getEntries() {
        return $ENTRIES;
    }

    private TypedArrayKind(String str, int i, int i2) {
        super(str, i);
        this.value = i2;
    }

    /* synthetic */ TypedArrayKind(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i3 & 1) != 0 ? JavaScriptTypedArrayKt.nextValue() : i2);
    }

    public final int getValue() {
        return this.value;
    }

    static {
        int i = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i2 = 0;
        Int16Array = new TypedArrayKind("Int16Array", 1, i2, i, defaultConstructorMarker);
        int i3 = 1;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        int i4 = 0;
        Int32Array = new TypedArrayKind("Int32Array", 2, i4, i3, defaultConstructorMarker2);
        Uint8Array = new TypedArrayKind("Uint8Array", 3, i2, i, defaultConstructorMarker);
        Uint8ClampedArray = new TypedArrayKind("Uint8ClampedArray", 4, i4, i3, defaultConstructorMarker2);
        Uint16Array = new TypedArrayKind("Uint16Array", 5, i2, i, defaultConstructorMarker);
        Uint32Array = new TypedArrayKind("Uint32Array", 6, i4, i3, defaultConstructorMarker2);
        Float32Array = new TypedArrayKind("Float32Array", 7, i2, i, defaultConstructorMarker);
        Float64Array = new TypedArrayKind("Float64Array", 8, i4, i3, defaultConstructorMarker2);
        BigInt64Array = new TypedArrayKind("BigInt64Array", 9, i2, i, defaultConstructorMarker);
        BigUint64Array = new TypedArrayKind("BigUint64Array", 10, i4, i3, defaultConstructorMarker2);
        TypedArrayKind[] typedArrayKindArr$values = $values();
        $VALUES = typedArrayKindArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(typedArrayKindArr$values);
    }

    public static TypedArrayKind valueOf(String str) {
        return (TypedArrayKind) Enum.valueOf(TypedArrayKind.class, str);
    }

    public static TypedArrayKind[] values() {
        return (TypedArrayKind[]) $VALUES.clone();
    }
}
