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
import com.urbanairship.preferencecenter.data.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 +2\u00020\u0001:\u0003*+,B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010!\u001a\u00020\u00002\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00100#H\u0000¢\u0006\u0002\b$J\b\u0010%\u001a\u00020&H\u0004J\r\u0010'\u001a\u00020(H ¢\u0006\u0002\b)R\u001c\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00108@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00108@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0019\u0010\u0012R\u0012\u0010\u001b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0002-.¨\u0006/"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Section;", "", "type", "", "(Ljava/lang/String;)V", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "getConditions", "()Ljava/util/List;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "hasChannelSubscriptions", "", "getHasChannelSubscriptions$urbanairship_preference_center_release", "()Z", "hasChannelSubscriptions$delegate", "Lkotlin/Lazy;", "hasContactManagement", "getHasContactManagement$urbanairship_preference_center_release", "hasContactManagement$delegate", "hasContactSubscriptions", "getHasContactSubscriptions$urbanairship_preference_center_release", "hasContactSubscriptions$delegate", "id", "getId", "()Ljava/lang/String;", "items", "Lcom/urbanairship/preferencecenter/data/Item;", "getItems", "filterItems", "predicate", "Lkotlin/Function1;", "filterItems$urbanairship_preference_center_release", "jsonMapBuilder", "Lcom/urbanairship/json/JsonMap$Builder;", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "Common", "Companion", "SectionBreak", "Lcom/urbanairship/preferencecenter/data/Section$Common;", "Lcom/urbanairship/preferencecenter/data/Section$SectionBreak;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Section.kt\ncom/urbanairship/preferencecenter/data/Section\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,120:1\n766#2:121\n857#2,2:122\n1549#2:124\n1620#2,3:125\n1549#2:128\n1620#2,3:129\n*S KotlinDebug\n*F\n+ 1 Section.kt\ncom/urbanairship/preferencecenter/data/Section\n*L\n23#1:121\n23#1:122,2\n117#1:124\n117#1:125,3\n118#1:128\n118#1:129,3\n*E\n"})
/* loaded from: classes5.dex */
public abstract class Section {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: hasChannelSubscriptions$delegate, reason: from kotlin metadata */
    private final Lazy hasChannelSubscriptions;

    /* renamed from: hasContactManagement$delegate, reason: from kotlin metadata */
    private final Lazy hasContactManagement;

    /* renamed from: hasContactSubscriptions$delegate, reason: from kotlin metadata */
    private final Lazy hasContactSubscriptions;
    private final String type;

