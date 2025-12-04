package androidx.test.rule.provider;

import android.util.Log;
import java.io.File;

/* loaded from: classes2.dex */
final class DatabaseArgs {
    private File dBCmdFile;
    private String[] dBCmds;
    private File dBDataFile;
    private String dBName;

    public DatabaseArgs(String str) {
        this.dBName = str;
    }

    public void setDBCmds(String... strArr) {
        if (this.dBCmds != null) {
            Log.w("DatabaseArgs", String.format("Commands for database %s already set", this.dBName));
        }
        this.dBCmds = strArr;
    }

    public void setDBCmdFile(File file) {
        if (this.dBCmdFile != null) {
            Log.w("DatabaseArgs", String.format("Command file for database %s already set", this.dBName));
        }
        this.dBCmdFile = file;
    }

    public void setDBDataFile(File file) {
        if (this.dBDataFile != null) {
            Log.w("DatabaseArgs", String.format("Data file to restore for database %s already set", this.dBName));
        }
        this.dBDataFile = file;
    }

    public void addDBCmds(String... strArr) {
        String[] strArr2 = this.dBCmds;
        if (strArr2 == null) {
            this.dBCmds = strArr;
            return;
        }
        String[] strArr3 = new String[strArr2.length + strArr.length];
        System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
        System.arraycopy(strArr, 0, strArr3, this.dBCmds.length, strArr.length);
        this.dBCmds = strArr3;
    }

    public boolean hasDBCmds() {
        return this.dBCmds != null;
    }

    public boolean hasDBCmdFile() {
        return this.dBCmdFile != null;
    }

    public boolean hasDBDataFile() {
        return this.dBDataFile != null;
    }

    public String getDBName() {
        return this.dBName;
    }

    public String[] getDBCmds() {
        return this.dBCmds;
    }

    public File getDBCmdFile() {
        return this.dBCmdFile;
    }

    public File getDBDataFile() {
        return this.dBDataFile;
    }
}
