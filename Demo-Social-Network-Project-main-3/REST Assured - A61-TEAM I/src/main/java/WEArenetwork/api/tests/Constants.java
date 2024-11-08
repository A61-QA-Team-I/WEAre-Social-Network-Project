package WEArenetwork.api.tests;

public class Constants {


    public static final String BASE_WEAre_URL = "http://localhost:8081";


    public static final String CREATE_USER_1_ENDPOINT = BASE_WEAre_URL + "/api/users/";

    public static final String CREATE_USER_2_ENDPOINT = BASE_WEAre_URL + "/api/users/";

    public static final String GET_ALL_USERS_ENDPOINT = BASE_WEAre_URL + "/api/users";

    public static final String EDIT_USER_ENDPOINT = BASE_WEAre_URL + "/api/users/auth";



    public static final String LOGIN_USER_1_ENDPOINT = BASE_WEAre_URL + "/authenticate";

    public static final String LOGIN_USER_2_ENDPOINT = BASE_WEAre_URL + "/authenticate";



    public static final String CREATE_PUBLIC_POST_USER_1_ENDPOINT = BASE_WEAre_URL + "/posts/auth/newPost?content=";

    public static final String CREATE_PRIVET_POST_USER_1_ENDPOINT = BASE_WEAre_URL + "/posts/auth/newPost?content={{postTitle2}}&name={{randomName}}&public=false";

    public static final String GET_ALL_POST_ENDPOINT = BASE_WEAre_URL + "/api/post/";

    public static final String LIKE_POST_ENDPOINT = BASE_WEAre_URL + "/api/post/auth/likesUp";

    public static final String DELETE_POST_ENDPOINT = BASE_WEAre_URL + "/api/post/auth/manager?postId={{postId}}";



    public static final String SEND_REQUEST_ENDPOINT = BASE_WEAre_URL + "/api/auth/request?name=";

    public static final String GET_REQUEST_ENDPOINT = BASE_WEAre_URL + "/api/auth/users/";

    public static final String APPROVE_REQUEST_ENDPOINT = BASE_WEAre_URL + "/api/auth/users/";



    public static final String COMMENT_POST_ENDPOINT = BASE_WEAre_URL + "/api/comment/auth/creator";

    public static final String LIKE_COMMENT_ENDPOINT = BASE_WEAre_URL + "/api/comment/auth/likesUp?commentId={{commentId}}";


}
