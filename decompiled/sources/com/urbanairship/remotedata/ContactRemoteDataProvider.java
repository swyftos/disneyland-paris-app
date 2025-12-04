package com.urbanairship.remotedata;

import android.content.Context;
import android.net.Uri;
import com.facebook.hermes.intl.Constants;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.contacts.Contact;
import com.urbanairship.contacts.ContactIdUpdate;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/urbanairship/remotedata/ContactRemoteDataProvider;", "Lcom/urbanairship/remotedata/RemoteDataProvider;", "context", "Landroid/content/Context;", "preferenceDataStore", "Lcom/urbanairship/PreferenceDataStore;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "contact", "Lcom/urbanairship/contacts/Contact;", "apiClient", "Lcom/urbanairship/remotedata/RemoteDataApiClient;", "urlFactory", "Lcom/urbanairship/remotedata/RemoteDataUrlFactory;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/contacts/Contact;Lcom/urbanairship/remotedata/RemoteDataApiClient;Lcom/urbanairship/remotedata/RemoteDataUrlFactory;)V", "createUrl", "Landroid/net/Uri;", "contactId", "", Constants.LOCALE, "Ljava/util/Locale;", "randomValue", "", "fetchRemoteData", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/remotedata/RemoteDataApiClient$Result;", "lastRemoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "(Ljava/util/Locale;ILcom/urbanairship/remotedata/RemoteDataInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRemoteDataInfoUpToDate", "", "remoteDataInfo", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactRemoteDataProvider extends RemoteDataProvider {
    private final RemoteDataApiClient apiClient;
    private final Contact contact;
    private final RemoteDataUrlFactory urlFactory;

    /* renamed from: com.urbanairship.remotedata.ContactRemoteDataProvider$fetchRemoteData$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactRemoteDataProvider.this.fetchRemoteData(null, 0, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactRemoteDataProvider(@NotNull Context context, @NotNull PreferenceDataStore preferenceDataStore, @NotNull AirshipRuntimeConfig config, @NotNull Contact contact, @NotNull RemoteDataApiClient apiClient, @NotNull RemoteDataUrlFactory urlFactory) {
        super(RemoteDataSource.CONTACT, new RemoteDataStore(context, config.getConfigOptions().appKey, "ua_remotedata_contact.db"), preferenceDataStore, false, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        Intrinsics.checkNotNullParameter(urlFactory, "urlFactory");
        this.contact = contact;
        this.apiClient = apiClient;
        this.urlFactory = urlFactory;
    }

    @Override // com.urbanairship.remotedata.RemoteDataProvider
    public boolean isRemoteDataInfoUpToDate(@NotNull RemoteDataInfo remoteDataInfo, @NotNull Locale locale, int randomValue) {
        ContactIdUpdate currentContactIdUpdate$urbanairship_core_release;
        Uri uriCreateUrl;
        Intrinsics.checkNotNullParameter(remoteDataInfo, "remoteDataInfo");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (remoteDataInfo.getSource() == RemoteDataSource.CONTACT && (currentContactIdUpdate$urbanairship_core_release = this.contact.getCurrentContactIdUpdate$urbanairship_core_release()) != null && currentContactIdUpdate$urbanairship_core_release.isStable() && Intrinsics.areEqual(currentContactIdUpdate$urbanairship_core_release.getContactId(), remoteDataInfo.getContactId()) && (uriCreateUrl = createUrl(currentContactIdUpdate$urbanairship_core_release.getContactId(), locale, randomValue)) != null) {
            return Intrinsics.areEqual(uriCreateUrl.toString(), remoteDataInfo.getUrl());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.urbanairship.remotedata.RemoteDataProvider
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fetchRemoteData(@org.jetbrains.annotations.NotNull java.util.Locale r8, int r9, @org.jetbrains.annotations.Nullable com.urbanairship.remotedata.RemoteDataInfo r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.http.RequestResult<com.urbanairship.remotedata.RemoteDataApiClient.Result>> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.urbanairship.remotedata.ContactRemoteDataProvider.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.urbanairship.remotedata.ContactRemoteDataProvider$fetchRemoteData$1 r0 = (com.urbanairship.remotedata.ContactRemoteDataProvider.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.urbanairship.remotedata.ContactRemoteDataProvider$fetchRemoteData$1 r0 = new com.urbanairship.remotedata.ContactRemoteDataProvider$fetchRemoteData$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L4b
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.throwOnFailure(r11)
            goto La1
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            int r9 = r6.I$0
            java.lang.Object r7 = r6.L$2
            r10 = r7
            com.urbanairship.remotedata.RemoteDataInfo r10 = (com.urbanairship.remotedata.RemoteDataInfo) r10
            java.lang.Object r7 = r6.L$1
            r8 = r7
            java.util.Locale r8 = (java.util.Locale) r8
            java.lang.Object r7 = r6.L$0
            com.urbanairship.remotedata.ContactRemoteDataProvider r7 = (com.urbanairship.remotedata.ContactRemoteDataProvider) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto L61
        L4b:
            kotlin.ResultKt.throwOnFailure(r11)
            com.urbanairship.contacts.Contact r11 = r7.contact
            r6.L$0 = r7
            r6.L$1 = r8
            r6.L$2 = r10
            r6.I$0 = r9
            r6.label = r3
            java.lang.Object r11 = r11.stableContactInfo$urbanairship_core_release(r6)
            if (r11 != r0) goto L61
            return r0
        L61:
            com.urbanairship.contacts.StableContactInfo r11 = (com.urbanairship.contacts.StableContactInfo) r11
            java.lang.String r11 = r11.getContactId()
            android.net.Uri r8 = r7.createUrl(r11, r8, r9)
            r9 = 0
            if (r10 == 0) goto L73
            java.lang.String r1 = r10.getUrl()
            goto L74
        L73:
            r1 = r9
        L74:
            java.lang.String r3 = java.lang.String.valueOf(r8)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L84
            java.lang.String r10 = r10.getLastModified()
            r4 = r10
            goto L85
        L84:
            r4 = r9
        L85:
            com.urbanairship.remotedata.RemoteDataApiClient r1 = r7.apiClient
            com.urbanairship.http.RequestAuth$ContactTokenAuth r3 = new com.urbanairship.http.RequestAuth$ContactTokenAuth
            r3.<init>(r11)
            com.urbanairship.remotedata.ContactRemoteDataProvider$fetchRemoteData$2 r5 = new com.urbanairship.remotedata.ContactRemoteDataProvider$fetchRemoteData$2
            r5.<init>()
            r6.L$0 = r9
            r6.L$1 = r9
            r6.L$2 = r9
            r6.label = r2
            r2 = r8
            java.lang.Object r11 = r1.fetch$urbanairship_core_release(r2, r3, r4, r5, r6)
            if (r11 != r0) goto La1
            return r0
        La1:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.ContactRemoteDataProvider.fetchRemoteData(java.util.Locale, int, com.urbanairship.remotedata.RemoteDataInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Uri createUrl(String contactId, Locale locale, int randomValue) {
        return this.urlFactory.createContactUrl(contactId, locale, randomValue);
    }
}
