/*The Philosopher's Stone (1997)
The Chamber of Secrets (1998)
The Prisoner of Azkaban (1999)
The Goblet of Fire (2000)
The Order of the Phoenix (2003)
The Half-Blood Prince (2005)
The Deathly Hallows (2007)
*/
const val MAXIMUM_NUMBER_OF_BORROWED_BOOKS = 20

fun main() {

    println(createLibrary(createBook()))
}

object Constants {
    const val BASE_URL = "library.com"
}

//inheritance
open class Book(val title: String, val author: String) {
    private var currentPage = 1

    companion object {
        const val BASE_URL = "library.com"
    }

    open fun readPage() {
        currentPage++
    }

    fun printUrl() = println("$BASE_URL$title.html")
    fun canBorrow(currentBorrowed: Int) = currentBorrowed < MAXIMUM_NUMBER_OF_BORROWED_BOOKS


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

fun createLibrary(books: List<BasicBooK>): Map<String, List<BasicBooK>> {
    val allBooks: Map<String, List<BasicBooK>> = mapOf(books[0].author to books)
    println(allBooks.any { it.value.any { it.title == "The Goblet of Fire" } })
    val moreBooks = mutableMapOf(books[0].title to books[0].author)
    println(moreBooks.getOrPut(books[0].title) { books[0].author })
    return allBooks
}


fun createBook(): List<BasicBooK> {
    val harryPotterBooks = listOf<BasicBooK>(
        BasicBooK(
            title = "the Philosopher's Stone",
            author = "J. K. Rowling",
            year = "1997"
        ),
        BasicBooK(
            title = "The Chamber of Secrets",
            author = "J. K. Rowling",
            year = "1998"
        ),
        BasicBooK(
            title = "The Prisoner of Azkaban ",
            author = "J. K. Rowling",
            year = "1999"
        ),
        BasicBooK(
            title = "The Goblet of Fire",
            author = "J. K. Rowling",
            year = "2000"
        ), BasicBooK(
            title = "The Order of the Phoenix",
            author = "J. K. Rowling",
            year = "2003"
        ), BasicBooK(
            title = "The Half-Blood Prince",
            author = "J. K. Rowling",
            year = "2005"
        ), BasicBooK(
            title = "The Deathly Hallows",
            author = "J. K. Rowling",
            year = "2007"
        )
    )
    harryPotterBooks.forEach {
        val (title, author, year) = it.getInfoWithYear()
        println("Here is your book \'$title\' written by \'$author\' in $year")
    }
    return harryPotterBooks
}