package com.google.common.collect;

import com.google.common.base.Predicate;

/* loaded from: classes4.dex */
interface FilteredMultimap extends Multimap {
    Predicate entryPredicate();

    Multimap unfiltered();
}
