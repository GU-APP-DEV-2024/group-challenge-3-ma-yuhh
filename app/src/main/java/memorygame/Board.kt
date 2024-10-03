package memorygame

class Board( ) {
    //Constructor to create board of different sizes.
    // Assign
    private val cards: Array<Card> = Array<Card>(6) {_ -> Card(' ', "")}
    init {
        val numCards = 6
        for(index in 0 until numCards / 2) {
            val randSuit = (0 .. 3).random()
            val randNum = (2..14).random()
            var suit = 'x'
            when (randSuit) {
                0 -> {
                    suit = 'c'
                }
                1 -> {
                    suit = 'd'
                }
                2 -> {
                    suit = 'h'
                }
                3 -> {
                    suit = 's'
                }
            }
            val num: String = when (randNum) {
                11 -> {
                    "j"
                }

                12 -> {
                    "q"
                }

                13 -> {
                    "k"
                }

                14 -> {
                    "a"
                }

                else -> randNum.toString()
            }
            var randIndex1 = (0 until numCards).random()
            while (cards[randIndex1] != Card(' ', "")) {
                randIndex1 = (0 until numCards).random()
            }
            cards[randIndex1] = Card(suit, num)

            // Find second empty spot
            var randIndex2 = (0 until numCards).random()
            while (cards[randIndex2] != Card(' ', "")) {
                randIndex2 = (0 until numCards).random()
            }
            cards[randIndex2] = Card(suit, num)
        }
    }

    fun getValueAt(index:Int): Card {
        return cards[index]
    }

    data class Card(val suit: Char, val rank: String) {

    }
}