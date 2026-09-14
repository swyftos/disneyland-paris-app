package com.google.firebase.iid;

/* JADX INFO: loaded from: classes4.dex */
final class InstanceIdResultImpl implements InstanceIdResult {

    /* JADX INFO: renamed from: id */
    private final String f3568id;
    private final String token;

    InstanceIdResultImpl(String str, String str2) {
        this.f3568id = str;
        this.token = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getId() {
        return this.f3568id;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getToken() {
        return this.token;
    }
}
