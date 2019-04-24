package elasticSearch

import com.sksamuel.elastic4s._
import com.sksamuel.elastic4s.http.{ElasticClient, ElasticProperties}
import com.sksamuel.elastic4s.http.Response
import com.sksamuel.elastic4s.http.search.SearchResponse
import com.sksamuel.elastic4s.{ElasticsearchClientUri}
import com.sksamuel.elastic4s.mappings.FieldType._
import java.text.SimpleDateFormat
import java.util.Date

/**
  * <h1>ElasticSearch</h1>
  * ElasticSearch class.
  * @author Henrique Borges
  * @since 24-04-2019
  */
class ElasticSearch {
  private val port = Integer.valueOf(scala.util.Properties.envOrElse("PORT", "9200"))
  private val host = (scala.util.Properties.envOrElse("HOST", "http://localhost"))
  //private val client = ElasticClient(ElasticProperties("http://localhost:9200"))
  private val client = ElasticClient.remote("url.of.your.es.server", 9300)
  private val index_ = "mutant"

  /**
    * This  method is responsible for inserting new documents into the Elastic Search index.
    * @param endpoint - Endpoint URL.
    * @param queryParams - Endpoint query params.
    * @param request_ip - Requester's IP Address.
    * @param response_status - HTTP response status.
    * @author Henrique Borges
    * @since 24-04-2019
    */
  def insertDocument(endpoint:String, queryParams:String, request_ip:String, response_status:Int)={
    val formatter = new SimpleDateFormat("dd/MM/yyyy")
    val date = new Date()
    val when = formatter.format(date)
    client..execute { index into index_ -> "requests" fields {
      "head" -> endpoint,
      "query_params" -> queryParams,
      "request_ip" -> request_ip,
      "response_status" -> response_status,
      "when" -> when
    } }.await
  }

  /**
    * This  method is responsible for inserting new documents into the Elastic Search index.
    * @param endpoint - Endpoint URL.
    * @param queryParams - Endpoint query params.
    * @param request_ip - Requester's IP Address.
    * @param response_status - HTTP response status.
    * @author Henrique Borges
    * @since 24-04-2019
    */
  def createIndex(): Unit ={
    client.execute { createIndex("places") }
  }

  this(this.createIndex());
}
