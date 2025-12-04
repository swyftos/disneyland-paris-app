package com.urbanairship.contacts;

import com.urbanairship.contacts.ContactChannel;
import com.urbanairship.contacts.ContactChannelMutation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"canonicalAddress", "", "Lcom/urbanairship/contacts/ContactChannel;", "getCanonicalAddress", "(Lcom/urbanairship/contacts/ContactChannel;)Ljava/lang/String;", "Lcom/urbanairship/contacts/ContactChannelMutation;", "(Lcom/urbanairship/contacts/ContactChannelMutation;)Ljava/lang/String;", "channelId", "getChannelId", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactChannelsProviderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getCanonicalAddress(ContactChannelMutation contactChannelMutation) {
        if (contactChannelMutation instanceof ContactChannelMutation.Disassociated) {
            return getCanonicalAddress(((ContactChannelMutation.Disassociated) contactChannelMutation).getChannel());
        }
        if (contactChannelMutation instanceof ContactChannelMutation.Associate) {
            return getCanonicalAddress(((ContactChannelMutation.Associate) contactChannelMutation).getChannel());
        }
        if (contactChannelMutation instanceof ContactChannelMutation.AssociateAnon) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getChannelId(ContactChannelMutation contactChannelMutation) {
        if (contactChannelMutation instanceof ContactChannelMutation.Disassociated) {
            ContactChannelMutation.Disassociated disassociated = (ContactChannelMutation.Disassociated) contactChannelMutation;
            String channelId = disassociated.getChannelId();
            return channelId == null ? getChannelId(disassociated.getChannel()) : channelId;
        }
        if (contactChannelMutation instanceof ContactChannelMutation.Associate) {
            ContactChannelMutation.Associate associate = (ContactChannelMutation.Associate) contactChannelMutation;
            String channelId2 = associate.getChannelId();
            return channelId2 == null ? getChannelId(associate.getChannel()) : channelId2;
        }
        if (contactChannelMutation instanceof ContactChannelMutation.AssociateAnon) {
            return ((ContactChannelMutation.AssociateAnon) contactChannelMutation).getChannelId();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getCanonicalAddress(ContactChannel contactChannel) {
        if (contactChannel instanceof ContactChannel.Sms) {
            ContactChannel.Sms sms = (ContactChannel.Sms) contactChannel;
            if (!(sms.getRegistrationInfo() instanceof ContactChannel.Sms.RegistrationInfo.Pending)) {
                return null;
            }
            return ((ContactChannel.Sms.RegistrationInfo.Pending) sms.getRegistrationInfo()).getAddress() + ':' + sms.getSenderId();
        }
        if (contactChannel instanceof ContactChannel.Email) {
            ContactChannel.Email email = (ContactChannel.Email) contactChannel;
            if (email.getRegistrationInfo() instanceof ContactChannel.Email.RegistrationInfo.Pending) {
                return ((ContactChannel.Email.RegistrationInfo.Pending) email.getRegistrationInfo()).getAddress();
            }
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getChannelId(ContactChannel contactChannel) {
        if (contactChannel instanceof ContactChannel.Sms) {
            ContactChannel.Sms sms = (ContactChannel.Sms) contactChannel;
            if (sms.getRegistrationInfo() instanceof ContactChannel.Sms.RegistrationInfo.Registered) {
                return ((ContactChannel.Sms.RegistrationInfo.Registered) sms.getRegistrationInfo()).getChannelId();
            }
            return null;
        }
        if (contactChannel instanceof ContactChannel.Email) {
            ContactChannel.Email email = (ContactChannel.Email) contactChannel;
            if (email.getRegistrationInfo() instanceof ContactChannel.Email.RegistrationInfo.Registered) {
                return ((ContactChannel.Email.RegistrationInfo.Registered) email.getRegistrationInfo()).getChannelId();
            }
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
