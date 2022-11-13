package app.pago.gatekeeper.evolution.initialFlag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.pago.gatekeeper.Constants.VODA_IMG
import app.pago.gatekeeper.R
import app.pago.gatekeeper.evolution.inversionFlag.decisions.PromoCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InitialFlagViewModel: ViewModel() {

    var remoteCampaignFlag = "voda_campaign_2021"

    private val _activeCampaign = MutableStateFlow<PromoCard?>(null)
    val activeCampaign = _activeCampaign.asStateFlow()

    fun getCardToDisplay() {
        val cardToDisplay = if (remoteCampaignFlag == "voda_campaign_2021") {
            PromoCard(
                text = R.string.voda_title,
                imageUrl = VODA_IMG,
                ctaText = R.string.voda_cta
            )
        } else {
            null
        }
    }
}