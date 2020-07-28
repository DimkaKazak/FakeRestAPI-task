package com.qaprosoft.carina.azure.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.carina.azure.api.activities.Activity;
import com.qaprosoft.carina.azure.api.activities.DeleteActivityMethod;
import com.qaprosoft.carina.azure.api.activities.GetActivityMethod;
import com.qaprosoft.carina.azure.api.activities.PostActivityMethod;
import com.qaprosoft.carina.azure.api.authors.*;
import com.qaprosoft.carina.azure.api.books.Book;
import com.qaprosoft.carina.azure.api.utils.Utils;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APIAuthorsTest {

    @Test(description = "AUTHOR POST#0001")
    @MethodOwner(owner = "Dima")
    public void testPostAuthor() throws Exception {
        PostAuthorMethod postAuthorMethod = new PostAuthorMethod();
        postAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postAuthorMethod.callAPI();
    }

    @Test(description = "AUTHOR PUT#0001")
    @MethodOwner(owner = "Dima")
    public void testPutAuthor() throws Exception {
        PutAuthorMethod putAuthorMethod = new PutAuthorMethod(1);
        putAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putAuthorMethod.callAPI();
        putAuthorMethod.validateResponse();
    }

    @Test(description = "AUTHOR DELETE#0001")
    @MethodOwner(owner = "Dima")
    public void testDeleteAuthor() throws Exception {
        DeleteAuthorMethod deleteAuthorMethod = new DeleteAuthorMethod(1);
        deleteAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteAuthorMethod.callAPI();
    }


    @Test(description = "AUTHOR GET#0001")
    @MethodOwner(owner = "Dima")
    public void testGetAuthor() throws Exception {
        GetAuthorMethod getAuthorMethod = new GetAuthorMethod(1);
        getAuthorMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getAuthorMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        Author author = mapper.readValue(response, Author.class);

        Assert.assertNotNull(author);
        getAuthorMethod.validateResponseAgainstSchema(Utils.AUTHOR_SCHEMA);
        Utils.checkFieldsNotNull(author);
        Assert.assertEquals(author.getId(), 1);
    }

    @Test(description = "AUTHOR GET#0002")
    @MethodOwner(owner = "Dima")
    public void testGetAuthors() throws Exception {
        GetAuthorsMethod getAuthorsMethod = new GetAuthorsMethod();
        getAuthorsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getAuthorsMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<Author> authors = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Author.class));

        for (Author author : authors){
            Assert.assertNotNull(author);
            Utils.checkFieldsNotNull(author);
        }
    }

    @Test(description = "AUTHOR GET#0003")
    @MethodOwner(owner = "Dima")
    public void testGetAuthorBook() throws Exception {
        GetAuthorBookMethod getAuthorBookMethod = new GetAuthorBookMethod(1);
        getAuthorBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getAuthorBookMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<Author> authors = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Author.class));

        for (Author author : authors){
            Assert.assertNotNull(author);
            Utils.checkFieldsNotNull(author);
            Assert.assertEquals(author.getIdBook(), 1);
        }
    }

}
