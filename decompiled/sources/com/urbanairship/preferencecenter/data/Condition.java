package com.urbanairship.preferencecenter.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0003\u000e\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH\u0004J\r\u0010\u000b\u001a\u00020\fH ¢\u0006\u0002\b\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0001\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Condition;", "", "type", "", "(Ljava/lang/String;)V", "evaluate", "", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/preferencecenter/data/Condition$State;", "jsonMapBuilder", "Lcom/urbanairship/json/JsonMap$Builder;", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "Companion", "OptInStatus", "State", "Lcom/urbanairship/preferencecenter/data/Condition$OptInStatus;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class Condition {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String type;

    public /* synthetic */ Condition(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public abstract boolean evaluate(@NotNull State state);

    @NotNull
    public abstract JsonMap toJson$urbanairship_preference_center_release();

    private Condition(String str) {
        this.type = str;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\r\u0010\u0012\u001a\u00020\u0013H\u0010¢\u0006\u0002\b\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Condition$OptInStatus;", "Lcom/urbanairship/preferencecenter/data/Condition;", "status", "Lcom/urbanairship/preferencecenter/data/Condition$OptInStatus$Status;", "(Lcom/urbanairship/preferencecenter/data/Condition$OptInStatus$Status;)V", "getStatus", "()Lcom/urbanairship/preferencecenter/data/Condition$OptInStatus$Status;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "evaluate", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/preferencecenter/data/Condition$State;", "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "", "Status", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class OptInStatus extends Condition {
        private final Status status;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Status.values().length];
                try {
                    iArr[Status.OPT_IN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Status.OPT_OUT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public static /* synthetic */ OptInStatus copy$default(OptInStatus optInStatus, Status status, int i, Object obj) {
            if ((i & 1) != 0) {
                status = optInStatus.status;
            }
            return optInStatus.copy(status);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Status getStatus() {
            return this.status;
        }

        @NotNull
        public final OptInStatus copy(@NotNull Status status) {
            Intrinsics.checkNotNullParameter(status, "status");
            return new OptInStatus(status);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OptInStatus) && this.status == ((OptInStatus) other).status;
        }

        public int hashCode() {
            return this.status.hashCode();
        }

        @NotNull
        public String toString() {
            return "OptInStatus(status=" + this.status + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final Status getStatus() {
            return this.status;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OptInStatus(@NotNull Status status) {
            super("notification_opt_in", null);
            Intrinsics.checkNotNullParameter(status, "status");
            this.status = status;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Condition$OptInStatus$Status;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "OPT_IN", "OPT_OUT", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Status {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Status[] $VALUES;

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE;
            public static final Status OPT_IN = new Status("OPT_IN", 0, "opt_in");
            public static final Status OPT_OUT = new Status("OPT_OUT", 1, "opt_out");
            private final String jsonValue;

            private static final /* synthetic */ Status[] $values() {
                return new Status[]{OPT_IN, OPT_OUT};
            }

            @NotNull
            public static EnumEntries<Status> getEntries() {
                return $ENTRIES;
            }

            public static Status valueOf(String str) {
                return (Status) Enum.valueOf(Status.class, str);
            }

            public static Status[] values() {
                return (Status[]) $VALUES.clone();
            }

            private Status(String str, int i, String str2) {
                this.jsonValue = str2;
            }

            @NotNull
            public final String getJsonValue() {
                return this.jsonValue;
            }

            static {
                Status[] statusArr$values = $values();
                $VALUES = statusArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
                INSTANCE = new Companion(null);
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Condition$OptInStatus$Status$Companion;", "", "()V", "parse", "Lcom/urbanairship/preferencecenter/data/Condition$OptInStatus$Status;", "json", "", "parse$urbanairship_preference_center_release", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final Status parse$urbanairship_preference_center_release(@NotNull String json) {
                    Intrinsics.checkNotNullParameter(json, "json");
                    String upperCase = json.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    return Status.valueOf(upperCase);
                }
            }
        }

        @Override // com.urbanairship.preferencecenter.data.Condition
        public boolean evaluate(@NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            int i = WhenMappings.$EnumSwitchMapping$0[this.status.ordinal()];
            if (i == 1) {
                return state.isOptedIn();
            }
            if (i == 2) {
                return !state.isOptedIn();
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.urbanairship.preferencecenter.data.Condition
        @NotNull
        public JsonMap toJson$urbanairship_preference_center_release() {
            JsonMap jsonMapBuild = jsonMapBuilder().put("when_status", this.status.getJsonValue()).build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Condition$State;", "Landroid/os/Parcelable;", "isOptedIn", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class State implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<State> CREATOR = new Creator();
        private final boolean isOptedIn;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<State> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new State(parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        public static /* synthetic */ State copy$default(State state, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.isOptedIn;
            }
            return state.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsOptedIn() {
            return this.isOptedIn;
        }

        @NotNull
        public final State copy(boolean isOptedIn) {
            return new State(isOptedIn);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && this.isOptedIn == ((State) other).isOptedIn;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isOptedIn);
        }

        @NotNull
        public String toString() {
            return "State(isOptedIn=" + this.isOptedIn + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.isOptedIn ? 1 : 0);
        }

        public State(boolean z) {
            this.isOptedIn = z;
        }

        public final boolean isOptedIn() {
            return this.isOptedIn;
        }
    }

    @NotNull
    protected final JsonMap.Builder jsonMapBuilder() {
        JsonMap.Builder builderPut = JsonMap.newBuilder().put("type", this.type);
        Intrinsics.checkNotNullExpressionValue(builderPut, "put(...)");
        return builderPut;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ!\u0010\t\u001a\f\u0012\u0004\u0012\u00020\n0\u000ej\u0002`\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Condition$Companion;", "", "()V", "KEY_STATUS", "", "KEY_TYPE", "TYPE_EMAIL_OPT_IN", "TYPE_NOTIFICATION_OPT_IN", "TYPE_SMS_OPT_IN", "parse", "Lcom/urbanairship/preferencecenter/data/Condition;", "json", "Lcom/urbanairship/json/JsonMap;", "parse$urbanairship_preference_center_release", "", "Lcom/urbanairship/preferencecenter/data/Conditions;", "Lcom/urbanairship/json/JsonValue;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nConditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Conditions.kt\ncom/urbanairship/preferencecenter/data/Condition$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n44#2,15:95\n44#2,15:111\n44#2,15:126\n1#3:110\n1549#4:141\n1620#4,3:142\n*S KotlinDebug\n*F\n+ 1 Conditions.kt\ncom/urbanairship/preferencecenter/data/Condition$Companion\n*L\n77#1:95,15\n80#1:111,15\n83#1:126,15\n91#1:141\n91#1:142,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Condition parse$urbanairship_preference_center_release(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            String strOptString2;
            String strOptString3;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get("type");
            String string = jsonValue != null ? jsonValue.getString() : null;
            if (string != null) {
                int iHashCode = string.hashCode();
                if (iHashCode != -310207529) {
                    if (iHashCode != 110431284) {
                        if (iHashCode == 1074464773 && string.equals("notification_opt_in")) {
                            JsonValue jsonValue2 = json.get("when_status");
                            if (jsonValue2 == null) {
                                throw new JsonException("Missing required field: 'when_status" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString3 = jsonValue2.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString3 = jsonValue2.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString3 = (String) Long.valueOf(jsonValue2.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString3 = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString3 = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString3 = (String) Integer.valueOf(jsonValue2.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                Object objOptList = jsonValue2.optList();
                                if (objOptList == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptList;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                Object objOptMap = jsonValue2.optMap();
                                if (objOptMap == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptMap;
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'when_status" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Object jsonValue3 = jsonValue2.toJsonValue();
                                if (jsonValue3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) jsonValue3;
                            }
                            return new OptInStatus(OptInStatus.Status.INSTANCE.parse$urbanairship_preference_center_release(strOptString3));
                        }
                    } else if (string.equals("email_opt_in")) {
                        JsonValue jsonValue4 = json.get("when_status");
                        if (jsonValue4 == null) {
                            throw new JsonException("Missing required field: 'when_status" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString2 = jsonValue4.optString();
                            if (strOptString2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString2 = jsonValue4.optString();
                            if (strOptString2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString2 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString2 = (String) Long.valueOf(jsonValue4.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString2 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString2 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString2 = (String) Integer.valueOf(jsonValue4.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            Object objOptList2 = jsonValue4.optList();
                            if (objOptList2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) objOptList2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            Object objOptMap2 = jsonValue4.optMap();
                            if (objOptMap2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) objOptMap2;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'when_status" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Object jsonValue5 = jsonValue4.toJsonValue();
                            if (jsonValue5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString2 = (String) jsonValue5;
                        }
                        return new OptInStatus(OptInStatus.Status.INSTANCE.parse$urbanairship_preference_center_release(strOptString2));
                    }
                } else if (string.equals("sms_opt_in")) {
                    JsonValue jsonValue6 = json.get("when_status");
                    if (jsonValue6 == null) {
                        throw new JsonException("Missing required field: 'when_status" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue6.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue6.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString = (String) Long.valueOf(jsonValue6.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue6.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList3 = jsonValue6.optList();
                        if (objOptList3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap3 = jsonValue6.optMap();
                        if (objOptMap3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap3;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'when_status" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue7 = jsonValue6.toJsonValue();
                        if (jsonValue7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue7;
                    }
                    return new OptInStatus(OptInStatus.Status.INSTANCE.parse$urbanairship_preference_center_release(strOptString));
                }
            }
            throw new JsonException("Unknown Condition type: '" + string + CoreConstants.SINGLE_QUOTE_CHAR);
        }

        @NotNull
        public final List<Condition> parse$urbanairship_preference_center_release(@Nullable JsonValue json) throws JsonException {
            JsonList list;
            if (json == null || (list = json.getList()) == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (JsonValue jsonValue : list) {
                Companion companion = Condition.INSTANCE;
                JsonMap jsonMapOptMap = jsonValue.optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                arrayList.add(companion.parse$urbanairship_preference_center_release(jsonMapOptMap));
            }
            return arrayList;
        }
    }
}
