data class RepositoryItem(
    val name: String,
    val owner: String,
    var default_branch: String,
    var topics: List<String>
)