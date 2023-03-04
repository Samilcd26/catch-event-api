package com.main.GuideAPI.data.repository

import com.main.GuideAPI.data.models.PublisherModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

import org.springframework.stereotype.Repository
import java.util.Objects


@EnableJpaRepositories
@Repository
interface PublisherRepository :JpaRepository<PublisherModel,String>{

    @Query("select pub from PublisherModel pub")
    fun getAllDataByCity():List<PublisherModel>;
}