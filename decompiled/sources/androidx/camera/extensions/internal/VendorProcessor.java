package androidx.camera.extensions.internal;

/* loaded from: classes.dex */
public interface VendorProcessor {
    void close();

    default void onDeInit() {
    }

    default void onInit() {
    }
}
