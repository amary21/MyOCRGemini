package com.amary.my.ocr.gemini.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OCRExtractorModel(
    @SerialName("provinsi") val province: String?? = null,
    @SerialName("kabupaten") val regency: String? = null,
    @SerialName("nik") val nationalIdentityNumber: String? = null,
    @SerialName("nama") val name: String? = null,
    @SerialName("tempat_tanggal_lahir") val placeAndDateOfBirth: String? = null,
    @SerialName("jenis_kelamin") val gender: String? = null,
    @SerialName("alamat") val address: String? = null,
    @SerialName("rt_rw") val rtRw: String? = null,
    @SerialName("kelurahan_desa") val villageSuburb: String? = null,
    @SerialName("kecamatan") val district: String? = null,
    @SerialName("agama") val religion: String? = null,
    @SerialName("status_perkawinan") val maritalStatus: String? = null,
    @SerialName("pekerjaan") val occupation: String? = null,
    @SerialName("kewarganegaraan") val citizenship: String? = null,
)
