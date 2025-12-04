package androidx.test.espresso.remote;

/* loaded from: classes2.dex */
public interface EspressoRemoteMessage {

    public interface From<T, M> {
        T fromProto(M m);
    }

    public interface To<M> {
        M toProto();
    }
}
