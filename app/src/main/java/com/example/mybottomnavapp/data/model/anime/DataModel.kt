package com.example.mybottomnavapp.data.model.anime


import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("aired")
    val aired: AiredModel? = AiredModel(),
    @SerializedName("airing")
    val airing: Boolean? = false,
    @SerializedName("approved")
    val approved: Boolean? = false,
    @SerializedName("background")
    val background: String? = "",
    @SerializedName("broadcast")
    val broadcast: BroadcastModel? = BroadcastModel(),
    @SerializedName("demographics")
    val demographics: List<DemographicModel?>? = listOf(),
    @SerializedName("duration")
    val duration: String? = "",
    @SerializedName("episodes")
    val episodes: Int? = 0,
    @SerializedName("explicit_genres")
    val explicitGenres: List<ExplicitGenreModel?>? = listOf(),
    @SerializedName("favorites")
    val favorites: Int? = 0,
    @SerializedName("genres")
    val genres: List<GenreModel?>? = listOf(),
    @SerializedName("images")
    val images: ImagesModel? = ImagesModel(),
    @SerializedName("licensors")
    val licensors: List<LicensorModel?>? = listOf(),
    @SerializedName("mal_id")
    val malId: String? = "",
    @SerializedName("members")
    val members: Int? = 0,
    @SerializedName("popularity")
    val popularity: Double? = 0.0,
    @SerializedName("producers")
    val producers: List<ProducerModel?>? = listOf(),
    @SerializedName("rank")
    val rank: Int? = 0,
    @SerializedName("rating")
    val rating: String? = "",
    @SerializedName("score")
    val score: Double? = 0.0,
    @SerializedName("scored_by")
    val scoredBy: Double? = 0.0,
    @SerializedName("season")
    val season: String? = "",
    @SerializedName("source")
    val source: String? = "",
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("studios")
    val studios: List<StudioModel?>? = listOf(),
    @SerializedName("synopsis")
    val synopsis: String? = "",
    @SerializedName("themes")
    val themes: List<ThemeModel?>? = listOf(),
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("title_english")
    val titleEnglish: String? = "",
    @SerializedName("title_japanese")
    val titleJapanese: String? = "",
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String?>? = listOf(),
    @SerializedName("titles")
    val titles: List<TitleModel?>? = listOf(),
    @SerializedName("trailer")
    val trailer: TrailerModel? = TrailerModel(),
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("year")
    val year: Int? = 0
)