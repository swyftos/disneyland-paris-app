package com.urbanairship.contacts;

import com.allegion.accesssdk.BuildConfig;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0080@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/contacts/ContactChannelsApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "fetch", "Lcom/urbanairship/http/RequestResult;", "", "Lcom/urbanairship/contacts/ContactChannel;", "contactId", "", "fetch$urbanairship_core_release", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseChannels", "responseBody", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContactChannelsApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChannelsApiClient.kt\ncom/urbanairship/contacts/ContactChannelsApiClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1549#2:112\n1620#2,3:113\n1603#2,9:116\n1855#2:125\n1856#2:232\n1612#2:233\n44#3,15:126\n44#3,15:141\n44#3,15:156\n44#3,15:171\n44#3,15:186\n44#3,15:201\n44#3,15:216\n1#4:231\n*S KotlinDebug\n*F\n+ 1 ContactChannelsApiClient.kt\ncom/urbanairship/contacts/ContactChannelsApiClient\n*L\n55#1:112\n55#1:113,3\n56#1:116,9\n56#1:125\n56#1:232\n56#1:233\n57#1:126,15\n61#1:141,15\n62#1:156,15\n73#1:171,15\n74#1:186,15\n75#1:201,15\n76#1:216,15\n56#1:231\n*E\n"})
/* loaded from: classes5.dex */
public final class ContactChannelsApiClient {
    private static final Companion Companion = new Companion(null);
    private final AirshipRuntimeConfig runtimeConfig;
    private final SuspendingRequestSession session;

    public ContactChannelsApiClient(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(session, "session");
        this.runtimeConfig = runtimeConfig;
        this.session = session;
    }

    public /* synthetic */ ContactChannelsApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetch$urbanairship_core_release(@org.jetbrains.annotations.NotNull final java.lang.String r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.http.RequestResult<java.util.List<com.urbanairship.contacts.ContactChannel>>> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.urbanairship.contacts.ContactChannelsApiClient$fetch$1
            if (r0 == 0) goto L13
            r0 = r15
            com.urbanairship.contacts.ContactChannelsApiClient$fetch$1 r0 = (com.urbanairship.contacts.ContactChannelsApiClient$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.contacts.ContactChannelsApiClient$fetch$1 r0 = new com.urbanairship.contacts.ContactChannelsApiClient$fetch$1
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r13 = r0.L$0
            r14 = r13
            java.lang.String r14 = (java.lang.String) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L91
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            kotlin.ResultKt.throwOnFailure(r15)
            com.urbanairship.config.AirshipRuntimeConfig r15 = r13.runtimeConfig
            com.urbanairship.config.UrlBuilder r15 = r15.getDeviceUrl()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "api/contacts/associated_types/"
            r2.append(r4)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            com.urbanairship.config.UrlBuilder r15 = r15.appendEncodedPath(r2)
            android.net.Uri r5 = r15.build()
            java.lang.String r15 = "Accept"
            java.lang.String r2 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r2)
            java.util.Map r9 = kotlin.collections.MapsKt.mapOf(r15)
            com.urbanairship.http.Request r15 = new com.urbanairship.http.Request
            com.urbanairship.http.RequestAuth$ContactTokenAuth r7 = new com.urbanairship.http.RequestAuth$ContactTokenAuth
            r7.<init>(r14)
            r11 = 40
            r12 = 0
            java.lang.String r6 = "GET"
            r8 = 0
            r10 = 0
            r4 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            com.urbanairship.contacts.ContactChannelsApiClient$fetch$2 r2 = new com.urbanairship.contacts.ContactChannelsApiClient$fetch$2
            r2.<init>()
            r4 = 0
            com.urbanairship.UALog.d$default(r4, r2, r3, r4)
            com.urbanairship.http.SuspendingRequestSession r2 = r13.session
            com.urbanairship.contacts.ContactChannelsApiClient$$ExternalSyntheticLambda0 r4 = new com.urbanairship.contacts.ContactChannelsApiClient$$ExternalSyntheticLambda0
            r4.<init>()
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r15 = r2.execute(r15, r4, r0)
            if (r15 != r1) goto L91
            return r1
        L91:
            r13 = r15
            com.urbanairship.http.RequestResult r13 = (com.urbanairship.http.RequestResult) r13
            com.urbanairship.contacts.ContactChannelsApiClient$fetch$4$1 r0 = new com.urbanairship.contacts.ContactChannelsApiClient$fetch$4$1
            r0.<init>()
            com.urbanairship.http.SuspendingRequestSessionKt.log(r13, r0)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactChannelsApiClient.fetch$urbanairship_core_release(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List fetch$lambda$0(ContactChannelsApiClient this$0, int i, Map map, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (UAHttpStatusUtil.inSuccessRange(i)) {
            return this$0.parseChannels(str);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x062f  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x08b5  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0b2c  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0482 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0aab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0a61 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0a17 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:509:0x0b2f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ac  */
    /* JADX WARN: Type inference failed for: r3v73, types: [com.urbanairship.contacts.ContactChannel$Email] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List parseChannels(java.lang.String r31) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 2939
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactChannelsApiClient.parseChannels(java.lang.String):java.util.List");
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
