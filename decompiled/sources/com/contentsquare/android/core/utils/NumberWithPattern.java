package com.contentsquare.android.core.utils;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/contentsquare/android/core/utils/NumberWithPattern;", "", "()V", "number", "", "compareTo", "", ETCPaymentMethod.OTHER, "operator", "Lcom/contentsquare/android/core/utils/RangeOperator;", ExactValueMatcher.EQUALS_VALUE_KEY, "", "hashCode", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class NumberWithPattern {

    @Nullable
    private String number;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static Recycler<NumberWithPattern> recycler = new Recycler<>();

    @NotNull
    private static final InstanceCreator<NumberWithPattern> numberWithPatternInstanceCreator = new InstanceCreator() { // from class: com.contentsquare.android.core.utils.NumberWithPattern$$ExternalSyntheticLambda0
        @Override // com.contentsquare.android.core.utils.InstanceCreator
        public final Object create() {
            return NumberWithPattern.numberWithPatternInstanceCreator$lambda$0();
        }
    };

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/core/utils/NumberWithPattern$Companion;", "", "()V", "numberWithPatternInstanceCreator", "Lcom/contentsquare/android/core/utils/InstanceCreator;", "Lcom/contentsquare/android/core/utils/NumberWithPattern;", "recycler", "Lcom/contentsquare/android/core/utils/Recycler;", "obtain", "n", "", "recycle", "", "number", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final NumberWithPattern obtain(String n) {
            NumberWithPattern numberWithPattern = (NumberWithPattern) NumberWithPattern.recycler.obtain(NumberWithPattern.numberWithPatternInstanceCreator);
            numberWithPattern.set(n);
            return numberWithPattern;
        }

        public final void recycle(NumberWithPattern number) {
            Intrinsics.checkNotNullParameter(number, "number");
            NumberWithPattern.recycler.recycle(number);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private NumberWithPattern() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NumberWithPattern numberWithPatternInstanceCreator$lambda$0() {
        return new NumberWithPattern();
    }

    public final int compareTo(NumberWithPattern other, RangeOperator operator) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(operator, "operator");
        if (Intrinsics.areEqual(this.number, "*") || Intrinsics.areEqual(other.number, "*")) {
            return 0;
        }
        String str = this.number;
        if (str == null && other.number == null) {
            return 0;
        }
        if (str == null) {
            str = (operator == RangeOperator.LTE || operator == RangeOperator.LT) ? "0" : "99999999999";
        }
        String str2 = other.number;
        String str3 = str2 != null ? str2 : "0";
        try {
            return Intrinsics.compare(Integer.parseInt(str), Integer.parseInt(str3));
        } catch (NumberFormatException unused) {
            return str.compareTo(str3);
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof NumberWithPattern)) {
            return false;
        }
        NumberWithPattern numberWithPattern = (NumberWithPattern) other;
        if (Intrinsics.areEqual(numberWithPattern.number, this.number)) {
            return true;
        }
        return (Intrinsics.areEqual(numberWithPattern.number, "*") && this.number != null) || (Intrinsics.areEqual(this.number, "*") && numberWithPattern.number != null);
    }

    public int hashCode() {
        String str = this.number;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final void set(String number) {
        this.number = number;
    }
}
