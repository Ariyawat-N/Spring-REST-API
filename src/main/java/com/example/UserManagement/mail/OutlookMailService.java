package com.example.UserManagement.mail;

public class OutlookMailService implements MailService{
    // Variables
    private String url;
    private String port;

    //Constructor
    public OutlookMailService() {
    }

    //Setter
    public void setUrl(String url) {
        this.url = url;
    }

    //Setter
    public void setPort(String port) {
        this.port = port;
    }


    public void sendMail(String email, String content) {
        System.out.println("Sent by outlook");
    }
}
