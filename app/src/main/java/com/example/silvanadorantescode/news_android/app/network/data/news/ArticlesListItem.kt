package com.example.silvanadorantescode.news_android.app.network.data.news

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

data class ArticlesListItem(var source: Source?, var author: String?, var title: String?, var description: String?, var url: String?, var urlToImage: String?, var publishedAt: String?, var content: String?) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Source::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(source, flags)
        parcel.writeString(author)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(url)
        parcel.writeString(urlToImage)
        parcel.writeString(publishedAt)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticlesListItem> {
        override fun createFromParcel(parcel: Parcel): ArticlesListItem {
            return ArticlesListItem(parcel)
        }

        override fun newArray(size: Int): Array<ArticlesListItem?> {
            return arrayOfNulls(size)
        }
    }
}