package bolts;

/* loaded from: classes2.dex */
public class Capture<T> {
    private Object value;

    public Capture() {
    }

    public Capture(T t) {
        this.value = t;
    }

    public T get() {
        return (T) this.value;
    }

    public void set(T t) {
        this.value = t;
    }
}
