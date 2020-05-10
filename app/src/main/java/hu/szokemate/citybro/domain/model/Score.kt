package hu.szokemate.citybro.domain.model

data class ScoreData(
    val id: Long? = null,
    val categories: List<Score>,
    val summary: String
)

data class Score(
    val id: Long? = null,
    val color: String,
    val name: String,
    val value: Double
)