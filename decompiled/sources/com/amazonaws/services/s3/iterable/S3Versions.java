package com.amazonaws.services.s3.iterable;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.VersionListing;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class S3Versions implements Iterable<S3VersionSummary> {
    private Integer batchSize;
    private String bucketName;
    private String key;
    private String prefix;
    private AmazonS3 s3;

    private S3Versions(AmazonS3 amazonS3, String str) {
        this.s3 = amazonS3;
        this.bucketName = str;
    }

    public static S3Versions inBucket(AmazonS3 amazonS3, String str) {
        return new S3Versions(amazonS3, str);
    }

    public static S3Versions withPrefix(AmazonS3 amazonS3, String str, String str2) {
        S3Versions s3Versions = new S3Versions(amazonS3, str);
        s3Versions.prefix = str2;
        return s3Versions;
    }

    public static S3Versions forKey(AmazonS3 amazonS3, String str, String str2) {
        S3Versions s3Versions = new S3Versions(amazonS3, str);
        s3Versions.key = str2;
        return s3Versions;
    }

    public S3Versions withBatchSize(int i) {
        this.batchSize = Integer.valueOf(i);
        return this;
    }

    public Integer getBatchSize() {
        return this.batchSize;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getKey() {
        return this.key;
    }

    public AmazonS3 getS3() {
        return this.s3;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    private class VersionIterator implements Iterator<S3VersionSummary> {
        private Iterator currentIterator;
        private VersionListing currentListing;
        private S3VersionSummary nextSummary;

        private VersionIterator() {
            this.currentListing = null;
            this.currentIterator = null;
            this.nextSummary = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            prepareCurrentListing();
            return nextMatchingSummary() != null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public S3VersionSummary next() {
            prepareCurrentListing();
            S3VersionSummary s3VersionSummaryNextMatchingSummary = nextMatchingSummary();
            this.nextSummary = null;
            return s3VersionSummaryNextMatchingSummary;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private S3VersionSummary nextMatchingSummary() {
            S3VersionSummary s3VersionSummary;
            if (S3Versions.this.getKey() == null || ((s3VersionSummary = this.nextSummary) != null && s3VersionSummary.getKey().equals(S3Versions.this.getKey()))) {
                return this.nextSummary;
            }
            return null;
        }

        private void prepareCurrentListing() {
            while (true) {
                if (this.currentListing != null && (this.currentIterator.hasNext() || !this.currentListing.isTruncated())) {
                    break;
                }
                if (this.currentListing == null) {
                    ListVersionsRequest listVersionsRequest = new ListVersionsRequest();
                    listVersionsRequest.setBucketName(S3Versions.this.getBucketName());
                    if (S3Versions.this.getKey() != null) {
                        listVersionsRequest.setPrefix(S3Versions.this.getKey());
                    } else {
                        listVersionsRequest.setPrefix(S3Versions.this.getPrefix());
                    }
                    listVersionsRequest.setMaxResults(S3Versions.this.getBatchSize());
                    this.currentListing = S3Versions.this.getS3().listVersions(listVersionsRequest);
                } else {
                    this.currentListing = S3Versions.this.getS3().listNextBatchOfVersions(this.currentListing);
                }
                this.currentIterator = this.currentListing.getVersionSummaries().iterator();
            }
            if (this.nextSummary == null && this.currentIterator.hasNext()) {
                this.nextSummary = (S3VersionSummary) this.currentIterator.next();
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<S3VersionSummary> iterator() {
        return new VersionIterator();
    }
}
