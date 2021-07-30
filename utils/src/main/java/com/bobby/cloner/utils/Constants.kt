package com.bobby.cloner.utils

object Constants {
    const val HEADER_AUTHORIZATION = "Authorization"
    const val YELP_CLIENT = "YELP_CLIENT"
    const val YELP_RETROFIT = "YELP_RETROFIT"

    //Room
    const val CATEGORY_TABLE_NAME = "category"
    const val CATEGORY_COLUMN_ID = "id"
    const val CATEGORY_COLUMN_ALIAS = "alias"
    const val CATEGORY_COLUMN_TITLE = "title"
    const val CATEGORY_COLUMN_PARENT_ALIAS = "parent_alias"
    const val CATEGORY_DB_NAME = "Category.db"

    const val BUSINESS_RESULT_STARTING_PAGE_INDEX = 0
    const val NETWORK_PAGE_SIZE = 20

    const val LAST_QUERY_SCROLLED: String = "last_query_scrolled"
    const val LAST_SEARCH_QUERY: String = "last_search_query"
}
