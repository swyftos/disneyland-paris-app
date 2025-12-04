package com.urbanairship.channel;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public abstract class TagEditor {
    private boolean clear = false;
    private final Set tagsToAdd = new HashSet();
    private final Set tagsToRemove = new HashSet();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract void onApply(boolean z, @NonNull Set<String> set, @NonNull Set<String> set2);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected TagEditor() {
    }

    @NonNull
    public TagEditor addTag(@NonNull String str) {
        this.tagsToRemove.remove(str);
        this.tagsToAdd.add(str);
        return this;
    }

    @NonNull
    public TagEditor addTags(@NonNull Set<String> set) {
        this.tagsToRemove.removeAll(set);
        this.tagsToAdd.addAll(set);
        return this;
    }

    @NonNull
    public TagEditor removeTag(@NonNull String str) {
        this.tagsToAdd.remove(str);
        this.tagsToRemove.add(str);
        return this;
    }

    @NonNull
    public TagEditor removeTags(@NonNull Set<String> set) {
        this.tagsToAdd.removeAll(set);
        this.tagsToRemove.addAll(set);
        return this;
    }

    @NonNull
    public TagEditor clear() {
        this.clear = true;
        return this;
    }

    public void apply() {
        onApply(this.clear, this.tagsToAdd, this.tagsToRemove);
    }
}
