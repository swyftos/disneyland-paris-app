package com.urbanairship.automation.remotedata;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.limits.FrequencyConstraint;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.remotedata.RemoteDataInfo;
import com.urbanairship.remotedata.RemoteDataPayload;
import com.urbanairship.remotedata.RemoteDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0003\t\n\u000bB\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/urbanairship/automation/remotedata/InAppRemoteData;", "", "payload", "", "Lcom/urbanairship/remotedata/RemoteDataSource;", "Lcom/urbanairship/automation/remotedata/InAppRemoteData$Payload;", "(Ljava/util/Map;)V", "getPayload", "()Ljava/util/Map;", "Companion", "Data", "Payload", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppRemoteData {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String LEGACY_REMOTE_INFO_METADATA_KEY = "com.urbanairship.iaa.REMOTE_DATA_METADATA";

    @NotNull
    public static final String REMOTE_INFO_METADATA_KEY = "com.urbanairship.iaa.REMOTE_DATA_INFO";
    private final Map payload;

    public InAppRemoteData(@NotNull Map<RemoteDataSource, Payload> payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.payload = payload;
    }

    @NotNull
    public final Map<RemoteDataSource, Payload> getPayload() {
        return this.payload;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J+\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/automation/remotedata/InAppRemoteData$Data;", "", "schedules", "", "Lcom/urbanairship/automation/AutomationSchedule;", "constraints", "Lcom/urbanairship/automation/limits/FrequencyConstraint;", "(Ljava/util/List;Ljava/util/List;)V", "getConstraints", "()Ljava/util/List;", "getSchedules", "component1", "component2", "copy", "copyWithUpdateSchedules", "updateBlock", "Lkotlin/Function1;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationRemoteDataAccess.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/InAppRemoteData$Data\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,272:1\n1549#2:273\n1620#2,3:274\n*S KotlinDebug\n*F\n+ 1 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/InAppRemoteData$Data\n*L\n212#1:273\n212#1:274,3\n*E\n"})
    public static final /* data */ class Data {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final List constraints;
        private final List schedules;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data data, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = data.schedules;
            }
            if ((i & 2) != 0) {
                list2 = data.constraints;
            }
            return data.copy(list, list2);
        }

        @NotNull
        public final List<AutomationSchedule> component1() {
            return this.schedules;
        }

        @Nullable
        public final List<FrequencyConstraint> component2() {
            return this.constraints;
        }

        @NotNull
        public final Data copy(@NotNull List<AutomationSchedule> schedules, @Nullable List<FrequencyConstraint> constraints) {
            Intrinsics.checkNotNullParameter(schedules, "schedules");
            return new Data(schedules, constraints);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.schedules, data.schedules) && Intrinsics.areEqual(this.constraints, data.constraints);
        }

        public int hashCode() {
            int iHashCode = this.schedules.hashCode() * 31;
            List list = this.constraints;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        @NotNull
        public String toString() {
            return "Data(schedules=" + this.schedules + ", constraints=" + this.constraints + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Data(@NotNull List<AutomationSchedule> schedules, @Nullable List<FrequencyConstraint> list) {
            Intrinsics.checkNotNullParameter(schedules, "schedules");
            this.schedules = schedules;
            this.constraints = list;
        }

        @NotNull
        public final List<AutomationSchedule> getSchedules() {
            return this.schedules;
        }

        @Nullable
        public final List<FrequencyConstraint> getConstraints() {
            return this.constraints;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/automation/remotedata/InAppRemoteData$Data$Companion;", "", "()V", "CONSTRAINTS", "", "SCHEDULES", "fromJson", "Lcom/urbanairship/automation/remotedata/InAppRemoteData$Data;", "value", "Lcom/urbanairship/json/JsonMap;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nAutomationRemoteDataAccess.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/InAppRemoteData$Data$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n1603#2,9:273\n1855#2:282\n1856#2:284\n1612#2:285\n1549#2:286\n1620#2,3:287\n1#3:283\n*S KotlinDebug\n*F\n+ 1 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/InAppRemoteData$Data$Companion\n*L\n197#1:273,9\n197#1:282\n197#1:284\n197#1:285\n205#1:286\n205#1:287,3\n197#1:283\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Data fromJson(@NotNull JsonMap value) throws JsonException {
                ArrayList arrayList;
                JsonList jsonListRequireList;
                Intrinsics.checkNotNullParameter(value, "value");
                JsonList jsonListRequireList2 = value.require("in_app_messages").requireList();
                Intrinsics.checkNotNullExpressionValue(jsonListRequireList2, "requireList(...)");
                ArrayList arrayList2 = new ArrayList();
                Iterator<JsonValue> it = jsonListRequireList2.iterator();
                while (true) {
                    arrayList = null;
                    AutomationSchedule automationScheduleFromJson = null;
                    arrayList = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    final JsonValue next = it.next();
                    try {
                        AutomationSchedule.Companion companion = AutomationSchedule.INSTANCE;
                        Intrinsics.checkNotNull(next);
                        automationScheduleFromJson = companion.fromJson(next);
                    } catch (Exception e) {
                        UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.remotedata.InAppRemoteData$Data$Companion$fromJson$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to parse a schedule from " + next;
                            }
                        });
                    }
                    if (automationScheduleFromJson != null) {
                        arrayList2.add(automationScheduleFromJson);
                    }
                }
                JsonValue jsonValue = value.get("frequency_constraints");
                if (jsonValue != null && (jsonListRequireList = jsonValue.requireList()) != null) {
                    FrequencyConstraint.Companion companion2 = FrequencyConstraint.INSTANCE;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                    Iterator<JsonValue> it2 = jsonListRequireList.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(companion2.fromJson(it2.next()));
                    }
                }
                return new Data(arrayList2, arrayList);
            }
        }

        @NotNull
        public final Data copyWithUpdateSchedules(@NotNull Function1<? super AutomationSchedule, AutomationSchedule> updateBlock) {
            Intrinsics.checkNotNullParameter(updateBlock, "updateBlock");
            List list = this.schedules;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(updateBlock.invoke(it.next()));
            }
            return new Data(arrayList, this.constraints);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/automation/remotedata/InAppRemoteData$Payload;", "", "data", "Lcom/urbanairship/automation/remotedata/InAppRemoteData$Data;", "timestamp", "", "remoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "(Lcom/urbanairship/automation/remotedata/InAppRemoteData$Data;JLcom/urbanairship/remotedata/RemoteDataInfo;)V", "getData", "()Lcom/urbanairship/automation/remotedata/InAppRemoteData$Data;", "getRemoteDataInfo", "()Lcom/urbanairship/remotedata/RemoteDataInfo;", "getTimestamp", "()J", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Payload {
        private final Data data;
        private final RemoteDataInfo remoteDataInfo;
        private final long timestamp;

        public static /* synthetic */ Payload copy$default(Payload payload, Data data, long j, RemoteDataInfo remoteDataInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                data = payload.data;
            }
            if ((i & 2) != 0) {
                j = payload.timestamp;
            }
            if ((i & 4) != 0) {
                remoteDataInfo = payload.remoteDataInfo;
            }
            return payload.copy(data, j, remoteDataInfo);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Data getData() {
            return this.data;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final RemoteDataInfo getRemoteDataInfo() {
            return this.remoteDataInfo;
        }

        @NotNull
        public final Payload copy(@NotNull Data data, long timestamp, @Nullable RemoteDataInfo remoteDataInfo) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new Payload(data, timestamp, remoteDataInfo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Payload)) {
                return false;
            }
            Payload payload = (Payload) other;
            return Intrinsics.areEqual(this.data, payload.data) && this.timestamp == payload.timestamp && Intrinsics.areEqual(this.remoteDataInfo, payload.remoteDataInfo);
        }

        public int hashCode() {
            int iHashCode = ((this.data.hashCode() * 31) + Long.hashCode(this.timestamp)) * 31;
            RemoteDataInfo remoteDataInfo = this.remoteDataInfo;
            return iHashCode + (remoteDataInfo == null ? 0 : remoteDataInfo.hashCode());
        }

        @NotNull
        public String toString() {
            return "Payload(data=" + this.data + ", timestamp=" + this.timestamp + ", remoteDataInfo=" + this.remoteDataInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Payload(@NotNull Data data, long j, @Nullable RemoteDataInfo remoteDataInfo) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.timestamp = j;
            this.remoteDataInfo = remoteDataInfo;
        }

        public /* synthetic */ Payload(Data data, long j, RemoteDataInfo remoteDataInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(data, j, (i & 4) != 0 ? null : remoteDataInfo);
        }

        @NotNull
        public final Data getData() {
            return this.data;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        public final RemoteDataInfo getRemoteDataInfo() {
            return this.remoteDataInfo;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/remotedata/InAppRemoteData$Companion;", "", "()V", "LEGACY_REMOTE_INFO_METADATA_KEY", "", "REMOTE_INFO_METADATA_KEY", "fromPayloads", "Lcom/urbanairship/automation/remotedata/InAppRemoteData;", "payloads", "", "Lcom/urbanairship/remotedata/RemoteDataPayload;", "parse", "Lcom/urbanairship/automation/remotedata/InAppRemoteData$Payload;", "payload", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationRemoteDataAccess.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/InAppRemoteData$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,272:1\n1855#2,2:273\n*S KotlinDebug\n*F\n+ 1 AutomationRemoteDataAccess.kt\ncom/urbanairship/automation/remotedata/InAppRemoteData$Companion\n*L\n230#1:273,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final InAppRemoteData fromPayloads(@NotNull List<RemoteDataPayload> payloads) {
            RemoteDataSource source;
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (RemoteDataPayload remoteDataPayload : payloads) {
                RemoteDataInfo remoteDataInfo = remoteDataPayload.getRemoteDataInfo();
                if (remoteDataInfo == null || (source = remoteDataInfo.getSource()) == null) {
                    source = RemoteDataSource.APP;
                }
                linkedHashMap.put(source, InAppRemoteData.INSTANCE.parse(remoteDataPayload));
            }
            return new InAppRemoteData(linkedHashMap);
        }

        private final Payload parse(RemoteDataPayload payload) {
            final JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to(InAppRemoteData.LEGACY_REMOTE_INFO_METADATA_KEY, ""), TuplesKt.to(InAppRemoteData.REMOTE_INFO_METADATA_KEY, payload.getRemoteDataInfo())).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return new Payload(Data.INSTANCE.fromJson(payload.getData()).copyWithUpdateSchedules(new Function1() { // from class: com.urbanairship.automation.remotedata.InAppRemoteData$Companion$parse$data$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AutomationSchedule invoke(AutomationSchedule local) {
                    Intrinsics.checkNotNullParameter(local, "local");
                    AutomationSchedule automationScheduleM2771copyWithtrFcsSw$urbanairship_automation_release$default = AutomationSchedule.m2771copyWithtrFcsSw$urbanairship_automation_release$default(local, null, null, jsonValue, 3, null);
                    if (automationScheduleM2771copyWithtrFcsSw$urbanairship_automation_release$default.getData() instanceof AutomationSchedule.ScheduleData.InAppMessageData) {
                        ((AutomationSchedule.ScheduleData.InAppMessageData) automationScheduleM2771copyWithtrFcsSw$urbanairship_automation_release$default.getData()).getMessage().setSource$urbanairship_automation_release(InAppMessage.Source.REMOTE_DATA);
                    }
                    return automationScheduleM2771copyWithtrFcsSw$urbanairship_automation_release$default;
                }
            }), payload.getTimestamp(), payload.getRemoteDataInfo());
        }
    }
}
