package androidx.camera.extensions.internal;

/* JADX INFO: loaded from: classes.dex */
public interface VendorProcessor {
    void close();

    default void onDeInit() {
    }

    default void onInit() {
    }
}
