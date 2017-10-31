package hu.tokingame.potatoeskill.MyBaseClasses.Http;

import com.badlogic.gdx.Net;

/**
 * Created by tuskeb on 2017. 02. 12..
 */

public class HttpConnect {
    protected String url;
    protected int userID;
    protected String password;

    protected Net.HttpRequest httpRequest;

    public HttpConnect(String Url, int UserID, String Password) {
        httpRequest = new Net.HttpRequest(Net.HttpMethods.POST);
        httpRequest.setUrl(Url);
        httpRequest.setTimeOut(2000);
        this.url = Url;
        this.password = Password;
        this.userID = UserID;
    }

}
