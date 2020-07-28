package com.qaprosoft.carina.azure.api.books;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class DeleteBookMethod extends AbstractApiMethodV2 {

    public DeleteBookMethod(Integer id) {
        super(null, null, "api/books/book.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("azure_api_url"));
        replaceUrlPlaceholder("id", id.toString());
    }
}
