package com.google.common.collect;

/* loaded from: classes4.dex */
class EmptyImmutableListMultimap extends ImmutableListMultimap {
    static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableListMultimap() {
        super(ImmutableMap.of(), 0);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableMap asMap() {
        return super.asMap();
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
