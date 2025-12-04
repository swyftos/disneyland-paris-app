package com.urbanairship.inputvalidation;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.http.RequestResult;
import com.urbanairship.inputvalidation.CachingSmsValidatorApiClient;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J6\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/inputvalidation/CachingSmsValidatorApiClient;", "Lcom/urbanairship/inputvalidation/SmsValidatorApiInterface;", "client", "maxCacheEntries", "", "(Lcom/urbanairship/inputvalidation/SmsValidatorApiInterface;I)V", "_cache", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/urbanairship/inputvalidation/CachingSmsValidatorApiClient$Entry;", "cacheResult", "", "result", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result;", "msisdn", "", "prefix", "sender", "cachedResultWithPrefix", "cachedResultWithSender", "validateSmsWithPrefix", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateSmsWithSender", "Entry", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCachingSmsValidatorApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CachingSmsValidatorApiClient.kt\ncom/urbanairship/inputvalidation/CachingSmsValidatorApiClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,85:1\n1#2:86\n288#3,2:87\n288#3,2:89\n230#4,5:91\n*S KotlinDebug\n*F\n+ 1 CachingSmsValidatorApiClient.kt\ncom/urbanairship/inputvalidation/CachingSmsValidatorApiClient\n*L\n42#1:87,2\n49#1:89,2\n64#1:91,5\n*E\n"})
/* loaded from: classes5.dex */
public final class CachingSmsValidatorApiClient implements SmsValidatorApiInterface {
    private final MutableStateFlow _cache;
    private final SmsValidatorApiInterface client;
    private final int maxCacheEntries;

