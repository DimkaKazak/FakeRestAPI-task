package com.qaprosoft.carina.azure.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.carina.azure.api.activities.*;
import com.qaprosoft.carina.azure.api.utils.Utils;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APIActivitiesTest extends AbstractTest {

    @Test(description = "ACTIVITY POST#0001")
    @MethodOwner(owner = "Dima")
    public void testPostActivity() throws Exception {
        PostActivityMethod postActivityMethod = new PostActivityMethod();
        postActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postActivityMethod.callAPI();
    }

    @Test(description = "ACTIVITY PUT#0001")
    @MethodOwner(owner = "Dima")
    public void testPutActivity() throws Exception {
        PutActivityMethod putActivityMethod = new PutActivityMethod(1);
        putActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putActivityMethod.callAPI();
        putActivityMethod.validateResponse();
    }

    @Test(description = "ACTIVITY DELETE#0001")
    @MethodOwner(owner = "Dima")
    public void testDeleteActivity() throws Exception {
        DeleteActivityMethod deleteActivityMethod = new DeleteActivityMethod(1);
        deleteActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteActivityMethod.callAPI();
    }

    @Test(description = "ACTIVITY GET#0001")
    @MethodOwner(owner = "Dima")
    public void testGetActivity() throws Exception {
        GetActivityMethod getActivityMethod = new GetActivityMethod(1);
        getActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getActivityMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        Activity activity = mapper.readValue(response, Activity.class);

        Assert.assertNotNull(activity);
        getActivityMethod.validateResponseAgainstSchema(Utils.ACTIVITY_SCHEMA);
        Utils.checkFieldsNotNull(activity);
        Assert.assertEquals(activity.getId(), 1);
    }

    @Test(description = "ACTIVITY GET#0002")
    @MethodOwner(owner = "Dima")
    public void testGetActivities() throws Exception {
        GetActivitiesMethod getActivityMethod = new GetActivitiesMethod();
        getActivityMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getActivityMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<Activity> activities = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Activity.class));

        for (Activity activity : activities){
            Assert.assertNotNull(activity);
            Utils.checkFieldsNotNull(activity);
        }
    }
}
