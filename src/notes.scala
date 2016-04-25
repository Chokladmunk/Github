object Notes {
	private val notes = Array[String]("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
	def fromNumberToName(i: Int): String = {notes(i%12)}
	def fromNameToNumber(note: String): Int = {notes.indexWhere(note == _)}
}