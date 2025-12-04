package com.urbanairship.actions.tags;

import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.actions.Action;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.actions.tags.TagActionMutation;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J'\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00130\u0011H ¢\u0006\u0002\b\u0014J\u001b\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0013H ¢\u0006\u0002\b\u0016J'\u0010\u0017\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00130\u0011H ¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/actions/tags/BaseTagsAction;", "Lcom/urbanairship/actions/Action;", "()V", "mutableMutations", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/urbanairship/actions/tags/TagActionMutation;", "mutationsFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getMutationsFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "acceptsArguments", "", "arguments", "Lcom/urbanairship/actions/ActionArguments;", "applyChannelTagGroups", "", FetchDeviceInfoAction.TAGS_KEY, "", "", "", "applyChannelTagGroups$urbanairship_core_release", "applyChannelTags", "applyChannelTags$urbanairship_core_release", "applyContactTagGroups", "applyContactTagGroups$urbanairship_core_release", "perform", "Lcom/urbanairship/actions/ActionResult;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseTagsAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseTagsAction.kt\ncom/urbanairship/actions/tags/BaseTagsAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n1603#2,9:140\n1855#2:149\n1856#2:151\n1612#2:152\n1855#2:153\n1603#2,9:154\n1855#2:163\n1856#2:165\n1612#2:166\n1856#2:167\n1855#2:168\n1603#2,9:169\n1855#2:178\n1856#2:180\n1612#2:181\n1856#2:182\n1603#2,9:183\n1855#2:192\n1856#2:194\n1612#2:195\n1#3:150\n1#3:164\n1#3:179\n1#3:193\n*S KotlinDebug\n*F\n+ 1 BaseTagsAction.kt\ncom/urbanairship/actions/tags/BaseTagsAction\n*L\n49#1:140,9\n49#1:149\n49#1:151\n49#1:152\n60#1:153\n61#1:154,9\n61#1:163\n61#1:165\n61#1:166\n60#1:167\n75#1:168\n76#1:169,9\n76#1:178\n76#1:180\n76#1:181\n75#1:182\n89#1:183,9\n89#1:192\n89#1:194\n89#1:195\n49#1:150\n61#1:164\n76#1:179\n89#1:193\n*E\n"})
/* loaded from: classes4.dex */
public abstract class BaseTagsAction extends Action {
    private final MutableSharedFlow mutableMutations;
    private final SharedFlow mutationsFlow;

    public abstract void applyChannelTagGroups$urbanairship_core_release(@NotNull Map<String, ? extends Set<String>> tags);

    public abstract void applyChannelTags$urbanairship_core_release(@NotNull Set<String> tags);

    public abstract void applyContactTagGroups$urbanairship_core_release(@NotNull Map<String, ? extends Set<String>> tags);

