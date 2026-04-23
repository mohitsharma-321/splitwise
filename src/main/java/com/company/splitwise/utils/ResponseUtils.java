package com.company.splitwise.utils;

import com.company.splitwise.dtos.ResponseDTO;

import java.util.Optional;

public class ResponseUtils {

    public static <DOC_TYPE> ResponseDTO<DOC_TYPE>toResponse(Optional<DOC_TYPE> data) {
        return data.map(ResponseDTO::success).orElse(ResponseDTO.notFound());
    }
}
