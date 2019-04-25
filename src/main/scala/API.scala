import services.Service
import com.twitter.app.Flag
import com.twitter.finagle.Http
import com.twitter.server.TwitterServer
import com.twitter.util.Await
import io.finch._
import io.finch.circe._
import io.finch.syntax._
import io.circe.generic.auto._
import models.User
import elasticSearch.ElasticSearch

import scala.collection.mutable.ListBuffer

object API extends TwitterServer {
  private val port: Flag[Integer] = flag("port", Integer.valueOf(scala.util.Properties.envOrElse("PORT", "8080")), "TCP port for HTTP server")
  private val host: Flag[String] = flag("host", scala.util.Properties.envOrElse("HOST", "localhost"), "HOST for HTTP server")
  private val service = new Service
  private val elasticSearch = new ElasticSearch

  def allWebsites: Endpoint[ListBuffer[String]] = get("allWebsites") {
    service.getAllWebSites().map(Ok).onFailure(e => {
      elasticSearch.insertDocument("/allWebsites", scala.collection.immutable.Map[String,Any](), "ip", 500)
    }).onSuccess(s => {
      elasticSearch.insertDocument("/allWebsites", scala.collection.immutable.Map[String,Any](), "ip", 200)
    })
  }

  def allUsers: Endpoint[ListBuffer[scala.collection.mutable.Map[String,String]]] = get("allUsers" :: paramOption ("sort")) { sort: Option[String] =>
    var params = scala.collection.immutable.Map[String,Any]()
    params += ("sort" -> sort.getOrElse(""))
    service.getAllUsers(sort.getOrElse("")).map(Ok).onFailure(e => {
      elasticSearch.insertDocument("/getAllUsers", params, "ip", 500)
    }).onSuccess(s => {
      elasticSearch.insertDocument("/getAllUsers", params, "ip", 200)
    })
  }

  def search: Endpoint[ListBuffer[User]] = get("search" :: paramOption ("name")) { name: Option[String] =>
    var params = scala.collection.immutable.Map[String,Any]()
    params += ("name" -> name.getOrElse(""))
    service.search(name.getOrElse("")).map(Ok).onFailure(e => {
      elasticSearch.insertDocument("/search", params, "ip", 500)
    }).onSuccess(s => {
      elasticSearch.insertDocument("/search", params, "ip", 200)
    })

  }

  val api = (allWebsites :+: allUsers :+: search).handle {
    case e: Exception => {
      println("Exception while fulfilling a request. Exception = " + e)
      InternalServerError(e)
    }
  }

  def main(): Unit = {
    println(s"Server is online and listening on ${host()}:${port()}")
    val server =
      Http.server
        .withStatsReceiver(statsReceiver)
        .serve(s":${port()}", api.toServiceAs[Application.Json])
    closeOnExit(server)
    onExit { server.close() }
    Await.ready(adminHttpServer)
  }
}