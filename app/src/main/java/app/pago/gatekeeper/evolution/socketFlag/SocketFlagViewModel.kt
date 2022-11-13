package app.pago.gatekeeper.evolution.socketFlag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.pago.gatekeeper.AvailableCampaigns
import app.pago.gatekeeper.Constants.VODA_IMG
import app.pago.gatekeeper.Gatekeeper
import app.pago.gatekeeper.R
import app.pago.gatekeeper.evolution.inversionFlag.decisions.PromoCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SocketFlagViewModel(
    private val gatekeeper: Gatekeeper
): ViewModel() {
    private val _activeCampaign = MutableStateFlow<PromoCard?>(null)
    val activeCampaign = _activeCampaign.asStateFlow()

    fun getCardToDisplay() {
        viewModelScope.launch {
            gatekeeper.getCampaignFlow().collect { campaign ->
                getCampaignCard(campaign)?.let { cardToDisplay ->
                    ...
                }
            }
        }
    }
}