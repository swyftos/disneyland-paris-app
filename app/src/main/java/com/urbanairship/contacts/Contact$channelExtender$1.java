package com.urbanairship.contacts;

import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.ChannelRegistrationPayload;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes5.dex */
final class Contact$channelExtender$1 implements AirshipChannel.Extender.Suspending {
    final /* synthetic */ Contact this$0;

    Contact$channelExtender$1(Contact contact) {
        this.this$0 = contact;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.urbanairship.channel.AirshipChannel.Extender.Suspending
    public final Object extend(ChannelRegistrationPayload.Builder builder, Continuation continuation) {
        Contact$channelExtender$1$extend$1 contact$channelExtender$1$extend$1;
        ChannelRegistrationPayload.Builder builder2;
        if (continuation instanceof Contact$channelExtender$1$extend$1) {
            contact$channelExtender$1$extend$1 = (Contact$channelExtender$1$extend$1) continuation;
            int i = contact$channelExtender$1$extend$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                contact$channelExtender$1$extend$1.label = i - Integer.MIN_VALUE;
            } else {
                contact$channelExtender$1$extend$1 = new Contact$channelExtender$1$extend$1(this, continuation);
            }
        } else {
            contact$channelExtender$1$extend$1 = new Contact$channelExtender$1$extend$1(this, continuation);
        }
        Object objStableVerifiedContactId = contact$channelExtender$1$extend$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = contact$channelExtender$1$extend$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objStableVerifiedContactId);
            if (this.this$0.contactManager.getLastContactId() == null) {
                this.this$0.contactManager.generateDefaultContactIdIfNotSet$urbanairship_core_release();
            }
            if (this.this$0.airshipChannel.getId() == null) {
                builder.setContactId(this.this$0.contactManager.getLastContactId());
                return builder;
            }
            Contact contact = this.this$0;
            contact$channelExtender$1$extend$1.L$0 = builder;
            contact$channelExtender$1$extend$1.L$1 = builder;
            contact$channelExtender$1$extend$1.label = 1;
            objStableVerifiedContactId = contact.stableVerifiedContactId(contact$channelExtender$1$extend$1);
            if (objStableVerifiedContactId == coroutine_suspended) {
                return coroutine_suspended;
            }
            builder2 = builder;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            builder = (ChannelRegistrationPayload.Builder) contact$channelExtender$1$extend$1.L$1;
            builder2 = (ChannelRegistrationPayload.Builder) contact$channelExtender$1$extend$1.L$0;
            ResultKt.throwOnFailure(objStableVerifiedContactId);
        }
        builder.setContactId((String) objStableVerifiedContactId);
        return builder2;
    }
}
