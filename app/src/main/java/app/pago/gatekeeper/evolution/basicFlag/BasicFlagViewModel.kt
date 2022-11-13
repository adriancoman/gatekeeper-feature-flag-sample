package app.pago.gatekeeper.evolution.basicFlag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.pago.gatekeeper.AvailableCampaigns
import app.pago.gatekeeper.Constants.INFOG_IMG
import app.pago.gatekeeper.Constants.VODA_IMG
import app.pago.gatekeeper.Gatekeeper
import app.pago.gatekeeper.R
import app.pago.gatekeeper.evolution.inversionFlag.decisions.PromoCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BasicFlagViewModel(
    private val gatekeeper: Gatekeeper
): ViewModel() {

    private val _activeCampaign = MutableStateFlow<PromoCard?>(null)
    val activeCampaign = _activeCampaign.asStateFlow()

    fun getCardToDisplay() {
        val cardToDisplay = when (gatekeeper.getCampaign()) {
            AvailableCampaigns.VODA -> {
                PromoCard(
                    text = R.string.voda_title,
                    imageUrl = VODA_IMG,
                    ctaText = R.string.voda_cta
                )
            }
            AvailableCampaigns.INFOGRAPHIC -> {
                PromoCard(
                    text = R.string.infographic_title,
                    imageUrl = INFOG_IMG,
                    ctaText = R.string.infographic_cta
                )
            }
            else -> {
                null
            }
        }

        cardToDisplay?.let {
            viewModelScope.launch {
                _activeCampaign.emit(cardToDisplay)
            }
        }
    }
}