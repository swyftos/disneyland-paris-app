package com.urbanairship.inputvalidation;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.channel.SmsValidationHandler;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation;", "", "Override", "Request", "Result", "Validator", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipInputValidation {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H&J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "", "legacySmsDelegate", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/urbanairship/channel/SmsValidationHandler;", "getLegacySmsDelegate", "()Lkotlinx/coroutines/flow/StateFlow;", "setLegacySmsDelegate", "", "delegate", "validate", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result;", "request", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;", "(Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface Validator {
        @NotNull
        StateFlow<SmsValidationHandler> getLegacySmsDelegate();

        void setLegacySmsDelegate(@Nullable SmsValidationHandler delegate);

        @Nullable
        Object validate(@NotNull Request request, @NotNull Continuation<? super Result> continuation);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result;", "", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Invalid", "Valid", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result$Invalid;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result$Valid;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Result {
        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result$Valid;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result;", "address", "", "(Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Valid extends Result {
            private final String address;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(@NotNull String address) {
                super(null);
                Intrinsics.checkNotNullParameter(address, "address");
                this.address = address;
            }

            @NotNull
            public final String getAddress() {
                return this.address;
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result$Invalid;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Invalid extends Result {

            @NotNull
            public static final Invalid INSTANCE = new Invalid();

            @Override // com.urbanairship.inputvalidation.AirshipInputValidation.Result
            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Invalid);
            }

            @Override // com.urbanairship.inputvalidation.AirshipInputValidation.Result
            public int hashCode() {
                return -1913447489;
            }

            @Override // com.urbanairship.inputvalidation.AirshipInputValidation.Result
            @NotNull
            public String toString() {
                return "Invalid";
            }

            private Invalid() {
                super(null);
            }
        }

        @NotNull
        public String toString() {
            String str;
            if (Intrinsics.areEqual(this, Invalid.INSTANCE)) {
                str = "Invalid()";
            } else {
                if (!(this instanceof Valid)) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "Valid(address = " + ((Valid) this).getAddress() + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }
            return "Result(" + str + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            if (Intrinsics.areEqual(this, Invalid.INSTANCE)) {
                return true;
            }
            if (!(this instanceof Valid)) {
                throw new NoWhenBranchMatchedException();
            }
            String address = ((Valid) this).getAddress();
            Valid valid = other instanceof Valid ? (Valid) other : null;
            return Intrinsics.areEqual(address, valid != null ? valid.getAddress() : null);
        }

        public int hashCode() {
            if (Intrinsics.areEqual(this, Invalid.INSTANCE)) {
                return getClass().hashCode();
            }
            if (this instanceof Valid) {
                return ((Valid) this).getAddress().hashCode();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Override;", "", "()V", "Replace", "UseDefault", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Override$Replace;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Override$UseDefault;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Override {
        public /* synthetic */ Override(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Override() {
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Override$Replace;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Override;", "result", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result;", "(Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result;)V", "getResult", "()Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Replace extends Override {
            private final Result result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Replace(@NotNull Result result) {
                super(null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            @NotNull
            public final Result getResult() {
                return this.result;
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Override$UseDefault;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Override;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UseDefault extends Override {

            @NotNull
            public static final UseDefault INSTANCE = new UseDefault();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof UseDefault);
            }

            public int hashCode() {
                return -263217373;
            }

            @NotNull
            public String toString() {
                return "UseDefault";
            }

            private UseDefault() {
                super(null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;", "", "()V", "toString", "", "Email", "Sms", "ValidateEmail", "ValidateSms", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$ValidateEmail;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$ValidateSms;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static abstract class Request {
        public /* synthetic */ Request(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Request() {
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$ValidateEmail;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;", "email", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Email;", "(Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Email;)V", "getEmail", "()Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Email;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ValidateEmail extends Request {
            private final Email email;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ValidateEmail(@NotNull Email email) {
                super(null);
                Intrinsics.checkNotNullParameter(email, "email");
                this.email = email;
            }

            @NotNull
            public final Email getEmail() {
                return this.email;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$ValidateSms;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;", "sms", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms;", "(Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms;)V", "getSms", "()Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class ValidateSms extends Request {
            private final Sms sms;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ValidateSms(@NotNull Sms sms) {
                super(null);
                Intrinsics.checkNotNullParameter(sms, "sms");
                this.sms = sms;
            }

            @NotNull
            public final Sms getSms() {
                return this.sms;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Email;", "", "rawInput", "", "(Ljava/lang/String;)V", "getRawInput", "()Ljava/lang/String;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Email {
            private final String rawInput;

            public Email(@NotNull String rawInput) {
                Intrinsics.checkNotNullParameter(rawInput, "rawInput");
                this.rawInput = rawInput;
            }

            @NotNull
            public final String getRawInput() {
                return this.rawInput;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms;", "", "rawInput", "", "validationOptions", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions;", "validationHints", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationHints;", "(Ljava/lang/String;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationHints;)V", "getRawInput", "()Ljava/lang/String;", "getValidationHints", "()Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationHints;", "getValidationOptions", "()Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions;", "ValidationHints", "ValidationOptions", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Sms {
            private final String rawInput;
            private final ValidationHints validationHints;
            private final ValidationOptions validationOptions;

            public Sms(@NotNull String rawInput, @NotNull ValidationOptions validationOptions, @Nullable ValidationHints validationHints) {
                Intrinsics.checkNotNullParameter(rawInput, "rawInput");
                Intrinsics.checkNotNullParameter(validationOptions, "validationOptions");
                this.rawInput = rawInput;
                this.validationOptions = validationOptions;
                this.validationHints = validationHints;
            }

            public /* synthetic */ Sms(String str, ValidationOptions validationOptions, ValidationHints validationHints, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, validationOptions, (i & 4) != 0 ? null : validationHints);
            }

            @NotNull
            public final String getRawInput() {
                return this.rawInput;
            }

            @NotNull
            public final ValidationOptions getValidationOptions() {
                return this.validationOptions;
            }

            @Nullable
            public final ValidationHints getValidationHints() {
                return this.validationHints;
            }

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions;", "", "()V", "toString", "", "Prefix", "Sender", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions$Prefix;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions$Sender;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static abstract class ValidationOptions {
                public /* synthetic */ ValidationOptions(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions$Sender;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions;", "senderId", "", "prefix", "(Ljava/lang/String;Ljava/lang/String;)V", "getPrefix", "()Ljava/lang/String;", "getSenderId", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
                public static final class Sender extends ValidationOptions {
                    private final String prefix;
                    private final String senderId;

                    public /* synthetic */ Sender(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this(str, (i & 2) != 0 ? null : str2);
                    }

                    @NotNull
                    public final String getSenderId() {
                        return this.senderId;
                    }

                    @Nullable
                    public final String getPrefix() {
                        return this.prefix;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public Sender(@NotNull String senderId, @Nullable String str) {
                        super(null);
                        Intrinsics.checkNotNullParameter(senderId, "senderId");
                        this.senderId = senderId;
                        this.prefix = str;
                    }
                }

                private ValidationOptions() {
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions$Prefix;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationOptions;", "prefix", "", "(Ljava/lang/String;)V", "getPrefix", "()Ljava/lang/String;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
                public static final class Prefix extends ValidationOptions {
                    private final String prefix;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public Prefix(@NotNull String prefix) {
                        super(null);
                        Intrinsics.checkNotNullParameter(prefix, "prefix");
                        this.prefix = prefix;
                    }

                    @NotNull
                    public final String getPrefix() {
                        return this.prefix;
                    }
                }

                @NotNull
                public String toString() {
                    String string;
                    if (this instanceof Prefix) {
                        string = "prefix = " + ((Prefix) this).getPrefix();
                    } else {
                        if (!(this instanceof Sender)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("sender = ");
                        Sender sender = (Sender) this;
                        sb.append(sender.getSenderId());
                        sb.append(", prefix = ");
                        sb.append(sender.getPrefix());
                        string = sb.toString();
                    }
                    return "ValidationOptions(" + string + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request$Sms$ValidationHints;", "", "minDigits", "", "maxDigits", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "(II)V", "getMaxDigits", "()I", "getMinDigits", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class ValidationHints {
                private final int maxDigits;
                private final int minDigits;

                /* JADX WARN: Illegal instructions before constructor call */
                public ValidationHints() {
                    int i = 0;
                    this(i, i, 3, (DefaultConstructorMarker) null);
                }

                public ValidationHints(int i, int i2) {
                    this.minDigits = i;
                    this.maxDigits = i2;
                }

                public /* synthetic */ ValidationHints(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? Integer.MAX_VALUE : i2);
                }

                public final int getMinDigits() {
                    return this.minDigits;
                }

                public final int getMaxDigits() {
                    return this.maxDigits;
                }

                public /* synthetic */ ValidationHints(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
                }

                public ValidationHints(@Nullable Integer num, @Nullable Integer num2) {
                    this(num != null ? num.intValue() : 0, num2 != null ? num2.intValue() : Integer.MAX_VALUE);
                }
            }
        }

        @NotNull
        public String toString() {
            String string;
            if (this instanceof ValidateEmail) {
                string = "email = " + ((ValidateEmail) this).getEmail().getRawInput();
            } else {
                if (!(this instanceof ValidateSms)) {
                    throw new NoWhenBranchMatchedException();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("sms = ");
                ValidateSms validateSms = (ValidateSms) this;
                sb.append(validateSms.getSms().getRawInput());
                sb.append(", validationOptions = ");
                sb.append(validateSms.getSms().getValidationOptions());
                string = sb.toString();
            }
            return "Request(" + string + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