    /* renamed from: com.urbanairship.inputvalidation.CachingSmsValidatorApiClient$validateSmsWithPrefix$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return CachingSmsValidatorApiClient.this.validateSmsWithPrefix(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.inputvalidation.CachingSmsValidatorApiClient$validateSmsWithSender$1, reason: invalid class name and case insensitive filesystem */
    static final class C11491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11491(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingSmsValidatorApiClient.this.validateSmsWithSender(null, null, this);
        }
    }

    public CachingSmsValidatorApiClient(@NotNull SmsValidatorApiInterface client, int i) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
        this.maxCacheEntries = i;
        this._cache = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    }

    public /* synthetic */ CachingSmsValidatorApiClient(SmsValidatorApiInterface smsValidatorApiInterface, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(smsValidatorApiInterface, (i2 & 2) != 0 ? 10 : i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.inputvalidation.SmsValidatorApiInterface
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object validateSmsWithPrefix(@org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.http.RequestResult<com.urbanairship.inputvalidation.SmsValidatorApiClient.Result>> r12) throws java.security.InvalidParameterException {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.urbanairship.inputvalidation.CachingSmsValidatorApiClient.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            com.urbanairship.inputvalidation.CachingSmsValidatorApiClient$validateSmsWithPrefix$1 r0 = (com.urbanairship.inputvalidation.CachingSmsValidatorApiClient.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.inputvalidation.CachingSmsValidatorApiClient$validateSmsWithPrefix$1 r0 = new com.urbanairship.inputvalidation.CachingSmsValidatorApiClient$validateSmsWithPrefix$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r9 = r0.L$2
            r11 = r9
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r9 = r0.L$1
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r0.L$0
            com.urbanairship.inputvalidation.CachingSmsValidatorApiClient r9 = (com.urbanairship.inputvalidation.CachingSmsValidatorApiClient) r9
            kotlin.ResultKt.throwOnFailure(r12)
        L36:
            r2 = r9
            r4 = r10
            r5 = r11
            goto L5d
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            kotlin.ResultKt.throwOnFailure(r12)
            com.urbanairship.http.RequestResult r12 = r9.cachedResultWithPrefix(r10, r11)
            if (r12 == 0) goto L4c
            return r12
        L4c:
            com.urbanairship.inputvalidation.SmsValidatorApiInterface r12 = r9.client
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.label = r3
            java.lang.Object r12 = r12.validateSmsWithPrefix(r10, r11, r0)
            if (r12 != r1) goto L36
            return r1
        L5d:
            com.urbanairship.http.RequestResult r12 = (com.urbanairship.http.RequestResult) r12
            r7 = 8
            r8 = 0
            r6 = 0
            r3 = r12
            cacheResult$default(r2, r3, r4, r5, r6, r7, r8)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.inputvalidation.CachingSmsValidatorApiClient.validateSmsWithPrefix(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.inputvalidation.SmsValidatorApiInterface
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object validateSmsWithSender(@org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.http.RequestResult<com.urbanairship.inputvalidation.SmsValidatorApiClient.Result>> r12) throws java.security.InvalidParameterException {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.urbanairship.inputvalidation.CachingSmsValidatorApiClient.C11491
            if (r0 == 0) goto L13
            r0 = r12
            com.urbanairship.inputvalidation.CachingSmsValidatorApiClient$validateSmsWithSender$1 r0 = (com.urbanairship.inputvalidation.CachingSmsValidatorApiClient.C11491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.inputvalidation.CachingSmsValidatorApiClient$validateSmsWithSender$1 r0 = new com.urbanairship.inputvalidation.CachingSmsValidatorApiClient$validateSmsWithSender$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r9 = r0.L$2
            r11 = r9
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r9 = r0.L$1
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r0.L$0
            com.urbanairship.inputvalidation.CachingSmsValidatorApiClient r9 = (com.urbanairship.inputvalidation.CachingSmsValidatorApiClient) r9
            kotlin.ResultKt.throwOnFailure(r12)
        L36:
            r2 = r9
            r4 = r10
            r6 = r11
            goto L5d
        L3a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L42:
            kotlin.ResultKt.throwOnFailure(r12)
            com.urbanairship.http.RequestResult r12 = r9.cachedResultWithSender(r10, r11)
            if (r12 == 0) goto L4c
            return r12
        L4c:
            com.urbanairship.inputvalidation.SmsValidatorApiInterface r12 = r9.client
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.label = r3
            java.lang.Object r12 = r12.validateSmsWithSender(r10, r11, r0)
            if (r12 != r1) goto L36
            return r1
        L5d:
            com.urbanairship.http.RequestResult r12 = (com.urbanairship.http.RequestResult) r12
            r7 = 4
            r8 = 0
            r5 = 0
            r3 = r12
            cacheResult$default(r2, r3, r4, r5, r6, r7, r8)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.inputvalidation.CachingSmsValidatorApiClient.validateSmsWithSender(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final RequestResult cachedResultWithSender(String msisdn, String sender) {
        Object next;
        Iterator it = ((Iterable) this._cache.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Entry entry = (Entry) next;
            if (Intrinsics.areEqual(entry.getMsisdn(), msisdn) && Intrinsics.areEqual(entry.getSender(), sender)) {
                break;
            }
        }
        Entry entry2 = (Entry) next;
        if (entry2 != null) {
            return entry2.getResult();
        }
        return null;
    }

    private final RequestResult cachedResultWithPrefix(String msisdn, String prefix) {
        Object next;
        Iterator it = ((Iterable) this._cache.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Entry entry = (Entry) next;
            if (Intrinsics.areEqual(entry.getMsisdn(), msisdn) && Intrinsics.areEqual(entry.getPrefix(), prefix)) {
                break;
            }
        }
        Entry entry2 = (Entry) next;
        if (entry2 != null) {
            return entry2.getResult();
        }
        return null;
    }

    static /* synthetic */ void cacheResult$default(CachingSmsValidatorApiClient cachingSmsValidatorApiClient, RequestResult requestResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        cachingSmsValidatorApiClient.cacheResult(requestResult, str, str2, str3);
    }

    private final void cacheResult(RequestResult result, String msisdn, String prefix, String sender) {
        Object value;
        List mutableList;
        if (result.isSuccessful()) {
            final Entry entry = new Entry(msisdn, sender, prefix, result);
            MutableStateFlow mutableStateFlow = this._cache;
            do {
                value = mutableStateFlow.getValue();
                mutableList = CollectionsKt.toMutableList((Collection) value);
                CollectionsKt.removeAll(mutableList, new Function1() { // from class: com.urbanairship.inputvalidation.CachingSmsValidatorApiClient$cacheResult$1$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(CachingSmsValidatorApiClient.Entry it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it, entry));
                    }
                });
                mutableList.add(entry);
                if (mutableList.size() > this.maxCacheEntries) {
                    mutableList.remove(0);
                }
            } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.toList(mutableList)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Entry {
        private final String msisdn;
        private final String prefix;
        private final RequestResult result;
        private final String sender;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return Intrinsics.areEqual(this.msisdn, entry.msisdn) && Intrinsics.areEqual(this.sender, entry.sender) && Intrinsics.areEqual(this.prefix, entry.prefix) && Intrinsics.areEqual(this.result, entry.result);
        }

        public int hashCode() {
            int iHashCode = this.msisdn.hashCode() * 31;
            String str = this.sender;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.prefix;
            return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.result.hashCode();
        }

        public String toString() {
            return "Entry(msisdn=" + this.msisdn + ", sender=" + this.sender + ", prefix=" + this.prefix + ", result=" + this.result + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Entry(String msisdn, String str, String str2, RequestResult result) {
            Intrinsics.checkNotNullParameter(msisdn, "msisdn");
            Intrinsics.checkNotNullParameter(result, "result");
            this.msisdn = msisdn;
            this.sender = str;
            this.prefix = str2;
            this.result = result;
        }

        public final String getMsisdn() {
            return this.msisdn;
        }

        public final String getSender() {
            return this.sender;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final RequestResult getResult() {
            return this.result;
        }
    }
}
