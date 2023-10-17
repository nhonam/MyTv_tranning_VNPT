package com.example.android.marsphotos.data.model.Home

data class Row1(
    val CATE_ID: Int,
    val CATE_NAME: String,
    val CATE_NODE_TYPE: Int,
    val DATA: List<DATAX>,
    val DATA_LINK: Any?=null,
    val KEYWORD: String,
    val POSTER_LAYOUT: Int,
    val PREVIEW_STATUS: Int,
    val SHOW_TITLE: String,
    val TOPTEN_STATUS: Int,
    val TYPE_ID: Int,
    val VIEW_MORE: Int
)