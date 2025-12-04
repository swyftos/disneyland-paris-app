package com.michaelflisar.lumberjack;

import android.content.Context;

/* loaded from: classes4.dex */
public class FileLoggingSetup {
    private final boolean logOnBackgroundThread;
    private final String mFileExtension;
    private final FileLoggingMode mFileLoggingMode;
    private final String mFileName;
    private final String mFileSizeLimit;
    private final String mFolderPath;
    private final int mLogFilesToKeep;
    private final String mLogPattern;

    private FileLoggingSetup(String str, int i, String str2, String str3, String str4, FileLoggingMode fileLoggingMode, String str5, boolean z) {
        this.mFolderPath = str;
        this.mLogFilesToKeep = i;
        this.mLogPattern = str2;
        this.mFileName = str3;
        this.mFileExtension = str4;
        this.mFileLoggingMode = fileLoggingMode;
        this.mFileSizeLimit = str5;
        this.logOnBackgroundThread = z;
    }

    public String getFolderPath() {
        return this.mFolderPath;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFileExtension() {
        return this.mFileExtension;
    }

    public int getLogFilesToKeep() {
        return this.mLogFilesToKeep;
    }

    public String getLogPattern() {
        return this.mLogPattern;
    }

    public FileLoggingMode getFileLoggingMode() {
        return this.mFileLoggingMode;
    }

    public String getFileSizeLimit() {
        return this.mFileSizeLimit;
    }

    public boolean isLogOnBackgroundThread() {
        return this.logOnBackgroundThread;
    }

    public static class Builder {
        private boolean logOnBackgroundThread;
        private String mFileExtension;
        private FileLoggingMode mFileLoggingMode;
        private String mFileName;
        private String mFileSizeLimit;
        private String mFolderPath;
        private int mLogFilesToKeep;
        private String mLogPattern;

        public Builder(Context context) {
            FileLoggingSetup.requireNonNull(context);
            this.mFolderPath = context.getFileStreamPath("").getAbsolutePath();
            this.mLogFilesToKeep = 7;
            this.mLogPattern = "%d\t%msg%n";
            this.mFileName = "log";
            this.mFileExtension = "log";
            this.mFileLoggingMode = FileLoggingMode.DAILY_ROLLOVER;
            this.mFileSizeLimit = "10MB";
            this.logOnBackgroundThread = false;
        }

        public Builder setFolderPath(String str) {
            FileLoggingSetup.requireNonNull(str);
            this.mFolderPath = str;
            return this;
        }

        public Builder setFileName(String str) {
            FileLoggingSetup.requireNonNull(str);
            this.mFileName = str;
            return this;
        }

        public Builder setFileExtension(String str) {
            FileLoggingSetup.requireNonNull(str);
            this.mFileExtension = str;
            return this;
        }

        public Builder setLogFilesToKeep(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("logFilesToKeep must be > 0");
            }
            this.mLogFilesToKeep = i;
            return this;
        }

        public Builder setLogPattern(String str) {
            FileLoggingSetup.requireNonNull(str);
            this.mLogPattern = str;
            return this;
        }

        public Builder setFileLoggingMode(FileLoggingMode fileLoggingMode) {
            this.mFileLoggingMode = fileLoggingMode;
            return this;
        }

        public Builder setFileSizeLimit(String str) {
            FileLoggingSetup.requireNonNull(str);
            this.mFileSizeLimit = str;
            return this;
        }

        public Builder setLogOnBackgroundThread(boolean z) {
            this.logOnBackgroundThread = z;
            return this;
        }

        public FileLoggingSetup build() {
            return new FileLoggingSetup(this.mFolderPath, this.mLogFilesToKeep, this.mLogPattern, this.mFileName, this.mFileExtension, this.mFileLoggingMode, this.mFileSizeLimit, this.logOnBackgroundThread);
        }
    }

    static void requireNonNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("This object should not be null");
        }
    }
}
