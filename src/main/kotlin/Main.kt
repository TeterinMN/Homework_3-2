fun main() {

    val noteOne = Note(title = "Первая заметка", text = "Текст первой заметки")
    val noteTwo = Note(title = "Вторая заметка", text = "Текст второй заметки")
    val noteThree = Note(title = "Третья заметка", text = "Текст третьей заметки")
    val noteService = NoteService()

    noteService.add(noteOne)
    noteService.add(noteTwo)
    println("Добавление заметок:")
    for (note in noteService.notes) {
        println(note)
    }

    noteService.delete(1)
    println("\nУдаление заметки:")
    for (note in noteService.notes) {
        println(note)
    }

    noteService.add(noteThree)
    println("\nДобавление заметки:")
    for (note in noteService.notes) {
        println(note)
    }

    noteService.edit(3, "Четвертая заметка", "Текст четвертой заметки")
    println("\nРедактирование заметки по id")
    for (note in noteService.notes) {
        println(note)
    }

}