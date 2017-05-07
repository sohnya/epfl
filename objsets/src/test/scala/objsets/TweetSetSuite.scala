package objsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetSuite extends FunSuite {
  trait TestSets {
    val emptySet = new Empty
    val a = emptySet.incl(new Tweet("a", "a body", 20))
    val ab = a.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val abc = ab.incl(c)
    val abd = ab.incl(d)
    val abcd = abc.incl(d)
  }

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  test("filter: on empty set") {
    new TestSets {
      assert(size(emptySet.filter(tw => tw.user == "a")) === 0)
    }
  }

  test("filter: a on set5") {
    new TestSets {
      assert(size(abcd.filter(tw => tw.user == "a")) === 1)
    }
  }

  test("filter: 20 on set5") {
    new TestSets {
      assert(size(abcd.filter(tw => tw.retweets == 20)) === 2)
    }
  }

  test("union: set4c and set4d") {
    new TestSets {
      assert(size(abc.union(abd)) === 4)
    }
  }

  test("union: with empty set (1)") {
    new TestSets {
      assert(size(abcd.union(emptySet)) === 4)
    }
  }

  test("union: with empty set (2)") {
    new TestSets {
      assert(size(emptySet.union(abcd)) === 4)
    }
  }

  test("descending: set5") {
    new TestSets {
      //val trends = abcd.descendingByRetweet
      //assert(!trends.isEmpty)
      //assert(trends.head.user == "a" || trends.head.user == "b")
    }
  }

  }
