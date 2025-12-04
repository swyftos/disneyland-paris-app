package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import com.urbanairship.cache.AirshipCache;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/audience/AudienceEvaluator;", "", "cache", "Lcom/urbanairship/cache/AirshipCache;", "(Lcom/urbanairship/cache/AirshipCache;)V", "hashChecker", "Lcom/urbanairship/audience/HashChecker;", "evaluate", "Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", "compoundAudience", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "newEvaluationDate", "", "infoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "(Lcom/urbanairship/audience/CompoundAudienceSelector;JLcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class AudienceEvaluator {
    private final HashChecker hashChecker;

    /* renamed from: com.urbanairship.audience.AudienceEvaluator$evaluate$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AudienceEvaluator.this.evaluate(null, 0L, null, this);
        }
    }

    public AudienceEvaluator(@NotNull AirshipCache cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.hashChecker = new HashChecker(cache, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object evaluate(@org.jetbrains.annotations.Nullable com.urbanairship.audience.CompoundAudienceSelector r8, long r9, @org.jetbrains.annotations.NotNull com.urbanairship.audience.DeviceInfoProvider r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.audience.AirshipDeviceAudienceResult> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.urbanairship.audience.AudienceEvaluator.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.urbanairship.audience.AudienceEvaluator$evaluate$1 r0 = (com.urbanairship.audience.AudienceEvaluator.AnonymousClass1) r0
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
            com.urbanairship.audience.AudienceEvaluator$evaluate$1 r0 = new com.urbanairship.audience.AudienceEvaluator$evaluate$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r12)
            goto L46
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.throwOnFailure(r12)
            if (r8 == 0) goto L4a
            com.urbanairship.audience.HashChecker r5 = r7.hashChecker
            r6.label = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r12 = r1.evaluate(r2, r4, r5, r6)
            if (r12 != r0) goto L46
            return r0
        L46:
            com.urbanairship.audience.AirshipDeviceAudienceResult r12 = (com.urbanairship.audience.AirshipDeviceAudienceResult) r12
            if (r12 != 0) goto L50
        L4a:
            com.urbanairship.audience.AirshipDeviceAudienceResult$Companion r7 = com.urbanairship.audience.AirshipDeviceAudienceResult.INSTANCE
            com.urbanairship.audience.AirshipDeviceAudienceResult r12 = r7.getMatch()
        L50:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.AudienceEvaluator.evaluate(com.urbanairship.audience.CompoundAudienceSelector, long, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
