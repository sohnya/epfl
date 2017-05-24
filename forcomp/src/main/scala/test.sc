import forcomp.Anagrams._

val w = "Wordd"

(for( (a,b) <- w.toLowerCase() groupBy( (element : Char) => element ) )
  yield (a,b.length)
  ).toList

val c = "c"

List("abcd", "e").mkString

val dictionary = List("aaa","aab","baa","bbb")

dictionary groupBy wordOccurrences

val abba = List(('a', 2), ('b', 2))
combinations(abba)

val x = ('a',2)
(0 to x._2).map((x._1, _)).toList


Map("1"->2, "2"->2,"3"->3,"4"->4).foldLeft(0){ case (a, (k, v)) => a+v}

val y = List(1,2,3)
(y foldLeft 0)(_ + _)

val a = Map(('b',1),('c',2),('a',2))
val b = Map(('b',1),('c',1)) withDefaultValue 0
(a map(x => (x._1,x._2 - b(x._1)))).filter(_._2 != 0)

//a foldLeft Nil ((_._1,_.2 - b(_._1)) ::)

//combinations(a)
//combinations(b)
//a.sortBy(_._2)
//a.sortWith{_._1 > _._1}