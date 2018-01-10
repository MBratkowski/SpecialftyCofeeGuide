package io.bratexsoft.specialtycofeecode.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */

data class Regular(
        @SerializedName("fbid")
        val fbid: String,
        @SerializedName("espresso")
        val espresso: Boolean,
        @SerializedName("aeropress")
        val aeropress: Boolean,
        @SerializedName("chemex")
        val chemex: Boolean,
        @SerializedName("drip")
        val drip: Boolean,
        @SerializedName("coldbrew")
        val coldbrew: Boolean,
        @SerializedName("syphon")
        val syphon: Boolean,
        @SerializedName("name")
        val name: String,
        @SerializedName("about")
        val about: Any,
        @SerializedName("street")
        val street: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("thumbnailURL")
        val thumbnailURL: String,
        @SerializedName("coverURL")
        val coverURL: String,
        @SerializedName("facebook")
        val facebook: String,
        @SerializedName("featured")
        val featured: Featured,
        @SerializedName("website")
        val website: String,
        @SerializedName("latitude")
        val latitude: Double,
        @SerializedName("longitude")
        val longitude: Double

)
