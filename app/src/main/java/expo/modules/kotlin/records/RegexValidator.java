package expo.modules.kotlin.records;

import expo.modules.kotlin.exception.ValidationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1836d2 = {"Lexpo/modules/kotlin/records/RegexValidator;", "Lexpo/modules/kotlin/records/FieldValidator;", "", "regex", "Lkotlin/text/Regex;", "<init>", "(Lkotlin/text/Regex;)V", "validate", "", "value", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class RegexValidator implements FieldValidator<CharSequence> {
    private final Regex regex;

    public RegexValidator(@NotNull Regex regex) {
        Intrinsics.checkNotNullParameter(regex, "regex");
        this.regex = regex;
    }

    @Override // expo.modules.kotlin.records.FieldValidator
    public void validate(@NotNull CharSequence value) throws ValidationException {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.regex.matches(value)) {
            return;
        }
        throw new ValidationException("Provided string " + ((Object) value) + " didn't match regex " + this.regex);
    }
}
