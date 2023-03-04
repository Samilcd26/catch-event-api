package com.main.GuideAPI.business.services.impl

import com.main.GuideAPI.business.services.PublisherServices
import com.main.GuideAPI.data.models.PublisherModel
import com.main.GuideAPI.data.repository.PublisherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Objects


@Service
class PublisherServicesImpl(
    @Autowired
    var publisherRepository: PublisherRepository
) :PublisherServices {




    override fun getAllPublisherByCity(city: String): List<PublisherModel>? {
        try {
            val responseData = ArrayList<PublisherModel>()
            var data=publisherRepository.getAllDataByCity()

            data.map { pub-> if (pub.address?.filter { adr->adr.city==city }!!.isNotEmpty())responseData.add( pub.copy(address = pub.address?.filter { adr->adr.city==city })) }


            return responseData
        }catch(e:Exception){
            println(e)
            return null
        }
    }


    override fun createNewPublisher(publisher:PublisherModel): PublisherModel? {
        try {
            publisherRepository.save(publisher)
            return publisher
        }catch(e:Exception){
            println(e)
            return null
        }
    }

    override fun updatePublisherById(id: Int, publisher: PublisherModel) {
        try {
//            var findPublisher = publisherRepository.findById(id.toLong());
//
//
//            findPublisher.get().address=publisher.address
//            findPublisher.get().brand=publisher.brand
//            findPublisher.get().category=publisher.category
//            findPublisher.get().description=publisher.description
//            findPublisher.get().email=publisher.email
//            findPublisher.get().image=publisher.image
//            findPublisher.get().openingHours=publisher.openingHours
//            findPublisher.get().coordinate=publisher.coordinate
//
//            publisherRepository.save(findPublisher.get())
        }catch(e:Exception){
            println(e)
        }
    }

    override fun deletePublisherById(id: Int) {
        try {
//            var findItem=publisherRepository.findById(id.toLong())
//            publisherRepository.delete(findItem.get())
        }catch(e:Exception){
            println(e)
        }
    }


}