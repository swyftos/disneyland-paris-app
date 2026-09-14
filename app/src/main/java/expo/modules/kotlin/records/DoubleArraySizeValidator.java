package expo.modules.kotlin.records;

import expo.modules.kotlin.exception.ValidationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1836d2 = {"Lexpo/modules/kotlin/records/DoubleArraySizeValidator;", "Lexpo/modules/kotlin/records/FieldValidator;", "", "min", "", "max", "<init>", "(II)V", "validate", "", "value", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class DoubleArraySizeValidator implements FieldValidator<double[]> {
    private final int max;
    private final int min;

    public DoubleArraySizeValidator(int i, int i2) {
        this.min = i;
        this.max = i2;
    }

    @Override // expo.modules.kotlin.records.FieldValidator
    public void validate(@NotNull double[] value) throws ValidationException {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.length < this.min || value.length > this.max) {
            throw new ValidationException("Number of elements in the array should be between " + this.min + " and " + this.max + ", got " + value.length);
        }
    }
}
