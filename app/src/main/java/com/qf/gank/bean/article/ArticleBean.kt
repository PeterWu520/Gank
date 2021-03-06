package com.qf.gank.bean.article

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.qf.gank.ui.home.HomePageListAdapter
import java.io.Serializable

data class ArticleBean(
    val _id: String? = null,
    val author: String? = null,
    val category: String? = null,
    val createdAt: String? = null,
    val desc: String? = null,
    val images: List<String>? = null,
    val likeCounts: Int = 0,
    val publishedAt: String? = null,
    val stars: Int = 0,
    val title: String? = null,
    val type: String? = null,
    val url: String? = null,
    val views: Int = 0,
    override var itemType: Int = HomePageListAdapter.TYPE_ARTICLE
): MultiItemEntity, Serializable