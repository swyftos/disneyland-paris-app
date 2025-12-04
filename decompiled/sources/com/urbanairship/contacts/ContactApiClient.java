package com.urbanairship.contacts;

import android.net.Uri;
import androidx.autofill.HintConstants;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.channel.TagGroupsMutation;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.Clock;
import com.urbanairship.util.DateUtils;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000 S2\u00020\u0001:\u0002STB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J6\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0090@¢\u0006\u0004\b\u0014\u0010\u0015J.\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0090@¢\u0006\u0004\b\u0018\u0010\u0019J6\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0090@¢\u0006\u0004\b\u001d\u0010\u001eJ8\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\n2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0002\u0010#J$\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0092@¢\u0006\u0002\u0010'J$\u0010(\u001a\b\u0012\u0004\u0012\u00020 0\n2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020&H\u0092@¢\u0006\u0002\u0010'J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\n2\u0006\u0010%\u001a\u00020&H\u0092@¢\u0006\u0002\u0010,J6\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u000fH\u0092@¢\u0006\u0002\u00100J4\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J4\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00102\u001a\u0002092\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u0010:J4\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u00102\u001a\u00020<2\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u0010=J&\u0010>\u001a\b\u0012\u0004\u0012\u00020+0\n2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0090@¢\u0006\u0004\b?\u0010@J\u001e\u0010A\u001a\b\u0012\u0004\u0012\u00020+0\n2\u0006\u0010\u0017\u001a\u00020\u000bH\u0090@¢\u0006\u0004\bB\u0010CJ&\u0010D\u001a\b\u0012\u0004\u0012\u00020+0\n2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0090@¢\u0006\u0004\bE\u0010FJ&\u0010G\u001a\b\u0012\u0004\u0012\u00020 0\n2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0002\u0010FJ0\u0010H\u001a\b\u0012\u0004\u0012\u00020 0\n2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0002\u0010IJL\u0010J\u001a\b\u0012\u0004\u0012\u00020+0\n2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010L2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010L2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010LH\u0096@¢\u0006\u0002\u0010RR\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/urbanairship/contacts/ContactApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;Lcom/urbanairship/util/Clock;)V", "associatedChannel", "Lcom/urbanairship/http/RequestResult;", "", "contactId", "channelId", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/contacts/ChannelType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disassociateChannel", "optOut", "", "disassociateChannel$urbanairship_core_release", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/contacts/ChannelType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disassociateEmail", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, "disassociateEmail$urbanairship_core_release", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disassociateSms", "msisdn", "senderId", "disassociateSms$urbanairship_core_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "identify", "Lcom/urbanairship/contacts/ContactApiClient$IdentityResult;", "namedUserId", "possiblyOrphanedContactId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDisassociate", "payload", "Lcom/urbanairship/json/JsonSerializable;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performIdentify", "requestAction", "performResend", "", "(Lcom/urbanairship/json/JsonSerializable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerAndAssociate", "url", "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;Lcom/urbanairship/json/JsonSerializable;Lcom/urbanairship/contacts/ChannelType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerEmail", "options", "Lcom/urbanairship/contacts/EmailRegistrationOptions;", Constants.LOCALE, "Ljava/util/Locale;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/contacts/EmailRegistrationOptions;Ljava/util/Locale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerOpen", "address", "Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;Ljava/util/Locale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSms", "Lcom/urbanairship/contacts/SmsRegistrationOptions;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/contacts/SmsRegistrationOptions;Ljava/util/Locale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendChannelOptIn", "resendChannelOptIn$urbanairship_core_release", "(Ljava/lang/String;Lcom/urbanairship/contacts/ChannelType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendEmailOptIn", "resendEmailOptIn$urbanairship_core_release", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resendSmsOptIn", "resendSmsOptIn$urbanairship_core_release", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "resolve", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "tagGroupMutations", "", "Lcom/urbanairship/channel/TagGroupsMutation;", "attributeMutations", "Lcom/urbanairship/channel/AttributeMutation;", "subscriptionListMutations", "Lcom/urbanairship/contacts/ScopedSubscriptionListMutation;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "IdentityResult", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContactApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactApiClient.kt\ncom/urbanairship/contacts/ContactApiClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,563:1\n1#2:564\n44#3,15:565\n*S KotlinDebug\n*F\n+ 1 ContactApiClient.kt\ncom/urbanairship/contacts/ContactApiClient\n*L\n437#1:565,15\n*E\n"})
/* loaded from: classes5.dex */
public class ContactApiClient {
    private static final Companion Companion = new Companion(null);
    private final Clock clock;
    private final AirshipRuntimeConfig runtimeConfig;
    private final SuspendingRequestSession session;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChannelType.values().length];
            try {
                iArr[ChannelType.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChannelType.SMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChannelType.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactApiClient$associatedChannel$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactApiClient.associatedChannel$suspendImpl(ContactApiClient.this, null, null, null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactApiClient$performDisassociate$1, reason: invalid class name and case insensitive filesystem */
    static final class C10951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10951(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactApiClient.this.performDisassociate(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactApiClient$performIdentify$1, reason: invalid class name and case insensitive filesystem */
    static final class C10971 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10971(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactApiClient.this.performIdentify(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactApiClient$performResend$1, reason: invalid class name and case insensitive filesystem */
    static final class C10991 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10991(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactApiClient.this.performResend(null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactApiClient$registerAndAssociate$1, reason: invalid class name and case insensitive filesystem */
    static final class C11011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11011(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactApiClient.this.registerAndAssociate(null, null, null, null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactApiClient$update$1, reason: invalid class name and case insensitive filesystem */
    static final class C11031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11031(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactApiClient.update$suspendImpl(ContactApiClient.this, null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String associatedChannel$lambda$3(String channelId, int i, Map map, String str) {
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (i == 200) {
            return channelId;
        }
        return null;
    }

    @Nullable
    public Object associatedChannel(@NotNull String str, @NotNull String str2, @NotNull ChannelType channelType, @NotNull Continuation<? super RequestResult<String>> continuation) throws RequestException {
        return associatedChannel$suspendImpl(this, str, str2, channelType, continuation);
    }

    @Nullable
    public Object disassociateChannel$urbanairship_core_release(@NotNull String str, @NotNull String str2, @NotNull ChannelType channelType, boolean z, @NotNull Continuation<? super RequestResult<String>> continuation) {
        return disassociateChannel$suspendImpl(this, str, str2, channelType, z, continuation);
    }

    @Nullable
    public Object disassociateEmail$urbanairship_core_release(@NotNull String str, @NotNull String str2, boolean z, @NotNull Continuation<? super RequestResult<String>> continuation) {
        return disassociateEmail$suspendImpl(this, str, str2, z, continuation);
    }

    @Nullable
    public Object disassociateSms$urbanairship_core_release(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull Continuation<? super RequestResult<String>> continuation) {
        return disassociateSms$suspendImpl(this, str, str2, str3, z, continuation);
    }

    @Nullable
    public Object identify(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @NotNull Continuation<? super RequestResult<IdentityResult>> continuation) throws RequestException {
        return identify$suspendImpl(this, str, str2, str3, str4, continuation);
    }

    @Nullable
    public Object registerEmail(@NotNull String str, @NotNull String str2, @NotNull EmailRegistrationOptions emailRegistrationOptions, @NotNull Locale locale, @NotNull Continuation<? super RequestResult<String>> continuation) {
        return registerEmail$suspendImpl(this, str, str2, emailRegistrationOptions, locale, continuation);
    }

    @Nullable
    public Object registerOpen(@NotNull String str, @NotNull String str2, @NotNull OpenChannelRegistrationOptions openChannelRegistrationOptions, @NotNull Locale locale, @NotNull Continuation<? super RequestResult<String>> continuation) throws RequestException {
        return registerOpen$suspendImpl(this, str, str2, openChannelRegistrationOptions, locale, continuation);
    }

    @Nullable
    public Object registerSms(@NotNull String str, @NotNull String str2, @NotNull SmsRegistrationOptions smsRegistrationOptions, @NotNull Locale locale, @NotNull Continuation<? super RequestResult<String>> continuation) throws RequestException {
        return registerSms$suspendImpl(this, str, str2, smsRegistrationOptions, locale, continuation);
    }

    @Nullable
    public Object resendChannelOptIn$urbanairship_core_release(@NotNull String str, @NotNull ChannelType channelType, @NotNull Continuation<? super RequestResult<Unit>> continuation) {
        return resendChannelOptIn$suspendImpl(this, str, channelType, continuation);
    }

    @Nullable
    public Object resendEmailOptIn$urbanairship_core_release(@NotNull String str, @NotNull Continuation<? super RequestResult<Unit>> continuation) {
        return resendEmailOptIn$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object resendSmsOptIn$urbanairship_core_release(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super RequestResult<Unit>> continuation) {
        return resendSmsOptIn$suspendImpl(this, str, str2, continuation);
    }

    @Nullable
    public Object reset(@NotNull String str, @Nullable String str2, @NotNull Continuation<? super RequestResult<IdentityResult>> continuation) throws RequestException {
        return reset$suspendImpl(this, str, str2, continuation);
    }

    @Nullable
    public Object resolve(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super RequestResult<IdentityResult>> continuation) throws RequestException {
        return resolve$suspendImpl(this, str, str2, str3, continuation);
    }

    @Nullable
    public Object update(@NotNull String str, @Nullable List<? extends TagGroupsMutation> list, @Nullable List<? extends AttributeMutation> list2, @Nullable List<? extends ScopedSubscriptionListMutation> list3, @NotNull Continuation<? super RequestResult<Unit>> continuation) throws RequestException {
        return update$suspendImpl(this, str, list, list2, list3, continuation);
    }

    public ContactApiClient(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull SuspendingRequestSession session, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.runtimeConfig = runtimeConfig;
        this.session = session;
        this.clock = clock;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ContactApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        suspendingRequestSession = (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession;
        if ((i & 4) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(airshipRuntimeConfig, suspendingRequestSession, DEFAULT_CLOCK);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B-\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0002\u0010\u000fJ\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J\t\u0010\u0019\u001a\u00020\fHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\fHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006\""}, d2 = {"Lcom/urbanairship/contacts/ContactApiClient$IdentityResult;", "", "jsonMap", "Lcom/urbanairship/json/JsonMap;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/util/Clock;)V", "contactId", "", "isAnonymous", "", "channelAssociatedDateMs", "", "token", "tokenExpiryDateMs", "(Ljava/lang/String;ZJLjava/lang/String;J)V", "getChannelAssociatedDateMs", "()J", "getContactId", "()Ljava/lang/String;", "()Z", "getToken", "getTokenExpiryDateMs", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactApiClient.kt\ncom/urbanairship/contacts/ContactApiClient$IdentityResult\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,563:1\n44#2,15:564\n44#2,15:579\n44#2,15:594\n44#2,15:609\n44#2,15:624\n44#2,15:639\n*S KotlinDebug\n*F\n+ 1 ContactApiClient.kt\ncom/urbanairship/contacts/ContactApiClient$IdentityResult\n*L\n524#1:564,15\n525#1:579,15\n527#1:594,15\n528#1:609,15\n530#1:624,15\n531#1:639,15\n*E\n"})
    public static final /* data */ class IdentityResult {
        private final long channelAssociatedDateMs;
        private final String contactId;
        private final boolean isAnonymous;
        private final String token;
        private final long tokenExpiryDateMs;

        public static /* synthetic */ IdentityResult copy$default(IdentityResult identityResult, String str, boolean z, long j, String str2, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = identityResult.contactId;
            }
            if ((i & 2) != 0) {
                z = identityResult.isAnonymous;
            }
            boolean z2 = z;
            if ((i & 4) != 0) {
                j = identityResult.channelAssociatedDateMs;
            }
            long j3 = j;
            if ((i & 8) != 0) {
                str2 = identityResult.token;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                j2 = identityResult.tokenExpiryDateMs;
            }
            return identityResult.copy(str, z2, j3, str3, j2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getContactId() {
            return this.contactId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsAnonymous() {
            return this.isAnonymous;
        }

        /* renamed from: component3, reason: from getter */
        public final long getChannelAssociatedDateMs() {
            return this.channelAssociatedDateMs;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* renamed from: component5, reason: from getter */
        public final long getTokenExpiryDateMs() {
            return this.tokenExpiryDateMs;
        }

        @NotNull
        public final IdentityResult copy(@NotNull String contactId, boolean isAnonymous, long channelAssociatedDateMs, @NotNull String token, long tokenExpiryDateMs) {
            Intrinsics.checkNotNullParameter(contactId, "contactId");
            Intrinsics.checkNotNullParameter(token, "token");
            return new IdentityResult(contactId, isAnonymous, channelAssociatedDateMs, token, tokenExpiryDateMs);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IdentityResult)) {
                return false;
            }
            IdentityResult identityResult = (IdentityResult) other;
            return Intrinsics.areEqual(this.contactId, identityResult.contactId) && this.isAnonymous == identityResult.isAnonymous && this.channelAssociatedDateMs == identityResult.channelAssociatedDateMs && Intrinsics.areEqual(this.token, identityResult.token) && this.tokenExpiryDateMs == identityResult.tokenExpiryDateMs;
        }

        public int hashCode() {
            return (((((((this.contactId.hashCode() * 31) + Boolean.hashCode(this.isAnonymous)) * 31) + Long.hashCode(this.channelAssociatedDateMs)) * 31) + this.token.hashCode()) * 31) + Long.hashCode(this.tokenExpiryDateMs);
        }

        @NotNull
        public String toString() {
            return "IdentityResult(contactId=" + this.contactId + ", isAnonymous=" + this.isAnonymous + ", channelAssociatedDateMs=" + this.channelAssociatedDateMs + ", token=" + this.token + ", tokenExpiryDateMs=" + this.tokenExpiryDateMs + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Removed duplicated region for block: B:117:0x02a8  */
        /* JADX WARN: Removed duplicated region for block: B:231:0x0523  */
        /* JADX WARN: Removed duplicated region for block: B:477:0x0b0f  */
        /* JADX WARN: Removed duplicated region for block: B:489:0x0b9f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public IdentityResult(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r31, @org.jetbrains.annotations.NotNull com.urbanairship.util.Clock r32) throws java.text.ParseException, com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 3146
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient.IdentityResult.<init>(com.urbanairship.json.JsonMap, com.urbanairship.util.Clock):void");
        }

        public IdentityResult(@NotNull String contactId, boolean z, long j, @NotNull String token, long j2) {
            Intrinsics.checkNotNullParameter(contactId, "contactId");
            Intrinsics.checkNotNullParameter(token, "token");
            this.contactId = contactId;
            this.isAnonymous = z;
            this.channelAssociatedDateMs = j;
            this.token = token;
            this.tokenExpiryDateMs = j2;
        }

        @NotNull
        public final String getContactId() {
            return this.contactId;
        }

        public final boolean isAnonymous() {
            return this.isAnonymous;
        }

        public final long getChannelAssociatedDateMs() {
            return this.channelAssociatedDateMs;
        }

        @NotNull
        public final String getToken() {
            return this.token;
        }

        public final long getTokenExpiryDateMs() {
            return this.tokenExpiryDateMs;
        }
    }

    static /* synthetic */ Object resolve$suspendImpl(ContactApiClient contactApiClient, String str, String str2, String str3, Continuation continuation) {
        return contactApiClient.performIdentify(str, JsonExtensionsKt.jsonMapOf(TuplesKt.to(DeferredApiClient.KEY_CONTACT_ID, str2), TuplesKt.to("type", "resolve"), TuplesKt.to("possibly_orphaned_contact_id", str3)), continuation);
    }

    static /* synthetic */ Object identify$suspendImpl(ContactApiClient contactApiClient, String str, String str2, String str3, String str4, Continuation continuation) {
        return contactApiClient.performIdentify(str, JsonExtensionsKt.jsonMapOf(TuplesKt.to("named_user_id", str3), TuplesKt.to("type", "identify"), TuplesKt.to(DeferredApiClient.KEY_CONTACT_ID, str2), TuplesKt.to("possibly_orphaned_contact_id", str4)), continuation);
    }

    static /* synthetic */ Object reset$suspendImpl(ContactApiClient contactApiClient, String str, String str2, Continuation continuation) {
        return contactApiClient.performIdentify(str, JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "reset"), TuplesKt.to("possibly_orphaned_contact_id", str2)), continuation);
    }

    static /* synthetic */ Object registerEmail$suspendImpl(ContactApiClient contactApiClient, String str, String str2, EmailRegistrationOptions emailRegistrationOptions, Locale locale, Continuation continuation) {
        String str3;
        Uri uriBuild = contactApiClient.runtimeConfig.getDeviceUrl().appendEncodedPath("api/channels/restricted/email/").build();
        Pair pair = TuplesKt.to("type", "email");
        Pair pair2 = TuplesKt.to("address", str2);
        Pair pair3 = TuplesKt.to(TCEventPropertiesNames.TCD_TIMEZONE, TimeZone.getDefault().getID());
        Pair pair4 = TuplesKt.to("locale_language", locale.getLanguage());
        Pair pair5 = TuplesKt.to("locale_country", locale.getCountry());
        long commercialOptedIn = emailRegistrationOptions.getCommercialOptedIn();
        Pair pair6 = TuplesKt.to("commercial_opted_in", commercialOptedIn > 0 ? DateUtils.createIso8601TimeStamp(commercialOptedIn) : null);
        long transactionalOptedIn = emailRegistrationOptions.getTransactionalOptedIn();
        Pair pair7 = TuplesKt.to(TCVideoEventPropertiesNames.TCV_CHANNEL, JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, pair4, pair5, pair6, TuplesKt.to("transactional_opted_in", transactionalOptedIn > 0 ? DateUtils.createIso8601TimeStamp(transactionalOptedIn) : null)));
        emailRegistrationOptions.getIsDoubleOptIn();
        if (emailRegistrationOptions.getIsDoubleOptIn()) {
            str3 = DoubleTypedProperty.TYPE;
        } else {
            str3 = "classic";
        }
        return contactApiClient.registerAndAssociate(str, uriBuild, JsonExtensionsKt.jsonMapOf(pair7, TuplesKt.to("opt_in_mode", str3), TuplesKt.to(CustomEvent.PROPERTIES, emailRegistrationOptions.getProperties())), ChannelType.EMAIL, continuation);
    }

    static /* synthetic */ Object registerSms$suspendImpl(ContactApiClient contactApiClient, String str, String str2, SmsRegistrationOptions smsRegistrationOptions, Locale locale, Continuation continuation) {
        return contactApiClient.registerAndAssociate(str, contactApiClient.runtimeConfig.getDeviceUrl().appendEncodedPath("api/channels/restricted/sms/").build(), JsonExtensionsKt.jsonMapOf(TuplesKt.to("msisdn", str2), TuplesKt.to("sender", smsRegistrationOptions.getSenderId()), TuplesKt.to(TCEventPropertiesNames.TCD_TIMEZONE, TimeZone.getDefault().getID()), TuplesKt.to("locale_language", locale.getLanguage()), TuplesKt.to("locale_country", locale.getCountry())), ChannelType.SMS, continuation);
    }

    static /* synthetic */ Object registerOpen$suspendImpl(ContactApiClient contactApiClient, String str, String str2, OpenChannelRegistrationOptions openChannelRegistrationOptions, Locale locale, Continuation continuation) {
        return contactApiClient.registerAndAssociate(str, contactApiClient.runtimeConfig.getDeviceUrl().appendEncodedPath("api/channels/restricted/open/").build(), JsonExtensionsKt.jsonMapOf(TuplesKt.to(TCVideoEventPropertiesNames.TCV_CHANNEL, JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", AbstractCircuitBreaker.PROPERTY_NAME), TuplesKt.to("opt_in", Boxing.boxBoolean(true)), TuplesKt.to("address", str2), TuplesKt.to(TCEventPropertiesNames.TCD_TIMEZONE, TimeZone.getDefault().getID()), TuplesKt.to("locale_language", locale.getLanguage()), TuplesKt.to("locale_country", locale.getCountry()), TuplesKt.to(AbstractCircuitBreaker.PROPERTY_NAME, JsonExtensionsKt.jsonMapOf(TuplesKt.to("open_platform_name", openChannelRegistrationOptions.getPlatformName()), TuplesKt.to("identifiers", openChannelRegistrationOptions.getIdentifiers())))))), ChannelType.OPEN, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object associatedChannel$suspendImpl(com.urbanairship.contacts.ContactApiClient r18, java.lang.String r19, final java.lang.String r20, final com.urbanairship.contacts.ChannelType r21, kotlin.coroutines.Continuation r22) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient.associatedChannel$suspendImpl(com.urbanairship.contacts.ContactApiClient, java.lang.String, java.lang.String, com.urbanairship.contacts.ChannelType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object update$suspendImpl(com.urbanairship.contacts.ContactApiClient r16, final java.lang.String r17, java.util.List r18, java.util.List r19, java.util.List r20, kotlin.coroutines.Continuation r21) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient.update$suspendImpl(com.urbanairship.contacts.ContactApiClient, java.lang.String, java.util.List, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object registerAndAssociate(java.lang.String r19, android.net.Uri r20, com.urbanairship.json.JsonSerializable r21, com.urbanairship.contacts.ChannelType r22, kotlin.coroutines.Continuation r23) throws com.urbanairship.http.RequestException {
        /*
            r18 = this;
            r0 = r18
            r1 = r22
            r2 = r23
            boolean r3 = r2 instanceof com.urbanairship.contacts.ContactApiClient.C11011
            if (r3 == 0) goto L19
            r3 = r2
            com.urbanairship.contacts.ContactApiClient$registerAndAssociate$1 r3 = (com.urbanairship.contacts.ContactApiClient.C11011) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.urbanairship.contacts.ContactApiClient$registerAndAssociate$1 r3 = new com.urbanairship.contacts.ContactApiClient$registerAndAssociate$1
            r3.<init>(r2)
        L1e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L4f
            if (r5 == r7) goto L3c
            if (r5 != r6) goto L34
            kotlin.ResultKt.throwOnFailure(r2)
            goto Ld0
        L34:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3c:
            java.lang.Object r0 = r3.L$2
            com.urbanairship.contacts.ChannelType r0 = (com.urbanairship.contacts.ChannelType) r0
            java.lang.Object r1 = r3.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$0
            com.urbanairship.contacts.ContactApiClient r5 = (com.urbanairship.contacts.ContactApiClient) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r10 = r1
            r1 = r0
            r0 = r5
            goto La8
        L4f:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.String r2 = "Accept"
            java.lang.String r5 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            com.urbanairship.config.AirshipRuntimeConfig r5 = r0.runtimeConfig
            com.urbanairship.AirshipConfigOptions r5 = r5.getConfigOptions()
            java.lang.String r5 = r5.appKey
            java.lang.String r9 = "X-UA-Appkey"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r9, r5)
            kotlin.Pair[] r2 = new kotlin.Pair[]{r2, r5}
            java.util.Map r14 = kotlin.collections.MapsKt.mapOf(r2)
            com.urbanairship.http.Request r2 = new com.urbanairship.http.Request
            com.urbanairship.http.RequestAuth$GeneratedAppToken r12 = com.urbanairship.http.RequestAuth.GeneratedAppToken.INSTANCE
            com.urbanairship.http.RequestBody$Json r13 = new com.urbanairship.http.RequestBody$Json
            r5 = r21
            r13.<init>(r5)
            r16 = 32
            r17 = 0
            java.lang.String r11 = "POST"
            r15 = 0
            r9 = r2
            r10 = r20
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            com.urbanairship.contacts.ContactApiClient$registerAndAssociate$2 r5 = new com.urbanairship.contacts.ContactApiClient$registerAndAssociate$2
            r5.<init>()
            com.urbanairship.UALog.d$default(r8, r5, r7, r8)
            com.urbanairship.http.SuspendingRequestSession r5 = r0.session
            com.urbanairship.contacts.ContactApiClient$$ExternalSyntheticLambda3 r9 = new com.urbanairship.contacts.ContactApiClient$$ExternalSyntheticLambda3
            r9.<init>()
            r3.L$0 = r0
            r10 = r19
            r3.L$1 = r10
            r3.L$2 = r1
            r3.label = r7
            java.lang.Object r2 = r5.execute(r2, r9, r3)
            if (r2 != r4) goto La8
            return r4
        La8:
            com.urbanairship.http.RequestResult r2 = (com.urbanairship.http.RequestResult) r2
            com.urbanairship.contacts.ContactApiClient$registerAndAssociate$result$2$1 r5 = new com.urbanairship.contacts.ContactApiClient$registerAndAssociate$result$2$1
            r5.<init>()
            com.urbanairship.http.SuspendingRequestSessionKt.log(r2, r5)
            java.lang.Object r5 = r2.getValue()
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto Lc1
            com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1 r0 = new kotlin.jvm.functions.Function1() { // from class: com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1
                static {
                    /*
                        com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1 r0 = new com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1) com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1.INSTANCE com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public final java.lang.String invoke(java.lang.String r1) {
                    /*
                        r0 = this;
                        r0 = 0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1.invoke(java.lang.String):java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        java.lang.String r1 = (java.lang.String) r1
                        java.lang.String r0 = r0.invoke(r1)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient$registerAndAssociate$channelId$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            com.urbanairship.http.RequestResult r0 = r2.map(r0)
            return r0
        Lc1:
            r3.L$0 = r8
            r3.L$1 = r8
            r3.L$2 = r8
            r3.label = r6
            java.lang.Object r2 = r0.associatedChannel(r10, r5, r1, r3)
            if (r2 != r4) goto Ld0
            return r4
        Ld0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient.registerAndAssociate(java.lang.String, android.net.Uri, com.urbanairship.json.JsonSerializable, com.urbanairship.contacts.ChannelType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String registerAndAssociate$lambda$8(int i, Map map, String str) {
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (UAHttpStatusUtil.inSuccessRange(i)) {
            return JsonValue.parseString(str).optMap().opt("channel_id").requireString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object performIdentify(final java.lang.String r17, com.urbanairship.json.JsonSerializable r18, kotlin.coroutines.Continuation r19) throws com.urbanairship.json.JsonException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r19
            boolean r3 = r2 instanceof com.urbanairship.contacts.ContactApiClient.C10971
            if (r3 == 0) goto L19
            r3 = r2
            com.urbanairship.contacts.ContactApiClient$performIdentify$1 r3 = (com.urbanairship.contacts.ContactApiClient.C10971) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.urbanairship.contacts.ContactApiClient$performIdentify$1 r3 = new com.urbanairship.contacts.ContactApiClient$performIdentify$1
            r3.<init>(r2)
        L1e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L3c
            if (r5 != r6) goto L34
            java.lang.Object r0 = r3.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r2)
            goto Lbb
        L34:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3c:
            kotlin.ResultKt.throwOnFailure(r2)
            com.urbanairship.config.AirshipRuntimeConfig r2 = r0.runtimeConfig
            com.urbanairship.config.UrlBuilder r2 = r2.getDeviceUrl()
            java.lang.String r5 = "api/contacts/identify/v2"
            com.urbanairship.config.UrlBuilder r2 = r2.appendEncodedPath(r5)
            android.net.Uri r8 = r2.build()
            com.urbanairship.config.AirshipRuntimeConfig r2 = r0.runtimeConfig
            int r2 = r2.getPlatform()
            java.lang.String r2 = com.urbanairship.util.PlatformUtils.getDeviceType(r2)
            java.lang.String r5 = "device_type"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r5, r2)
            kotlin.Pair[] r2 = new kotlin.Pair[]{r2}
            com.urbanairship.json.JsonMap r2 = com.urbanairship.json.JsonExtensionsKt.jsonMapOf(r2)
            java.lang.String r5 = "device_info"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r5, r2)
            java.lang.String r5 = "action"
            r7 = r18
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r7)
            kotlin.Pair[] r2 = new kotlin.Pair[]{r2, r5}
            com.urbanairship.json.JsonMap r2 = com.urbanairship.json.JsonExtensionsKt.jsonMapOf(r2)
            java.lang.String r5 = "Accept"
            java.lang.String r7 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r7)
            java.util.Map r12 = kotlin.collections.MapsKt.mapOf(r5)
            com.urbanairship.http.Request r5 = new com.urbanairship.http.Request
            com.urbanairship.http.RequestAuth$GeneratedChannelToken r10 = new com.urbanairship.http.RequestAuth$GeneratedChannelToken
            r10.<init>(r1)
            com.urbanairship.http.RequestBody$Json r11 = new com.urbanairship.http.RequestBody$Json
            r11.<init>(r2)
            r14 = 32
            r15 = 0
            java.lang.String r9 = "POST"
            r13 = 0
            r7 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)
            com.urbanairship.contacts.ContactApiClient$performIdentify$2 r2 = new com.urbanairship.contacts.ContactApiClient$performIdentify$2
            r2.<init>()
            r7 = 0
            com.urbanairship.UALog.d$default(r7, r2, r6, r7)
            com.urbanairship.http.SuspendingRequestSession r2 = r0.session
            com.urbanairship.contacts.ContactApiClient$$ExternalSyntheticLambda1 r7 = new com.urbanairship.contacts.ContactApiClient$$ExternalSyntheticLambda1
            r7.<init>()
            r3.L$0 = r1
            r3.label = r6
            java.lang.Object r2 = r2.execute(r5, r7, r3)
            if (r2 != r4) goto Lba
            return r4
        Lba:
            r0 = r1
        Lbb:
            r1 = r2
            com.urbanairship.http.RequestResult r1 = (com.urbanairship.http.RequestResult) r1
            com.urbanairship.contacts.ContactApiClient$performIdentify$4$1 r3 = new com.urbanairship.contacts.ContactApiClient$performIdentify$4$1
            r3.<init>()
            com.urbanairship.http.SuspendingRequestSessionKt.log(r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient.performIdentify(java.lang.String, com.urbanairship.json.JsonSerializable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IdentityResult performIdentify$lambda$10(ContactApiClient this$0, int i, Map map, String str) throws JsonException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (!UAHttpStatusUtil.inSuccessRange(i)) {
            return null;
        }
        JsonMap jsonMapRequireMap = JsonValue.parseString(str).requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        return new IdentityResult(jsonMapRequireMap, this$0.clock);
    }

    static /* synthetic */ Object resendChannelOptIn$suspendImpl(ContactApiClient contactApiClient, String str, ChannelType channelType, Continuation continuation) {
        String str2;
        Pair pair = TuplesKt.to("channel_id", str);
        int i = WhenMappings.$EnumSwitchMapping$0[channelType.ordinal()];
        if (i == 1) {
            str2 = "email";
        } else if (i == 2) {
            str2 = "sms";
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str2 = AbstractCircuitBreaker.PROPERTY_NAME;
        }
        return contactApiClient.performResend(JsonExtensionsKt.jsonMapOf(pair, TuplesKt.to("channel_type", str2)), continuation);
    }

    static /* synthetic */ Object resendEmailOptIn$suspendImpl(ContactApiClient contactApiClient, String str, Continuation continuation) {
        return contactApiClient.performResend(JsonExtensionsKt.jsonMapOf(TuplesKt.to("email_address", str), TuplesKt.to("channel_type", ChannelType.EMAIL)), continuation);
    }

    static /* synthetic */ Object resendSmsOptIn$suspendImpl(ContactApiClient contactApiClient, String str, String str2, Continuation continuation) {
        return contactApiClient.performResend(JsonExtensionsKt.jsonMapOf(TuplesKt.to("msisdn", str), TuplesKt.to("sender", str2), TuplesKt.to("channel_type", ChannelType.SMS)), continuation);
    }

    static /* synthetic */ Object disassociateChannel$suspendImpl(ContactApiClient contactApiClient, String str, String str2, ChannelType channelType, boolean z, Continuation continuation) {
        return contactApiClient.performDisassociate(str, JsonExtensionsKt.jsonMapOf(TuplesKt.to("channel_id", str2), TuplesKt.to("channel_type", channelType), TuplesKt.to("opt_out", Boxing.boxBoolean(z))), continuation);
    }

    static /* synthetic */ Object disassociateEmail$suspendImpl(ContactApiClient contactApiClient, String str, String str2, boolean z, Continuation continuation) {
        return contactApiClient.performDisassociate(str, JsonExtensionsKt.jsonMapOf(TuplesKt.to("email_address", str2), TuplesKt.to("channel_type", ChannelType.EMAIL), TuplesKt.to("opt_out", Boxing.boxBoolean(z))), continuation);
    }

    static /* synthetic */ Object disassociateSms$suspendImpl(ContactApiClient contactApiClient, String str, String str2, String str3, boolean z, Continuation continuation) {
        return contactApiClient.performDisassociate(str, JsonExtensionsKt.jsonMapOf(TuplesKt.to("channel_type", ChannelType.SMS), TuplesKt.to("msisdn", str2), TuplesKt.to("sender", str3), TuplesKt.to("opt_out", Boxing.boxBoolean(z))), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object performDisassociate(java.lang.String r18, final com.urbanairship.json.JsonSerializable r19, kotlin.coroutines.Continuation r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            boolean r4 = r3 instanceof com.urbanairship.contacts.ContactApiClient.C10951
            if (r4 == 0) goto L1b
            r4 = r3
            com.urbanairship.contacts.ContactApiClient$performDisassociate$1 r4 = (com.urbanairship.contacts.ContactApiClient.C10951) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L1b
            int r5 = r5 - r6
            r4.label = r5
            goto L20
        L1b:
            com.urbanairship.contacts.ContactApiClient$performDisassociate$1 r4 = new com.urbanairship.contacts.ContactApiClient$performDisassociate$1
            r4.<init>(r3)
        L20:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 1
            if (r6 == 0) goto L3d
            if (r6 != r7) goto L35
            java.lang.Object r0 = r4.L$0
            com.urbanairship.json.JsonSerializable r0 = (com.urbanairship.json.JsonSerializable) r0
            kotlin.ResultKt.throwOnFailure(r3)
            goto Laa
        L35:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3d:
            kotlin.ResultKt.throwOnFailure(r3)
            com.urbanairship.config.AirshipRuntimeConfig r3 = r0.runtimeConfig
            com.urbanairship.config.UrlBuilder r3 = r3.getDeviceUrl()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "api/contacts/disassociate/"
            r6.append(r8)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            com.urbanairship.config.UrlBuilder r3 = r3.appendEncodedPath(r6)
            android.net.Uri r9 = r3.build()
            java.lang.String r3 = "Accept"
            java.lang.String r6 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r6)
            java.lang.String r6 = "Content-Type"
            java.lang.String r8 = "application/json"
            kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r8)
            kotlin.Pair[] r3 = new kotlin.Pair[]{r3, r6}
            java.util.Map r13 = kotlin.collections.MapsKt.mapOf(r3)
            com.urbanairship.http.Request r3 = new com.urbanairship.http.Request
            com.urbanairship.http.RequestAuth$ContactTokenAuth r11 = new com.urbanairship.http.RequestAuth$ContactTokenAuth
            r11.<init>(r1)
            com.urbanairship.http.RequestBody$Json r12 = new com.urbanairship.http.RequestBody$Json
            r12.<init>(r2)
            r15 = 32
            r16 = 0
            java.lang.String r10 = "POST"
            r14 = 0
            r8 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            com.urbanairship.contacts.ContactApiClient$performDisassociate$2 r1 = new com.urbanairship.contacts.ContactApiClient$performDisassociate$2
            r1.<init>()
            r6 = 0
            com.urbanairship.UALog.d$default(r6, r1, r7, r6)
            com.urbanairship.http.SuspendingRequestSession r0 = r0.session
            com.urbanairship.contacts.ContactApiClient$$ExternalSyntheticLambda2 r1 = new com.urbanairship.contacts.ContactApiClient$$ExternalSyntheticLambda2
            r1.<init>()
            r4.L$0 = r2
            r4.label = r7
            java.lang.Object r3 = r0.execute(r3, r1, r4)
            if (r3 != r5) goto La9
            return r5
        La9:
            r0 = r2
        Laa:
            r1 = r3
            com.urbanairship.http.RequestResult r1 = (com.urbanairship.http.RequestResult) r1
            com.urbanairship.contacts.ContactApiClient$performDisassociate$4$1 r2 = new com.urbanairship.contacts.ContactApiClient$performDisassociate$4$1
            r2.<init>()
            com.urbanairship.http.SuspendingRequestSessionKt.log(r1, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient.performDisassociate(java.lang.String, com.urbanairship.json.JsonSerializable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String performDisassociate$lambda$12(int i, Map map, String str) throws JsonException {
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (!UAHttpStatusUtil.inSuccessRange(i)) {
            return null;
        }
        JsonMap jsonMapRequireMap = JsonValue.parseString(str).requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        JsonValue jsonValue = jsonMapRequireMap.get("channel_id");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.checkNotNull(jsonValue);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            String strOptString = jsonValue.optString();
            if (strOptString != null) {
                return strOptString;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            String strOptString2 = jsonValue.optString();
            if (strOptString2 != null) {
                return strOptString2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (String) Boolean.valueOf(jsonValue.getBoolean(false));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (String) Long.valueOf(jsonValue.getLong(0L));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            return (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            return (String) Integer.valueOf(jsonValue.getInt(0));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            return (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList = jsonValue.optList();
            if (objOptList != null) {
                return (String) objOptList;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap = jsonValue.optMap();
            if (objOptMap != null) {
                return (String) objOptMap;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
            Object jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 != null) {
                return (String) jsonValue2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object performResend(final com.urbanairship.json.JsonSerializable r14, kotlin.coroutines.Continuation r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.urbanairship.contacts.ContactApiClient.C10991
            if (r0 == 0) goto L13
            r0 = r15
            com.urbanairship.contacts.ContactApiClient$performResend$1 r0 = (com.urbanairship.contacts.ContactApiClient.C10991) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.contacts.ContactApiClient$performResend$1 r0 = new com.urbanairship.contacts.ContactApiClient$performResend$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r13 = r0.L$0
            r14 = r13
            com.urbanairship.json.JsonSerializable r14 = (com.urbanairship.json.JsonSerializable) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L8a
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            kotlin.ResultKt.throwOnFailure(r15)
            com.urbanairship.config.AirshipRuntimeConfig r15 = r13.runtimeConfig
            com.urbanairship.config.UrlBuilder r15 = r15.getDeviceUrl()
            java.lang.String r2 = "api/channels/resend"
            com.urbanairship.config.UrlBuilder r15 = r15.appendEncodedPath(r2)
            android.net.Uri r5 = r15.build()
            java.lang.String r15 = "Accept"
            java.lang.String r2 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r2)
            java.lang.String r2 = "Content-Type"
            java.lang.String r4 = "application/json"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r4)
            kotlin.Pair[] r15 = new kotlin.Pair[]{r15, r2}
            java.util.Map r9 = kotlin.collections.MapsKt.mapOf(r15)
            com.urbanairship.http.Request r15 = new com.urbanairship.http.Request
            com.urbanairship.http.RequestAuth$GeneratedAppToken r7 = com.urbanairship.http.RequestAuth.GeneratedAppToken.INSTANCE
            com.urbanairship.http.RequestBody$Json r8 = new com.urbanairship.http.RequestBody$Json
            r8.<init>(r14)
            r11 = 32
            r12 = 0
            java.lang.String r6 = "POST"
            r10 = 0
            r4 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            com.urbanairship.contacts.ContactApiClient$performResend$2 r2 = new com.urbanairship.contacts.ContactApiClient$performResend$2
            r2.<init>()
            r4 = 0
            com.urbanairship.UALog.d$default(r4, r2, r3, r4)
            com.urbanairship.http.SuspendingRequestSession r13 = r13.session
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r15 = r13.execute(r15, r0)
            if (r15 != r1) goto L8a
            return r1
        L8a:
            r13 = r15
            com.urbanairship.http.RequestResult r13 = (com.urbanairship.http.RequestResult) r13
            com.urbanairship.contacts.ContactApiClient$performResend$3$1 r0 = new com.urbanairship.contacts.ContactApiClient$performResend$3$1
            r0.<init>()
            com.urbanairship.http.SuspendingRequestSessionKt.log(r13, r0)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactApiClient.performResend(com.urbanairship.json.JsonSerializable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