    public BaseTagsAction() {
        MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.mutableMutations = mutableSharedFlowMutableSharedFlow$default;
        this.mutationsFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    @NotNull
    public final SharedFlow<TagActionMutation> getMutationsFlow() {
        return this.mutationsFlow;
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NotNull ActionArguments arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (arguments.getValue().isNull()) {
            return false;
        }
        return (arguments.getValue().getString() == null && arguments.getValue().getList() == null && arguments.getValue().getMap() == null) ? false : true;
    }

    @Override // com.urbanairship.actions.Action
    @NotNull
    public ActionResult perform(@NotNull ActionArguments arguments) {
        JsonValue jsonValue;
        JsonList jsonListOptList;
        JsonValue jsonValue2;
        JsonMap jsonMapOptMap;
        ArrayList arrayList;
        JsonValue jsonValue3;
        JsonMap jsonMapOptMap2;
        ArrayList arrayList2;
        Set<String> set;
        String string;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (arguments.getValue().getString() != null && (string = arguments.getValue().getString()) != null) {
            Set<String> of = SetsKt.setOf(string);
            applyChannelTags$urbanairship_core_release(of);
            this.mutableMutations.tryEmit(new TagActionMutation.ChannelTags(of));
        }
        if (arguments.getValue().getList() != null) {
            JsonList list = arguments.getValue().getList();
            if (list != null) {
                ArrayList arrayList3 = new ArrayList();
                Iterator<JsonValue> it = list.iterator();
                while (it.hasNext()) {
                    String string2 = it.next().getString();
                    if (string2 != null) {
                        arrayList3.add(string2);
                    }
                }
                set = CollectionsKt.toSet(arrayList3);
            } else {
                set = null;
            }
            if (set != null && !set.isEmpty()) {
                applyChannelTags$urbanairship_core_release(set);
                this.mutableMutations.tryEmit(new TagActionMutation.ChannelTags(set));
            }
        }
        if (arguments.getValue().getMap() != null) {
            JsonMap map = arguments.getValue().getMap();
            if (map != null && (jsonValue3 = map.get(TCVideoEventPropertiesNames.TCV_CHANNEL)) != null && (jsonMapOptMap2 = jsonValue3.optMap()) != null) {
                Map<String, ? extends Set<String>> linkedHashMap = new LinkedHashMap<>();
                for (Map.Entry<String, JsonValue> entry : jsonMapOptMap2) {
                    JsonList list2 = entry.getValue().getList();
                    if (list2 != null) {
                        Intrinsics.checkNotNull(list2);
                        arrayList2 = new ArrayList();
                        Iterator<JsonValue> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            String string3 = it2.next().getString();
                            if (string3 != null) {
                                arrayList2.add(string3);
                            }
                        }
                    } else {
                        arrayList2 = null;
                    }
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        String key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                        linkedHashMap.put(key, CollectionsKt.toSet(arrayList2));
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    applyChannelTagGroups$urbanairship_core_release(linkedHashMap);
                    this.mutableMutations.tryEmit(new TagActionMutation.ChannelTagGroups(linkedHashMap));
                }
            }
            JsonMap map2 = arguments.getValue().getMap();
            if (map2 != null && (jsonValue2 = map2.get(FetchDeviceInfoAction.NAMED_USER_ID_KEY)) != null && (jsonMapOptMap = jsonValue2.optMap()) != null) {
                Map<String, ? extends Set<String>> linkedHashMap2 = new LinkedHashMap<>();
                for (Map.Entry<String, JsonValue> entry2 : jsonMapOptMap) {
                    JsonList list3 = entry2.getValue().getList();
                    if (list3 != null) {
                        Intrinsics.checkNotNull(list3);
                        arrayList = new ArrayList();
                        Iterator<JsonValue> it3 = list3.iterator();
                        while (it3.hasNext()) {
                            String string4 = it3.next().getString();
                            if (string4 != null) {
                                arrayList.add(string4);
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        String key2 = entry2.getKey();
                        Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                        linkedHashMap2.put(key2, CollectionsKt.toSet(arrayList));
                    }
                }
                if (!linkedHashMap2.isEmpty()) {
                    applyContactTagGroups$urbanairship_core_release(linkedHashMap2);
                    this.mutableMutations.tryEmit(new TagActionMutation.ContactTagGroups(linkedHashMap2));
                }
            }
            JsonMap map3 = arguments.getValue().getMap();
            if (map3 != null && (jsonValue = map3.get("device")) != null && (jsonListOptList = jsonValue.optList()) != null) {
                ArrayList arrayList4 = new ArrayList();
                Iterator<JsonValue> it4 = jsonListOptList.iterator();
                while (it4.hasNext()) {
                    String string5 = it4.next().getString();
                    if (string5 != null) {
                        arrayList4.add(string5);
                    }
                }
                Set<String> set2 = CollectionsKt.toSet(arrayList4);
                if (!set2.isEmpty()) {
                    applyChannelTags$urbanairship_core_release(set2);
                    this.mutableMutations.tryEmit(new TagActionMutation.ChannelTags(set2));
                }
            }
        }
        ActionResult actionResultNewEmptyResult = ActionResult.newEmptyResult();
        Intrinsics.checkNotNullExpressionValue(actionResultNewEmptyResult, "newEmptyResult(...)");
        return actionResultNewEmptyResult;
    }
}
