# AcraSlack

ACRA (https://github.com/ACRA/acra) is a very popular open-source bug tracking library for Android. Normally you would need your own backend to collect reports, however it is possible to integrate ACRA into your Slack account directly.

###### Firstly, you need to add ACRA to your project. In Android Studio it means adding dependency to Gradle
```
compile 'ch.acra:acra:4.6.1'
```
###### and initializing ACRA in your Application class
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
###### Then, you need to add Incoming Webhooks API integration. 

![webhooks](https://cloud.githubusercontent.com/assets/560815/6597120/01576862-c7d9-11e4-87fa-d5ba8e138e78.png)

###### Create new channel for bugs tracking and copy it's url to Urls class

![webhooks2](https://cloud.githubusercontent.com/assets/560815/6597144/32e481da-c7d9-11e4-8b20-96aacfcb0c0e.png)

```
public static final String SLACK_CRASH_CHANNEL = "/M03H6CG1F/B07V91KN6/T8HANY51iQygHlckHX8KQ0Zk";
```
###### For more info, please check official documentation (https://api.slack.com/incoming-webhooks)
###### That's it! Now each time your app is crashed you'll receive nice instant message right into your Slack channel.

![acrasamplescreenshot](https://cloud.githubusercontent.com/assets/560815/6596912/72df4cea-c7d7-11e4-8ab0-a78f2dd238b7.png)
