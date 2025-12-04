package com.amazonaws.services.s3.model;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class WebsiteConfiguration {
    private String errorDocument;
    private String indexDocumentSuffix;
    private String redirectAllRequestsTo;
    private List routingRules = new LinkedList();

    public void setIndexDocumentSuffix(String str) {
        this.indexDocumentSuffix = str;
    }

    public String getIndexDocumentSuffix() {
        return this.indexDocumentSuffix;
    }

    public WebsiteConfiguration withIndexDocumentSuffix(String str) {
        this.indexDocumentSuffix = str;
        return this;
    }

    public void setErrorDocument(String str) {
        this.errorDocument = str;
    }

    public String getErrorDocument() {
        return this.errorDocument;
    }

    public WebsiteConfiguration witherrorDocument(String str) {
        this.errorDocument = str;
        return this;
    }

    public void setRedirectAllRequestsTo(String str) {
        this.redirectAllRequestsTo = str;
    }

    public String getRedirectAllRequestsTo() {
        return this.redirectAllRequestsTo;
    }

    public WebsiteConfiguration withRedirectAllRequestsTo(String str) {
        this.redirectAllRequestsTo = str;
        return this;
    }

    public void setRoutingRules(List<RoutingRule> list) {
        this.routingRules = list;
    }

    public List<RoutingRule> getRoutingRule() {
        return this.routingRules;
    }

    public WebsiteConfiguration withRoutingRule(List<RoutingRule> list) {
        this.routingRules = list;
        return this;
    }
}
