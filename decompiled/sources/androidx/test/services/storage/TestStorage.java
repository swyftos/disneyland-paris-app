package androidx.test.services.storage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.services.storage.file.HostedFile;
import androidx.test.services.storage.file.PropertyFile;
import androidx.test.services.storage.internal.TestStorageUtil;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

@ExperimentalTestStorage
/* loaded from: classes2.dex */
public final class TestStorage {
    private static final String TAG = "TestStorage";
    private final ContentResolver contentResolver;

    public TestStorage() {
        this(InstrumentationRegistry.getInstrumentation().getTargetContext().getContentResolver());
    }

    public TestStorage(@Nonnull ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public static Uri getInputFileUri(@Nonnull String str) {
        Checks.checkNotNull(str);
        return HostedFile.buildUri(HostedFile.FileHost.TEST_FILE, str);
    }

    public static Uri getOutputFileUri(@Nonnull String str) {
        Checks.checkNotNull(str);
        return HostedFile.buildUri(HostedFile.FileHost.OUTPUT, str);
    }

    public InputStream openInputFile(@Nonnull String str) throws FileNotFoundException {
        return TestStorageUtil.getInputStream(getInputFileUri(str), this.contentResolver);
    }

    public String getInputArg(@Nonnull String str) {
        Checks.checkNotNull(str);
        Uri uriBuildUri = PropertyFile.buildUri(PropertyFile.Authority.TEST_ARGS, str);
        Cursor cursor = null;
        try {
            Cursor cursorDoQuery = doQuery(this.contentResolver, uriBuildUri);
            if (cursorDoQuery.getCount() == 0) {
                throw new TestStorageException(String.format("Query for URI '%s' did not return any results. Make sure the argName is actually being passed in as a test argument.", uriBuildUri));
            }
            if (cursorDoQuery.getCount() > 1) {
                throw new TestStorageException(String.format("Query for URI '%s' returned more than one result. Weird.", uriBuildUri));
            }
            cursorDoQuery.moveToFirst();
            String string = cursorDoQuery.getString(PropertyFile.Column.VALUE.getPosition());
            cursorDoQuery.close();
            return string;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public Map<String, String> getInputArgs() {
        Cursor cursorDoQuery = null;
        try {
            cursorDoQuery = doQuery(this.contentResolver, PropertyFile.buildUri(PropertyFile.Authority.TEST_ARGS));
            return getProperties(cursorDoQuery);
        } finally {
            if (cursorDoQuery != null) {
                cursorDoQuery.close();
            }
        }
    }

    public OutputStream openOutputFile(@Nonnull String str) throws FileNotFoundException {
        Checks.checkNotNull(str);
        return TestStorageUtil.getOutputStream(getOutputFileUri(str), this.contentResolver);
    }

    public void addOutputProperties(Map<String, Serializable> map) throws Throwable {
        if (map == null || map.isEmpty()) {
            return;
        }
        Map<String, Serializable> outputProperties = getOutputProperties();
        outputProperties.putAll(map);
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(TestStorageUtil.getOutputStream(getPropertyFileUri(), this.contentResolver)));
                try {
                    objectOutputStream2.writeObject(outputProperties);
                    silentlyClose(objectOutputStream2);
                } catch (FileNotFoundException e) {
                    e = e;
                    throw new TestStorageException("Unable to create file", e);
                } catch (IOException e2) {
                    e = e2;
                    throw new TestStorageException("I/O error occurred during reading test properties.", e);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    silentlyClose(objectOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.test.services.storage.TestStorage] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public Map<String, Serializable> getOutputProperties() throws Throwable {
        InputStream inputStream;
        Uri propertyFileUri = getPropertyFileUri();
        ObjectInputStream objectInputStream = null;
        try {
            try {
                this = TestStorageUtil.getInputStream(propertyFileUri, this.contentResolver);
                try {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(this);
                    try {
                        Map<String, Serializable> map = (Map) objectInputStream2.readObject();
                        if (map == null) {
                            map = new HashMap<>();
                        }
                        silentlyClose(objectInputStream2);
                        silentlyClose((InputStream) this);
                        return map;
                    } catch (FileNotFoundException unused) {
                        objectInputStream = objectInputStream2;
                        Log.i(TAG, String.format("%s: does not exist, we must be the first call.", propertyFileUri));
                        inputStream = this;
                        silentlyClose(objectInputStream);
                        silentlyClose(inputStream);
                        return new HashMap();
                    } catch (IOException | ClassNotFoundException e) {
                        e = e;
                        objectInputStream = objectInputStream2;
                        Log.w(TAG, "Failed to read recorded stats!", e);
                        inputStream = this;
                        silentlyClose(objectInputStream);
                        silentlyClose(inputStream);
                        return new HashMap();
                    } catch (Throwable th) {
                        th = th;
                        objectInputStream = objectInputStream2;
                        silentlyClose(objectInputStream);
                        silentlyClose((InputStream) this);
                        throw th;
                    }
                } catch (FileNotFoundException unused2) {
                } catch (IOException | ClassNotFoundException e2) {
                    e = e2;
                }
            } catch (FileNotFoundException unused3) {
                this = 0;
            } catch (IOException | ClassNotFoundException e3) {
                e = e3;
                this = 0;
            } catch (Throwable th2) {
                th = th2;
                this = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static Uri getPropertyFileUri() {
        return HostedFile.buildUri(HostedFile.FileHost.EXPORT_PROPERTIES, "properties.dat");
    }

    private static Cursor doQuery(ContentResolver contentResolver, Uri uri) {
        Checks.checkNotNull(contentResolver);
        Checks.checkNotNull(uri);
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        if (cursorQuery != null) {
            return cursorQuery;
        }
        throw new TestStorageException(String.format("Failed to resolve query for URI: %s", uri));
    }

    private static Map getProperties(Cursor cursor) {
        Checks.checkNotNull(cursor);
        HashMap map = new HashMap();
        while (cursor.moveToNext()) {
            map.put(cursor.getString(PropertyFile.Column.NAME.getPosition()), cursor.getString(PropertyFile.Column.VALUE.getPosition()));
        }
        return map;
    }

    private static void silentlyClose(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void silentlyClose(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
