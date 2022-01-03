package com.example.data

import java.util.*

class SampleDataClass {

    companion object{
        private val sampleText1 = "A simple note"
        private val sampleText2 = "A note n\nline feed"
        private val sampleText3 = """
            
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eget ante magna. Duis consequat fermentum est, non lacinia ante tempus sagittis. Vivamus tristique arcu arcu, non suscipit nunc pulvinar nec. Nam molestie odio in risus laoreet, ac elementum risus finibus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Mauris tristique velit id purus pharetra, sit amet tempor nibh faucibus. Duis risus turpis, dapibus sit amet luctus in, consectetur ac eros. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam ut ligula a orci dignissim scelerisque pretium quis turpis. Suspendisse nec fermentum nisl, non sollicitudin sapien. Proin vel purus sit amet erat tempor consectetur et nec mi.

            Duis volutpat non dui vitae scelerisque. Nulla et quam cursus, viverra purus ac, vulputate eros. Sed quis accumsan urna. Sed quam magna, eleifend ac gravida at, fermentum a tortor. Duis sagittis, urna sed commodo consectetur, sapien sem tristique orci, non ultrices tellus erat eu risus. Nulla fermentum metus a malesuada fringilla. Donec eget metus tellus. Curabitur ac euismod urna, non euismod tortor. 
        """.trimIndent()

        private fun getDate(diff:Long):Date{
            return Date(Date().time+diff)
        }

        fun getNotes() = arrayListOf(
            NoteEntity(1, getDate(0), sampleText1),
            NoteEntity(2, getDate(1), sampleText2),
            NoteEntity(3, getDate(2), sampleText3)
        )
    }
}