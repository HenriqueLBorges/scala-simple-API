package connection

import java.util
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request

/**
  * <h1>Request</h1>
  * Used to make HTTP requests.
  * @author Henrique Borges
  * @since 24-04-2019
  */
class Request {
  /**
    * This method executes a GET request.
    *
    * @param endpoint - Request URL.
    * @param headers - A Map object that will be used as the request headers.
    * @return body - A String containg the response body.
    * @author Henrique Borges
    * @since 24-04-2019
    */
  def get(endpoint: String, headers: util.Map[String, String]): String = {
    val client = new OkHttpClient()
    val request = new Request.Builder().url(endpoint).get.headers(Headers.of(headers)).build
    val call = client.newCall(request)
    val response = call.execute
    val body = response.body.string
    response.close()
    return body
  }
}
