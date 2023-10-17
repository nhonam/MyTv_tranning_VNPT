package com.example.android.marsphotos.data.model.film

data class Data(
    val API_CATE_URL: String,
    val API_LIST_URL: String,
    val CATE_ID: String,
    val CATE_NAME: String,
    val CATE_NODE_TYPE: String,
    val CATE_TYPE_LINK: String,
    val DATA: List<Film>,
    val DATA_LINK: Any,
    val IS_VIEW_MORE: String,
    val PARAMS_CATE: String,
    val PARAMS_LIST: String,
    val POSTER_LAYOUT: String
)