package com.deeosoft.headlinewithrxjavaanddagger2.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Resource<T> {

    @NonNull
    public NetworkState networkState;

    @Nullable
    public T data;

    @Nullable
    public String message;

    private Resource(@NonNull NetworkState networkState, @Nullable T data, @Nullable String message){
        this.networkState = networkState;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> loading(NetworkState networkState, T data){
        return new Resource<>(NetworkState.LOADING, data, null);
    }

    public static <T> Resource<T> success(NetworkState networkState, T data, String message){
        return new Resource<>(NetworkState.SUCCESS, data, message);
    }

    public static <T> Resource<T> error(NetworkState networkState, T data, String message){
        return new Resource<>(NetworkState.ERROR, data, message);
    }

}
