package com.main.GuideAPI.data.models
import com.fasterxml.jackson.annotation.JsonProperty

data class GoogleLocationModel(
    @JsonProperty("plus_code")
    val plusCode: PlusCode,
    val results: List<Result>,
    val status: String,
)

data class PlusCode(
    @JsonProperty("compound_code")
    val compoundCode: String,
    @JsonProperty("global_code")
    val globalCode: String,
)

data class Result(
    @JsonProperty("address_components")
    val addressComponents: List<AddressComponent>,
    @JsonProperty("formatted_address")
    val formattedAddress: String,
    val geometry: Geometry,
    @JsonProperty("place_id")
    val placeId: String,
    @JsonProperty("plus_code")
    val plusCode: PlusCode2?,
    val types: List<String>,
)

data class AddressComponent(
    @JsonProperty("long_name")
    val longName: String,
    @JsonProperty("short_name")
    val shortName: String,
    val types: List<String>,
)

data class Geometry(
    val location: Location,
    @JsonProperty("location_type")
    val locationType: String,
    val viewport: Viewport,
    val bounds: Bounds?,
)

data class Location(
    val lat: Double,
    val lng: Double,
)

data class Viewport(
    val northeast: Northeast,
    val southwest: Southwest,
)

data class Northeast(
    val lat: Double,
    val lng: Double,
)

data class Southwest(
    val lat: Double,
    val lng: Double,
)

data class Bounds(
    val northeast: Northeast2,
    val southwest: Southwest2,
)

data class Northeast2(
    val lat: Double,
    val lng: Double,
)

data class Southwest2(
    val lat: Double,
    val lng: Double,
)

data class PlusCode2(
    @JsonProperty("compound_code")
    val compoundCode: String,
    @JsonProperty("global_code")
    val globalCode: String,
)
