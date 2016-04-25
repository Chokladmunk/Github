abstract class Chord {
	val name: String
	val grip: Array[Int]
	val tuning: Array[String]
	
	def lowestFret(): Int = {grip.min}
	def highestFret(): Int = {grip.max}
	def getNote(i: Int): String = {Notes.fromNumberToName(Notes.fromNameToNumber(tuning(i-1))+grip(i-1))}
	override def toString(): String = {name +": "+ grip.mkString(" ") + "; " + tuning.mkString(" ")}
	
	//TODO: Implement fretBoard() 
	def fretBoard(): String = {
		//toString+"; Fret range ["+lowestFret+", "+highestFret+"]" + "\n" +
		//for(i <- 1 to highestFret) { yield for(j <- 1 to tuning.size) {yield if() " *" else " |"} + i	}
	}
}


class GuitarChord(val name: String, val grip: Array[Int]) 
	extends Chord {
		val tuning: Array[String] = Array[String]("E","A","D","G","B","E")
		override def toString(): String = {"Guitar "+super.toString}
}

class UkeleleChord(val name: String, val grip: Array[Int]) 
	extends Chord {
		val tuning: Array[String] = Array[String]("A","D","F#","B")
		override def toString(): String = {"Guitar "+super.toString}
}

object Notes {
	class Notes {
		private val notes = Array[String]("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
		def fromNumberToName(i: Int): String = {notes(i%12)}
		def fromNameToNumber(note: String): Int = {notes.indexWhere(note == _)}
	}
}