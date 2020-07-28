package com.qaprosoft.carina.azure.api.utils;

import org.testng.Assert;

import java.lang.reflect.Field;

public class Utils {
    public final static String ACTIVITY_SCHEMA = "api/activities/_get/responseActivity.schema";
    public final static String AUTHOR_SCHEMA   = "api/authors/_get/responseAuthor.schema";
    public final static String BOOK_SCHEMA     = "api/books/_get/responseBook.schema";
    public final static String PHOTO_SCHEMA    = "api/photos/_get/responsePhoto.schema";
    public final static String USER_SCHEMA     = "api/users/_get/responseUser.schema";


    public static int checkFieldsNotNull(Object object) {
        for (Field field : object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                Assert.assertNotNull(field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 1;
    }
}
