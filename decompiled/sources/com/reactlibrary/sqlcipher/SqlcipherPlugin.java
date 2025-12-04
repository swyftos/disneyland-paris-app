package com.reactlibrary.sqlcipher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Base64;
import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.urbanairship.reactnative.ReactMessageView;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteCursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* loaded from: classes4.dex */
public class SqlcipherPlugin extends ReactContextBaseJavaModule {
    private static final String PLUGIN_NAME = "Sqlcipher";
    public static final String TAG = "SqlcipherPlugin";
    protected Context context;
    protected ExecutorService threadPool;
    private static final Pattern FIRST_WORD = Pattern.compile("^\\s*(\\S+)", 2);
    static ConcurrentHashMap<String, DBRunner> dbrmap = new ConcurrentHashMap<>();

    private enum Action {
        open,
        close,
        attach,
        delete,
        executeSqlBatch,
        backgroundExecuteSqlBatch,
        echoStringValue,
        copyDBFile
    }

    private enum QueryType {
        update,
        insert,
        delete,
        select,
        begin,
        commit,
        rollback,
        other
    }

    public SqlcipherPlugin(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.context = null;
        this.context = reactApplicationContext.getApplicationContext();
        this.threadPool = Executors.newCachedThreadPool();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return PLUGIN_NAME;
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute(AbstractCircuitBreaker.PROPERTY_NAME, readableMap, new CallbackContext(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error:" + e.getMessage());
        }
    }

    @ReactMethod
    public void close(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute(ReactMessageView.EVENT_CLOSE, readableMap, new CallbackContext(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error" + e.getMessage());
        }
    }

    @ReactMethod
    public void attach(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("attach", readableMap, new CallbackContext(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error" + e.getMessage());
        }
    }

    @ReactMethod
    public void delete(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("delete", readableMap, new CallbackContext(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error" + e.getMessage());
        }
    }

    @ReactMethod
    public void backgroundExecuteSqlBatch(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("backgroundExecuteSqlBatch", readableMap, new CallbackContext(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error" + e.getMessage());
        }
    }

    @ReactMethod
    public void executeSqlBatch(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("executeSqlBatch", readableMap, new CallbackContext(callback, callback2));
        } catch (Exception unused) {
            callback2.invoke("Unexpected error");
        }
    }

    @ReactMethod
    public void echoStringValue(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("echoStringValue", readableMap, new CallbackContext(callback, callback2));
        } catch (Exception unused) {
            callback2.invoke("Unexpected error");
        }
    }

    @ReactMethod
    public void copyDBFile(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("copyDBFile", readableMap, new CallbackContext(callback, callback2));
        } catch (Exception unused) {
            callback2.invoke("Unexpected error");
        }
    }

    protected ExecutorService getThreadPool() {
        return this.threadPool;
    }

    protected Context getContext() {
        return this.context;
    }

    protected boolean execute(String str, ReadableMap readableMap, CallbackContext callbackContext) throws Exception {
        try {
            try {
                return executeAndPossiblyThrow(Action.valueOf(str), readableMap, callbackContext);
            } catch (Exception e) {
                FLog.e(TAG, "unexpected error", e);
                callbackContext.error("Unexpected error executing processing SQLite query");
                throw e;
            }
        } catch (IllegalArgumentException e2) {
            FLog.e(TAG, "unexpected error", e2);
            callbackContext.error("Unexpected error executing processing SQLite query");
            throw e2;
        }
    }

    /* renamed from: com.reactlibrary.sqlcipher.SqlcipherPlugin$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action;

        static {
            int[] iArr = new int[Action.values().length];
            $SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action = iArr;
            try {
                iArr[Action.echoStringValue.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action[Action.open.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action[Action.close.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action[Action.attach.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action[Action.delete.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action[Action.copyDBFile.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action[Action.executeSqlBatch.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action[Action.backgroundExecuteSqlBatch.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean executeAndPossiblyThrow(Action action, ReadableMap readableMap, CallbackContext callbackContext) throws Exception {
        String[] strArr;
        ReadableArray[] readableArrayArr;
        String[] strArr2 = null;
        switch (AnonymousClass1.$SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action[action.ordinal()]) {
            case 1:
                callbackContext.success(SqlcipherPluginConverter.getString(readableMap, "value", ""));
                return true;
            case 2:
                startDatabase(SqlcipherPluginConverter.getString(readableMap, "name", ""), readableMap, callbackContext);
                return true;
            case 3:
                closeDatabase(SqlcipherPluginConverter.getString(readableMap, "path", ""), callbackContext);
                return true;
            case 4:
                attachDatabase(SqlcipherPluginConverter.getString(readableMap, "path", ""), SqlcipherPluginConverter.getString(readableMap, "dbName", ""), SqlcipherPluginConverter.getString(readableMap, "dbAlias", ""), callbackContext);
                return true;
            case 5:
                deleteDatabase(SqlcipherPluginConverter.getString(readableMap, "path", ""), callbackContext);
                return true;
            case 6:
                openDbFile(SqlcipherPluginConverter.getString(readableMap, "path", ""), SqlcipherPluginConverter.getString(readableMap, "assetFilename", (String) null), 268435456, true);
                return true;
            case 7:
            case 8:
                String string = SqlcipherPluginConverter.getString((ReadableMap) SqlcipherPluginConverter.get(readableMap, "dbargs", (Object) null), "dbname", "");
                ReadableArray readableArray = (ReadableArray) SqlcipherPluginConverter.get(readableMap, "executes", (Object) null);
                if (readableArray.isNull(0)) {
                    strArr = new String[0];
                    readableArrayArr = null;
                } else {
                    int size = readableArray.size();
                    String[] strArr3 = new String[size];
                    String[] strArr4 = new String[size];
                    ReadableArray[] readableArrayArr2 = new ReadableArray[size];
                    for (int i = 0; i < size; i++) {
                        ReadableMap readableMap2 = (ReadableMap) SqlcipherPluginConverter.get(readableArray, i, (Object) null);
                        strArr3[i] = SqlcipherPluginConverter.getString(readableMap2, "sql", "");
                        strArr4[i] = SqlcipherPluginConverter.getString(readableMap2, "qid", "");
                        readableArrayArr2[i] = (ReadableArray) SqlcipherPluginConverter.get(readableMap2, "params", (Object) null);
                    }
                    strArr = strArr3;
                    strArr2 = strArr4;
                    readableArrayArr = readableArrayArr2;
                }
                DBQuery dBQuery = new DBQuery(strArr, strArr2, readableArrayArr, callbackContext);
                DBRunner dBRunner = dbrmap.get(string);
                if (dBRunner != null) {
                    try {
                        dBRunner.q.put(dBQuery);
                    } catch (Exception e) {
                        FLog.e(TAG, "couldn't add to queue", e);
                        callbackContext.error("couldn't add to queue");
                    }
                } else {
                    callbackContext.error("database not open");
                }
                return true;
            default:
                return true;
        }
    }

    public void closeAllOpenDatabases() throws InterruptedException {
        while (!dbrmap.isEmpty()) {
            String next = dbrmap.keySet().iterator().next();
            closeDatabaseNow(next);
            try {
                dbrmap.get(next).q.put(new DBQuery());
            } catch (Exception e) {
                FLog.e(TAG, "couldn't stop db thread for db: " + next, e);
            }
            dbrmap.remove(next);
        }
    }

    private void startDatabase(String str, ReadableMap readableMap, CallbackContext callbackContext) {
        if (dbrmap.get(str) != null) {
            callbackContext.success("database started");
            return;
        }
        DBRunner dBRunner = new DBRunner(str, readableMap, callbackContext);
        dbrmap.put(str, dBRunner);
        getThreadPool().execute(dBRunner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase openDatabase(String str, String str2, String str3, int i, CallbackContext callbackContext) throws Exception {
        SQLiteDatabase database = getDatabase(str);
        if (database != null && database.isOpen()) {
            throw new Exception("Database already open");
        }
        SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(openDbFile(str, str3, i, false).getAbsolutePath(), unscrambleKey(str2, "!!#DLPMobileApp2020#!!"), (SQLiteDatabase.CursorFactory) null, i);
        if (callbackContext != null) {
            callbackContext.success("Database opened");
        }
        return sQLiteDatabaseOpenDatabase;
    }

    private static String unscrambleKey(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String str3 = new String(decodeHexString(str));
        String str4 = TAG;
        Log.v(str4, "hex decoded input : " + str3);
        int i = 0;
        String str5 = new String(Base64.decode(str3, 0));
        Log.v(str4, "base64 decoded string : " + str5);
        while (str2.length() < str5.length() / 2) {
            str2 = str2 + str2;
        }
        while (i < str5.length()) {
            int i2 = i + 2;
            sb.append(Character.toString((char) (Integer.parseInt(str5.substring(i, i2), 16) ^ str2.charAt(i / 2))));
            i = i2;
        }
        return sb.toString();
    }

    private static byte hexToByte(String str) {
        return (byte) ((toDigit(str.charAt(0)) << 4) + toDigit(str.charAt(1)));
    }

    private static int toDigit(char c) {
        int iDigit = Character.digit(c, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new IllegalArgumentException("Invalid Hexadecimal Character: " + c);
    }

    private static byte[] decodeHexString(String str) {
        if (str.length() % 2 == 1) {
            throw new IllegalArgumentException("Invalid hexadecimal String supplied.");
        }
        byte[] bArr = new byte[str.length() / 2];
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            bArr[i / 2] = hexToByte(str.substring(i, i2));
            i = i2;
        }
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012f A[Catch: all -> 0x0056, TRY_ENTER, TryCatch #5 {all -> 0x0056, blocks: (B:16:0x003e, B:53:0x012f, B:55:0x0139, B:57:0x013f, B:58:0x0142, B:63:0x014e, B:64:0x0155, B:67:0x015a, B:68:0x0164, B:69:0x0165, B:70:0x016f, B:71:0x0170, B:73:0x0176, B:74:0x017d, B:21:0x005b, B:30:0x0098, B:33:0x00b1), top: B:91:0x0015, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.reactlibrary.sqlcipher.SqlcipherPlugin] */
    /* JADX WARN: Type inference failed for: r14v0, types: [int] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.io.File openDbFile(java.lang.String r12, java.lang.String r13, int r14, boolean r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactlibrary.sqlcipher.SqlcipherPlugin.openDbFile(java.lang.String, java.lang.String, int, boolean):java.io.File");
    }

    private void createFromAssets(String str, File file, InputStream inputStream) throws Exception {
        File file2;
        FileOutputStream fileOutputStream;
        Closeable closeable = null;
        try {
            FLog.v(TAG, "Copying pre-populated DB content");
            String absolutePath = file.getAbsolutePath();
            String strSubstring = absolutePath.substring(0, absolutePath.lastIndexOf("/") + 1);
            File file3 = new File(strSubstring);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            file2 = new File(strSubstring + str);
            fileOutputStream = new FileOutputStream(file2);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i > 0) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    FLog.v(TAG, "Copied pre-populated DB asset to: " + file2.getAbsolutePath());
                    closeQuietly(fileOutputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            closeable = fileOutputStream;
            th = th2;
            closeQuietly(closeable);
            throw th;
        }
    }

    private void closeDatabase(String str, CallbackContext callbackContext) throws InterruptedException {
        DBRunner dBRunner = dbrmap.get(str);
        if (dBRunner == null) {
            if (callbackContext != null) {
                callbackContext.success("database closed");
                return;
            }
            return;
        }
        try {
            dBRunner.q.put(new DBQuery(false, callbackContext));
        } catch (Exception e) {
            if (callbackContext != null) {
                callbackContext.error("couldn't close database" + e);
            }
            FLog.e(TAG, "couldn't close database", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDatabaseNow(String str) {
        SQLiteDatabase database = getDatabase(str);
        if (database != null) {
            database.close();
        }
    }

    private void attachDatabase(String str, String str2, String str3, CallbackContext callbackContext) throws InterruptedException {
        DBRunner dBRunner = dbrmap.get(str);
        if (dBRunner != null) {
            try {
                dBRunner.q.put(new DBQuery(new String[]{"ATTACH DATABASE '" + getContext().getDatabasePath(str2).getAbsolutePath() + "' AS " + str3}, new String[]{"1111"}, null, callbackContext));
                return;
            } catch (InterruptedException unused) {
                callbackContext.error("Can't put query in the queue. Interrupted.");
                return;
            }
        }
        callbackContext.error("Database " + str + "i s not created yet");
    }

    private void deleteDatabase(String str, CallbackContext callbackContext) throws InterruptedException {
        DBRunner dBRunner = dbrmap.get(str);
        if (dBRunner != null) {
            try {
                dBRunner.q.put(new DBQuery(true, callbackContext));
                return;
            } catch (Exception e) {
                if (callbackContext != null) {
                    callbackContext.error("couldn't close database" + e);
                }
                FLog.e(TAG, "couldn't close database", e);
                return;
            }
        }
        if (deleteDatabaseNow(str)) {
            callbackContext.success("database deleted");
        } else {
            callbackContext.error("couldn't delete database");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public boolean deleteDatabaseNow(String str) {
        return android.database.sqlite.SQLiteDatabase.deleteDatabase(getContext().getDatabasePath(str));
    }

    private SQLiteDatabase getDatabase(String str) {
        DBRunner dBRunner = dbrmap.get(str);
        if (dBRunner == null) {
            return null;
        }
        return dBRunner.mydb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0137 A[Catch: Exception -> 0x0092, TRY_LEAVE, TryCatch #7 {Exception -> 0x0092, blocks: (B:9:0x001c, B:19:0x003a, B:51:0x009c, B:63:0x00bc, B:97:0x011d, B:106:0x0137, B:115:0x0150, B:116:0x0153, B:104:0x0131), top: B:135:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeSqlBatch(java.lang.String r20, java.lang.String[] r21, com.facebook.react.bridge.ReadableArray[] r22, java.lang.String[] r23, com.reactlibrary.sqlcipher.CallbackContext r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactlibrary.sqlcipher.SqlcipherPlugin.executeSqlBatch(java.lang.String, java.lang.String[], com.facebook.react.bridge.ReadableArray[], java.lang.String[], com.reactlibrary.sqlcipher.CallbackContext):void");
    }

    private QueryType getQueryType(String str) {
        Matcher matcher = FIRST_WORD.matcher(str);
        if (matcher.find()) {
            try {
                return QueryType.valueOf(matcher.group(1).toLowerCase(Locale.US));
            } catch (IllegalArgumentException unused) {
            }
        }
        return QueryType.other;
    }

    private void bindArgsToStatement(SQLiteStatement sQLiteStatement, ReadableArray readableArray) {
        for (int i = 0; i < readableArray.size(); i++) {
            if (readableArray.getType(i) == ReadableType.Number) {
                double d = readableArray.getDouble(i);
                long j = (long) d;
                if (d == j) {
                    sQLiteStatement.bindLong(i + 1, j);
                } else {
                    sQLiteStatement.bindDouble(i + 1, d);
                }
            } else if (readableArray.isNull(i)) {
                sQLiteStatement.bindNull(i + 1);
            } else {
                sQLiteStatement.bindString(i + 1, SqlcipherPluginConverter.getString(readableArray, i, ""));
            }
        }
    }

    private WritableMap executeSqlStatementQuery(SQLiteDatabase sQLiteDatabase, String str, ReadableArray readableArray, CallbackContext callbackContext) throws Exception {
        WritableMap writableMapCreateMap = Arguments.createMap();
        try {
            try {
                String[] strArr = new String[0];
                if (readableArray != null) {
                    int size = readableArray.size();
                    String[] strArr2 = new String[size];
                    for (int i = 0; i < size; i++) {
                        if (readableArray.isNull(i)) {
                            strArr2[i] = "";
                        } else {
                            strArr2[i] = SqlcipherPluginConverter.getString(readableArray, i, "");
                        }
                    }
                    strArr = strArr2;
                }
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery(str, strArr);
                if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    int columnCount = cursorRawQuery.getColumnCount();
                    do {
                        WritableMap writableMapCreateMap2 = Arguments.createMap();
                        for (int i2 = 0; i2 < columnCount; i2++) {
                            bindRow(writableMapCreateMap2, cursorRawQuery.getColumnName(i2), cursorRawQuery, i2);
                        }
                        writableArrayCreateArray.pushMap(writableMapCreateMap2);
                    } while (cursorRawQuery.moveToNext());
                    writableMapCreateMap.putArray("rows", writableArrayCreateArray);
                }
                closeQuietly(cursorRawQuery);
                return writableMapCreateMap;
            } catch (Exception e) {
                FLog.e(TAG, "SQLitePlugin.executeSql[Batch]() failed", e);
                throw e;
            }
        } catch (Throwable th) {
            closeQuietly((Closeable) null);
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    private void bindRow(WritableMap writableMap, String str, android.database.Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            writableMap.putNull(str);
            return;
        }
        if (type == 1) {
            writableMap.putDouble(str, cursor.getLong(i));
            return;
        }
        if (type == 2) {
            writableMap.putDouble(str, cursor.getDouble(i));
        } else if (type == 4) {
            writableMap.putString(str, new String(Base64.encode(cursor.getBlob(i), 0)));
        } else {
            writableMap.putString(str, cursor.getString(i));
        }
    }

    private void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void closeQuietly(SQLiteCursor sQLiteCursor) {
        sQLiteCursor.close();
    }

    private void closeQuietly(SQLiteStatement sQLiteStatement) {
        sQLiteStatement.close();
    }

    private class DBRunner implements Runnable {
        private boolean androidLockWorkaround;
        private String assetFilename;
        final String dbname;
        final String key;
        SQLiteDatabase mydb;
        final CallbackContext openCbc;
        final int openFlags;
        final BlockingQueue q;

        DBRunner(String str, ReadableMap readableMap, CallbackContext callbackContext) {
            this.dbname = str;
            this.key = readableMap.getString("key");
            int i = 268435456;
            try {
                String string = SqlcipherPluginConverter.getString(readableMap, "assetFilename", (String) null);
                this.assetFilename = string;
                if (string != null && string.length() > 0) {
                    if (SqlcipherPluginConverter.getBoolean(readableMap, "readOnly", false)) {
                        i = 1;
                    }
                }
            } catch (Exception e) {
                FLog.e(SqlcipherPlugin.TAG, "Error retrieving assetFilename or mode from options:", e);
            }
            this.openFlags = i;
            boolean z = SqlcipherPluginConverter.getBoolean(readableMap, "androidLockWorkaround", false);
            this.androidLockWorkaround = z;
            if (z) {
                FLog.i(SqlcipherPlugin.TAG, "Android db closing/locking workaround applied");
            }
            this.q = new LinkedBlockingQueue();
            this.openCbc = callbackContext;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                this.mydb = SqlcipherPlugin.this.openDatabase(this.dbname, this.key, this.assetFilename, this.openFlags, this.openCbc);
                DBQuery dBQuery = null;
                try {
                    Object objTake = this.q.take();
                    while (true) {
                        dBQuery = (DBQuery) objTake;
                        if (dBQuery.stop) {
                            break;
                        }
                        SqlcipherPlugin.this.executeSqlBatch(this.dbname, dBQuery.queries, dBQuery.queryParams, dBQuery.queryIDs, dBQuery.cbc);
                        if (this.androidLockWorkaround) {
                            String[] strArr = dBQuery.queries;
                            if (strArr.length == 1 && strArr[0].equals("COMMIT")) {
                                SqlcipherPlugin.this.closeDatabaseNow(this.dbname);
                                this.mydb = SqlcipherPlugin.this.openDatabase(this.dbname, this.key, "", this.openFlags, null);
                            }
                        }
                        objTake = this.q.take();
                    }
                } catch (Exception e) {
                    FLog.e(SqlcipherPlugin.TAG, "unexpected error", e);
                }
                if (dBQuery == null || !dBQuery.close) {
                    return;
                }
                try {
                    SqlcipherPlugin.this.closeDatabaseNow(this.dbname);
                    SqlcipherPlugin.dbrmap.remove(this.dbname);
                    if (!dBQuery.delete) {
                        dBQuery.cbc.success("database removed");
                    } else {
                        try {
                            if (SqlcipherPlugin.this.deleteDatabaseNow(this.dbname)) {
                                dBQuery.cbc.success("database removed");
                            } else {
                                dBQuery.cbc.error("couldn't delete database");
                            }
                        } catch (Exception e2) {
                            FLog.e(SqlcipherPlugin.TAG, "couldn't delete database", e2);
                            dBQuery.cbc.error("couldn't delete database: " + e2);
                        }
                    }
                } catch (Exception e3) {
                    FLog.e(SqlcipherPlugin.TAG, "couldn't close database", e3);
                    CallbackContext callbackContext = dBQuery.cbc;
                    if (callbackContext != null) {
                        callbackContext.error("couldn't close database: " + e3);
                    }
                }
            } catch (SQLiteException e4) {
                FLog.e(SqlcipherPlugin.TAG, "SQLite error opening database, stopping db thread", e4);
                CallbackContext callbackContext2 = this.openCbc;
                if (callbackContext2 != null) {
                    callbackContext2.error("Can't open database." + e4);
                }
                SqlcipherPlugin.dbrmap.remove(this.dbname);
            } catch (Exception e5) {
                FLog.e(SqlcipherPlugin.TAG, "Unexpected error opening database, stopping db thread", e5);
                CallbackContext callbackContext3 = this.openCbc;
                if (callbackContext3 != null) {
                    callbackContext3.error("Can't open database." + e5);
                }
                SqlcipherPlugin.dbrmap.remove(this.dbname);
            }
        }
    }

    private final class DBQuery {
        final CallbackContext cbc;
        final boolean close;
        final boolean delete;
        final String[] queries;
        final String[] queryIDs;
        final ReadableArray[] queryParams;
        final boolean stop;

        DBQuery(String[] strArr, String[] strArr2, ReadableArray[] readableArrayArr, CallbackContext callbackContext) {
            this.stop = false;
            this.close = false;
            this.delete = false;
            this.queries = strArr;
            this.queryIDs = strArr2;
            this.queryParams = readableArrayArr;
            this.cbc = callbackContext;
        }

        DBQuery(boolean z, CallbackContext callbackContext) {
            this.stop = true;
            this.close = true;
            this.delete = z;
            this.queries = null;
            this.queryIDs = null;
            this.queryParams = null;
            this.cbc = callbackContext;
        }

        DBQuery() {
            this.stop = true;
            this.close = false;
            this.delete = false;
            this.queries = null;
            this.queryIDs = null;
            this.queryParams = null;
            this.cbc = null;
        }
    }
}
