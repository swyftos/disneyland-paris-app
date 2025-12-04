package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class BucketWebsiteConfiguration implements Serializable {
    private String errorDocument;
    private String indexDocumentSuffix;
    private RedirectRule redirectAllRequestsTo;
    private List routingRules = new LinkedList();

    public BucketWebsiteConfiguration() {
    }

    public BucketWebsiteConfiguration(String str) {
        this.indexDocumentSuffix = str;
    }

    public BucketWebsiteConfiguration(String str, String str2) {
        this.indexDocumentSuffix = str;
        this.errorDocument = str2;
    }

    public String getIndexDocumentSuffix() {
        return this.indexDocumentSuffix;
    }

    public void setIndexDocumentSuffix(String str) {
        this.indexDocumentSuffix = str;
    }

    public String getErrorDocument() {
        return this.errorDocument;
    }

    public void setErrorDocument(String str) {
        this.errorDocument = str;
    }

    public void setRedirectAllRequestsTo(RedirectRule redirectRule) {
        this.redirectAllRequestsTo = redirectRule;
    }

    public RedirectRule getRedirectAllRequestsTo() {
        return this.redirectAllRequestsTo;
    }

    public BucketWebsiteConfiguration withRedirectAllRequestsTo(RedirectRule redirectRule) {
        this.redirectAllRequestsTo = redirectRule;
        return this;
    }

    public void setRoutingRules(List<RoutingRule> list) {
        this.routingRules = list;
    }

    public List<RoutingRule> getRoutingRules() {
        return this.routingRules;
    }

    public BucketWebsiteConfiguration withRoutingRules(List<RoutingRule> list) {
        this.routingRules = list;
        return this;
    }
}
