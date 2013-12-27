package org.feathercoin.monitoring;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.handler.TextRequestHandler;
import org.apache.wicket.request.http.WebResponse;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class JsonWebPage extends WebPage {

    public JsonWebPage(PageParameters pageParameters) {
        String json = "{\"data\":[{\"name\":\"13.12.2013\",\"value\":4},{\"name\":\"14.12.2013\",\"value\":20}]}";

        //allow requests from local files too to simplify testing of chart creation
        ((WebResponse)getResponse()).setHeader("Access-Control-Allow-Origin","*");
        getRequestCycle().scheduleRequestHandlerAfterCurrent(new TextRequestHandler("application/json", "UTF-8", json));
    }
}
