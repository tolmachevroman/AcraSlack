package com.acra.slack.sample.network.requests;

import com.google.gson.annotations.SerializedName;

import org.acra.ReportField;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * Created by romantolmachev on 11/3/15.
 */
public class SlackMessageWrapper {

    String username;

    @SerializedName("icon_emoji")
    String icon;

    ArrayList<MessageAttachment> attachments;

    public SlackMessageWrapper(String reportId, EnumMap<ReportField, String> report) {
        this.username = "crashbot#" + reportId;
        this.icon = ":crab:";
        this.attachments = new ArrayList<>();

        //we need 2 attachments: one for general info (android version, app version code, phone brand and model)
        //and second for stacktrace

        StringBuilder deviceInfoString = new StringBuilder();
        deviceInfoString.append(report.get(ReportField.BRAND) + " ");
        deviceInfoString.append(report.get(ReportField.PHONE_MODEL) + ", running Android version ");
        deviceInfoString.append(report.get(ReportField.ANDROID_VERSION) + ", application version ");
        deviceInfoString.append(report.get(ReportField.APP_VERSION_CODE));

        MessageAttachment generalInfoAttachment = new MessageAttachment("", "Device info" , deviceInfoString.toString(), "#36a64f");

        MessageAttachment stacktraceAttachment = new MessageAttachment("", "Stacktrace" , report.get(ReportField.STACK_TRACE), "#d61129");

        this.attachments.add(generalInfoAttachment);
        this.attachments.add(stacktraceAttachment);
    }

    private class MessageAttachment {
        String fallback;

        String color;

        ArrayList<MessageFields> fields;

        private MessageAttachment(String fallback, String title, String value, String color) {
            this.fallback = fallback;
            this.color = color;
            this.fields = new ArrayList<>();
            this.fields.add(new MessageFields(title, value));
        }
    }

    private class MessageFields {

        String title;

        String value;

        private MessageFields(String title, String value) {
            this.title = title;
            this.value = value;
        }
    }

}