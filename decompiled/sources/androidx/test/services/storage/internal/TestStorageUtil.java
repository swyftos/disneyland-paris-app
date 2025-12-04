package androidx.test.services.storage.internal;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.test.internal.util.Checks;
import androidx.test.services.storage.TestStorageException;
import com.contentsquare.android.core.system.DeviceInfo;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class TestStorageUtil {
    public static InputStream getInputStream(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        Checks.checkNotNull(uri);
        ContentProviderClient contentProviderClientMakeContentProviderClient = null;
        try {
            try {
                contentProviderClientMakeContentProviderClient = makeContentProviderClient(contentResolver, uri);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new ParcelFileDescriptor.AutoCloseInputStream(contentProviderClientMakeContentProviderClient.openFile(uri, "r")));
                contentProviderClientMakeContentProviderClient.release();
                return bufferedInputStream;
            } catch (RemoteException e) {
                String strValueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 35);
                sb.append("Unable to access content provider: ");
                sb.append(strValueOf);
                throw new TestStorageException(sb.toString(), e);
            }
        } catch (Throwable th) {
            if (contentProviderClientMakeContentProviderClient != null) {
                contentProviderClientMakeContentProviderClient.release();
            }
            throw th;
        }
    }

    public static OutputStream getOutputStream(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        Checks.checkNotNull(uri);
        ContentProviderClient contentProviderClientMakeContentProviderClient = null;
        try {
            try {
                contentProviderClientMakeContentProviderClient = makeContentProviderClient(contentResolver, uri);
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(contentProviderClientMakeContentProviderClient.openFile(uri, DeviceInfo.WIDTH));
                contentProviderClientMakeContentProviderClient.release();
                return autoCloseOutputStream;
            } catch (RemoteException e) {
                String strValueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 35);
                sb.append("Unable to access content provider: ");
                sb.append(strValueOf);
                throw new TestStorageException(sb.toString(), e);
            }
        } catch (Throwable th) {
            if (contentProviderClientMakeContentProviderClient != null) {
                contentProviderClientMakeContentProviderClient.release();
            }
            throw th;
        }
    }

    private static ContentProviderClient makeContentProviderClient(ContentResolver contentResolver, Uri uri) {
        Checks.checkNotNull(contentResolver);
        ContentProviderClient contentProviderClientAcquireContentProviderClient = contentResolver.acquireContentProviderClient(uri);
        if (contentProviderClientAcquireContentProviderClient != null) {
            return contentProviderClientAcquireContentProviderClient;
        }
        throw new TestStorageException(String.format("No content provider registered for: %s. Are all test services apks installed?", uri));
    }
}
