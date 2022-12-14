package com.noweshed.noweshedmisltest.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by noweshedakram on 3/12/22.
 */
data class ProductResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("specification")
    val specification: Specification,
) : Serializable

data class Specification(
    @SerializedName("Display")
    val display: Display,
    @SerializedName("Memory")
    val memory: Memory,
    @SerializedName("OS")
    val os: Os,
    @SerializedName("Product Type")
    val productType: ProductType,
    @SerializedName("Dimensions (mm)")
    val dimensionsMm: DimensionsMm,
    @SerializedName("Video")
    val video: Video,
    @SerializedName("Audio")
    val audio: Audio,
    @SerializedName("Connectivity")
    val connectivity: Connectivity,
    @SerializedName("Power")
    val power: Power,
    @SerializedName("Processor")
    val processor: Processor,
    @SerializedName("Smart Feature")
    val smartFeature: SmartFeature,
    @SerializedName("Others")
    val others: Others,
)

data class Display(
    @SerializedName("Resolution")
    val resolution: String,
    @SerializedName("Screen Size")
    val screenSize: String,
    @SerializedName("Aspect Ratio")
    val aspectRatio: String,
    @SerializedName("Display Type")
    val displayType: String,
)

data class Memory(
    @SerializedName("RAM Size (GB)")
    val ramSizeGB: String,
    @SerializedName("ROM Size (GB)")
    val romSizeGB: String,
)

data class Os(
    @SerializedName("Operating System")
    val operatingSystem: String,
)

data class ProductType(
    @SerializedName("Product Type")
    val productType: String,
)

data class DimensionsMm(
    @SerializedName("Set Size with Stand (WxHxD)")
    val setSizeWithStandWxHxD: String,
    @SerializedName("Set Size without Stand (WxHxD)")
    val setSizeWithoutStandWxHxD: String,
)

data class Video(
    @SerializedName("PQI (Picture Quality Index)")
    val pQIPictureQualityIndex: String,
    @SerializedName("One Billion Color")
    val oneBillionColor: String,
    @SerializedName("HDR (High Dynamic Range)")
    val hDRHighDynamicRange: String,
    @SerializedName("HDR 10+")
    val hdr10: String,
    @SerializedName("Contrast")
    val contrast: String,
    @SerializedName("Contrast Enhancer")
    val contrastEnhancer: String,
    @SerializedName("Auto Motion Plus")
    val autoMotionPlus: String,
    @SerializedName("Picture Engine")
    val pictureEngine: String,
    @SerializedName("Refresh Rate")
    val refreshRate: String,
    @SerializedName("Color")
    val color: String,
)

data class Audio(
    @SerializedName("Speaker Type")
    val speakerType: String,
    @SerializedName("Sound Output (RMS)")
    val soundOutputRMS: String,
    @SerializedName("Dolby Digital Plus")
    val dolbyDigitalPlus: String,
)

data class Connectivity(
    @SerializedName("HDMI")
    val hdmi: String,
    @SerializedName("USB")
    val usb: String,
    @SerializedName("WiFi Direct")
    val wiFiDirect: String,
    @SerializedName("Wi-Fi")
    val wiFi: String
)

data class Power(
    @SerializedName("Power Consumption (Max)")
    val powerConsumptionMax: String,
    @SerializedName("Power Supply")
    val powerSupply: String,
)

data class Processor(
    @SerializedName("Processor")
    val processor: String,
)

data class SmartFeature(
    @SerializedName("Mobile to TV - Mirroring, DLNA")
    val mobileToTVMirroringDLNA: String,
    @SerializedName("TV Sound to Mobile")
    val tvSoundToMobile: String,
    @SerializedName("Sound Mirroring")
    val soundMirroring: String,
)

data class Others(
    @SerializedName("Series")
    val series: String,
    @SerializedName("Picture Engine")
    val pictureEngine: String,
    @SerializedName("Micro Dimming")
    val microDimming: String,
    @SerializedName("Q-Symphony")
    val qSymphony: String,
    @SerializedName("Web Browser")
    val webBrowser: String,
    @SerializedName("TV to Mobile - Mirroring")
    val tvToMobileMirror: String,
    @SerializedName("Design")
    val design: String,
    @SerializedName("Bezel Type")
    val bezelType: String,
    @SerializedName("Power Supply")
    val powerSupply: String,
)
