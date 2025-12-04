package com.urbanairship.preferencecenter.ui;

import androidx.annotation.VisibleForTesting;
import com.dlp.BluetoothManager;
import com.urbanairship.contacts.ContactChannel;
import com.urbanairship.preferencecenter.data.Condition;
import com.urbanairship.preferencecenter.data.ConditionsKt;
import com.urbanairship.preferencecenter.data.Item;
import com.urbanairship.preferencecenter.data.PreferenceCenterConfig;
import com.urbanairship.preferencecenter.data.Section;
import com.urbanairship.preferencecenter.ui.item.AlertItem;
import com.urbanairship.preferencecenter.ui.item.ChannelSubscriptionItem;
import com.urbanairship.preferencecenter.ui.item.ContactManagementItem;
import com.urbanairship.preferencecenter.ui.item.ContactSubscriptionGroupItem;
import com.urbanairship.preferencecenter.ui.item.ContactSubscriptionItem;
import com.urbanairship.preferencecenter.ui.item.PrefCenterItem;
import com.urbanairship.preferencecenter.ui.item.SectionBreakItem;
import com.urbanairship.preferencecenter.ui.item.SectionItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\tH\u0001\u001a\u0014\u0010\n\u001a\u00020\t*\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005¨\u0006\r"}, d2 = {"isOptedIn", "", "Lcom/urbanairship/contacts/ContactChannel;", "isOptedIn$annotations", "(Lcom/urbanairship/contacts/ContactChannel;)V", "(Lcom/urbanairship/contacts/ContactChannel;)Z", "asPrefCenterItems", "", "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "filterByConditions", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/preferencecenter/data/Condition$State;", "urbanairship-preference-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPreferenceCenterViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModelKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,806:1\n766#2:807\n857#2,2:808\n1549#2:810\n1620#2,3:811\n1360#2:814\n1446#2,2:815\n1549#2:817\n1620#2,3:818\n1448#2,3:821\n*S KotlinDebug\n*F\n+ 1 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModelKt\n*L\n717#1:807\n717#1:808,2\n719#1:810\n719#1:811,3\n734#1:814\n734#1:815,2\n745#1:817\n745#1:818,3\n734#1:821,3\n*E\n"})
/* loaded from: classes5.dex */
public final class PreferenceCenterViewModelKt {
    @VisibleForTesting
    public static /* synthetic */ void isOptedIn$annotations(ContactChannel contactChannel) {
    }

