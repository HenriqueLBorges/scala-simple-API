package models
/**
  * <h1>User</h1>
  * Model class for the user.
  * @author Henrique Borges
  * @since 24-04-2019
  */
case class User(id: Int, name: String, username: String, email: String, address: scala.collection.mutable.Map[String,String], phone: String, website: String, company: scala.collection.mutable.Map[String,String])