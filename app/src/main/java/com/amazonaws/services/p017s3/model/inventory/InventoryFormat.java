package com.amazonaws.services.p017s3.model.inventory;

/* JADX INFO: loaded from: classes2.dex */
public enum InventoryFormat {
    CSV("CSV");

    private final String format;

    InventoryFormat(String str) {
        this.format = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.format;
    }
}
