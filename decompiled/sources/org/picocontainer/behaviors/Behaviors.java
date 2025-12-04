package org.picocontainer.behaviors;

import org.picocontainer.BehaviorFactory;

/* loaded from: classes6.dex */
public class Behaviors {
    public static BehaviorFactory implementationHiding() {
        return new ImplementationHiding();
    }

    public static BehaviorFactory caching() {
        return new Caching();
    }

    public static BehaviorFactory synchronizing() {
        return new Synchronizing();
    }

    public static BehaviorFactory locking() {
        return new Locking();
    }

    public static BehaviorFactory propertyApplying() {
        return new PropertyApplying();
    }

    public static BehaviorFactory automatic() {
        return new Automating();
    }
}
