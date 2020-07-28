package com.qaprosoft.carina.azure.api.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostBookMethod extends AbstractApiMethodV2 {
    public PostBookMethod() {
        super("api/books/_post/rq.json", null, "api/books/book.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
    }
}
