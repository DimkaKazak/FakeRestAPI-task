package com.qaprosoft.carina.azure.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.carina.azure.api.activities.DeleteActivityMethod;
import com.qaprosoft.carina.azure.api.activities.PostActivityMethod;
import com.qaprosoft.carina.azure.api.books.*;
import com.qaprosoft.carina.azure.api.utils.Utils;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APIBooksTest {

    @Test(description = "BOOK POST#0001")
    @MethodOwner(owner = "Dima")
    public void testPostBook() throws Exception {
        PostBookMethod postBookMethod = new PostBookMethod();
        postBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postBookMethod.callAPI();
    }

    @Test(description = "BOOK PUT#0001")
    @MethodOwner(owner = "Dima")
    public void testPutBook() throws Exception {
        PutBookMethod putBookMethod = new PutBookMethod(1);
        putBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putBookMethod.callAPI();
        putBookMethod.validateResponse();
    }

    @Test(description = "BOOK DELETE#0001")
    @MethodOwner(owner = "Dima")
    public void testDeleteBook() throws Exception {
        DeleteBookMethod deleteBookMethod = new DeleteBookMethod(1);
        deleteBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deleteBookMethod.callAPI();
    }


    @Test(description = "BOOK GET#0001")
    @MethodOwner(owner = "Dima")
    public void testGetBook() throws Exception {
        GetBookMethod getBookMethod = new GetBookMethod(1);
        getBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getBookMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(response, Book.class);

        Assert.assertNotNull(book);
        getBookMethod.validateResponseAgainstSchema(Utils.BOOK_SCHEMA);
        Utils.checkFieldsNotNull(book);
        Assert.assertEquals(book.getId(), 1);
    }

    @Test(description = "BOOK GET#0002")
    @MethodOwner(owner = "Dima")
    public void testGetBooks() throws Exception {
        GetBooksMethod getBooksMethod = new GetBooksMethod();
        getBooksMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getBooksMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<Book> books = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Book.class));

        for (Book book : books){
            Assert.assertNotNull(book);
            Utils.checkFieldsNotNull(book);
        }
    }

}
