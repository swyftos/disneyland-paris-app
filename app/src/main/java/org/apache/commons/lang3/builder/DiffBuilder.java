package org.apache.commons.lang3.builder;

import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.facebook.react.uimanager.ViewProps;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DiffBuilder<T> implements org.apache.commons.lang3.builder.Builder<DiffResult<T>> {
    private final List diffs;
    private final boolean equals;
    private final Object left;
    private final Object right;
    private final ToStringStyle style;
    private final String toStringFormat;

    /* JADX INFO: Access modifiers changed from: private */
    interface SerializableSupplier extends Supplier, Serializable {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$append$9e3d8e65$1(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$append$9e40489f$1(Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object[] lambda$append$dbd51caa$1(Object[] objArr) {
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object[] lambda$append$dbd7d6e4$1(Object[] objArr) {
        return objArr;
    }

    public static final class Builder<T> {
        private Object left;
        private Object right;
        private ToStringStyle style;
        private boolean testObjectsEquals = true;
        private String toStringFormat = "%s differs from %s";

        public DiffBuilder<T> build() {
            return new DiffBuilder<>(this.left, this.right, this.style, this.testObjectsEquals, this.toStringFormat);
        }

        public Builder<T> setLeft(T t) {
            this.left = t;
            return this;
        }

        public Builder<T> setRight(T t) {
            this.right = t;
            return this;
        }

        public Builder<T> setStyle(ToStringStyle toStringStyle) {
            if (toStringStyle == null) {
                toStringStyle = ToStringStyle.DEFAULT_STYLE;
            }
            this.style = toStringStyle;
            return this;
        }

        public Builder<T> setTestObjectsEquals(boolean z) {
            this.testObjectsEquals = z;
            return this;
        }

        public Builder<T> setToStringFormat(String str) {
            if (str == null) {
                str = "%s differs from %s";
            }
            this.toStringFormat = str;
            return this;
        }
    }

    private static final class SDiff extends Diff {
        private static final long serialVersionUID = 1;
        private final SerializableSupplier leftSupplier;
        private final SerializableSupplier rightSupplier;

        private SDiff(String str, SerializableSupplier serializableSupplier, SerializableSupplier serializableSupplier2, Class cls) {
            super(str, cls);
            Objects.requireNonNull(serializableSupplier);
            this.leftSupplier = serializableSupplier;
            Objects.requireNonNull(serializableSupplier2);
            this.rightSupplier = serializableSupplier2;
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Object getLeft() {
            return this.leftSupplier.get();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Object getRight() {
            return this.rightSupplier.get();
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    @Deprecated
    public DiffBuilder(T t, T t2, ToStringStyle toStringStyle) {
        this(t, t2, toStringStyle, true);
    }

    @Deprecated
    public DiffBuilder(T t, T t2, ToStringStyle toStringStyle, boolean z) {
        this(t, t2, toStringStyle, z, "%s differs from %s");
    }

    private DiffBuilder(Object obj, Object obj2, ToStringStyle toStringStyle, boolean z, String str) {
        Objects.requireNonNull(obj, ViewProps.LEFT);
        this.left = obj;
        Objects.requireNonNull(obj2, ViewProps.RIGHT);
        this.right = obj2;
        this.diffs = new ArrayList();
        this.toStringFormat = str;
        this.style = toStringStyle == null ? ToStringStyle.DEFAULT_STYLE : toStringStyle;
        this.equals = z && obj.equals(obj2);
    }

    private DiffBuilder add(String str, SerializableSupplier serializableSupplier, SerializableSupplier serializableSupplier2, Class cls) {
        this.diffs.add(new SDiff(str, serializableSupplier, serializableSupplier2, cls));
        return this;
    }

    public DiffBuilder<T> append(String str, boolean z, boolean z2) {
        return (this.equals || z == z2) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda14(z), new DiffBuilder$$ExternalSyntheticLambda15(z2), Boolean.class);
    }

    public DiffBuilder<T> append(String str, boolean[] zArr, boolean[] zArr2) {
        return (this.equals || Arrays.equals(zArr, zArr2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda31(zArr), new DiffBuilder$$ExternalSyntheticLambda32(zArr2), Boolean[].class);
    }

    public DiffBuilder<T> append(String str, byte b, byte b2) {
        return (this.equals || b == b2) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda23(b), new DiffBuilder$$ExternalSyntheticLambda24(b2), Byte.class);
    }

    public DiffBuilder<T> append(String str, byte[] bArr, byte[] bArr2) {
        return (this.equals || Arrays.equals(bArr, bArr2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda20(bArr), new DiffBuilder$$ExternalSyntheticLambda21(bArr2), Byte[].class);
    }

    public DiffBuilder<T> append(String str, char c, char c2) {
        return (this.equals || c == c2) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda10(c), new DiffBuilder$$ExternalSyntheticLambda11(c2), Character.class);
    }

    public DiffBuilder<T> append(String str, char[] cArr, char[] cArr2) {
        return (this.equals || Arrays.equals(cArr, cArr2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda18(cArr), new DiffBuilder$$ExternalSyntheticLambda19(cArr2), Character[].class);
    }

    public DiffBuilder<T> append(final String str, DiffResult<?> diffResult) {
        Objects.requireNonNull(diffResult, "diffResult");
        if (this.equals) {
            return this;
        }
        diffResult.getDiffs().forEach(new Consumer() { // from class: org.apache.commons.lang3.builder.DiffBuilder$$ExternalSyntheticLambda22
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$append$0(str, (Diff) obj);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$append$0(String str, Diff diff) {
        append(str + InstructionFileId.DOT + diff.getFieldName(), diff.getLeft(), diff.getRight());
    }

    public DiffBuilder<T> append(String str, double d, double d2) {
        return (this.equals || Double.doubleToLongBits(d) == Double.doubleToLongBits(d2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda4(d), new DiffBuilder$$ExternalSyntheticLambda5(d2), Double.class);
    }

    public DiffBuilder<T> append(String str, double[] dArr, double[] dArr2) {
        return (this.equals || Arrays.equals(dArr, dArr2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda33(dArr), new DiffBuilder$$ExternalSyntheticLambda34(dArr2), Double[].class);
    }

    public DiffBuilder<T> append(String str, float f, float f2) {
        return (this.equals || Float.floatToIntBits(f) == Float.floatToIntBits(f2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda6(f), new DiffBuilder$$ExternalSyntheticLambda7(f2), Float.class);
    }

    public DiffBuilder<T> append(String str, float[] fArr, float[] fArr2) {
        return (this.equals || Arrays.equals(fArr, fArr2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda25(fArr), new DiffBuilder$$ExternalSyntheticLambda26(fArr2), Float[].class);
    }

    public DiffBuilder<T> append(String str, int i, int i2) {
        return (this.equals || i == i2) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda29(i), new DiffBuilder$$ExternalSyntheticLambda30(i2), Integer.class);
    }

    public DiffBuilder<T> append(String str, int[] iArr, int[] iArr2) {
        return (this.equals || Arrays.equals(iArr, iArr2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda35(iArr), new DiffBuilder$$ExternalSyntheticLambda36(iArr2), Integer[].class);
    }

    public DiffBuilder<T> append(String str, long j, long j2) {
        return (this.equals || j == j2) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda16(j), new DiffBuilder$$ExternalSyntheticLambda17(j2), Long.class);
    }

    public DiffBuilder<T> append(String str, long[] jArr, long[] jArr2) {
        return (this.equals || Arrays.equals(jArr, jArr2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda12(jArr), new DiffBuilder$$ExternalSyntheticLambda13(jArr2), Long[].class);
    }

    public DiffBuilder<T> append(String str, Object obj, Object obj2) {
        if (this.equals || obj == obj2) {
            return this;
        }
        Object obj3 = obj != null ? obj : obj2;
        if (!ObjectUtils.isArray(obj3)) {
            return Objects.equals(obj, obj2) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda27(obj), new DiffBuilder$$ExternalSyntheticLambda28(obj2), Object.class);
        }
        if (obj3 instanceof boolean[]) {
            return append(str, (boolean[]) obj, (boolean[]) obj2);
        }
        if (obj3 instanceof byte[]) {
            return append(str, (byte[]) obj, (byte[]) obj2);
        }
        if (obj3 instanceof char[]) {
            return append(str, (char[]) obj, (char[]) obj2);
        }
        if (obj3 instanceof double[]) {
            return append(str, (double[]) obj, (double[]) obj2);
        }
        if (obj3 instanceof float[]) {
            return append(str, (float[]) obj, (float[]) obj2);
        }
        if (obj3 instanceof int[]) {
            return append(str, (int[]) obj, (int[]) obj2);
        }
        if (obj3 instanceof long[]) {
            return append(str, (long[]) obj, (long[]) obj2);
        }
        if (obj3 instanceof short[]) {
            return append(str, (short[]) obj, (short[]) obj2);
        }
        return append(str, (Object[]) obj, (Object[]) obj2);
    }

    public DiffBuilder<T> append(String str, Object[] objArr, Object[] objArr2) {
        return (this.equals || Arrays.equals(objArr, objArr2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda0(objArr), new DiffBuilder$$ExternalSyntheticLambda1(objArr2), Object[].class);
    }

    public DiffBuilder<T> append(String str, short s, short s2) {
        return (this.equals || s == s2) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda8(s), new DiffBuilder$$ExternalSyntheticLambda9(s2), Short.class);
    }

    public DiffBuilder<T> append(String str, short[] sArr, short[] sArr2) {
        return (this.equals || Arrays.equals(sArr, sArr2)) ? this : add(str, new DiffBuilder$$ExternalSyntheticLambda2(sArr), new DiffBuilder$$ExternalSyntheticLambda3(sArr2), Short[].class);
    }

    @Override // org.apache.commons.lang3.builder.Builder
    public DiffResult<T> build() {
        return new DiffResult<>(this.left, this.right, this.diffs, this.style, this.toStringFormat);
    }

    Object getLeft() {
        return this.left;
    }

    Object getRight() {
        return this.right;
    }
}
