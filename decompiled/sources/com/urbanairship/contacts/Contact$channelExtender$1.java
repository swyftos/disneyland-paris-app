package com.urbanairship.contacts;

import com.urbanairship.channel.AirshipChannel;

/* loaded from: classes5.dex */
final class Contact$channelExtender$1 implements AirshipChannel.Extender.Suspending {
    final /* synthetic */ Contact this$0;

    Contact$channelExtender$1(Contact contact) {
        this.this$0 = contact;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.channel.AirshipChannel.Extender.Suspending
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object extend(com.urbanairship.channel.ChannelRegistrationPayload.Builder r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.contacts.Contact$channelExtender$1$extend$1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.contacts.Contact$channelExtender$1$extend$1 r0 = (com.urbanairship.contacts.Contact$channelExtender$1$extend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.contacts.Contact$channelExtender$1$extend$1 r0 = new com.urbanairship.contacts.Contact$channelExtender$1$extend$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            com.urbanairship.channel.ChannelRegistrationPayload$Builder r5 = (com.urbanairship.channel.ChannelRegistrationPayload.Builder) r5
            java.lang.Object r4 = r0.L$0
            com.urbanairship.channel.ChannelRegistrationPayload$Builder r4 = (com.urbanairship.channel.ChannelRegistrationPayload.Builder) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L6e
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.contacts.Contact r6 = r4.this$0
            com.urbanairship.contacts.ContactManager r6 = com.urbanairship.contacts.Contact.access$getContactManager$p(r6)
            java.lang.String r6 = r6.getLastContactId()
            if (r6 != 0) goto L52
            com.urbanairship.contacts.Contact r6 = r4.this$0
            com.urbanairship.contacts.ContactManager r6 = com.urbanairship.contacts.Contact.access$getContactManager$p(r6)
            r6.generateDefaultContactIdIfNotSet$urbanairship_core_release()
        L52:
            com.urbanairship.contacts.Contact r6 = r4.this$0
            com.urbanairship.channel.AirshipChannel r6 = com.urbanairship.contacts.Contact.access$getAirshipChannel$p(r6)
            java.lang.String r6 = r6.getId()
            if (r6 == 0) goto L75
            com.urbanairship.contacts.Contact r4 = r4.this$0
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = com.urbanairship.contacts.Contact.access$stableVerifiedContactId(r4, r0)
            if (r6 != r1) goto L6d
            return r1
        L6d:
            r4 = r5
        L6e:
            java.lang.String r6 = (java.lang.String) r6
            r5.setContactId(r6)
            r5 = r4
            goto L82
        L75:
            com.urbanairship.contacts.Contact r4 = r4.this$0
            com.urbanairship.contacts.ContactManager r4 = com.urbanairship.contacts.Contact.access$getContactManager$p(r4)
            java.lang.String r4 = r4.getLastContactId()
            r5.setContactId(r4)
        L82:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.Contact$channelExtender$1.extend(com.urbanairship.channel.ChannelRegistrationPayload$Builder, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
