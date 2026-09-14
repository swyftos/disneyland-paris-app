package com.reactlibrary.sqlcipher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Base64;
import android.util.Log;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
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
import com.google.firebase.messaging.Constants;
import com.urbanairship.reactnative.ReactMessageView;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
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
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.sqlcipher.SQLiteCursor;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import net.zetetic.database.sqlcipher.SQLiteDatabaseHook;
import net.zetetic.database.sqlcipher.SQLiteStatement;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* JADX INFO: loaded from: classes4.dex */
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
                FLog.m1292e(TAG, "unexpected error", e);
                callbackContext.error("Unexpected error executing processing SQLite query");
                throw e;
            }
        } catch (IllegalArgumentException e2) {
            FLog.m1292e(TAG, "unexpected error", e2);
            callbackContext.error("Unexpected error executing processing SQLite query");
            throw e2;
        }
    }

    /* JADX INFO: renamed from: com.reactlibrary.sqlcipher.SqlcipherPlugin$1 */
    static /* synthetic */ class C45561 {
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
        switch (C45561.$SwitchMap$com$reactlibrary$sqlcipher$SqlcipherPlugin$Action[action.ordinal()]) {
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
                        dBRunner.f3677q.put(dBQuery);
                    } catch (Exception e) {
                        FLog.m1292e(TAG, "couldn't add to queue", e);
                        callbackContext.error("couldn't add to queue");
                    }
                    break;
                } else {
                    callbackContext.error("database not open");
                }
                return true;
            default:
                return true;
        }
    }

    public void closeAllOpenDatabases() {
        while (!dbrmap.isEmpty()) {
            String next = dbrmap.keySet().iterator().next();
            closeDatabaseNow(next);
            try {
                dbrmap.get(next).f3677q.put(new DBQuery());
            } catch (Exception e) {
                FLog.m1292e(TAG, "couldn't stop db thread for db: " + next, e);
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
    public SQLiteDatabase openDatabase(String str, String str2, String str3, int i, int i2, CallbackContext callbackContext) throws Exception {
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase;
        SQLiteDatabase database = getDatabase(str);
        if (database != null && database.isOpen()) {
            throw new Exception("Database already open");
        }
        File fileOpenDbFile = openDbFile(str, str3, i, false);
        if (str2 != null && !str2.isEmpty()) {
            String str4 = TAG;
            FLog.m1319v(str4, "Opening encrypted database with SQLCipher");
            sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(fileOpenDbFile.getAbsolutePath(), unscrambleKey(str2, "!!#DLPMobileApp2020#!!"), (SQLiteDatabase.CursorFactory) null, (DatabaseErrorHandler) null, (SQLiteDatabaseHook) null);
            if (i2 == 16384) {
                try {
                    sQLiteDatabaseOpenOrCreateDatabase.rawExecSQL("PRAGMA cipher_page_size = 16384", new Object[0]);
                    FLog.m1319v(str4, "16KB page size configured for encrypted database");
                } catch (Exception e) {
                    FLog.m1331w(TAG, "Could not set 16KB page size, using default: " + e.getMessage());
                }
            }
        } else {
            FLog.m1331w(TAG, "Opening unencrypted database - not recommended for production use");
            sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(fileOpenDbFile.getAbsolutePath(), (String) null, (SQLiteDatabase.CursorFactory) null, (DatabaseErrorHandler) null, (SQLiteDatabaseHook) null);
        }
        if (callbackContext != null) {
            callbackContext.success("Database opened");
        }
        return sQLiteDatabaseOpenOrCreateDatabase;
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

    /* JADX WARN: Code duplicated, block: B:11:0x0017 A[Catch: all -> 0x0011, TRY_LEAVE, TryCatch #2 {all -> 0x0011, blocks: (B:4:0x0009, B:11:0x0017, B:14:0x0021, B:15:0x0032, B:23:0x0072, B:25:0x007a, B:27:0x0082, B:29:0x008c, B:28:0x0088, B:35:0x00c6, B:37:0x00d6, B:38:0x00da, B:49:0x0112), top: B:86:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0021 A[Catch: all -> 0x0011, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0011, blocks: (B:4:0x0009, B:11:0x0017, B:14:0x0021, B:15:0x0032, B:23:0x0072, B:25:0x007a, B:27:0x0082, B:29:0x008c, B:28:0x0088, B:35:0x00c6, B:37:0x00d6, B:38:0x00da, B:49:0x0112), top: B:86:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0072 A[Catch: all -> 0x0011, TRY_ENTER, TryCatch #2 {all -> 0x0011, blocks: (B:4:0x0009, B:11:0x0017, B:14:0x0021, B:15:0x0032, B:23:0x0072, B:25:0x007a, B:27:0x0082, B:29:0x008c, B:28:0x0088, B:35:0x00c6, B:37:0x00d6, B:38:0x00da, B:49:0x0112), top: B:86:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x007a A[Catch: all -> 0x0011, TryCatch #2 {all -> 0x0011, blocks: (B:4:0x0009, B:11:0x0017, B:14:0x0021, B:15:0x0032, B:23:0x0072, B:25:0x007a, B:27:0x0082, B:29:0x008c, B:28:0x0088, B:35:0x00c6, B:37:0x00d6, B:38:0x00da, B:49:0x0112), top: B:86:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0082 A[Catch: all -> 0x0011, TryCatch #2 {all -> 0x0011, blocks: (B:4:0x0009, B:11:0x0017, B:14:0x0021, B:15:0x0032, B:23:0x0072, B:25:0x007a, B:27:0x0082, B:29:0x008c, B:28:0x0088, B:35:0x00c6, B:37:0x00d6, B:38:0x00da, B:49:0x0112), top: B:86:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0088 A[Catch: all -> 0x0011, TRY_LEAVE, TryCatch #2 {all -> 0x0011, blocks: (B:4:0x0009, B:11:0x0017, B:14:0x0021, B:15:0x0032, B:23:0x0072, B:25:0x007a, B:27:0x0082, B:29:0x008c, B:28:0x0088, B:35:0x00c6, B:37:0x00d6, B:38:0x00da, B:49:0x0112), top: B:86:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c6 A[Catch: all -> 0x0011, TRY_ENTER, TryCatch #2 {all -> 0x0011, blocks: (B:4:0x0009, B:11:0x0017, B:14:0x0021, B:15:0x0032, B:23:0x0072, B:25:0x007a, B:27:0x0082, B:29:0x008c, B:28:0x0088, B:35:0x00c6, B:37:0x00d6, B:38:0x00da, B:49:0x0112), top: B:86:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00d6 A[Catch: all -> 0x0011, TRY_LEAVE, TryCatch #2 {all -> 0x0011, blocks: (B:4:0x0009, B:11:0x0017, B:14:0x0021, B:15:0x0032, B:23:0x0072, B:25:0x007a, B:27:0x0082, B:29:0x008c, B:28:0x0088, B:35:0x00c6, B:37:0x00d6, B:38:0x00da, B:49:0x0112), top: B:86:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x012c  */
    /* JADX WARN: Code duplicated, block: B:53:0x012f A[Catch: all -> 0x0056, TRY_ENTER, TryCatch #5 {all -> 0x0056, blocks: (B:16:0x003e, B:53:0x012f, B:55:0x0139, B:57:0x013f, B:58:0x0142, B:63:0x014e, B:64:0x0155, B:67:0x015a, B:68:0x0164, B:69:0x0165, B:70:0x016f, B:71:0x0170, B:73:0x0176, B:74:0x017d, B:21:0x005b, B:30:0x0098, B:33:0x00b1), top: B:91:0x0015, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0176 A[Catch: all -> 0x0056, TryCatch #5 {all -> 0x0056, blocks: (B:16:0x003e, B:53:0x012f, B:55:0x0139, B:57:0x013f, B:58:0x0142, B:63:0x014e, B:64:0x0155, B:67:0x015a, B:68:0x0164, B:69:0x0165, B:70:0x016f, B:71:0x0170, B:73:0x0176, B:74:0x017d, B:21:0x005b, B:30:0x0098, B:33:0x00b1), top: B:91:0x0015, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0014  */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x0021, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
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
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v8 */
    protected File openDbFile(String str, String str2, int i, boolean z) throws Exception {
        boolean z2;
        File file;
        FileInputStream fileInputStream;
        String str3;
        String strSubstring;
        InputStream inputStreamOpen;
        InputStream inputStream;
        String str4;
        InputStream inputStreamOpen2;
        boolean z3 = false;
        ?? r4 = 0;
        databasePath = null;
        databasePath = null;
        databasePath = null;
        databasePath = null;
        FileInputStream fileInputStream2 = null;
        File databasePath = null;
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                try {
                    if (z2) {
                        i = 0;
                    } else if (str2.compareTo("1") == 0) {
                        str4 = "www/" + str;
                        try {
                            inputStreamOpen2 = getContext().getAssets().open(str4);
                            try {
                                FLog.m1319v(TAG, "Pre-populated DB asset FOUND  in app bundle www subdirectory: " + str4);
                                i = inputStreamOpen2;
                            } catch (Exception unused) {
                                FLog.m1291e(TAG, "pre-populated DB asset NOT FOUND in app bundle www subdirectory: " + str4);
                                inputStream = inputStreamOpen2;
                                z3 = true;
                                i = inputStream;
                            }
                        } catch (Exception unused2) {
                            inputStreamOpen2 = null;
                        }
                    } else if (str2.charAt(0) == '~') {
                        if (str2.startsWith("~/")) {
                            strSubstring = str2.substring(2);
                        } else {
                            strSubstring = str2.substring(1);
                        }
                        try {
                            inputStreamOpen = getContext().getAssets().open(strSubstring);
                            try {
                                FLog.m1319v(TAG, "Pre-populated DB asset FOUND in app bundle subdirectory: " + strSubstring);
                                i = inputStreamOpen;
                            } catch (Exception unused3) {
                                FLog.m1291e(TAG, "pre-populated DB asset NOT FOUND in app bundle www subdirectory: " + strSubstring);
                                inputStream = inputStreamOpen;
                                z3 = true;
                                i = inputStream;
                            }
                        } catch (Exception unused4) {
                            inputStreamOpen = null;
                        }
                    } else {
                        File filesDir = getContext().getFilesDir();
                        if (str2.startsWith("/")) {
                            str2 = str2.substring(1);
                        }
                        try {
                            file = new File(filesDir, str2);
                            fileInputStream = new FileInputStream(file);
                            try {
                                try {
                                    str3 = TAG;
                                    FLog.m1319v(str3, "Pre-populated DB asset FOUND in Files subdirectory: " + file.getCanonicalPath());
                                    if (i == 1) {
                                        try {
                                            FLog.m1319v(str3, "Detected read-only mode request for external asset.");
                                            databasePath = file;
                                        } catch (Exception unused5) {
                                            fileInputStream2 = fileInputStream;
                                            FLog.m1291e(TAG, "Error opening pre-populated DB asset in app bundle www subdirectory: " + str2);
                                            z3 = true;
                                            i = fileInputStream2;
                                            databasePath = file;
                                        }
                                    }
                                    i = fileInputStream;
                                } catch (Throwable th) {
                                    th = th;
                                    r4 = fileInputStream;
                                }
                            } catch (Exception unused6) {
                                file = null;
                            }
                        } catch (Exception unused7) {
                            file = null;
                        }
                    }
                    if (databasePath == null) {
                        databasePath = getContext().getDatabasePath(str);
                        if (z && databasePath.exists()) {
                            databasePath.delete();
                        }
                        if (!databasePath.exists() && z2) {
                            if (!z3 || i == 0) {
                                FLog.m1291e(TAG, "Unable to import pre-populated db asset");
                                throw new Exception("Unable to import pre-populated db asset");
                            }
                            FLog.m1319v(TAG, "Copying pre-populated db asset to destination");
                            try {
                                createFromAssets(str, databasePath, i);
                            } catch (Exception e) {
                                FLog.m1292e(TAG, "Error importing pre-populated DB asset", e);
                                throw new Exception("Error importing pre-populated DB asset");
                            }
                        }
                        if (!databasePath.exists()) {
                            databasePath.getParentFile().mkdirs();
                        }
                    }
                    FLog.m1319v(TAG, "DB file is ready, proceeding to OPEN SQLite DB: " + databasePath.getAbsolutePath());
                    closeQuietly(i);
                    return databasePath;
                } catch (Throwable th2) {
                    th = th2;
                    r4 = i;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            z2 = false;
            if (z2) {
                i = 0;
            } else if (str2.compareTo("1") == 0) {
                str4 = "www/" + str;
                inputStreamOpen2 = getContext().getAssets().open(str4);
                FLog.m1319v(TAG, "Pre-populated DB asset FOUND  in app bundle www subdirectory: " + str4);
                i = inputStreamOpen2;
            } else if (str2.charAt(0) == '~') {
                if (str2.startsWith("~/")) {
                    strSubstring = str2.substring(2);
                } else {
                    strSubstring = str2.substring(1);
                }
                inputStreamOpen = getContext().getAssets().open(strSubstring);
                FLog.m1319v(TAG, "Pre-populated DB asset FOUND in app bundle subdirectory: " + strSubstring);
                i = inputStreamOpen;
            } else {
                File filesDir2 = getContext().getFilesDir();
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                file = new File(filesDir2, str2);
                fileInputStream = new FileInputStream(file);
                str3 = TAG;
                FLog.m1319v(str3, "Pre-populated DB asset FOUND in Files subdirectory: " + file.getCanonicalPath());
                if (i == 1) {
                    FLog.m1319v(str3, "Detected read-only mode request for external asset.");
                    databasePath = file;
                }
                i = fileInputStream;
            }
            if (databasePath == null) {
                databasePath = getContext().getDatabasePath(str);
                if (z) {
                    databasePath.delete();
                }
                if (!databasePath.exists()) {
                    if (!z3) {
                    }
                    FLog.m1291e(TAG, "Unable to import pre-populated db asset");
                    throw new Exception("Unable to import pre-populated db asset");
                }
                if (!databasePath.exists()) {
                    databasePath.getParentFile().mkdirs();
                }
            }
            FLog.m1319v(TAG, "DB file is ready, proceeding to OPEN SQLite DB: " + databasePath.getAbsolutePath());
            closeQuietly(i);
            return databasePath;
        }
        closeQuietly(r4);
        throw th;
    }

    private void createFromAssets(String str, File file, InputStream inputStream) throws Exception {
        Closeable closeable = null;
        try {
            FLog.m1319v(TAG, "Copying pre-populated DB content");
            String absolutePath = file.getAbsolutePath();
            String strSubstring = absolutePath.substring(0, absolutePath.lastIndexOf("/") + 1);
            File file2 = new File(strSubstring);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(strSubstring + str);
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i > 0) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        FLog.m1319v(TAG, "Copied pre-populated DB asset to: " + file3.getAbsolutePath());
                        closeQuietly(fileOutputStream);
                        return;
                    }
                }
            } catch (Throwable th) {
                closeable = fileOutputStream;
                th = th;
                closeQuietly(closeable);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void closeDatabase(String str, CallbackContext callbackContext) {
        DBRunner dBRunner = dbrmap.get(str);
        if (dBRunner == null) {
            if (callbackContext != null) {
                callbackContext.success("database closed");
                return;
            }
            return;
        }
        try {
            dBRunner.f3677q.put(new DBQuery(false, callbackContext));
        } catch (Exception e) {
            if (callbackContext != null) {
                callbackContext.error("couldn't close database" + e);
            }
            FLog.m1292e(TAG, "couldn't close database", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDatabaseNow(String str) {
        SQLiteDatabase database = getDatabase(str);
        if (database != null) {
            database.close();
        }
    }

    private void attachDatabase(String str, String str2, String str3, CallbackContext callbackContext) {
        DBRunner dBRunner = dbrmap.get(str);
        if (dBRunner != null) {
            try {
                dBRunner.f3677q.put(new DBQuery(new String[]{"ATTACH DATABASE '" + getContext().getDatabasePath(str2).getAbsolutePath() + "' AS " + str3}, new String[]{"1111"}, null, callbackContext));
                return;
            } catch (InterruptedException unused) {
                callbackContext.error("Can't put query in the queue. Interrupted.");
                return;
            }
        }
        callbackContext.error("Database " + str + "i s not created yet");
    }

    private void deleteDatabase(String str, CallbackContext callbackContext) {
        DBRunner dBRunner = dbrmap.get(str);
        if (dBRunner != null) {
            try {
                dBRunner.f3677q.put(new DBQuery(true, callbackContext));
                return;
            } catch (Exception e) {
                if (callbackContext != null) {
                    callbackContext.error("couldn't close database" + e);
                }
                FLog.m1292e(TAG, "couldn't close database", e);
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
    /* JADX WARN: Code duplicated, block: B:106:0x0137 A[Catch: Exception -> 0x0092, TRY_LEAVE, TryCatch #7 {Exception -> 0x0092, blocks: (B:9:0x001c, B:19:0x003a, B:51:0x009c, B:63:0x00bc, B:97:0x011d, B:106:0x0137, B:115:0x0150, B:116:0x0153, B:104:0x0131), top: B:134:0x001c }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0140  */
    /* JADX WARN: Code duplicated, block: B:120:0x0168  */
    /* JADX WARN: Code duplicated, block: B:121:0x017b  */
    /* JADX WARN: Code duplicated, block: B:130:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    @SuppressLint({"NewApi"})
    public void executeSqlBatch(String str, String[] strArr, ReadableArray[] readableArrayArr, String[] strArr2, CallbackContext callbackContext) throws Throwable {
        WritableMap writableMap;
        String message;
        WritableMap writableMapCreateMap;
        boolean z;
        String str2;
        boolean z2;
        String str3;
        SQLiteStatement sQLiteStatementCompileStatement;
        int iExecuteUpdateDelete;
        SQLiteDatabase database = getDatabase(str);
        if (database == null) {
            callbackContext.error("database has been closed");
            return;
        }
        int length = strArr.length;
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (int i = 0; i < length; i++) {
            String str4 = strArr2[i];
            try {
                String str5 = strArr[i];
                QueryType queryType = getQueryType(str5);
                message = "unknown";
                if (queryType == QueryType.update) {
                    str3 = str5;
                    sQLiteStatementCompileStatement = database.compileStatement(str3);
                    if (readableArrayArr != null) {
                        bindArgsToStatement(sQLiteStatementCompileStatement, readableArrayArr[i]);
                    }
                    iExecuteUpdateDelete = sQLiteStatementCompileStatement.executeUpdateDelete();
                    closeQuietly(sQLiteStatementCompileStatement);
                    if (iExecuteUpdateDelete != -1) {
                        writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putInt("rowsAffected", iExecuteUpdateDelete);
                    } else {
                        writableMapCreateMap = null;
                    }
                    z = false;
                } else {
                    try {
                        if (queryType == QueryType.delete) {
                            str3 = str5;
                            try {
                                sQLiteStatementCompileStatement = database.compileStatement(str3);
                                if (readableArrayArr != null) {
                                    try {
                                        try {
                                            bindArgsToStatement(sQLiteStatementCompileStatement, readableArrayArr[i]);
                                        } catch (Throwable th) {
                                            th = th;
                                            closeQuietly(sQLiteStatementCompileStatement);
                                            throw th;
                                        }
                                    } catch (SQLException e) {
                                        e = e;
                                        message = e.getMessage();
                                        FLog.m1292e(TAG, "SQLiteStatement.executeUpdateDelete() failed", e);
                                        closeQuietly(sQLiteStatementCompileStatement);
                                        iExecuteUpdateDelete = -1;
                                    }
                                }
                                iExecuteUpdateDelete = sQLiteStatementCompileStatement.executeUpdateDelete();
                                closeQuietly(sQLiteStatementCompileStatement);
                            } catch (SQLException e2) {
                                e = e2;
                                sQLiteStatementCompileStatement = null;
                            } catch (Throwable th2) {
                                th = th2;
                                sQLiteStatementCompileStatement = null;
                            }
                            if (iExecuteUpdateDelete != -1) {
                                writableMapCreateMap = Arguments.createMap();
                                writableMapCreateMap.putInt("rowsAffected", iExecuteUpdateDelete);
                            } else {
                                writableMapCreateMap = null;
                            }
                        } else {
                            z = true;
                            if (queryType == QueryType.insert && readableArrayArr != null) {
                                FLog.m1279d("executeSqlBatch", "INSERT");
                                SQLiteStatement sQLiteStatementCompileStatement2 = database.compileStatement(str5);
                                bindArgsToStatement(sQLiteStatementCompileStatement2, readableArrayArr[i]);
                                str2 = str5;
                                try {
                                    long jExecuteInsert = sQLiteStatementCompileStatement2.executeInsert();
                                    writableMapCreateMap = Arguments.createMap();
                                    if (jExecuteInsert != -1) {
                                        try {
                                            try {
                                                writableMapCreateMap.putDouble("insertId", jExecuteInsert);
                                                writableMapCreateMap.putInt("rowsAffected", 1);
                                            } catch (SQLException e3) {
                                                e = e3;
                                                message = e.getMessage();
                                                FLog.m1292e(TAG, "SQLiteDatabase.executeInsert() failed", e);
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            writableMap = writableMapCreateMap;
                                            try {
                                                closeQuietly(sQLiteStatementCompileStatement2);
                                                throw th;
                                            } catch (Exception e4) {
                                                e = e4;
                                                message = e.getMessage();
                                                FLog.m1292e(TAG, "SQLitePlugin.executeSql[Batch](): failed", e);
                                                writableMapCreateMap = writableMap;
                                                if (writableMapCreateMap != null) {
                                                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                                                    writableMapCreateMap2.putString("qid", str4);
                                                    writableMapCreateMap2.putString("type", OneIDTrackerEvent.EVENT_PARAM_SUCCESS);
                                                    writableMapCreateMap2.putMap("result", writableMapCreateMap);
                                                    writableArrayCreateArray.pushMap(writableMapCreateMap2);
                                                } else {
                                                    WritableMap writableMapCreateMap3 = Arguments.createMap();
                                                    writableMapCreateMap3.putString("qid", str4);
                                                    writableMapCreateMap3.putString("type", Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                                                    WritableMap writableMapCreateMap4 = Arguments.createMap();
                                                    writableMapCreateMap4.putString("message", message);
                                                    writableMapCreateMap3.putMap("result", writableMapCreateMap4);
                                                    writableArrayCreateArray.pushMap(writableMapCreateMap3);
                                                }
                                            }
                                        }
                                    } else {
                                        writableMapCreateMap.putInt("rowsAffected", 0);
                                    }
                                } catch (SQLException e5) {
                                    e = e5;
                                    writableMapCreateMap = null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    writableMap = null;
                                }
                                try {
                                    closeQuietly(sQLiteStatementCompileStatement2);
                                } catch (Exception e6) {
                                    e = e6;
                                    writableMap = writableMapCreateMap;
                                    message = e.getMessage();
                                    FLog.m1292e(TAG, "SQLitePlugin.executeSql[Batch](): failed", e);
                                    writableMapCreateMap = writableMap;
                                }
                            } else {
                                str2 = str5;
                                if (queryType == QueryType.begin) {
                                    try {
                                        database.beginTransaction();
                                        writableMapCreateMap = Arguments.createMap();
                                        try {
                                            writableMapCreateMap.putInt("rowsAffected", 0);
                                        } catch (SQLException e7) {
                                            e = e7;
                                            message = e.getMessage();
                                            FLog.m1292e(TAG, "SQLiteDatabase.beginTransaction() failed", e);
                                        }
                                    } catch (SQLException e8) {
                                        e = e8;
                                        writableMapCreateMap = null;
                                    }
                                } else if (queryType == QueryType.commit) {
                                    try {
                                        database.setTransactionSuccessful();
                                        database.endTransaction();
                                        writableMapCreateMap = Arguments.createMap();
                                        try {
                                            writableMapCreateMap.putInt("rowsAffected", 0);
                                        } catch (SQLException e9) {
                                            e = e9;
                                            message = e.getMessage();
                                            FLog.m1292e(TAG, "SQLiteDatabase.setTransactionSuccessful/endTransaction() failed", e);
                                        }
                                    } catch (SQLException e10) {
                                        e = e10;
                                        writableMapCreateMap = null;
                                    }
                                } else if (queryType == QueryType.rollback) {
                                    try {
                                        database.endTransaction();
                                        writableMapCreateMap = Arguments.createMap();
                                        z2 = false;
                                        try {
                                            writableMapCreateMap.putInt("rowsAffected", 0);
                                        } catch (SQLException e11) {
                                            e = e11;
                                            message = e.getMessage();
                                            FLog.m1292e(TAG, "SQLiteDatabase.endTransaction() failed", e);
                                        }
                                    } catch (SQLException e12) {
                                        e = e12;
                                        z2 = false;
                                        writableMapCreateMap = null;
                                    }
                                    z = z2;
                                    str3 = str2;
                                } else {
                                    str3 = str2;
                                    writableMapCreateMap = null;
                                }
                            }
                            str3 = str2;
                        }
                        z = false;
                    } catch (Exception e13) {
                        e = e13;
                        writableMap = null;
                        message = e.getMessage();
                        FLog.m1292e(TAG, "SQLitePlugin.executeSql[Batch](): failed", e);
                        writableMapCreateMap = writableMap;
                        if (writableMapCreateMap != null) {
                            WritableMap writableMapCreateMap5 = Arguments.createMap();
                            writableMapCreateMap5.putString("qid", str4);
                            writableMapCreateMap5.putString("type", OneIDTrackerEvent.EVENT_PARAM_SUCCESS);
                            writableMapCreateMap5.putMap("result", writableMapCreateMap);
                            writableArrayCreateArray.pushMap(writableMapCreateMap5);
                        } else {
                            WritableMap writableMapCreateMap6 = Arguments.createMap();
                            writableMapCreateMap6.putString("qid", str4);
                            writableMapCreateMap6.putString("type", Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                            WritableMap writableMapCreateMap7 = Arguments.createMap();
                            writableMapCreateMap7.putString("message", message);
                            writableMapCreateMap6.putMap("result", writableMapCreateMap7);
                            writableArrayCreateArray.pushMap(writableMapCreateMap6);
                        }
                    }
                }
                if (z) {
                    writableMapCreateMap = executeSqlStatementQuery(database, str3, readableArrayArr != null ? readableArrayArr[i] : null, callbackContext);
                }
            } catch (Exception e14) {
                e = e14;
            }
            if (writableMapCreateMap != null) {
                WritableMap writableMapCreateMap8 = Arguments.createMap();
                writableMapCreateMap8.putString("qid", str4);
                writableMapCreateMap8.putString("type", OneIDTrackerEvent.EVENT_PARAM_SUCCESS);
                writableMapCreateMap8.putMap("result", writableMapCreateMap);
                writableArrayCreateArray.pushMap(writableMapCreateMap8);
            } else {
                WritableMap writableMapCreateMap9 = Arguments.createMap();
                writableMapCreateMap9.putString("qid", str4);
                writableMapCreateMap9.putString("type", Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                WritableMap writableMapCreateMap10 = Arguments.createMap();
                writableMapCreateMap10.putString("message", message);
                writableMapCreateMap9.putMap("result", writableMapCreateMap10);
                writableArrayCreateArray.pushMap(writableMapCreateMap9);
            }
        }
        callbackContext.success(writableArrayCreateArray);
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
                FLog.m1292e(TAG, "SQLitePlugin.executeSql[Batch]() failed", e);
                throw e;
            }
        } catch (Throwable th) {
            closeQuietly((Closeable) null);
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    private void bindRow(WritableMap writableMap, String str, Cursor cursor, int i) {
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

    private void closeQuietly(Closeable closeable) {
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
        final int pageSize;

        /* JADX INFO: renamed from: q */
        final BlockingQueue f3677q;

        DBRunner(String str, ReadableMap readableMap, CallbackContext callbackContext) {
            this.dbname = str;
            this.key = readableMap.getString("key");
            this.pageSize = SqlcipherPluginConverter.getInt(readableMap, "pageSize", 0);
            int i = 268435456;
            try {
                String string = SqlcipherPluginConverter.getString(readableMap, "assetFilename", (String) null);
                this.assetFilename = string;
                if (string != null && string.length() > 0 && SqlcipherPluginConverter.getBoolean(readableMap, "readOnly", false)) {
                    i = 1;
                }
            } catch (Exception e) {
                FLog.m1292e(SqlcipherPlugin.TAG, "Error retrieving assetFilename or mode from options:", e);
            }
            this.openFlags = i;
            boolean z = SqlcipherPluginConverter.getBoolean(readableMap, "androidLockWorkaround", false);
            this.androidLockWorkaround = z;
            if (z) {
                FLog.m1303i(SqlcipherPlugin.TAG, "Android db closing/locking workaround applied");
            }
            this.f3677q = new LinkedBlockingQueue();
            this.openCbc = callbackContext;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                this.mydb = SqlcipherPlugin.this.openDatabase(this.dbname, this.key, this.assetFilename, this.openFlags, this.pageSize, this.openCbc);
                DBQuery dBQuery = null;
                try {
                    Object objTake = this.f3677q.take();
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
                                this.mydb = SqlcipherPlugin.this.openDatabase(this.dbname, this.key, "", this.openFlags, this.pageSize, null);
                            }
                        }
                        objTake = this.f3677q.take();
                    }
                } catch (Exception e) {
                    FLog.m1292e(SqlcipherPlugin.TAG, "unexpected error", e);
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
                            FLog.m1292e(SqlcipherPlugin.TAG, "couldn't delete database", e2);
                            dBQuery.cbc.error("couldn't delete database: " + e2);
                        }
                    }
                } catch (Exception e3) {
                    FLog.m1292e(SqlcipherPlugin.TAG, "couldn't close database", e3);
                    CallbackContext callbackContext = dBQuery.cbc;
                    if (callbackContext != null) {
                        callbackContext.error("couldn't close database: " + e3);
                    }
                }
            } catch (SQLException e4) {
                FLog.m1292e(SqlcipherPlugin.TAG, "SQLite error opening database, stopping db thread", e4);
                CallbackContext callbackContext2 = this.openCbc;
                if (callbackContext2 != null) {
                    callbackContext2.error("Can't open database." + e4);
                }
                SqlcipherPlugin.dbrmap.remove(this.dbname);
            } catch (Exception e5) {
                FLog.m1292e(SqlcipherPlugin.TAG, "Unexpected error opening database, stopping db thread", e5);
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
