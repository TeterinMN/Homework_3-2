import org.junit.Assert.assertEquals
import org.junit.Test

class NoteServiceTest {
    @Test
    fun addNoteIfListEmpty() {
        val service = NoteService()
        val comment = Comment(text = "First Comment")
        val note = Note(
            title = "First Note",
            text = "First Text",
            comments = mutableListOf(comment)
        )
        service.add(note)

        val result = note.id

        assertEquals(1, result)
    }

    @Test
    fun addNoteIfListNotEmpty() {
        val service = NoteService()
        val comment = Comment(text = "First Comment")
        val noteFirst = Note(
            title = "First Title",
            text = "First Text",
            comments = mutableListOf(comment)
        )

        val noteSecond = Note(
            title = "Second Title",
            text = "Second Text",
            comments = mutableListOf(comment)
        )

        service.add(noteFirst)
        service.add(noteSecond)

        val result = noteSecond.id

        assertEquals(2, result)
    }

    @Test
    fun deleteNoteWithExistId() {
        val service = NoteService()
        val comment = Comment(text = "First Comment")
        val note = Note(
            title = "First Title",
            text = "First Text",
            comments = mutableListOf(comment)
        )
        service.add(note)
        service.delete(1)

        val result = service.notes.size

        assertEquals(0, result)
    }

    @Test
    fun deleteNoteWithNotExistId() {
        val service = NoteService()
        val comment = Comment(text = "First Comment")
        val note = Note(
            title = "First Title",
            text = "First Text",
            comments = mutableListOf(comment)
        )
        service.add(note)
        service.delete(2)

        val result = service.notes.size

        assertEquals(1, result)
    }

    @Test
    fun editNoteWithExistId() {
        val service = NoteService()
        val comment = Comment(text = "First Comment")
        val title = "First Title"
        val text = "First Text"
        val note = Note(
            title = "First Title",
            text = "First Text",
            comments = mutableListOf(comment)
        )

        service.add(note)
        service.edit(1, title, text)

        val resultTitle = note.title
        val resultText = note.text

        assertEquals(title, resultTitle)
        assertEquals(text, resultText)
    }

    @Test
    fun editNoteWithNotExistId() {
        val service = NoteService()
        val comment = Comment(text = "First Comment")
        val title = "First Title"
        val text = "First Text"
        val note = Note(
            title = "First Title",
            text = "First Text",
            comments = mutableListOf(comment)
        )

        service.add(note)
        service.edit(2, title, text)

        val resultTitle = note.title
        val resultText = note.text

        assertEquals("First Title", resultTitle)
        assertEquals("First Text", resultText)
    }

}