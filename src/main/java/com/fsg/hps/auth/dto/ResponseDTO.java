package com.fsg.hps.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "结果类")
public class ResponseDTO<T> {

    @Schema(description = "编码")
    private String code;

    @Schema(description = "描述")
    private String msg;

    @Schema(description = "对象")
    private T data;

    public ResponseDTO() {
    }

    public ResponseDTO(String code) {
        this.setCode(code);
    }

    public ResponseDTO(String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }

    public ResponseDTO(String code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    public ResponseDTO(String code, T data) {
        this.setCode(code);
        this.setData(data);
    }

    public static <T> ResponseDTO<T> newInstance(String code, String msg, T data) {
        return new ResponseDTO<>(code,msg,data);
    }

    public static <T> ResponseDTO<T> newInstance(String code, T data) {
        return new ResponseDTO<>(code,data);
    }

    public static <T> ResponseDTO<T> newInstance(String code) {
        return new ResponseDTO<>(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
