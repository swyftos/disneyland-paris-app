package expo.modules.kotlin.records;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.exception.ValidationException;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1836d2 = {"Lexpo/modules/kotlin/records/NumericRangeValidator;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lexpo/modules/kotlin/records/FieldValidator;", "from", TypedValues.TransitionType.S_TO, "fromInclusive", "", "toInclusive", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;ZZ)V", "Ljava/lang/Comparable;", "validate", "", "value", "(Ljava/lang/Comparable;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class NumericRangeValidator<T extends Comparable<? super T>> implements FieldValidator<T> {
    private final Comparable from;
    private final boolean fromInclusive;
    private final Comparable to;
    private final boolean toInclusive;

    public NumericRangeValidator(@NotNull T from, @NotNull T to, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        this.from = from;
        this.to = to;
        this.fromInclusive = z;
        this.toInclusive = z2;
    }

    @Override // expo.modules.kotlin.records.FieldValidator
    public void validate(@NotNull T value) throws ValidationException {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.compareTo(this.from) < 0 || this.to.compareTo(value) < 0 || ((Intrinsics.areEqual(value, this.from) && !this.fromInclusive) || (Intrinsics.areEqual(value, this.to) && !this.toInclusive))) {
            throw new ValidationException("Value should be in range " + this.from + " " + (this.fromInclusive ? "<=" : "<") + " 'value' " + (this.toInclusive ? "<=" : "<") + " " + this.to + ", got " + value);
        }
    }
}
