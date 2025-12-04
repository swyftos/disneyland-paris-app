package com.urbanairship.actions.tags;

import androidx.annotation.CallSuper;
import androidx.annotation.OpenForTesting;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionRegistry;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.channel.TagEditor;
import com.urbanairship.channel.TagGroupsEditor;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B1\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000f0\rH\u0017J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000fH\u0017J\"\u0010\u0011\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000f0\rH\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/actions/tags/AddTagsAction;", "Lcom/urbanairship/actions/tags/BaseTagsAction;", "()V", "channelTagEditor", "Lkotlin/Function0;", "Lcom/urbanairship/channel/TagEditor;", "channelTagGroupEditor", "Lcom/urbanairship/channel/TagGroupsEditor;", "contactTagGroupEditor", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "applyChannelTagGroups", "", FetchDeviceInfoAction.TAGS_KEY, "", "", "", "applyChannelTags", "applyContactTagGroups", "AddTagsPredicate", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@OpenForTesting
@SourceDebugExtension({"SMAP\nAddTagsAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddTagsAction.kt\ncom/urbanairship/actions/tags/AddTagsAction\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,107:1\n215#2,2:108\n215#2,2:110\n*S KotlinDebug\n*F\n+ 1 AddTagsAction.kt\ncom/urbanairship/actions/tags/AddTagsAction\n*L\n68#1:108,2\n78#1:110,2\n*E\n"})
/* loaded from: classes4.dex */
public final class AddTagsAction extends BaseTagsAction {

    @NotNull
    public static final String DEFAULT_REGISTRY_NAME = "add_tags_action";

    @NotNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^+t";
    private final Function0 channelTagEditor;
    private final Function0 channelTagGroupEditor;
    private final Function0 contactTagGroupEditor;

    public AddTagsAction(@NotNull Function0<? extends TagEditor> channelTagEditor, @NotNull Function0<? extends TagGroupsEditor> channelTagGroupEditor, @NotNull Function0<? extends TagGroupsEditor> contactTagGroupEditor) {
        Intrinsics.checkNotNullParameter(channelTagEditor, "channelTagEditor");
        Intrinsics.checkNotNullParameter(channelTagGroupEditor, "channelTagGroupEditor");
        Intrinsics.checkNotNullParameter(contactTagGroupEditor, "contactTagGroupEditor");
        this.channelTagEditor = channelTagEditor;
        this.channelTagGroupEditor = channelTagGroupEditor;
        this.contactTagGroupEditor = contactTagGroupEditor;
    }

    public AddTagsAction() {
        this(new Function0() { // from class: com.urbanairship.actions.tags.AddTagsAction.1
            @Override // kotlin.jvm.functions.Function0
            public final TagEditor invoke() {
                return UAirship.shared().getChannel().editTags();
            }
        }, new Function0() { // from class: com.urbanairship.actions.tags.AddTagsAction.2
            @Override // kotlin.jvm.functions.Function0
            public final TagGroupsEditor invoke() {
                return UAirship.shared().getChannel().editTagGroups();
            }
        }, new Function0() { // from class: com.urbanairship.actions.tags.AddTagsAction.3
            @Override // kotlin.jvm.functions.Function0
            public final TagGroupsEditor invoke() {
                return UAirship.shared().getContact().editTagGroups();
            }
        });
    }

    @Override // com.urbanairship.actions.tags.BaseTagsAction
    @CallSuper
    /* renamed from: applyChannelTags, reason: merged with bridge method [inline-methods] */
    public void applyChannelTags$urbanairship_core_release(@NotNull Set<String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        UALog.i("Adding tags: %s", tags);
        ((TagEditor) this.channelTagEditor.invoke()).addTags(tags).apply();
    }

    @Override // com.urbanairship.actions.tags.BaseTagsAction
    @CallSuper
    /* renamed from: applyChannelTagGroups, reason: merged with bridge method [inline-methods] */
    public void applyChannelTagGroups$urbanairship_core_release(@NotNull Map<String, ? extends Set<String>> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        UALog.i("Adding channel tag groups: %s", tags);
        TagGroupsEditor tagGroupsEditor = (TagGroupsEditor) this.channelTagGroupEditor.invoke();
        for (Map.Entry<String, ? extends Set<String>> entry : tags.entrySet()) {
            tagGroupsEditor.addTags(entry.getKey(), entry.getValue());
        }
        tagGroupsEditor.apply();
    }

    @Override // com.urbanairship.actions.tags.BaseTagsAction
    @CallSuper
    /* renamed from: applyContactTagGroups, reason: merged with bridge method [inline-methods] */
    public void applyContactTagGroups$urbanairship_core_release(@NotNull Map<String, ? extends Set<String>> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        UALog.i("Adding contact user tag groups: %s", tags);
        TagGroupsEditor tagGroupsEditor = (TagGroupsEditor) this.contactTagGroupEditor.invoke();
        for (Map.Entry<String, ? extends Set<String>> entry : tags.entrySet()) {
            tagGroupsEditor.addTags(entry.getKey(), entry.getValue());
        }
        tagGroupsEditor.apply();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/actions/tags/AddTagsAction$AddTagsPredicate;", "Lcom/urbanairship/actions/ActionRegistry$Predicate;", "()V", "apply", "", "arguments", "Lcom/urbanairship/actions/ActionArguments;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AddTagsPredicate implements ActionRegistry.Predicate {
        @Override // com.urbanairship.actions.ActionRegistry.Predicate
        public boolean apply(@NotNull ActionArguments arguments) {
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            return 1 != arguments.getSituation();
        }
    }
}
