package app.pago.gatekeeper.evolution.inversionFlag

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.pago.gatekeeper.evolution.inversionFlag.decisions.BasicCard
import app.pago.gatekeeper.evolution.inversionFlag.decisions.PromoCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InversionViewModel(
    private val displayedCard: BasicCard?
): ViewModel() {

    private val _activeCampaign = MutableStateFlow<PromoCard?>(null)
    val activeCampaign = _activeCampaign.asStateFlow()

    fun getCardToDisplay() {
        displayedCard?.getCard()?.let { cardToDisplay ->
            viewModelScope.launch {
                _activeCampaign.emit(cardToDisplay)
            }
        }
    }
}
