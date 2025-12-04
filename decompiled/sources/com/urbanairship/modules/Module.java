package com.urbanairship.modules;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import com.urbanairship.AirshipComponent;
import com.urbanairship.actions.ActionRegistry;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class Module {
    private final int actionsXmlId;
    private final Set components;

    protected Module(@NonNull Set<? extends AirshipComponent> set) {
        this(set, 0);
    }

    protected Module(@NonNull Set<? extends AirshipComponent> set, @XmlRes int i) {
        this.components = set;
        this.actionsXmlId = i;
    }

    @NonNull
    public static Module singleComponent(@NonNull AirshipComponent airshipComponent, @XmlRes int i) {
        return new Module(Collections.singleton(airshipComponent), i);
    }

    @NonNull
    public static Module multipleComponents(@NonNull Collection<AirshipComponent> collection, @XmlRes int i) {
        return new Module(new HashSet(collection), i);
    }

    @NonNull
    public Set<? extends AirshipComponent> getComponents() {
        return this.components;
    }

    public void registerActions(@NonNull Context context, @NonNull ActionRegistry actionRegistry) {
        int i = this.actionsXmlId;
        if (i != 0) {
            actionRegistry.registerActions(context, i);
        }
    }
}
