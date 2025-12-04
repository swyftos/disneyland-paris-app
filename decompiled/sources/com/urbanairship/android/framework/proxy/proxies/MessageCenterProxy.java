package com.urbanairship.android.framework.proxy.proxies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UAirship;
import com.urbanairship.android.framework.proxy.ProxyLogger;
import com.urbanairship.android.framework.proxy.ProxyStore;
import com.urbanairship.messagecenter.MessageCenter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u001aJ\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\nJ\u0010\u0010#\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/MessageCenterProxy;", "", "proxyStore", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "messageCenterProvider", "Lkotlin/Function0;", "Lcom/urbanairship/messagecenter/MessageCenter;", "(Lcom/urbanairship/android/framework/proxy/ProxyStore;Lkotlin/jvm/functions/Function0;)V", "_displayState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "displayState", "Lkotlinx/coroutines/flow/StateFlow;", "getDisplayState$airship_framework_proxy_release", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteMessage", "", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "dismiss", "display", "getMessage", "Lcom/urbanairship/android/framework/proxy/MessageCenterMessage;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUnreadMessagesCount", "", "launchMessageCenterIntent", "intentAction", "markMessageRead", "refreshInbox", "setAutoLaunchDefaultMessageCenter", "enabled", "showMessageCenter", "showMessageView", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageCenterProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageCenterProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/MessageCenterProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n1549#2:103\n1620#2,3:104\n*S KotlinDebug\n*F\n+ 1 MessageCenterProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/MessageCenterProxy\n*L\n71#1:103\n71#1:104,3\n*E\n"})
/* loaded from: classes2.dex */
public final class MessageCenterProxy {
    private final MutableStateFlow _displayState;
    private final StateFlow displayState;
    private final Function0 messageCenterProvider;
    private final ProxyStore proxyStore;

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$getMessage$1, reason: invalid class name and case insensitive filesystem */
    static final class C09161 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09161(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageCenterProxy.this.getMessage(null, this);
        }
    }

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$getMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C09171 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09171(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageCenterProxy.this.getMessages(this);
        }
    }

    public MessageCenterProxy(@NotNull ProxyStore proxyStore, @NotNull Function0<MessageCenter> messageCenterProvider) {
        Intrinsics.checkNotNullParameter(proxyStore, "proxyStore");
        Intrinsics.checkNotNullParameter(messageCenterProvider, "messageCenterProvider");
        this.proxyStore = proxyStore;
        this.messageCenterProvider = messageCenterProvider;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this._displayState = MutableStateFlow;
        this.displayState = MutableStateFlow;
    }

    @NotNull
    public final StateFlow<Boolean> getDisplayState$airship_framework_proxy_release() {
        return this.displayState;
    }

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$display$1, reason: invalid class name and case insensitive filesystem */
    static final class C09151 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $messageId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09151(String str, Continuation continuation) {
            super(2, continuation);
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageCenterProxy.this.new C09151(this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = MessageCenterProxy.this._displayState;
                Boolean boolBoxBoolean = Boxing.boxBoolean(true);
                this.label = 1;
                if (mutableStateFlow.emit(boolBoxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (this.$messageId != null) {
                ((MessageCenter) MessageCenterProxy.this.messageCenterProvider.invoke()).showMessageCenter(this.$messageId);
            } else {
                MessageCenter.showMessageCenter$default((MessageCenter) MessageCenterProxy.this.messageCenterProvider.invoke(), null, 1, null);
            }
            return Unit.INSTANCE;
        }
    }

    public final void display(@Nullable String messageId) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new C09151(messageId, null), 3, null);
    }

    public final void showMessageView(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        launchMessageCenterIntent(MessageCenter.VIEW_MESSAGE_INTENT_ACTION, messageId);
    }

    public final void showMessageCenter(@Nullable String messageId) {
        launchMessageCenterIntent(MessageCenter.VIEW_MESSAGE_CENTER_INTENT_ACTION, messageId);
    }

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$launchMessageCenterIntent$1, reason: invalid class name and case insensitive filesystem */
    static final class C09181 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $intentAction;
        final /* synthetic */ String $messageId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09181(String str, String str2, Continuation continuation) {
            super(2, continuation);
            this.$intentAction = str;
            this.$messageId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageCenterProxy.this.new C09181(this.$intentAction, this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = MessageCenterProxy.this._displayState;
                Boolean boolBoxBoolean = Boxing.boxBoolean(true);
                this.label = 1;
                if (mutableStateFlow.emit(boolBoxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MessageCenterProxy.this.messageCenterProvider.invoke();
            Context applicationContext = UAirship.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            Intent intentAddFlags = new Intent(this.$intentAction).setPackage(UAirship.getApplicationContext().getPackageName()).addFlags(805306368);
            Intrinsics.checkNotNullExpressionValue(intentAddFlags, "addFlags(...)");
            String str = this.$messageId;
            if (str != null) {
                intentAddFlags.setData(Uri.fromParts("message", str, null));
            }
            try {
                applicationContext.startActivity(intentAddFlags);
            } catch (Exception e) {
                ProxyLogger.error(e);
            }
            return Unit.INSTANCE;
        }
    }

    private final void launchMessageCenterIntent(String intentAction, String messageId) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new C09181(intentAction, messageId, null), 3, null);
    }

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$dismiss$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MessageCenterProxy.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = MessageCenterProxy.this._displayState;
                Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                this.label = 1;
                if (mutableStateFlow.emit(boolBoxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void dismiss() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMessages(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.android.framework.proxy.MessageCenterMessage>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy.C09171
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$getMessages$1 r0 = (com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy.C09171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$getMessages$1 r0 = new com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$getMessages$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4a
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.functions.Function0 r4 = r4.messageCenterProvider
            java.lang.Object r4 = r4.invoke()
            com.urbanairship.messagecenter.MessageCenter r4 = (com.urbanairship.messagecenter.MessageCenter) r4
            com.urbanairship.messagecenter.Inbox r4 = r4.getInbox()
            r0.label = r3
            r5 = 0
            java.lang.Object r5 = com.urbanairship.messagecenter.Inbox.getMessages$default(r4, r5, r0, r3, r5)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r4 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r0)
            r4.<init>(r0)
            java.util.Iterator r5 = r5.iterator()
        L5b:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L70
            java.lang.Object r0 = r5.next()
            com.urbanairship.messagecenter.Message r0 = (com.urbanairship.messagecenter.Message) r0
            com.urbanairship.android.framework.proxy.MessageCenterMessage r1 = new com.urbanairship.android.framework.proxy.MessageCenterMessage
            r1.<init>(r0)
            r4.add(r1)
            goto L5b
        L70:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy.getMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMessage(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.android.framework.proxy.MessageCenterMessage> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy.C09161
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$getMessage$1 r0 = (com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy.C09161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$getMessage$1 r0 = new com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy$getMessage$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function0 r4 = r4.messageCenterProvider
            java.lang.Object r4 = r4.invoke()
            com.urbanairship.messagecenter.MessageCenter r4 = (com.urbanairship.messagecenter.MessageCenter) r4
            com.urbanairship.messagecenter.Inbox r4 = r4.getInbox()
            r0.label = r3
            java.lang.Object r6 = r4.getMessage(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            if (r6 == 0) goto L53
            com.urbanairship.messagecenter.Message r6 = (com.urbanairship.messagecenter.Message) r6
            com.urbanairship.android.framework.proxy.MessageCenterMessage r4 = new com.urbanairship.android.framework.proxy.MessageCenterMessage
            r4.<init>(r6)
            return r4
        L53:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Required value was null."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy.getMessage(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void deleteMessage(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        ((MessageCenter) this.messageCenterProvider.invoke()).getInbox().deleteMessages(messageId);
    }

    public final void markMessageRead(@NotNull String messageId) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        ((MessageCenter) this.messageCenterProvider.invoke()).getInbox().markMessagesRead(messageId);
    }

    @Nullable
    public final Object refreshInbox(@NotNull Continuation<? super Boolean> continuation) {
        return ((MessageCenter) this.messageCenterProvider.invoke()).getInbox().fetchMessages(continuation);
    }

    @Nullable
    public final Object getUnreadMessagesCount(@NotNull Continuation<? super Integer> continuation) {
        return ((MessageCenter) this.messageCenterProvider.invoke()).getInbox().getUnreadCount(continuation);
    }

    public final void setAutoLaunchDefaultMessageCenter(boolean enabled) {
        this.proxyStore.setAutoLaunchMessageCenterEnabled(enabled);
    }
}
