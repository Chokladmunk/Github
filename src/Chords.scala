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
		toString+"; Fret range ["+lowestFret+", "+highestFret+"]" + "\n" +
		(for(i <- 0 to (highestFret-1)) 
		  yield {for(j <- 0 to (tuning.size-1)) 
		    yield {if(grip(j)==i && i != 0) " *" else if(grip(j)==i) "_*" else if(i==0) "_ " else " |"}}.mkString).mkString("\n")
	}
}

case class GuitarChord(val name: String, val grip: Array[Int]) 
	extends Chord {
		val tuning: Array[String] = Array[String]("E","A","D","G","B","E")
		override def toString(): String = {"Guitar "+super.toString}
}

case class UkeleleChord(val name: String, val grip: Array[Int]) 
	extends Chord {
		val tuning: Array[String] = Array[String]("A","D","F#","B")
		override def toString(): String = {"Guitar "+super.toString}
}

object Notes {
	private val notes = Array[String]("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
	def fromNumberToName(i: Int): String = {notes(i%12)}
	def fromNameToNumber(note: String): Int = {notes.indexWhere(note == _)}
}

object main {
  def main(args: Array[String]): Unit = {
    val gc = new GuitarChord("G", Array[Int](0,5,5,4,3,3))
    println(gc.fretBoard)
  }
}