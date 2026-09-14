package androidx.test.espresso.core.internal.deps.guava.collect;

/* JADX INFO: loaded from: classes2.dex */
abstract class Hashing {
    static int smear(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * (-862048943)), 15)) * 461845907);
    }

    static int smearedHash(Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
