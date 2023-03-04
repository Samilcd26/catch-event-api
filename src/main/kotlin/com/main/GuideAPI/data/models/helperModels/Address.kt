package com.main.GuideAPI.data.models.helperModels

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
data class Address(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int?=null,
    val postCode:Int? = null,
    val country :String? = null,
    val state:String? = null,
    val city:String? = null,
    val streetName:String? = null,
    val district:String? = null,
    val neighbourhood:String? = null,
    val apartmentName:String? = null,
    val doorNumber:Int? = null,
    @OneToOne(cascade = [(CascadeType.ALL)],fetch = FetchType.LAZY)
    var coordinate: Coordinate? = null,
)
