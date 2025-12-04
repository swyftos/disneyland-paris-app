package com.urbanairship.android.layout.info;

import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/urbanairship/android/layout/info/AutomatedAccessibilityAction;", "", "type", "Lcom/urbanairship/android/layout/info/AutomatedAccessibilityActionType;", "(Lcom/urbanairship/android/layout/info/AutomatedAccessibilityActionType;)V", "getType", "()Lcom/urbanairship/android/layout/info/AutomatedAccessibilityActionType;", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomatedAccessibilityAction {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AutomatedAccessibilityActionType type;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/info/AutomatedAccessibilityAction$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/info/AutomatedAccessibilityAction;", "json", "Lcom/urbanairship/json/JsonMap;", "fromList", "", "jsonList", "Lcom/urbanairship/json/JsonList;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/AutomatedAccessibilityAction$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n1#2:945\n1#2:956\n1603#3,9:946\n1855#3:955\n1856#3:957\n1612#3:958\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/AutomatedAccessibilityAction$Companion\n*L\n760#1:956\n760#1:946,9\n760#1:955\n760#1:957\n760#1:958\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final AutomatedAccessibilityAction from(@NotNull JsonMap json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            String strOptString = json.opt("type").optString();
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            AutomatedAccessibilityActionType automatedAccessibilityActionTypeFrom = AutomatedAccessibilityActionType.INSTANCE.from(strOptString);
            if (automatedAccessibilityActionTypeFrom != null) {
                return new AutomatedAccessibilityAction(automatedAccessibilityActionTypeFrom);
            }
            return null;
        }

        @NotNull
        public final List<AutomatedAccessibilityAction> fromList(@NotNull JsonList jsonList) throws JsonException {
            Intrinsics.checkNotNullParameter(jsonList, "jsonList");
            if (jsonList.isEmpty()) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (JsonValue jsonValue : jsonList) {
                Companion companion = AutomatedAccessibilityAction.INSTANCE;
                JsonMap jsonMapOptMap = jsonValue.optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                AutomatedAccessibilityAction automatedAccessibilityActionFrom = companion.from(jsonMapOptMap);
                if (automatedAccessibilityActionFrom != null) {
                    arrayList.add(automatedAccessibilityActionFrom);
                }
            }
            return arrayList;
        }
    }

    public AutomatedAccessibilityAction(@NotNull AutomatedAccessibilityActionType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    @NotNull
    public final AutomatedAccessibilityActionType getType() {
        return this.type;
    }
}
