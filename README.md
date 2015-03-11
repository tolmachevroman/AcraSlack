# AcraSlack

ACRA (https://github.com/ACRA/acra) is a very popular open-source bug tracking library for Android. Normally you would need your own backend to collect reports, however it is possible to integrate ACRA into your Slack account directly.

###### First, you need to add ACRA to your project. In Android Studio it means adding dependency to Gradle
```
compile 'ch.acra:acra:4.6.1'
```
and initialize ACRA in your Application class
```
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
```
###### Then, you need to add Incoming Webhooks API integration (https://api.slack.com/incoming-webhooks). Create new channel for bugs tracking and copy it's url to Urls class
```
public static final String SLACK_CRASH_CHANNEL = "/M03H6CG1F/B07V91KN6/T8HANY51iQygHlckHX8KQ0Zk";
```
That's it! Now each time your app is crashed you'll receive nice instant message right into your Slack channel.