    public /* synthetic */ Section(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @NotNull
    public abstract List<Condition> getConditions();

    @NotNull
    public abstract CommonDisplay getDisplay();

    @NotNull
    public abstract String getId();

    @NotNull
    public abstract List<Item> getItems();

    @NotNull
    public abstract JsonMap toJson$urbanairship_preference_center_release();

    private Section(String str) {
        this.type = str;
        this.hasChannelSubscriptions = LazyKt.lazy(new Function0() { // from class: com.urbanairship.preferencecenter.data.Section$hasChannelSubscriptions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                List<Item> items = this.this$0.getItems();
                boolean z = false;
                if (items == null || !items.isEmpty()) {
                    Iterator<T> it = items.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((Item) it.next()).getHasChannelSubscriptions()) {
                            z = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
        this.hasContactSubscriptions = LazyKt.lazy(new Function0() { // from class: com.urbanairship.preferencecenter.data.Section$hasContactSubscriptions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                List<Item> items = this.this$0.getItems();
                boolean z = false;
                if (items == null || !items.isEmpty()) {
                    Iterator<T> it = items.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((Item) it.next()).getHasContactSubscriptions()) {
                            z = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
        this.hasContactManagement = LazyKt.lazy(new Function0() { // from class: com.urbanairship.preferencecenter.data.Section$hasContactManagement$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                List<Item> items = this.this$0.getItems();
                boolean z = false;
                if (items == null || !items.isEmpty()) {
                    Iterator<T> it = items.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((Item) it.next()).getHasContactManagement()) {
                            z = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Section filterItems$urbanairship_preference_center_release(@NotNull Function1<? super Item, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (!(this instanceof Common)) {
            if (this instanceof SectionBreak) {
                return this;
            }
            throw new NoWhenBranchMatchedException();
        }
        Common common = (Common) this;
        List<Item> items = getItems();
        ArrayList arrayList = new ArrayList();
        for (Object obj : items) {
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return Common.copy$default(common, null, arrayList, null, null, 13, null);
    }

    public final boolean getHasChannelSubscriptions$urbanairship_preference_center_release() {
        return ((Boolean) this.hasChannelSubscriptions.getValue()).booleanValue();
    }

    public final boolean getHasContactSubscriptions$urbanairship_preference_center_release() {
        return ((Boolean) this.hasContactSubscriptions.getValue()).booleanValue();
    }

    public final boolean getHasContactManagement$urbanairship_preference_center_release() {
        return ((Boolean) this.hasContactManagement.getValue()).booleanValue();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Section$Companion;", "", "()V", "KEY_CONDITIONS", "", "KEY_DISPLAY", "KEY_ID", "KEY_ITEMS", "KEY_TYPE", "TYPE_SECTION", "TYPE_SECTION_BREAK", "parse", "Lcom/urbanairship/preferencecenter/data/Section;", "json", "Lcom/urbanairship/json/JsonMap;", "parse$urbanairship_preference_center_release", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Section.kt\ncom/urbanairship/preferencecenter/data/Section$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,120:1\n44#2,15:121\n1549#3:136\n1620#3,3:137\n*S KotlinDebug\n*F\n+ 1 Section.kt\ncom/urbanairship/preferencecenter/data/Section$Companion\n*L\n86#1:121,15\n91#1:136\n91#1:137,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Section parse$urbanairship_preference_center_release(@NotNull JsonMap json) throws JsonException {
            String strOptString;
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
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            CommonDisplay commonDisplay = CommonDisplay.INSTANCE.parse$urbanairship_preference_center_release(json.get("display"));
            JsonValue jsonValue3 = json.get("type");
            String string = jsonValue3 != null ? jsonValue3.getString() : null;
            if (Intrinsics.areEqual(string, "section")) {
                JsonList jsonListOptList = json.opt("items").optList();
                Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
                for (JsonValue jsonValue4 : jsonListOptList) {
                    Item.Companion companion = Item.INSTANCE;
                    JsonMap jsonMapOptMap = jsonValue4.optMap();
                    Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                    arrayList.add(companion.parse$urbanairship_preference_center_release(jsonMapOptMap));
                }
                return new Common(strOptString, arrayList, commonDisplay, Condition.INSTANCE.parse$urbanairship_preference_center_release(json.get("conditions")));
            }
            if (Intrinsics.areEqual(string, "labeled_section_break")) {
                return new SectionBreak(strOptString, commonDisplay, Condition.INSTANCE.parse$urbanairship_preference_center_release(json.get("conditions")));
            }
            throw new JsonException("Unknown Preference Center Section type: '" + string + CoreConstants.SINGLE_QUOTE_CHAR);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b0\u0005j\u0007`\f¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u000b0\u0005j\u0007`\f¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0007HÆ\u0003JP\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0013\b\u0002\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b0\u0005j\u0007`\f¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\r\u0010 \u001a\u00020!H\u0010¢\u0006\u0002\b\"J\t\u0010#\u001a\u00020\u0003HÖ\u0001R(\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b0\u0005j\u0007`\f¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006$"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Section$Common;", "Lcom/urbanairship/preferencecenter/data/Section;", "id", "", "items", "", "Lcom/urbanairship/preferencecenter/data/Item;", "Lkotlinx/parcelize/RawValue;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "conditions", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "(Ljava/lang/String;Ljava/util/List;Lcom/urbanairship/preferencecenter/data/CommonDisplay;Ljava/util/List;)V", "getConditions", "()Ljava/util/List;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getId", "()Ljava/lang/String;", "getItems", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Common extends Section {
        private final List conditions;
        private final CommonDisplay display;
        private final String id;
        private final List items;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Common copy$default(Common common, String str, List list, CommonDisplay commonDisplay, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = common.id;
            }
            if ((i & 2) != 0) {
                list = common.items;
            }
            if ((i & 4) != 0) {
                commonDisplay = common.display;
            }
            if ((i & 8) != 0) {
                list2 = common.conditions;
            }
            return common.copy(str, list, commonDisplay, list2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final List<Item> component2() {
            return this.items;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final CommonDisplay getDisplay() {
            return this.display;
        }

        @NotNull
        public final List<Condition> component4() {
            return this.conditions;
        }

        @NotNull
        public final Common copy(@NotNull String id, @NotNull List<? extends Item> items, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            return new Common(id, items, display, conditions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Common)) {
                return false;
            }
            Common common = (Common) other;
            return Intrinsics.areEqual(this.id, common.id) && Intrinsics.areEqual(this.items, common.items) && Intrinsics.areEqual(this.display, common.display) && Intrinsics.areEqual(this.conditions, common.conditions);
        }

        public int hashCode() {
            return (((((this.id.hashCode() * 31) + this.items.hashCode()) * 31) + this.display.hashCode()) * 31) + this.conditions.hashCode();
        }

        @NotNull
        public String toString() {
            return "Common(id=" + this.id + ", items=" + this.items + ", display=" + this.display + ", conditions=" + this.conditions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public List<Item> getItems() {
            return this.items;
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public CommonDisplay getDisplay() {
            return this.display;
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public List<Condition> getConditions() {
            return this.conditions;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Common(@NotNull String id, @NotNull List<? extends Item> items, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            super("section", null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            this.id = id;
            this.items = items;
            this.display = display;
            this.conditions = conditions;
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public JsonMap toJson$urbanairship_preference_center_release() throws JsonException {
            JsonMap jsonMapBuild = jsonMapBuilder().build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b0\u0007j\u0007`\t¢\u0006\u0002\b\n¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\b0\u0007j\u0007`\t¢\u0006\u0002\b\n¢\u0006\u0002\b\nHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b0\u0007j\u0007`\t¢\u0006\u0002\b\n¢\u0006\u0002\b\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\r\u0010\u001f\u001a\u00020 H\u0010¢\u0006\u0002\b!J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R(\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b0\u0007j\u0007`\t¢\u0006\u0002\b\n¢\u0006\u0002\b\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Section$SectionBreak;", "Lcom/urbanairship/preferencecenter/data/Section;", "id", "", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "Lkotlinx/parcelize/RawValue;", "(Ljava/lang/String;Lcom/urbanairship/preferencecenter/data/CommonDisplay;Ljava/util/List;)V", "getConditions", "()Ljava/util/List;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getId", "()Ljava/lang/String;", "items", "Lcom/urbanairship/preferencecenter/data/Item;", "getItems", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SectionBreak extends Section {
        private final List conditions;
        private final CommonDisplay display;
        private final String id;
        private final List items;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SectionBreak copy$default(SectionBreak sectionBreak, String str, CommonDisplay commonDisplay, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sectionBreak.id;
            }
            if ((i & 2) != 0) {
                commonDisplay = sectionBreak.display;
            }
            if ((i & 4) != 0) {
                list = sectionBreak.conditions;
            }
            return sectionBreak.copy(str, commonDisplay, list);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final CommonDisplay getDisplay() {
            return this.display;
        }

        @NotNull
        public final List<Condition> component3() {
            return this.conditions;
        }

        @NotNull
        public final SectionBreak copy(@NotNull String id, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            return new SectionBreak(id, display, conditions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionBreak)) {
                return false;
            }
            SectionBreak sectionBreak = (SectionBreak) other;
            return Intrinsics.areEqual(this.id, sectionBreak.id) && Intrinsics.areEqual(this.display, sectionBreak.display) && Intrinsics.areEqual(this.conditions, sectionBreak.conditions);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.display.hashCode()) * 31) + this.conditions.hashCode();
        }

        @NotNull
        public String toString() {
            return "SectionBreak(id=" + this.id + ", display=" + this.display + ", conditions=" + this.conditions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public CommonDisplay getDisplay() {
            return this.display;
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public List<Condition> getConditions() {
            return this.conditions;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionBreak(@NotNull String id, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            super("labeled_section_break", null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            this.id = id;
            this.display = display;
            this.conditions = conditions;
            this.items = CollectionsKt.emptyList();
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public List<Item> getItems() {
            return this.items;
        }

        @Override // com.urbanairship.preferencecenter.data.Section
        @NotNull
        public JsonMap toJson$urbanairship_preference_center_release() throws JsonException {
            JsonMap jsonMapBuild = jsonMapBuilder().build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }
    }

    @NotNull
    protected final JsonMap.Builder jsonMapBuilder() throws JsonException {
        JsonMap.Builder builderPut = JsonMap.newBuilder().put("id", getId()).put("type", this.type).put("display", getDisplay().toJson$urbanairship_preference_center_release());
        List<Item> items = getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(((Item) it.next()).toJson$urbanairship_preference_center_release());
        }
        JsonMap.Builder builderPut2 = builderPut.put("items", JsonExtensionsKt.toJsonList(arrayList));
        List<Condition> conditions = getConditions();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(conditions, 10));
        Iterator<T> it2 = conditions.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Condition) it2.next()).toJson$urbanairship_preference_center_release());
        }
        JsonMap.Builder builderPut3 = builderPut2.put("conditions", JsonExtensionsKt.toJsonList(arrayList2));
        Intrinsics.checkNotNullExpressionValue(builderPut3, "put(...)");
        return builderPut3;
    }
}
