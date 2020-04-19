package hu.szokemate.citybro.domain.model

data class ScoreData(
    val categories: List<Score>,
    val summary: String
)

data class Score(
    val color: String,
    val name: String,
    val value: Double
)