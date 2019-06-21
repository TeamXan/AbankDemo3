package com.xan.abankdemo3.Module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xan.abankdemo3.model.ApiCallInterface;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Singleton
@Module(includes = ViewModelModule.class)
public class ApplicationModule {

  /*  @Provides
    @Singleton
    String provideStringOne() {
        return "hello";
    }

    @Provides
    @StringTwo
    String provideStringTwo() {
        return "Welcome";
    }

    @Provides
    @Singleton
    T2 provideTestTwo(TestTwo testTwo) {
        return testTwo;
    }


    @Provides
    @Singleton
    T3 provideTestThree(TestThree test3) {
        return test3;
    }*/

  private static final String BASE_URL = "https://simplifiedcoding.net/demos/";
  @Provides
  @Singleton
  Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {

      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .client(okHttpClient)
              .addConverterFactory(GsonConverterFactory.create(gson))
              .build();

      return retrofit;


  }
    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder builder =
                new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.setLenient().create();
    }


    @Provides
    @Singleton
    OkHttpClient getRequestHeader() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .build();
            return chain.proceed(request);
        })
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS);

        return httpClient.build();
    }
  /*@Singleton
  @Provides
  static Retrofit provideRetrofit() {
      return new Retrofit.Builder().baseUrl(BASE_URL)
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .addConverterFactory(GsonConverterFactory.create())
              .build();
  }*/

    @Singleton
    @Provides
    static ApiCallInterface provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ApiCallInterface.class);
    }

}
