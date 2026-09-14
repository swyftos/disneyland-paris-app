package com.urbanairship.contacts;

import ch.qos.logback.core.net.SyslogConstants;
import com.tagcommander.lib.p193serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PrivacyManager;
import com.urbanairship.audience.AudienceOverrides;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.RequestResult;
import com.urbanairship.util.AutoRefreshingDataProvider;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B3\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0002\u0010\rBO\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\"\u001a\u00020\u0004H\u0016J*\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020$2\u0006\u0010%\u001a\u00020\u000bH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J\u001e\u0010(\u001a\u0004\u0018\u00010\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u000bH\u0002R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006+"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannelsProvider;", "Lcom/urbanairship/util/AutoRefreshingDataProvider;", "", "Lcom/urbanairship/contacts/ContactChannel;", "Lcom/urbanairship/audience/AudienceOverrides$Contact;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "stableContactIdUpdates", "Lkotlinx/coroutines/flow/Flow;", "", "overrideUpdates", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)V", "apiClient", "Lcom/urbanairship/contacts/ContactChannelsApiClient;", "clock", "Lcom/urbanairship/util/Clock;", "taskSleeper", "Lcom/urbanairship/util/TaskSleeper;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/contacts/ContactChannelsApiClient;Lcom/urbanairship/PrivacyManager;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lcom/urbanairship/util/Clock;Lcom/urbanairship/util/TaskSleeper;Lkotlinx/coroutines/CoroutineDispatcher;)V", "addressToChannelIdMap", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "isMatch", "", TCVideoEventPropertiesNames.TCV_CHANNEL, "mutation", "Lcom/urbanairship/contacts/ContactChannelMutation;", "onApplyOverrides", "data", "overrides", "onFetch", "Lkotlin/Result;", "identifier", "onFetch-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveChannelId", "channelId", "canonicalAddress", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nContactChannelsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChannelsProvider.kt\ncom/urbanairship/contacts/ContactChannelsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,214:1\n1855#2,2:215\n1855#2:217\n288#2,2:218\n1856#2:220\n*S KotlinDebug\n*F\n+ 1 ContactChannelsProvider.kt\ncom/urbanairship/contacts/ContactChannelsProvider\n*L\n74#1:215,2\n98#1:217\n101#1:218,2\n98#1:220\n*E\n"})
public final class ContactChannelsProvider extends AutoRefreshingDataProvider<List<? extends ContactChannel>, AudienceOverrides.Contact> {
    private final Map addressToChannelIdMap;
    private final ContactChannelsApiClient apiClient;
    private final ReentrantLock lock;
    private final PrivacyManager privacyManager;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ContactChannelsProvider(ContactChannelsApiClient contactChannelsApiClient, PrivacyManager privacyManager, Flow flow, Flow flow2, Clock clock, TaskSleeper taskSleeper, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        if ((i & 16) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(contactChannelsApiClient, privacyManager, flow, flow2, clock2, (i & 32) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper, (i & 64) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactChannelsProvider(@NotNull ContactChannelsApiClient apiClient, @NotNull PrivacyManager privacyManager, @NotNull Flow<String> stableContactIdUpdates, @NotNull Flow<AudienceOverrides.Contact> overrideUpdates, @NotNull Clock clock, @NotNull TaskSleeper taskSleeper, @NotNull CoroutineDispatcher dispatcher) {
        super(stableContactIdUpdates, overrideUpdates, clock, taskSleeper, dispatcher);
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(stableContactIdUpdates, "stableContactIdUpdates");
        Intrinsics.checkNotNullParameter(overrideUpdates, "overrideUpdates");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(taskSleeper, "taskSleeper");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.apiClient = apiClient;
        this.privacyManager = privacyManager;
        this.addressToChannelIdMap = new LinkedHashMap();
        this.lock = new ReentrantLock();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContactChannelsProvider(@NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull Flow<String> stableContactIdUpdates, @NotNull Flow<AudienceOverrides.Contact> overrideUpdates) {
        this(new ContactChannelsApiClient(config, null, 2, null), privacyManager, stableContactIdUpdates, overrideUpdates, null, null, null, SyslogConstants.LOG_ALERT, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(stableContactIdUpdates, "stableContactIdUpdates");
        Intrinsics.checkNotNullParameter(overrideUpdates, "overrideUpdates");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.urbanairship.util.AutoRefreshingDataProvider
    @Nullable
    /* JADX INFO: renamed from: onFetch-gIAlu-s */
    public Object mo5079onFetchgIAlus(@NotNull String str, @NotNull Continuation<? super Result<? extends List<? extends ContactChannel>>> continuation) {
        ContactChannelsProvider$onFetch$1 contactChannelsProvider$onFetch$1;
        if (continuation instanceof ContactChannelsProvider$onFetch$1) {
            contactChannelsProvider$onFetch$1 = (ContactChannelsProvider$onFetch$1) continuation;
            int i = contactChannelsProvider$onFetch$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                contactChannelsProvider$onFetch$1.label = i - Integer.MIN_VALUE;
            } else {
                contactChannelsProvider$onFetch$1 = new ContactChannelsProvider$onFetch$1(this, continuation);
            }
        } else {
            contactChannelsProvider$onFetch$1 = new ContactChannelsProvider$onFetch$1(this, continuation);
        }
        Object objFetch$urbanairship_core_release = contactChannelsProvider$onFetch$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = contactChannelsProvider$onFetch$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFetch$urbanairship_core_release);
            if (!ContactKt.isContactsEnabled(this.privacyManager)) {
                Result.Companion companion = Result.INSTANCE;
                return Result.m5277constructorimpl(ResultKt.createFailure(new IllegalStateException("Unable to fetch subscriptions when FEATURE_TAGS_AND_ATTRIBUTES or FEATURE_CONTACTS are disabled")));
            }
            ContactChannelsApiClient contactChannelsApiClient = this.apiClient;
            contactChannelsProvider$onFetch$1.label = 1;
            objFetch$urbanairship_core_release = contactChannelsApiClient.fetch$urbanairship_core_release(str, contactChannelsProvider$onFetch$1);
            if (objFetch$urbanairship_core_release == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFetch$urbanairship_core_release);
        }
        RequestResult requestResult = (RequestResult) objFetch$urbanairship_core_release;
        if (requestResult.isSuccessful() && requestResult.getValue() != null) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m5277constructorimpl(requestResult.getValue());
        }
        Result.Companion companion3 = Result.INSTANCE;
        Throwable exception = requestResult.getException();
        if (exception == null) {
            exception = new IllegalStateException("Missing response body");
        }
        return Result.m5277constructorimpl(ResultKt.createFailure(exception));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbanairship.util.AutoRefreshingDataProvider
    @NotNull
    public List<ContactChannel> onApplyOverrides(@NotNull List<? extends ContactChannel> data, @NotNull AudienceOverrides.Contact overrides) {
        Object next;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        List<ContactChannelMutation> channels = overrides.getChannels();
        if (channels == null || channels.isEmpty()) {
            return data;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (ContactChannelMutation contactChannelMutation : channels) {
                if (contactChannelMutation instanceof ContactChannelMutation.Associate) {
                    String canonicalAddress = ContactChannelsProviderKt.getCanonicalAddress(((ContactChannelMutation.Associate) contactChannelMutation).getChannel());
                    String channelId = ((ContactChannelMutation.Associate) contactChannelMutation).getChannelId();
                    if (canonicalAddress != null && channelId != null) {
                        this.addressToChannelIdMap.put(canonicalAddress, channelId);
                    }
                } else if (contactChannelMutation instanceof ContactChannelMutation.Disassociated) {
                    String canonicalAddress2 = ContactChannelsProviderKt.getCanonicalAddress(((ContactChannelMutation.Disassociated) contactChannelMutation).getChannel());
                    String channelId2 = ((ContactChannelMutation.Disassociated) contactChannelMutation).getChannelId();
                    if (canonicalAddress2 != null && channelId2 != null) {
                        this.addressToChannelIdMap.put(canonicalAddress2, channelId2);
                    }
                } else {
                    boolean z = contactChannelMutation instanceof ContactChannelMutation.AssociateAnon;
                }
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            List<ContactChannel> mutableList = CollectionsKt.toMutableList((Collection) data);
            for (final ContactChannelMutation contactChannelMutation2 : channels) {
                if (!(contactChannelMutation2 instanceof ContactChannelMutation.Associate)) {
                    if (contactChannelMutation2 instanceof ContactChannelMutation.Disassociated) {
                        CollectionsKt.removeAll((List) mutableList, new Function1() { // from class: com.urbanairship.contacts.ContactChannelsProvider$onApplyOverrides$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(ContactChannel it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return Boolean.valueOf(this.this$0.isMatch(it, contactChannelMutation2));
                            }
                        });
                    } else {
                        boolean z2 = contactChannelMutation2 instanceof ContactChannelMutation.AssociateAnon;
                    }
                } else {
                    Iterator<T> it = mutableList.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!isMatch((ContactChannel) next, contactChannelMutation2));
                    if (((ContactChannel) next) == null) {
                        mutableList.add(((ContactChannelMutation.Associate) contactChannelMutation2).getChannel());
                    }
                }
            }
            return mutableList;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMatch(ContactChannel channel, ContactChannelMutation mutation) {
        String canonicalAddress = ContactChannelsProviderKt.getCanonicalAddress(channel);
        String strResolveChannelId = resolveChannelId(ContactChannelsProviderKt.getChannelId(channel), canonicalAddress);
        String canonicalAddress2 = ContactChannelsProviderKt.getCanonicalAddress(mutation);
        String strResolveChannelId2 = resolveChannelId(ContactChannelsProviderKt.getChannelId(mutation), canonicalAddress2);
        if (strResolveChannelId == null || !Intrinsics.areEqual(strResolveChannelId, strResolveChannelId2)) {
            return canonicalAddress != null && Intrinsics.areEqual(canonicalAddress, canonicalAddress2);
        }
        return true;
    }

    private final String resolveChannelId(String channelId, String canonicalAddress) {
        if (channelId != null) {
            return channelId;
        }
        if (canonicalAddress == null) {
            return null;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return (String) this.addressToChannelIdMap.get(canonicalAddress);
        } finally {
            reentrantLock.unlock();
        }
    }
}
