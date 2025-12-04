package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class DependencyCycleException extends DependencyException {
    private final List componentsInCycle;

    public DependencyCycleException(List<Component<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    public List<Component<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
