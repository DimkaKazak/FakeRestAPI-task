package com.qaprosoft.carina.azure.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaprosoft.carina.azure.api.photos.*;
import com.qaprosoft.carina.azure.api.utils.Utils;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class APIPhotosTest {

    @Test(description = "PHOTO POST#0001")
    @MethodOwner(owner = "Dima")
    public void testPostPhoto() throws Exception {
        PostPhotoMethod postPhotoMethod = new PostPhotoMethod();
        postPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        postPhotoMethod.callAPI();
    }

    @Test(description = "PHOTO PUT#0001")
    @MethodOwner(owner = "Dima")
    public void testPutPhoto() throws Exception {
        PutPhotoMethod putPhotoMethod = new PutPhotoMethod(1);
        putPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        putPhotoMethod.callAPI();
        putPhotoMethod.validateResponse();
    }

    @Test(description = "PHOTO DELETE#0001")
    @MethodOwner(owner = "Dima")
    public void testDeletePhoto() throws Exception {
        DeletePhotoMethod deletePhotoMethod = new DeletePhotoMethod(1);
        deletePhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePhotoMethod.callAPI();
    }


    @Test(description = "PHOTO GET#0001")
    @MethodOwner(owner = "Dima")
    public void testGetPhoto() throws Exception {
        GetPhotoMethod getPhotoMethod = new GetPhotoMethod(1);
        getPhotoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getPhotoMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        Photo photo = mapper.readValue(response, Photo.class);

        Assert.assertNotNull(photo);
        getPhotoMethod.validateResponseAgainstSchema(Utils.PHOTO_SCHEMA);
        Utils.checkFieldsNotNull(photo);
        Assert.assertEquals(photo.getId(), 1);
    }

    @Test(description = "PHOTO GET#0002")
    @MethodOwner(owner = "Dima")
    public void testGetPhotos() throws Exception {
        GetPhotosMethod getPhotosMethod = new GetPhotosMethod();
        getPhotosMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getPhotosMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<Photo> photos = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Photo.class));

        for (Photo photo : photos){
            Assert.assertNotNull(photo);
            Utils.checkFieldsNotNull(photo);
        }
    }

    @Test(description = "PHOTO GET#0003")
    @MethodOwner(owner = "Dima")
    public void testGetCoverBook() throws Exception {
        GetCoverBookMethod getCoverBookMethod = new GetCoverBookMethod(1);
        getCoverBookMethod.expectResponseStatus(HttpResponseStatusType.OK_200);

        String response = getCoverBookMethod.callAPI().asString();
        ObjectMapper mapper = new ObjectMapper();
        List<Photo> photos = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Photo.class));


        for (Photo photo : photos){
            Assert.assertNotNull(photo);
            Utils.checkFieldsNotNull(photo);
            Assert.assertEquals(photo.getIdBook(), 1);
        }
    }
}
