package net.sqlcipher.database;

/* loaded from: classes6.dex */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
