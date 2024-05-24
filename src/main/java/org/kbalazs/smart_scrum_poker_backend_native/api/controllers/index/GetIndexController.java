package org.kbalazs.smart_scrum_poker_backend_native.api.controllers.index;

import org.kbalazs.smart_scrum_poker_backend_native.api.builders.ResponseEntityBuilder;
import org.kbalazs.smart_scrum_poker_backend_native.api.exceptions.ApiException;
import org.kbalazs.smart_scrum_poker_backend_native.api.value_objects.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("AccountGetByReviewIdAction")
@RequestMapping("/")
public class GetIndexController
{
    @GetMapping("/")
    public ResponseEntity<ResponseData<String>> action() throws ApiException
    {
        return new ResponseEntityBuilder<String>().data("hello").build();
    }
}
