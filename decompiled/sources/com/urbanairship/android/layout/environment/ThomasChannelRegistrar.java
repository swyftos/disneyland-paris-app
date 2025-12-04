package com.urbanairship.android.layout.environment;

import com.urbanairship.UAirship;
import com.urbanairship.android.layout.info.ThomasChannelRegistration;
import com.urbanairship.android.layout.info.ThomasEmailRegistrationOptions;
import com.urbanairship.android.layout.property.SmsLocale;
import com.urbanairship.contacts.EmailRegistrationOptions;
import com.urbanairship.contacts.SmsRegistrationOptions;
import com.urbanairship.util.Clock;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0010\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/android/layout/environment/ThomasChannelRegistrar;", "", "clock", "Lcom/urbanairship/util/Clock;", "registerEmail", "Lkotlin/Function2;", "", "Lcom/urbanairship/contacts/EmailRegistrationOptions;", "", "registerSms", "Lcom/urbanairship/contacts/SmsRegistrationOptions;", "(Lcom/urbanairship/util/Clock;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "register", "channels", "", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "channelRegistration", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration$Email;", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration$Sms;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nThomasChannelRegistrar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThomasChannelRegistrar.kt\ncom/urbanairship/android/layout/environment/ThomasChannelRegistrar\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1855#2,2:74\n*S KotlinDebug\n*F\n+ 1 ThomasChannelRegistrar.kt\ncom/urbanairship/android/layout/environment/ThomasChannelRegistrar\n*L\n23#1:74,2\n*E\n"})
/* loaded from: classes5.dex */
public final class ThomasChannelRegistrar {
    private final Clock clock;
    private final Function2 registerEmail;
    private final Function2 registerSms;

    public ThomasChannelRegistrar() {
        this(null, null, null, 7, null);
    }

    public ThomasChannelRegistrar(@NotNull Clock clock, @NotNull Function2<? super String, ? super EmailRegistrationOptions, Unit> registerEmail, @NotNull Function2<? super String, ? super SmsRegistrationOptions, Unit> registerSms) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(registerEmail, "registerEmail");
        Intrinsics.checkNotNullParameter(registerSms, "registerSms");
        this.clock = clock;
        this.registerEmail = registerEmail;
        this.registerSms = registerSms;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ThomasChannelRegistrar(Clock DEFAULT_CLOCK, Function2 function2, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(DEFAULT_CLOCK, (i & 2) != 0 ? new Function2() { // from class: com.urbanairship.android.layout.environment.ThomasChannelRegistrar.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (EmailRegistrationOptions) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String address, EmailRegistrationOptions options) {
                Intrinsics.checkNotNullParameter(address, "address");
                Intrinsics.checkNotNullParameter(options, "options");
                UAirship.shared().getContact().registerEmail(address, options);
            }
        } : function2, (i & 4) != 0 ? new Function2() { // from class: com.urbanairship.android.layout.environment.ThomasChannelRegistrar.2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (SmsRegistrationOptions) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String msisdn, SmsRegistrationOptions options) {
                Intrinsics.checkNotNullParameter(msisdn, "msisdn");
                Intrinsics.checkNotNullParameter(options, "options");
                UAirship.shared().getContact().registerSms(msisdn, options);
            }
        } : function22);
    }

    private final void registerSms(ThomasChannelRegistration.Sms channelRegistration) {
        if (channelRegistration.getRegistration() instanceof SmsLocale.Registration.OptIn) {
            this.registerSms.invoke(channelRegistration.getAddress(), SmsRegistrationOptions.INSTANCE.options(((SmsLocale.Registration.OptIn) channelRegistration.getRegistration()).getData().getSenderId()));
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void registerEmail(ThomasChannelRegistration.Email channelRegistration) {
        EmailRegistrationOptions emailRegistrationOptionsOptions$default;
        Date date = new Date(this.clock.currentTimeMillis());
        ThomasEmailRegistrationOptions options = channelRegistration.getOptions();
        if (options instanceof ThomasEmailRegistrationOptions.Commercial) {
            EmailRegistrationOptions.Companion companion = EmailRegistrationOptions.INSTANCE;
            if (!((ThomasEmailRegistrationOptions.Commercial) channelRegistration.getOptions()).getOptedIn()) {
                date = null;
            }
            emailRegistrationOptionsOptions$default = EmailRegistrationOptions.Companion.commercialOptions$default(companion, date, null, ((ThomasEmailRegistrationOptions.Commercial) channelRegistration.getOptions()).getProperties(), 2, null);
        } else if (options instanceof ThomasEmailRegistrationOptions.DoubleOptIn) {
            emailRegistrationOptionsOptions$default = EmailRegistrationOptions.Companion.options$default(EmailRegistrationOptions.INSTANCE, null, ((ThomasEmailRegistrationOptions.DoubleOptIn) channelRegistration.getOptions()).getProperties(), true, 1, null);
        } else if (options instanceof ThomasEmailRegistrationOptions.Transactional) {
            emailRegistrationOptionsOptions$default = EmailRegistrationOptions.Companion.options$default(EmailRegistrationOptions.INSTANCE, null, ((ThomasEmailRegistrationOptions.Transactional) channelRegistration.getOptions()).getProperties(), false, 1, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.registerEmail.invoke(channelRegistration.getAddress(), emailRegistrationOptionsOptions$default);
    }

    public final void register(@NotNull List<? extends ThomasChannelRegistration> channels) {
        Intrinsics.checkNotNullParameter(channels, "channels");
        for (ThomasChannelRegistration thomasChannelRegistration : channels) {
            if (thomasChannelRegistration instanceof ThomasChannelRegistration.Email) {
                registerEmail((ThomasChannelRegistration.Email) thomasChannelRegistration);
            } else if (thomasChannelRegistration instanceof ThomasChannelRegistration.Sms) {
                registerSms((ThomasChannelRegistration.Sms) thomasChannelRegistration);
            }
        }
    }
}
