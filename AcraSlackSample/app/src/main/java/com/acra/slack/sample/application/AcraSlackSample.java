package com.acra.slack.sample.application;

import android.app.Application;

import com.acra.slack.sample.acra.CrashSender;
import com.acra.slack.sample.network.ClientApi;

import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by romantolmachev on 11/3/15.
 */
@ReportsCrashes()
public class AcraSlackSample extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ClientApi.initialize();

        ACRA.init(this);
        ACRA.getErrorReporter().setReportSender(new CrashSender());
    }

}