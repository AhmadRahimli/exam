package com.rahimliahmad.exam_23_05.model



data class PopluarMovies(
    var page:Int,
    var  adult:Boolean?=null,
     var backdrop_path:String,
     var genreIds:List<Int>,
    var id:Int,
    var language:String,
    var orginal_tittle:String,
    var overview:String,
    var populuarity:Int,
    var poster:String

    )
