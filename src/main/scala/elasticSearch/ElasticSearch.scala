package elasticSearch

import com.sksamuel.elastic4s._
import com.sksamuel.elastic4s.FieldsMapper
import com.sksamuel.elastic4s.http.{ElasticClient, ElasticProperties}
import com.sksamuel.elastic4s.http.Response
import com.sksamuel.elastic4s.http.search.SearchResponse
import com.sksamuel.elastic4s.ElasticsearchClientUri
import com.sksamuel.elastic4s.mappings.FieldType._
import java.text.SimpleDateFormat
import java.util.Date

import com.sksamuel.elastic4s.mappings.ObjectField

/**
  * <h1>ElasticSearch</h1>
  * ElasticSearch class.
  * @author Henrique Borges
  * @since 24-04-2019
  */
class ElasticSearch {
  import com.sksamuel.elastic4s.http.ElasticDsl._
  private val port = Integer.valueOf(scala.util.Properties.envOrElse("PORT", "9200"))
  private val host = (scala.util.Properties.envOrElse("HOST", "http://localhost"))
  val client = ElasticClient(ElasticProperties("http://localhost:9200"))
  private val index_ = "mutant"
  private val type_ = "requests"

  /**
    * This  method is responsible for inserting new documents into the Elastic Search index.
    * @param endpoint - Endpoint URL.
    * @param queryParams - Endpoint query params.
    * @param request_ip - Requester's IP Address.
    * @param response_status - HTTP response status.
    * @author Henrique Borges
    * @since 24-04-2019
    */
  def insertDocument(endpoint:String, queryParams:scala.collection.immutable.Map[String,Any], request_ip:String, response_status:Int)={
    val formatter = new SimpleDateFormat("dd-MM-yyyy")
    val date = new Date()
    val when = formatter.format(date)
    client.execute {
      bulk(
        indexInto(index_ / type_).fields("head" -> endpoint, "query_params" -> FieldsMapper.mapper(queryParams),
          "request_ip" -> request_ip,
          "response_status" -> response_status,
          "when" -> when)
      ).refresh(RefreshPolicy.WaitFor)
    }.await
  }
}
