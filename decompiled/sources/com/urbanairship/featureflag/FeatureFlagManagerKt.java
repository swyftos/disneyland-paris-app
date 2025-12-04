package com.urbanairship.featureflag;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"evaluate", "Lcom/urbanairship/featureflag/VariableResult;", "Lcom/urbanairship/featureflag/FeatureFlagVariables;", "isEligible", "", "audienceEvaluator", "Lcom/urbanairship/audience/AudienceEvaluator;", "newEvaluationDate", "", "deviceInfoProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "(Lcom/urbanairship/featureflag/FeatureFlagVariables;ZLcom/urbanairship/audience/AudienceEvaluator;JLcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-feature-flag_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFeatureFlagManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagManager.kt\ncom/urbanairship/featureflag/FeatureFlagManagerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,453:1\n288#2,2:454\n*S KotlinDebug\n*F\n+ 1 FeatureFlagManager.kt\ncom/urbanairship/featureflag/FeatureFlagManagerKt\n*L\n436#1:454,2\n*E\n"})
/* loaded from: classes5.dex */
public final class FeatureFlagManagerKt {

    /* renamed from: com.urbanairship.featureflag.FeatureFlagManagerKt$evaluate$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FeatureFlagManagerKt.evaluate(null, false, null, 0L, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072 A[PHI: r0 r2 r5 r7 r9
  0x0072: PHI (r0v4 java.util.Iterator) = (r0v3 java.util.Iterator), (r0v5 java.util.Iterator) binds: [B:22:0x0063, B:34:0x00b3] A[DONT_GENERATE, DONT_INLINE]
  0x0072: PHI (r2v2 com.urbanairship.audience.DeviceInfoProvider) = (r2v1 com.urbanairship.audience.DeviceInfoProvider), (r2v3 com.urbanairship.audience.DeviceInfoProvider) binds: [B:22:0x0063, B:34:0x00b3] A[DONT_GENERATE, DONT_INLINE]
  0x0072: PHI (r5v1 long) = (r5v0 long), (r5v2 long) binds: [B:22:0x0063, B:34:0x00b3] A[DONT_GENERATE, DONT_INLINE]
  0x0072: PHI (r7v1 com.urbanairship.featureflag.FeatureFlagManagerKt$evaluate$1) = 
  (r7v0 com.urbanairship.featureflag.FeatureFlagManagerKt$evaluate$1)
  (r7v2 com.urbanairship.featureflag.FeatureFlagManagerKt$evaluate$1)
 binds: [B:22:0x0063, B:34:0x00b3] A[DONT_GENERATE, DONT_INLINE]
  0x0072: PHI (r9v11 com.urbanairship.audience.AudienceEvaluator) = (r9v5 com.urbanairship.audience.AudienceEvaluator), (r9v12 com.urbanairship.audience.AudienceEvaluator) binds: [B:22:0x0063, B:34:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ac -> B:33:0x00ad). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object evaluate(com.urbanairship.featureflag.FeatureFlagVariables r9, boolean r10, com.urbanairship.audience.AudienceEvaluator r11, long r12, com.urbanairship.audience.DeviceInfoProvider r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlagManagerKt.evaluate(com.urbanairship.featureflag.FeatureFlagVariables, boolean, com.urbanairship.audience.AudienceEvaluator, long, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
