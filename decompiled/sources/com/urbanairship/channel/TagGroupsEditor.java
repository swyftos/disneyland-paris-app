package com.urbanairship.channel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.UALog;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
public class TagGroupsEditor {
    private final List mutations = new ArrayList();

    protected boolean allowTagGroupChange(@NonNull String str) {
        return true;
    }

    protected void onApply(@NonNull List<TagGroupsMutation> list) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TagGroupsEditor() {
    }

    @NonNull
    public TagGroupsEditor addTag(@NonNull String str, @NonNull String str2) {
        return addTags(str, Collections.singleton(str2));
    }

    @NonNull
    public TagGroupsEditor addTags(@NonNull String str, @NonNull Set<String> set) {
        String strTrim = str.trim();
        if (UAStringUtil.isEmpty(strTrim)) {
            UALog.e("The tag group ID string cannot be null.", new Object[0]);
            return this;
        }
        if (!allowTagGroupChange(strTrim)) {
            return this;
        }
        Set setNormalizeTags = TagUtils.normalizeTags(set);
        if (setNormalizeTags.isEmpty()) {
            return this;
        }
        this.mutations.add(TagGroupsMutation.newAddTagsMutation(strTrim, setNormalizeTags));
        return this;
    }

    @NonNull
    public TagGroupsEditor setTag(@NonNull String str, @NonNull String str2) {
        return setTags(str, Collections.singleton(str2));
    }

    @NonNull
    public TagGroupsEditor setTags(@NonNull String str, @Nullable Set<String> set) {
        Set setNormalizeTags;
        String strTrim = str.trim();
        if (UAStringUtil.isEmpty(strTrim)) {
            UALog.e("The tag group ID string cannot be null.", new Object[0]);
            return this;
        }
        if (!allowTagGroupChange(strTrim)) {
            return this;
        }
        if (set == null) {
            setNormalizeTags = new HashSet();
        } else {
            setNormalizeTags = TagUtils.normalizeTags(set);
        }
        this.mutations.add(TagGroupsMutation.newSetTagsMutation(strTrim, setNormalizeTags));
        return this;
    }

    @NonNull
    public TagGroupsEditor removeTag(@NonNull String str, @NonNull String str2) {
        return removeTags(str, Collections.singleton(str2));
    }

    @NonNull
    public TagGroupsEditor removeTags(@NonNull String str, @NonNull Set<String> set) {
        String strTrim = str.trim();
        if (UAStringUtil.isEmpty(strTrim)) {
            UALog.e("The tag group ID string cannot be null.", new Object[0]);
            return this;
        }
        if (!allowTagGroupChange(strTrim)) {
            return this;
        }
        Set setNormalizeTags = TagUtils.normalizeTags(set);
        if (setNormalizeTags.isEmpty()) {
            return this;
        }
        this.mutations.add(TagGroupsMutation.newRemoveTagsMutation(strTrim, setNormalizeTags));
        return this;
    }

    public void apply() {
        onApply(TagGroupsMutation.collapseMutations(this.mutations));
    }
}
