package com.urbanairship.messagecenter;

import androidx.annotation.VisibleForTesting;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.config.AirshipRuntimeConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010 J \u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/urbanairship/messagecenter/InboxJobHandler;", "", TCEventPropertiesNames.TCE_USER, "Lcom/urbanairship/messagecenter/User;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "messageDao", "Lcom/urbanairship/messagecenter/MessageDao;", "(Lcom/urbanairship/messagecenter/User;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/messagecenter/MessageDao;)V", "inboxApiClient", "Lcom/urbanairship/messagecenter/InboxApiClient;", "(Lcom/urbanairship/messagecenter/User;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/messagecenter/MessageDao;Lcom/urbanairship/messagecenter/InboxApiClient;)V", "createUser", "Lcom/urbanairship/messagecenter/UserCredentials;", "channelId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreateUserCredentials", "removeStoredData", "", "removeStoredData$urbanairship_message_center_release", "syncDeletedMessageState", "", "userCredentials", "(Lcom/urbanairship/messagecenter/UserCredentials;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncMessageList", "syncReadMessageState", "updateInbox", "serverMessages", "Lcom/urbanairship/json/JsonList;", "(Lcom/urbanairship/json/JsonList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInboxJobHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InboxJobHandler.kt\ncom/urbanairship/messagecenter/InboxJobHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,252:1\n1603#2,9:253\n1855#2:262\n1856#2:264\n1612#2:265\n1549#2:266\n1620#2,3:267\n1549#2:270\n1620#2,3:271\n1603#2,9:274\n1855#2:283\n1856#2:285\n1612#2:286\n1549#2:287\n1620#2,3:288\n1549#2:291\n1620#2,3:292\n1#3:263\n1#3:284\n*S KotlinDebug\n*F\n+ 1 InboxJobHandler.kt\ncom/urbanairship/messagecenter/InboxJobHandler\n*L\n143#1:253,9\n143#1:262\n143#1:264\n143#1:265\n156#1:266\n156#1:267,3\n162#1:270\n162#1:271,3\n175#1:274,9\n175#1:283\n175#1:285\n175#1:286\n187#1:287\n187#1:288,3\n192#1:291\n192#1:292,3\n143#1:263\n175#1:284\n*E\n"})
/* loaded from: classes5.dex */
public final class InboxJobHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String LAST_MESSAGE_REFRESH_TIME = "com.urbanairship.messages.LAST_MESSAGE_REFRESH_TIME";

    @NotNull
    public static final String LAST_UPDATE_TIME = "com.urbanairship.user.LAST_UPDATE_TIME";
    private static final long USER_UPDATE_INTERVAL_MS;
    private final PreferenceDataStore dataStore;
    private final InboxApiClient inboxApiClient;
    private final MessageDao messageDao;
    private final User user;

    /* renamed from: com.urbanairship.messagecenter.InboxJobHandler$createUser$1, reason: invalid class name */
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
            return InboxJobHandler.this.createUser(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.InboxJobHandler$syncDeletedMessageState$1, reason: invalid class name and case insensitive filesystem */
    static final class C11921 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11921(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxJobHandler.this.syncDeletedMessageState(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$1, reason: invalid class name and case insensitive filesystem */
    static final class C11951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11951(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxJobHandler.this.syncMessageList(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.InboxJobHandler$syncReadMessageState$1, reason: invalid class name and case insensitive filesystem */
    static final class C11991 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11991(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxJobHandler.this.syncReadMessageState(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.InboxJobHandler$updateInbox$1, reason: invalid class name and case insensitive filesystem */
    static final class C12021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C12021(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxJobHandler.this.updateInbox(null, this);
        }
    }

    /* renamed from: com.urbanairship.messagecenter.InboxJobHandler$updateUser$1, reason: invalid class name and case insensitive filesystem */
    static final class C12081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C12081(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxJobHandler.this.updateUser(null, null, this);
        }
    }

    @VisibleForTesting
    public InboxJobHandler(@NotNull User user, @NotNull PreferenceDataStore dataStore, @NotNull MessageDao messageDao, @NotNull InboxApiClient inboxApiClient) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(messageDao, "messageDao");
        Intrinsics.checkNotNullParameter(inboxApiClient, "inboxApiClient");
        this.user = user;
        this.dataStore = dataStore;
        this.messageDao = messageDao;
        this.inboxApiClient = inboxApiClient;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InboxJobHandler(@NotNull User user, @NotNull AirshipRuntimeConfig runtimeConfig, @NotNull PreferenceDataStore dataStore, @NotNull MessageDao messageDao) {
        this(user, dataStore, messageDao, new InboxApiClient(runtimeConfig, null, 2, 0 == true ? 1 : 0));
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(messageDao, "messageDao");
    }

    public final void removeStoredData$urbanairship_message_center_release() {
        this.dataStore.remove(LAST_MESSAGE_REFRESH_TIME);
        this.dataStore.remove(LAST_UPDATE_TIME);
    }

    @Nullable
    public final Object getOrCreateUserCredentials(@NotNull String str, @NotNull Continuation<? super UserCredentials> continuation) {
        long j = this.dataStore.getLong(LAST_UPDATE_TIME, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        UserCredentials userCredentials$urbanairship_message_center_release = this.user.getUserCredentials$urbanairship_message_center_release();
        if (userCredentials$urbanairship_message_center_release == null) {
            return createUser(str, continuation);
        }
        return (!Intrinsics.areEqual(this.user.getRegisteredChannelId$urbanairship_message_center_release(), str) || j > jCurrentTimeMillis || j + USER_UPDATE_INTERVAL_MS > jCurrentTimeMillis) ? updateUser(userCredentials$urbanairship_message_center_release, str, continuation) : userCredentials$urbanairship_message_center_release;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncMessageList(@org.jetbrains.annotations.NotNull com.urbanairship.messagecenter.UserCredentials r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.urbanairship.messagecenter.InboxJobHandler.C11951
            if (r0 == 0) goto L13
            r0 = r11
            com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$1 r0 = (com.urbanairship.messagecenter.InboxJobHandler.C11951) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$1 r0 = new com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "com.urbanairship.messages.LAST_MESSAGE_REFRESH_TIME"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3f
            if (r2 != r4) goto L37
            java.lang.Object r8 = r0.L$1
            com.urbanairship.http.RequestResult r8 = (com.urbanairship.http.RequestResult) r8
            java.lang.Object r9 = r0.L$0
            com.urbanairship.messagecenter.InboxJobHandler r9 = (com.urbanairship.messagecenter.InboxJobHandler) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L93
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            java.lang.Object r8 = r0.L$0
            com.urbanairship.messagecenter.InboxJobHandler r8 = (com.urbanairship.messagecenter.InboxJobHandler) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L62
        L47:
            kotlin.ResultKt.throwOnFailure(r11)
            com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$2 r11 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.InboxJobHandler.syncMessageList.2
                static {
                    /*
                        com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$2 r0 = new com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$2) com.urbanairship.messagecenter.InboxJobHandler.syncMessageList.2.INSTANCE com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C11962.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C11962.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C11962.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Refreshing inbox messages."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C11962.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.i$default(r6, r11, r5, r6)
            com.urbanairship.messagecenter.InboxApiClient r11 = r8.inboxApiClient
            com.urbanairship.PreferenceDataStore r2 = r8.dataStore
            java.lang.String r2 = r2.getString(r3, r6)
            r0.L$0 = r8
            r0.label = r5
            java.lang.Object r11 = r11.fetchMessages(r9, r10, r2, r0)
            if (r11 != r1) goto L62
            return r1
        L62:
            r9 = r11
            com.urbanairship.http.RequestResult r9 = (com.urbanairship.http.RequestResult) r9
            com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$3 r10 = new com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$3
            r10.<init>()
            com.urbanairship.UALog.v$default(r6, r10, r5, r6)
            java.lang.Object r10 = r9.getValue()
            com.urbanairship.json.JsonList r10 = (com.urbanairship.json.JsonList) r10
            boolean r11 = r9.isSuccessful()
            if (r11 == 0) goto Lac
            if (r10 == 0) goto Lac
            com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$4 r11 = new com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$4
            r11.<init>()
            com.urbanairship.UALog.i$default(r6, r11, r5, r6)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r8.updateInbox(r10, r0)
            if (r10 != r1) goto L90
            return r1
        L90:
            r7 = r9
            r9 = r8
            r8 = r7
        L93:
            com.urbanairship.PreferenceDataStore r9 = r9.dataStore
            java.util.Map r8 = r8.getHeaders()
            if (r8 == 0) goto La4
            java.lang.String r10 = "Last-Modified"
            java.lang.Object r8 = r8.get(r10)
            r6 = r8
            java.lang.String r6 = (java.lang.String) r6
        La4:
            r9.put(r3, r6)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r8
        Lac:
            java.lang.Integer r8 = r9.getStatus()
            if (r8 != 0) goto Lb3
            goto Lc5
        Lb3:
            int r8 = r8.intValue()
            r10 = 304(0x130, float:4.26E-43)
            if (r8 != r10) goto Lc5
            com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$5 r8 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.InboxJobHandler.syncMessageList.5
                static {
                    /*
                        com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$5 r0 = new com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$5
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$5) com.urbanairship.messagecenter.InboxJobHandler.syncMessageList.5.INSTANCE com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$5
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C11985.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C11985.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C11985.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Inbox messages already up-to-date."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C11985.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.d$default(r6, r8, r5, r6)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r8
        Lc5:
            com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$6 r8 = new com.urbanairship.messagecenter.InboxJobHandler$syncMessageList$6
            r8.<init>()
            com.urbanairship.UALog.d$default(r6, r8, r5, r6)
            r8 = 0
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.syncMessageList(com.urbanairship.messagecenter.UserCredentials, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0113 A[Catch: JsonException -> 0x004e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {JsonException -> 0x004e, blocks: (B:17:0x0049, B:47:0x0113), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0147 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.urbanairship.messagecenter.InboxJobHandler] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.lang.Object, java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.urbanairship.json.JsonList] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2, types: [com.urbanairship.messagecenter.InboxJobHandler, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [com.urbanairship.messagecenter.InboxJobHandler, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f1 -> B:41:0x00f9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateInbox(com.urbanairship.json.JsonList r14, kotlin.coroutines.Continuation r15) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.updateInbox(com.urbanairship.json.JsonList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010a A[LOOP:0: B:46:0x0104->B:48:0x010a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncDeletedMessageState(@org.jetbrains.annotations.NotNull com.urbanairship.messagecenter.UserCredentials r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.syncDeletedMessageState(com.urbanairship.messagecenter.UserCredentials, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0112 A[LOOP:0: B:48:0x010c->B:50:0x0112, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0132 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncReadMessageState(@org.jetbrains.annotations.NotNull com.urbanairship.messagecenter.UserCredentials r12, @org.jetbrains.annotations.NotNull java.lang.String r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.syncReadMessageState(com.urbanairship.messagecenter.UserCredentials, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createUser(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.messagecenter.InboxJobHandler.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.messagecenter.InboxJobHandler$createUser$1 r0 = (com.urbanairship.messagecenter.InboxJobHandler.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.InboxJobHandler$createUser$1 r0 = new com.urbanairship.messagecenter.InboxJobHandler$createUser$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r0.L$0
            com.urbanairship.messagecenter.InboxJobHandler r4 = (com.urbanairship.messagecenter.InboxJobHandler) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4c
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.messagecenter.InboxApiClient r6 = r4.inboxApiClient
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.createUser(r5, r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            com.urbanairship.http.RequestResult r6 = (com.urbanairship.http.RequestResult) r6
            java.lang.Object r0 = r6.getValue()
            com.urbanairship.messagecenter.UserCredentials r0 = (com.urbanairship.messagecenter.UserCredentials) r0
            boolean r1 = r6.isSuccessful()
            r2 = 0
            if (r1 == 0) goto L7d
            if (r0 == 0) goto L7d
            com.urbanairship.messagecenter.InboxJobHandler$createUser$2 r6 = new com.urbanairship.messagecenter.InboxJobHandler$createUser$2
            r6.<init>()
            com.urbanairship.UALog.i$default(r2, r6, r3, r2)
            com.urbanairship.PreferenceDataStore r6 = r4.dataStore
            java.lang.String r1 = "com.urbanairship.user.LAST_UPDATE_TIME"
            long r2 = java.lang.System.currentTimeMillis()
            r6.put(r1, r2)
            com.urbanairship.PreferenceDataStore r6 = r4.dataStore
            java.lang.String r1 = "com.urbanairship.messages.LAST_MESSAGE_REFRESH_TIME"
            r6.remove(r1)
            com.urbanairship.messagecenter.User r4 = r4.user
            r4.onCreated$urbanairship_message_center_release(r0, r5)
            goto L86
        L7d:
            com.urbanairship.messagecenter.InboxJobHandler$createUser$3 r4 = new com.urbanairship.messagecenter.InboxJobHandler$createUser$3
            r4.<init>()
            com.urbanairship.UALog.d$default(r2, r4, r3, r2)
            r0 = r2
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.createUser(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateUser(com.urbanairship.messagecenter.UserCredentials r9, java.lang.String r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.urbanairship.messagecenter.InboxJobHandler.C12081
            if (r0 == 0) goto L13
            r0 = r11
            com.urbanairship.messagecenter.InboxJobHandler$updateUser$1 r0 = (com.urbanairship.messagecenter.InboxJobHandler.C12081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.messagecenter.InboxJobHandler$updateUser$1 r0 = new com.urbanairship.messagecenter.InboxJobHandler$updateUser$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lb0
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            java.lang.Object r8 = r0.L$2
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r8 = r0.L$1
            r9 = r8
            com.urbanairship.messagecenter.UserCredentials r9 = (com.urbanairship.messagecenter.UserCredentials) r9
            java.lang.Object r8 = r0.L$0
            com.urbanairship.messagecenter.InboxJobHandler r8 = (com.urbanairship.messagecenter.InboxJobHandler) r8
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5b
        L47:
            kotlin.ResultKt.throwOnFailure(r11)
            com.urbanairship.messagecenter.InboxApiClient r11 = r8.inboxApiClient
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r11 = r11.updateUser(r9, r10, r0)
            if (r11 != r1) goto L5b
            return r1
        L5b:
            com.urbanairship.http.RequestResult r11 = (com.urbanairship.http.RequestResult) r11
            com.urbanairship.messagecenter.InboxJobHandler$updateUser$2 r2 = new com.urbanairship.messagecenter.InboxJobHandler$updateUser$2
            r2.<init>()
            r5 = 0
            com.urbanairship.UALog.v$default(r5, r2, r4, r5)
            java.lang.Integer r11 = r11.getStatus()
            java.lang.String r2 = "com.urbanairship.user.LAST_UPDATE_TIME"
            if (r11 != 0) goto L6f
            goto L8b
        L6f:
            int r6 = r11.intValue()
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L8b
            com.urbanairship.messagecenter.InboxJobHandler$updateUser$3 r11 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.InboxJobHandler.updateUser.3
                static {
                    /*
                        com.urbanairship.messagecenter.InboxJobHandler$updateUser$3 r0 = new com.urbanairship.messagecenter.InboxJobHandler$updateUser$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.InboxJobHandler$updateUser$3) com.urbanairship.messagecenter.InboxJobHandler.updateUser.3.INSTANCE com.urbanairship.messagecenter.InboxJobHandler$updateUser$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C12103.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C12103.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C12103.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Rich Push user updated."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C12103.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.i$default(r5, r11, r4, r5)
            com.urbanairship.PreferenceDataStore r11 = r8.dataStore
            long r0 = java.lang.System.currentTimeMillis()
            r11.put(r2, r0)
            com.urbanairship.messagecenter.User r8 = r8.user
            r8.onUpdated$urbanairship_message_center_release(r10)
            goto Lb7
        L8b:
            r9 = 0
            if (r11 != 0) goto L8f
            goto Lb1
        L8f:
            int r11 = r11.intValue()
            r6 = 401(0x191, float:5.62E-43)
            if (r11 != r6) goto Lb1
            com.urbanairship.messagecenter.InboxJobHandler$updateUser$4 r11 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.messagecenter.InboxJobHandler.updateUser.4
                static {
                    /*
                        com.urbanairship.messagecenter.InboxJobHandler$updateUser$4 r0 = new com.urbanairship.messagecenter.InboxJobHandler$updateUser$4
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.messagecenter.InboxJobHandler$updateUser$4) com.urbanairship.messagecenter.InboxJobHandler.updateUser.4.INSTANCE com.urbanairship.messagecenter.InboxJobHandler$updateUser$4
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C12114.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C12114.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C12114.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Re-creating Rich Push user."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.C12114.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.d$default(r5, r11, r4, r5)
            com.urbanairship.PreferenceDataStore r11 = r8.dataStore
            r11.put(r2, r9)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r11 = r8.createUser(r10, r0)
            if (r11 != r1) goto Lb0
            return r1
        Lb0:
            return r11
        Lb1:
            com.urbanairship.PreferenceDataStore r8 = r8.dataStore
            r8.put(r2, r9)
            r9 = r5
        Lb7:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxJobHandler.updateUser(com.urbanairship.messagecenter.UserCredentials, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/messagecenter/InboxJobHandler$Companion;", "", "()V", "LAST_MESSAGE_REFRESH_TIME", "", "getLAST_MESSAGE_REFRESH_TIME$urbanairship_message_center_release$annotations", "LAST_UPDATE_TIME", "USER_UPDATE_INTERVAL_MS", "", "getUSER_UPDATE_INTERVAL_MS$urbanairship_message_center_release", "()J", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getLAST_MESSAGE_REFRESH_TIME$urbanairship_message_center_release$annotations() {
        }

        private Companion() {
        }

        public final long getUSER_UPDATE_INTERVAL_MS$urbanairship_message_center_release() {
            return InboxJobHandler.USER_UPDATE_INTERVAL_MS;
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        USER_UPDATE_INTERVAL_MS = Duration.m3485getInWholeMillisecondsimpl(DurationKt.toDuration(24, DurationUnit.HOURS));
    }
}
