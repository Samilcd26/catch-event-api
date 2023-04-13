package com.main.GuideAPI.data.models.helperModels.generalHelper

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
data class Address(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null,
    var eventID:Long?=null,
    var postalCode:String? = null,
    var country:String? = null,
    var state:String? = null,
    var city:String? = null,
    var district:String? = null,
    var address1:String?=null,
    var address2:String?=null,
    @ManyToOne(cascade = [(CascadeType.ALL)],fetch = FetchType.LAZY)
    var coordinate: Coordinate? = null,
)
