package tests
/*import io.finch.Input
import models.User
import org.scalatest.{FlatSpec, Matchers}*/

/**
  * <h1>Test</h1>
  * Test class.
  * @author Henrique Borges
  * @since 25-04-2019
  */
class Test {
  //import API._
  /*behavior of "/allWebsites"

  it should "String List of user's websites" in {
    val expectedResponse = ListBuffer[String]()
    expectedResponse += "hildegard.org"
    expectedResponse += "anastasia.net"
    expectedResponse += "ramiro.info"
    expectedResponse += "kale.biz"
    expectedResponse += "demarco.info"
    expectedResponse += "ola.org"
    expectedResponse += "elvis.io"
    expectedResponse += "jacynthe.com"
    expectedResponse += "conrad.com"
    expectedResponse += "ambrose.net"
    hello(Input.get("/allWebsites")).awaitValueUnsafe() shouldBe Some(expectedResponse)
  }

  it should "Map List of containing user info" in {
    var users = new ListBuffer[scala.collection.mutable.Map[String,String]]
    val user = scala.collection.mutable.Map[String,String]()

    user += ("name" -> "Keebler LLC")
    user += ("email" -> "Chelsey Dietrich")
    user += ("company" -> "Lucio_Hettinger@annie.ca")
    users += user

    user += ("name" -> "Clementina DuBuque")
    user += ("email" -> "Rey.Padberg@karina.biz")
    user += ("company" -> "Hoeger LLC")
    users += user

    user += ("name" -> "Clementine Bauch")
    user += ("email" -> "Nathan@yesenia.net")
    user += ("company" -> "Romaguera-Jacobson")
    users += user

    user += ("name" -> "Ervin Howell")
    user += ("email" -> "Shanna@melissa.tv")
    user += ("company" -> "Deckow-Crist")
    users += user

    user += ("name" -> "Glenna Reichert")
    user += ("email" -> "Chaim_McDermott@dana.io")
    user += ("company" -> "Yost and Sons")
    users += user

    user += ("name" -> "Kurtis Weissnat")
    user += ("email" -> "Telly.Hoeger@billy.biz")
    user += ("company" -> "Johns Group")
    users += user

    user += ("name" -> "Leanne Graham")
    user += ("email" -> "Sincere@april.biz")
    user += ("company" -> "Romaguera-Crona")
    users += user

    user += ("name" -> "Mrs. Dennis Schulist")
    user += ("email" -> "Karley_Dach@jasper.info")
    user += ("company" -> "Considine-Lockman")
    users += user

    user += ("name" -> "Nicholas Runolfsdottir V")
    user += ("email" -> "Sherwood@rosamond.me")
    user += ("company" -> "Abernathy Group")
    users += user

    user += ("name" -> "Patricia Lebsack")
    user += ("email" -> "Julianne.OConner@kory.org")
    user += ("company" -> "Robel-Corkery")
    users += user

    hello(Input.get("/allUsers")).awaitValueUnsafe() shouldBe Some(users)
  }

  it should "String List of user's websites" in {
    var users = new ListBuffer[User]
    var user = new User()
    val address = scala.collection.mutable.Map[String,String]()
    val company = scala.collection.mutable.Map[String,String]()

    address += ("street" -> "Kulas Light")
    address += ("suite" -> "Apt. 556")
    address += ("city" -> "Gwenborough")
    address += ("zipcode" -> "92998-3874")
    address += ("geo_lat" -> "-37.3159")
    address += ("geo_lng" -> "81.1496")

    company += ("name" -> "Romaguera-Crona")
    company += ("catchPhrase" -> "Multi-layered client-server neural-net")
    company += ("bs" -> "harness real-time e-markets")

    users += new User(1, "Leanne Graham", "Bret",
          "Sincere@april.biz", address, "1-770-736-8031 x56442", "hildegard.org", company)

    address += ("street" -> "Victor Plains")
    address += ("suite" -> "90566-7771")
    address += ("city" -> "Wisokyburgh")
    address += ("zipcode" -> "90566-7771")
    address += ("geo_lat" -> "-43.9509")
    address += ("geo_lng" -> "-34.4618")

    company += ("name" -> "Deckow-Crist")
    company += ("catchPhrase" -> "synergize scalable supply-chains")
    company += ("bs" -> "Proactive didactic contingency")

    users += new User(2, "Ervin Howell", "Antonette",
          "Shanna@melissa.tv", address, "010-692-6593 x09125", "anastasia.net", company)

    address += ("street" -> "Douglas Extension")
    address += ("suite" -> "Suite 847")
    address += ("city" -> "McKenziehaven")
    address += ("zipcode" -> "59590-4157")
    address += ("geo_lat" -> "-68.6102")
    address += ("geo_lng" -> "-47.0653")

    company += ("name" -> "Romaguera-Jacobson")
    company += ("catchPhrase" -> "e-enable strategic applications")
    company += ("bs" -> "Face to face bifurcated interface")

    users += new User(3, "Clementine Bauch", "Samantha",
          "Nathan@yesenia.net", address, "1-463-123-4447", "ramiro.info", company)

    address += ("street" -> "Hoeger Mall")
    address += ("suite" -> "Apt. 692")
    address += ("city" -> "South Elvis")
    address += ("zipcode" -> "53919-4257")
    address += ("geo_lat" -> "29.4572")
    address += ("geo_lng" -> "-164.2990")

    company += ("name" -> "")
    company += ("catchPhrase" -> "")
    company += ("bs" -> "")

    users += new User(4, "Patricia Lebsack", "Karianne",
          "Julianne.OConner@kory.org", address, "493-170-9623 x156", "kale.biz", company)

    address += ("street" -> "Skiles Walks")
    address += ("suite" -> "Suite 351")
    address += ("city" -> "Roscoeview")
    address += ("zipcode" -> "33263")
    address += ("geo_lat" -> "-31.8129")
    address += ("geo_lng" -> "62.5342")

    company += ("name" -> "Keebler LLC")
    company += ("catchPhrase" -> "User-centric fault-tolerant solution")
    company += ("bs" -> "revolutionize end-to-end systems")

    users += new User(5, "Chelsey Dietrich", "Kamren",
          "Lucio_Hettinger@annie.ca", address, "(254)954-1289", "demarco.info", company)

    address += ("street" -> "Norberto Crossing")
    address += ("suite" -> "Apt. 950")
    address += ("city" -> "South Christy")
    address += ("zipcode" -> "23505-1337")
    address += ("geo_lat" -> "-71.4197")
    address += ("geo_lng" -> "71.7478")

    company += ("name" -> "Considine-Lockman")
    company += ("catchPhrase" -> "e-enable innovative applications")
    company += ("bs" -> "Synchronised bottom-line interface")

    users += new User(6, "Mrs. Dennis Schulist", "Leopoldo_Corkery",
          "Karley_Dach@jasper.info", address, "1-477-935-8478 x6430", "ola.org", company)

    address += ("street" -> "Rex Trail")
    address += ("suite" -> "Suite 280")
    address += ("city" -> "Howemouth")
    address += ("zipcode" -> "58804-1099")
    address += ("geo_lat" -> "24.8918")
    address += ("geo_lng" -> "21.8984")

    company += ("name" -> "Johns Group")
    company += ("catchPhrase" -> "Configurable multimedia task-force")
    company += ("bs" -> "generate enterprise e-tailers")

    users += new User(7, "Kurtis Weissnat", "Elwyn.Skiles",
          "Telly.Hoeger@billy.biz", address, "210.067.6132", "elvis.io", company)

    address += ("street" -> "Ellsworth Summit")
    address += ("suite" -> "Suite 729")
    address += ("city" -> "Aliyaview")
    address += ("zipcode" -> "45169")
    address += ("geo_lat" -> "-14.3990")
    address += ("geo_lng" -> "-120.7677")

    company += ("name" -> "Abernathy Group")
    company += ("catchPhrase" -> "Implemented secondary concept")
    company += ("bs" -> "e-enable extensible e-tailers")

    users += new User(8, "Nicholas Runolfsdottir V", "Maxime_Nienow",
          "Sherwood@rosamond.me", address, "586.493.6943 x140", "jacynthe.com", company)

    address += ("street" -> "Dayna Park")
    address += ("suite" -> "Suite 449")
    address += ("city" -> "Bartholomebury")
    address += ("zipcode" -> "76495-3109")
    address += ("geo_lat" -> "24.6463")
    address += ("geo_lng" -> "-168.8889")

    company += ("name" -> "Yost and Sons")
    company += ("catchPhrase" -> "Switchable contextually-based project")
    company += ("bs" -> "aggregate real-time technologies")

    users += new User(9, "Glenna Reichert", "Delphine",
          "Chaim_McDermott@dana.io", address, "(775)976-6794 x41206", "conrad.com", company)

    address += ("street" -> "Kattie Turnpike")
    address += ("suite" -> "Suite 198")
    address += ("city" -> "Lebsackbury")
    address += ("zipcode" -> "31428-2261")
    address += ("geo_lat" -> "57.2232")
    address += ("geo_lng" -> "-38.2386")

    company += ("name" -> "Hoeger LLC")
    company += ("catchPhrase" -> "Centralized empowering task-force")
    company += ("bs" -> "target end-to-end models")

    users += new User(10, "Clementina DuBuque", "Moriah.Stanton",
          "Rey.Padberg@karina.biz", address, "024-648-3804", "ambrose.net", company)
    hello(Input.get("/allWebsites")).awaitValueUnsafe() shouldBe Some(users)
  }*/
}
