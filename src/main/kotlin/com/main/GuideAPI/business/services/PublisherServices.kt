package com.main.GuideAPI.business.services

import com.main.GuideAPI.data.models.PublisherModel
import com.main.GuideAPI.data.models.helperModels.Coordinate

interface PublisherServices {
    fun getAllPublisherByCity(city:String):List<PublisherModel>?
    fun createNewPublisher(publisher:PublisherModel):PublisherModel?
    fun updatePublisherById(id:Int,publisher: PublisherModel)
    fun deletePublisherById(id: Int)
}