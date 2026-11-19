package com.krassoc.smoothbrainz.data.services.remote

import io.ktor.client.call.body

import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.Url
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import kotlinx.serialization.SerializationException

import com.krassoc.smoothbrainz.model.services.IListenBrainzAPI
import com.krassoc.smoothbrainz.model.data.ListenBrainzAPI.TokenValidation
import com.krassoc.smoothbrainz.model.repo.INetworkMonitor

/*
Maybe I'm stupid duh but it looks like kotlin doesn't let you access string resources outside of
Composable functions which is completely fucking insane
    <string name="listenbrainz_base_url">https://api.listenbrainz.org</string>
    <string name="listenbrainz_base_api_version">1</string>
    <string name="listenbrainz_base_app_name">com.krassoc.smoothbrainz</string>
    <string name="listenbrainz_base_app_version">1.0</string>
    <string name="listenbrainz_base_app_email">kevin@18ballymac.com</string>
 */
private const val BASE_URL    = "api.listenbrainz.org"
private const val API_VERSION = "1"
private const val APP_NAME    = "com.krassoc.smoothbrainz"
private const val APP_VERSION = "1.0"
private const val APP_EMAIL   = "kevin@18ballymac.com"

//@Singleton
class ListenBrainzAPI (
    val networkMonitor: INetworkMonitor,
) : IListenBrainzAPI {
    private val userAgent = "$APP_NAME/$APP_VERSION ( $APP_EMAIL )" //User-Agent: YourAppName/1.0 ( your-email@example.com )
    override suspend fun verifyToken(token: String) : Result<Boolean> {
        val httpClient            = networkMonitor.httpClient
        val url                   = buildUrl("validate-token")
        return try {
            val res : TokenValidation = httpClient.get(url) {
                headers {
                    append(HttpHeaders.Authorization, "Token $token")
                    append(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                    append(HttpHeaders.Accept, ContentType.Application.Json.toString())
                    append(HttpHeaders.UserAgent, userAgent)
                }
            }.body()
            //res.username
            Result.success(res.valid)
        } catch (e: RedirectResponseException) { //3xx
            Result.failure(Exception("RedirectResponseException $e"))
        } catch (e: ClientRequestException) {    //4xx
            Result.failure(Exception("ClientRequestException $e"))
        } catch (e: ServerResponseException) {   //5xx
            Result.failure(Exception("ServerResponseException $e"))
        } catch (e: SerializationException) {
            Result.failure(Exception("SerializationException  $e"))
        } catch (e: Exception) {
            Result.failure(Exception("Exception $e"))
        }
    }
    private fun buildUrl (request: String) : Url {
        val urlBuilder = URLBuilder(            protocol = URLProtocol.HTTPS,
            host= BASE_URL,
            pathSegments = listOf(API_VERSION, request)
        )
        return urlBuilder.build() //.toString()
    }
}
