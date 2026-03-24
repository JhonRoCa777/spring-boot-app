package com.example.spring_boot_server.domain.externals;

import com.example.spring_boot_server.domain.errors.BaseError;
import lombok.Getter;

@Getter
public class Result<T> {

    private final boolean isSuccess;
    private final T data;
    private final BaseError error;

    private Result(boolean isSuccess, T data, BaseError error) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.error = error;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, data, null);
    }

    public static <T> Result<T> failure(BaseError error) {
        return new Result<>(false, null, error);
    }
}