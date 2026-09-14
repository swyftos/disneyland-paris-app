package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    EmptyRequestManagerTreeNode() {
    }

    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    public Set getDescendants() {
        return Collections.emptySet();
    }
}
