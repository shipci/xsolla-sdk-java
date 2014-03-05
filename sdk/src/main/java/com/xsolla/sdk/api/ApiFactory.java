package com.xsolla.sdk.api;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.xsolla.sdk.Project;

public class ApiFactory {

    public static final String BASE_URL = "https://api.xsolla.com";

    protected Project project;
    protected String baseUrl;
    protected AsyncHttpClient asyncHttpClient;

    public ApiFactory(Project project, String baseUrl, AsyncHttpClient asyncHttpClient) {
        this.project = project;
        this.baseUrl = baseUrl;
        this.asyncHttpClient = asyncHttpClient;
    }

    public ApiFactory(Project project) {
        this(project, BASE_URL, null);
        this.asyncHttpClient = this.getAsyncHttpClient();
    }

    public SubscriptionsApi getSubscriptionsApi() {
        return new SubscriptionsApi(this.asyncHttpClient, this.baseUrl, project);
    }

    public MobilePaymentApi getMobilePaymentApi() {
        return new MobilePaymentApi(this.asyncHttpClient, this.baseUrl, project);
    }

    protected AsyncHttpClient getAsyncHttpClient() {
        AsyncHttpClientConfig.Builder configBuilder = new AsyncHttpClientConfig.Builder();
        return new AsyncHttpClient(configBuilder.build());
    }
}
