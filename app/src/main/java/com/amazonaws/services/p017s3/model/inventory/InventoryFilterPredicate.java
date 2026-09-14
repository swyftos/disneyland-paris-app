package com.amazonaws.services.p017s3.model.inventory;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InventoryFilterPredicate implements Serializable {
    public abstract void accept(InventoryPredicateVisitor inventoryPredicateVisitor);
}
