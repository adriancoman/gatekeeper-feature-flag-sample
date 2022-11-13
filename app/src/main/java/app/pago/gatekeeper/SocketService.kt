package app.pago.gatekeeper

interface SocketService {
    fun on(s: String, response: (String) -> Unit)
}