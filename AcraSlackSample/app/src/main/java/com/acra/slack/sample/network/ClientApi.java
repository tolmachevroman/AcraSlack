package com.acra.slack.sample.network;

import android.util.Log;

import com.acra.slack.sample.network.requests.SlackMessageWrapper;
import com.squareup.okhttp.OkHttpClient;

import org.acra.ReportField;

import java.util.EnumMap;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

/**
 * Created by romantolmachev on 11/3/15.
 */
public class ClientApi {

    private static ClientApiDefinitions serviceSlack;

    public static void initialize() {

        RestAdapter.Log restLogs = new RestAdapter.Log() {
            @Override
            public void log(String s) {
                Log.d("CLIENT API", s);
            }
        };

        // create client
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(1, TimeUnit.MINUTES);
        okHttpClient.setWriteTimeout(1, TimeUnit.MINUTES);
        okHttpClient.setConnectTimeout(1, TimeUnit.MINUTES);

        //slack
        RestAdapter slackRestAdapter = new RestAdapter.Builder()
                .setEndpoint(Urls.SLACK_ENDPOINT)
                .setLog(restLogs)
                .setClient(new OkClient(okHttpClient))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        serviceSlack = slackRestAdapter.create(ClientApiDefinitions.class);
    }

    /**
     * Send message to your Slack channel defined in {@link com.acra.slack.sample.network.Urls}
     *
     * @param reportId Report id
     * @param report   Map with report fields
     * @param appName  Application name
     */
    public static void sendSlackMessage(String reportId, EnumMap<ReportField, String> report, String appName) {

        serviceSlack.sendCrash(new SlackMessageWrapper(reportId, report, appName), new Callback<String>() {
            @Override
            public void success(String s, Response response) {
            }

            @Override
            public void failure(RetrofitError error) {
            }
        });
    }
}