package androidx.test.espresso.remote;

/* JADX INFO: loaded from: classes2.dex */
public interface EspressoRemoteMessage {

    public interface From<T, M> {
        T fromProto(M m);
    }

    /* JADX INFO: renamed from: androidx.test.espresso.remote.EspressoRemoteMessage$To */
    public interface InterfaceC1427To<M> {
        M toProto();
    }
}
