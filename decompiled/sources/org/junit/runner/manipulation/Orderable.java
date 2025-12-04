package org.junit.runner.manipulation;

/* loaded from: classes6.dex */
public interface Orderable extends Sortable {
    void order(Orderer orderer) throws InvalidOrderingException;
}
