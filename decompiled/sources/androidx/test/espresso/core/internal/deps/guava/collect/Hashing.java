package androidx.test.espresso.core.internal.deps.guava.collect;

/* loaded from: classes2.dex */
abstract class Hashing {
    static int smear(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    static int smearedHash(Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
