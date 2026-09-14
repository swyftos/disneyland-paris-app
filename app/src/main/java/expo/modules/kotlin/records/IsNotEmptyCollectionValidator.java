package expo.modules.kotlin.records;

import expo.modules.kotlin.exception.ValidationException;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¨\u0006\b"}, m1836d2 = {"Lexpo/modules/kotlin/records/IsNotEmptyCollectionValidator;", "Lexpo/modules/kotlin/records/FieldValidator;", "", "<init>", "()V", "validate", "", "value", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class IsNotEmptyCollectionValidator implements FieldValidator<Collection<?>> {
    @Override // expo.modules.kotlin.records.FieldValidator
    public void validate(@NotNull Collection<?> value) throws ValidationException {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.isEmpty()) {
            throw new ValidationException("Collection is empty");
        }
    }
}
