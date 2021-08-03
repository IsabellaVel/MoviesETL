package com.isabellavel.edenmovies.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import java.util.ArrayList

@Parcelize
data class Movie(
    val tit: String?, val pos: String?, val story: String?,
    val act: ArrayList<String>?, val url: String?, val yr: String?, val i_d: String?, val genr: ArrayList<String>?,
    val ratg: IntArray?, val contR: String?, val dur: String?, val relD: String?,
    val avr: Int?,
    val origt: String?, val imdb: String?) : Parcelable {

    @SerializedName("title")
    val title: String = "No movie here"
    @SerializedName("poster")
    val poster: String = ""
    @SerializedName("storyline")
    val storyline: String = ""
    @SerializedName("actors")
    val actors: List<String> = arrayListOf()
    @SerializedName("posterurl")
    val posterurl: String = ""
    @SerializedName("year")
    val year: String = ""
    @SerializedName("id")
    val id: String = ""
    @SerializedName("genres")
    val genres: List<String> = arrayListOf()
    @SerializedName("ratings")
    val ratings: List<Int> = arrayListOf()
    @SerializedName("contentRating")
    val contentR: String = ""
    @SerializedName("duration")
    val duration: String = ""
    @SerializedName("releaseDate")
    val relDate: String = ""
    @SerializedName("averageRating")
    val avRating: Int = 0
    @SerializedName("originalTitle")
    val originalTitle: String = ""
    @SerializedName("imdbRating")
    val imdbRating: String = ""

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.createIntArray(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    companion object : Parceler<Movie> {

        override fun Movie.write(parcel: Parcel, flags: Int) {
            parcel.writeString(tit)
            parcel.writeString(pos)
            parcel.writeString(story)
            parcel.writeStringList(act)
            parcel.writeString(url)
            parcel.writeString(yr)
            parcel.writeString(i_d)
            parcel.writeStringList(genr)
            parcel.writeIntArray(ratg)
            parcel.writeString(contR)
            parcel.writeString(dur)
            parcel.writeString(relD)
            parcel.writeValue(avr)
            parcel.writeString(origt)
            parcel.writeString(imdb)
        }

        override fun create(parcel: Parcel): Movie {
            return Movie(parcel)
        }
    }


}




