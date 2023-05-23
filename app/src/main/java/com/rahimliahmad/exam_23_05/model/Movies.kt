package com.rahimliahmad.exam_23_05.model

data class Movies(
    var page:Int,
    var results:List<String>,
     var total_pages:Int,
    var total_result:Int
)
