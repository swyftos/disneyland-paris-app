package com.amazonaws.services.p017s3.model;

import com.amazonaws.services.p017s3.model.inventory.InventoryConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class GetBucketInventoryConfigurationResult {
    private InventoryConfiguration inventoryConfiguration;

    public InventoryConfiguration getInventoryConfiguration() {
        return this.inventoryConfiguration;
    }

    public void setInventoryConfiguration(InventoryConfiguration inventoryConfiguration) {
        this.inventoryConfiguration = inventoryConfiguration;
    }

    public GetBucketInventoryConfigurationResult withInventoryConfiguration(InventoryConfiguration inventoryConfiguration) {
        setInventoryConfiguration(inventoryConfiguration);
        return this;
    }
}
