package org.junit.runner.manipulation;

/* JADX INFO: loaded from: classes4.dex */
public interface Orderable extends Sortable {
    void order(Orderer orderer) throws InvalidOrderingException;
}
