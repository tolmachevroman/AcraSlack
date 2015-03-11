package com.acra.slack.sample.network;

import com.acra.slack.sample.network.requests.SlackMessageWrapper;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by romantolmachev on 11/3/15.
 */
public interface ClientApiDefinitions {

    @Headers("Content-Type: application/json, Content-Length: 8190")
    @POST(Urls.SLACK_CRASH_CHANNEL)
    void sendCrash(
            @Body SlackMessageWrapper wrapper,
            Callback<String> callback
    );

}
