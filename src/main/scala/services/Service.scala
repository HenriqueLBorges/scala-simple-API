package services

import java.util

import models.User
import com.twitter.util.Future
import connection.Request
import com.google.gson.JsonParser

import scala.collection.mutable.ListBuffer
/**
  * <h1>Service</h1>
  * API Service class.
  * @author Henrique Borges
  * @since 24-04-2019
  */
class Service {

  /**
    * This service method is responsible for getting a list containing all users websites.
    * @return websites - String List.
    * @author Henrique Borges
    * @since 24-04-2019
    */
  def getAllWebSites(): Future[ListBuffer[String]] = {
    val headers = new util.HashMap[String, String]()
    val parser = new JsonParser()
    val websites = new ListBuffer[String]()
    parser.parse(callEndpoint("https://jsonplaceholder.typicode.com/users", headers)).getAsJsonArray().forEach(item => {
      websites += item.getAsJsonObject.get("website").getAsString()
    })
    Future.value(websites)
  }

  /**
    * This service method is responsible for getting a list containing all users name, email and company name.
    * @param sort - This sort param can be "name", "email" or "company" and will be used to order the list alphabetically. If there
    *             isn't a valid option the list will be ordered by user's name.
    * @return users - Map[String,String] List containing all users.
    * @author Henrique Borges
    * @since 24-04-2019
    */
  def getAllUsers(sort: String): Future[ListBuffer[scala.collection.mutable.Map[String,String]]] = {
    val headers = new util.HashMap[String, String]()
    val parser = new JsonParser()
    var users = new ListBuffer[scala.collection.mutable.Map[String,String]]
    var order = "name"

    if(sort != null){
      if(sort == "email") {
        order = "email"
      } else if (sort == "company") {
        order = "company"
      }
    }

    parser.parse(callEndpoint("https://jsonplaceholder.typicode.com/users", headers)).getAsJsonArray().forEach(item => {
      val user = scala.collection.mutable.Map[String,String]()

      user += ("name" -> item.getAsJsonObject().get("name").getAsString())
      user += ("email" -> item.getAsJsonObject().get("email").getAsString())
      user += ("company" -> item.getAsJsonObject().get("company").getAsJsonObject.get("name").getAsString())
      users += user

    })

    //Order the list.
    users = users sortBy (_.get(order))
    Future.value(users)
  }

  /**
    * This service method is responsible for return a list of users based on a named passed as parameter.
    * @param name - This param is used as keyword to search the users on their address. The default keyword value is "suite".
    * @return users - Users List.
    * @author Henrique Borges
    * @since 24-04-2019
    */
  def search(name: String): Future[ListBuffer[User]] = {
    val headers = new util.HashMap[String, String]()
    val parser = new JsonParser()
    var users = new ListBuffer[User]
    var keyword = ""

    if(name != null){
      keyword = name
    }
    parser.parse(callEndpoint("https://jsonplaceholder.typicode.com/users", headers)).getAsJsonArray().forEach(item => {
      val json = item.getAsJsonObject()

      if (json.get("address").getAsJsonObject.get("suite").getAsString().toLowerCase() contains keyword.toLowerCase()){
        val address = scala.collection.mutable.Map[String,String]()
        address += ("street" -> json.get("address").getAsJsonObject.get("street").getAsString())
        address += ("suite" -> json.get("address").getAsJsonObject.get("suite").getAsString())
        address += ("city" -> json.get("address").getAsJsonObject.get("city").getAsString())
        address += ("zipcode" -> json.get("address").getAsJsonObject().get("zipcode").getAsString())
        address += ("geo_lat" -> json.get("address").getAsJsonObject().get("geo").getAsJsonObject().get("lat").getAsString())
        address += ("geo_lng" -> json.get("address").getAsJsonObject().get("geo").getAsJsonObject().get("lng").getAsString())

        val company = scala.collection.mutable.Map[String,String]()
        company += ("name" -> json.get("company").getAsJsonObject.get("name").getAsString())
        company += ("catchPhrase" -> json.get("company").getAsJsonObject.get("catchPhrase").getAsString())
        company += ("bs" -> json.get("company").getAsJsonObject.get("bs").getAsString())

        val user = new User(json.get("id").getAsInt(), json.get("name").getAsString(), json.get("username").getAsString(),
          json.get("email").getAsString(), address, json.get("phone").getAsString(), json.get("website").getAsString(), company)

        users += user
      }

    })
    Future.value(users)
  }

  def callEndpoint(endpoint: String, headers: util.Map[String, String]): String = {
    val request = new Request()
    return request.get(endpoint, headers)
  }
}