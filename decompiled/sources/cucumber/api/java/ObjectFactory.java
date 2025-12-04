package cucumber.api.java;

@Deprecated
/* loaded from: classes5.dex */
public interface ObjectFactory {
    boolean addClass(Class<?> cls);

    <T> T getInstance(Class<T> cls);

    void start();

    void stop();
}
