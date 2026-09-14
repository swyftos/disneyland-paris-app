package coil3.content;

import coil3.size.Size;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableHardwareBitmapService implements HardwareBitmapService {
    private final boolean allowHardware;

    public ImmutableHardwareBitmapService(boolean z) {
        this.allowHardware = z;
    }

    @Override // coil3.content.HardwareBitmapService
    public boolean allowHardwareMainThread(Size size) {
        return this.allowHardware;
    }

    @Override // coil3.content.HardwareBitmapService
    public boolean allowHardwareWorkerThread() {
        return this.allowHardware;
    }
}
