//package pl.edu.pollub.yals.endpoints
//
//import com.auth0.spring.security.api.authentication.PreAuthenticatedAuthenticationJsonWebToken
//import org.springframework.http.server.reactive.ServerHttpRequest
//import org.springframework.security.core.Authentication
//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.context.SecurityContext
//import org.springframework.security.core.context.SecurityContextHolder
//import org.springframework.security.web.server.context.ServerSecurityContextRepository
//import org.springframework.web.server.ServerWebExchange
//import reactor.core.publisher.Mono
//
//class BearerServerSecurityContextRepository : ServerSecurityContextRepository {
//    override fun save(exchange: ServerWebExchange?, context: SecurityContext?): Mono<Void> {
//        return Mono.empty()
//    }
//
//    override fun load(exchange: ServerWebExchange?): Mono<SecurityContext> {
//        val context = SecurityContextHolder.createEmptyContext()
//        val token = tokenFromRequest(exchange!!.request)
//        val authentication = PreAuthenticatedAuthenticationJsonWebToken.usingToken(token)
//        if (authentication != null) {
//            context.authentication = authentication
//        } else {
//            context.authentication = object : Authentication {
//                override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun setAuthenticated(isAuthenticated: Boolean) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun getName(): String {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun getCredentials(): Any {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun getPrincipal(): Any {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun isAuthenticated(): Boolean = false
//                override fun getDetails(): Any {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//            }
//        }
//        return Mono.just(context)
//    }
//
//    private fun tokenFromRequest(request: ServerHttpRequest): String? {
//        val authorizationHeader = request.headers["Authorization"]?.first()
//
//        if (authorizationHeader == null || !authorizationHeader.startsWith("bearer")) {
//            return null
//        }
//
//        val parts = authorizationHeader.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//
//        return if (parts.size < 2) {
//            null
//        } else parts[1].trim { it <= ' ' }
//
//    }
//}