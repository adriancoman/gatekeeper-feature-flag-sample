package app.pago.gatekeeper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Gatekeeper(
    private val socketService: SocketService? = null
) {
    private var remoteCampaignFlag = "voda_campaign_2021"

    fun getCampaign(): AvailableCampaigns {
        return when (remoteCampaignFlag) {
            "voda_campaign_2021" -> {
                AvailableCampaigns.VODA
            }
            "travel_campaign_summer" -> {
                AvailableCampaigns.INFOGRAPHIC
            }
            "prepay_campaign_ongoing" -> {
                AvailableCampaigns.IPAY
            }
            else -> {
                AvailableCampaigns.NONE
            }
        }
    }

    fun getCampaignFlow(): Flow<AvailableCampaigns> = flow {
        socketService?.on("flag_change") { newFlag ->
            remoteCampaignFlag = newFlag
        }
        emit(getCampaign())
    }
}