package memorygame

class Board( ) {
    //Constructor to create board of different sizes.
    // Assign
    private val cards: Array<Card> = Array<Card>(6) {_ -> Card(' ', "")}
    private val suits: Array<Char> = arrayOf('c', 'd', 'h', 's')
    private val vals: Array<String> = arrayOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "'j", "q", "k", "a")

    init {
        val numCards = 6
        for(index in 0 until numCards / 2) {
            var randIndex1 = (0 until numCards).random()

            val currCardSuit = suits.random()
            val currCardVal = vals.random()

            while (cards[randIndex1] != Card(' ', "")) {
                randIndex1 = (0 until numCards).random()
            }

            cards[randIndex1] = Card(currCardSuit, currCardVal)

            // Find second empty spot
            var randIndex2 = (0 until numCards).random()
            while (cards[randIndex2] != Card(' ', "")) {
                randIndex2 = (0 until numCards).random()
            }
            cards[randIndex2] = Card(currCardSuit, currCardVal)
        }
    }

    fun getValueAt(index:Int): Card {
        return cards[index]
    }

    data class Card(val suit: Char, val rank: String) {

    }
}