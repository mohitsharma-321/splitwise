package com.company.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDTO<DTO_TYPE> {
    private HttpStatus status;
    private DTO_TYPE data;

    public static <DTO_TYPE> ResponseDTO<DTO_TYPE> notFound() {
        ResponseDTO<DTO_TYPE> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(HttpStatus.NOT_FOUND);
        return responseDTO;
    }

    public static <DTO_TYPE> ResponseDTO<DTO_TYPE> success(DTO_TYPE data) {
        ResponseDTO<DTO_TYPE> responseDTO = new ResponseDTO<>();
        responseDTO.setStatus(HttpStatus.OK);
        responseDTO.setData(data);
        return responseDTO;
    }
}
