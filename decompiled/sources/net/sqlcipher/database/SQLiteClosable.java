package net.sqlcipher.database;

/* loaded from: classes6.dex */
public abstract class SQLiteClosable {
    private int mReferenceCount = 1;
    private Object mLock = new Object();

    protected abstract void onAllReferencesReleased();

    protected void onAllReferencesReleasedFromContainer() {
    }

    public void acquireReference() {
        synchronized (this.mLock) {
            try {
                int i = this.mReferenceCount;
                if (i <= 0) {
                    throw new IllegalStateException("attempt to re-open an already-closed object: " + getObjInfo());
                }
                this.mReferenceCount = i + 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void releaseReference() {
        synchronized (this.mLock) {
            try {
                int i = this.mReferenceCount - 1;
                this.mReferenceCount = i;
                if (i == 0) {
                    onAllReferencesReleased();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void releaseReferenceFromContainer() {
        synchronized (this.mLock) {
            try {
                int i = this.mReferenceCount - 1;
                this.mReferenceCount = i;
                if (i == 0) {
                    onAllReferencesReleasedFromContainer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private String getObjInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" (");
        if (this instanceof SQLiteDatabase) {
            sb.append("database = ");
            sb.append(((SQLiteDatabase) this).getPath());
        } else if ((this instanceof SQLiteProgram) || (this instanceof SQLiteStatement) || (this instanceof SQLiteQuery)) {
            sb.append("mSql = ");
            sb.append(((SQLiteProgram) this).mSql);
        }
        sb.append(") ");
        return sb.toString();
    }
}
