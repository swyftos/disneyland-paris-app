package expo.modules.interfaces.permissions;

/* JADX INFO: loaded from: classes5.dex */
public enum PermissionsStatus {
    GRANTED(PermissionsResponse.GRANTED_KEY),
    UNDETERMINED("undetermined"),
    DENIED("denied");

    private final String status;

    PermissionsStatus(String str) {
        this.status = str;
    }

    public String getStatus() {
        return this.status;
    }
}
