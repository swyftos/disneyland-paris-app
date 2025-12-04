package androidx.test.rule.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.test.mock.MockContentResolver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

@Beta
/* loaded from: classes2.dex */
public class ProviderTestRule implements TestRule {
    private final DelegatingContext context;
    private final Set databaseArgsSet;
    private final Set providersRef;
    private final ContentResolver resolver;

    protected void afterProviderCleanedUp() {
    }

    protected void beforeProviderSetup() {
    }

    ProviderTestRule(Set set, Set set2, ContentResolver contentResolver, DelegatingContext delegatingContext) {
        this.providersRef = set;
        this.databaseArgsSet = set2;
        this.resolver = contentResolver;
        this.context = delegatingContext;
    }

    public ContentResolver getResolver() {
        return this.resolver;
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return new ProviderStatement(statement);
    }

    public void runDatabaseCommands(@NonNull String str, @NonNull String... strArr) throws SQLException {
        Checks.checkNotNull(str);
        Checks.checkNotNull(strArr);
        if (strArr.length > 0) {
            SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = this.context.openOrCreateDatabase(str, 0, null);
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        sQLiteDatabaseOpenOrCreateDatabase.execSQL(str2);
                    } catch (SQLiteException e) {
                        Log.e("ProviderTestRule", String.format("Error executing sql command %s, possibly wrong or duplicated commands (e.g. same table insertion command without checking current table existence).", str2));
                        throw e;
                    }
                }
            }
        }
    }

    public void revokePermission(@NonNull String str) {
        Checks.checkArgument(!TextUtils.isEmpty(str), "permission cannot be null or empty");
        this.context.addRevokedPermission(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpProviders() throws Throwable {
        beforeProviderSetup();
        Iterator it = this.databaseArgsSet.iterator();
        while (it.hasNext()) {
            setUpProvider((DatabaseArgs) it.next());
        }
    }

    private void setUpProvider(DatabaseArgs databaseArgs) throws Throwable {
        if (databaseArgs.hasDBDataFile()) {
            restoreDBDataFromFile(databaseArgs);
        }
        if (databaseArgs.hasDBCmdFile()) {
            collectDBCmdsFromFile(databaseArgs);
        }
        if (databaseArgs.hasDBCmds()) {
            runDatabaseCommands(databaseArgs.getDBName(), databaseArgs.getDBCmds());
        }
    }

    private void restoreDBDataFromFile(DatabaseArgs databaseArgs) throws IOException {
        File dBDataFile = databaseArgs.getDBDataFile();
        Checks.checkState(dBDataFile.exists(), String.format("The database file %s doesn't exist!", dBDataFile));
        String dBName = databaseArgs.getDBName();
        copyFile(dBDataFile, this.context.getDatabasePath(dBName));
        this.context.addDatabase(dBName);
    }

    private void collectDBCmdsFromFile(DatabaseArgs databaseArgs) throws Throwable {
        File dBCmdFile = databaseArgs.getDBCmdFile();
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(dBCmdFile), Charset.forName("UTF-8")));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            if (!TextUtils.isEmpty(line)) {
                                arrayList.add(line);
                            }
                        } else {
                            bufferedReader2.close();
                            databaseArgs.addDBCmds((String[]) arrayList.toArray(new String[arrayList.size()]));
                            return;
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        Log.e("ProviderTestRule", String.format("Cannot open command file %s to read", dBCmdFile));
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    private void copyFile(File file, File file2) throws IOException {
        File parentFile = file2.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            String str = String.format("error happened creating parent dir for file %s", file2);
            Log.e("ProviderTestRule", str);
            throw new IOException(str);
        }
        FileChannel channel = new FileInputStream(file).getChannel();
        FileChannel channel2 = new FileOutputStream(file2).getChannel();
        try {
            try {
                channel.transferTo(0L, channel.size(), channel2);
            } catch (IOException e) {
                Log.e("ProviderTestRule", String.format("error happened copying file from %s to %s", file, file2));
                throw e;
            }
        } finally {
            channel.close();
            channel2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanUpProviders() {
        Iterator it = this.providersRef.iterator();
        while (it.hasNext()) {
            ContentProvider contentProvider = (ContentProvider) ((WeakReference) it.next()).get();
            if (contentProvider != null) {
                contentProvider.shutdown();
            }
        }
        Iterator it2 = this.databaseArgsSet.iterator();
        while (it2.hasNext()) {
            String dBName = ((DatabaseArgs) it2.next()).getDBName();
            if (dBName != null) {
                this.context.deleteDatabase(dBName);
            }
        }
        afterProviderCleanedUp();
    }

    public static class Builder {
        private final Map databaseArgsMap;
        private String prefix;
        private final Map providerClasses;

        public <T extends ContentProvider> Builder(@NonNull Class<T> cls, @NonNull String str) {
            HashMap map = new HashMap();
            this.providerClasses = map;
            this.databaseArgsMap = new HashMap();
            this.prefix = "test.";
            Checks.checkNotNull(cls);
            Checks.checkNotNull(str);
            map.put(str, cls);
        }

        public Builder setPrefix(@NonNull String str) {
            Checks.checkArgument(!TextUtils.isEmpty(str), "The prefix cannot be null or empty");
            this.prefix = str;
            return this;
        }

        public Builder setDatabaseFile(@NonNull String str, @NonNull File file) {
            Checks.checkNotNull(str);
            Checks.checkNotNull(file);
            getDatabaseArgs(str).setDBDataFile(file);
            return this;
        }

        public Builder setDatabaseCommands(@NonNull String str, @NonNull String... strArr) {
            Checks.checkNotNull(str);
            Checks.checkNotNull(strArr);
            getDatabaseArgs(str).setDBCmds(strArr);
            return this;
        }

        public Builder setDatabaseCommandsFile(@NonNull String str, @NonNull File file) {
            Checks.checkNotNull(str);
            Checks.checkNotNull(file);
            getDatabaseArgs(str).setDBCmdFile(file);
            return this;
        }

        public <T extends ContentProvider> Builder addProvider(@NonNull Class<T> cls, @NonNull String str) {
            Checks.checkNotNull(cls);
            Checks.checkNotNull(str);
            Checks.checkState(this.providerClasses.size() > 0, "No existing provider yet while trying to add more");
            Checks.checkState(!this.providerClasses.containsKey(str), String.format("ContentProvider with authority %s already exists.", str));
            this.providerClasses.put(str, cls);
            return this;
        }

        public ProviderTestRule build() {
            HashSet hashSet = new HashSet();
            MockContentResolver mockContentResolver = new MockContentResolver();
            DelegatingContext delegatingContext = new DelegatingContext(InstrumentationRegistry.getInstrumentation().getTargetContext(), this.prefix, mockContentResolver);
            for (Map.Entry entry : this.providerClasses.entrySet()) {
                hashSet.add(new WeakReference(createProvider((String) entry.getKey(), (Class) entry.getValue(), mockContentResolver, delegatingContext)));
            }
            return new ProviderTestRule(hashSet, new HashSet(this.databaseArgsMap.values()), mockContentResolver, delegatingContext);
        }

        private ContentProvider createProvider(String str, Class cls, MockContentResolver mockContentResolver, Context context) {
            try {
                ContentProvider contentProvider = (ContentProvider) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                ProviderInfo providerInfo = new ProviderInfo();
                providerInfo.authority = str;
                contentProvider.attachInfo(context, providerInfo);
                mockContentResolver.addProvider(providerInfo.authority, contentProvider);
                return contentProvider;
            } catch (IllegalAccessException e) {
                String strValueOf = String.valueOf(cls.toString());
                Log.e("ProviderTestRule", strValueOf.length() != 0 ? "IllegalAccessException occurred when trying create new Instance for ".concat(strValueOf) : new String("IllegalAccessException occurred when trying create new Instance for "));
                throw new RuntimeException(e);
            } catch (InstantiationException e2) {
                String strValueOf2 = String.valueOf(cls.toString());
                Log.e("ProviderTestRule", strValueOf2.length() != 0 ? "InstantiationException occurred when trying create new Instance for ".concat(strValueOf2) : new String("InstantiationException occurred when trying create new Instance for "));
                throw new RuntimeException(e2);
            } catch (NoSuchMethodException e3) {
                String strValueOf3 = String.valueOf(cls.toString());
                Log.e("ProviderTestRule", strValueOf3.length() != 0 ? "NoSuchMethodException occurred when trying create new Instance for ".concat(strValueOf3) : new String("NoSuchMethodException occurred when trying create new Instance for "));
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                String strValueOf4 = String.valueOf(cls.toString());
                Log.e("ProviderTestRule", strValueOf4.length() != 0 ? "InvocationTargetException occurred when trying create new Instance for ".concat(strValueOf4) : new String("InvocationTargetException occurred when trying create new Instance for "));
                throw new RuntimeException(e4);
            }
        }

        private DatabaseArgs getDatabaseArgs(String str) {
            if (this.databaseArgsMap.containsKey(str)) {
                return (DatabaseArgs) this.databaseArgsMap.get(str);
            }
            DatabaseArgs databaseArgs = new DatabaseArgs(str);
            this.databaseArgsMap.put(str, databaseArgs);
            return databaseArgs;
        }
    }

    private class ProviderStatement extends Statement {
        private final Statement base;

        public ProviderStatement(Statement statement) {
            this.base = statement;
        }

        @Override // org.junit.runners.model.Statement
        public void evaluate() {
            try {
                ProviderTestRule.this.setUpProviders();
                this.base.evaluate();
            } finally {
                ProviderTestRule.this.cleanUpProviders();
            }
        }
    }
}
