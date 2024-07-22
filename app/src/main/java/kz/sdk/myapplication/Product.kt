package kz.sdk.myapplication

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(
    val id:Int,
    val name:String,
    @DrawableRes
    val img:Int,
    val price:Int,
    val description: String,
):Parcelable
