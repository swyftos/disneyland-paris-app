package com.urbanairship.contacts;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import com.urbanairship.PrivacyManager;
import com.urbanairship.audience.AudienceOverrides;
import com.urbanairship.audience.AudienceOverridesProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006*\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"isContactsAudienceEnabled", "", "Lcom/urbanairship/PrivacyManager;", "(Lcom/urbanairship/PrivacyManager;)Z", "isContactsEnabled", "stableContactIdUpdates", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/urbanairship/contacts/ContactManager;", "getStableContactIdUpdates", "(Lcom/urbanairship/contacts/ContactManager;)Lkotlinx/coroutines/flow/Flow;", "contactUpdates", "Lcom/urbanairship/audience/AudienceOverrides$Contact;", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContact.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Contact.kt\ncom/urbanairship/contacts/ContactKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,627:1\n60#2:628\n63#2:632\n50#3:629\n55#3:631\n106#4:630\n*S KotlinDebug\n*F\n+ 1 Contact.kt\ncom/urbanairship/contacts/ContactKt\n*L\n618#1:628\n618#1:632\n618#1:629\n618#1:631\n618#1:630\n*E\n"})
/* loaded from: classes5.dex */
public final class ContactKt {
    public static final boolean isContactsEnabled(@NotNull PrivacyManager privacyManager) {
        Intrinsics.checkNotNullParameter(privacyManager, "<this>");
        return privacyManager.isEnabled(PrivacyManager.Feature.CONTACTS);
    }

    public static final boolean isContactsAudienceEnabled(@NotNull PrivacyManager privacyManager) {
        Intrinsics.checkNotNullParameter(privacyManager, "<this>");
        return privacyManager.isEnabled(PrivacyManager.Feature.CONTACTS, PrivacyManager.Feature.TAGS_AND_ATTRIBUTES);
    }

    @NotNull
    public static final Flow<String> getStableContactIdUpdates(@NotNull ContactManager contactManager) {
        Intrinsics.checkNotNullParameter(contactManager, "<this>");
        final StateFlow<ContactIdUpdate> contactIdUpdates = contactManager.getContactIdUpdates();
        return new Flow<String>() { // from class: com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = contactIdUpdates.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Contact.kt\ncom/urbanairship/contacts/ContactKt\n*L\n1#1,222:1\n61#2:223\n62#2:225\n619#3:224\n*E\n"})
            /* renamed from: com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1$2", f = "Contact.kt", i = {}, l = {JfifUtil.MARKER_APP1}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1$2$1 r0 = (com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1$2$1 r0 = new com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L51
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        com.urbanairship.contacts.ContactIdUpdate r5 = (com.urbanairship.contacts.ContactIdUpdate) r5
                        if (r5 == 0) goto L45
                        boolean r6 = r5.isStable()
                        if (r6 != r3) goto L45
                        java.lang.String r5 = r5.getContactId()
                        goto L46
                    L45:
                        r5 = 0
                    L46:
                        if (r5 == 0) goto L51
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L51
                        return r1
                    L51:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactKt$special$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    /* renamed from: com.urbanairship.contacts.ContactKt$contactUpdates$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function3 {
        final /* synthetic */ AudienceOverridesProvider $this_contactUpdates;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AudienceOverridesProvider audienceOverridesProvider, Continuation continuation) {
            super(3, continuation);
            this.$this_contactUpdates = audienceOverridesProvider;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m2842invokeOsBMiQA((String) obj, ((UInt) obj2).getData(), (Continuation) obj3);
        }

        /* renamed from: invoke-OsBMiQA, reason: not valid java name */
        public final Object m2842invokeOsBMiQA(String str, int i, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_contactUpdates, continuation);
            anonymousClass1.L$0 = str;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) this.L$0;
                AudienceOverridesProvider audienceOverridesProvider = this.$this_contactUpdates;
                this.label = 1;
                obj = audienceOverridesProvider.contactOverrides$urbanairship_core_release(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @NotNull
    public static final Flow<AudienceOverrides.Contact> contactUpdates(@NotNull AudienceOverridesProvider audienceOverridesProvider, @NotNull Flow<String> stableContactIdUpdates) {
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "<this>");
        Intrinsics.checkNotNullParameter(stableContactIdUpdates, "stableContactIdUpdates");
        return FlowKt.combine(stableContactIdUpdates, audienceOverridesProvider.getUpdates$urbanairship_core_release(), new AnonymousClass1(audienceOverridesProvider, null));
    }
}
