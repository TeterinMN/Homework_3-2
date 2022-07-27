class NoteService {
    val notes = mutableListOf<Note>()

    fun add(note: Note) {
        if (notes.isEmpty()) {
            note.id = 1
        } else {
            note.id = notes.last().id + 1
        }
        notes.add(note)
    }

    fun delete(id: Int) {
        val iterator = notes.iterator()
        while (iterator.hasNext()) {
            if (id == iterator.next().id) {
                iterator.remove()
            }
        }
    }

    fun edit(id: Int, title: String, text: String) {
        for (note in notes) {
            if (id == note.id) {
                note.title = title
                note.text = text
            }
        }
    }

}