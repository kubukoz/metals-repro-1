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
    onEmpty: F[B]
  )(
    implicit SC: fs2.Compiler[F, F]
  ): F[B] = stream
    .pull
    .peek1
    .void
    .stream
    .compile
    .last
    .flatMap(_.getOrElse(onEmpty))

}
