package io.bratexsoft.specialtycofeecode.repository.model

import com.google.gson.annotations.SerializedName

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */

fun Regular.processSpecialization(map: HashMap<String, String>): String {
    var specialization = ""
    if (aeropress) {
        specialization += (map[Constant.TYPE_AEROPRESS]) + ","
    }
    if (chemex) {
        specialization += " " + (map[Constant.TYPE_CHEMEX]) + ","
    }
    if (coldbrew) {
        specialization += " " + (map[Constant.TYPE_COLD_BREW]) + ","
    }
    if (drip) {
        specialization += " " + (map[Constant.TYPE_DRIP]) + ","
    }
    if (syphon) {
        specialization += " " + (map[Constant.TYPE_SYPHON]) + ","
    }
    specialization = specialization.removeSuffix(",")
    return specialization
}

object Constant {
    const val TYPE_AEROPRESS = "AEROPRESS"
    const val TYPE_ESPRESSO = "ESPRESSO"
    const val TYPE_CHEMEX = "CHEMEX"
    const val TYPE_COLD_BREW = "COLD_BREW"
    const val TYPE_DRIP = "DRIP"
    const val TYPE_SYPHON = "SYPHON"
}

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
