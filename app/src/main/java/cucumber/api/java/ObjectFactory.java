package cucumber.api.java;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface ObjectFactory {
    boolean addClass(Class<?> cls);

    <T> T getInstance(Class<T> cls);

    void start();

    void stop();
}
