package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
class SingletonImmutableTable extends ImmutableTable {
    final Object singleColumnKey;
    final Object singleRowKey;
    final Object singleValue;

    @Override // com.google.common.collect.Table
    public int size() {
        return 1;
    }

    SingletonImmutableTable(Object obj, Object obj2, Object obj3) {
        this.singleRowKey = Preconditions.checkNotNull(obj);
        this.singleColumnKey = Preconditions.checkNotNull(obj2);
        this.singleValue = Preconditions.checkNotNull(obj3);
    }

    SingletonImmutableTable(Table.Cell cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap column(Object obj) {
        Preconditions.checkNotNull(obj);
        if (containsColumn(obj)) {
            return ImmutableMap.m1536of(this.singleRowKey, this.singleValue);
        }
        return ImmutableMap.m1535of();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap columnMap() {
        return ImmutableMap.m1536of(this.singleColumnKey, ImmutableMap.m1536of(this.singleRowKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap rowMap() {
        return ImmutableMap.m1536of(this.singleRowKey, ImmutableMap.m1536of(this.singleColumnKey, this.singleValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public ImmutableSet createCellSet() {
        return ImmutableSet.m1564of(ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public ImmutableCollection createValues() {
        return ImmutableSet.m1564of(this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableTable
    @J2ktIncompatible
    @GwtIncompatible
    Object writeReplace() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }
}
