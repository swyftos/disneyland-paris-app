package com.contentsquare.android.api.model;

import androidx.annotation.FloatRange;
import com.contentsquare.android.api.Currencies;
import com.contentsquare.android.core.features.logging.Logger;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/contentsquare/android/api/model/Transaction;", "", "builder", "Lcom/contentsquare/android/api/model/Transaction$TransactionBuilder;", "(Lcom/contentsquare/android/api/model/Transaction$TransactionBuilder;)V", "currency", "", "getCurrency$annotations", "()V", "getCurrency", "()I", "id", "", "getId", "()Ljava/lang/String;", "value", "", "getValue", "()F", "Companion", "TransactionBuilder", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Transaction {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int currency;

    @Nullable
    private final String id;

    @FloatRange(from = 1.401298464324817E-45d, to = 3.4028234663852886E38d)
    private final float value;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/contentsquare/android/api/model/Transaction$Companion;", "", "()V", "builder", "Lcom/contentsquare/android/api/model/Transaction$TransactionBuilder;", "value", "", "currency", "", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final TransactionBuilder builder(@FloatRange(from = 1.401298464324817E-45d, to = 3.4028234663852886E38d) float value, int currency) {
            return new TransactionBuilder(value, currency);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TransactionBuilder builder(@FloatRange(from = 1.401298464324817E-45d, to = 3.4028234663852886E38d) float value, @NotNull String currency) {
            Intrinsics.checkNotNullParameter(currency, "currency");
            return new TransactionBuilder(value, currency);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/contentsquare/android/api/model/Transaction$TransactionBuilder;", "", "value", "", "currency", "", "(FI)V", "", "(FLjava/lang/String;)V", "getCurrency", "()I", "setCurrency", "(I)V", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getValue", "()F", "setValue", "(F)V", "build", "Lcom/contentsquare/android/api/model/Transaction;", "Companion", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransactionBuilder {

        @NotNull
        private static final Logger logger = new Logger("TransactionBuilder");
        private int currency;

        @Nullable
        private String id;
        private float value;

        public TransactionBuilder(@FloatRange(from = 1.401298464324817E-45d, to = 3.4028234663852886E38d) float f, int i) {
            this.value = f;
            int iFromInteger = Currencies.INSTANCE.fromInteger(i);
            this.currency = iFromInteger;
            if (iFromInteger == -1) {
                logger.i("Invalid currency code: \"" + i + "\". Transaction currency is set to \"unknown(-1)\".");
            }
        }

        @NotNull
        public final Transaction build() {
            return new Transaction(this, null);
        }

        public final int getCurrency() {
            return this.currency;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        public final float getValue() {
            return this.value;
        }

        @NotNull
        public final TransactionBuilder id(@NotNull String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            return this;
        }

        public final void setCurrency(int i) {
            this.currency = i;
        }

        public final void setId(@Nullable String str) {
            this.id = str;
        }

        public final void setValue(float f) {
            this.value = f;
        }

        public TransactionBuilder(@FloatRange(from = 1.401298464324817E-45d, to = 3.4028234663852886E38d) float f, @NotNull String currency) {
            Intrinsics.checkNotNullParameter(currency, "currency");
            this.value = f;
            Currencies currencies = Currencies.INSTANCE;
            String upperCase = currency.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            int iFromString = currencies.fromString(upperCase);
            this.currency = iFromString;
            if (iFromString == -1) {
                logger.i("Invalid currency string: \"" + currency + "\". Transaction currency is set to \"unknown(-1)\".");
            }
        }
    }

    private Transaction(TransactionBuilder transactionBuilder) {
        this.id = transactionBuilder.getId();
        this.currency = transactionBuilder.getCurrency();
        this.value = transactionBuilder.getValue();
    }

    public static /* synthetic */ void getCurrency$annotations() {
    }

    public final int getCurrency() {
        return this.currency;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    public final float getValue() {
        return this.value;
    }

    public /* synthetic */ Transaction(TransactionBuilder transactionBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(transactionBuilder);
    }
}
