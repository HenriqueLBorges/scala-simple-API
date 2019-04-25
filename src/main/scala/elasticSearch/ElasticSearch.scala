package elasticSearch

import com.sksamuel.elastic4s._
import com.sksamuel.elastic4s.FieldsMapper
import com.sksamuel.elastic4s.http.{ElasticClient, ElasticProperties}
import java.text.SimpleDateFormat
import java.util.Date

/**
  * <h1>ElasticSearch</h1>
  * Elasticsearch class.
  * @author Henrique Borges
  * @since 24-04-2019
  */
class ElasticSearch {
  import com.sksamuel.elastic4s.http.ElasticDsl._
  private val port = Integer.valueOf(scala.util.Properties.envOrElse("ES_PORT", "9200"))
  private val host = (scala.util.Properties.envOrElse("ES_HOST", "http://localhost"))
  val client = ElasticClient(ElasticProperties(host+":"+port))
  private val index_ = "mutant"
  private val type_ = "requests"

  /**
    * This  method is responsible for inserting new documents into the Elasticsearch index.
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
      createIndex("mutant_")
    }.await
    client.execute {
      bulk(
        indexInto(index_ / type_).fields("head" -> endpoint, "query_params" -> FieldsMapper.mapper(queryParams),
          "request_ip" -> request_ip,
          "response_status" -> response_status,
          "when" -> when)
      ).refresh(RefreshPolicy.WaitFor)
    }.await
  }

  /**
    * This  method is responsible for create a new index into the Elasticsearch.
    * @author Henrique Borges
    * @since 24-04-2019
    */
  private def create(): Unit ={
    try {
      client.execute {
        createIndex("mutant_")
      }.await
    }catch {
      case e: Exception => println("Exception no ElasticSearch. Exception = " + e)
    }
  }

  create()
}
