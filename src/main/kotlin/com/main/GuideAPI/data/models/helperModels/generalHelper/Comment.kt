package com.main.GuideAPI.data.models.helperModels.generalHelper

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.time.LocalDateTime
import javax.persistence.*

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
data class Comment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    var id:Long?=null,
    @Column(nullable=false)
    var byAddId:Long?=null,
    var contents:String?=null,
    @ElementCollection
    var likeed:MutableList<Long>?= arrayListOf(),

    @ElementCollection
    var subComment:MutableList<Long>?=arrayListOf(),
    var createdDate:LocalDateTime?=LocalDateTime.now(),
    var changedDate:LocalDateTime?=LocalDateTime.now(),
)
