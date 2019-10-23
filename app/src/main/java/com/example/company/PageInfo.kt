package com.example.company

data class PageInfo(
            // pages info
        val FIRST_PAGE  :Int = 0,
        var currentPage :Int,
        var totalPage   :Int,
            // loading
        var isLoading   :Boolean,
        var isLastPage  :Boolean
            ){

    constructor() : this(FIRST_PAGE =0 ,totalPage =0 , currentPage =0 ,isLoading = false , isLastPage = false)
    companion object{
      val PAGE_NUMBER : String = "PAGE_NUMBER"

        // base on object can complete this part
        val item :String = "ITEM_PAGE"
        /*
            for ex in adapter if we have data class we put this here for sending data between activities
         */
    }
}