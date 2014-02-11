package models

import scala.concurrent.{ExecutionContext, Future}

object UserStore {

  case class User(id: Long, name: String, age: Int)

  val Users = Map[Long, User](
    1L -> User(1L, "Joe", 34),
    2L -> User(2L, "Mr T", 55))

  def search(name: String)(implicit ec: ExecutionContext): Future[Iterable[User]] = {
    Future {
      Thread.sleep(5000)
      Users.values.filter(u => u.name == name)
    }
  }

}
