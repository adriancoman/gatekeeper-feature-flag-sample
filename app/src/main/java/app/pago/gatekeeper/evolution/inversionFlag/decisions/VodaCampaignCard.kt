package app.pago.gatekeeper.evolution.inversionFlag.decisions

import app.pago.gatekeeper.Constants.VODA_IMG
import app.pago.gatekeeper.R

class VodaCampaignCard: BasicCard {
    override fun getCard() = PromoCard(
        text = R.string.voda_title,
        imageUrl = VODA_IMG,
        ctaText = R.string.voda_cta
    )
}