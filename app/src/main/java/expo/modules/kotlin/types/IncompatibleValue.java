package expo.modules.kotlin.types;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, m1836d2 = {"Lexpo/modules/kotlin/types/IncompatibleValue;", "Lexpo/modules/kotlin/types/DeferredValue;", "<init>", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final /* data */ class IncompatibleValue extends DeferredValue {

    @NotNull
    public static final IncompatibleValue INSTANCE = new IncompatibleValue();

    public boolean equals(@Nullable Object other) {
        return this == other || (other instanceof IncompatibleValue);
    }

    public int hashCode() {
        return 1921661369;
    }

    @NotNull
    public String toString() {
        return "IncompatibleValue";
    }

    private IncompatibleValue() {
        super(null);
    }
}