    @VisibleForTesting
    @NotNull
    public static final PreferenceCenterConfig filterByConditions(@NotNull PreferenceCenterConfig preferenceCenterConfig, @NotNull final Condition.State state) {
        Intrinsics.checkNotNullParameter(preferenceCenterConfig, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        List<Section> sections = preferenceCenterConfig.getSections();
        ArrayList arrayList = new ArrayList();
        for (Object obj : sections) {
            if (ConditionsKt.evaluate(((Section) obj).getConditions(), state)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Section) it.next()).filterItems$urbanairship_preference_center_release(new Function1() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModelKt$filterByConditions$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Item item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    return Boolean.valueOf(ConditionsKt.evaluate(item.getConditions(), state));
                }
            }));
        }
        return PreferenceCenterConfig.copy$default(preferenceCenterConfig, null, arrayList2, null, null, 13, null);
    }

    @VisibleForTesting
    @NotNull
    public static final List<PrefCenterItem> asPrefCenterItems(@NotNull PreferenceCenterConfig preferenceCenterConfig) {
        List listListOf;
        List listPlus;
        Object contactManagementItem;
        Intrinsics.checkNotNullParameter(preferenceCenterConfig, "<this>");
        List<Section> sections = preferenceCenterConfig.getSections();
        ArrayList arrayList = new ArrayList();
        for (Section section : sections) {
            if (section instanceof Section.SectionBreak) {
                listPlus = CollectionsKt.listOf(new SectionBreakItem((Section.SectionBreak) section));
            } else if (section instanceof Section.Common) {
                if (section.getDisplay().isEmpty$urbanairship_preference_center_release()) {
                    listListOf = CollectionsKt.emptyList();
                } else {
                    listListOf = CollectionsKt.listOf(new SectionItem(section));
                }
                List<Item> items = section.getItems();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
                for (Item item : items) {
                    if (item instanceof Item.ChannelSubscription) {
                        contactManagementItem = new ChannelSubscriptionItem((Item.ChannelSubscription) item);
                    } else if (item instanceof Item.ContactSubscription) {
                        contactManagementItem = new ContactSubscriptionItem((Item.ContactSubscription) item);
                    } else if (item instanceof Item.ContactSubscriptionGroup) {
                        contactManagementItem = new ContactSubscriptionGroupItem((Item.ContactSubscriptionGroup) item);
                    } else if (item instanceof Item.Alert) {
                        contactManagementItem = new AlertItem((Item.Alert) item);
                    } else {
                        if (!(item instanceof Item.ContactManagement)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        contactManagementItem = new ContactManagementItem((Item.ContactManagement) item);
                    }
                    arrayList2.add(contactManagementItem);
                }
                listPlus = CollectionsKt.plus((Collection) listListOf, (Iterable) arrayList2);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            CollectionsKt.addAll(arrayList, listPlus);
        }
        return arrayList;
    }

    public static final boolean isOptedIn(@NotNull ContactChannel contactChannel) {
        Intrinsics.checkNotNullParameter(contactChannel, "<this>");
        if (contactChannel instanceof ContactChannel.Email) {
            ContactChannel.Email email = (ContactChannel.Email) contactChannel;
            ContactChannel.Email.RegistrationInfo registrationInfo = email.getRegistrationInfo();
            if (registrationInfo instanceof ContactChannel.Email.RegistrationInfo.Pending) {
                return false;
            }
            if (registrationInfo instanceof ContactChannel.Email.RegistrationInfo.Registered) {
                ContactChannel.Email.RegistrationInfo registrationInfo2 = email.getRegistrationInfo();
                Intrinsics.checkNotNull(registrationInfo2, "null cannot be cast to non-null type com.urbanairship.contacts.ContactChannel.Email.RegistrationInfo.Registered");
                ContactChannel.Email.RegistrationInfo.Registered registered = (ContactChannel.Email.RegistrationInfo.Registered) registrationInfo2;
                if (registered.getCommercialOptedOut() == null) {
                    if (registered.getCommercialOptedIn() == null) {
                        return false;
                    }
                } else {
                    if (registered.getCommercialOptedIn() == null || registered.getCommercialOptedOut() == null) {
                        return false;
                    }
                    Long commercialOptedIn = registered.getCommercialOptedIn();
                    long jLongValue = commercialOptedIn != null ? commercialOptedIn.longValue() : 0L;
                    Long commercialOptedOut = registered.getCommercialOptedOut();
                    if (jLongValue <= (commercialOptedOut != null ? commercialOptedOut.longValue() : 0L)) {
                        return false;
                    }
                }
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!(contactChannel instanceof ContactChannel.Sms)) {
            throw new NoWhenBranchMatchedException();
        }
        ContactChannel.Sms sms = (ContactChannel.Sms) contactChannel;
        ContactChannel.Sms.RegistrationInfo registrationInfo3 = sms.getRegistrationInfo();
        if (registrationInfo3 instanceof ContactChannel.Sms.RegistrationInfo.Pending) {
            return false;
        }
        if (!(registrationInfo3 instanceof ContactChannel.Sms.RegistrationInfo.Registered)) {
            throw new NoWhenBranchMatchedException();
        }
        ContactChannel.Sms.RegistrationInfo registrationInfo4 = sms.getRegistrationInfo();
        Intrinsics.checkNotNull(registrationInfo4, "null cannot be cast to non-null type com.urbanairship.contacts.ContactChannel.Sms.RegistrationInfo.Registered");
        return ((ContactChannel.Sms.RegistrationInfo.Registered) registrationInfo4).getIsOptIn();
    }
}
