package com.urbanairship.android.layout.info;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.property.SmsLocale;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "", "()V", "Email", "Sms", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration$Email;", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration$Sms;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ThomasChannelRegistration {
    public /* synthetic */ ThomasChannelRegistration(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/info/ThomasChannelRegistration$Email;", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "address", "", "options", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", "(Ljava/lang/String;Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;)V", "getAddress", "()Ljava/lang/String;", "getOptions", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Email extends ThomasChannelRegistration {
        private final String address;
        private final ThomasEmailRegistrationOptions options;

        public static /* synthetic */ Email copy$default(Email email, String str, ThomasEmailRegistrationOptions thomasEmailRegistrationOptions, int i, Object obj) {
            if ((i & 1) != 0) {
                str = email.address;
            }
            if ((i & 2) != 0) {
                thomasEmailRegistrationOptions = email.options;
            }
            return email.copy(str, thomasEmailRegistrationOptions);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final ThomasEmailRegistrationOptions getOptions() {
            return this.options;
        }

        @NotNull
        public final Email copy(@NotNull String address, @NotNull ThomasEmailRegistrationOptions options) {
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(options, "options");
            return new Email(address, options);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Email)) {
                return false;
            }
            Email email = (Email) other;
            return Intrinsics.areEqual(this.address, email.address) && Intrinsics.areEqual(this.options, email.options);
        }

        public int hashCode() {
            return (this.address.hashCode() * 31) + this.options.hashCode();
        }

        @NotNull
        public String toString() {
            return "Email(address=" + this.address + ", options=" + this.options + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Email(@NotNull String address, @NotNull ThomasEmailRegistrationOptions options) {
            super(null);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(options, "options");
            this.address = address;
            this.options = options;
        }

        @NotNull
        public final String getAddress() {
            return this.address;
        }

        @NotNull
        public final ThomasEmailRegistrationOptions getOptions() {
            return this.options;
        }
    }

    private ThomasChannelRegistration() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/info/ThomasChannelRegistration$Sms;", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "address", "", "registration", "Lcom/urbanairship/android/layout/property/SmsLocale$Registration;", "(Ljava/lang/String;Lcom/urbanairship/android/layout/property/SmsLocale$Registration;)V", "getAddress", "()Ljava/lang/String;", "getRegistration", "()Lcom/urbanairship/android/layout/property/SmsLocale$Registration;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Sms extends ThomasChannelRegistration {
        private final String address;
        private final SmsLocale.Registration registration;

        public static /* synthetic */ Sms copy$default(Sms sms, String str, SmsLocale.Registration registration, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sms.address;
            }
            if ((i & 2) != 0) {
                registration = sms.registration;
            }
            return sms.copy(str, registration);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final SmsLocale.Registration getRegistration() {
            return this.registration;
        }

        @NotNull
        public final Sms copy(@NotNull String address, @NotNull SmsLocale.Registration registration) {
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(registration, "registration");
            return new Sms(address, registration);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Sms)) {
                return false;
            }
            Sms sms = (Sms) other;
            return Intrinsics.areEqual(this.address, sms.address) && Intrinsics.areEqual(this.registration, sms.registration);
        }

        public int hashCode() {
            return (this.address.hashCode() * 31) + this.registration.hashCode();
        }

        @NotNull
        public String toString() {
            return "Sms(address=" + this.address + ", registration=" + this.registration + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Sms(@NotNull String address, @NotNull SmsLocale.Registration registration) {
            super(null);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(registration, "registration");
            this.address = address;
            this.registration = registration;
        }

        @NotNull
        public final String getAddress() {
            return this.address;
        }

        @NotNull
        public final SmsLocale.Registration getRegistration() {
            return this.registration;
        }
    }
}
