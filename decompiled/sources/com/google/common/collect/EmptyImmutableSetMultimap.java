package com.google.common.collect;

/* loaded from: classes4.dex */
class EmptyImmutableSetMultimap extends ImmutableSetMultimap {
    static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableSetMultimap() {
        super(ImmutableMap.of(), 0, null);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableMap asMap() {
        return super.asMap();
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
