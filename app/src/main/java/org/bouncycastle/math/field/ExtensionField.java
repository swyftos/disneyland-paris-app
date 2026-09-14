package org.bouncycastle.math.field;

/* JADX INFO: loaded from: classes6.dex */
public interface ExtensionField extends FiniteField {
    int getDegree();

    FiniteField getSubfield();
}
