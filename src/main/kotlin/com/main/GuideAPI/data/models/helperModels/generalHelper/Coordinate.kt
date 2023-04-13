package com.main.GuideAPI.data.models.helperModels.generalHelper

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
data class Coordinate(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long?=null,
    val latitude:Double? = null,
    val longitude:Double? = null
)
