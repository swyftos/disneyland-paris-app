package com.urbanairship.preferencecenter.data;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.Section;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J9\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\r\u0010&\u001a\u00020'H\u0000¢\u0006\u0002\b(J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "", "id", "", "sections", "", "Lcom/urbanairship/preferencecenter/data/Section;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "(Ljava/lang/String;Ljava/util/List;Lcom/urbanairship/preferencecenter/data/CommonDisplay;)V", "options", "Lcom/urbanairship/preferencecenter/data/Options;", "(Ljava/lang/String;Ljava/util/List;Lcom/urbanairship/preferencecenter/data/CommonDisplay;Lcom/urbanairship/preferencecenter/data/Options;)V", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "hasChannelSubscriptions", "", "getHasChannelSubscriptions", "()Z", "hasContactManagement", "getHasContactManagement", "hasContactSubscriptions", "getHasContactSubscriptions", "getId", "()Ljava/lang/String;", "getOptions", "()Lcom/urbanairship/preferencecenter/data/Options;", "getSections", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPreferenceCenterConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferenceCenterConfig.kt\ncom/urbanairship/preferencecenter/data/PreferenceCenterConfig\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1549#2:92\n1620#2,3:93\n*S KotlinDebug\n*F\n+ 1 PreferenceCenterConfig.kt\ncom/urbanairship/preferencecenter/data/PreferenceCenterConfig\n*L\n73#1:92\n73#1:93,3\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class PreferenceCenterConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_ID = "id";
    private final CommonDisplay display;
    private final boolean hasChannelSubscriptions;
    private final boolean hasContactManagement;
    private final boolean hasContactSubscriptions;
    private final String id;
    private final Options options;
    private final List sections;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreferenceCenterConfig copy$default(PreferenceCenterConfig preferenceCenterConfig, String str, List list, CommonDisplay commonDisplay, Options options, int i, Object obj) {
        if ((i & 1) != 0) {
            str = preferenceCenterConfig.id;
        }
        if ((i & 2) != 0) {
            list = preferenceCenterConfig.sections;
        }
        if ((i & 4) != 0) {
            commonDisplay = preferenceCenterConfig.display;
        }
        if ((i & 8) != 0) {
            options = preferenceCenterConfig.options;
        }
        return preferenceCenterConfig.copy(str, list, commonDisplay, options);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<Section> component2() {
        return this.sections;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final CommonDisplay getDisplay() {
        return this.display;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Options getOptions() {
        return this.options;
    }

    @NotNull
    public final PreferenceCenterConfig copy(@NotNull String id, @NotNull List<? extends Section> sections, @NotNull CommonDisplay display, @Nullable Options options) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(display, "display");
        return new PreferenceCenterConfig(id, sections, display, options);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreferenceCenterConfig)) {
            return false;
        }
        PreferenceCenterConfig preferenceCenterConfig = (PreferenceCenterConfig) other;
        return Intrinsics.areEqual(this.id, preferenceCenterConfig.id) && Intrinsics.areEqual(this.sections, preferenceCenterConfig.sections) && Intrinsics.areEqual(this.display, preferenceCenterConfig.display) && Intrinsics.areEqual(this.options, preferenceCenterConfig.options);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.sections.hashCode()) * 31) + this.display.hashCode()) * 31;
        Options options = this.options;
        return iHashCode + (options == null ? 0 : options.hashCode());
    }

    @NotNull
    public String toString() {
        return "PreferenceCenterConfig(id=" + this.id + ", sections=" + this.sections + ", display=" + this.display + ", options=" + this.options + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PreferenceCenterConfig(@NotNull String id, @NotNull List<? extends Section> sections, @NotNull CommonDisplay display, @Nullable Options options) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(display, "display");
        this.id = id;
        this.sections = sections;
        this.display = display;
        this.options = options;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (Section section : sections) {
            z2 = section.getHasChannelSubscriptions$urbanairship_preference_center_release() || z2;
            z3 = section.getHasContactSubscriptions$urbanairship_preference_center_release() || z3;
            z = section.getHasContactManagement$urbanairship_preference_center_release() || z;
        }
        this.hasContactManagement = z;
        this.hasChannelSubscriptions = z2;
        this.hasContactSubscriptions = z3;
    }

    public /* synthetic */ PreferenceCenterConfig(String str, List list, CommonDisplay commonDisplay, Options options, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, commonDisplay, (i & 8) != 0 ? null : options);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<Section> getSections() {
        return this.sections;
    }

    @NotNull
    public final CommonDisplay getDisplay() {
        return this.display;
    }

    @Nullable
    public final Options getOptions() {
        return this.options;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreferenceCenterConfig(@NotNull String id, @NotNull List<? extends Section> sections, @NotNull CommonDisplay display) {
        this(id, sections, display, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(display, "display");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig$Companion;", "", "()V", "KEY_DISPLAY", "", "KEY_ID", "KEY_OPTIONS", "KEY_SECTIONS", "parse", "Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "json", "Lcom/urbanairship/json/JsonMap;", "parse$urbanairship_preference_center_release", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPreferenceCenterConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferenceCenterConfig.kt\ncom/urbanairship/preferencecenter/data/PreferenceCenterConfig$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n44#2,15:92\n1549#3:107\n1620#3,3:108\n1#4:111\n*S KotlinDebug\n*F\n+ 1 PreferenceCenterConfig.kt\ncom/urbanairship/preferencecenter/data/PreferenceCenterConfig$Companion\n*L\n38#1:92,15\n39#1:107\n39#1:108,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final PreferenceCenterConfig parse$urbanairship_preference_center_release(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            CommonDisplay empty;
            JsonMap map;
            JsonMap map2;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get("id");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.toJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            JsonList jsonListOptList = json.opt("sections").optList();
            Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
            for (JsonValue jsonValue3 : jsonListOptList) {
                Section.Companion companion = Section.INSTANCE;
                JsonMap jsonMapOptMap = jsonValue3.optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                arrayList.add(companion.parse$urbanairship_preference_center_release(jsonMapOptMap));
            }
            JsonValue jsonValue4 = json.get("display");
            if (jsonValue4 == null || (map2 = jsonValue4.getMap()) == null || (empty = CommonDisplay.INSTANCE.parse$urbanairship_preference_center_release(map2)) == null) {
                empty = CommonDisplay.INSTANCE.getEMPTY();
            }
            JsonValue jsonValue5 = json.get("options");
            return new PreferenceCenterConfig(strOptString, arrayList, empty, (jsonValue5 == null || (map = jsonValue5.getMap()) == null) ? null : Options.INSTANCE.parse$urbanairship_preference_center_release(map));
        }
    }

    public final boolean getHasChannelSubscriptions() {
        return this.hasChannelSubscriptions;
    }

    public final boolean getHasContactSubscriptions() {
        return this.hasContactSubscriptions;
    }

    public final boolean getHasContactManagement() {
        return this.hasContactManagement;
    }

    @NotNull
    public final JsonMap toJson$urbanairship_preference_center_release() throws JsonException {
        Pair pair = TuplesKt.to("id", this.id);
        List list = this.sections;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Section) it.next()).toJson$urbanairship_preference_center_release());
        }
        Pair pair2 = TuplesKt.to("sections", JsonExtensionsKt.toJsonList(arrayList));
        Pair pair3 = TuplesKt.to("display", this.display.toJson$urbanairship_preference_center_release());
        Options options = this.options;
        return JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, TuplesKt.to("options", options != null ? options.toJson$urbanairship_preference_center_release() : null));
    }
}
