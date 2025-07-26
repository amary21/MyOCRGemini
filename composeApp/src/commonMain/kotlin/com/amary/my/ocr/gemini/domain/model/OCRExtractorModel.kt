package com.amary.my.ocr.gemini.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OCRExtractorModel(
    @SerialName("provinsi") val province: String,
    @SerialName("kabupaten") val regency: String,
    @SerialName("nik") val nationalIdentityNumber: String,
    @SerialName("tempat_tanggal_lahir") val placeAndDateOfBirth: String,
    @SerialName("jenis_kelamin") val gender: String,
    @SerialName("alamat") val address: String,
    @SerialName("rt_rw") val rtRw: String,
    @SerialName("kelurahan_desa") val villageSuburb: String,
    @SerialName("kecamatan") val district: String,
    @SerialName("agama") val religion: String,
    @SerialName("status_perkawinan") val maritalStatus: String,
    @SerialName("pekerjaan") val occupation: String,
    @SerialName("kewarganegaraan") val citizenship: String,
)
