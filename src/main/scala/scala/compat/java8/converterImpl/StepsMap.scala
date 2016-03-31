package scala.compat.java8.converterImpl

import language.implicitConversions

import scala.compat.java8.collectionImpl._
import scala.compat.java8.runtime._

import Stepper._

// Generic maps defer to the iterator steppers if a more precise type cannot be found via pattern matching
// TODO: implement pattern matching

final class RichMapCanStep[K, V](private val underlying: collection.Map[K, V]) extends AnyVal with MakesAnyKeySeqStepper[K] with MakesAnyValueSeqStepper[V] {
  // No generic stepper because RichIterableCanStep will get that anyway, and we don't pattern match here
  def keyStepper: AnyStepper[K] = new StepsAnyIterator[K](underlying.keysIterator)
  def valueStepper: AnyStepper[V] = new StepsAnyIterator[V](underlying.valuesIterator)
}

final class RichDoubleKeyMapCanStep[V](private val underlying: collection.Map[Double, V]) extends AnyVal with MakesDoubleKeySeqStepper {
  def keyStepper: DoubleStepper = new StepsDoubleIterator(underlying.keysIterator)
}

final class RichDoubleValueMapCanStep[K](private val underlying: collection.Map[K, Double]) extends AnyVal with MakesDoubleValueSeqStepper {
  def valueStepper: DoubleStepper = new StepsDoubleIterator(underlying.valuesIterator)
}

final class RichIntKeyMapCanStep[V](private val underlying: collection.Map[Int, V]) extends AnyVal with MakesIntKeySeqStepper {
  def keyStepper: IntStepper = new StepsIntIterator(underlying.keysIterator)
}

final class RichIntValueMapCanStep[K](private val underlying: collection.Map[K, Int]) extends AnyVal with MakesIntValueSeqStepper {
  def valueStepper: IntStepper = new StepsIntIterator(underlying.valuesIterator)
}

final class RichLongKeyMapCanStep[V](private val underlying: collection.Map[Long, V]) extends AnyVal with MakesLongKeySeqStepper {
  def keyStepper: LongStepper = new StepsLongIterator(underlying.keysIterator)
}

final class RichLongValueMapCanStep[K](private val underlying: collection.Map[K, Long]) extends AnyVal with MakesLongValueSeqStepper {
  def valueStepper: LongStepper = new StepsLongIterator(underlying.valuesIterator)
}
