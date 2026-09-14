package com.urbanairship.push;

import com.urbanairship.AirshipConfigOptions;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/push/PushProviderType;", "", "deliveryType", "", "(Ljava/lang/String;ILjava/lang/String;)V", AirshipConfigOptions.ADM_TRANSPORT, "FCM", AirshipConfigOptions.HMS_TRANSPORT, "NONE", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum PushProviderType {
    ADM(PushProvider.ADM_DELIVERY_TYPE),
    FCM("fcm"),
    HMS(PushProvider.HMS_DELIVERY_TYPE),
    NONE(null);

    private final String deliveryType;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy VALUES_BY_TYPE$delegate = LazyKt.lazy(new Function0() { // from class: com.urbanairship.push.PushProviderType$Companion$VALUES_BY_TYPE$2
        @Override // kotlin.jvm.functions.Function0
        public final Map invoke() {
            PushProviderType[] pushProviderTypeArrValues = PushProviderType.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(pushProviderTypeArrValues.length), 16));
            for (PushProviderType pushProviderType : pushProviderTypeArrValues) {
                linkedHashMap.put(pushProviderType.deliveryType, pushProviderType);
            }
            return linkedHashMap;
        }
    });

    @NotNull
    public static EnumEntries<PushProviderType> getEntries() {
        return $ENTRIES;
    }

    PushProviderType(String str) {
        this.deliveryType = str;
    }

    @Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rR)\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m1836d2 = {"Lcom/urbanairship/push/PushProviderType$Companion;", "", "()V", "VALUES_BY_TYPE", "", "", "Lcom/urbanairship/push/PushProviderType;", "getVALUES_BY_TYPE", "()Ljava/util/Map;", "VALUES_BY_TYPE$delegate", "Lkotlin/Lazy;", "from", "provider", "Lcom/urbanairship/push/PushProvider;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Map getVALUES_BY_TYPE() {
            return (Map) PushProviderType.VALUES_BY_TYPE$delegate.getValue();
        }

        @NotNull
        public final PushProviderType from(@Nullable PushProvider provider) {
            PushProviderType pushProviderType = (PushProviderType) getVALUES_BY_TYPE().get(provider != null ? provider.getDeliveryType() : null);
            return pushProviderType == null ? PushProviderType.NONE : pushProviderType;
        }
    }
}
