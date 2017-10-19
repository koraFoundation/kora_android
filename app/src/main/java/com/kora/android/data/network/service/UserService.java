package com.kora.android.data.network.service;

import com.kora.android.data.network.model.response.UserListResponse;
import com.kora.android.data.network.model.response.UserResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface UserService {

    @POST("profile")
    Observable<UserResponse> getUserData();

    @Multipart
    @PUT("profile")
    Observable<UserResponse> updateUser(@PartMap final Map<String, RequestBody> userMap);

    @Multipart
    @PUT("profile/avatar")
    ObservableSource<Object> updateAvatar(@Part final MultipartBody.Part imageFile);

    @GET("recents")
    Observable<List<UserResponse>> getRecentUsers();

    @GET("contacts")
    Observable<UserListResponse> getUsers(@Query("search") String search,
                                          @Query("limit") int limit,
                                          @Query("skip") int skip,
                                          @Query("sort") String sort);
}
