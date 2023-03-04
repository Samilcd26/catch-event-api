package com.main.GuideAPI.data.models

import com.main.GuideAPI.data.models.helperModels.Address
import com.main.GuideAPI.data.models.helperModels.Coordinate
import com.main.GuideAPI.data.models.helperModels.PublisherCategory
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
data class PublisherModel(

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    var id:Long?=null,
    var brand:String? = null,
    var image:String? = null,
    var description: String? = null,
    var openingHours:String? = null,
    @OneToMany(cascade = [(CascadeType.ALL)] ,fetch = FetchType.LAZY)
    var address:List<Address>? = null,


    var category: PublisherCategory? = null,
    var email:String? = null,
)
