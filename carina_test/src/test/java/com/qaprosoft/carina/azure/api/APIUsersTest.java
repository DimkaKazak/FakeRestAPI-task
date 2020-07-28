package com.qaprosoft.carina.azure.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.carina.azure.api.users.*;
import com.qaprosoft.carina.azure.api.utils.Utils;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APIUsersTest {

    @Test(description = "USER POST#0001")
    @MethodOwner(owner = "Dima")
    public void testPostUser() throws Exception {
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postUserMethod.callAPI();
    }

    @Test(description = "USER PUT#0001")
    @MethodOwner(owner = "Dima")
    public void testPutUser() throws Exception {
        PutUserMethod putUserMethod = new PutUserMethod(1);
        putUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putUserMethod.callAPI();
        putUserMethod.validateResponse();
    }

    @Test(description = "USER DELETE#0001")
    @MethodOwner(owner = "Dima")
    public void testDeleteUser() throws Exception {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(1);
        deleteUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteUserMethod.callAPI();
    }


    @Test(description = "USER GET#0001")
    @MethodOwner(owner = "Dima")
    public void testGetUser() throws Exception {
        GetUserMethod getUserMethod = new GetUserMethod(1);
        getUserMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getUserMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(response, User.class);

        Assert.assertNotNull(user);
        getUserMethod.validateResponseAgainstSchema(Utils.USER_SCHEMA);
        Utils.checkFieldsNotNull(user);
        Assert.assertEquals(user.getId(), 1);
    }

    @Test(description = "USER GET#0002")
    @MethodOwner(owner = "Dima")
    public void testGetUsers() throws Exception {
        GetUsersMethod getUsersMethod = new GetUsersMethod();
        getUsersMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getUsersMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, User.class));

        for (User user : users){
            Assert.assertNotNull(user);
            Utils.checkFieldsNotNull(user);
        }
    }
}
