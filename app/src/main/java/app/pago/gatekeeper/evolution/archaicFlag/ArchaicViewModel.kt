package app.pago.gatekeeper.evolution.archaicFlag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.pago.gatekeeper.Constants.VODA_IMG
import app.pago.gatekeeper.R
import app.pago.gatekeeper.evolution.inversionFlag.decisions.PromoCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArchaicViewModel: ViewModel() {

    private val _activeCampaign = MutableStateFlow<PromoCard?>(null)
    val activeCampaign = _activeCampaign.asStateFlow()

    fun getCardToDisplay() {
        // var isVodaCampaign = true // uncomment to test
        val isVodaCampaign = false

        val cardToDisplay = if (isVodaCampaign) {
            PromoCard(
                text = R.string.voda_title,
                imageUrl = VODA_IMG,
                ctaText = R.string.voda_cta
            )
        } else {
            null
        }

        cardToDisplay?.let {
            viewModelScope.launch {
                _activeCampaign.emit(cardToDisplay)
            }
        }
    }
}