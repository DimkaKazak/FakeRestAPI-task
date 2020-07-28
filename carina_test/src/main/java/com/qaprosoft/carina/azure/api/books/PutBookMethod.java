package com.qaprosoft.carina.azure.api.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class PutBookMethod extends AbstractApiMethodV2 {
    public PutBookMethod(Integer id) {
        super("api/books/_put/rq.json", "api/books/_put/rs.json", "api/books/book.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
