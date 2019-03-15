open class Book(var title: String, var author: String) {
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


