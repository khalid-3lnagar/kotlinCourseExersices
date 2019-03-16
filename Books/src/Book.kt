//inheritance
open class Book(val title: String, val author: String) {
    private var currentPage = 1
    open fun readPage() {
        currentPage++
    }

    class eBook(var format: String = "text", title: String, author: String) : Book(title, author) {
        private var numberOfWords = 0
        override fun readPage() {
            numberOfWords += 250
        }
    }
}

//generics
class BasicBooK(title: String, author: String, val year: String) : Book(title, author) {
    fun getInfo(): Pair<String, String> {
        return title to author
    }

    fun getInfoWithYear(): Triple<String, String, String> {
        return Triple(title, author, year)
    }
}

fun main() {
    createBook()
}

fun createBook() {
    val harryPotter =
        BasicBooK(title = "Harry Potter and the Philosopher's Stone", author = "J. K. Rowling", year = "2010")
    println(harryPotter.getInfo())
    println(harryPotter.getInfoWithYear())
    val (title, author) = harryPotter.getInfo()
    println("title: $title\nauthor: $author\n")
    val year = harryPotter.getInfoWithYear().third
    println("Here is your book \'$title\' written by \'$author\' in $year")
}