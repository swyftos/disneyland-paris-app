package com.contentsquare.android.api.model;

import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/api/model/CustomVarValidator;", "", "()V", "validateName", "", "key", "validateValue", "value", "Companion", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomVarValidator {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static Logger logger = new Logger("CustomVar");

    @NotNull
    private static final CustomVarValidator$Companion$nameValidation$1 nameValidation = new StringVarValidator() { // from class: com.contentsquare.android.api.model.CustomVarValidator$Companion$nameValidation$1

        @NotNull
        private final Function0<Unit> onEmpty = new a();

        @NotNull
        private final Function1<Integer, Unit> onTooLong = new b();

        public static final class a extends Lambda implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                CustomVarValidator.INSTANCE.getLogger().i("Custom Variable name is empty. Custom Variable is sent but the name is set to \"" + getDefaultValue() + '\"');
                return Unit.INSTANCE;
            }
        }

        public static final class b extends Lambda implements Function1<Integer, Unit> {
            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int iIntValue = num.intValue();
                CustomVarValidator.INSTANCE.getLogger().i("Custom Variable name is too long: the current input has a length of " + iIntValue + " while the limit is " + getMaxLength() + ". Custom Variable is sent but the name truncated");
                return Unit.INSTANCE;
            }
        }

        @Override // com.contentsquare.android.api.model.StringVarValidator
        @NotNull
        public Function0<Unit> getOnEmpty() {
            return this.onEmpty;
        }

        @Override // com.contentsquare.android.api.model.StringVarValidator
        @NotNull
        public Function1<Integer, Unit> getOnTooLong() {
            return this.onTooLong;
        }
    };

    @NotNull
    private static final CustomVarValidator$Companion$valueValidation$1 valueValidation = new StringVarValidator() { // from class: com.contentsquare.android.api.model.CustomVarValidator$Companion$valueValidation$1

        @NotNull
        private final Function0<Unit> onEmpty = new a();

        @NotNull
        private final Function1<Integer, Unit> onTooLong = new b();

        public static final class a extends Lambda implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                CustomVarValidator.INSTANCE.getLogger().i("Custom Variable value is empty. Custom Variable is sent but the value is set to \"" + getDefaultValue() + '\"');
                return Unit.INSTANCE;
            }
        }

        public static final class b extends Lambda implements Function1<Integer, Unit> {
            public b() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Integer num) {
                int iIntValue = num.intValue();
                CustomVarValidator.INSTANCE.getLogger().i("Custom Variable value is too long: the current input has a length of " + iIntValue + " while the limit is " + getMaxLength() + ". Custom Variable is sent but the value truncated");
                return Unit.INSTANCE;
            }
        }

        @Override // com.contentsquare.android.api.model.StringVarValidator
        @NotNull
        public Function0<Unit> getOnEmpty() {
            return this.onEmpty;
        }

        @Override // com.contentsquare.android.api.model.StringVarValidator
        @NotNull
        public Function1<Integer, Unit> getOnTooLong() {
            return this.onTooLong;
        }
    };

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\u0003*\u0002\u000b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/contentsquare/android/api/model/CustomVarValidator$Companion;", "", "()V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "getLogger$annotations", "getLogger", "()Lcom/contentsquare/android/core/features/logging/Logger;", "setLogger", "(Lcom/contentsquare/android/core/features/logging/Logger;)V", "nameValidation", "com/contentsquare/android/api/model/CustomVarValidator$Companion$nameValidation$1", "Lcom/contentsquare/android/api/model/CustomVarValidator$Companion$nameValidation$1;", "valueValidation", "com/contentsquare/android/api/model/CustomVarValidator$Companion$valueValidation$1", "Lcom/contentsquare/android/api/model/CustomVarValidator$Companion$valueValidation$1;", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getLogger$annotations() {
        }

        @NotNull
        public final Logger getLogger() {
            return CustomVarValidator.logger;
        }

        public final void setLogger(@NotNull Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "<set-?>");
            CustomVarValidator.logger = logger;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public final String validateName(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return nameValidation.invoke(key);
    }

    @NotNull
    public final String validateValue(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return valueValidation.invoke(value);
    }
}
