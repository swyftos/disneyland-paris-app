package com.github.barteksc.pdfviewer;

import android.os.AsyncTask;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import io.legere.pdfiumandroid.PdfiumCore;
import io.legere.pdfiumandroid.util.Size;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
class DecodingAsyncTask extends AsyncTask {
    private boolean cancelled = false;
    private DocumentSource docSource;
    private String password;
    private PdfFile pdfFile;
    private WeakReference pdfViewReference;
    private PdfiumCore pdfiumCore;
    private int[] userPages;

    DecodingAsyncTask(DocumentSource documentSource, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.docSource = documentSource;
        this.userPages = iArr;
        this.pdfViewReference = new WeakReference(pDFView);
        this.password = str;
        this.pdfiumCore = pdfiumCore;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Throwable doInBackground(Void... voidArr) {
        try {
            PDFView pDFView = (PDFView) this.pdfViewReference.get();
            if (pDFView != null) {
                this.pdfFile = new PdfFile(this.pdfiumCore, this.docSource.createDocument(pDFView.getContext(), this.pdfiumCore, this.password), pDFView.getPageFitPolicy(), getViewSize(pDFView), this.userPages, pDFView.isOnDualPageMode(), pDFView.isSwipeVertical(), pDFView.getSpacingPx(), pDFView.isAutoSpacingEnabled(), pDFView.isFitEachPage(), pDFView.isOnLandscapeOrientation());
                return null;
            }
            return new NullPointerException("pdfView == null");
        } catch (Throwable th) {
            return th;
        }
    }

    private Size getViewSize(PDFView pDFView) {
        return new Size(pDFView.getWidth(), pDFView.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Throwable th) {
        PDFView pDFView = (PDFView) this.pdfViewReference.get();
        if (pDFView != null) {
            if (th != null) {
                pDFView.loadError(th);
            } else {
                if (this.cancelled) {
                    return;
                }
                pDFView.loadComplete(this.pdfFile);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.cancelled = true;
    }
}
