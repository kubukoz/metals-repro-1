package com.example

import cats.effect.IOApp
import cats.effect.IO

object demo0 {

  import cats.MonadThrow
  import cats.implicits._
  import fs2.Pull
  import fs2.Stream

  def onEmptyOrNonEmpty[F[_]: MonadThrow, A, B](
    stream: Stream[F, A]
  )(
    onNonEmpty: Stream[F, A] => F[B]
  )(
    onEmpty: F[B]
  )(
    implicit SC: fs2.Compiler[F, F]
  ): F[B] = stream
    .pull
    .peek1
    .flatMap {
      _.traverse_ { case (h, t) =>
        Pull.output1(onNonEmpty((Stream.emit(h) ++ t)))
      }
    }
    .stream
    .compile
    .last
    .flatMap(_.getOrElse(onEmpty))

}
