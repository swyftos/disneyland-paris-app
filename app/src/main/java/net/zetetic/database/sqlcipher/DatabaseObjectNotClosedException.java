package net.zetetic.database.sqlcipher;

/* JADX INFO: loaded from: classes6.dex */
public class DatabaseObjectNotClosedException extends RuntimeException {
    public DatabaseObjectNotClosedException() {
        super("Application did not close the cursor or database object that was opened here");
    }
}
