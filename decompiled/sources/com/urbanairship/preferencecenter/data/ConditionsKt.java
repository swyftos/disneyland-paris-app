package com.urbanairship.preferencecenter.data;

import com.dlp.BluetoothManager;
import com.urbanairship.preferencecenter.data.Condition;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000*\u0018\b\u0000\u0010\u0007\"\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\b"}, d2 = {"evaluate", "", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/preferencecenter/data/Condition$State;", "Conditions", "urbanairship-preference-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Conditions.kt\ncom/urbanairship/preferencecenter/data/ConditionsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n1747#2,3:95\n*S KotlinDebug\n*F\n+ 1 Conditions.kt\ncom/urbanairship/preferencecenter/data/ConditionsKt\n*L\n23#1:95,3\n*E\n"})
/* loaded from: classes5.dex */
public final class ConditionsKt {
    public static final boolean evaluate(@NotNull List<? extends Condition> list, @NotNull Condition.State state) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!list.isEmpty()) {
            if (!list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((Condition) it.next()).evaluate(state)) {
                    }
                }
            }
            return false;
        }
        return true;
    }
}
